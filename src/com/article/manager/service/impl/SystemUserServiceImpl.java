package com.article.manager.service.impl;

import com.article.manager.dao.SystemUserDao;
import com.article.manager.dao.impl.SystemUserDaoImpl;
import com.article.manager.entity.SystemUser;
import com.article.manager.service.SystemUserService;

public class SystemUserServiceImpl implements SystemUserService {
    private SystemUserDao systemUserDao;
    public SystemUserServiceImpl(){
        systemUserDao = new SystemUserDaoImpl();
    }
    @Override
    public SystemUser selectByNameAndPwd(String name, String pwd) {
        return systemUserDao.selectByNameAndPwd(name, pwd);
    }
}
