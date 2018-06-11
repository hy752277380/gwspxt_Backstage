package com.kcsj.gwglxt.controller.DocumentManage;

import com.kcsj.gwglxt.entity.Document;
import com.kcsj.gwglxt.entity.Guser;
import com.kcsj.gwglxt.entity.LoginCustom;
import com.kcsj.gwglxt.service.documentManage.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void addDocument(Document doc, HttpSession httpSession, HttpServletResponse response){
        LoginCustom loginCustom = (LoginCustom)httpSession.getAttribute("loginerInfo");
        doc.setDocumentDept(loginCustom.getGuser().getUserDepartment());
        doc.setDocumentUser(loginCustom.getGuser().getUserId());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        doc.setCreationTime(df.format(new Date()));
        doc.setDocumentState(1);
        int result = documentService.insert(doc);

    }

}
