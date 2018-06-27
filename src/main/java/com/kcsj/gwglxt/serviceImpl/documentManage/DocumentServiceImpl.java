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
import org.springframework.web.bind.annotation.RequestBody;


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
        int location = document.getDocumentLocation();
        if (location == processNodeMapper.getMaxStep(document.getDocumentProcess())) {
            return 0;
        }else{
            Integer nextLocation = location + 1;
            //利用当前文档所走流程和流程子节点步骤锁定下一个流程节点操作人所在的部门和所需要的职位
            ProcessNode processNode = processNodeMapper.getNextOne(document.getDocumentProcess(), nextLocation);
            if (processNode != null) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                //根据职位和部门查出人员
                List<Guser> users = guserMapper.getUserByPosition(processNode.getProcessNodePosition(), processNode.getProcessNodeDepartment());
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
    public QueryForPage getDocumentByState(String documentType,Integer documentConfidential,Integer documentState, String documentUser, int currentPage,String fuzzySearch) {
        List<DocumentCustom> list = documentMapper.getDocumentByState(documentType,documentConfidential,documentState, documentUser,fuzzySearch);
        QueryForPage queryForPage = new QueryForPage();
        int pagesize = 10;//每页记录数
        int allRow = list.size();//总记录数
        int totalPage = QueryForPage.countTotalPage(pagesize, allRow);//总页数
        int offSet = QueryForPage.countOffset(pagesize, currentPage);//当前页开始记录数
        int currentPages = QueryForPage.countCurrentPage(currentPage);
        int endSet = pagesize * currentPage;
        if (offSet + pagesize - 1 >= allRow) {
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
    public QueryForPage getAllDocument(String departmentName, String userId, int currentPage, String fuzzySearch,String documentType,Integer documentConfidential,String documentDept) {
        List<DocumentCustom> list = documentMapper.getAllDocument(documentType,documentConfidential,documentDept,fuzzySearch);
        for (DocumentCustom documentCustom : list) {
            if (documentCustom.getDepartment().getDepartmentName() != departmentName) {
                List<Borrowing> borrowing = borrowingMapper.borrowingState(documentCustom.getDocument().getDocumentId(), userId);
                if (borrowing.size()!=0){
                    documentCustom.setBorrowing(borrowing.get(0));
                }else {
                    System.out.println("无借阅记录");
                }
            }
        }
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
    public DocumentCustom documentBaseInfo(String documentId) {
        return documentMapper.documentBaseInfo(documentId);
    }

    //查询本人需要审核的文档
    @Override
    public QueryForPage findCheckingDoc(int currentPage,LoginCustom loginCustom, String fuzzySearch,String documentType,Integer documentConfidential) {
        List<ProcessNode> list = processNodeMapper.getProcessNodeByUser(loginCustom.getGuser().getUserDepartment(), loginCustom.getGuser().getUserPosition());
        //定义Documentcustom集合
        List<DocumentCustom> list_doc = new ArrayList<>();
        //遍历该人员所需要任的所有流程子节点
        for (ProcessNode processNode : list) {
            //用每一个processNode里面的流程名和流程位置的前一位查询文档
            List<DocumentCustom> documentCustoms = documentMapper.findCheckingDoc(documentType,documentConfidential,processNode.getProcessNodeProcess(), processNode.getProcessNodeStep() - 1,fuzzySearch);
            for (DocumentCustom documentCustom:documentCustoms){
                list_doc.add(documentCustom);
            }
        }
        QueryForPage queryForPage = new QueryForPage();
        int pagesize = 10;//每页记录数
        int allRow = list_doc.size();//总记录数
        int totalPage = QueryForPage.countTotalPage(pagesize, allRow);//总页数
        int offSet = QueryForPage.countOffset(pagesize, currentPage);//当前页开始记录数
        int currentPages = QueryForPage.countCurrentPage(currentPage);
        int endSet = pagesize * currentPage;
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
    public DocumentCustom insertBorrowing(@RequestBody DocumentCustom documentCustom, LoginCustom loginCustom) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //从documentCustom对象中获得borrowing对象
        Borrowing borrowing = documentCustom.getBorrowing();
        //获取该部门最高权限职称
        List<Position> positions = positionMapper.getDptManager(documentCustom.getDocument().getDocumentDept());
        //获取该职称对应的人
        //List<Guser> gusers = guserMapper.getDptManager(documentCustom.getDocument().getDocumentDept(), positions.get(0).getPositionId());
        List<Guser> gusers = new ArrayList<>();
        //遍历所有职位
        for(Position position:positions){
            gusers.addAll(guserMapper.getDptManager(documentCustom.getDocument().getDocumentDept(), position.getPositionId()));
        }
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
        documentCustom.setBorrowing(borrowing);
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
        return documentCustom;
    }
    //获取需要本人同意的文档借阅申请
    @Override
    public QueryForPage getAllApplyRead(LoginCustom loginCustom,int currentPage,String documentType,Integer documentConfidential,String fuzzySearch) {
        //获得本人所在的部门，查看本部门的文档
        List<DocumentCustom> documentCustoms = documentMapper.getDocumentByDpt(documentType,documentConfidential,loginCustom.getGuser().getUserDepartment(),fuzzySearch);
        //分页
        QueryForPage queryForPage = new QueryForPage();
        int pagesize = 10;//每页记录数
        int allRow = documentCustoms.size();//总记录数
        int totalPage = QueryForPage.countTotalPage(pagesize, allRow);//总页数
        int offSet = QueryForPage.countOffset(pagesize, currentPage);//当前页开始记录数
        int currentPages = QueryForPage.countCurrentPage(currentPage);
        int endSet = pagesize * currentPage;
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
    public int refuseDoc(LoginCustom loginCustom, String documentId,String refuseReason) {
        //根据id获取文档信息，目的是得到文档的流程开始时间
        Document document = documentMapper.selectByPrimaryKey(documentId);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
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
        int result = documentMapper.updateDocumentState(1,documentProcessBegin,documentProcessFinish,documentId);
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
        message.setMessageContent(loginCustom.getGuser().getUserName()+"拒绝了对你的"+document.getDocumentTitle()+"的申请,拒绝理由："+refuseReason+"。");
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
        return result;
    }
    //同意借阅申请
    @Override
    public int acceptApply(DocumentCustom documentCustom, LoginCustom loginCustom) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
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
    public int refuseApply(DocumentCustom documentCustom, LoginCustom loginCustom,String refuseReason) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
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
            message.setMessageContent("您申请批阅的"+documentCustom.getDocument().getDocumentTitle()+"已被拒绝，拒绝理由："+refuseReason+"。");
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
    public QueryForPage getMyAllMessage(String userId,int currentPage) {
        QueryForPage queryForPage = new QueryForPage();
        int pagesize = 10;//每页记录数
        List<MessageCustom> messageCustoms = mobjectMapper.getMyAllMessage(userId,0,0);
        int allRow = messageCustoms.size();//总记录数
        int totalPage = QueryForPage.countTotalPage(pagesize, allRow);//总页数
        int offSet = QueryForPage.countOffset(pagesize, currentPage);//当前页开始记录数
        int currentPages = QueryForPage.countCurrentPage(currentPage);
        int endSet = pagesize * currentPage;
        if (offSet + pagesize - 1 > allRow || offSet + pagesize - 1 == allRow) {
            endSet = allRow;
        }
        List<MessageCustom> list_thisPage = mobjectMapper.getMyAllMessage(userId,offSet, endSet);
        queryForPage.setList(list_thisPage);
        queryForPage.setAllRow(allRow);
        queryForPage.setCurrentPage(currentPages);
        queryForPage.setPageSize(pagesize);
        queryForPage.setTotalPage(totalPage);
        queryForPage.init();
        return queryForPage;
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
        int allRow = processes.size();//总记录数
        int totalPage = QueryForPage.countTotalPage(pagesize, allRow);//总页数
        int offSet = QueryForPage.countOffset(pagesize, currentPage);//当前页开始记录数
        int currentPages = QueryForPage.countCurrentPage(currentPage);
        int endSet = pagesize * currentPage;
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

    @Override
    public List<com.kcsj.gwglxt.entity.Process> getAllProcessNoPage() {
        return processMapper.getAllProcess();
    }

    @Override
    public List<List<Log>> getLog(int year, String userId) {
        List<List<Log>> list = new ArrayList<>();
        //从一月开始循环查询
        for(int mouth=1;mouth<=12;mouth++){
            List<Log> logs = logMapper.getLogByUser(year,userId,mouth);
            list.add(logs);
        }
        return list;
    }

    @Override
    public int allAreRead(String userId) {
        return mobjectMapper.allAreRead(userId);
    }
    //删除文档
    @Override
    public int deleteDoc(String[] ids, LoginCustom loginCustom) {
        int result = 0;
        if (ids.length==0){
            return 0;
        }else{
            //遍历id删除
            for (String documentId:ids){
                Document document = new Document();
                document.setDocumentId(documentId);
                document.setDocumentIsdelete(1);
                int deleteResult = documentMapper.updateByPrimaryKeySelective(document);
                result = result + deleteResult;
            }
        }
        //插入日志
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //添加操作日志
        Log log = new Log();
        log.setLogId(TeamUtil.getUuid());
        log.setCreationTime(df.format(new Date()));
        log.setLogUser(loginCustom.getGuser().getUserId());
        //根据职位id获取职位名称
        log.setLogContent("删除了"+result+"篇草稿文档。");
        logMapper.insert(log);
        return result;
    }

}
