package gestionlibros;

public class Nodo {
    private Libro dato;
    private Nodo ps;

    public Nodo(Libro elem) {
        dato = elem;
        ps =null;
    }

    public Libro getDato() {
        return dato;
    }

    public void setDato(Libro dato) {
        this.dato = dato;
    }

    public Nodo getPs() {
        return ps;
    }

    public void setPs(Nodo ps) {
        this.ps = ps;
    }
    
    public void modificarEstado(){
        dato.ingresarEstado();
    }
    
    public void mostrar(){
        dato.mostrarLibro();
    }
}
