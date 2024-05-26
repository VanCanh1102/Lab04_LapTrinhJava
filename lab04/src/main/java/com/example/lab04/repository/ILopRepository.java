package com.example.lab04.repository;

import com.example.lab04.entity.Lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILopRepository extends JpaRepository<Lop, Long> {
}
