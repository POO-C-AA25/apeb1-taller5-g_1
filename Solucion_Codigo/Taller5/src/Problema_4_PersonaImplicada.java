public class Problema_4_PersonaImplicada {
    private String nombre;
    private byte edad;
    private String ocupacion;
    private String implicacion; 
    private boolean sentenciaMenorUnAnio; 
    private boolean colabora; 
    private boolean confiesa; 
    private double danoEconomico; 
    public Problema_4_PersonaImplicada(String nombre, byte edad, String ocupacion, String implicacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.ocupacion = ocupacion;
        this.implicacion = implicacion;
        this.sentenciaMenorUnAnio = false;
        this.colabora = false;
        this.confiesa = false;
        this.danoEconomico = 0.0;
    }
    public String getNombre() {
        return this.nombre;
    }
    public byte getEdad() { 
        return this.edad;
    }
    public String getOcupacion() {
        return this.ocupacion;
    }
    public String getImplicacion() { 
        return this.implicacion;
    }
    public boolean isSentenciaMenorUnAnio() { 
        return this.sentenciaMenorUnAnio;
    }
    public boolean isColabora() {
        return this.colabora;
    }
    public boolean isConfiesa() { 
        return this.confiesa;
    }
    public double getDanoEconomico() { 
        return this.danoEconomico;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(byte edad) { 
        this.edad = edad;
    }
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    public void setImplicacion(String implicacion) { 
        this.implicacion = implicacion;
    }
    public void setSentenciaMenorUnAnio(boolean sentenciaMenorUnAnio) {
        this.sentenciaMenorUnAnio = sentenciaMenorUnAnio;
    }
    public void setColabora(boolean colabora) {
        this.colabora = colabora;
    }
    public void setConfiesa(boolean confiesa) {
        this.confiesa = confiesa;
    }
    public void setDanoEconomico(double danoEconomico) { 
        this.danoEconomico = danoEconomico;
    }
    public boolean aplicarReduccion() { 
        return "acusado".equals(this.implicacion) && this.confiesa;
    }
    public double calcularFianza() { 
        if ("acusado".equals(this.implicacion) && this.sentenciaMenorUnAnio && this.colabora) {
            return this.danoEconomico * 0.50;
        }
        return 0.0;
    }
    @Override
    public String toString() {
        String resultado = "";
        resultado = resultado + "Persona: " + this.nombre;
        resultado = resultado + " (Edad: " + this.edad;
        resultado = resultado + ", Ocupación: " + this.ocupacion;
        resultado = resultado + ", Nivel: " + this.implicacion + ")";
        if ("acusado".equals(this.implicacion)) {
            resultado = resultado + "\n    -> Sentencia < 1 año: " + (this.sentenciaMenorUnAnio ? "Sí" : "No");
            resultado = resultado + ", Colabora: " + (this.colabora ? "Sí" : "No");
            resultado = resultado + ", Confiesa: " + (this.confiesa ? "Sí" : "No");
            resultado = resultado + ", Daño Económico: $" + this.danoEconomico;
            if (aplicarReduccion()) {
                resultado = resultado + " (Aplica reducción de pena)";
            }
            double fianza = calcularFianza();
            if (fianza > 0) {
                resultado = resultado + " (Fianza aplicable: $" + fianza + ")";
            }
        }
        return resultado;
    }
}