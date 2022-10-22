import java.util.*;

public class AnalisadorLexico {
    Automato automato;
    Integer estado_atual;
    String lexema, entrada;
    Stack<Integer> pilha = new Stack<>();
    char caractere_atual;

    public AnalisadorLexico(Automato automato, String entrada) {
        this.automato = automato;
        this.entrada = entrada;
        lexema = "";
        estado_atual = 0;
        pilha.clear();
    }

    public Map<Integer, String> analise() {
        while (entrada.length() != 0 && estado_atual != -1) {
            caractere_atual = entrada.charAt(0);
            entrada = entrada.substring(1);
            lexema += caractere_atual;

            if (automato.estados_finais.contains(estado_atual))
                pilha.clear();

            pilha.push(estado_atual);
            estado_atual = trans(estado_atual, caractere_atual);
        }

        while (!automato.estados_finais.contains(estado_atual) && !pilha.empty()) {
            estado_atual = pilha.pop();
            caractere_atual = lexema.charAt(lexema.length() - 1);
            lexema = truncaUltimo();
            entrada = voltaChar(entrada, caractere_atual);
        }

        if (automato.estados_finais.contains(estado_atual)) {
            Map<Integer, String> aceito = new HashMap<>();
            aceito.put(estado_atual, lexema);
            return aceito;
        }

        Map<Integer, String> nao_aceito = new HashMap<>();
        nao_aceito.put(-1, lexema);

        return nao_aceito;
    }

    public void analisar() {
        if (contemChar(entrada)) {
            if (this.analise().containsKey(-1)) {
                System.out.println("A palavra nao foi aceita");
            } else {
                if (entrada == "") {
                    System.out.println("A palavra " + lexema + " foi aceita no estado " + estado_atual);
                } else {
                    System.out.println("A palavra " + lexema + " foi aceita no estado " + estado_atual + ". O resto " + entrada + " nao foi aceito.");
                }
            }
        } else {
            System.out.println("A palavra contem caracteres que nao estao no alfabeto");
        }

    }

    public String voltaChar(String entrada, char caractere) {
        StringBuilder sb = new StringBuilder(entrada);
        sb.insert(0, caractere);
        return sb.toString();
    }
    public String truncaUltimo() {
        return lexema.substring(0, lexema.length() - 1);
    }

    public Integer trans(Integer estado, char caractere) {
        Integer proximo_estado = 0;
        Par atual = new Par(estado, caractere);
        proximo_estado = automato.transicao.get(atual);
        return proximo_estado;
    }

    public boolean contemChar(String entrada) {
        int i;
        String _alfabeto = new String();
        _alfabeto = Arrays.toString(automato.alfabeto);

        for (i = 0; i < entrada.length(); i++)
            if (_alfabeto.indexOf(entrada.charAt(i)) == -1)
                return false;

        return true;
    }
}
