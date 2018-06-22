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

import java.lang.Process;
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
    @Autowired
    private DocumenttypeMapper documenttypeMapper;
    @Autowired
    private ProcessMapper processMapper;
    @Autowired
    private PositionMapper positionMapper;

    @Override
    public int insert(Document record) {
        return documentMapper.insert(record);
    }

    @Override
    public int updateDocumentState(Integer documentState, String documentProcessBegin, String documentProcessFinish, String documentId) {
        return documentMapper.updateDocumentState(documentState, documentProcessBegin, documentProcessFinish, documentId);
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
        return documentMapper.updateDocumentLocation(documentLocation, documentId);
    }

    @Override
    public int getDocumentLocation(String documentId) {
        return documentMapper.getDocumentLocation(documentId);
    }

    @Override
    public int updateByPrimaryKey(Document record) {
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
        System.out.println("拿到的文档" + document);
        int location = document.getDocumentLocation();
        if (location == processNodeMapper.getMaxStep(document.getDocumentProcess())) {
            System.out.println("流程审核完成。");
            return 0;
        }else{
            Integer nextLocation = location + 1;
            //利用当前文档所走流程和流程子节点步骤锁定下一个流程节点操作人所在的部门和所需要的职位
            //System.out.println("我是两个参数"+document.getDocumentProcess()+"我他妈是分隔符"+nextLocation);
            ProcessNode processNode = processNodeMapper.getNextOne(document.getDocumentProcess(), nextLocation);
            System.out.println("查出的流程节点" + processNode);
            if (processNode != null) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                //根据职位和部门查出人员
                List<Guser> users = guserMapper.getUserByPosition(processNode.getProcessNodePosition(), processNode.getProcessNodeDepartment());
                System.out.println("查出的用户" + users.get(0));
                //遍历users
                for(Guser guser:users){
                    Message message = new Message();
                    String messageId = TeamUtil.getUuid();
                    message.setMessageId(messageId);
                    message.setMessageContent("您有新的公文待审核，请尽快处理！");
                    message.setMessageTime(df.format(new Date()));
                    message.setMessageIsdelete(0);
                    message.setMessageType(3);
                    Mobject mobject = new Mobject();
                    mobject.setMobjectId(TeamUtil.getUuid());
                    mobject.setMobjectUser(guser.getUserId());
                    mobject.setMobjectMessage(messageId);
                    mobject.setMobjectIsread(0);
                    mobjectMapper.insert(mobject);
                    return messageMapper.insert(message);
                }
            } else {
                return 0;
            }
        }
        return 0;
    }
    //根据文档状态查询
    @Override
    public QueryForPage getDocumentByState(String documentType,Integer documentConfidential,Integer documentState, String documentUser, int currentPage,String searchInfo) {
        List<DocumentCustom> list = documentMapper.getDocumentByState(documentType,documentConfidential,documentState, documentUser,searchInfo);
        QueryForPage queryForPage = new QueryForPage();
        int pagesize = 10;//每页记录数
        int allRow = list.size();//总记录数
        int totalPage = QueryForPage.countTotalPage(pagesize, allRow);//总页数
        int offSet = QueryForPage.countOffset(pagesize, currentPage);//当前页开始记录数
        int currentPages = QueryForPage.countCurrentPage(currentPage);
        int endSet = pagesize * currentPage;
        if (offSet + pagesize - 1 > allRow || offSet + pagesize - 1 == allRow) {
            endSet = allRow;
        }
        List<DocumentCustom> list_thisPage = list.subList(offSet, endSet);
        queryForPage.setList(list_thisPage);
        queryForPage.setAllRow(allRow);
        queryForPage.setCurrentPage(currentPages);
        queryForPage.setPageSize(pagesize);
        queryForPage.setTotalPage(totalPage);
        queryForPage.init();
        return queryForPage;
    }

    @Override
    public List<ProcessNode> getAllProcessNode(String processNodeProcess) {
        List<ProcessNode> list = processNodeMapper.getAllProcessNode(processNodeProcess);
        return list;
    }

    //按阅读权限整理出所有文档
    @Override
    public QueryForPage getAllDocument(String departmentName, String userId, int currentPage, String searchInfo,String documentType,Integer documentConfidential,String documentDept) {
        List<DocumentCustom> list = documentMapper.getAllDocument(searchInfo,documentType,documentConfidential,documentDept);
        Borrowing borrowing;
        for (DocumentCustom documentCustom : list) {
            if (documentCustom.getDepartment().getDepartmentName() != departmentName) {
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
        int totalPage = QueryForPage.countTotalPage(pagesize, allRow);//总页数
        int offSet = QueryForPage.countOffset(pagesize, currentPage);//当前页开始记录数
        int currentPages = QueryForPage.countCurrentPage(currentPage);
        int endSet = pagesize * currentPage;
        if (offSet + pagesize - 1 > allRow || offSet + pagesize - 1 == allRow) {
            endSet = allRow;
        }
        List<DocumentCustom> list_thisPage = list.subList(offSet, endSet);
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

    //查询本人需要审核的文档
    @Override
    public QueryForPage findCheckingDoc(int currentPage,LoginCustom loginCustom) {
        List<ProcessNode> list = processNodeMapper.getProcessNodeByUser(loginCustom.getGuser().getUserDepartment(), loginCustom.getGuser().getUserPosition());
        //定义Documentcustom集合
        List<DocumentCustom> list_doc = new ArrayList<>();
        //遍历该人员所需要任的所有流程子节点
        for (ProcessNode processNode : list) {
            //用每一个processNode里面的流程名和流程位置的前一位查询文档
            //list_doc.add(documentMapper.findCheckingDoc(processNode.getProcessNodeProcess(), processNode.getProcessNodeStep() - 1,loginCustom.getGuser().getUserDepartment()));
            List<DocumentCustom> documentCustoms = documentMapper.findCheckingDoc(processNode.getProcessNodeProcess(), processNode.getProcessNodeStep() - 1,loginCustom.getGuser().getUserDepartment());
            System.out.println("changdu1aaaa"+documentCustoms.size());
            for (DocumentCustom documentCustom:documentCustoms){
                list_doc.add(documentCustom);
            }
            System.out.println("流程是"+processNode.getProcessNodeProcess());
            System.out.println(processNode.getProcessNodeStep() - 1);
            System.out.println(loginCustom.getGuser().getUserDepartment());
            System.out.println(list_doc.size());
        }
        QueryForPage queryForPage = new QueryForPage();
        int pagesize = 10;//每页记录数
        System.out.println("我的長度是"+list_doc.size());
        int allRow = list_doc.size();//总记录数
        int totalPage = QueryForPage.countTotalPage(pagesize, allRow);//总页数
        int offSet = QueryForPage.countOffset(pagesize, currentPage);//当前页开始记录数
        int currentPages = QueryForPage.countCurrentPage(currentPage);
        int endSet = pagesize * currentPage;
        System.out.println(allRow);
        if (offSet + pagesize - 1 > allRow || offSet + pagesize - 1 == allRow) {
            endSet = allRow;
        }
        List<DocumentCustom> list_thisPage = list_doc.subList(offSet, endSet);
        queryForPage.setList(list_thisPage);
        queryForPage.setAllRow(allRow);
        queryForPage.setCurrentPage(currentPages);
        queryForPage.setPageSize(pagesize);
        queryForPage.setTotalPage(totalPage);
        queryForPage.init();
        return queryForPage;
    }
    //申请批阅
    @Override
    public int insertBorrowing(DocumentCustom documentCustom, LoginCustom loginCustom) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        //从documentCustom对象中获得borrowing对象
        Borrowing borrowing = documentCustom.getBorrowing();
        //获取该部门最高权限职称
        List<Position> positions = positionMapper.getDptManager(documentCustom.getDocument().getDocumentDept());
        //获取该职称对应的人
        List<Guser> gusers = guserMapper.getDptManager(documentCustom.getDocument().getDocumentDept(), positions.get(0).getPositionId());
        //添加申请借阅记录
        borrowing.setBorrowingId(TeamUtil.getUuid());
        borrowing.setBorrowingBorrowUser(loginCustom.getGuser().getUserId());
        borrowing.setBorrowingLendUser("");
        borrowing.setBorrowingDocument(documentCustom.getDocument().getDocumentId());
        borrowing.setBorrowingApplicationdate(df.format(new Date()));
        borrowing.setBorrowingState(1);
        borrowing.setBorrowingBegintime("");
        borrowing.setBorrowingOvertime("");
        borrowing.setBorrowingIsdelete(0);
        int result = borrowingMapper.insert(borrowing);
        //添加个人日志
        Log log = new Log();
        log.setLogId(TeamUtil.getUuid());
        log.setLogUser(loginCustom.getGuser().getUserId());
        log.setLogContent("提交了对"+documentCustom.getDocument().getDocumentTitle()+"的阅读申请");
        log.setCreationTime(df.format(new Date()));
        logMapper.insert(log);
        //添加有审核权限人的消息通知
        //遍历
        for(Guser guser:gusers){
            LoginCustom user = guserMapper.getPersonalInfo(loginCustom.getGuser().getUserId());
            Message message = new Message();
            String messageId = TeamUtil.getUuid();
            message.setMessageId(messageId);
            message.setMessageContent(user.getGuser().getUserName()+"申请了对"+documentCustom.getDocument().getDocumentTitle()+"的借阅,请尽快处理。");
            message.setMessageTime(df.format(new Date()));
            message.setMessageIsdelete(0);
            message.setMessageType(1);
            messageMapper.insertMsg(message);
            Mobject mobject = new Mobject();
            mobject.setMobjectId(TeamUtil.getUuid());
            mobject.setMobjectUser(guser.getUserId());
            mobject.setMobjectMessage(messageId);
            mobject.setMobjectIsread(0);
            mobjectMapper.insertMbj(mobject);
        }
        return result;
    }
    //获取需要本人同意的文档借阅申请
    @Override
    public QueryForPage getAllApplyRead(LoginCustom loginCustom,int currentPage) {
        //获得本人所在的部门，查看本部门的文档
        List<DocumentCustom> documentCustoms = documentMapper.getDocumentByDpt(loginCustom.getGuser().getUserDepartment());
        //分页
        QueryForPage queryForPage = new QueryForPage();
        int pagesize = 10;//每页记录数
        System.out.println("我的長度是"+documentCustoms.size());
        int allRow = documentCustoms.size();//总记录数
        int totalPage = QueryForPage.countTotalPage(pagesize, allRow);//总页数
        int offSet = QueryForPage.countOffset(pagesize, currentPage);//当前页开始记录数
        int currentPages = QueryForPage.countCurrentPage(currentPage);
        int endSet = pagesize * currentPage;
        System.out.println(allRow);
        if (offSet + pagesize - 1 > allRow || offSet + pagesize - 1 == allRow) {
            endSet = allRow;
        }
        List<DocumentCustom> list_thisPage = documentCustoms.subList(offSet, endSet);
        queryForPage.setList(list_thisPage);
        queryForPage.setAllRow(allRow);
        queryForPage.setCurrentPage(currentPages);
        queryForPage.setPageSize(pagesize);
        queryForPage.setTotalPage(totalPage);
        queryForPage.init();
        return queryForPage;
    }
    //拒绝文档申请
    @Override
    public void refuseDoc(LoginCustom loginCustom, String documentId) {
        //根据id获取文档信息，目的是得到文档的流程开始时间
        Document document = documentMapper.selectByPrimaryKey(documentId);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String documentProcessBegin;
        String documentProcessFinish = null;
        //判断流程开始时间是否为空，若为空则说明文档在第一个流程子节点被拒绝，则同时更改流程开始和结束时间
        if(document.getDocumentProcessBegin()==null){
            documentProcessBegin = df.format(new Date());
            documentProcessFinish = df.format(new Date());
        }
        else {
            documentProcessBegin = document.getDocumentProcessBegin();
        }
        //将文档状态更改为退回状态
        documentMapper.updateDocumentState(0,documentProcessBegin,documentProcessFinish,documentId);
        //生成审核人日志
        Log log = new Log();
        log.setLogId(TeamUtil.getUuid());
        log.setLogUser(loginCustom.getGuser().getUserId());
        log.setLogContent("拒绝了对"+document.getDocumentTitle()+"的申请");
        log.setCreationTime(df.format(new Date()));
        logMapper.insert(log);
        //生成文档提交人的消息
        Message message = new Message();
        String messageId = TeamUtil.getUuid();
        message.setMessageId(messageId);
        message.setMessageContent(loginCustom.getGuser().getUserName()+"拒绝了对你的"+document.getDocumentTitle()+"的申请");
        message.setMessageTime(df.format(new Date()));
        message.setMessageIsdelete(0);
        message.setMessageType(3);
        messageMapper.insertMsg(message);
        Mobject mobject = new Mobject();
        mobject.setMobjectId(TeamUtil.getUuid());
        mobject.setMobjectUser(document.getDocumentUser());
        mobject.setMobjectMessage(messageId);
        mobject.setMobjectIsread(0);
        mobjectMapper.insertMbj(mobject);
    }
    //同意借阅申请
    @Override
    public int acceptApply(DocumentCustom documentCustom, LoginCustom loginCustom) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        //首先改变该文档及改人的借阅记录的借阅状态
        //获取该条documentCustom记录的borrowing的id
        String borrowingId = documentCustom.getBorrowing().getBorrowingId();
        //根据主键查询原借阅记录
        Borrowing borrowing = borrowingMapper.selectByPrimaryKey(borrowingId);
        if(borrowing.getBorrowingState()==1){
            //更新部分属性
            borrowing.setBorrowingLendUser(loginCustom.getGuser().getUserId());
            borrowing.setBorrowingBegintime(df.format(new Date()));
            borrowing.setBorrowingState(2);
            //根据主键更改借阅表的状态及借出时间
            int result = borrowingMapper.updateByPrimaryKey(borrowing);
            //添加批准人日志
            Log log = new Log();
            log.setLogId(TeamUtil.getUuid());
            log.setLogUser(loginCustom.getGuser().getUserId());
            //根据借阅表中的借入用户id查询其姓名
            Guser guser = guserMapper.selectByPrimaryKey(borrowing.getBorrowingBorrowUser());
            log.setLogContent("同意了"+guser.getUserName()+"对"+documentCustom.getDocument().getDocumentTitle()+"的借阅申请。");
            log.setCreationTime(df.format(new Date()));
            logMapper.insert(log);
            //添加申请人的消息通知
            Message message = new Message();
            String messageId = TeamUtil.getUuid();
            message.setMessageId(messageId);
            message.setMessageContent("您申请批阅的"+documentCustom.getDocument().getDocumentTitle()+"已被同意。");
            message.setMessageTime(df.format(new Date()));
            message.setMessageIsdelete(0);
            message.setMessageType(1);
            messageMapper.insertMsg(message);
            Mobject mobject = new Mobject();
            mobject.setMobjectId(TeamUtil.getUuid());
            mobject.setMobjectUser(borrowing.getBorrowingBorrowUser());
            mobject.setMobjectMessage(messageId);
            mobject.setMobjectIsread(0);
            mobjectMapper.insertMbj(mobject);
            return result;
        }else {
            return 0;
        }

    }
    //拒绝批阅申请
    @Override
    public int refuseApply(DocumentCustom documentCustom, LoginCustom loginCustom) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        //首先改变该文档及改人的借阅记录的借阅状态
        //获取该条documentCustom记录的borrowing的id
        String borrowingId = documentCustom.getBorrowing().getBorrowingId();
        //根据主键查询原借阅记录
        Borrowing borrowing = borrowingMapper.selectByPrimaryKey(borrowingId);
        if(borrowing.getBorrowingState()==1){
            //更新部分属性
            borrowing.setBorrowingState(4);
            //根据主键更改借阅表的状态及借出时间
            int result = borrowingMapper.updateByPrimaryKey(borrowing);
            //添加批准人日志
            Log log = new Log();
            log.setLogId(TeamUtil.getUuid());
            log.setLogUser(loginCustom.getGuser().getUserId());
            //根据借阅表中的借入用户id查询其姓名
            Guser guser = guserMapper.selectByPrimaryKey(borrowing.getBorrowingBorrowUser());
            log.setLogContent("拒绝了"+guser.getUserName()+"对"+documentCustom.getDocument().getDocumentTitle()+"的借阅申请。");
            log.setCreationTime(df.format(new Date()));
            logMapper.insert(log);
            //添加申请人的消息通知
            Message message = new Message();
            String messageId = TeamUtil.getUuid();
            message.setMessageId(messageId);
            message.setMessageContent("您申请批阅的"+documentCustom.getDocument().getDocumentTitle()+"已被拒绝。");
            message.setMessageTime(df.format(new Date()));
            message.setMessageIsdelete(0);
            message.setMessageType(1);
            messageMapper.insertMsg(message);
            Mobject mobject = new Mobject();
            mobject.setMobjectId(TeamUtil.getUuid());
            mobject.setMobjectUser(borrowing.getBorrowingBorrowUser());
            mobject.setMobjectMessage(messageId);
            mobject.setMobjectIsread(0);
            mobjectMapper.insertMbj(mobject);
            return result;
        }else {
            return 0;
        }

    }

    //根据流程id流程子节点
    @Override
    public List<ProcessNode> getProcessNodeByPro(String process) {
        return processNodeMapper.getProcessNodeByPro(process);
    }

    @Override
    public int insertMsg(Message message) {
        return messageMapper.insertMsg(message);
    }

    @Override
    public int insertMbj(Mobject mobject) {
        return mobjectMapper.insertMbj(mobject);
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
    public List<Documenttype> getAllDocType() {
        return documenttypeMapper.getAllDocType();
    }

    @Override
    public QueryForPage getAllProcess(int currentPage) {
        List<com.kcsj.gwglxt.entity.Process> processes = processMapper.getAllProcess();
        QueryForPage queryForPage = new QueryForPage();
        int pagesize = 10;//每页记录数
        System.out.println("我的長度是"+processes.size());
        int allRow = processes.size();//总记录数
        int totalPage = QueryForPage.countTotalPage(pagesize, allRow);//总页数
        int offSet = QueryForPage.countOffset(pagesize, currentPage);//当前页开始记录数
        int currentPages = QueryForPage.countCurrentPage(currentPage);
        int endSet = pagesize * currentPage;
        System.out.println(allRow);
        if (offSet + pagesize - 1 > allRow || offSet + pagesize - 1 == allRow) {
            endSet = allRow;
        }
        List<com.kcsj.gwglxt.entity.Process> list_thisPage = processes.subList(offSet, endSet);
        queryForPage.setList(list_thisPage);
        queryForPage.setAllRow(allRow);
        queryForPage.setCurrentPage(currentPages);
        queryForPage.setPageSize(pagesize);
        queryForPage.setTotalPage(totalPage);
        queryForPage.init();
        return queryForPage;
    }
    //获取本人未读消息
    @Override
    public List<MessageCustom> getUnReadMsg(String userId) {
        return mobjectMapper.getUnReadMsg(userId);
    }

    @Override
    public int isRead(String mobjectId) {
        Mobject mobject = new Mobject();
        mobject.setMobjectId(mobjectId);
        mobject.setMobjectIsread(1);
        return mobjectMapper.updateByPrimaryKeySelective(mobject);
    }

}
