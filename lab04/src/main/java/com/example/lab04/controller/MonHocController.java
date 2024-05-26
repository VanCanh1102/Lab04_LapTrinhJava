package com.example.lab04.controller;

import com.example.lab04.entity.Lop;
import com.example.lab04.entity.MonHoc;
import com.example.lab04.entity.SinhVien;
import com.example.lab04.services.MonHocService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/monHoc")
public class MonHocController {
    @Autowired
    private MonHocService monHocService;

    @GetMapping
    public String showAllMonHoc(Model model){
        List<MonHoc> dsMonHoc = monHocService.getAllMonHoc();
        model.addAttribute("dsMonHoc", dsMonHoc);
        return "monHoc/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("monHoc", new MonHoc());
        return "monHoc/add";
    }

    @PostMapping("/add")
    public String addMonHoc(@Valid @ModelAttribute("monHoc") MonHoc monHoc, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("moHoc", monHoc);
            return "addLop";
        }
        monHocService.addMonHoc(monHoc);
        return "redirect:/monHoc";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        MonHoc monHoc = monHocService.getMonHocById(id);
        if (monHoc != null) {
            model.addAttribute("monHoc", monHoc);
            return "monHoc/edit";
        } else {
            return "redirect:/monHoc";
        }
    }

    @PostMapping("/edit")
    public String updateMonHoc(@ModelAttribute("monHoc") MonHoc monHoc) {
        monHocService.updateMonHoc(monHoc);
        return "redirect:/monHoc";
    }

    @GetMapping("/delete/{id}")
    public String deleteMonHoc(@PathVariable String id) {
        monHocService.deleteMonHoc(id);
        return "redirect:/monHoc";
    }

    @GetMapping("/search")
    public String searchMonHoc(@RequestParam("tenMonHoc") String tenMonHoc, Model model) {
        List<MonHoc> dsMonHoc = monHocService.searchMonHocByName(tenMonHoc);
        model.addAttribute("dsMonHoc", dsMonHoc);
        return "monHoc/list";
    }
}
