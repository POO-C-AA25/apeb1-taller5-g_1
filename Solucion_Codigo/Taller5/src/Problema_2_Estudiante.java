public class Problema_2_Estudiante{
    private String nombre;
    private byte edad;
    private String materia_a_cursar;
    public Problema_2_Estudiante(){}
    public Problema_2_Estudiante(String nombre, byte edad, String materia_a_cursar){
        this.nombre = nombre;
        this.edad = edad;
        this.materia_a_cursar = materia_a_cursar;
    }
    public String getNombre(){
        return this.nombre;
    }
    public byte getEdad(){
        return this.edad;
    }
    public String getMateria_a_cursar(){
        return this.materia_a_cursar;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setEdad(byte edad){
        this.edad = edad;
    }
    public void setMateria_a_cursar(String materia_a_cursar){
        this.materia_a_cursar = materia_a_cursar;
    }
    @Override
    public String toString(){
        return "Estudiante { nombre: " + this.nombre + " edad: " + this.edad + 
                " materia a cursar: " + this.materia_a_cursar + " }";
    }
}