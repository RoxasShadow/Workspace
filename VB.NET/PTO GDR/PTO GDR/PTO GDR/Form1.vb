Imports System
Imports System.IO

Public Class Form1

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click

        If TextBox3.Text = Nothing Then
            MsgBox("Compilare il form Nome Pokèmon con il nome del Pokèmon." + vbCrLf + "Per maggiori informazioni aprire la Guida")
        Else
            WebBrowser1.Navigate("http://www.smogon.com/dp/pokemon/" + TextBox3.Text)
        End If
    End Sub
    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click

        If TextBox3.Text = Nothing Then
            MsgBox("Compilare il form Nome Pokèmon con il nome del Pokèmon." + vbCrLf + "Per maggiori informazioni aprire la Guida")
        Else
            WebBrowser1.Navigate("http://www.pcentral.it/wiki/" + TextBox3.Text)
        End If
    End Sub
    Private Sub Button5_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button5.Click

        If TextBox4.Text = Nothing Then
            MsgBox("Compilare il form Nome Mossa con il nome della mossa." + vbCrLf + "Per maggiori informazioni aprire la Guida")
        Else
            WebBrowser1.Navigate("http://www.pcentral.it/wiki/" + TextBox4.Text + "_(mossa)")
        End If

    End Sub
    Private Sub Button6_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button6.Click
        WebBrowser1.Navigate("http://pokemontheorigins.forumcommunity.net")
    End Sub
    Private Sub Button4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button4.Click
        'PV

        Dim liv As String = TextBox1.Text
        Dim hp As String = TextBox2.Text
        Dim stadio As String = ComboBox1.SelectedItem
        Dim operstadio As Integer
        Dim operstadio2 As Integer
        Dim operstadio3 As Integer

        If stadio = "Primo Stadio" Then
            operstadio = 5
            operstadio2 = 10
            operstadio3 = 15
        End If

        If stadio = "Secondo Stadio" Then
            operstadio = 10
            operstadio2 = 20
            operstadio3 = 10
        End If

        If stadio = "Terzo Stadio" Then
            operstadio = 15
            operstadio2 = 30
            operstadio3 = 5
        End If




        If liv = Nothing Or hp = Nothing Then
            MsgBox("Alcuni form non sono stati compilati." + vbCrLf + "I form HP, Livello e Stadio sono obbligatori.")

        Else
            Dim op As Integer = ((liv + operstadio) * 3) + (hp + operstadio2)
            Dim str As String = op
            TextBox6.Text = str
        End If



    End Sub

    Private Sub Button3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button3.Click
        'PP

        Dim pp As String = TextBox5.Text
        Dim liv As String = TextBox1.Text
        Dim stadio As String = ComboBox1.SelectedItem
        Dim operstadio As Integer
        Dim operstadio2 As Integer
        Dim operstadio3 As Integer

        If stadio = "Primo Stadio" Then
            operstadio = 5
            operstadio2 = 10
            operstadio3 = 15
        End If

        If stadio = "Secondo Stadio" Then
            operstadio = 10
            operstadio2 = 20
            operstadio3 = 10
        End If

        If stadio = "Terzo Stadio" Then
            operstadio = 15
            operstadio2 = 30
            operstadio3 = 5
        End If



        If liv = Nothing Or pp = Nothing Then
            MsgBox("Alcuni form non sono stati compilati." + vbCrLf + "I form PP, Livello e Stadio sono obbligatori.")

        Else
            Dim op As Integer = (liv * 2) + (pp - operstadio3)
            Dim str As String = op
            TextBox7.Text = str
        End If


    End Sub

    Private Sub LinkLabel1_LinkClicked(ByVal sender As System.Object, ByVal e As System.Windows.Forms.LinkLabelLinkClickedEventArgs) Handles LinkLabel1.LinkClicked
        WebBrowser1.Navigate("http://pokemontheorigins.forumcommunity.net/?act=Profile&MID=2183292")
    End Sub

    Private Sub LinkLabel2_LinkClicked(ByVal sender As System.Object, ByVal e As System.Windows.Forms.LinkLabelLinkClickedEventArgs) Handles LinkLabel2.LinkClicked
        WebBrowser1.Navigate("http://pokemontheorigins.forumcommunity.net/?act=Profile&MID=2843486")
    End Sub

    Private Sub LinkLabel3_LinkClicked(ByVal sender As System.Object, ByVal e As System.Windows.Forms.LinkLabelLinkClickedEventArgs) Handles LinkLabel3.LinkClicked
        WebBrowser1.Navigate("http://pokemontheorigins.forumcommunity.net/?act=Profile&MID=1532847")
    End Sub

    Private Sub Button7_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button7.Click
        Form2.Show()
    End Sub
End Class
