package mochila;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mochila {
    public static class Item {
	int value, weight;

	public Item(int value, int weight) {
	    this.value = value;
	    this.weight = weight;
	}
    }

    static List<int[]> permutations = new ArrayList<>();
    static int[][] permutationsArray;

    public static void main(String[] args) {
	//setup
	final int bagCap = 150;
	final int itensCount = 8;
	final int maxItemWeight = 40;
	final int maxItemValue = 50;

	Item itens[] = new Item[itensCount];
	int ids[] = new int[itensCount];
	int bestResult = 0;

	for(int i = 0; i < itensCount; i++) {
	    itens[i] = new Item(Math.round((float) Math.random() * maxItemValue),
		    Math.round((float) Math.random() * maxItemWeight));
	    ids[i] = i;
	}
	permutationsArray = new int[factorial(itensCount)][itensCount];

	permute(itensCount, ids);
	//System.out.println(Arrays.deepToString(permutations.toArray(permutationsArray)));

	long startTime = System.nanoTime();
	for(int i = 0; i < permutationsArray.length; i++) {
	    int currentCap = 0;
	    int totalVal = 0;

	    for(int j = 0; j < itensCount; j++) {
		if(currentCap + itens[permutationsArray[i][j]].weight <= bagCap) {
		    currentCap += itens[permutationsArray[i][j]].weight;
		    totalVal += itens[permutationsArray[i][j]].value;
		}
	    }

	    if(totalVal > bestResult) {
		bestResult = totalVal;
	    }
	}
	long endTime = System.nanoTime();

	System.out.println("bubbleSortTimer: " + (endTime - startTime) / 1_000_000 + "ms");
    }

    public static void permute(int n, int[] elements) {

	if(n == 1) {
	    permutations.add(elements.clone());
	}
	else {
	    for(int i = 0; i < n - 1; i++) {
		permute(n - 1, elements);
		if(n % 2 == 0) {
		    swap(elements, i, n - 1);
		}
		else {
		    swap(elements, 0, n - 1);
		}
	    }
	    permute(n - 1, elements);
	}
    }

    private static void swap(int[] input, int a, int b) {
	int tmp = input[a];
	input[a] = input[b];
	input[b] = tmp;
    }

    public static int factorial(int value) {
	if(value == 1) {
	    return value;
	}
	else {
	    return value * factorial(value - 1);
	}
    }
}
