
package com.TiendaM.service;

import com.TiendaM.domain.Articulo;
import java.util.List;


public interface ArticuloService {
    public List<Articulo> getArticulos(boolean activos);/*firma del metodo*/
    
    public Articulo getArticulo(Articulo articulo);
    
    public void save (Articulo articulo);//Para insertar o modificar (Si viene el idCliente o no)

    public void delete (Articulo articulo);
}
