package com.progra.productos.rest.productos;

import com.progra.productos.entities.Operacion;
import com.progra.productos.entities.Producto;
import com.progra.productos.services.ProductoService;
import com.progra.productos.services.ProductoServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/product")
public class ProductoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Producto> getProducts() {
        ProductoService productoService = new ProductoServiceImpl();
        return productoService.listarProductos();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Producto getProductById(@PathParam("id") int id) {
        ProductoService productoService = new ProductoServiceImpl();
        Producto producto = new Producto();
        producto.setId(id);
        return productoService.seleccionarProducto(producto);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveProduct(Producto producto) {
        ProductoService productoService = new ProductoServiceImpl();
       // if(productoService.insertarProducto(producto)){
            //si descomentas este codigo, podras obtener el objeto con el nuevo id, desde la BD
            int codigo = productoService.insertarProductoConRetorno(producto);
            if(codigo != -1) {
                producto.setId(codigo);
                Producto producto1 = productoService.seleccionarProducto(producto);
                return Response.ok(producto1, MediaType.APPLICATION_JSON).build();
            }else{
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
       // };
       //
    }


    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProduct(@PathParam("id") int id, Producto producto) {
        ProductoService productoService = new ProductoServiceImpl();
        producto.setId(id);
        if(productoService.actualizarProducto(producto)){
            return Response.ok(producto, MediaType.APPLICATION_JSON).build();
        };
        throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }

    @PATCH
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificarInventario(@PathParam("id") int id, Operacion operacion) {
        ProductoService productoService = new ProductoServiceImpl();
        operacion.setId(id);
        if(productoService.modificarInventario(operacion)){
            return Response.ok(operacion, MediaType.APPLICATION_JSON).build();
        };
        throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }
}