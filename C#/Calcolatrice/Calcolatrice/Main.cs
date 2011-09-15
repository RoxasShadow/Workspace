using System;

namespace Calcolatrice
{
	class Calcolatrice
	{
		public int addizione(int  a, int b) {
			int res;
			res = a + b;
			return res;
		}
		
		public int sottrazione(int  a, int b) {
			int res;
			res = a - b;
			return res;
		}
		
		public int moltiplicazione(int  a, int b) {
			int res;
			res = a * b;
			return res;
		}
		
		public int divisione(int  a, int b) {
			int res;
			res = a / b;
			return res;
		}
		
		public int quadrato(int  a) {
			int res;
			res = a * a;
			return res;
		}
		
		
		public static void Main (string[] args)
		{
			int a, b, res, op; // Dichiaro le variabili pubbliche
			
			Console.WriteLine("Ciao, benvenuto nella prima calcolatrice in C# di Giovanni Capuano!\n");
			Console.WriteLine("Per prima cosa seleziona ciò che vuoi fare seguendo il seguente schema\n");
			Console.WriteLine("Addizione -> 1\nSottrazione -> 2\nMoltiplicazione -> 3\nDivisione -> 4\nQuadrato -> 5\n");
			op = int.Parse(Console.ReadLine());
			
			if(op == 1) {
				Console.WriteLine("Digita un numero: ");
				a = int.Parse(Console.ReadLine());
				Console.WriteLine("Digita un altro numero: ");
				b = int.Parse(Console.ReadLine());
				
				Console.WriteLine(quadrato(a));
			}
		}
	}
}

