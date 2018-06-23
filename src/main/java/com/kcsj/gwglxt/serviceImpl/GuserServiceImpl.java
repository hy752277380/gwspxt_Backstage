package com.kcsj.gwglxt.serviceImpl;

import com.kcsj.gwglxt.DTO.CountByMouth;
import com.kcsj.gwglxt.DTO.DocumentCustom;
import com.kcsj.gwglxt.entity.Guser;
import com.kcsj.gwglxt.entity.GuserExample;
import com.kcsj.gwglxt.DTO.LoginCustom;
import com.kcsj.gwglxt.entity.Log;
import com.kcsj.gwglxt.entity.Position;
import com.kcsj.gwglxt.mapper.DocumentMapper;
import com.kcsj.gwglxt.mapper.GuserMapper;
import com.kcsj.gwglxt.mapper.LogMapper;
import com.kcsj.gwglxt.mapper.PositionMapper;
import com.kcsj.gwglxt.service.GuserService;
import com.kcsj.gwglxt.util.TeamUtil;
import com.kcsj.gwglxt.util.md5;
import com.kcsj.gwglxt.vo.QueryForPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class GuserServiceImpl implements GuserService {

    @Autowired
    private GuserMapper guserMapper;
    @Autowired
    private DocumentMapper documentMapper;
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private LogMapper logMapper;
    @Override
    public int countByExample(GuserExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(GuserExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String userId) {
        return 0;
    }
    //插入用户信息
    @Override
    public int insert(Guser record) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        record.setUserId(TeamUtil.getUuid());
        record.setCreationTime(df.format(new Date()));
        record.setUserIsdelete(0);
        return guserMapper.insert(record);
    }

    @Override
    public int insertSelective(Guser record) {
        return 0;
    }

    @Override
    public List<Guser> selectByExample(GuserExample example) {
        return null;
    }

    @Override
    public Guser selectByPrimaryKey(String userId) {
        return guserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByExampleSelective(Guser record, GuserExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Guser record, GuserExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Guser record) {
        return guserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Guser record) {
        return guserMapper.updateByPrimaryKey(record);
    }

    @Override
    public LoginCustom loginInfo(String userId) {
        return guserMapper.loginInfo(userId);
    }

    @Override
    public LoginCustom loginFunction(String userAccount) {

        LoginCustom ll = guserMapper.loginFunction(userAccount);
        System.out.println(userAccount);
        System.out.println(ll);
        return ll;
}

    @Override
    public LoginCustom getPersonalInfo(String userId) {
        return guserMapper.getPersonalInfo(userId);
    }
    //首页月份人数统计
    @Override
    public CountByMouth countUserByMouth() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        System.out.println(guserMapper.countUserByMouth(df.format(new Date())));
        return guserMapper.countUserByMouth(df.format(new Date()));
    }
    //计算总人数
    @Override
    public int countAllUser() {
        return guserMapper.countAllUser();
    }
    //计算总文档数
    @Override
    public int countAllDocument(String department,String user) {
        return documentMapper.countAllDocument(department,user);
    }
    //公司文档月份统计
    @Override
    public CountByMouth countDocumentByMouth() {
        String department = null;
        String userId = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        System.out.println(guserMapper.countUserByMouth(df.format(new Date())));
        return documentMapper.countDocumentByMouth(df.format(new Date()),department,userId);
    }

    @Override
    public CountByMouth countDptDocumentByMouth(String department) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        System.out.println(guserMapper.countUserByMouth(df.format(new Date())));
        String userId = null;
        return documentMapper.countDocumentByMouth(df.format(new Date()),department,userId);
    }

    @Override
    public CountByMouth countPersonalDocumentByMouth(String userId) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        System.out.println(guserMapper.countUserByMouth(df.format(new Date())));
        String department = null;
        return documentMapper.countDocumentByMouth(df.format(new Date()),department,userId);
    }

    @Override
    public QueryForPage getAllUser(int currentPage) {
        List<LoginCustom>  users = guserMapper.getAllUser();
        QueryForPage queryForPage = new QueryForPage();
        int pagesize = 10;//每页记录数
        int allRow = users.size();//总记录数
        int totalPage = QueryForPage.countTotalPage(pagesize, allRow);//总页数
        int offSet = QueryForPage.countOffset(pagesize, currentPage);//当前页开始记录数
        int currentPages = QueryForPage.countCurrentPage(currentPage);
        int endSet = pagesize * currentPage;
        if (offSet + pagesize - 1 > allRow || offSet + pagesize - 1 == allRow) {
            endSet = allRow;
        }
        List<LoginCustom> list_thisPage = users.subList(offSet, endSet);
        queryForPage.setList(list_thisPage);
        queryForPage.setAllRow(allRow);
        queryForPage.setCurrentPage(currentPages);
        queryForPage.setPageSize(pagesize);
        queryForPage.setTotalPage(totalPage);
        queryForPage.init();
        return queryForPage;
    }

    @Override
    public List<Position> getPositionByDpt(String department) {
        return positionMapper.getPositionByDpt(department);
    }
    //重置密码
    @Override
    public int resetPassword(String userId) {
        String password = md5.GetMD5Code("111111");
        Guser guser = new Guser();
        guser.setUserId(userId);
        guser.setUserPassword(password);
        return guserMapper.updateByPrimaryKey(guser);
    }
    //批量删除
    @Override
    public int batchDelete(String[] userIds) {
        int result = 0;
        if (userIds==null&&"".equals(userIds)){
            return 0;
        }else{
            //遍历id删除
            for (String userId:userIds){
                Guser guser = new Guser();
                guser.setUserId(userId);
                guser.setUserIsdelete(1);
                int deleteResult = guserMapper.updateByPrimaryKeySelective(guser);
                result = result + deleteResult;
            }
            return result;
        }
    }

    @Override
    public QueryForPage getUserByDpt(String userDepartment,int currentPage) {
        List<LoginCustom> loginCustoms = guserMapper.getUserByDpt(userDepartment);
        QueryForPage queryForPage = new QueryForPage();
        int pagesize = 10;//每页记录数
        int allRow = loginCustoms.size();//总记录数
        int totalPage = QueryForPage.countTotalPage(pagesize, allRow);//总页数
        int offSet = QueryForPage.countOffset(pagesize, currentPage);//当前页开始记录数
        int currentPages = QueryForPage.countCurrentPage(currentPage);
        int endSet = pagesize * currentPage;
        if (offSet + pagesize - 1 > allRow || offSet + pagesize - 1 == allRow) {
            endSet = allRow;
        }
        List<LoginCustom> list_thisPage = loginCustoms.subList(offSet, endSet);
        queryForPage.setList(list_thisPage);
        queryForPage.setAllRow(allRow);
        queryForPage.setCurrentPage(currentPages);
        queryForPage.setPageSize(pagesize);
        queryForPage.setTotalPage(totalPage);
        queryForPage.init();
        return queryForPage;
    }
}
