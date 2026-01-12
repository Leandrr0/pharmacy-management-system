package com.leandro.pharmacy.controller;

import com.leandro.pharmacy.model.Medicine;
import com.leandro.pharmacy.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.apache.tomcat.util.net.openssl.OpenSSLStatus.getName;

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

    @PutMapping("/{id}")
    public Medicine update(@PathVariable Long id, @RequestBody Medicine data) {
        Medicine medicine = repository.findById(id).orElse(null);

        if (medicine != null) {
            medicine.setName(data.getName());
            medicine.setManufacturer(data.getManufacturer());
            medicine.setPrice(data.getPrice());
            medicine.setQuantity(data.getQuantity());

            return repository.save(medicine);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        repository.deleteById(id);
    }
}
