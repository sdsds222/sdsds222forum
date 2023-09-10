package org.sdsds222.testtlias.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.sdsds222.testtlias.pojo.User;

@Mapper
public interface LoginMapper {
    @Select("select count(*) from user where username = #{username}")
    public Integer findItemByUsername(User user);

    @Select("select count(*) from user where username = #{username} and password = #{password}")
    public Integer findItemByUsernameAndPassword(User user);

    @Insert("INSERT INTO user (username, password) VALUES (#{username} ,#{password})")
    public void insertItemByUsernameAndPassword(User user);
}
