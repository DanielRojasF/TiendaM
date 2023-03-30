package com.TiendaM.service;

import com.TiendaM.dao.ArticuloDao;
import com.TiendaM.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceImpl implements ArticuloService {
    
    @Autowired
    ArticuloDao articuloDao;

    @Override
    @Transactional (readOnly = true)
    public List<Articulo> getArticulos(boolean activos) {
        List<Articulo> lista = (List<Articulo>) articuloDao.findAll();// en esta lista tenemos 4 elementos 3 activos y uno inactivo
        
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional (readOnly = true)
    public Articulo getArticulo(Articulo articulo) {
       return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    public void delete(Articulo articulo) {
        articuloDao.deleteById(articulo.getIdArticulo());
    }
    
}
