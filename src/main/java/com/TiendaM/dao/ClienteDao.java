package com.TiendaM.dao;

import com.TiendaM.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Long>{
    
}
