package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application,Integer>{

}
