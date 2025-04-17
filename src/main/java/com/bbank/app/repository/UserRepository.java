package com.bbank.app.repository;

import com.bbank.app.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<LoginUser,Long> {
    LoginUser findByUserName(String userName);
}
