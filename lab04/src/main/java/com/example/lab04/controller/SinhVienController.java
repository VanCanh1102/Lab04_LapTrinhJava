package com.example.lab04.controller;

import com.example.lab04.entity.Lop;
import com.example.lab04.entity.SinhVien;
import com.example.lab04.services.LopService;
import com.example.lab04.services.SinhVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sinhVien")
public class SinhVienController {
    @Autowired
    private SinhVienService sinhVienService;
    @Autowired
    private LopService lopService;

    @GetMapping
    public String showAllSinhVien(Model model){
        List<SinhVien> dsSinhVien = sinhVienService.getAllSinhVien();
        model.addAttribute("dsSinhVien", dsSinhVien);
        return "sinhVien/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("sinhVien", new SinhVien());
        List<Lop> dsLop = lopService.getAllLop();
        model.addAttribute("dsLop", dsLop);
        return "sinhVien/add";
    }

    @PostMapping("/add")
    public String addSinhVien(@Valid @ModelAttribute("sinhVien") SinhVien sinhVien, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("sinhVien", sinhVien);
            return "addSinhVien";
        }
        sinhVienService.addSinhVien(sinhVien);
        return "redirect:/sinhVien";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        SinhVien sinhVien = sinhVienService.getSinhVienById(id);
        if (sinhVien != null) {
            model.addAttribute("sinhVien", sinhVien);
            List<Lop> dsLop = lopService.getAllLop();
            model.addAttribute("dsLop", dsLop);
            return "sinhVien/edit";
        } else {
            return "redirect:/sinhVien";
        }
    }

    @PostMapping("/edit")
    public String updateSinhVien(@Valid @ModelAttribute("sinhVien") SinhVien sinhVien, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Lop> dsLop = lopService.getAllLop();
            model.addAttribute("dsLop", dsLop);
            return "sinhVienForm";
        }
        sinhVienService.addSinhVien(sinhVien); // Lưu thông tin sinh viên vào database
        return "redirect:/sinhVien";
    }

    @GetMapping("/delete/{id}")
    public String deleteSinhVien(@PathVariable String id) {
        sinhVienService.deleteSinhVien(id);
        return "redirect:/sinhVien";
    }

    @GetMapping("/search")
    public String searchSinhVien(@RequestParam("hoTen") String hoTen, Model model) {
        List<SinhVien> dsSinhVien = sinhVienService.searchSinhVienByName(hoTen);
        model.addAttribute("dsSinhVien", dsSinhVien);
        return "sinhVien/list";
    }
}
