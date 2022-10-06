package com.portfolio.jlm.Repository;

import com.portfolio.jlm.Entity.Adm;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RAdm extends JpaRepository<Adm, Integer>{
    public Optional<Adm> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}