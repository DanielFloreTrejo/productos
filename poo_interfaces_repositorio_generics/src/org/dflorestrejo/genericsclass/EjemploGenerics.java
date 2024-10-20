package org.dflorestrejo.genericsclass;

public class EjemploGenerics {
    public static void main(String[] args) {

        Camion<Animal> transporteCaballos = new Camion<>(5);
        transporteCaballos.add(new Animal("Peregrino", "Caballo"));
        transporteCaballos.add(new Animal("Grilla", "Caballo"));
        transporteCaballos.add(new Animal("Tunquen", "Caballo"));
        transporteCaballos.add(new Animal("Topocalma", "Caballo"));
        transporteCaballos.add(new Animal("Longotoma", "Caballo"));

        imprimirCamion(transporteCaballos);

        Camion<Maquinaria> transportarMaquinaria = new Camion<>(3);
        transportarMaquinaria.add(new Maquinaria("Bulldozer"));
        transportarMaquinaria.add(new Maquinaria("Grúa Horquilla"));
        transportarMaquinaria.add(new Maquinaria("Perforadora"));

        imprimirCamion(transportarMaquinaria);

        Camion<Automovil> transportarAutomovil = new Camion<>(3);
        transportarAutomovil.add(new Automovil("Toyota"));
        transportarAutomovil.add(new Automovil("Mitsubishi"));
        transportarAutomovil.add(new Automovil("Chevrolet"));

        imprimirCamion(transportarAutomovil);

    }

    public static <T> void imprimirCamion(Camion<T> camion) {
        for (T a : camion) {
            if (a instanceof Animal) {
                System.out.println("Nombre: " + ((Animal) a).getNombre() + ", tipo: " + ((Animal) a).getTipo());
            }
            if (a instanceof Maquinaria) {
                System.out.println("Maquina: " + ((Maquinaria) a).getTipo());
            }
            if (a instanceof Automovil) {
                System.out.println("Marcar: " + ((Automovil) a).getMarca());
            }
        }
    }
}
