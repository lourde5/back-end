package com.portfolio.jlm.Controller;

import com.portfolio.jlm.Dto.dtoAdm;
import com.portfolio.jlm.Entity.Adm;
import com.portfolio.jlm.Security.Controller.Mensaje;
import com.portfolio.jlm.Service.SAdm;
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
@RequestMapping("adm")
@CrossOrigin(origins = "http://localhost:4200")
public class CAdm {
    @Autowired
    SAdm sAdm;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Adm>> list(){
        List<Adm> list = sAdm.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Adm> getById(@PathVariable("id") int id) {
        if(!sAdm.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Adm adm = sAdm.getOne(id).get();
        return new ResponseEntity(adm, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAdm dtoadm){
        if(StringUtils.isBlank(dtoadm.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Adm adm = new Adm(dtoadm.getNombreE());
        sAdm.save(adm);
        
        return new ResponseEntity(new Mensaje("Información agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAdm dtoadm){
        if(!sAdm.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoadm.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Adm adm = sAdm.getOne(id).get();
        adm.setNombreE(dtoadm.getNombreE());
        
        sAdm.save(adm);
        return new ResponseEntity(new Mensaje("Información actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sAdm.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sAdm.delete(id);
        
        return new ResponseEntity(new Mensaje("Información eliminada"), HttpStatus.OK);
    }
}
