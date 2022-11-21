package com.article.manager.dao;

import com.article.manager.entity.SystemUser;

public interface SystemUserDao {
    SystemUser selectByNameAndPwd(String name,String pwd);

}
