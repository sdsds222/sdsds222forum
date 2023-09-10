package org.sdsds222.testtlias.mapper;

import org.apache.ibatis.annotations.*;
import org.sdsds222.testtlias.pojo.*;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface UniAppMapper {

    @Select("select * from nav")
    List<Nav> getAllNavList();

    @Select("select * from news where classid = #{cid}")
    List<News> getAllNewsListByCid(Integer cid);

    @Select("select * from detail where classid = #{cid} and newsid = #{id}")
    Detail getDetailByCidAndId(Integer cid, Integer id);


    void addPublishContentToNews(PublishContent publishContent);
    void addPublishContentToDetail(PublishContent publishContent);
}
