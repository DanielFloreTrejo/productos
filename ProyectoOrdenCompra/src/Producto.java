public class Producto {
    private String fabricante;
    private String nombre;
    private float precio;

    public Producto(String fabricante, String nombre, float precio) {
        this.fabricante = fabricante;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "\n" + fabricante +
                "\t" + nombre +
                "\t" + precio;
    }
}
