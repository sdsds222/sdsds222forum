package org.sdsds222.testtlias.service.impl;

import org.sdsds222.testtlias.mapper.LoginMapper;
import org.sdsds222.testtlias.pojo.User;
import org.sdsds222.testtlias.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public Boolean login(User user) {
        Integer userNum = loginMapper.findItemByUsername(user);
        if(userNum > 0){
            Integer num = loginMapper.findItemByUsernameAndPassword(user);
            //如果查询到的结果的个数大于0，则说明数据库中存在账号且密码正确，登陆成功
            if (num > 0) {
                return true;
            }else{
                return false;
            }
        }else{
            loginMapper.insertItemByUsernameAndPassword(user);
            return true;
        }
    }
}
