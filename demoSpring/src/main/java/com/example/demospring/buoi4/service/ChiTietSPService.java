package com.example.demospring.buoi4.service;

import com.example.demospring.buoi4.dto.ChiTietSPCusTom;
import com.example.demospring.buoi4.dto.ChiTietSPRequest;
import com.example.demospring.buoi4.entity.ChiTietSanPham;
import com.example.demospring.buoi4.entity.NhaSanXuat;
import com.example.demospring.buoi4.entity.SanPham;
import com.example.demospring.buoi4.repository.IChiTietSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChiTietSPService {
    @Autowired
    private IChiTietSanPhamRepository repository;


    public List<ChiTietSPCusTom> getAll() {
        return repository.getCusTomSanPham();
    }

    public Page<ChiTietSanPham> getPage(Integer page){
        Pageable pageable = PageRequest.of(page, 3);
        return repository.findAll(pageable);
    }


    public ChiTietSanPham getOne(String ma) {
        Optional<ChiTietSanPham> optional = repository.findById(ma);
        return optional.isPresent() ? optional.get() : null;
    }

    public ChiTietSanPham update(String ma, ChiTietSPRequest request){
        Optional<ChiTietSanPham> optional = repository.findById(ma);
        return optional.map(ctsp ->{
            ctsp.setSanPham(SanPham.builder().id(request.getIdSp()).build());
            ctsp.setNsx(NhaSanXuat.builder().id(request.getIdNSX()).build());
            ctsp.setGiaBan(request.getGiaBan());
            ctsp.setGiaNhap(request.getGiaNhap());
            ctsp.setMoTa(request.getMoTa());
            ctsp.setSoLuongTon(request.getSoLuongTon());
            ctsp.setNamBH(request.getNamBH());
            return repository.save(ctsp);
        }).orElse(null);

    }


    public ChiTietSanPham delete(String ma){
        Optional<ChiTietSanPham> optional = repository.findById(ma);
        return optional.map(ctsp ->{
            repository.delete(ctsp);
            return ctsp;
        }).orElse(null);
    }


    public ChiTietSanPham add(ChiTietSPRequest chiTietSPRequest) {
        ChiTietSanPham chiTietSP = chiTietSPRequest.map(new ChiTietSanPham());
        return repository.save(chiTietSP);
    }
}
