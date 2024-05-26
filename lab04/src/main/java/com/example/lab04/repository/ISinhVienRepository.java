package com.example.lab04.repository;

import com.example.lab04.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISinhVienRepository extends JpaRepository<SinhVien,String> {
}
