package com.TiendaM.dao;

import com.TiendaM.domain.Articulo;
import org.springframework.data.repository.CrudRepository;

public interface ArticuloDao extends CrudRepository<Articulo, Long>{
    
}
