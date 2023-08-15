package com.example.demospring.buoi3;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "may_tinh")
public class MayTinh {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "gennerator")
    @Column(name = "ma")
    private String ma;
    @Column(name = "ten")
    private String ten;
    @Column(name = "gia")
    private Float gia;
    @Column(name = "bo_nho")
    private String bo_nho;
    @Column(name = "mau_sac")
    private String mau_sac;
    @Column(name = "hang")
    private String hang;
    @Column(name = "mieu_ta")
    private String mieu_ta;
}
