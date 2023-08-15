package com.example.demospring.buoi2;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class NhanVienService {

    private List<NhanVien> list = new ArrayList<>();

//    @PostConstruct
//    public void fakeData(){
//        IntStream.rangeClosed(1,50)
//                .mapToObj(o-> NhanVien.builder().ten("name"+o).tuoi(new Random().nextInt()))
//    }


//    public List<NhanVien> getAll(){
//
//    }
}
