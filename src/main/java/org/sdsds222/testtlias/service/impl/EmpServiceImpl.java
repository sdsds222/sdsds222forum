package org.sdsds222.testtlias.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.sdsds222.testtlias.mapper.EmpMapper;
import org.sdsds222.testtlias.pojo.Emp;
import org.sdsds222.testtlias.pojo.PageBean;
import org.sdsds222.testtlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    //    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        //获取总记录数
//        Long count = empMapper.count();
//        //获取结果列表
//        //计算起始索引
//        Integer start = (page - 1) * pageSize;
//        List<Emp> empList = empMapper.page(start,pageSize);
//        //封装pageBean对象
//        return new PageBean(count,empList);
//    }
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        PageHelper.startPage(page, pageSize);
        List<Emp> empList = empMapper.page(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;

        //封装pageBean对象
        return new PageBean(p.getTotal(), p.getResult());
    }
}
