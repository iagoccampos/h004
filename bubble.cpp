#include <algorithm>
#include <iostream>
#include <iomanip>
#include <math.h>
#include <time.h>
using namespace std;
void bubbleSort(int vetor[], int tamanho)
{
	int j = 0;
	bool troca = true;
	int limite = tamanho - 1;

	while (troca)
	{
		troca = false;
		for(int i = 0; i < limite; i++)
		{
			if (vetor[i] > vetor[i+1])
			{
				int trab = vetor[i];
				vetor[i] = vetor[i+1];
				vetor[i+1] = trab;
				j = i;
				troca = true;
			}		
		}
		limite = j;
	}
}


int main()
{
	clock_t tInicio, tFim;
	int size = 99999;
	int vetor[size];
	for(int i = 0; i < size; i++)
		vetor[i] = i;
	random_shuffle ( vetor, vetor + size);

	tInicio = clock();
	bubbleSort(vetor, size);
	tFim = clock();

	double tempo = ((double) (tFim - tInicio) / CLOCKS_PER_SEC);
	cout << fixed << setprecision(5) << tempo << endl;
	return 0;
}
