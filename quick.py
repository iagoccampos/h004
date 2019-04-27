import sys
import time
import random

def quickSort(vetor, tamanho, i, j):
	left = i
	right = j

	pivo = vetor[round((left + right) / 2)]
	while (left <= right):
		while (vetor[left] < pivo):
				left += 1
		while (vetor[right] > pivo):
				right -= 1
		
		if (left <= right):
			trab = vetor[left]
			vetor[left] = vetor[right]
			vetor[right] = trab
			left += 1
			right -= 1

	if(right - i >= 0):
		quickSort(vetor, tamanho, i, right)
	if(j - left >= 0):
		quickSort(vetor, tamanho, left, j)

	
	return


def main():
	vetor = []
	size = 10
	for n in range(size):
		vetor.append(n)
	random.shuffle(vetor)
	print (vetor)
	inicio = time.time()
	quickSort(vetor, size, 0, (size - 1) )	
	fim = time.time()
	print (vetor)
	print (fim - inicio)
	


#-----------------------------------------------------
if __name__ == '__main__':
    main()
