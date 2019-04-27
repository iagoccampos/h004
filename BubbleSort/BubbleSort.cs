namespace H004
{
    using System;
    using System.Diagnostics;
    using System.Linq;

    public static class BubbleSort
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
            Sort(array, Size);
            sw.Stop();

            Console.WriteLine($"Bubble Sort: {sw.ElapsedMilliseconds}ms.");
            Console.ReadKey();
        }

        public static void Sort(int[] vetor, int tamanho)
        {
            int j = 0;
            int trab;
            bool troca = true;
            int limite = tamanho - 1;

            while (troca)
            {
                troca = false;
                for (int i = 0; i < limite; ++i)
                {
                    if (vetor[i] > vetor[i + 1])
                    {
                        trab = vetor[i];
                        vetor[i] = vetor[i + 1];
                        vetor[i + 1] = trab;
                        j = i;
                        troca = true;
                    }
                }

                limite = j;
            }
        }
    }
}
