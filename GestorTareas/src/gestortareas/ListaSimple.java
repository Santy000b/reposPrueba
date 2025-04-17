
package gestortareas;

public class ListaSimple {
    protected Nodo list;

    public ListaSimple() {
        list = null;
    }

    public void InsertarAlPrincipio(Tareas t) {
        Nodo x = new Nodo(t);
        if (list == null) {
            list = x;
        } else {
            x.setPs(list);
            list = x;
        }
    }

    public boolean ListaVacia() {
        return(list == null);
    }
    
    public Nodo inicio(){
        return list;
    }
    public Nodo quitar(Nodo a, Nodo p){
        Nodo x = p;
        if (p == list){
            list = p.getPs();
        }else{
            a.setPs(p.getPs());
        }
        return x;
    }
}
