
package gestortareas;



public class Nodo {
    private Tareas dato;
    private Nodo ps;
    
    public Nodo(Tareas dato){
        this.dato = dato;
        this.ps = null;
    }

    public Tareas getDato() {
        return dato;
    }

    public void setDato(Tareas dato) {
        this.dato = dato;
    }

    public Nodo getPs() {
        return ps;
    }

    public void setPs(Nodo ps) {
        this.ps = ps;
    }
}
