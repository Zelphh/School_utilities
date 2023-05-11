# Criado por Zelph (Matheu Melle Tártari)
# Data: 20/11/2021
# Objetivo: Obter informações de uma função quadrática

import math

def run():
   print("""\n                 \033[33mAtenção!!!\033[m
Para esse programa funcionar eh preciso digitar
\033[4mAPENAS\033[m os valores dos coeficientes \033[34mA\033[m, \033[34mB\033[m e \033[34mC\033[m. Apenas eles!
\n\033[33mObs\033[m: Esse programa não aceita nem mostra frações!
    Se um número tiver '.0' no final, apenas ignore a parte decimal.\n""")

   a = int(input("Digite o valor do coeficiente A: "))
   if a == 0:
       while a == 0:
           print("\033[31mERRO!\033[m O coeficiente A não pode ser igual a zero!")
           a = int(input("Digite o valor do coeficiente A: "))
   b = int(input("Digite o valor do coeficiente B: "))
   c = int(input("Digite o valor do coeficiente C: "))

   # Parte 1 = ax²
   if a == 1:
       p1 = 'x²'
   elif a == -1:
       p1 = '-x²'
   else:
       p1 = f'{a}x²'

   # Parte 2 = bx
   if b == 1:
       p2 = '+ x'
   elif b == -1:
       p2 = '- x'
   elif b > 0:
       p2 = f'+ {b}x'
   elif b < 0:
       p2 = f'- {abs(b)}x'
   else:
       p2 = ''

   # Parte 3 = c
   if c > 0:
       p3 = f'+ {c}'
   elif c < 0:
       p3 = f'- {abs(c)}'
   else:
       p3 = ''

   print(f'\nFunção: {p1} {p2} {p3}')

   # Concavidade da parábola:
   print("\n•Concavidade da parábola: ")
   if a > 0:
       para_cima = True
   else:
       para_cima = False

   if para_cima:
       print('    a > 0 → Para cima')
   else:
       print('    a < 0 → Para baixo')

   # Ponto de intersecção com o eixo OX (raízes ou zeros da função):
   print("\n•Intersecção com o eixo OX: ")

   delta = b**2 - 4 * a * c

   if delta < 0:
       print('    Essa função não possui intersecção com o eixo OX.')
   elif delta == 0:
       x1 = (-b + (math.sqrt(delta))) / (2 * a)
       print(f'    Esssa função possui duas raízes reias iguais: {x1}')
       print(f'    Ponto de intersecção: ({x1}, 0)')
   else:
       print(f'    ∆ = {delta}')

       x1 = (-b + (math.sqrt(delta))) / (2 * a)

       x2 = (-b - (math.sqrt(delta))) / (2 * a)

       print(f'    As raízes são: {x1} e {x2}')
       print(f'    Pontos de intersecção: ({x1}, 0) e ({x2}, 0)')

   # Ponto de intersecção com o eixo OY:
   print('\n•Intersecção com o eixo OY: ')

   print(f'    c = {c} → (0, {c})')

   # Ponto de vértice da parábola (Xv, Yv):
   print("\n•Ponto de vértice: ")

   xv = -b / (2 * a)

   yv = -delta / (4 * a)

   print(f'    Xv = {xv}')
   print(f'    Yv = {yv}')

   print(f'    V({xv}, {yv})')

   # Valor mínimo/maximo da função(Yv):
   if para_cima:
       print('\n•Valor mínimo: ')
   else:
       print('\n•Valor maximo: ')

   print(f'    Yv = {yv}')

   # Intervalos de crescimento de decrescimento:
   print('\n•Intervalos de crescimento e decrescimento')

   if para_cima:
       print(f'    Decrescente em: (-∞, {xv}]')
       print(f'    Crescente em: [{xv}, +∞)')
   else:
       print(f'    Crescente em: (-∞, {xv}]')
       print(f'    Decrescente em: [{xv}, +∞)')

   # Eixo de simetria(Xv):
   print('\n•Eixo de simetria: ')

   print(f'    Xv = {xv}')

   # Conjunto imagem da função:
   print('\n•Conjunto imagem da função: ')

   if para_cima:
       print(f'    Im(f) = {{y ∈ ℝ | y ≥ {yv}}}')
   else:
       print(f'    Im(f) = {{y ∈ ℝ | y ≤ {yv}}}')


if __name__ == '__main__':
   run()

