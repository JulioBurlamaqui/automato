
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

def AFD(alfabeto, estados, q0, qf, funcTrans):
    automato = []
    
    for i in range(len(funcTrans)):
        isFinal = False
        if(i in qf):
            isFinal = True

        automato.append( Estado(i, isFinal) )

        for j in range(len(alfabeto)):
            automato[i].addTrans( alfabeto[j] , funcTrans[i][j] )

    return automato



def verExpressao(expressao, automato):
    estado_atual = 0

    # Loop de verificação da expressão dada
    for i in range(len(expressao)):
        lexema = expressao[i]
        
        # Alfabeto Check
        if( (lexema in alfabeto) == False ):
            print("ERRO: character fora do alfabeto")
            return False
        
        estado_atual = automato[estado_atual].getTransPorEntrada(lexema)

    if(automato[estado_atual].isFinal == True):
        print("A palavra " + expressao + " pertence à linguagem.")
    else:
        print("A palavra " + expressao + " NÃO pertence à linguagem.")

# =================================================================================================================================== #


alfabeto = {'p','e','t','c','a'}
alfabeto = list(alfabeto)
alfabeto.sort()
q0 = 0
qf = {2}
estados = {0,1}

funcTrans = []
file = open('tabela_1.txt', 'r')
linha = file.readline()
while(len(linha) != 0):
    linha = linha.split()
    linha = list(map(int, linha))
    funcTrans.append( tuple(linha) )
    linha = file.readline()

automato = AFD(alfabeto, estados, q0, qf, funcTrans)
expressao = 'petecatecatecateca'
verExpressao(expressao, automato)

