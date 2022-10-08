package com.portfolio.jlm.Controller;

import com.portfolio.jlm.Dto.dtoSkills;
import com.portfolio.jlm.Entity.skills;
import com.portfolio.jlm.Security.Controller.Mensaje;
import com.portfolio.jlm.Service.Sskills;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("skills")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://portfoliojlm.web.app")
public class Cskills {
    @Autowired
    Sskills sskills;
    
    @GetMapping("/lista")
    public ResponseEntity<List<skills>> list(){
        List<skills> list = sskills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<skills> getById(@PathVariable("id") int id) {
        if(!sskills.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        skills skill = sskills.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskill){
        if(StringUtils.isBlank(dtoskill.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        skills skill = new skills(dtoskill.getNombre(), dtoskill.getNumero());
        sskills.save(skill);
        
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskill){
        if(!sskills.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoskill.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        skills skill = sskills.getOne(id).get();
        skill.setNombre(dtoskill.getNombre());
        skill.setNumero(dtoskill.getNumero());
        
        sskills.save(skill);
        return new ResponseEntity(new Mensaje("Skill actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sskills.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sskills.delete(id);
        
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }
}

