package com.kcsj.gwglxt.serviceImpl.departmentManage;

import com.kcsj.gwglxt.DTO.DocumentCustom;
import com.kcsj.gwglxt.DTO.LoginCustom;
import com.kcsj.gwglxt.DTO.PositionPermission;
import com.kcsj.gwglxt.entity.*;
import com.kcsj.gwglxt.mapper.*;
import com.kcsj.gwglxt.service.departmentManage.DepartmentService;
import com.kcsj.gwglxt.util.TeamUtil;
import com.kcsj.gwglxt.vo.QueryForPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private GuserMapper guserMapper;
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private LogMapper logMapper;

    @Override
    public int countByExample(DepartmentExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(DepartmentExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String departmentId) {
        return 0;
    }

    //添加部门
    @Override
    public int insert(Department record, LoginCustom loginCustom) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //添加操作日志
        Log log = new Log();
        log.setLogId(TeamUtil.getUuid());
        log.setCreationTime(df.format(new Date()));
        log.setLogUser(loginCustom.getGuser().getUserId());
        log.setLogContent("添加了"+record.getDepartmentName()+"部门");
        logMapper.insert(log);
        record.setDepartmentId(TeamUtil.getUuid());
        record.setDepartmentIsdelete(0);
        return departmentMapper.insert(record);
    }

    @Override
    public int insertSelective(Department record) {
        return 0;
    }

    @Override
    public List<Department> selectByExample(DepartmentExample example) {
        return null;
    }

    @Override
    public Department selectByPrimaryKey(String departmentId) {
        return null;
    }

    @Override
    public int updateByExampleSelective(Department record, DepartmentExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Department record, DepartmentExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return 0;
    }

    @Override
    public QueryForPage getAllDepartment(int currentPage,String searchInfo) {
        //查询得到所有部门
        List<Department> list = departmentMapper.getAllDepartment();
        //遍历每一个查询结果，使用id查询人员表得到该部门人数
        for (Department departmentOne:list){
            int count = guserMapper.countByDepartment(departmentOne.getDepartmentId());
            departmentOne.setMemberCount(count);
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
        List<Department> list_thisPage = list.subList(offSet, endSet);
        queryForPage.setList(list_thisPage);
        queryForPage.setAllRow(allRow);
        queryForPage.setCurrentPage(currentPages);
        queryForPage.setPageSize(pagesize);
        queryForPage.setTotalPage(totalPage);
        queryForPage.init();
        return queryForPage;
    }
    //获取职位和权限信息
    @Override
    public List<PositionPermission> getPoPeByDpt(String department) {
        return positionMapper.getPoPeByDpt(department);
    }
    //获取所有权限
    @Override
    public List<Permission> getAllPermission() {
        return permissionMapper.getAllPermission();
    }
    //添加职位
    @Override
    public int insertPosition(Position position,LoginCustom loginCustom) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //添加操作日志
        Log log = new Log();
        log.setLogId(TeamUtil.getUuid());
        log.setCreationTime(df.format(new Date()));
        log.setLogUser(loginCustom.getGuser().getUserId());
        log.setLogContent("添加了"+position.getPositionName()+"职位。");
        logMapper.insert(log);
        position.setPositionId(TeamUtil.getUuid());
        position.setPositionIsdelete(0);
        return positionMapper.insert(position);
    }

    //修改职位权限
    @Override
    public int updatePermission(Position position,LoginCustom loginCustom) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //添加操作日志
        Log log = new Log();
        log.setLogId(TeamUtil.getUuid());
        log.setCreationTime(df.format(new Date()));
        log.setLogUser(loginCustom.getGuser().getUserId());
        //根据职位id获取职位名称
        log.setLogContent("修改了"+positionMapper.selectByPrimaryKey(position.getPositionId()).getPositionName()+"职位权限。");
        logMapper.insert(log);
        return positionMapper.updateByPrimaryKeySelective(position);
    }
    //修改部门信息
    @Override
    public int updateDptInfo(Department department,LoginCustom loginCustom) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //添加操作日志
        Log log = new Log();
        log.setLogId(TeamUtil.getUuid());
        log.setCreationTime(df.format(new Date()));
        log.setLogUser(loginCustom.getGuser().getUserId());
        //根据职位id获取职位名称
        log.setLogContent("修改了"+department.getDepartmentName()+"职位权限。");
        logMapper.insert(log);
        return departmentMapper.updateByPrimaryKeySelective(department);
    }

    @Override
    public List<Department> getAllDepartmentNoPage() {
        return departmentMapper.getAllDepartment();
    }
}
