package entidades;

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

    public Factura() {
        this.factura = new ArrayList();
        this.fecha = LocalDate.now();
    }

    public void llenarFactura(Productos producto) {
        factura.add(producto);
    }

    public List<Productos> getFactura() {
        return factura;
    }

    public void descargarFactura(Cliente cliente) {
        try {
            BufferedWriter imprFactura = new BufferedWriter(new FileWriter("factura.txt"));
            String contenido = "";
            contenido = "##########   FACTURA GAME    ##########\n";
            contenido += factura.toString();
            imprFactura.write(contenido);
        } catch (IOException e) {
            System.out.println("error al escribir el archivo: " + e.getMessage());
        }
    }

}
