package com.viemed.carfleet.service;

/**
 * Functional Interface that authenticate users
 * 
 * @author carlos.lafferriere
 *
 */
@FunctionalInterface
public interface AuthenticationService {

    void authenticate(String username, String password) throws Exception;

}
