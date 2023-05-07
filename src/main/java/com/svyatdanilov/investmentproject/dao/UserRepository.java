package com.svyatdanilov.investmentproject.dao;

import com.svyatdanilov.investmentproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);

}
