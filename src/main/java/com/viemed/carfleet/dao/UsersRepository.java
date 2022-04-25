package com.viemed.carfleet.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.viemed.carfleet.model.Users;

/**
 * User's repository
 * 
 * @author carlos.lafferriere
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUser(String user);

}
