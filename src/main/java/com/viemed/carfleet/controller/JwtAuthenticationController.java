package com.viemed.carfleet.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import com.viemed.carfleet.dao.UsersRepository;
import com.viemed.carfleet.dto.JwtRequestDto;
import com.viemed.carfleet.exceptions.ForbiddenException;
import com.viemed.carfleet.model.Users;
import com.viemed.carfleet.service.AuthenticationService;
import com.viemed.carfleet.service.impl.JwtUserDetailsServiceImpl;
import com.viemed.carfleet.utils.JwtTokenUtils;

/**
 * Controller that manage authentication of users into the system
 * 
 * @author carlos.lafferriere
 *
 */
@Controller
public class JwtAuthenticationController {

    private AuthenticationService authenticationService;
    private JwtTokenUtils jwtTokenUtil;
    private JwtUserDetailsServiceImpl userDetailsService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UsersRepository usersRepository;


    public JwtAuthenticationController(UsersRepository usersRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder,
            JwtUserDetailsServiceImpl userDetailsService, 
            JwtTokenUtils jwtTokenUtil,
            AuthenticationService authenticationService) {

        this.usersRepository = usersRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationService = authenticationService;
    }


    /**
     * Add a new User to the system
     * 
     * @param userDto to add
     */
    public Users signUp(JwtRequestDto userDto) {
        Users user = new Users();
        user.setUser(userDto.getUser());
        user.setPass(bCryptPasswordEncoder.encode(userDto.getPass()));
        return usersRepository.save(user);
    }


    /**
     * Method that create an authentication token for the given user.
     * 
     * @param authenticationRequest with data to be verified and validated
     * @return the token for the given user
     */
    public String createAuthenticationToken(JwtRequestDto authenticationRequest) {
        try {
            authenticationService.authenticate(authenticationRequest.getUser(),
                    authenticationRequest.getPass());
        } catch (Exception e) {
            throw new ForbiddenException("Forbidden for user: " 
            			+ authenticationRequest.getUser());
        }
        final UserDetails userDetails =
                userDetailsService.loadUserByUsername(authenticationRequest.getUser());
        return jwtTokenUtil.generateToken(userDetails);
    }

}
