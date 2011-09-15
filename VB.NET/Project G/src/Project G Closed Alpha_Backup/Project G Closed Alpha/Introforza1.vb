Imports System.IO

Public Class Introforza1
    Private Sub Button4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button4.Click
        If File.Exists("C:\Project G\Temp\db.projg") Then
            File.Delete("C:\Project G\Temp\db.projg")
        End If

        Intro.Close()


    End Sub

    Private Sub Button6_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button6.Click
        Opzioni.Show()

    End Sub

    Private Sub Danni_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Back.Click
        Me.Close()
        Form1.Visible = True
        Form1.Enabled = True
    End Sub

    Private Sub Button3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button3.Click

        If hp.Text = Nothing Or atk.Text = Nothing Or dif.Text = Nothing Or atksp.Text = Nothing Or difsp.Text = Nothing Or vel.Text = Nothing Then
            MsgBox("E' accaduto un errore." + vbCrLf + "Devi completare tutti i campi.")
        Else

            'Tipo(T1 + T2 + T3 +T4 + T5 + T6) * 15 / 63
            Dim T1 As Int16
            Dim T2 As Int16
            Dim T3 As Int16
            Dim T4 As Int16
            Dim T5 As Int16
            Dim T6 As Int16

            If hp.Text = "1" Or hp.Text = "3" Or hp.Text = "5" Or hp.Text = "7" Or hp.Text = "9" Or hp.Text = "11" Or hp.Text = "13" Or hp.Text = "15" Or hp.Text = "17" Or hp.Text = "19" Or hp.Text = "21" Or hp.Text = "23" Or hp.Text = "25" Or hp.Text = "27" Or hp.Text = "29" Or hp.Text = "31" Then
                T1 = 1

            Else

                T1 = 0
            End If

            If atk.Text = "1" Or atk.Text = "3" Or atk.Text = "5" Or atk.Text = "7" Or atk.Text = "9" Or atk.Text = "11" Or atk.Text = "13" Or atk.Text = "15" Or atk.Text = "17" Or atk.Text = "19" Or atk.Text = "21" Or atk.Text = "23" Or atk.Text = "25" Or atk.Text = "27" Or atk.Text = "29" Or atk.Text = "31" Then
                T2 = 2

            Else

                T2 = 0
            End If

            If dif.Text = "1" Or dif.Text = "3" Or dif.Text = "5" Or dif.Text = "7" Or dif.Text = "9" Or dif.Text = "11" Or dif.Text = "13" Or dif.Text = "15" Or dif.Text = "17" Or dif.Text = "19" Or dif.Text = "21" Or dif.Text = "23" Or dif.Text = "25" Or dif.Text = "27" Or dif.Text = "29" Or dif.Text = "31" Then
                T3 = 4

            Else

                T3 = 0
            End If

            If vel.Text = "1" Or vel.Text = "3" Or vel.Text = "5" Or vel.Text = "7" Or vel.Text = "9" Or vel.Text = "11" Or vel.Text = "13" Or vel.Text = "15" Or vel.Text = "17" Or vel.Text = "19" Or vel.Text = "21" Or vel.Text = "23" Or vel.Text = "25" Or vel.Text = "27" Or vel.Text = "29" Or vel.Text = "31" Then
                T4 = 8

            Else

                T4 = 0
            End If

            If atksp.Text = "1" Or atksp.Text = "3" Or atksp.Text = "5" Or atksp.Text = "7" Or atksp.Text = "9" Or atksp.Text = "11" Or atksp.Text = "13" Or atksp.Text = "15" Or atksp.Text = "17" Or atksp.Text = "19" Or atksp.Text = "21" Or atksp.Text = "23" Or atksp.Text = "25" Or atksp.Text = "27" Or atksp.Text = "29" Or atksp.Text = "31" Then
                T5 = 16

            Else

                T5 = 0
            End If

            If difsp.Text = "1" Or difsp.Text = "3" Or difsp.Text = "5" Or difsp.Text = "7" Or difsp.Text = "9" Or difsp.Text = "11" Or difsp.Text = "13" Or difsp.Text = "15" Or difsp.Text = "17" Or difsp.Text = "19" Or difsp.Text = "21" Or difsp.Text = "23" Or difsp.Text = "25" Or difsp.Text = "27" Or difsp.Text = "29" Or difsp.Text = "31" Then
                T6 = 32

            Else

                T6 = 0
            End If







            TextBox1.Text = Math.Truncate((T1 + T2 + T3 + T4 + T5 + T6) * 15 / 63)



            If TextBox1.Text = "0" Then
                tipo.Text = "Lotta"

            ElseIf TextBox1.Text = "1" Then
                tipo.Text = "Volante"

            ElseIf TextBox1.Text = "2" Then
                tipo.Text = "Veleno"

            ElseIf TextBox1.Text = "3" Then
                tipo.Text = "Terra"

            ElseIf TextBox1.Text = "4" Then
                tipo.Text = "Roccia"

            ElseIf TextBox1.Text = "5" Then
                tipo.Text = "Coleottero"

            ElseIf TextBox1.Text = "6" Then
                tipo.Text = "Spettro"

            ElseIf TextBox1.Text = "7" Then
                tipo.Text = "Acciaio"

            ElseIf TextBox1.Text = "8" Then
                tipo.Text = "Fuoco"

            ElseIf TextBox1.Text = "9" Then
                tipo.Text = "Acqua"

            ElseIf TextBox1.Text = "10" Then
                tipo.Text = "Erba"

            ElseIf TextBox1.Text = "11" Then
                tipo.Text = "Elettro"

            ElseIf TextBox1.Text = "12" Then
                tipo.Text = "Psico"

            ElseIf TextBox1.Text = "13" Then
                tipo.Text = "Ghiaccio"

            ElseIf TextBox1.Text = "14" Then
                tipo.Text = "Buio"

            ElseIf TextBox1.Text = "15" Then
                tipo.Text = "Buio"

            End If






            'Potenza (P1 + P2 + P3 + P4 + P5 + P6) * 40 / 63 + 30

            Dim P1 As Int16
            Dim P2 As Int16
            Dim P3 As Int16
            Dim P4 As Int16
            Dim P5 As Int16
            Dim P6 As Int16

            If hp.Text Mod 4 = 2 Or hp.Text Mod 4 = 3 Then
                P1 = 1

            Else
                P1 = 0
            End If

            If atk.Text Mod 4 = 2 Or atk.Text Mod 4 = 3 Then
                P2 = 2

            Else
                P2 = 0
            End If

            If dif.Text Mod 4 = 2 Or dif.Text Mod 4 = 3 Then
                P3 = 4

            Else
                P3 = 0
            End If

            If atksp.Text Mod 4 = 2 Or atksp.Text Mod 4 = 3 Then
                P4 = 16

            Else
                P4 = 0
            End If

            If difsp.Text Mod 4 = 2 Or difsp.Text Mod 4 = 3 Then
                P5 = 32

            Else
                P5 = 0
            End If

            If vel.Text Mod 4 = 2 Or vel.Text Mod 4 = 3 Then
                P6 = 8

            Else
                P6 = 0
            End If

            potenza.Text = Math.Truncate((P1 + P2 + P3 + P4 + P5 + P6) * 40 / 63 + 30)

        End If

    End Sub
End Class