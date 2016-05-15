package com.jazeroth.realm.dao;

import com.jazeroth.realm.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountDao extends JpaRepository<Account, Long> {

    @Query("FROM Account WHERE username = :username")
    Account findByUsername(@Param("username") String username);

}
