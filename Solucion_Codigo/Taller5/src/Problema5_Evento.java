import java.time.LocalDate;
import java.util.ArrayList;

public class Problema5_Evento {
    public String nombre;
    public LocalDate fecha;
    public String ubicacion;
    public String descripcion;
    public boolean usoArmasNucleares;
    public ArrayList<Problema5_Pais> paises;

    public Problema5_Evento() {
    }
    
    public Problema5_Evento(String nombre, LocalDate fecha, String ubicacion, String descripcion, boolean usoArmasNucleares, ArrayList<Problema5_Pais> paises) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.usoArmasNucleares = usoArmasNucleares;
        this.paises = paises;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean UsoArmasNucleares() {
        return usoArmasNucleares;
    }

    public ArrayList<Problema5_Pais> getPaises() {
        return paises;
    }

    @Override
    public String toString() {
        return nombre + " (" + fecha + ") en " + ubicacion + 
               " | Nuclear: " + usoArmasNucleares;
    }
}