package com.example.demospring.buoi4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NSX")
public class NhaSanXuat {
    @Id
    @Column(name = "Id")
    private String id;
    @Column(name = "Ten")
    private String ten;
}
