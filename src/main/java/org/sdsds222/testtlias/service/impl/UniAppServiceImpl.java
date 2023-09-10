package org.sdsds222.testtlias.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.sdsds222.testtlias.mapper.DeptMapper;
import org.sdsds222.testtlias.mapper.EmpMapper;
import org.sdsds222.testtlias.mapper.UniAppMapper;
import org.sdsds222.testtlias.pojo.*;
import org.sdsds222.testtlias.service.DeptService;
import org.sdsds222.testtlias.service.UniAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UniAppServiceImpl implements UniAppService {
    @Autowired
    private UniAppMapper uniAppMapper;

    @Override
    public List<Nav> navList() {
        List<Nav> navList = uniAppMapper.getAllNavList();
        return navList;
    }

    @Override
    public List<News> newsList(Integer cid, Integer num, Integer page) {
        PageHelper.startPage(page, num);
        List<News> newsList = uniAppMapper.getAllNewsListByCid(cid);
        Page<News> p = (Page<News>) newsList;
        return p.getResult();
    }

    @Override
    public Detail detail(Integer cid, Integer id) {
        Detail detail = uniAppMapper.getDetailByCidAndId(cid, id);
        return detail;
    }

    @Override
    public void publish(PublishContent publishContent) {

        publishContent.setPosttime(System.currentTimeMillis());
        uniAppMapper.addPublishContentToNews(publishContent);
        uniAppMapper.addPublishContentToDetail(publishContent);
    }
}
