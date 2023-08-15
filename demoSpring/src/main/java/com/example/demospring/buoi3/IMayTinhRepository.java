package com.example.demospring.buoi3;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMayTinhRepository extends JpaRepository<MayTinh, String> {


}
