package org.sdsds222.testtlias.service;

import org.sdsds222.testtlias.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    //查询全部部门数据
    List<Dept> list();

    void delete(Integer id);

    void add(Dept dept);

    Dept select(String id);

    void update(Dept dept);
}
