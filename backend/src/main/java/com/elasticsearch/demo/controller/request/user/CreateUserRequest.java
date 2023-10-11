package com.elasticsearch.demo.controller.request.user;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
public class CreateUserRequest {

    /** ID */
    @Size(min=8, max = 30)
    @NotEmpty
    private String id;

    /** Password */
    @Size(min=8, max = 30)
    @NotEmpty
    private String password;

    /** 姓 */
    @Size(min = 1, max = 100)
    @NotEmpty
    private String lastName;

    /** 名 */
    @Size(min = 1, max = 100)
    @NotEmpty
    private String firstName;
}
