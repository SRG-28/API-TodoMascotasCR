package com.progra.productos.services;


import com.progra.productos.dao.CategoriaDao;
import com.progra.productos.entities.Categoria;

import java.util.ArrayList;

public class CategoriaServiceImpl implements CategoriaService{

    private CategoriaDao categoriaDao;

    public CategoriaServiceImpl() {
        categoriaDao = new CategoriaDao();
    }

    public Categoria seleccionarCategoria(Categoria categoria){
        return categoriaDao.seleccionarCategoria(categoria);
    }

    public ArrayList<Categoria> listarCategorias(){
        return categoriaDao.mostrarTodosCategorias();
    }
}

