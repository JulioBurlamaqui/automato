import java.nio.Character.Character;
import java.util.*;

public class Automato
{
	/*
	 * Classe que representa um aut?mato finito deterministico (AFD).
	 * O aut?mato tem um vetor de estados, o um sempre sendo o inicial, e tamb?m outro vetor com os
	 * estados finais. Al?m disso, possui um vetor de caracteres que representa o alfabeto.
	 * Finalmente, possui um dicion?rio que representar? o delta, isto ?, a fun??o de transi??o. Este
	 * dicion?rio possui um par estado entrada-caractere como chave e um estado resultado como valor.
	 */
    private int estadoInicial;
    private Vector<Character> alfabeto;
    private Vector<Integer> estados;
    private Vector<Integer> estadosFinais;
    private Dictionary<Par, Integer> trans;

    Automato(Vector<Character> alfabeto, Vector<Integer> estadosFinais, Vector<Integer> estados, Dictionary<Par, Integer> trans)
    {
        this.estadoInicial = 1; /*estado inicial ? sempre um kk*/
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
    
    /*Entrada ? o estado antes da transi??o.*/
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
    			throw new IllegalArgumentException("O s?mbolo inserido n?o pertence ao alfabeto!");
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