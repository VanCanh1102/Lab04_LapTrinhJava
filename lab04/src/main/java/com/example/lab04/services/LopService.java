package com.example.lab04.services;

import com.example.lab04.entity.Lop;
import com.example.lab04.entity.MonHoc;
import com.example.lab04.repository.ILopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LopService {
    @Autowired
    private ILopRepository lopRepository;

    public List<Lop> getAllLop(){
        return lopRepository.findAll();
    }

    public Lop getLopById(Long id){
        return lopRepository.findById(id).orElse(null);
    }

    public void addLop(Lop lop){
        lopRepository.save(lop);
    }

    public void deleteLop(Long id){
        lopRepository.deleteById(id);
    }

    public void updateLop(Lop lop){
        lopRepository.save(lop);
    }

    public List<Lop> searchLopByName(String tenLop) {
        List<Lop> allLop = lopRepository.findAll();

        return allLop.stream()
                .filter(lop -> lop.getTenLop().toLowerCase().contains(tenLop.toLowerCase()))
                .collect(Collectors.toList());
    }
}
