package com.elasticsearch.demo.service;

import com.elasticsearch.demo.controller.dto.user.CreateUserParam;

public interface CreateUserService {

    /**
     * ユーザ作成
     * @param param ユーザ作成用パラメータ
     */
    public void createUser(CreateUserParam param);
}
