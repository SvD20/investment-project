package com.svyatdanilov.investmentproject.dao;

import com.svyatdanilov.investmentproject.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Integer> {

    Role findByName(String name);

}
