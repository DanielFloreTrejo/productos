import java.text.SimpleDateFormat;
import java.util.Date;

public class OrdenCompra {

    private int identificador;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private Producto[] productos;
    private int indice;
    private static int contador;
    private static final int MAX_ITEMS = 4;

    public OrdenCompra(String descripcion) {
        this.descripcion = descripcion;
        this.productos = new Producto[MAX_ITEMS];
        this.identificador = ++contador;
        this.fecha = new Date();
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void addProducto(Producto producto) {
        if (this.indice < MAX_ITEMS) {
            this.productos[this.indice++] = producto;
        }
    }

    public float getGranTotal() {
        float total = 0.0f;
        for (Producto pro: productos) {
            total += pro.getPrecio();
        }
        return total;
    }

    public String getDetalleGeneral() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        StringBuilder sb = new StringBuilder("Factura n°: ");
        sb.append(this.identificador)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t")
                .append(this.cliente.getApellido())
                .append("\nFecha de Factura: ")
                .append(sdf.format(this.fecha))
                .append("\n")
                .append("\n#Fabr.\tNombre\t$");

        for (int i = 0; i < indice; i++) {
            sb.append(this.productos[i].toString());
        }

        sb.append("\nTotal Final: ")
                .append(getGranTotal());

        return sb.toString();
    }
}
