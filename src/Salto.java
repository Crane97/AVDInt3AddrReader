public class Salto implements Instruccion{

    private Object arg1;
    private Object arg2;

    private int etiqueta;

    @Override
    public int getId() {
        return 0;
    }

    public Object getArg1() {
        return arg1;
    }

    public void setArg1(Object arg1) {
        this.arg1 = arg1;
    }

    public Object getArg2() {
        return arg2;
    }

    public void setArg2(Object arg2) {
        this.arg2 = arg2;
    }

    public int getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(int etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Salto(Object arg1, Object arg2, int etiqueta) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.etiqueta = etiqueta;
    }
}
