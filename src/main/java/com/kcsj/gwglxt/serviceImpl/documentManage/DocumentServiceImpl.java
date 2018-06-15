package com.kcsj.gwglxt.serviceImpl.documentManage;

import com.kcsj.gwglxt.DTO.DocumentCustom;
import com.kcsj.gwglxt.DTO.LoginCustom;
import com.kcsj.gwglxt.DTO.MessageCustom;
import com.kcsj.gwglxt.entity.*;
import com.kcsj.gwglxt.mapper.*;
import com.kcsj.gwglxt.service.documentManage.DocumentService;
import com.kcsj.gwglxt.util.TeamUtil;
import com.kcsj.gwglxt.vo.QueryForPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentMapper documentMapper;
    @Autowired
    private LogMapper logMapper;
    @Autowired
    private ProcessNodeMapper processNodeMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private GuserMapper guserMapper;
    @Autowired
    private MobjectMapper mobjectMapper;
    @Autowired
    private BorrowingMapper borrowingMapper;

    @Override
    public int insert(Document record) {
        return documentMapper.insert(record);
    }

    @Override
    public int updateDocumentState(Integer documentState,String documentProcessBegin,String documentProcessFinish, String documentId) {
        return documentMapper.updateDocumentState(documentState,documentProcessBegin,documentProcessFinish,documentId);
    }

    @Override
    public int insertLog(Log log) {
        return logMapper.insert(log);
    }

    @Override
    public String getDocumentName(String documentId) {
        return documentMapper.getDocumentName(documentId);
    }

    @Override
    public Document selectByPrimaryKey(String documentId) {
        return documentMapper.selectByPrimaryKey(documentId);
    }

    @Override
    public int updateDocumentLocation(Integer documentLocation, String documentId) {
        return documentMapper.updateDocumentLocation(documentLocation,documentId);
    }

    @Override
    public int getDocumentLocation(String documentId) {
        return documentMapper.getDocumentLocation(documentId);
    }

    @Override
    public int updateByPrimaryKey(Document record) {
        String documentId = record.getDocumentId();
        Document documentOld = documentMapper.selectByPrimaryKey(documentId);
        documentOld.setDocumentType(record.getDocumentType());
        documentOld.setDocumentConfidential(record.getDocumentConfidential());
        documentOld.setDocumentSpeed(record.getDocumentSpeed());
        documentOld.setDocumentProcess(record.getDocumentProcess());
        return documentMapper.updateByPrimaryKey(record);
    }

    @Override
    public int getMaxStep(String processNodeProcess) {
        return processNodeMapper.getMaxStep(processNodeProcess);
    }
    //生成信息
    @Override
    public int insertMessage(String documentId) {
        //根据id查询文档
        Document document = documentMapper.selectByPrimaryKey(documentId);
        System.out.println("拿到的文档"+document);
        int location = document.getDocumentLocation();
        if(location==processNodeMapper.getMaxStep(document.getDocumentProcess())){
            System.out.println("流程审核完成。");
        }
        Integer nextLocation = location + 1;
        //利用当前文档所走流程和流程子节点步骤锁定下一个流程节点操作人所在的部门和所需要的职位
        //System.out.println("我是两个参数"+document.getDocumentProcess()+"我他妈是分隔符"+nextLocation);
        ProcessNode processNode = processNodeMapper.getNextOne(document.getDocumentProcess(),nextLocation);
        System.out.println("查出的流程节点"+processNode);
        if(processNode!=null){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            //根据职位和部门查出人员
            Guser user = guserMapper.getUserByPosition(processNode.getProcessNodePosition(),processNode.getProcessNodeDepartment());
            System.out.println("查出的用户"+user);
            Message message = new Message();
            String messageId = TeamUtil.getUuid();
            message.setMessageId(messageId);
            message.setMessageContent("您有新的公文待审核，请尽快处理！");
            message.setMessageTime(df.format(new Date()));
            message.setMessageIsdelete(0);
            message.setMessageType(3);
            Mobject mobject = new Mobject();
            mobject.setMobjectId(TeamUtil.getUuid());
            mobject.setMobjectUser(user.getUserId());
            mobject.setMobjectMessage(messageId);
            mobject.setMobjectIsread(0);
            mobjectMapper.insert(mobject);
            return messageMapper.insert(message);
        }else {
            return 0;
        }
    }

    @Override
    public List<DocumentCustom> getDocumentByState(Integer documentState,String documentUser) {
        List<DocumentCustom> list = documentMapper.getDocumentByState(documentState,documentUser);
        return list;
    }

    @Override
    public List<ProcessNode> getAllProcessNode(String processNodeProcess) {
        List<ProcessNode> list = processNodeMapper.getAllProcessNode(processNodeProcess);
        return list;
    }
    //按阅读权限整理出所有文档
    @Override
    public QueryForPage getAllDocument(String departmentName, String userId,int currentPage,String searchInfo) {
        List<DocumentCustom> list = documentMapper.getAllDocument(searchInfo);
        Borrowing borrowing;
        for (DocumentCustom documentCustom:list){
            if (documentCustom.getDepartment().getDepartmentName()!=departmentName) {
                borrowing = borrowingMapper.borrowingState(documentCustom.getDocument().getDocumentId(), userId);
                documentCustom.setBorrowing(borrowing);
            }
        }
        QueryForPage queryForPage = new QueryForPage();
        /*//设置总记录数
        queryForPage1.setAllRow(list.size());
        //获取当前页
        queryForPage1.setCurrentPage(queryForPage.getCurrentPage());
        //设置每页数据为十条
        queryForPage.setPageSize(10);
        queryForPage1.setList(list.subList(QueryForPage.countOffset(10,list.size()),10));*/
        int pagesize = 10;//每页记录数
        int allRow = list.size();//总记录数
        int totalPage = QueryForPage.countTotalPage(pagesize,allRow);//总页数
        int offSet = QueryForPage.countOffset(pagesize,currentPage);//当前页开始记录数
        int currentPages = QueryForPage.countCurrentPage(currentPage);
        List<DocumentCustom> list_thisPage = list.subList(offSet,pagesize);
        queryForPage.setList(list_thisPage);
        queryForPage.setAllRow(allRow);
        queryForPage.setCurrentPage(currentPages);
        queryForPage.setPageSize(pagesize);
        queryForPage.setTotalPage(totalPage);
        queryForPage.init();
        return queryForPage;
    }

    @Override
    public DocumentCustom documentBaseInfo(String documentId) {
        return documentMapper.documentBaseInfo(documentId);
    }

    @Override
    public List<DocumentCustom> findCheckingDoc(LoginCustom loginCustom) {
        List<ProcessNode> list = processNodeMapper.getProcessNodeByUser(loginCustom.getGuser().getUserDepartment(),loginCustom.getGuser().getUserPosition());
        //定义Documentcustom集合
        List< DocumentCustom> list_doc = new ArrayList<>();
        //遍历该人员所需要任的所有流程子节点
        for (ProcessNode processNode : list){
            //用每一个processNode里面的流程名和流程位置的前一位查询文档
            list_doc.add(documentMapper.findCheckingDoc(processNode.getProcessNodeProcess(),processNode.getProcessNodeStep()-1));
        }
        return list_doc;
    }

    @Override
    public List<MessageCustom> getMyAllMessage(String userId) {
        return mobjectMapper.getMyAllMessage(userId);
    }

    @Override
    public List<Log> getAllLog(String userId) {
        return logMapper.getAllLog(userId);
    }

    @Override
    public int insertMsg(Message message) {
        return messageMapper.insertMsg(message);
    }

    @Override
    public int insertMbj(Mobject mobject) {
        return mobjectMapper.insertMbj(mobject);
    }


}
