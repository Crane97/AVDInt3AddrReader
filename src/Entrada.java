public class Entrada implements Instruccion{

    public int id;
    public int variable;

    public Entrada(int id, int variable) {
        this.id = id;
        this.variable = variable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVariable() {
        return variable;
    }

    public void setVariable(int variable) {
        this.variable = variable;
    }
}
