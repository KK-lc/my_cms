package com.article.manager.service;

import com.article.manager.entity.SystemUser;

public interface SystemUserService {
    SystemUser selectByNameAndPwd(String name,String pwd);
}
