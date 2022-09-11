package com.progra.productos.services;

import com.progra.productos.entities.Categoria;
import java.util.ArrayList;

public interface CategoriaService {

    public Categoria seleccionarCategoria(Categoria categoria);

    public ArrayList<Categoria> listarCategorias();
}
