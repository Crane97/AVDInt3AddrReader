public class Suma implements Instruccion{

    public int id;

    public Object valor1;
    public Object valor2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getValor1() {
        return valor1;
    }

    public void setValor1(Object valor1) {
        this.valor1 = valor1;
    }

    public Object getValor2() {
        return valor2;
    }

    public void setValor2(Object valor2) {
        this.valor2 = valor2;
    }

    public Suma(int id, Object valor1, Object valor2) {
        this.id = id;
        this.valor1 = valor1;
        this.valor2 = valor2;
    }
}
