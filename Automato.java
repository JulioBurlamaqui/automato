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
        this.estadoInicial = 1; /*estado inicial é sempre um kk*/
        this.alfabeto = alfabeto;
        this.trans = trans;
        
        if(estados.contains(1))
        	this.estados = estados;
        else
        	throw new IllegalArgumentException("Um dos estados precisa ser 1!");
        
        if(estados.containsAll(estadosFinais))
        	this.estadosFinais = estadosFinais;
        else
        	throw new IllegalArgumentException("Os estados finais precisam fazer parte dos estados!");  
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
    		if(!this.alfabeto.contains(simbolo))
    			throw new IllegalArgumentException("O símbolo inserido não pertence ao alfabeto!");
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