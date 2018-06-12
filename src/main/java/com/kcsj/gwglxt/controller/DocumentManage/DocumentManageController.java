package com.kcsj.gwglxt.controller.DocumentManage;

import com.kcsj.gwglxt.entity.Document;
import com.kcsj.gwglxt.entity.Guser;
import com.kcsj.gwglxt.entity.Log;
import com.kcsj.gwglxt.entity.LoginCustom;
import com.kcsj.gwglxt.service.documentManage.DocumentService;
import com.kcsj.gwglxt.util.TeamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class DocumentManageController {
    @Autowired
    private DocumentService documentService;

    //添加文档
    @RequestMapping("/addDocument")
    public String addDocument(Document doc, HttpSession httpSession, HttpServletResponse response){
        //获取session内容
        LoginCustom loginCustom = (LoginCustom)httpSession.getAttribute("loginerInfo");
        //初始化resul
        String result =null;
        //从对象中获得文档标题
        String documentName = doc.getDocumentTitle();
        //将部分属性存入doc对象中
        doc.setDocumentId(TeamUtil.getUuid());
        doc.setDocumentDept(loginCustom.getGuser().getUserDepartment());
        doc.setDocumentUser(loginCustom.getGuser().getUserId());
        doc.setDocumentConfidential(1);
        doc.setDoucmentContent("  ");
        doc.setDocumentRemark("  ");
        doc.setDocumentProcess("1");
        doc.setDocumentLocation(0);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        doc.setCreationTime(df.format(new Date()));
        doc.setDocumentState(1);
        doc.setDocumentIsdelete(0);
        //将对象存入数据库
        int addResult = documentService.insert(doc);
        Log log = new Log();
        //存入日志信息到日志表
        log.setLogId(TeamUtil.getUuid());
        log.setLogUser(loginCustom.getGuser().getUserId());
        log.setLogContent("添加了"+documentName+"文档");
        log.setCreationTime(df.format(new Date()));
        int addLogResult = documentService.insertLog(log);
        //判断执行文档添加操作返回的结果，返回结果为数据库中受影响行数
        if (addResult==0){
            result = "updateFailed";
        }result = "updateSuccess";
        return "{\"msg\":\""+result+"\"}";
    }

    //更改文档状态
    @RequestMapping("/updateDocumentState")
    public String updateDocumentState(Integer documentState, String documentId,HttpSession httpSession, HttpServletResponse response){
        //初始化result
        String result =null;
        //获取session中的信息
        LoginCustom loginCustom = (LoginCustom)httpSession.getAttribute("loginerInfo");
        //根据文档id修改文档状态
        int updateResult = documentService.updateDocumentState(documentState,documentId);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        Log log = new Log();
        String text = null;
        //根据得到的文档id获得文档信息拼接入日志信息中
        Document document = documentService.selectByPrimaryKey(documentId);
        //根据不同的文档状态定义不同的日志信息
        if(documentState==2){
            text = "提交了"+document.getDocumentTitle()+"文档";
            log.setLogId(TeamUtil.getUuid());
            log.setLogUser(loginCustom.getGuser().getUserId());
            log.setLogContent(text);
            log.setCreationTime(df.format(new Date()));
            int addLogResult = documentService.insertLog(log);
        }else if (documentState==3&&documentState==4){
            text="审核了"+document.getDocumentTitle()+"文档";
            log.setLogId(TeamUtil.getUuid());
            log.setLogUser(loginCustom.getGuser().getUserId());
            log.setLogContent(text);
            log.setCreationTime(df.format(new Date()));
            documentService.insertLog(log);
            //在被审核的用户工作日志里生成日志
            Log logOfObject = new Log();
            logOfObject.setLogId(TeamUtil.getUuid());
            logOfObject.setLogUser(document.getDocumentUser());
            logOfObject.setLogContent("您的"+document.getDocumentTitle()+"被"+loginCustom.getGuser().getUserName()+"审核了");
            logOfObject.setCreationTime(df.format(new Date()));
            documentService.insertLog(logOfObject);
        }
        //判断执行文档添加操作返回的结果，返回结果为数据库中受影响行数
        if (updateResult==0){
            result = "updateFailed";
        }result = "updateSuccess";
        return "{\"msg\":\""+result+"\"}";
    }
    //更改文档当前所处流程的位置
    @RequestMapping("/updateDocumentLocation")
    public String updateDocumentLocation(String documentId,HttpSession httpSession, HttpServletResponse response){
        //初始化result
        String result =null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        //获取session内容
        LoginCustom loginCustom = (LoginCustom)httpSession.getAttribute("loginerInfo");
        Document document = documentService.selectByPrimaryKey(documentId);
        int documentLocation = document.getDocumentLocation() + 1;
        int updateLocationResult = documentService.updateDocumentLocation(documentLocation,documentId);
        //生成审核人日志文件
        Log log = new Log();
        log.setLogId(TeamUtil.getUuid());
        log.setLogUser(loginCustom.getGuser().getUserId());
        log.setLogContent("审核了"+document.getDocumentTitle()+"公文");
        log.setCreationTime(df.format(new Date()));
        documentService.insertLog(log);
        //生成被审核人的日志文件
        Log log1 = new Log();
        log1.setLogId(TeamUtil.getUuid());
        log1.setLogUser(document.getDocumentUser());
        log1.setLogContent("您的"+document.getDocumentTitle()+"被"+loginCustom.getGuser().getUserName()+"审核了");
        log1.setCreationTime(df.format(new Date()));
        documentService.insertLog(log1);
        //判断执行文档添加操作返回的结果，返回结果为数据库中受影响行数
        if (updateLocationResult==0){
            result = "updateFailed";
        }result = "updateSuccess";
        return "{\"msg\":\""+result+"\"}";
    }
}
