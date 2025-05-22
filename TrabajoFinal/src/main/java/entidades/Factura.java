package entidades;

import interfaz.Carrito;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuarioDAW
 */
public class Factura {

    protected List<Productos> factura;
    protected LocalDate fecha;

    public Factura(List<Productos> factura, LocalDate fecha) {
        this.factura = new ArrayList();
        this.fecha = LocalDate.now();
    }

    public void llenarFactura(Productos producto) {
        factura.add(producto);
    }

    public List<Productos> getFactura() {
        return factura;
    }

    public void vaciarFactura() {
        factura.clear();
    }

    public void descargarFactura(Cliente cliente) {
        try {
            BufferedWriter imprFactura = new BufferedWriter(new FileWriter("factura.txt"));
            String contenido = "";
            contenido = "##########   FACTURA GAME    ##########\n";
            contenido += "Fecha: "+fecha+"\n";
            contenido += "Cliente: "+ cliente.getNombre()+" "+cliente.getApellidos()+"\n";
            contenido += "Usuario: "+ cliente.getNombreUsuario()+"\n";
            contenido += "########################################"+"\n";
            contenido += ""+"\n";
            contenido += "Productos"+"\n";
            double total=0.0;
            for(Productos p : factura){
                contenido += "Nombre: "+p.getNombre()+"\n";
                contenido += "Precio: "+p.getPrecio()+"\n";
                total+=p.getPrecio();
            }
            contenido += "Precio Total: "+total;
            imprFactura.write(contenido);
        } catch (IOException e) {
            System.out.println("error al escribir el archivo: " + e.getMessage());
        }
    }

}
