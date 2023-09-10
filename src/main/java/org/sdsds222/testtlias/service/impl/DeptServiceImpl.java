package org.sdsds222.testtlias.service.impl;

import org.sdsds222.testtlias.mapper.DeptMapper;
import org.sdsds222.testtlias.mapper.EmpMapper;
import org.sdsds222.testtlias.pojo.Dept;
import org.sdsds222.testtlias.service.DeptService;
import org.sdsds222.testtlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    //对所有的异常都进行回滚操作,默认情况下只有运行时异常才进行事务回滚操作
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id) {
        deptMapper.delete(id);
        empMapper.deleteEmpsByDeptId(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept select(String id) {
        return deptMapper.select(id);
    }

    @Override
    public void update(Dept dept) {
        deptMapper.update(dept);
    }
}
