import java.util.Hashtable;
import java.util.Objects;

public class Par
{
    public int estado;
    public char entrada;
    public int hashCode;

    public Par(int estado, char entrada) {
        this.estado = estado;
        this.entrada = entrada;
        this.hashCode = Objects.hash(estado, entrada);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Par par = (Par) obj;

        if (this.estado != par.estado) {
            return false;
        }

        if (this.entrada != par.entrada) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }

}