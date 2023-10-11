package com.elasticsearch.demo.service.impl;

import com.elasticsearch.demo.controller.dto.user.CreateUserParam;
import com.elasticsearch.demo.repository.mapper.AppUserMapper;
import com.elasticsearch.demo.repository.model.AppUserWithBLOBs;
import com.elasticsearch.demo.service.CreateUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserServiceImpl implements CreateUserService {

    @Autowired private AppUserMapper appUserMapper;

    @Override
    public void createUser(CreateUserParam param) {

        AppUserWithBLOBs appUserWithBLOBs = new AppUserWithBLOBs();
        appUserWithBLOBs.setId(param.getId());
        appUserWithBLOBs.setLoginPassword(param.getPassword());
        appUserWithBLOBs.setLastName(param.getLastName());
        appUserWithBLOBs.setFirstName(param.getFirstName());

        appUserMapper.insert(appUserWithBLOBs);



    }
}
