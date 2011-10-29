Module Module1

    Sub Main()
    	Dim count As Int16 = 656
   	Dim Dir As String = "xml"
        Dim name(count+1) As String
        Dim ability1(count+1) As String
        Dim ability2(count+1) As String
        Dim number(count+1) As String
        Dim Hp(count+1) As String
        Dim atk(count+1) As String
        Dim dif(count+1) As String
        Dim atksp(count+1) As String
        Dim difsp(count+1) As String
        Dim spe(count+1) As String

        'Qui metti il percorso del file .txt da leggere
        Dim P As String = "pokemon.txt"

        If Not IO.File.Exists(P) Then
            Console.WriteLine("Percorso errato")
            Console.ReadKey()
        Else
            Dim rd As New IO.StreamReader(P)
            Dim tmp As Array
            Dim I As Int16 = 0
            Do While Not rd.EndOfStream
                tmp = rd.ReadLine.Split(",")
                name(I) = tmp(0)
                ability1(I) = tmp(2)
                ability2(I) = tmp(3)
                number(I) = tmp(4)
                Hp(I) = tmp(5)
                atk(I) = tmp(6)
                dif(I) = tmp(7)
                atksp(I) = tmp(8)
                difsp(I) = tmp(9)
                spe(I) = tmp(10)
                I += 1
            Loop
            rd.Close()
        End If
        
        For I = 0 To count
            Dim F As String = Dir & name(I) & ".xml" 'Creo il file con il name del Pokèmon [Se vuoi creare i file numerati basta usare la riga seguente]
            Dim wr As New IO.StreamWriter(F)
            'Qui creo la stringa che sarà scritta nel file .xml [Puoi completarla tu, basta continuare con Num2.... fino a Num7].
            Dim str As String = "<pokemon>" & vbCrLf & "<name>" & name(I) & "</name>" & vbCrLf & "<ability1>" & ability1(I) & "</ability1>" & vbCrLf & "<ability2>" & ability2(I) & "</ability2>" & vbCrLf & "<number>" & number(I) & "</number>" & vbCrLf & "<Hp>" & Hp(I) & "</Hp>" & vbCrLf & "<atk>" & atk(I) & "</atk>" & vbCrLf & "<def>" & dif(I) & "</def>" & vbCrLf & "<atksp>" & atksp(I) & "</atksp>" & vbCrLf & "<difsp>" & difsp(I) & "</difsp>" & vbCrLf & "<spe>" & spe(I) & "</spe>" & vbCrLf & "</pokemon>"
            wr.Write(str)
            wr.Close()
        Next

    End Sub

End Module
