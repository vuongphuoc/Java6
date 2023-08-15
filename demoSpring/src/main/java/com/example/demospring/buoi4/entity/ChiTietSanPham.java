package com.example.demospring.buoi4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ChiTietSP")
public class ChiTietSanPham {
    @Id
    @Column(name = "Id")
    private String id;
    @Column(name = "NamBH")
    private String namBH;
    @Column(name = "SoLuongTon")
    private Integer soLuongTon;
    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;
    @Column(name = "GiaBan")
    private BigDecimal giaBan ;
    @Column(name = "MoTa")
    private String moTa;


    @ManyToOne
    @JoinColumn(name = "IdSP")
    private  SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IdNSX")
    private NhaSanXuat nsx;
}
