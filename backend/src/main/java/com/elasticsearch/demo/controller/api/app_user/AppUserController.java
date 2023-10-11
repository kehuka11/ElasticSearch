package com.elasticsearch.demo.controller.api.app_user;

import com.elasticsearch.demo.controller.dto.user.CreateUserParam;
import com.elasticsearch.demo.controller.request.user.CreateUserRequest;
import com.elasticsearch.demo.controller.response.EmptyResponse;
import com.elasticsearch.demo.service.CreateUserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserController {

    @Autowired
    private CreateUserService createUserService;

    @PostMapping("/app-user/create")
    public ResponseEntity<EmptyResponse> createAppUser(@RequestBody CreateUserRequest request) {

        CreateUserParam param = CreateUserParam.builder()
                .id(request.getId())
                .password(request.getPassword())
                .lastName(request.getLastName())
                .firstName(request.getFirstName())
                .build();

        createUserService.createUser(param);

        return ResponseEntity.ok(new EmptyResponse());
    }
}
