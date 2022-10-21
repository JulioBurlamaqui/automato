public class Par
{
	/*
	 * Par representará as chaves do dicionário que representa a função delta de mudança de estados.
	 * Armazena um inteiro que representa um estado e uma entrada que representa um caractere do lexema.
	 */
    int estado;
    char entrada;
    
    Par(int estado, char entrada)
    {
    	this.entrada = entrada;
    	this.estado = estado;
    }

    public boolean equals(Par outro){
        return (outro.entrada == this.entrada && outro.estado == this.estado);
    }
}