package com.progra.productos.dao;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.progra.productos.entities.Operacion;
import com.progra.productos.utils.Conexion;
import com.progra.productos.entities.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dario
 */
public class ProductoDao {
    public final static Connection connection = Conexion.getConnection();

    //metodo para insertar
    public boolean insertarProducto(Producto producto) {
        try {
            String consulta = "insert into productos(nombre, descripcion, url, precio, cantidad) values (?, ?, ?, ?, ?)";
            PreparedStatement stm1 = connection.prepareStatement(consulta);
            stm1.setString(1, producto.getNombre());
            stm1.setString(2, producto.getDescripcion());
            stm1.setString(3, producto.getUrl());
            stm1.setDouble(4, producto.getPrecio());
            stm1.setInt(5, producto.getCantidad());
            stm1.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error:" + ex.fillInStackTrace());
            return false;
        }

    }


    //metodo para insertar
    public int insertarProductoConRetornoId(Producto producto) {
        int codigo = 0;
        try {
            String consulta = "insert into productos(nombre, descripcion, url, precio, cantidad) values (?, ?, ?, ?, ?)";
            PreparedStatement stm1 = connection.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            stm1.setString(1, producto.getNombre());
            stm1.setString(2, producto.getDescripcion());
            stm1.setString(3, producto.getUrl());
            stm1.setDouble(4, producto.getPrecio());
            stm1.setInt(5, producto.getCantidad());
            stm1.executeUpdate();
            ResultSet rs = stm1.getGeneratedKeys();
            if (rs.next()) {
                codigo = rs.getInt(1);
            }
            return codigo;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error:" + ex.fillInStackTrace());
            return -1;
        }

    }

    //metodo para buscar
    public Producto seleccionarProducto(Producto producto) {
        try {
            String consulta = "select * from productos where id = ? ";
            PreparedStatement stm1 = connection.prepareStatement(consulta);
            stm1.setInt(1, producto.getId());
            ResultSet rs = stm1.executeQuery();
            Producto productoNuevo = null;
            while (rs.next()) {
                productoNuevo = new Producto();
                productoNuevo.setId(rs.getInt("id"));
                productoNuevo.setNombre(rs.getString("nombre"));
                productoNuevo.setDescripcion(rs.getString("descripcion"));
                productoNuevo.setUrl(rs.getString("url"));
                productoNuevo.setPrecio(rs.getDouble("precio"));
                productoNuevo.setCantidad(rs.getInt("cantidad"));
            }
            return productoNuevo;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error:" + ex.fillInStackTrace());
            return null;
        }

    }

    //metodo para traer todos los registros
    public ArrayList<Producto> mostrarTodos() {
        try {
            String consulta = "select * from productos";
            PreparedStatement stm1 = connection.prepareStatement(consulta);
            ResultSet rs = stm1.executeQuery();
            ArrayList<Producto> listaProductos = new ArrayList();
            while (rs.next()) {
                Producto Producto = new Producto();
                Producto.setId(rs.getInt("id"));
                Producto.setNombre(rs.getString("nombre"));
                Producto.setDescripcion(rs.getString("descripcion"));
                Producto.setUrl(rs.getString("url"));
                Producto.setPrecio(rs.getDouble("precio"));
                Producto.setCantidad(rs.getInt("cantidad"));
                listaProductos.add(Producto);
            }
            return listaProductos;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error:" + ex.fillInStackTrace());
            return null;
        }

    }

    //metodo para actualizar
    public boolean actualizarProducto(Producto producto) {
        try {
            String consulta = "update productos " +
                    " set nombre = ?, descripcion=?, url=?, precio=?, cantidad=? where id=? ";
            PreparedStatement stm1 = connection.prepareStatement(consulta);
            stm1.setString(1, producto.getNombre());
            stm1.setString(2, producto.getDescripcion());
            stm1.setString(3, producto.getUrl());
            stm1.setDouble(4, producto.getPrecio());
            stm1.setInt(5, producto.getCantidad());
            stm1.setInt(6, producto.getId());
            stm1.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error:" + ex.fillInStackTrace());
            return false;
        }

    }
    //metodo para borrar (fisico o logico)


    public boolean modificarInventario(Operacion newOperacion) {
        try {

            String consulta = "update productos " +
                    " set cantidad=? where id=? ";
            String consultaSuma = "update productos " +
                    " set cantidad=cantidad+? where id=? ";
            String consultaResta = "update productos " +
                    " set cantidad=cantidad-? where id=? ";
            PreparedStatement stm1 = null;
                if (newOperacion.getOperacion().equals("modificar")) {
                    stm1 = connection.prepareStatement(consulta);
                    stm1.setInt(1, newOperacion.getCantidad());
                    stm1.setInt(2, newOperacion.getId());
                }
                if (newOperacion.getOperacion().equals("agregar")) {
                    stm1 = connection.prepareStatement(consultaSuma);
                    stm1.setInt(1, newOperacion.getCantidad());
                    stm1.setInt(2, newOperacion.getId());

                }
                if (newOperacion.getOperacion().equals("restar")) {
                    stm1 = connection.prepareStatement(consultaResta);
                    stm1.setInt(1, newOperacion.getCantidad());
                    stm1.setInt(2, newOperacion.getId());
                }
                stm1.execute();
                return true;
            } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error:" + ex.fillInStackTrace());
            return false;
        }
    }
}
