import java.util.ArrayList;
import java.util.List;
public class Problema_3_Empresa {
    public List<Problema_3_Departamento> listaDepartamento;
    public String nombre_empresa;
    public String ruc;
    public String direccion;
    public Problema_3_Empresa(String nombre_empresa, String ruc, 
                                String direccion){
        this.nombre_empresa = nombre_empresa;
        this.ruc = ruc;
        this.direccion = direccion;
        this.listaDepartamento = new ArrayList<>();
    }
    public String getNombre_empresa() {
        return this.nombre_empresa;
    }
    public String getRuc() {
        return this.ruc;
    }
    public String getDireccion() {
        return this.direccion;
    }
    public List<Problema_3_Departamento> getListaDepartamentos() {
        return this.listaDepartamento;
    }
    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void agregarDepartamento(Problema_3_Departamento departamento) {
        if (departamento != null) {
            this.listaDepartamento.add(departamento);
            System.out.println("Departamento:" + departamento.getNombre_departamento() 
            + " agregado a la empresa: " + this.nombre_empresa);
        }
    }
    @Override
    public String toString(){
        String mensaje;
        if (listaDepartamento.isEmpty()) {
            mensaje = "No hay departamentos registrados.";
        } else {
            mensaje = "";
            for (Problema_3_Departamento depa : this.listaDepartamento) {
                mensaje += depa.toString() + "\n";
            }
        }
        return "Empresa: " + this.nombre_empresa +
            "\nRUC: " + this.ruc +
            "\nDirección: " + this.direccion +
            "\nDepartamentos:\n" + mensaje;
    }
}
