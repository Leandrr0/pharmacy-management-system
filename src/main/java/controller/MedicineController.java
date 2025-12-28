package com.finekss.pharmacy.controller;

import com.finekss.pharmacy.model.Medicine;
import com.finekss.pharmacy.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

    @Autowired
    private MedicineRepository repository;

    @PostMapping
    public void create(@RequestBody Medicine data) {
        repository.save(data);
    }

    @GetMapping
    public List<Medicine> listAll() {
        return repository.findAll();
    }
}