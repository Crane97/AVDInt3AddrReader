public class Escribir implements Instruccion{

    public int id;

    public int valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Escribir(int variable, int valor) {
        this.id = variable;
        this.valor = valor;
    }
}
