package Mundo;

/**
 *
 * @author juand
 */
public class Alumno {
    private String cedula;
    private String nombre;
    private String apellido;
    private int semestre;
    private String correo;
    private String celular;

    public Alumno() {
    }
    
    public Alumno(String cedula, String nombre, String apellido, int semestre, String correo, String celular) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.semestre = semestre;
        this.correo = correo;
        this.celular = celular;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
    
    
    
}
