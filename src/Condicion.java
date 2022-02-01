public class Condicion implements Instruccion{

    public String izquierda;
    public String derecha;

    @Override
    public int getId() {
        return 0;
    }

    public Condicion(String izquierda, String derecha) {
        this.izquierda = izquierda;
        this.derecha = derecha;
    }
}
