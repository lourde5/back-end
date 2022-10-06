package com.portfolio.jlm.Service;

import com.portfolio.jlm.Entity.Adm;
import com.portfolio.jlm.Repository.RAdm;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SAdm {
    @Autowired
    RAdm rAdm;
    
    public List<Adm> list(){
        return rAdm.findAll();
    }
    
    public Optional<Adm> getOne(int id){
        return rAdm.findById(id);
    }
    
    public Optional<Adm> getByNombreE(String nombreE){
        return rAdm.findByNombreE(nombreE);
    }
    
    public void save(Adm adm){
        rAdm.save(adm);
    }
    
    public void delete(int id){
        rAdm.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rAdm.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return rAdm.existsByNombreE(nombreE);
    }
}
