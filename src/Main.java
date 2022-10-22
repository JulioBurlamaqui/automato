import java.util.*;

public class Main {

    public static void main(String[] args) {

        // EXEMPLO 1: LINGUAGEM [abc]+c
        char[] alfabeto1 = {'a', 'b', 'c'};
        Integer[] _estados1 = {0, 1, 2};
        Integer[] _estados_finais1 = {2};
        Map<Par, Integer> transicao1 = new HashMap<>();

        List<Integer> estados1 = Arrays.asList(_estados1);
        List<Integer> estados_finais1 = Arrays.asList(_estados_finais1);

        transicao1.put(new Par(0, 'a'), 1);
        transicao1.put(new Par(0, 'b'), 1);
        transicao1.put(new Par(0, 'c'), 1);
        transicao1.put(new Par(1, 'a'), 1);
        transicao1.put(new Par(1, 'b'), 1);
        transicao1.put(new Par(1, 'c'), 2);
        transicao1.put(new Par(2, 'a'), 1);
        transicao1.put(new Par(2, 'b'), 1);
        transicao1.put(new Par(2, 'c'), 2);

        Automato automato1 = new Automato(alfabeto1, estados1, estados_finais1, transicao1);

        AnalisadorLexico analisador1 = new AnalisadorLexico(automato1, "abcabcabab");

        analisador1.analisar();

        // EXEMPLO 2: Linguagem (a|b)*abb

        char[] alfabeto2 = {'a', 'b'};
        Integer[] _estados2 = {0, 1, 2, 3, 4};
        Integer[] _estados_finais2 = {4};
        Map<Par, Integer> transicao2 = new HashMap<>();

        List<Integer> estados2 = Arrays.asList(_estados2);
        List<Integer> estados_finais2 = Arrays.asList(_estados_finais2);

        transicao2.put(new Par(0, 'a'), 1);
        transicao2.put(new Par(0, 'b'), 2);
        transicao2.put(new Par(1, 'a'), 1);
        transicao2.put(new Par(1, 'b'), 3);
        transicao2.put(new Par(2, 'a'), 1);
        transicao2.put(new Par(2, 'b'), 2);
        transicao2.put(new Par(3, 'a'), 1);
        transicao2.put(new Par(3, 'b'), 4);
        transicao2.put(new Par(4, 'a'), 1);
        transicao2.put(new Par(4, 'b'), 2);

        Automato automato2 = new Automato(alfabeto2, estados2, estados_finais2, transicao2);

        AnalisadorLexico analisador2 = new AnalisadorLexico(automato2, "abbaabbab");

        analisador2.analisar();

    }
}


