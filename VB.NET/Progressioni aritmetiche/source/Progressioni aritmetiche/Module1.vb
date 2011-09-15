Imports System.IO

Module Module1

    Sub Main()
        Dim cond As Int16 'Una variabile per decidere se stampare su file o meno.
        Dim ragione As Int32 'Ragione
        Dim n As Int32 'Numero di valori
        Dim start As Int32 'Numero di partenza
        Dim res As String 'Risultato

        'Creo la gestione degli errori con Try..Catch
        Try

            'Ottengo i dati
            Console.WriteLine("<<< Progressione aritmetica >>>")
            Console.WriteLine("<<< Scritto in Vb.NET il 10/11/10 da Giovanni Capuano >>>")
            Console.WriteLine("")
            Console.WriteLine("Digita 0 se vuoi visualizare i risultati nella console, premi 1 se invece vuoi che vengano scritti su un file di testo.")
            cond = Console.ReadLine
            Console.WriteLine("Inserisci la Ragione")
            ragione = Console.ReadLine
            Console.WriteLine("Inserisci il numero di valori che vuoi cercare")
            n = Console.ReadLine
            Console.WriteLine("Inserisci il numero di partenza")
            start = Console.ReadLine
            Console.WriteLine("")

            If cond = 0 Then 'Se si richiede di stampare su console eseguo
                'Creo un ciclo iterativo settando il contatore come il numero di partenza e come fine il numero di valori da cercare
                For i = start To n
                    res = i * ragione  'i è il contatore che aumenta di 1 ad ogni iterazione che si moltiplica per la ragione ottenendo la sequenza
                    Console.WriteLine(res)
                Next

            ElseIf cond = 1 Then 'Altrimenti stampo su un file nella directory di avvio
                Using writer As New StreamWriter("progressione.txt") 'Creo uno StreamWriter se si sceglie di scrivere i risultati su file
                    For i = start To n
                        res = i * ragione
                        writer.WriteLine(res) 'E ci scrivo
                    Next
                End Using
                Console.WriteLine("")
                Console.WriteLine("E' stato creato il file progressione.txt contenente la progressione generata.")
            End If

            Console.WriteLine("")
            Console.WriteLine("La progressione si è conclusa. Premi un tasto per continuare.")
            Console.ReadKey()

        Catch 'Un errore generale
            Console.WriteLine("E' accaduto un errore.")
            Console.WriteLine("Premere un tasto per continuare.")
            Console.ReadKey()
        End Try
    End Sub
End Module
