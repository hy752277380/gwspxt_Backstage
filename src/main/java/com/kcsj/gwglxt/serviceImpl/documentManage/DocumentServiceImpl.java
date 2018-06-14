package com.kcsj.gwglxt.serviceImpl.documentManage;

import com.kcsj.gwglxt.entity.*;
import com.kcsj.gwglxt.mapper.*;
import com.kcsj.gwglxt.service.documentManage.DocumentService;
import com.kcsj.gwglxt.util.TeamUtil;
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
        int loaction = document.getDocumentLocation();
        if(loaction==processNodeMapper.getMaxStep(document.getDocumentProcess())){
            System.out.println("流程审核完成。");
        }
        int nextLocation = loaction + 1;
        //利用当前文档所走流程和流程子节点步骤锁定下一个流程节点操作人所在的部门和所需要的职位
        ProcessNode processNode = processNodeMapper.getNextOne(document.getDocumentProcess(),nextLocation);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        //根据职位查出人员
        Guser user = guserMapper.getUserByPosition(processNode.getProcessNodePosition());
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
    }

    @Override
    public List<DocumentCustom> getDocumentByState(Integer documentState) {
        List<DocumentCustom> list = documentMapper.getDocumentByState(documentState);
        return list;
    }

    @Override
    public List<ProcessNode> getAllProcessNode(String processNodeProcess) {
        List<ProcessNode> list = processNodeMapper.getAllProcessNode(processNodeProcess);
        return list;
    }

    @Override
    public List<DocumentCustom> getAllDocument() {
        return documentMapper.getAllDocument();
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
    public int insertMsg(Message message) {
        return messageMapper.insertMsg(message);
    }

    @Override
    public int insertMbj(Mobject mobject) {
        return mobjectMapper.insertMbj(mobject);
    }


}
