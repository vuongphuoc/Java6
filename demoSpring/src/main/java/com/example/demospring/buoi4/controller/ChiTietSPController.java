package com.example.demospring.buoi4.controller;

import com.example.demospring.buoi4.dto.ChiTietSPRequest;
import com.example.demospring.buoi4.entity.ChiTietSanPham;
import com.example.demospring.buoi4.service.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sanPham")
public class ChiTietSPController {
    @Autowired
    ChiTietSPService service;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/detail/{ma}")
    public ResponseEntity<?> getOne(@PathVariable String ma){
        return ResponseEntity.ok(service.getOne(ma));
    }

    @PutMapping("/update/{ma}")
    public ResponseEntity<?> updateOne(@PathVariable String ma, @RequestBody ChiTietSPRequest request){
        return ResponseEntity.ok(service.update(ma, request));
    }


    @DeleteMapping("/delete/{ma}")
    public ResponseEntity deleteOne(@PathVariable String ma){
        return ResponseEntity.ok(service.delete(ma));
    }

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody ChiTietSPRequest request){
        return ResponseEntity.ok(service.add(request));
    }

    @GetMapping("/getPage")
    public ResponseEntity<?> getPage(@RequestParam (value = "page", defaultValue = "0")Integer page){
        return ResponseEntity.ok(service.getPage(page));
    }
}
