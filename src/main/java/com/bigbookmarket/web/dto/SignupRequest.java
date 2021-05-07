package com.bigbookmarket.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

    private String id;

    private String pwd;

    private String phone;

    private String nickname;
}
