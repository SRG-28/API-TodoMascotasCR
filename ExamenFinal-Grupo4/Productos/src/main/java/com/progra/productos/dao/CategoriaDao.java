package com.progra.productos.dao;

import com.progra.productos.entities.Categoria;
import com.progra.productos.utils.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaDao {
    public final static Connection connection = Conexion.getConnection();

    //metodo para buscar
    public Categoria seleccionarCategoria(Categoria categoria) {
        try {
            String consulta = "select * from categorias where id = ? ";
            PreparedStatement stm1 = connection.prepareStatement(consulta);
            stm1.setInt(1, categoria.getId());
            ResultSet rs = stm1.executeQuery();
            Categoria categoriaNueva = null;
            while (rs.next()) {
                categoriaNueva = new Categoria();
                categoriaNueva.setId(rs.getInt("id"));
                categoriaNueva.setDescripcion(rs.getString("descripcion"));
            }
            return categoriaNueva;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error:" + ex.fillInStackTrace());
            return null;
        }

    }

    //metodo para traer todos los registros
    public ArrayList<Categoria> mostrarTodosCategorias() {
        try {
            String consulta = "select * from categorias";
            PreparedStatement stm1 = connection.prepareStatement(consulta);
            ResultSet rs = stm1.executeQuery();
            ArrayList<Categoria> listaCategorias = new ArrayList();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setDescripcion(rs.getString("descripcion"));
                listaCategorias.add(categoria);
            }
            return listaCategorias;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error:" + ex.fillInStackTrace());
            return null;
        }

    }
}
