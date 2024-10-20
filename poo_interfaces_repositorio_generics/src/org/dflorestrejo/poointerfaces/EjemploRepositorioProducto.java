package org.dflorestrejo.poointerfaces;


import org.dflorestrejo.poointerfaces.modelo.Producto;
import org.dflorestrejo.poointerfaces.repositorio.Direccion;
import org.dflorestrejo.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;
import org.dflorestrejo.poointerfaces.repositorio.excepciones.*;
import org.dflorestrejo.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {

        try {

            OrdenablePaginableCrudRepositorio<Producto> repo = new ProductoListRepositorio();
            repo.crear(new Producto("Mesa", 50.52));
            repo.crear(new Producto("Silla", 18.0));
            repo.crear(new Producto("Lámpara", 15.5));
            repo.crear(new Producto("Notebook", 400.89));

            List<Producto> productos = repo.listar();

            productos.forEach(System.out::println);

            List<Producto> paginable = repo.listar(1, 3);
            System.out.println("===== Paginable =====");
            paginable.forEach(System.out::println);

            System.out.println("===== Ordenar =====");
            List<Producto> productoOrdenAsc = repo.listar("precio", Direccion.ASC);
            productoOrdenAsc.forEach(System.out::println);

            System.out.println("===== Editar =====");
            Producto escritorio = new Producto("Escritorio de oficina", 500.0);
            escritorio.setId(1);
            repo.editar(escritorio);
            repo.listar().forEach(System.out::println);

            System.out.println("===== Eliminar =====");
            repo.eliminar(2);
            repo.listar().forEach(System.out::println);

            System.out.println("===== Total =====");
            System.out.println("Total de registro: " + repo.total());
        } catch (LecturaAccesoDatoException e) {
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        } catch (AccesoDatoException e) {
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        }
    }
}
