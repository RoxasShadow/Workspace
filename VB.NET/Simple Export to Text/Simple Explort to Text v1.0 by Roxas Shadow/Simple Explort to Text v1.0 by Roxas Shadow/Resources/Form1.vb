Imports System
Imports System.IO
Imports System.Text

Public Class Form1

    Private Sub SalvaToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles SalvaToolStripMenuItem.Click

        'Salva il team

        Dim percorso As String
        Dim contenuto As String
        percorso = TextBox2.Text + ".ett"
        contenuto = TextBox1.Text
        File.WriteAllText(percorso, contenuto)
        MessageBox.Show(TextBox2.Text + ".ett" + " è stato salvato con successo!")



    End Sub

    Private Sub GeneraToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles GeneraToolStripMenuItem.Click
        '                                                                          #1

        Dim hp As String
        hp = ComboBox2.SelectedItem

        If hp = "Hidden Power" Then
            hp = ComboBox2.SelectedItem + " [" + ComboBox8.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox2.SelectedItem

        End If

        Dim hp2 As String
        hp2 = ComboBox4.SelectedItem

        If hp2 = "Hidden Power" Then
            hp2 = ComboBox4.SelectedItem + " [" + ComboBox8.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox4.SelectedItem

        End If


        Dim hp3 As String
        hp3 = ComboBox5.SelectedItem

        If hp3 = "Hidden Power" Then
            hp3 = ComboBox5.SelectedItem + " [" + ComboBox8.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox5.SelectedItem

        End If

        Dim hp4 As String
        hp4 = ComboBox6.SelectedItem

        If hp4 = "Hidden Power" Then
            hp4 = ComboBox6.SelectedItem + " [" + ComboBox8.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox6.SelectedItem

        End If




        '                                                                          #2


        Dim hp5 As String
        hp5 = ComboBox17.SelectedItem

        If hp5 = "Hidden Power" Then
            hp5 = ComboBox17.SelectedItem + " [" + ComboBox14.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox17.SelectedItem

        End If

        Dim hp6 As String
        hp6 = ComboBox18.SelectedItem

        If hp6 = "Hidden Power" Then
            hp6 = ComboBox18.SelectedItem + " [" + ComboBox14.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox18.SelectedItem

        End If


        Dim hp7 As String
        hp7 = ComboBox19.SelectedItem

        If hp7 = "Hidden Power" Then
            hp7 = ComboBox19.SelectedItem + " [" + ComboBox14.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox19.SelectedItem

        End If

        Dim hp8 As String
        hp8 = ComboBox20.SelectedItem

        If hp8 = "Hidden Power" Then
            hp8 = ComboBox20.SelectedItem + " [" + ComboBox14.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox20.SelectedItem

        End If






        '                                                                          #3


        Dim hp9 As String
        hp9 = ComboBox27.SelectedItem

        If hp9 = "Hidden Power" Then
            hp9 = ComboBox27.SelectedItem + " [" + ComboBox24.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox27.SelectedItem

        End If

        Dim hp10 As String
        hp10 = ComboBox28.SelectedItem

        If hp10 = "Hidden Power" Then
            hp10 = ComboBox28.SelectedItem + " [" + ComboBox24.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox28.SelectedItem

        End If

        Dim hp11 As String
        hp11 = ComboBox29.SelectedItem

        If hp11 = "Hidden Power" Then
            hp11 = ComboBox29.SelectedItem + " [" + ComboBox24.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox29.SelectedItem

        End If

        Dim hp12 As String
        hp12 = ComboBox30.SelectedItem

        If hp12 = "Hidden Power" Then
            hp12 = ComboBox30.SelectedItem + " [" + ComboBox24.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox30.SelectedItem

        End If




        '                                                                          #4


        Dim hp13 As String
        hp13 = ComboBox37.SelectedItem

        If hp13 = "Hidden Power" Then
            hp13 = ComboBox37.SelectedItem + " [" + ComboBox34.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox37.SelectedItem

        End If


        Dim hp14 As String
        hp14 = ComboBox38.SelectedItem

        If hp14 = "Hidden Power" Then
            hp14 = ComboBox38.SelectedItem + " [" + ComboBox34.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox38.SelectedItem

        End If


        Dim hp15 As String
        hp15 = ComboBox39.SelectedItem

        If hp15 = "Hidden Power" Then
            hp15 = ComboBox39.SelectedItem + " [" + ComboBox34.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox39.SelectedItem

        End If


        Dim hp16 As String
        hp16 = ComboBox40.SelectedItem

        If hp16 = "Hidden Power" Then
            hp16 = ComboBox40.SelectedItem + " [" + ComboBox34.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox40.SelectedItem

        End If


        '                                                                          #5


        Dim hp17 As String
        hp17 = ComboBox47.SelectedItem

        If hp17 = "Hidden Power" Then
            hp17 = ComboBox47.SelectedItem + " [" + ComboBox44.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox47.SelectedItem

        End If


        Dim hp18 As String
        hp18 = ComboBox48.SelectedItem

        If hp18 = "Hidden Power" Then
            hp18 = ComboBox48.SelectedItem + " [" + ComboBox44.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox48.SelectedItem

        End If

        Dim hp19 As String
        hp19 = ComboBox49.SelectedItem

        If hp19 = "Hidden Power" Then
            hp19 = ComboBox49.SelectedItem + " [" + ComboBox44.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox49.SelectedItem

        End If


        Dim hp20 As String
        hp20 = ComboBox50.SelectedItem

        If hp20 = "Hidden Power" Then
            hp20 = ComboBox50.SelectedItem + " [" + ComboBox44.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox50.SelectedItem

        End If


        '                                                                          #6


        Dim hp21 As String
        hp21 = ComboBox57.SelectedItem

        If hp21 = "Hidden Power" Then
            hp21 = ComboBox57.SelectedItem + " [" + ComboBox54.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox57.SelectedItem

        End If


        Dim hp22 As String
        hp22 = ComboBox58.SelectedItem

        If hp22 = "Hidden Power" Then
            hp22 = ComboBox58.SelectedItem + " [" + ComboBox54.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox58.SelectedItem

        End If


        Dim hp23 As String
        hp23 = ComboBox59.SelectedItem

        If hp23 = "Hidden Power" Then
            hp23 = ComboBox59.SelectedItem + " [" + ComboBox54.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox49.SelectedItem

        End If


        Dim hp24 As String
        hp24 = ComboBox60.SelectedItem

        If hp24 = "Hidden Power" Then
            hp24 = ComboBox60.SelectedItem + " [" + ComboBox54.SelectedItem + "]"

        Else
            TextBox1.Text = ComboBox60.SelectedItem

        End If


        Dim sesso1 As String
        If ComboBox3.SelectedItem = "Maschio" Then
            sesso1 = "(M)"
        ElseIf ComboBox3.SelectedItem = "Femmina" Then
            sesso1 = "(F)"
        ElseIf ComboBox3.SelectedItem = "???" Then
            sesso1 = ""
        End If

        Dim sesso2 As String
        If ComboBox16.SelectedItem = "Maschio" Then
            sesso1 = "(M)"
        ElseIf ComboBox16.SelectedItem = "Femmina" Then
            sesso1 = "(F)"
        ElseIf ComboBox16.SelectedItem = "???" Then
            sesso1 = ""
        End If

        Dim sesso3 As String
        If ComboBox26.SelectedItem = "Maschio" Then
            sesso1 = "(M)"
        ElseIf ComboBox26.SelectedItem = "Femmina" Then
            sesso1 = "(F)"
        ElseIf ComboBox26.SelectedItem = "???" Then
            sesso1 = ""
        End If

        Dim sesso4 As String
        If ComboBox36.SelectedItem = "Maschio" Then
            sesso1 = "(M)"
        ElseIf ComboBox36.SelectedItem = "Femmina" Then
            sesso1 = "(F)"
        ElseIf ComboBox36.SelectedItem = "???" Then
            sesso1 = ""
        End If

        Dim sesso5 As String
        If ComboBox46.SelectedItem = "Maschio" Then
            sesso1 = "(M)"
        ElseIf ComboBox46.SelectedItem = "Femmina" Then
            sesso1 = "(F)"
        ElseIf ComboBox46.SelectedItem = "???" Then
            sesso1 = ""
        End If

        Dim sesso6 As String
        If ComboBox56.SelectedItem = "Maschio" Then
            sesso1 = "(M)"
        ElseIf ComboBox56.SelectedItem = "Femmina" Then
            sesso1 = "(F)"
        ElseIf ComboBox56.SelectedItem = "???" Then
            sesso1 = ""
        End If



        'Genera

        TextBox1.Text = TextBox2.Text & ControlChars.CrLf & ControlChars.CrLf & TextBox3.Text & ControlChars.CrLf & ControlChars.CrLf & ComboBox1.SelectedItem & " " & sesso1 & " " & "@ " & ComboBox9.SelectedItem & ControlChars.CrLf & "Ability: " & ComboBox7.SelectedItem & ControlChars.CrLf & "EVs: " & ControlChars.CrLf & ComboBox10.SelectedItem & " nature" & ControlChars.CrLf & " - " & hp & ControlChars.CrLf & " - " & hp2 & ControlChars.CrLf & " - " & hp3 & ControlChars.CrLf & " - " & hp4 & ControlChars.CrLf & " ------------- " & ControlChars.CrLf & ControlChars.CrLf & ControlChars.CrLf & ComboBox15.SelectedItem & " " & sesso2 & " " & "@ " & ComboBox13.SelectedItem & ControlChars.CrLf & "Ability: " & ComboBox12.SelectedItem & ControlChars.CrLf & "EVs: " & ControlChars.CrLf & ComboBox11.SelectedItem & " nature" & ControlChars.CrLf & " - " & hp5 & ControlChars.CrLf & " - " & hp6 & ControlChars.CrLf & " - " & hp7 & ControlChars.CrLf & " - " & hp8 & ControlChars.CrLf & " ------------- " & ControlChars.CrLf & ControlChars.CrLf & ControlChars.CrLf & ComboBox25.SelectedItem & " " & sesso3 & " " & "@ " & ComboBox23.SelectedItem & ControlChars.CrLf & "Ability: " & ComboBox22.SelectedItem & ControlChars.CrLf & "EVs: " & ControlChars.CrLf & ComboBox21.SelectedItem & " nature" & ControlChars.CrLf & " - " & hp9 & ControlChars.CrLf & " - " & hp10 & ControlChars.CrLf & " - " & hp11 & ControlChars.CrLf & " - " & hp12 & ControlChars.CrLf & " ------------- " & ControlChars.CrLf & ControlChars.CrLf & ControlChars.CrLf & ComboBox35.SelectedItem & " " & sesso4 & " " & "@ " & ComboBox33.SelectedItem & ControlChars.CrLf & "Ability: " & ComboBox32.SelectedItem & ControlChars.CrLf & "EVs: " & ControlChars.CrLf & ComboBox31.SelectedItem & " nature" & ControlChars.CrLf & " - " & hp13 & ControlChars.CrLf & " - " & hp14 & ControlChars.CrLf & " - " & hp15 & ControlChars.CrLf & " - " & hp16 & ControlChars.CrLf & " ------------- " & ControlChars.CrLf & ControlChars.CrLf & ControlChars.CrLf & ComboBox1.SelectedItem & " " & sesso5 & " " & "@ " & ComboBox9.SelectedItem & ControlChars.CrLf & "Ability: " & ComboBox7.SelectedItem & ControlChars.CrLf & "EVs: " & ControlChars.CrLf & ComboBox10.SelectedItem & " nature" & ControlChars.CrLf & " - " & hp17 & ControlChars.CrLf & " - " & hp18 & ControlChars.CrLf & " - " & hp19 & ControlChars.CrLf & " - " & hp20 & ControlChars.CrLf & " ------------- " & ControlChars.CrLf & ControlChars.CrLf & ControlChars.CrLf & ComboBox55.SelectedItem & " " & sesso6 & " " & "@ " & ComboBox53.SelectedItem & ControlChars.CrLf & "Ability: " & ComboBox52.SelectedItem & ControlChars.CrLf & "EVs: " & ControlChars.CrLf & ComboBox51.SelectedItem & " nature" & ControlChars.CrLf & " - " & hp21 & ControlChars.CrLf & " - " & hp22 & ControlChars.CrLf & " - " & hp23 & ControlChars.CrLf & " - " & hp24 & ControlChars.CrLf & " ------------- " & ControlChars.CrLf & ControlChars.CrLf & ControlChars.CrLf



    End Sub

    Private Sub CaricaToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles CaricaToolStripMenuItem.Click
        'Carica il team

        Dim MyFile As New FileInfo(TextBox2.Text + ".ett")
        If MyFile.Exists() Then

            Dim fileReader As String
            fileReader = My.Computer.FileSystem.ReadAllText(TextBox2.Text + ".ett")
            TextBox1.Text = fileReader

        Else
            MessageBox.Show("E' accaduto un errore. Non è stato possibile trovare un un team sotto il nome di " + TextBox2.Text + ".ett")
        End If

    End Sub

    Private Sub EliminaToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles EliminaToolStripMenuItem.Click
        'Elimina

        Dim fi As New FileInfo(TextBox2.Text + ".ett")

        fi.Delete()


        Dim MyFile As New FileInfo(TextBox2.Text + ".ett")
        If MyFile.Exists() Then
            MessageBox.Show("E' accaduto un errore. Non è stato possibile eliminare" + TextBox2.Text + ".ett")
        Else
            MessageBox.Show(TextBox2.Text + ".ett" + " è stato eliminato con successo")
        End If


    End Sub

    Private Sub PulisciToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles PulisciToolStripMenuItem.Click
        'Pulisci
        TextBox1.Text = ""
        TextBox3.Text = ""

    End Sub

    Private Sub Form2_Load(ByVal sender As System.Object, ByVal e As System.EventArgs)
        'About

        Dim about As New hidden()
        about.Show()
    End Sub

    Private Sub EsciToolStripMenuItem_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles EsciToolStripMenuItem.Click
        Close()

    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        TextBox1.TextAlign = HorizontalAlignment.Center

    End Sub

    Private Sub Button3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button3.Click
        TextBox1.TextAlign = HorizontalAlignment.Left
    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        TextBox1.TextAlign = HorizontalAlignment.Right
    End Sub

    Private Sub Button4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button4.Click
        'HTML

        Dim html As New Form3()
        html.Show()

    End Sub
End Class
