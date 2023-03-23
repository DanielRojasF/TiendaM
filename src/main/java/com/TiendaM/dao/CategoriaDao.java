package com.TiendaM.dao;

import com.TiendaM.domain.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaDao extends CrudRepository<Categoria, Long>{
    
}
