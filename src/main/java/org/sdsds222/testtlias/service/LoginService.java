package org.sdsds222.testtlias.service;

import org.sdsds222.testtlias.pojo.User;
import org.springframework.stereotype.Component;

public interface LoginService {
    Boolean login(User user);
}
