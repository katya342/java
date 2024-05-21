package com.example.demo.repository;

import com.example.demo.entity.Libuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibuserRepository extends JpaRepository<Libuser, Integer> {

}