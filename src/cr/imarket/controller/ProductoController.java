package cr.imarket.controller;
import cr.imarket.model.Producto;
import java.util.ArrayList;


public class    ProductoController {

        // El Controller mantiene la lista de productos
        private ArrayList<Producto> productos;

        public ProductoController() {

            // Al iniciar el sistema, la lista empieza vacía
            productos = new ArrayList<>();
        }

        public Producto agregarProducto(String nombre, int cantidad, double costo, double precioVenta) {

            // Creamos el objeto del Model
            Producto producto = new Producto(
                    nombre,
                    cantidad,
                    costo,
                    precioVenta
            );

            // Lo guardamos en memoria
            productos.add(producto);

            return producto;
        }

        public ArrayList<Producto> getProductos() {
            return productos;
        }
    }

