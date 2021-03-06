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
import java.util.Random;

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
    public int insertUser(Guser record,LoginCustom loginCustom) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Random random = new Random();
        int num = random.nextInt(10);
        record.setUserId(TeamUtil.getUuid());
        record.setUserPassword(md5.GetMD5Code("111111"));
        record.setCreationTime(df.format(new Date()));
        record.setUserIsdelete(0);
        record.setUserPicture(num+1+".gif");
        int result = guserMapper.insert(record);
        //添加操作日志
        Log log = new Log();
        log.setLogId(TeamUtil.getUuid());
        log.setCreationTime(df.format(new Date()));
        log.setLogUser(loginCustom.getGuser().getUserId());
        //根据职位id获取职位名称
        log.setLogContent("删除了"+record.getUserName()+"流程。");
        logMapper.insert(log);
        return result;
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

    //修改个人信息
    @Override
    public int updateByPrimaryKeySelective(Guser record,LoginCustom loginCustom) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //添加操作日志
        Log log = new Log();
        log.setLogId(TeamUtil.getUuid());
        log.setCreationTime(df.format(new Date()));
        log.setLogUser(loginCustom.getGuser().getUserId());
        //根据职位id获取职位名称
        log.setLogContent("修改了个人信息。");
        logMapper.insert(log);
        return guserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Guser record,LoginCustom loginCustom) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //添加操作日志
        Log log = new Log();
        log.setLogId(TeamUtil.getUuid());
        log.setCreationTime(df.format(new Date()));
        log.setLogUser(loginCustom.getGuser().getUserId());
        //根据职位id获取职位名称
        log.setLogContent("修改了"+record.getUserName()+"的信息。");
        return guserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public LoginCustom loginInfo(String userId) {
        return guserMapper.loginInfo(userId);
    }

    @Override
    public LoginCustom loginFunction(String userAccount) {

        LoginCustom ll = guserMapper.loginFunction(userAccount);
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
        return documentMapper.countDocumentByMouth(df.format(new Date()),department,userId);
    }

    @Override
    public CountByMouth countDptDocumentByMouth(String department) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        String userId = null;
        return documentMapper.countDocumentByMouth(df.format(new Date()),department,userId);
    }

    @Override
    public CountByMouth countPersonalDocumentByMouth(String userId) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy");//设置日期格式
        String department = null;
        return documentMapper.countDocumentByMouth(df.format(new Date()),department,userId);
    }

    @Override
    public QueryForPage getAllUser(int currentPage,String fuzzySearch,LoginCustom loginCustom) {
        List<LoginCustom>  users = guserMapper.getAllUser(fuzzySearch,loginCustom.getGuser().getUserId());
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
    public int resetPassword(String userId,LoginCustom loginCustom) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //添加操作日志
        Log log = new Log();
        log.setLogId(TeamUtil.getUuid());
        log.setCreationTime(df.format(new Date()));
        log.setLogUser(loginCustom.getGuser().getUserId());
        //根据职位id获取职位名称
        log.setLogContent("重置了"+guserMapper.selectByPrimaryKey(userId).getUserName()+"的密码");
        logMapper.insert(log);
        String password = md5.GetMD5Code("111111");
        Guser guser = new Guser();
        guser.setUserId(userId);
        guser.setUserPassword(password);
        return guserMapper.updateByPrimaryKeySelective(guser);
    }
    //批量删除
    @Override
    public int batchDelete(String[] userIds,LoginCustom loginCustom) {
        int result = 0;
        if (userIds.length==0){
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
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            //添加操作日志
            Log log = new Log();
            log.setLogId(TeamUtil.getUuid());
            log.setCreationTime(df.format(new Date()));
            log.setLogUser(loginCustom.getGuser().getUserId());
            //根据职位id获取职位名称
            log.setLogContent("删除了"+result+"人。");
            logMapper.insert(log);
            return result;
        }
    }

    @Override
    public QueryForPage getUserByDpt(String userDepartment,int currentPage,String fuzzySearch,String  userId) {
        List<LoginCustom> loginCustoms = guserMapper.getUserByDpt(userDepartment,fuzzySearch,userId);
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

    @Override
    public Guser getUserById(String userId) {
        return guserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int changePassword(String newPassword, LoginCustom loginCustom) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //添加操作日志
        Log log = new Log();
        log.setLogId(TeamUtil.getUuid());
        log.setCreationTime(df.format(new Date()));
        log.setLogUser(loginCustom.getGuser().getUserId());
        //根据职位id获取职位名称
        log.setLogContent("修改了密码。");
        logMapper.insert(log);
        Guser guser = new Guser();
        guser.setUserId(loginCustom.getGuser().getUserId());
        guser.setUserPassword(md5.GetMD5Code(newPassword));
        return guserMapper.updateByPrimaryKeySelective(guser);
    }

    @Override
    public boolean getUserByAcc(String userAccount) {
        List<Guser> user = guserMapper.getUserByAcc(userAccount);
        if (user.size()==0){
            return true;
        }else {
            return false;
        }
    }


}
