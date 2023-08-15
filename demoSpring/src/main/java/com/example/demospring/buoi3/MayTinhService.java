package com.example.demospring.buoi3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MayTinhService {

    @Autowired
    private IMayTinhRepository repository;


    public Page<MayTinh> getAll(Integer page){
        Pageable pageable = PageRequest.of(page,2);
        return repository.findAll(pageable);
    }

    public MayTinh getOne(String ma){
        Optional<MayTinh> optional = repository.findById(ma);
        return optional.isPresent() ? optional.get() : null;
    }
//    public MayTinh add(MayTinh mayTinh){
//        return repository.save(mayTinh);
//    }

    public MayTinh update (MayTinh mayTinh, String ma ){
        Optional<MayTinh> optional = repository.findById(ma);
        return  optional.map(o ->{
            o.setTen(mayTinh.getTen());
            o.setMau_sac(mayTinh.getMau_sac());
            o.setMieu_ta(mayTinh.getMieu_ta());
            o.setHang(mayTinh.getHang());
            o.setBo_nho(mayTinh.getBo_nho());
            o.setGia(mayTinh.getGia());
            return repository.save(o);
        }).orElse(null);
    }

    public MayTinh delete(String ma){
        Optional<MayTinh> optional = repository.findById(ma);
        return optional.map(o->{
            repository.delete(o);
            return o;
        }).orElse(null);
    }

    public List<MayTinh> loc(){
        return repository.findAll().stream().filter(o->o.getGia() >=1&& o.getGia() <=2000)
                .collect(Collectors.toList());
    }

    public MayTinh max(){
        return repository.findAll().stream()
                .max(Comparator.comparing(MayTinh::getGia))
                .get();
    }



    public Integer tong(){
        return (int) repository.findAll().stream()
                .filter(o-> o.getHang().equals("Brand"))
                .count();
    }
}
