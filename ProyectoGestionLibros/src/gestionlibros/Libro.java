package gestionlibros;

import EntradaSalida.EntradaSalida;

public class Libro {

    private ISBN cod;
    private String titulo;
    private String autor;
    private boolean estado;

    public Libro() {
        cod = new ISBN();
        titulo = "";
        autor = "";
        estado = true;
    }

    public ISBN getCod() {
        return cod;
    }

    public void setCod(ISBN cod) {
        this.cod = cod;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void ingresarLibro() {
        cod.ingresarISBN();
        ingresarTitulo();
        ingresarAutor();
        ingresarEstado();
    }

    public void ingresarLibro(int clave) {
        cod.ingresarISBN();
    }

    private void ingresarTitulo() {
        boolean verif = false;
        String ingTitulo = "";
        while (!verif) {
            System.out.println("ingrese el titulo del libro:");
            ingTitulo = EntradaSalida.leerString();
            verif = validarTexto(ingTitulo);
        }
        setTitulo(ingTitulo);
    }

    private void ingresarAutor() {
        boolean verif = false;
        String ingAutor = "";
        while (!verif) {
            System.out.println("ingrese el autor del libro:");
            ingAutor = EntradaSalida.leerString();
            verif = validarTexto(ingAutor);
        }
        setAutor(ingAutor);
    }

    private boolean validarTexto(String elem) {
        while ("".equals(elem)) {
            System.out.println("Error texto nulo, ingrese nuevamente:");
            return false;
        }
        return true;
    }

    public void ingresarEstado() {
        boolean verif = false;
        int ingEstado = 0;
        while (!verif) {
            System.out.println("ingrese el estado del libro:\n"
                    + "1 - disponible\n"
                    + "2 - prestado");
            ingEstado = EntradaSalida.leerInt();
            verif = validarEstado(ingEstado);
        }
        setEstado((ingEstado == 1) ? true : false);
    }

    private boolean validarEstado(int elem) {
        while (elem != 1 && elem != 2) {
            System.out.println("Error, ingrese nuevamente:");
            return false;
        }
        return true;
    }

    public String presentarEstado() {
        if (estado) {
            return "disponible";
        } else {
            return "prestado";
        }
    }

    public void mostrarLibro() {
        cod.mostrarISBN();
        System.out.print(" / " + titulo + " / " + autor + " /  " + presentarEstado() + "\n");

    }

    public boolean esIgualQue(Libro x) {
        if (cod.esIgualQue(x.getCod())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esMayorOIgualQue(Libro x) {
        if (cod.esMayorOIgualQue(x.getCod())) {
            return true;
        } else {
            return false;
        }
    }

}
