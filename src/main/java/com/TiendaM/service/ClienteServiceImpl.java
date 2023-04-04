package com.TiendaM.service;

import com.TiendaM.dao.ClienteDao;
import com.TiendaM.dao.CreditoDao;
import com.TiendaM.domain.Cliente;
import com.TiendaM.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService{    
    @Autowired
    private ClienteDao clienteDao;

    @Autowired
    private CreditoDao creditoDao;

    @Override
    @Transactional (readOnly = true)//Para manejar transacciones de solo lectura
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    public void save(Cliente cliente) {//metodo save sirve tanto para insertar como para modificar
        Credito credito = cliente.getCredito();
        credito = creditoDao.save(credito);
        cliente.setCredito(credito);
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }
    
    @Override
    @Transactional (readOnly = true)
    public Cliente getCliente(Cliente cliente) {
       return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }
}
