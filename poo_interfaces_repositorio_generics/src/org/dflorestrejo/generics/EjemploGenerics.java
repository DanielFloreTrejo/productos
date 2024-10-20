package org.dflorestrejo.generics;

import org.dflorestrejo.poointerfaces.modelo.Cliente;
import org.dflorestrejo.poointerfaces.modelo.ClientePremium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenerics {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Andrés", "Guzmán"));
        Cliente andres = clientes.iterator().next();

        Cliente[] clienteArray = {new Cliente("Luci", "Martinez"),
                new Cliente("Andrés", "Guzmán")};

        Integer[] enteroArray = {1, 2, 3};

        List<Cliente> clientesLista = fromArrayToList(clienteArray);

        List<Integer> enterosList = fromArrayToList(enteroArray);

        clientesLista.forEach(System.out::println);

        enterosList.forEach(System.out::println);

        List<String> nombre = fromArrayToList(new String[]{"Andrés", "Pepe", "Luci", "Bea", "John"}, enteroArray);
        nombre.forEach(System.out::println);

        List<ClientePremium> clientePremiums = fromArrayToList(new ClientePremium[]{
                new ClientePremium("Paco", "Fernandez")});

        imprimirCliente(clientes);
        imprimirCliente(clientesLista);
        imprimirCliente(clientePremiums);

        System.out.println("Máximo de 1, 9 y 4 es: " + maximo(1, 9, 4));
        System.out.println("Máximo de 3.9, 11.6 y 7.78 es: " + maximo(3.9, 11.6, 7.78));
        System.out.println("Máximo de zanahoria, arándanos y manzana es: " + maximo("zanahoria",
                "arándanos", "manzana"));
    }

    public static <T> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T extends Number> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T extends Cliente, G> List<T> fromArrayToList(T[] c, G[] x) {
        for (G elemento : x) {
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }

    public static <T, G> List<T> fromArrayToList(T[] c, G[] x) {
        for (G elemento : x) {
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }

    public static void imprimirCliente(List<? extends Cliente> clientes) {
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }

        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }
}
