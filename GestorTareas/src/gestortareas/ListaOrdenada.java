
package gestortareas;


public class ListaOrdenada extends ListaSimple {
    public ListaOrdenada() {
        super();
    }
    public void InsertarAlMedio(Nodo p, Nodo a, Nodo x){
        a.setPs(x);
        x.setPs(p);
    }
    public void InsertarAlFinal(Nodo p, Nodo a, Nodo x){
        if (p == null){
            a.setPs(x);
            x.setPs(null);
        }
    }

    public void Insertar(Tareas v){
        Nodo p = list;
        Nodo ant = null;
        int b = 0;
        int existe = 0;
        while (p != null && b == 0){
            Tareas tareas = p.getDato();
            if (tareas.esMayorIgualQueID(v)){
                if (tareas.esIgualQueID(v)){
                    existe = 1;
                }else{
                    b = 1;
                }
            }else{
                ant = p;
                p = p.getPs();
            }
        }
        if (existe == 1){
            System.out.println("codigos iguales");
        }else{
            Nodo x = new Nodo(v);
            if (b == 1){
                if (p == list){
                    InsertarAlPrincipio(v);
                }else{
                    InsertarAlMedio(p,ant,x);
                }
            }else{
                if (ant == null){
                    list = x;
                }else{
                    InsertarAlFinal(p,ant,x);
                }
            }
        }
    }

    public void ordenar_Fecha() {
        if (list == null || list.getPs() == null) {
            return;
        }
        boolean desordenado;

        do {
            desordenado = false; // Asumimos que la lista ya está ordenada
            Nodo actual = list;
            Nodo anterior = null;

            while (actual != null && actual.getPs() != null) {
                Nodo siguiente = actual.getPs();

                if (actual.getDato().getFechalimite().isAfter(siguiente.getDato().getFechalimite())) {
                    // Intercambiar nodos
                    if (anterior == null) {
                        list = siguiente;
                    } else {
                        anterior.setPs(siguiente);
                    }

                    actual.setPs(siguiente.getPs());
                    siguiente.setPs(actual);

                    // Marcar que hubo un cambio
                    desordenado = true;
                }

                anterior = actual;
                actual = actual.getPs();
            }
        } while (desordenado);

    }

    public void ordenar_Fecha2(){
        if (list == null || list.getPs() == null) {
            return;
        }

        boolean desordenado = true; // Para saber si hay intercambios
        while (desordenado) {
            desordenado = false; // Suponemos que ya está ordenado
            Nodo actual = list;
            Nodo anterior = null;

            while (actual != null && actual.getPs() != null) {
                Nodo siguiente = actual.getPs();

                if (actual.getDato().getFechalimite().isAfter(siguiente.getDato().getFechalimite())) {
                    // Intercambiar nodos
                    if (anterior == null) {
                        list = siguiente;
                    } else {
                        anterior.setPs(siguiente);
                    }

                    actual.setPs(siguiente.getPs());
                    siguiente.setPs(actual);

                    // Marcar que hubo un cambio
                    desordenado = true;
                }

                // Avanzamos en la lista
                anterior = actual;
                actual = actual.getPs();
            }
        }
    }

    public Nodo BuscarCod(Tareas t) {
        Nodo p = list;
        Nodo x = null;
        int b = 0;
        Nodo ant = null;
        if (ListaVacia()) {
            System.out.println("La lista esta vacia!!");
        }
        while (p != null && b == 0) {
            Tareas elem = p.getDato();
            if (elem.esMayorIgualQue(t)) {
                if (elem.esIgualQue(t)) {
                    b = 1;
                    x = p;
                } else {
                    p = null;
                }
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        if (b == 1) {
            System.out.println("Tarea Encontrada");
        }
        return x;
    }

    public Nodo eliminar(Tareas t) {
        Nodo p = list;
        Nodo x = null;
        Nodo ant = null;
        int b = 0;

        if (ListaVacia()) {
            System.out.println("La lista está vacía!!");
            return null;
        }

        while (p != null && b == 0) {
            Tareas elem = p.getDato();
            if (elem.esMayorIgualQueID(t)) {
                if (elem.esIgualQueID(t)) {
                    b = 1;
                    x = p;
                } else {
                    p = p.getPs();
                }
            } else {
                ant = p;
                p = p.getPs();
            }
        }

        if (b == 1) {
            quitar(ant, x); 
            System.out.println("Tarea Eliminada");
        } else {
            System.out.println("Tarea Inexistente");
        }

        return x;
    }
    
    
    
}
