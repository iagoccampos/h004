#include <algorithm>
#include <iostream>
#include <iomanip>
#include <math.h>
#include <time.h>
using namespace std;
void quickSort(int vetor[], int tamanho, int i, int j)
{
	int trab, esq, dir, pivo;
	esq = i;
	dir = j;
	pivo = vetor[(int)ceil((esq + dir)/2.0)];
	do
	{
		while (vetor[esq] < pivo)
			esq++;
		while (vetor[dir] > pivo)
			dir--;
		if (esq <= dir)
		{
			trab = vetor[esq];
			vetor[esq] = vetor[dir];
			vetor[dir] = trab;
			esq++;
			dir--;
		}
	} while (esq <= dir);

	if (dir-i >= 0)
		quickSort(vetor,tamanho,i,dir);
	if (j-esq >= 0)
		quickSort(vetor,tamanho,esq,j);
}


int main()
{
	clock_t tInicio, tFim;
	int size = 999999;
	int vetor[size];
	for(int i = 0; i < size; i++)
		vetor[i] = i;
	random_shuffle ( vetor, vetor + size);

	tInicio = clock();
	quickSort(vetor, size, 0 , size - 1);
	tFim = clock();

	double tempo = ((double) (tFim - tInicio) / CLOCKS_PER_SEC);
	cout << fixed << setprecision(5) << tempo << endl;
	return 0;
}
