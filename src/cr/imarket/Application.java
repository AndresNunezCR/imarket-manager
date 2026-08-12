package cr.imarket;
import cr.imarket.model.Producto;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args){

        System.out.print("iMarket Manager iniciado correctamente\n");

        ArrayList<Producto> productos = new ArrayList<>();

        Producto producto1 = new Producto("iPhone 15 Pro Max", 2, 720, 790);
        Producto producto2 = new Producto("Apple Watch SE 3 44mm", 1, 200, 255);

        productos.add(producto1);
        productos.add(producto2);


        for (Producto producto : productos ){
        System.out.println("Producto: " + producto.getNombre());
        System.out.println("Cantidad: " + producto.getCantidad());
        System.out.println("Ganancia unidad: " + producto.calcularGananciaUnidad());
        System.out.println("Ganancia potencial: " + producto.calcularGananciaPotencial());
        System.out.println("---------------------------");
    }


    }
}
