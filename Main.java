
public class Main {

	public static void main(String[] args) {
		// reconhecer pr�ximo token
		estado = s0
		lexema = ��
		pilha.limpa()
		while (!eof && estado != erro) do
		char = leChar()
		lexema = lexema + char
		push (estado)
		estado = trans(estado,char)
		end;

		// limpar estado final
		while (estado pertence* SF

		&& !pilha.vazia()) do

		estado <- pilha.pop()
		lexema = lexema.truncaUltimo()
		voltaChar()
		end;
		if (estado pertence* SF )
		// r�tulo do estado � tipo do token
		then return <estado.rotulo, lexema>
		else return erro
	}

}
