package com.example.demospring.buoi3;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
@RequestMapping("/api/mayTinh")
public class MayTinhController {
    @Autowired
    private MayTinhService service;

@Autowired
IMayTinhRepository repository;

    @GetMapping
    public ResponseEntity<?> getALl(@RequestParam(defaultValue = "0", value = "page") Integer page) {
        return ResponseEntity.ok(service.getAll(page));
    }

    @GetMapping("/detail/{ma}")
    public ResponseEntity<?> getOne(@PathVariable String ma) {
        return ResponseEntity.ok(service.getOne(ma));
    }

    @PutMapping("/update/{ma}")
    public ResponseEntity<?> updateOne(@PathVariable String ma, @RequestBody MayTinh mayTinh) {
        return ResponseEntity.ok(service.update(mayTinh, ma));
    }

    @DeleteMapping("/delete/{ma}")
    public ResponseEntity<?> delete(@PathVariable String ma) {
        return ResponseEntity.ok(service.delete(ma));
    }

    @GetMapping("/loc")
    public ResponseEntity<?> loc() {
        return ResponseEntity.ok(service.loc());
    }

    @GetMapping("/max")
    public ResponseEntity<?> max() {
        return ResponseEntity.ok(service.max());
    }

    @PostMapping("/create")
    public ResponseEntity<?> add(@RequestBody MayTinh mayTinh){
     MayTinh mayTinh1   =repository.save(mayTinh);
        return ResponseEntity.ok(mayTinh1);
    }
    
    @GetMapping("/tong")
    public ResponseEntity<?> tong(){
        return ResponseEntity.ok(service.tong());
    }

}
