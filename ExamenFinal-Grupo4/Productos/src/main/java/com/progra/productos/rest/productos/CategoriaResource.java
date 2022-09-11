package com.progra.productos.rest.productos;

import com.progra.productos.entities.Categoria;
import com.progra.productos.services.CategoriaService;
import com.progra.productos.services.CategoriaServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/categories")
public class CategoriaResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Categoria> getCategorias() {
        CategoriaService categoriaService = new CategoriaServiceImpl();
        return categoriaService.listarCategorias();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Categoria getCategoriaId(@PathParam("id") int id) {
        CategoriaService categoriaService = new CategoriaServiceImpl();
        Categoria categoria = new Categoria();
        categoria.setId(id);
        return categoriaService.seleccionarCategoria(categoria);
    }
}
