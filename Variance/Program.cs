using System;

namespace Variance
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = args.Length;

            double[] source = new double[n];
            for (int i = 0; i < n; i++)
            {
                source[i] = double.Parse(args[i]);
            }

            double sum = 0.0;
            for (int i = 0; i < n; i++)
            {
                sum += source[i];
            }

            double mean = sum / n;

            double sumOfSquares = 0.0;
            for (int i = 0; i < n; i++)
            {
                sumOfSquares += (source[i] - mean) * (source[i] - mean);
            }

            double variance = sumOfSquares / (n - 1);

            Console.WriteLine($"분산: {variance}");
        }
    }
}
