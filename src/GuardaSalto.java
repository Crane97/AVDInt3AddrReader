import java.util.Objects;

public class GuardaSalto {

    private Node origenSalto;

    private int destinoSalto;

    public Node getOrigenSalto() {
        return origenSalto;
    }

    public void setOrigenSalto(Node origenSalto) {
        this.origenSalto = origenSalto;
    }

    public int getDestinoSalto() {
        return destinoSalto;
    }

    public void setDestinoSalto(int destinoSalto) {
        this.destinoSalto = destinoSalto;
    }

    public GuardaSalto(Node origenSalto, int destinoSalto) {
        this.origenSalto = origenSalto;
        this.destinoSalto = destinoSalto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuardaSalto that = (GuardaSalto) o;
        return destinoSalto == that.destinoSalto && Objects.equals(origenSalto, that.origenSalto);
    }
}
