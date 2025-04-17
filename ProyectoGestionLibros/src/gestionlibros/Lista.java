package gestionlibros;
public class Lista {
    protected Nodo list;

    public Lista() {
    }
    public Nodo inicio(){
        return list;
    }
    public boolean listaVacia(){
        return list==null;
    }
    public void insertarPri(Libro elem){
        Nodo x=new Nodo(elem);
        if (list!=null){
            x.setPs(list);
        }
        list=x;    
    }
    public Nodo quitar(Nodo p,Nodo ant){
        Nodo x=p;
        if (p==list){
            list=p.getPs();
        }else{
            ant.setPs(p.getPs());
        }
        return x;
    }
    public Nodo eliminar(Libro libro){
        Nodo x=null;
        Nodo p=list;
        Nodo ant=null;
        if(p==null){
            return x;
        }
        boolean b=false;
        while (p!=null && !b){
            Libro elem = p.getDato();
            if(elem.esIgualQue(libro)){
                b=true;
            }else{
                ant=p;
                p=p.getPs();
            }
        }
        if (b==true){
            quitar(p,ant);
            x=p;
            System.out.println("Libro Eliminado");
        }else{
            System.out.println("Libro Inexistente");
        }
        return x;
    }
    
   public boolean buscarElem(Libro libro){
       Nodo p=list;
       if (p==null){
           return false;
       }
       while (p!=null){
           Libro elem = p.getDato();
           if(elem.esIgualQue(libro)){
               return true;
           }else{
               p=p.getPs();
           }
       }
       return false;
   }
}
