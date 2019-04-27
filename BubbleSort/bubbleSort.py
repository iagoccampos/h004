import sys
import time
import random

def bubbleSort(vetor, tamanho):
	j = 0
	troca = True
	limite = tamanho - 1

	while (troca):
		troca = False
		for i in range(limite):
			if (vetor[i] > vetor[i+1]):
				trab = vetor[i]
				vetor[i] = vetor[i+1]
				vetor[i+1] = trab
				j = i
				troca = True
		limite = j
	
	return


def main():
	vetor = []
	size = 10000
	for n in range (size):
		vetor.append(n)
	random.shuffle (vetor)
	print (vetor)
	inicio = time.time()
	bubbleSort (vetor, size)	
	fim = time.time()
	print (vetor)
	print (fim - inicio)
	


#-----------------------------------------------------
if __name__ == '__main__':
    main()
