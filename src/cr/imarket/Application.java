package cr.imarket;
import cr.imarket.view.MainWindow;
import cr.imarket.controller.ProductoController;


public class Application {

    public static void main(String[] args) {

        // Creamos el Controller
        ProductoController controller = new ProductoController();


        // Creamos la View y le entregamos el Controller
        new MainWindow(controller);

    }
}

/*
Application inicia
      ↓
crea ProductoController
      ↓
guarda su referencia en "controller"
      ↓
crea MainWindow
      ↓
le pasa esa misma referencia
      ↓
MainWindow ahora puede hablar con el Controller
 */


/*
USUARIO
↓
btnAgregar
↓
ActionListener
↓
MainWindow lee campos
↓
controller.agregarProducto(...)
↓
ProductoController crea Producto
↓
Controller lo guarda en ArrayList
↓
MainWindow consulta controller.getProductos()
↓
MainWindow actualiza JTable
 */