package gestionlibros;

import EntradaSalida.EntradaSalida;

public class ISBN {

    private int internacional;
    private int pais;
    private int editor;
    private int titulo;
    private int control;

    public ISBN() {
        internacional = 978;
        pais = 950;
        editor = 0;
        titulo = 0;
        control = 0;
    }

    public int getInternacional() {
        return internacional;
    }

    public int getPais() {
        return pais;
    }

    public int getEditor() {
        return editor;
    }

    public void setEditor(int editor) {
        this.editor = editor;
    }

    public int getTitulo() {
        return titulo;
    }

    public void setTitulo(int titulo) {
        this.titulo = titulo;
    }

    public int getControl() {
        return control;
    }

    public void setControl(int control) {
        this.control = control;
    }

    public void ingresarISBN() {
        System.out.println("Ingrese el ISBN que comienza con: 978 - 950 - \n");
        ingresarEditor();
        ingresarTitulo();
        ingresarControl();
    }

    private void ingresarEditor() {
        boolean verif = false;
        int ingEditor = 0;
        while (!verif) {
            System.out.println("ingrese el identificador de editor:");
            ingEditor = EntradaSalida.leerInt();
            verif = validarEditor(ingEditor);
        }
        setEditor(ingEditor);
    }

    private void ingresarTitulo() {
        boolean verif = false;
        int ingTitulo = 0;
        while (!verif) {
            System.out.println("ingrese el identificador de titulo:");
            ingTitulo = EntradaSalida.leerInt();
            verif = validarTitulo(ingTitulo);
        }
        setTitulo(ingTitulo);
    }

    private void ingresarControl() {
        boolean verif = false;
        int ingControl = 0;
        while (!verif) {
            System.out.println("ingrese el identificador de control:");
            ingControl = EntradaSalida.leerInt();
            verif = validarControl(ingControl);
        }
        setControl(ingControl);
    }

    private boolean validarEditor(int elem) {
        while (elem > 9999 || elem < 1000) {
            System.out.println("Error debe ser un numero de 4 digitos, ingrese nuevamente:");
            return false;
        }
        return true;
    }

    private boolean validarTitulo(int elem) {
        while (elem > 99 || elem < 10) {
            System.out.println("Error debe ser un numero de 2 digitos, ingrese nuevamente:");
            return false;
        }
        return true;
    }

    private boolean validarControl(int elem) {
        while (elem > 9 || elem < 1) {
            System.out.println("Error debe ser un numero de  digito, ingrese nuevamente:");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return (internacional + "-" + pais + "-" + editor + "-" + titulo + "-" + control);
    }

    public void mostrarISBN() {
        System.out.print("ISBN(" + toString() + ") ");
    }

    public boolean esIgualQue(ISBN x) {
        if (editor == x.getEditor() && titulo == x.getTitulo() && control == x.getControl()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esMayorOIgualQue(ISBN x) {
        if (editor >= x.getEditor() || titulo >= x.getTitulo() || control >= x.getControl()) {
            return true;
        } else {
            return false;
        }
    }
}
