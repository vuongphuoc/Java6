package com.example.demospring.buoi4.dto;

import com.example.demospring.buoi4.entity.ChiTietSanPham;
import com.example.demospring.buoi4.entity.NhaSanXuat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ChiTietSPRequest {
    private String idSp;
    private String idNSX;
    private Integer soLuongTon;
    private String namBH;
    private String moTa;
    private BigDecimal giaNhap;
    private BigDecimal  giaBan;



    public ChiTietSanPham map(ChiTietSanPham chiTietSanPham){
        chiTietSanPham.setId(this.getIdSp());
        chiTietSanPham.setNsx(NhaSanXuat.builder().id(this.getIdNSX()).build());
        chiTietSanPham.setSoLuongTon(this.getSoLuongTon());
        chiTietSanPham.setNamBH(this.getNamBH());
        chiTietSanPham.setMoTa(this.getMoTa());
        chiTietSanPham.setGiaNhap(this.getGiaNhap());
        chiTietSanPham.setGiaBan(this.getGiaBan());
        return chiTietSanPham;
    }
}
