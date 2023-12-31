package org.sdsds222.testtlias.service;

import org.sdsds222.testtlias.pojo.PageBean;

import java.time.LocalDate;


/**
 * 员工管理
 */
public interface EmpService {
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);
}
