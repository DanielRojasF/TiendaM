
package com.TiendaM.service;

import com.TiendaM.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    public List<Categoria> getCategorias(boolean activos);/*firma del metodo*/
    
    public Categoria getCategoria(Categoria categoria);
    
    public void save (Categoria categoria);//Para insertar o modificar (Si viene el idCliente o no)

    public void delete (Categoria categoria);
}
