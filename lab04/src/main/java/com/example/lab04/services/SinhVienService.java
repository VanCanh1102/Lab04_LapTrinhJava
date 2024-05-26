package com.example.lab04.services;

import com.example.lab04.entity.SinhVien;
import com.example.lab04.repository.ISinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SinhVienService {
    @Autowired
    private ISinhVienRepository sinhVienRepository;

    public List<SinhVien> getAllSinhVien(){
        return sinhVienRepository.findAll();
    }

    public SinhVien getSinhVienById(String id){
        return sinhVienRepository.findById(id).orElse(null);
    }

    public void addSinhVien(SinhVien sinhVien){
        sinhVienRepository.save(sinhVien);
    }

    public void deleteSinhVien(String id){
        sinhVienRepository.deleteById(id);
    }

    public void updateSinhVien(SinhVien sinhVien){
        sinhVienRepository.save(sinhVien);
    }

    public List<SinhVien> searchSinhVienByName(String hoTen) {
        List<SinhVien> allSinhVien = sinhVienRepository.findAll();

        return allSinhVien.stream()
                .filter(sinhVien -> sinhVien.getHoTen().toLowerCase().contains(hoTen.toLowerCase()))
                .collect(Collectors.toList());
    }

}
