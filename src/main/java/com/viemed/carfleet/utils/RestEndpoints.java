package com.viemed.carfleet.utils;

import lombok.Builder;

@Builder
public class RestEndpoints {

    public static final String USERS = "/users";
    public static final String USER_AUTH = USERS + "/authenticate";

    private RestEndpoints() {}

}
