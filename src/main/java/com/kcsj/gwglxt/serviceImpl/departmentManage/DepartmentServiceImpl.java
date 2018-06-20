package com.kcsj.gwglxt.serviceImpl.departmentManage;

import com.kcsj.gwglxt.DTO.DocumentCustom;
import com.kcsj.gwglxt.entity.Department;
import com.kcsj.gwglxt.entity.DepartmentExample;
import com.kcsj.gwglxt.mapper.DepartmentMapper;
import com.kcsj.gwglxt.mapper.GuserMapper;
import com.kcsj.gwglxt.service.departmentManage.DepartmentService;
import com.kcsj.gwglxt.vo.QueryForPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private GuserMapper guserMapper;

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

    @Override
    public int insert(Department record) {
        return 0;
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
        List<Department> list = departmentMapper.getAllDepartment(searchInfo);
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
}
