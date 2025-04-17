
package gestortareas;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import utilidades.consola;

public class Tareas {
    private String nombre;
    private String descripcion;
    private LocalDate fechalimite;
    private int iD;
    private int estado; // 1: Pendiente, 2: En progreso, 0: Completada

    public Tareas() {
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechalimite() {
        return fechalimite;
    }

    public void setFechalimite(LocalDate fechalimite) {
        this.fechalimite = fechalimite;
    }

    public int getID() {
        return iD;
    }

    public void setID(int ID) {
        this.iD = ID;
    }

    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public void CargarDatos(){
        CargarNombre();
        CargarDescripcion();
        CargarFecha();
        setEstado(1);
        CargarID();
    }
    
    public void CargarID(){
        int id = consola.readInt(0, "Ingrese identificador de la tarea: ");
        this.iD = id;
    }
    
    public void CargarNombre(){
        String nom = consola.readString("Ingrese nombre de la tarea: ");
        this.nombre = nom;
    }
    public void CargarDescripcion(){
        String des = consola.readString("Ingrese descripcion de la tarea: ");
        this.descripcion = des;
    }
    public void CargarFecha(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = null;
        while (fecha == null){
            try{
                String fecha_texto = consola.readString("Ingrese la fecha limite con el formato (dia/mes/año)");
                fecha = LocalDate.parse(fecha_texto, formato);
            }catch (DateTimeException e){
                System.out.println("Error: formato incorrecto, intente denuevo con (dd/MM/yyyy)");
            }
        }
        this.fechalimite = fecha;
    }
    
    public boolean esMayorIgualQue(Tareas x){
        return this.fechalimite.isAfter(x.getFechalimite()) || this.fechalimite.isEqual(x.getFechalimite());
    }
    public boolean esIgualQue(Tareas x){
        return this.fechalimite.isEqual(x.getFechalimite());
    }

    public boolean esMayorIgualQueID(Tareas x){
        return this.iD >= x.getID();
    }

    public boolean esIgualQueID(Tareas x){
        return this.iD == x.getID();
    }
    
    public void MenuModificador(Tareas t){
        int opcion;
        do{
            System.out.println("1.Modificar nombre de la tarea");
            System.out.println("2.Modificar descripcion de la tarea");
            System.out.println("3.Modificar fecha de la tarea");
            System.out.println("4.Modificar identificador de la tarea");
            System.out.println("0.Salir");
            opcion = consola.readInt(0, "Ingrese la opcion: ");
            switch(opcion){
                case 1:
                    t.setNombre(consola.readString("Ingrese nuevo nombre de la tarea: "));
                    System.out.println("Cambio realizado!!");
                    break;
                case 2:
                    t.setDescripcion(consola.readString("Ingrese nueva descripcion de la tarea: "));
                    System.out.println("Cambio realizado!!");
                    break;
                case 3:
                    System.out.println("Ingresar nueva fecha limite: ");
                    t.CargarFecha();
                    this.fechalimite = t.getFechalimite();
                    System.out.println("Cambio realizado!!");
                    break;
                case 4:
                    t.setID(consola.readInt(0, "Ingrese nuevo identificador de la tarea: "));
                    System.out.println("Cambio realizado!!");
                case 0:
                    break;
            }
        }while (opcion != 0);
    }
    
    
    

    public void Mostrar(){
        System.out.println(Impresion());
    }
    
    public String Impresion(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String salida = String.format("| Nombre: %-20s | Descripcion: %-20s | "
                + "Fecha limite: %-15s | Identificador: %-15d | Estado: %d", nombre, descripcion, fechalimite.format(formato), iD,
                estado);
        return salida;
    }
    
    
//    @Override
//    public String toString() {
//        return "Tareas: " + "nombre: " + nombre + ", descripcion: " + descripcion + ", fecha limite: " + fechalimite +
//                "identificador: " + iD + ", estado: " + estado;
//    }
    
    
}
