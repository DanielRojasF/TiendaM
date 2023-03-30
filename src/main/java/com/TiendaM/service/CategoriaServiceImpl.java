package com.TiendaM.service;

import com.TiendaM.dao.CategoriaDao;
import com.TiendaM.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired
    CategoriaDao categoriaDao;

    @Override
    @Transactional (readOnly = true)
    public List<Categoria> getCategorias(boolean activos) {
        List<Categoria> lista = (List<Categoria>) categoriaDao.findAll();// en esta lista tenemos 4 elementos 3 activos y uno inactivo
        
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional (readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
       return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    public void delete(Categoria categoria) {
        categoriaDao.deleteById(categoria.getIdCategoria());
    }
    
}
