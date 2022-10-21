
# =================================================================================================================================== #

class Estado:

    indice = int
    isFinal = False
    trans = [] # Tuplas: (entrada, próximo indice)

    def __init__(self, indice, isFinal):
        self.indice = indice
        self.isFinal = isFinal
        self.trans = []
        pass

    def getTransPorEntrada(self, entrada):
        check = False
        for i in range(len(self.trans)):
            if(self.trans[i][0] == entrada):
                check = True
                return self.trans[i][1]
                

        if(check == False):
            print("ERRO: Transição não encontrada no estado Q"+str(self.getIndice())+" para a entrada: "+str(entrada) )

    def addTrans(self, entrada, proximo_indice):
        self.trans.append( (entrada, proximo_indice) )

# =================================================================================================================================== #

alfabeto = {'0','1'}

# Definindo AFD. Neste caso, L = número ímpar de 1's
AFD = []

AFD.append( Estado(0,False) )
AFD.append( Estado(1,True) )

AFD[0].addTrans('0',0)
AFD[0].addTrans('1',1)
AFD[1].addTrans('0',1)
AFD[1].addTrans('1',0)

expressao = '000100011000000000000000000000000000000000000000000000000000000111'  ## Expressão de entrada a ser verificada pelo autômato

# =================================================================================================================================== #

def verExpressao(expressao, AFD):
    estado_atual = 0

    # Loop de verificação da expressão dada
    for i in range(len(expressao)):
        lexema = expressao[i]
        
        # Alfabeto Check
        if( (lexema in alfabeto) == False ):
            print("ERRO: character fora do alfabeto")
            return False
        
        estado_atual = AFD[estado_atual].getTransPorEntrada(lexema)

    if(AFD[estado_atual].isFinal == True):
        print("A palavra " + expressao + " pertence à linguagem.")
    else:
        print("A palavra " + expressao + " NÃO pertence à linguagem.")

# =================================================================================================================================== #

verExpressao(expressao, AFD)

