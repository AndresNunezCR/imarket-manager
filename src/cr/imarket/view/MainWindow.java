package cr.imarket.view;
import javax.swing.*;
import cr.imarket.model.Producto;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class MainWindow {

    private JPanel panelPrincipal;
    private JTextField txtNombre;
    private JTextField txtCantidad;
    private JTextField txtCosto;
    private JTextField txtPrecioVenta;
    private JButton btnAgregar;
    private JPanel panelFormulario;
    private JTable tablaProductos;

    private ArrayList<Producto> productos = new ArrayList<>();

    private DefaultTableModel modeloTabla;

    public MainWindow(){

        JFrame frame = new JFrame("iMarket Manager");

        // Definimos las columnas de la tabla
        String[] columnas = {
                "Nombre",
                "Cantidad",
                "Costo",
                "Precio",
                "Ganancia unidad",
                "Ganancia potencial"
        };

// Creamos el modelo vacío
        modeloTabla = new DefaultTableModel(columnas, 0);

// Conectamos el modelo con la JTable visual
        tablaProductos.setModel(modeloTabla);

        btnAgregar.addActionListener(e -> {

            // Leemos lo que escribió el usuario
            String nombre = txtNombre.getText();

            int cantidad = Integer.parseInt(txtCantidad.getText());
            double costo = Double.parseDouble(txtCosto.getText());
            double precioVenta = Double.parseDouble(txtPrecioVenta.getText());

            // Creamos el producto con esos datos
            Producto producto = new Producto(
                    nombre,
                    cantidad,
                    costo,
                    precioVenta
            );

            productos.add(producto);

            // Creamos una fila con los datos del producto
            Object[] fila = {
                    producto.getNombre(),
                    producto.getCantidad(),
                    producto.getCostoUnidad(),
                    producto.getPrecioVenta(),
                    producto.calcularGananciaUnidad(),
                    producto.calcularGananciaPotencial()
            };

// Agregamos la fila a la tabla
            modeloTabla.addRow(fila);

            // Por ahora mostramos el resultado en consola
            System.out.println("Producto agregado: " + producto.getNombre());
            System.out.println("Ganancia por unidad: " + producto.calcularGananciaUnidad());
            System.out.println("Ganancia potencial: " + producto.calcularGananciaPotencial());
            System.out.println("Productos registrados: " + productos.size());
        });


        frame.setContentPane(panelPrincipal);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(500,300);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
