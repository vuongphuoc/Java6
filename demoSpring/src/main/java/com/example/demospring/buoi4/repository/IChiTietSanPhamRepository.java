package com.example.demospring.buoi4.repository;

import com.example.demospring.buoi4.dto.ChiTietSPCusTom;
import com.example.demospring.buoi4.entity.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham, String> {

    @Query(value = "select sp.Ma, nsx.Ten, ctsp.namBH, ctsp.MoTa, ctsp.SoLuongTon, ctsp.GiaNhap, ctsp.GiaBan \n" +
            "from ChiTietSP  ctsp \n" +
            " join  SanPham  sp on sp.Id = ctsp.IDSP \n" +
            " join NSX nsx on  nsx.id = ctsp.IdNSX ", nativeQuery = true)
    List<ChiTietSPCusTom> getCusTomSanPham();
}
