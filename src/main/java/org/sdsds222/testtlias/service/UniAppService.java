package org.sdsds222.testtlias.service;

import org.sdsds222.testtlias.pojo.*;

import java.util.List;

/**
 * 部门管理
 */
public interface UniAppService {
    List<Nav> navList();


    List<News> newsList(Integer cid, Integer num, Integer page);

    Detail detail(Integer cid, Integer id);

    void publish(PublishContent publishContent);
}
