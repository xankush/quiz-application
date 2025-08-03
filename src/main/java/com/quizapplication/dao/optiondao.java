package com.quizapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quizapplication.entity.Option;

public interface optiondao extends JpaRepository<Option, Integer>{

}
