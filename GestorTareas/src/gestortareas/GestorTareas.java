
package gestortareas;
import utilidades.consola;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class GestorTareas {
    ListaOrdenada listaOrdenada;
    public GestorTareas(){
        listaOrdenada = new ListaOrdenada();
    }

    public void AgregarTarea(){
        int opcion = -1;
        while (opcion != 0){
            Tareas tareas = new Tareas();
            tareas.CargarDatos();
            listaOrdenada.Insertar(tareas);
            opcion = consola.readInt(0, "Ingrese un numero (0 para terminar): ");

        }
    }
    
    public void MostrarTareas(){
        if (listaOrdenada.ListaVacia()){
            System.out.println("No hay tareas registradas");
        }else{
            Nodo p = listaOrdenada.inicio();
            System.out.println("--------Tareas--------");
            while (p != null){
                Tareas tareas = p.getDato();
                tareas.Mostrar();
                p = p.getPs();
            }
        }
        
    }
    
    public void Menu(){
        int opcion;
        do{
            System.out.println("");
            System.out.println("1. Agregar Tarea");
            System.out.println("2. Mostrar tareas");
            System.out.println("3. Marcar una tarea completada");
            System.out.println("4. Editar una tarea");
            System.out.println("5. Eliminar una tarea");
            System.out.println("6. Filtrar tareas proximas");
            System.out.println("7. Ordenar por fecha limite las tareas");
            System.out.println("0. salir");
            System.out.println("Ingrese la opcion");
            opcion = consola.readInt(0, "=> ");
            switch(opcion){
                case 1:
                    AgregarTarea();
                    break;
                case 2:
                    MostrarTareas();
                    break;
                case 3:
                    MarcarTareaCompletada();
                    break;
                case 4:
                    ActualizarTarea();
                    break;
                case 5:
                    EliminarUnaTarea();
                    break;
                case 6:
                    FiltrarTareas();
                    break;
                case 7:
                    OrdenarPorFecha();
                    break;
                case 0:
                    break;
            }
        }while (opcion != 0);
    }

    public void OrdenarPorFecha(){
        if (listaOrdenada.ListaVacia()){
            System.out.println("Lista vacia");

        }else{
            listaOrdenada.ordenar_Fecha2();
            Nodo p = listaOrdenada.inicio();
            System.out.println("--------Tareas--------");
            while (p != null){
                Tareas t = p.getDato();
                t.Mostrar();
                p = p.getPs();
            }
        }

    }


    public void FiltrarTareas(){
        if (listaOrdenada.ListaVacia()){
            System.out.println("Lista vacia");
            return;
        }
        String fecha = consola.readString("Ingrese mes y año en formato (MM/yyyy): ");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/yyyy");
        LocalDate fechalimite = LocalDate.parse("01/" + fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int mes = fechalimite.getMonthValue();
        int anio = fechalimite.getYear();
        Nodo p = listaOrdenada.inicio();
        System.out.println("--------Tareas--------");
        while (p != null){
            Tareas t = p.getDato();
            if (t.getEstado() == 1 || t.getEstado() == 0){
                if (t.getFechalimite().getMonthValue() == mes && t.getFechalimite().getYear() == anio){
                    t.Mostrar();
                }

            }
            p = p.getPs();
        }
    }

    public void MarcarTareaCompletada(){
        if (listaOrdenada.ListaVacia()){
            System.out.println("No hay tareas");
            return;
        }
        Tareas t = new Tareas();
        t.CargarID();
        Nodo x = listaOrdenada.BuscarCod(t);
        if (x != null){
            t = x.getDato();
            t.setEstado(0);
           
        }else{
            System.out.println("Tarea no encontrada");
        }
        
    }
    
    public void ActualizarTarea(){
        if (listaOrdenada.ListaVacia()){
            System.out.println("No hay tareas");
            return;
        }
        System.out.println("Aqui podra modificar una tarea");
        Tareas t = new Tareas();
        t.CargarID();
        Nodo x = listaOrdenada.BuscarCod(t);
        if (x != null){
            t = x.getDato();
            t.MenuModificador(t);
        }else{
            System.out.println("Tarea no encontrada");
        }
    }
    
    public void EliminarUnaTarea(){
        if (listaOrdenada.ListaVacia()){
            System.out.println("No hay tareas");
            return;
        }
        System.out.println("Aqui podrá eliminar una tarea");
        Tareas t = new Tareas();
        t.CargarID();
        Nodo x = listaOrdenada.eliminar(t);
        if (x == null){
            System.out.println("Tarea no encontrada");
        }
    }
    
    public static void main(String[] args) {
        GestorTareas GT = new GestorTareas();
        GT.Menu();
    }
    
}
