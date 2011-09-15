Module Module1

    Sub Main()
        Dim Nome(499) As String
        Dim Abilità1(499) As String
        'Dim Abilità2() As String

        'Ovviamente tu puoi dare nomi più appropriati a seconda di cosa rappresentano: Attacco, difesa ecc...

        'Qui metti il percorso del file .txt da leggere
        Dim P As String = "C:\Project G\Pokemon.txt"

        If Not IO.File.Exists(P) Then
            Console.WriteLine("Percorso errato")
            Console.ReadKey()
        Else
            Dim rd As New IO.StreamReader(P)
            Dim tmp As Array
            Dim I As Int16 = 0
            Do While Not rd.EndOfStream
                tmp = rd.ReadLine.Split(",")
                Nome(I) = tmp(0)
                Abilità1(I) = tmp(1)
                '           Abilità2(I) = tmp(2)
                I += 1
            Loop
            rd.Close()
        End If
        'Ora hai tutte le info dei Pokèmon, non ci resta che creare i vari file .xml
        'Scegliamo la Directory in cui salvarli [è evidente che dovrai modificarla]:
        Dim Dir As String = "C:\Project G\Data\T-1F2890\"
        For I = 0 To 498
            Dim F As String = Dir & Nome(I) & ".xml" 'Creo il file con il nome del Pokèmon [Se vuoi creare i file numerati basta usare la riga seguente]
            'Dim F As String = Dir & (I + 1) & ".xml"
            Dim wr As New IO.StreamWriter(F)
            'Qui creo la stringa che sarà scritta nel file .xml [Puoi completarla tu, basta continuare con Num2.... fino a Num7].
            Dim str As String = "<pokemon>" & vbCrLf & "<nome>" & Nome(I) & "</nome>" & vbCrLf & "<tipo1>" & Abilità1(I) & "</tipo1>" & vbCrLf & "</pokemon>"
            wr.Write(str)
            wr.Close()
        Next

    End Sub

End Module