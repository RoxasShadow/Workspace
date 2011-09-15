Imports System.IO
Imports System
Imports System.Data
Imports System.Net.WebClient
Imports System.Text.RegularExpressions
Imports System.Xml

Public Class PokedexPG1
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

    Private Sub ComboBox1_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ComboBox1.SelectedIndexChanged

        'Inizio PokedexPG1[...]



        'Immagine

        Dim pokemon As String
        pokemon = ComboBox1.SelectedItem

        If ComboBox1.SelectedItem = pokemon And File.Exists("C:\Project G\Media\" + ComboBox1.SelectedItem + ".png") Then
            PictureBox3.Visible = True
            PictureBox3.Image = Image.FromFile("C:\Project G\Media\" + ComboBox1.SelectedItem + ".png")
        Else
            PictureBox3.Visible = False
        End If


        'Calcolatore Statistiche di base
        Dim pathxml As String
        pathxml = "C:\Project G\Data\P-16E64DB\" + pokemon + ".xml"

        If File.Exists(pathxml) Then


            Dim xml As XmlReader
            xml = XmlReader.Create(pathxml)

            xml.ReadToFollowing("pokemon")
            xml.ReadToFollowing("nome")
            xml.ReadToFollowing("Abilità1")

            Dim abilità1 As String = (xml.ReadElementContentAsString())

            xml.ReadToFollowing("Abilità2")

            Dim abilità2 As String = (xml.ReadElementContentAsString())

            xml.ReadToFollowing("Numero")

            Dim numero As String = (xml.ReadElementContentAsString())

            xml.ReadToFollowing("HP")

            Dim HP As String = (xml.ReadElementContentAsString())

            xml.ReadToFollowing("Atk")

            Dim atk As String = (xml.ReadElementContentAsString())

            xml.ReadToFollowing("Dif")

            Dim dif As String = (xml.ReadElementContentAsString())

            xml.ReadToFollowing("AtkSp")

            Dim atksp As String = (xml.ReadElementContentAsString())

            xml.ReadToFollowing("DifSp")

            Dim difsp As String = (xml.ReadElementContentAsString())

            xml.ReadToFollowing("Vel")

            Dim vel As String = (xml.ReadElementContentAsString())


            'Base Stats +
            Label53.Text = HP
            Label52.Text = atk
            Label51.Text = dif
            Label50.Text = atksp
            Label49.Text = difsp
            Label48.Text = vel

            'Max +
            Label59.Text = "-"
            Label58.Text = System.Math.Truncate(((((31 + 2 * atk + (252 / 4)) * 100 / 100) + 5) * 1.1))
            Label57.Text = System.Math.Truncate(((((31 + 2 * dif + (252 / 4)) * 100 / 100) + 5) * 1.1))
            Label56.Text = System.Math.Truncate(((((31 + 2 * atksp + (252 / 4)) * 100 / 100) + 5) * 1.1))
            Label55.Text = System.Math.Truncate(((((31 + 2 * difsp + (252 / 4)) * 100 / 100) + 5) * 1.1))
            Label54.Text = System.Math.Truncate(((((31 + 2 * vel + (252 / 4)) * 100 / 100) + 5) * 1.1))

            'Max
            Label65.Text = System.Math.Truncate(((31 + 2 * HP + (252 / 4)) * 100 / 100) + 10 + 100)
            Label64.Text = System.Math.Truncate(((((31 + 2 * atk + (252 / 4)) * 100 / 100) + 5) * 1))
            Label63.Text = System.Math.Truncate(((((31 + 2 * dif + (252 / 4)) * 100 / 100) + 5) * 1))
            Label62.Text = System.Math.Truncate(((((31 + 2 * atksp + (252 / 4)) * 100 / 100) + 5) * 1))
            Label61.Text = System.Math.Truncate(((((31 + 2 * difsp + (252 / 4)) * 100 / 100) + 5) * 1))
            Label60.Text = System.Math.Truncate(((((31 + 2 * vel + (252 / 4)) * 100 / 100) + 5) * 1))

            'Min
            Label71.Text = System.Math.Truncate(((31 + 2 * HP + (0 / 4)) * 100 / 100) + 10 + 100)
            Label70.Text = System.Math.Truncate(((((31 + 2 * atk + (0 / 4)) * 100 / 100) + 5) * 1))
            Label69.Text = System.Math.Truncate(((((31 + 2 * dif + (0 / 4)) * 100 / 100) + 5) * 1))
            Label68.Text = System.Math.Truncate(((((31 + 2 * atksp + (0 / 4)) * 100 / 100) + 5) * 1))
            Label67.Text = System.Math.Truncate(((((31 + 2 * difsp + (0 / 4)) * 100 / 100) + 5) * 1))
            Label66.Text = System.Math.Truncate(((((31 + 2 * vel + (0 / 4)) * 100 / 100) + 5) * 1))

            'Min -
            Label77.Text = "-"
            Label76.Text = System.Math.Truncate(((((31 + 2 * atk + (0 / 4)) * 100 / 100) + 5) * 0.9))
            Label75.Text = System.Math.Truncate(((((31 + 2 * dif + (0 / 4)) * 100 / 100) + 5) * 0.9))
            Label74.Text = System.Math.Truncate(((((31 + 2 * atksp + (0 / 4)) * 100 / 100) + 5) * 0.9))
            Label73.Text = System.Math.Truncate(((((31 + 2 * difsp + (0 / 4)) * 100 / 100) + 5) * 0.9))
            Label72.Text = System.Math.Truncate(((((31 + 2 * vel + (0 / 4)) * 100 / 100) + 5) * 0.9))

            'Abilità
            Label46.Text = abilità1

            If abilità1 = abilità2 Then
                Label45.Text = ""
            Else
                Label45.Text = abilità2
            End If 'End If Abilità


            'Fine PokedexPG1[...]













            If File.Exists("C:\Project G\Temp\db.projg") Then


                'Consulta link

                Dim Text As String = IO.File.ReadAllText("C:\Project G\Temp\db.projg")
                Dim Keywords As New Regex( _
                 pokemon, _
                RegexOptions.Multiline)
                Dim Match As Match
                Match = Keywords.Match(Text)

                'La Pagina esiste
                If Match.Success Then
                    Build.Visible = False
                    Button1.Visible = True
                    Button1.Enabled = True

                Else

                    Build.Visible = True
                    Button1.Visible = False
                    Button1.Enabled = False
                End If
            End If

        Else
            MsgBox("E' accaduto un errore." + vbCrLf + "Il Pokèmon da te selezionato non è stato trovato nel database.")
        End If
    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        If File.Exists("C:\Project G\Temp\db.projg") Then

            Dim pokemon As String
            pokemon = ComboBox1.SelectedItem

            Dim link As String
            link = "http://www.doomdesire.it/index.php?act=pokedex/" + pokemon + ".html"


            'Consulta link

            Dim Text As String = IO.File.ReadAllText("C:\Project G\Temp\db.projg")
            Dim Keywords As New Regex( _
             pokemon, _
            RegexOptions.Multiline)
            Dim Match As Match
            Match = Keywords.Match(Text)


            If Match.Success Then
                System.Diagnostics.Process.Start(link)

            Else

                Build.Visible = True
                Button1.Visible = False
                Button1.Enabled = False
            End If

        End If

    End Sub

    Private Sub Build_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Build.Click
        MsgBox("Il bottone non è attivo. I motivi possono essere due:" + vbCrLf + "Non è presente ancora alcuna scheda su questo Pokèmon in DoomDesire;" + vbCrLf + "Il database di DoomDesire è down oppure non è stato possibile scaricarlo.")
    End Sub
End Class