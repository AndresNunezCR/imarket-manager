package cr.imarket.view;
import javax.swing.*;
import cr.imarket.model.Producto;
import javax.swing.table.DefaultTableModel;
import cr.imarket.controller.ProductoController;
import java.util.ArrayList;

public class MainWindow {

    private JPanel panelPrincipal;
    private JTextField txtNombre;
    private JTextField txtCantidad;
    private JTextField txtCosto;
    private JTextField txtPrecioVenta;
    private JButton btnAgregar;
    private JPanel panelFormulario;
    private JTable tablaProductos;


    private DefaultTableModel modeloTabla;

    //objeto controller para conectar Application -> controller -> view
    private ProductoController controller;

    public MainWindow(ProductoController controller) {

        System.out.println("Entrando al constructor de MainWindow");


        // Guardamos la referencia al Controller recibido
        this.controller = controller;

        JFrame frame = new JFrame("iMarket Manager");

        frame.setContentPane(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);

        String[] columnas = {
                "Nombre", "Cantidad", "Costo", "Precio", "Ganancia unidad", "Ganancia potencial"};

        modeloTabla = new DefaultTableModel(columnas, 0);

        tablaProductos.setModel(modeloTabla);

        frame.setVisible(true);

        // ---------------------------------------------------------

        btnAgregar.addActionListener(e -> {

            // La View lee los datos escritos por el usuario
            String nombre = txtNombre.getText();
            int cantidad = Integer.parseInt(txtCantidad.getText());
            double costo = Double.parseDouble(txtCosto.getText());
            double precioVenta = Double.parseDouble(txtPrecioVenta.getText());

            Producto producto = controller.agregarProducto(
                    nombre,
                    cantidad,
                    costo,
                    precioVenta
            );

            Object[] fila = {
                    producto.getNombre(),
                    producto.getCantidad(),
                    producto.getCostoUnidad(),
                    producto.getPrecioVenta(),
                    producto.calcularGananciaUnidad(),
                    producto.calcularGananciaPotencial()
            };

            modeloTabla.addRow(fila);

            System.out.println("Producto registrado mediante Controller");

        });

        /*
        Usuario hace clic
↓
View detecta evento
↓
View lee JTextField
↓
View llama:
controller.agregarProducto(...)
↓
Controller crea Producto
↓
Controller guarda Producto
↓
Controller devuelve Producto
↓
View recibe Producto
↓
View lo muestra en JTable
         */
    }
}