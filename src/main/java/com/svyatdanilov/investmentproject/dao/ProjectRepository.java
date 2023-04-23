package com.svyatdanilov.investmentproject.dao;


import com.svyatdanilov.investmentproject.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    //add a method to sort by name
    //List<Project> findAllByOrderByName_of_projectAsc();
	
}
