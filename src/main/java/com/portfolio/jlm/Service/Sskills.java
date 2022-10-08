
package com.portfolio.jlm.Service;

import com.portfolio.jlm.Entity.skills;
import com.portfolio.jlm.Repository.Rskills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class Sskills {
    @Autowired
    Rskills rskills;
    
    public List<skills> list(){
        return rskills.findAll();
    }
    
    public Optional<skills> getOne(int id){
        return rskills.findById(id);
    }
    
    public Optional<skills> getByNombre(String nombre){
        return rskills.findByNombre(nombre);
    }
    
    public void save(skills skill){
        rskills.save(skill);
    }
    
    public void delete(int id){
        rskills.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rskills.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rskills.existsByNombre(nombre);
    }
}
