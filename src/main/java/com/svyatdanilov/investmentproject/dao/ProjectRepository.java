package com.svyatdanilov.investmentproject.dao;


import com.svyatdanilov.investmentproject.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
