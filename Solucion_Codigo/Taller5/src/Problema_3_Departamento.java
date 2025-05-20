public class Problema_3_Departamento {
    private int cant_empleados;
    private int produccion_anual;
    private String categoria;
    private String nombre_departamento;
    public Problema_3_Departamento(){}
    public Problema_3_Departamento(int cant_empleados, int produccion_anual
                                    , String nombre_departamento){
        this.cant_empleados = cant_empleados;
        this.produccion_anual = produccion_anual;
        this.nombre_departamento = nombre_departamento;
    }
    public String getNombre_departamento(){
        return this.nombre_departamento;
    }
    public int getCant_empleados(){
        return this.cant_empleados;
    }
    public int getProduccion_anual(){
        return this.produccion_anual;
    }
    public void setNombre_departamento(String nombre_departamento){
        this.nombre_departamento = nombre_departamento;
    }
    public void setCant_empleados(int cant_empleados){
        this.cant_empleados = cant_empleados;
    }
    public void setProduccion_anual(int produccion_anual){
        this.produccion_anual = produccion_anual;
    }
    public void calcularCategoria(){
        if (this.cant_empleados <= 10 && this.produccion_anual <= 500000) {
            this.categoria = "C";
        } else if (this.cant_empleados <= 20 && this.produccion_anual <= 1000000) {
            this.categoria = "B";
        } else if (this.cant_empleados > 20 && this.produccion_anual > 1000000) {
            this.categoria = "A";
        } else {
        this.categoria = "No definida";
    }

    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    @Override
    public String toString(){
        return "Departamento{ "+"nombre: "+this.nombre_departamento+
                " cantidad de empleados: "+this.cant_empleados+
                " produccion anual: "+this.produccion_anual+
                " categoria: "+this.categoria;
    }
}