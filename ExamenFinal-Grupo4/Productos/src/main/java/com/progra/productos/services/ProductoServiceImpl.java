package com.progra.productos.services;

import com.progra.productos.dao.ProductoDao;
import com.progra.productos.entities.Operacion;
import com.progra.productos.entities.Producto;

import java.util.ArrayList;

public class ProductoServiceImpl implements ProductoService{

    private ProductoDao productoDao;

    public ProductoServiceImpl() {
        productoDao = new ProductoDao();
    }

    public Boolean insertarProducto(Producto producto){

        //validacion a nivel de regla de negocio

        return productoDao.insertarProducto(producto);
    }

    public int insertarProductoConRetorno(Producto producto){
        return productoDao.insertarProductoConRetornoId(producto);
    }

    public Boolean actualizarProducto(Producto producto){
        return productoDao.actualizarProducto(producto);
    }

    public Boolean modificarInventario(Operacion newOperacion){
        return productoDao.modificarInventario(newOperacion);
    }

    public Producto seleccionarProducto(Producto producto){
        return productoDao.seleccionarProducto(producto);
    }

    public ArrayList<Producto> listarProductos(){
        return productoDao.mostrarTodos();
    }
}
