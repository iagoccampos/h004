package quicksort;

public class QuickSort {
    public static void main(String[] args) {
	int size = 10;
	int[] vetor = new int[size];

	for(int i = 0; i < size; i++) {
	    vetor[i] = i;
	}

	shuffle(vetor);

	long startTime = System.nanoTime();
	quickSort(vetor, size, 0, vetor.length - 1);
	long endTime = System.nanoTime();

	System.out.println("quickSortTimer: " + (endTime - startTime) / 1_000_000 + "ms");
    }

    static void quickSort(int vetor[], int tamanho, int i, int j) {
	int trab, esq, dir, pivo;
	esq = i;
	dir = j;

	pivo = vetor[(int) Math.round((esq + dir) / 2.0)];
	do {
	    while(vetor[esq] < pivo) {
		esq++;
	    }
	    while(vetor[dir] > pivo) {
		dir--;
	    }
	    if(esq <= dir) {
		trab = vetor[esq];
		vetor[esq] = vetor[dir];
		vetor[dir] = trab;
		esq++;
		dir--;
	    }
	} while(esq <= dir);
	if(dir - i >= 0) {
	    quickSort(vetor, tamanho, i, dir);
	}
	if(j - esq >= 0) {
	    quickSort(vetor, tamanho, esq, j);
	}
    }

    static int[] shuffle(int[] array) {
	int currentIndex = array.length, temporaryValue, randomIndex;

	while(0 != currentIndex) {
	    randomIndex = (int) Math.floor(Math.random() * currentIndex);
	    currentIndex -= 1;

	    temporaryValue = array[currentIndex];
	    array[currentIndex] = array[randomIndex];
	    array[randomIndex] = temporaryValue;
	}

	return array;
    }
}
