package cr.imarket.model;

public class Producto {

    private String nombre;
    private int cantidad;
    private double costoUnidad;
    private double precioVenta;

    //Constructor:
    public Producto(String nombre, int cantidad, double costoUnidad, double precioVenta){
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costoUnidad = costoUnidad;
        this.precioVenta = precioVenta;
    }

    //Ganancia por Unidad
    public double calcularGananciaUnidad(){
        return precioVenta - costoUnidad;
    }

    //Ganacia estimada al vender inventario
    public double calcularGananciaPotencial(){
        return calcularGananciaUnidad() * cantidad;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getCostoUnidad() {
        return costoUnidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

}
