package com.example.demo.Repo;

import com.example.demo.Mode.Users1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Users1,Integer> {
}
