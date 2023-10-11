package com.elasticsearch.demo.controller.dto.user;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
public class CreateUserParam {

    /** ID */
    private String id;

    /** Password */
    private String password;

    /** 姓 */
    private String lastName;

    /** 名 */
    private String firstName;
}
