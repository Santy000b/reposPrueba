package gestionlibros;

import EntradaSalida.EntradaSalida;

public class Principal {

    ListaOrdenada listaLibros;

    public Principal() {
        listaLibros = new ListaOrdenada();
    }

    public void generarLibros() {
        int op = -1;
        while (op != 0) {
            Libro libro = new Libro();
            libro.ingresarLibro();
            listaLibros.insertar(libro);
            System.out.println("Ingrese un numero (0/para terminar): ");
            op = EntradaSalida.leerInt();

        }
    }

    public void eliminarLibros() {
        if (verificarListaCargada()) {
            System.out.println("Eliminacion de libros");
            int op = -1;
            while (op != 0) {
                Libro libro = new Libro();
                libro.ingresarLibro(0);
                listaLibros.eliminar(libro);
                System.out.println("Ingrese un numero (0/para terminar): ");
                op = EntradaSalida.leerInt();

            }
        }
    }

    public boolean verificarListaCargada() {
        if (listaLibros.inicio() == null) {
            System.out.println("No hay libros cargados\n\n");
            return false;
        } else {
            return true;
        }

    }

    public void indicarPrestado() {
        if (verificarListaCargada()) {
            Libro libro = new Libro();
            libro.ingresarLibro(0);
            Nodo x = listaLibros.BuscarCod(libro);
            if (x != null) {
                x.modificarEstado();
                System.out.println("Cambio de estado!");
            } else {
                System.out.println("No existe");
            }
        }
    }

    public void mostrarLibros() {
        if (verificarListaCargada()) {
            Nodo p = listaLibros.inicio();
            System.out.println("CODIGO DE LIBRO / TITULO / AUTOR / ESTADO");
            while (p != null) {
                p.mostrar();
                p = p.getPs();
            }
        }
    }

    public void mostrarOpciones() {
        System.out.println("MENU DE OPCIONES");
        System.out.println("1-Agregar libros");
        System.out.println("2-Eliminar libros");
        System.out.println("3-Indicar libro prestado");
        System.out.println("4-Mostrar libros");
        System.out.println("0-salir");
    }

    public void menu() {
        int op = 9;
        do {
            switch (op) {
                case 1:
                    generarLibros();
                    break;
                case 2:
                    eliminarLibros();
                    break;
                case 3:
                    indicarPrestado();
                    break;
                case 4:
                    mostrarLibros();
            }
            mostrarOpciones();
            System.out.println("Ingrese una opcion");
            System.out.println("--->");
            op = EntradaSalida.leerInt();
        } while (op != 0);
    }

    public static void main(String[] args) {
        Principal biblioteca = new Principal();
        biblioteca.menu();
    }

}
