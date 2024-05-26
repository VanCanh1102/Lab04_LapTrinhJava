package com.example.lab04.services;

import com.example.lab04.entity.MonHoc;
import com.example.lab04.entity.SinhVien;
import com.example.lab04.repository.IMonHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonHocService {
    @Autowired
    private IMonHocRepository monHocRepository;

    public List<MonHoc> getAllMonHoc(){
        return monHocRepository.findAll();
    }

    public MonHoc getMonHocById(String id){
        return monHocRepository.findById(id).orElse(null);
    }

    public void addMonHoc(MonHoc monHoc){
        monHocRepository.save(monHoc);
    }

    public void deleteMonHoc(String id){
        monHocRepository.deleteById(id);
    }

    public void updateMonHoc(MonHoc monHoc){
        monHocRepository.save(monHoc);
    }

    public List<MonHoc> searchMonHocByName(String tenMonHoc) {
        List<MonHoc> allMonHoc = monHocRepository.findAll();

        return allMonHoc.stream()
                .filter(monHoc -> monHoc.getTenMonHoc().toLowerCase().contains(tenMonHoc.toLowerCase()))
                .collect(Collectors.toList());
    }
}
