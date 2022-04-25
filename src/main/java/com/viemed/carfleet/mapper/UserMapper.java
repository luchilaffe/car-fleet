package com.viemed.carfleet.mapper;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import com.viemed.carfleet.model.Users;

public class UserMapper {

    /**
     * Constructor
     */
    private UserMapper() {}

    public static UserDetails toUserDetails(Users user) {
        return new User(user.getUser(), user.getPass(), new ArrayList<>());
    }

}
