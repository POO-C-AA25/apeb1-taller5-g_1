public class Problema_2_Materia {
    private String nombremateria;
    private double calificacion_acd;
    private double calificacion_ape;
    private double calificacion_aa;
    private double notaFinal;
    public Problema_2_Materia() {}
    public Problema_2_Materia(String nombremateria, double calificacion_aa,
                    double calificacion_acd, double calificacion_ape){
        this.nombremateria = nombremateria;
        this.calificacion_aa = calificacion_aa;
        this.calificacion_acd = calificacion_acd;
        this.calificacion_ape = calificacion_ape;
    }
    public String getNombremateria(){
        return this.nombremateria;
    }
    public double getCalificacion_acd(){
        return this.calificacion_acd;
    }
    public double getCalificacion_aa(){
        return this.calificacion_aa;
    }
    public double getCalificacion_ape(){
        return this.calificacion_ape;
    }
    public void setNombrmateria(String nombremateria){
        this.nombremateria = nombremateria;
    }
    public void setCalificacion_acd(double calificacion_acd){
        this.calificacion_acd = calificacion_acd;
    }
    public void setCalificacion_ape(double calificacion_ape){
        this.calificacion_ape = calificacion_ape;
    }
    public void setCalificacion_aa(double calificacion_aa){
        this.calificacion_aa = calificacion_aa;
    }
    public double calcularNotaFinal(){
        this.notaFinal = this.calificacion_aa + this.calificacion_acd + this.calificacion_ape;
        return this.notaFinal;
    }
    public void calcularRecuperacion(){
        double notaAprobacion = 7;
        if(this.notaFinal < notaAprobacion){
            this.notaFinal = (this.notaFinal * 0.6) + 3.5;
        }
    }
    public boolean verificarAprobacion(){
        return this.notaFinal >= 7.00;
    }
    @Override
    public String toString() {
        return "Materia{" +
                "nombre='" + this.nombremateria +
                ", calificacion_acd=" + this.calificacion_acd +
                ", calificacion_aper=" + this.calificacion_ape +
                ", calificacion_aa=" + this.calificacion_aa +
                ", notaFinal=" + this.notaFinal +
                "}";
    }
}