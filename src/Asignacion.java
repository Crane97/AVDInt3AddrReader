public class Asignacion implements Instruccion{

    public int id;
    public Object asignacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(Object asignacion) {
        this.asignacion = asignacion;
    }

    public Asignacion(int val, Object asignacion) {
        this.id = val;
        this.asignacion = asignacion;
    }
}
