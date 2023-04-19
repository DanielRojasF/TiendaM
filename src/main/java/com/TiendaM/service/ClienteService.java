package com.TiendaM.service;

import com.TiendaM.domain.Cliente;
import java.util.List;

public interface ClienteService {
    
    public List<Cliente> getClientes();/*firma del metodo*/
    
    public void save (Cliente cliente);//Para insertar o modificar (Si viene el idCliente o no)

    public void delete (Cliente cliente);
    
    public Cliente getCliente(Cliente cliente);
} 
  