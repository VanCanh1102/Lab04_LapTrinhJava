package com.example.lab04.repository;

import com.example.lab04.entity.MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMonHocRepository extends JpaRepository<MonHoc, String> {
}
