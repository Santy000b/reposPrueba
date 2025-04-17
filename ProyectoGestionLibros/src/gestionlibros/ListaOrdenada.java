package gestionlibros;

public class ListaOrdenada extends Lista {
    
    public ListaOrdenada() {
        super();
    }
    
    public void insertarMedio(Nodo p, Nodo ant, Nodo x) {
        x.setPs(p);
        ant.setPs(x);
    }
    
    public void insertarFin(Nodo ant, Nodo p, Nodo x) {
        if (p == null) {
            x.setPs(null);
            ant.setPs(x);
        }
    }
    
    public void insertar(Libro libro) {
        Nodo p = inicio();
        Nodo ant = null;
        int b = 0;
        while (p != null && b == 0) {
            Libro elem = p.getDato();
            if (elem.esMayorOIgualQue(libro)) {
                if (elem.esIgualQue(libro)) {
                    System.out.println("Libro Existente");
                    b = 2;
                } else {
                    b = 1;
                }
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        if (b != 2) {
            Nodo x = new Nodo(libro);
            if (b == 1) {
                if (p == list) {
                    insertarPri(libro);
                } else {
                    insertarMedio(p, ant, x);
                }
            } else {
                if (ant == null) {
                    list = x;
                } else {
                    insertarFin(ant, p, x);
                }
            }
        }
        
    }
    
    @Override
    public Nodo eliminar(Libro libro) {
        Nodo x = null;
        Nodo p = list;
        Nodo ant = null;
        if (p == null) {
            return x;
        }
        boolean b = false;
        while (p != null && !b) {
            Libro elem = p.getDato();
            if (elem.esMayorOIgualQue(libro)) {
                b = true;
                if (elem.esIgualQue(libro)) {
                    x = p;
                }
                
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        if (x != null) {
            quitar(p, ant);
        }
        if (b) {
            System.out.println("Libro Eliminado");
        } else {
            System.out.println("Libro Inexistente");
        }
        return x;
    }
    
    public Nodo BuscarCod(Libro libro) {
        Nodo p = list;
        Nodo x = null;
        int b = 0;
        Nodo ant = null;
        if (listaVacia()) {
            System.out.println("La lista esta vacia!!");
        }
        while (p != null && b == 0) {
            Libro elem = p.getDato();
            if (elem.esMayorOIgualQue(libro)) {
                if (elem.esIgualQue(libro)) {
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
            System.out.println("Libro Encontrado");
        }
        return x;
    }
}
