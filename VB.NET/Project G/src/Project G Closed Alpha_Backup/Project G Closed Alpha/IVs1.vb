Imports System.IO
Imports System
Imports System.Data
Imports System.Text.RegularExpressions
Imports System.Xml

Public Class IVs1
    Private Sub Button4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button4.Click
        If File.Exists("C:\Project G\Temp\db.projg") Then
            File.Delete("C:\Project G\Temp\db.projg")
        End If

        Intro.Close()

    End Sub

    Private Sub Button6_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button6.Click
        Opzioni.Show()

    End Sub

    Private Sub Button3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button3.Click


        'Inizio IVs1231[...]

        Dim pokemon As String = ComboBox1.SelectedItem
        Dim naturabox As String = ComboBox2.SelectedItem
        Dim naturaatk As String
        Dim naturadif As String
        Dim naturaatksp As String
        Dim naturadifsp As String
        Dim naturavel As String

        'Controllo
        If liv.Text = Nothing Or pokemon = Nothing Or naturabox = Nothing Or hp.Text = Nothing Or atk.Text = Nothing Or dif.Text = Nothing Or atksp.Text = Nothing Or difsp.Text = Nothing Or vel.Text = Nothing Or hpe.Text = Nothing Or atke.Text = Nothing Or dife.Text = Nothing Or atkspe.Text = Nothing Or difspe.Text = Nothing Or vele.Text = Nothing Then
            MsgBox("E' accaduto un errore." + vbCrLf + "Devi completare tutti i campi.")

        Else


            If naturabox = "Adamant" Then
                naturaatk = 1.1
                naturaatksp = 0.9
                naturadif = 1
                naturadifsp = 1
                naturavel = 1
            End If

            If naturabox = "Bashful" Then
                naturaatk = 1
                naturadif = 1
                naturaatksp = 1
                naturadifsp = 1
                naturavel = 1
            End If

            If naturabox = "Bold" Then
                naturadif = 1.1
                naturaatk = 0.9
                naturaatksp = 1
                naturadifsp = 1
                naturavel = 1
            End If

            If naturabox = "Brave" Then
                naturaatk = 1.1
                naturavel = 0.9
                naturadif = 1
                naturaatksp = 1
                naturadifsp = 1
            End If

            If naturabox = "Calm" Then
                naturadifsp = 1.1
                naturaatk = 0.9
                naturadif = 1
                naturaatksp = 1
                naturavel = 1
            End If

            If naturabox = "Careful" Then
                naturadifsp = 1.1
                naturaatk = 0.9
                naturadif = 1
                naturaatksp = 1
                naturavel = 1
            End If

            If naturabox = "Docile" Then
                naturaatk = 1
                naturadif = 1
                naturaatksp = 1
                naturadifsp = 1
                naturavel = 1
            End If

            If naturabox = "Gentle" Then
                naturadifsp = 1.1
                naturadif = 0.9
                naturaatk = 1
                naturaatksp = 1
                naturavel = 1
            End If

            If naturabox = "Hardy" Then
                naturaatk = 1
                naturadif = 1
                naturaatksp = 1
                naturadifsp = 1
                naturavel = 1
            End If

            If naturabox = "Hasty" Then
                naturavel = 1.1
                naturadif = 0.9
                naturaatk = 1
                naturaatksp = 1
                naturadifsp = 1

            End If

            If naturabox = "Impish" Then
                naturadif = 1.1
                naturaatksp = 0.9
                naturaatk = 1
                naturadifsp = 1
                naturavel = 1
            End If

            If naturabox = "Jolly" Then
                naturavel = 1.1
                naturaatksp = 0.9
                naturaatk = 1
                naturadif = 1
                naturadifsp = 1
            End If

            If naturabox = "Lax" Then
                naturadif = 1.1
                naturadifsp = 0.9
                naturaatk = 1
                naturaatksp = 1
                naturavel = 1
            End If

            If naturabox = "Lonely" Then
                naturaatk = 1.1
                naturaatksp = 0.9
                naturadif = 1
                naturadifsp = 1
                naturavel = 1
            End If

            If naturabox = "Mild" Then
                naturaatksp = 1.1
                naturadif = 0.9
                naturaatk = 1
                naturadifsp = 1
                naturavel = 1
            End If

            If naturabox = "Modest" Then
                naturaatksp = 1.1
                naturaatk = 0.9
                naturadif = 1
                naturadifsp = 1
                naturavel = 1
            End If

            If naturabox = "Naive" Then
                naturavel = 1.1
                naturadifsp = 0.9
                naturaatk = 1
                naturadif = 1
                naturaatksp = 1
            End If

            If naturabox = "Naughty" Then
                naturaatk = 1.1
                naturadifsp = 0.9
                naturadif = 1
                naturaatksp = 1
                naturavel = 1
            End If

            If naturabox = "Quiet" Then
                naturaatksp = 1.1
                naturavel = 0.9
                naturaatk = 1
                naturadif = 1
                naturadifsp = 1
            End If

            If naturabox = "Quirky" Then
                naturaatk = 1
                naturadif = 1
                naturaatksp = 1
                naturadifsp = 1
                naturavel = 1
            End If

            If naturabox = "Rash" Then
                naturaatksp = 1.1
                naturadifsp = 0.9
                naturaatk = 1
                naturadif = 1
                naturavel = 1
            End If

            If naturabox = "Lax" Then
                naturadif = 1.1
                naturavel = 0.9
                naturaatk = 1
                naturaatksp = 1
                naturadifsp = 1
            End If

            If naturabox = "Sassy" Then
                naturadifsp = 1.1
                naturavel = 0.9
                naturaatk = 1
                naturadif = 1
                naturaatksp = 1
            End If

            If naturabox = "Serious" Then
                naturaatk = 1
                naturadif = 1
                naturaatksp = 1
                naturadifsp = 1
                naturavel = 1
            End If

            If naturabox = "Timid" Then
                naturavel = 1.1
                naturaatk = 0.9
                naturadif = 1
                naturaatksp = 1
                naturadifsp = 1
            End If






            'Calcolatore IVs1231


            Dim pathxml As String
            pathxml = "C:\Project G\Data\P-16E64DB\" + pokemon + ".xml"

            If Not File.Exists(pathxml) Then
                MsgBox("E' accaduto un errore." + vbCrLf + "Il Pokèmon da te selezionato non è stato trovato nel database.")
            Else


                Dim xml As XmlReader
                xml = XmlReader.Create(pathxml)

                xml.ReadToFollowing("pokemon")
                xml.ReadToFollowing("nome")
                xml.ReadToFollowing("Abilità1")
                xml.ReadToFollowing("Abilità2")
                xml.ReadToFollowing("Numero")
                xml.ReadToFollowing("HP")

                Dim HPBase As String = (xml.ReadElementContentAsString())

                xml.ReadToFollowing("Atk")

                Dim atkBase As String = (xml.ReadElementContentAsString())

                xml.ReadToFollowing("Dif")

                Dim difBase As String = (xml.ReadElementContentAsString())

                xml.ReadToFollowing("AtkSp")

                Dim atkspBase As String = (xml.ReadElementContentAsString())

                xml.ReadToFollowing("DifSp")

                Dim difspBase As String = (xml.ReadElementContentAsString())

                xml.ReadToFollowing("Vel")

                Dim velBase As String = (xml.ReadElementContentAsString())



                'Atk IVs1231
                TextBox3.Text = ((Math.Round((atk.Text / naturaatk)) - 5) * 100 / liv.Text) - 2 * atkBase - atke.Text / 4

                'Dif IVs1231
                TextBox6.Text = ((Math.Round((dif.Text / naturadif)) - 5) * 100 / liv.Text) - 2 * difBase - dife.Text / 4

                'Atksp IVs1231
                TextBox4.Text = ((Math.Round((atksp.Text / naturaatksp)) - 5) * 100 / liv.Text) - 2 * atkspBase - atkspe.Text / 4

                'Difsp IVs1231
                TextBox5.Text = ((Math.Round((difsp.Text / naturadifsp)) - 5) * 100 / liv.Text) - 2 * difspBase - difspe.Text / 4

                'Vel IVs1231
                TextBox2.Text = ((Math.Round((vel.Text / naturavel)) - 5) * 100 / liv.Text) - 2 * velBase - vele.Text / 4

                'HP IVs1231
                TextBox7.Text = ((hp.Text - liv.Text - 10) * 100 / liv.Text) - 2 * HPBase - hpe.Text / 4


                'Fine IVs1231[...]
        End If
        End If

  


    End Sub
    Private Sub Danni_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Back.Click
        Me.Close()
        Form1.Visible = True
        Form1.Enabled = True
    End Sub
End Class
