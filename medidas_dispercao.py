import math

#Funções

def calc_amplitude(num_list):
    maior = max(num_list)
    menor = min(num_list)

    amplitude = maior - menor

    print(f"Amplitude: {maior} - {menor} = {amplitude}\n")


def calc_media(num_list):
    soma = sum(num_list)
    ntermos = len(num_list)
    media =  soma / ntermos 

    print(f"Média: {soma} / {ntermos} = {media}\n")

    return media


def calc_variancia(num_list, media):

    sec_list = []
    list_count = 0

    for i in num_list:
        sec_list.append(pow((i - media), 2))
       
        print(f"({i} - {media})² = {sec_list[list_count]}")
        
        list_count += 1
    
    sec_soma = sum(sec_list)
    ntermos = len(num_list)

    variancia = sec_soma / ntermos

    print(f"\nVariância: {sec_soma} / {ntermos} = {variancia}")

    return variancia


def calc_dp(variancia):
    dp = math.sqrt(variancia)

    print(f"Desvio padrão: √{variancia} = {dp}")
    
    
#Main

print("Digite uma lista de números(um por um), digite 'e' para encerrar: ")

confirm = "n"
count_confirm = 0

while confirm == "n": #Enquanto o usuario não der a confirmação da lista, o looping continua

    num_list = []

    end = ''

    count = 0
    count_confirm += 1 

    while end != 'e': #Enquanto o usuario não digitar um letra ou caratctere invalido, o looping continua
        
        count += 1

        if count_confirm >= 2 and count == 1: 
            print("Digite de novo: ")

        try:
            var = int(input(f"N°{count}: ")) #Caso usuario digite uma letra ou caractere invalido, o programa
                                             #entende que ele terminou de digitar a lsita e pede uma confimação
            num_list.append(var)

        except:
            break

    print("Essa é sua lista? ->", num_list)
    confirm = input("[s/n] -> ") #Confirmação do usuario

print("\n------------------------//------------------------\n")

#Amplitude
calc_amplitude(num_list)

#Média
media = calc_media(num_list)

#Variância
variancia = calc_variancia(num_list, media)

#Desvio Padrão
calc_dp(variancia)

