package org.dflorestrejo.poointerfaces;

import org.dflorestrejo.poointerfaces.modelo.Cliente;
import org.dflorestrejo.poointerfaces.repositorio.*;
import org.dflorestrejo.poointerfaces.repositorio.excepciones.*;
import org.dflorestrejo.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        try {

            OrdenablePaginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio();
            repo.crear(new Cliente("Jano", "Pérez"));
            repo.crear(new Cliente("Bea", "Gonzales"));
            repo.crear(new Cliente("Lucia", "Martinez"));
            repo.crear(new Cliente("Daniel", "Flores"));
//            Cliente daniel = new Cliente("Daniel", "Flores");
//            repo.crear(daniel);
//            repo.crear(daniel);

            List<Cliente> clientes = repo.listar();

            clientes.forEach(System.out::println);

            List<Cliente> paginable = repo.listar(1, 3);
            System.out.println("===== Paginable =====");
            paginable.forEach(System.out::println);

            System.out.println("===== Ordenar =====");
            List<Cliente> clienteOrenarAsc = repo.listar("nombre", Direccion.ASC);
            clienteOrenarAsc.forEach(System.out::println);

            System.out.println("===== Editar =====");
            Cliente beaActualizar = new Cliente("Bea", "Mena");
            beaActualizar.setId(2);
            repo.editar(beaActualizar);
            repo.listar().forEach(System.out::println);

            System.out.println("===== Eliminar =====");
            repo.eliminar(2);
            repo.listar().forEach(System.out::println);

            System.out.println("===== Total =====");
            System.out.println("Total de registro: " + repo.total());
        } catch (LecturaAccesoDatoException e) {
            System.out.println("Lectura: " + e.getMessage());
            e.printStackTrace(System.out);
        } catch (EscrituraAccesoDatoException e) {
            System.out.println("Escritura: " + e.getMessage());
            e.printStackTrace(System.out);
        } catch (AccesoDatoException e) {
            System.out.println("Genérica: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }
}
