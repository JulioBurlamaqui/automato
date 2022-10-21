public class Par
{
	/*
	 * Par representar� as chaves do dicion�rio que representa a fun��o delta de mudan�a de estados.
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