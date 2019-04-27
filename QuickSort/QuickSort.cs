namespace H004
{
    using System;
    using System.Diagnostics;
    using System.Linq;

    public static class QuickSort
    {
        public static void Main()
        {
            var rng = new Random();
            const int Size = 99999;
            int[] array = Enumerable
                .Range(0, Size)
                .OrderBy(_ => rng.Next())
                .ToArray();

            var sw = new Stopwatch();
            sw.Start();
            Sort(array, Size, 0, Size - 1);
            sw.Stop();

            Console.WriteLine($"Quick Sort: {sw.ElapsedMilliseconds}ms.");
            Console.ReadKey();
        }

        public static void Sort(int[] vetor, int tamanho, int i, int j)
        {
            int trab, esq, dir, pivo;
            esq = i;
            dir = j;

            pivo = vetor[(int)Math.Round((esq + dir) / 2.0)];
            do
            {
                while (vetor[esq] < pivo)
                {
                    esq++;
                }

                while (vetor[dir] > pivo)
                {
                    dir--;
                }

                if (esq <= dir)
                {
                    trab = vetor[esq];
                    vetor[esq] = vetor[dir];
                    vetor[dir] = trab;
                    esq++;
                    dir--;
                }
            }
            while (esq <= dir);

            if (dir - i >= 0)
            {
                Sort(vetor, tamanho, i, dir);
            }

            if (j - esq >= 0)
            {
                Sort(vetor, tamanho, esq, j);
            }
        }
    }
}
