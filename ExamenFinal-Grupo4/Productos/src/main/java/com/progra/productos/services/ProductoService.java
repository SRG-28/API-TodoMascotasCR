package com.progra.productos.services;

import com.progra.productos.entities.Operacion;
import com.progra.productos.entities.Producto;

import java.util.ArrayList;

public interface ProductoService {
    public Boolean insertarProducto(Producto producto);

    public Boolean actualizarProducto(Producto producto);

    public Boolean modificarInventario(Operacion newOperacion);

    public int insertarProductoConRetorno(Producto producto);

    public Producto seleccionarProducto(Producto producto);

    public ArrayList<Producto> listarProductos();
}
