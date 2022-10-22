import java.util.*;

public class Automato {
    public char[] alfabeto;
    public List<Integer> estados;
    public List<Integer> estados_finais;
    public int estado_inicial;

    public Map<Par, Integer> transicao;


    Automato(char[] alfabeto, List<Integer> estados, List<Integer> estados_finais, Map<Par, Integer> transicao) {
        this.alfabeto = alfabeto;
        this.estados = estados;
        this.estado_inicial = 0;
        this.estados_finais = estados_finais;
        this.transicao = transicao;

    }

}
