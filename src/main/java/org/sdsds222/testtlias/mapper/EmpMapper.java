package org.sdsds222.testtlias.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.sdsds222.testtlias.pojo.Emp;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {
    //查询总记录数
    @Select("select count(*) from emp")
    public Long count();

    //获取分页数据
//    @Select("select * from emp limit #{start},#{pageSize}")
//    public List<Emp> page(Integer start,Integer pageSize);
    //@Select("select * from emp")
    public List<Emp> page(String name, Short gender, LocalDate begin, LocalDate end);

    @Delete("delete from emp where dept_id = #{id}")
    public void deleteEmpsByDeptId(Integer id);
}
