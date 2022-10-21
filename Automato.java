import java.nio.Character.Character;
import java.util.*;

public class Automato
{
	/*
	 * Classe que representa um autômato finito deterministico (AFD).
	 * O autômato tem um vetor de estados, o um sempre sendo o inicial, e também outro vetor com os
	 * estados finais. Além disso, possui um vetor de caracteres que representa o alfabeto.
	 * Finalmente, possui um dicionário que representará o delta, isto é, a função de transição. Este
	 * dicionário possui um par estado entrada-caractere como chave e um estado resultado como valor.
	 */
    private int estadoInicial;
    private Vector<Character> alfabeto;
    private Vector<Integer> estados;
    private Vector<Integer> estadosFinais;
    private Dictionary<Par, Integer> trans;

    Automato(Vector<Character> alfabeto, Vector<Integer> estadosFinais, Vector<Integer> estados, Dictionary<Par, Integer> trans)
    {
        this.estadoInicial = 1; /*estado inicial é sempre zero kk*/
        this.alfabeto = alfabeto;
        this.estados = estados;
        this.estadosFinais = estadosFinais; 
        this.trans = trans; 
    }
    
    /*Entrada é o estado antes da transição.*/
    private int funcao_trans(Par entrada) {
        return (int) trans.get(entrada);
    }
    
    public boolean aceitaPalavra()
    {
    	Scanner sc = new Scanner(System.in);
    	char simbolo;
    	Vector<Character> lexema = new Vector<Character>();
    	int estadoAtual = estadoInicial;
    	Par entrada;
    	
    	while(sc.hasNext())
    	{
    		simbolo = sc.next().charAt(0);
    		lexema.add(simbolo);
    		entrada = new Par(estadoAtual, simbolo);
    		
    		estadoAtual = funcao_trans(entrada);
    	}
    	
    	sc.close();
    	
    	if(this.estadosFinais.contains(estadoAtual))
    		return true;
    	return false;
    }

}