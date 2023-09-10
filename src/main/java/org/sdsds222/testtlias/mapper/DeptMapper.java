package org.sdsds222.testtlias.mapper;

import org.apache.ibatis.annotations.*;
import org.sdsds222.testtlias.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
    //查询全部部门数据
    @Select("select * from dept")
    List<Dept> list();

    @Delete("delete from dept where id = #{id}")
    void delete(Integer id);

    @Insert("insert into dept (name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    @Select("select * from dept where id = #{id}")
    Dept select(String id);

    @Update("update dept set name = #{name} where id = #{id}")
    void update(Dept dept);
}
