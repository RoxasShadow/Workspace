Public Class Form1

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim pokemon As String = ComboBox1.SelectedItem
        Dim num As String = TextBox3.Text
        Dim liv As String = TextBox5.Text
        Dim pv As String = TextBox8.Text
        Dim atk1 As String = TextBox4.Text
        Dim atk2 As String = TextBox1.Text
        Dim atk3 As String = TextBox6.Text
        Dim atk4 As String = TextBox7.Text
        Dim danno1 As String = TextBox9.Text
        Dim danno2 As String = TextBox10.Text
        Dim danno3 As String = TextBox11.Text
        Dim danno4 As String = TextBox12.Text
        Dim tipop As String = TextBox13.Text
        Dim tipop2 As String = TextBox18.Text
        Dim tipo1 As String = TextBox14.Text
        Dim tipo2 As String = TextBox15.Text
        Dim tipo3 As String = TextBox16.Text
        Dim tipo4 As String = TextBox17.Text
        Dim casino As String
        Dim casino2 As String
        Dim casino3 As String
        Dim casino4 As String
        Dim fine As String


        If pokemon = Nothing Or num = Nothing Or liv = Nothing Or pv = Nothing Or tipop = Nothing Then
            MsgBox("Si prega di completare tutti i campi.")
        Else


            If CheckBox1.Checked = True Then
                casino = "<tr><td colspan=""3"">:" + tipo1 + ":" + atk1 + "(-" + danno1 + ")</td></tr>'"
            End If

            If CheckBox2.Checked = True Then
                casino2 = "<tr><td colspan=""3"">:" + tipo2 + ":" + atk2 + "(-" + danno2 + ")</td></tr>"
            End If

            If CheckBox3.Checked = True Then
                casino3 = "<tr><td colspan=""3"">:" + tipo3 + ":" + atk3 + "(-" + danno3 + ")</td></tr>"
            End If

            If CheckBox4.Checked = True Then
                casino4 = "<tr><td colspan=""3"">:" + tipo4 + ":" + atk4 + "(-" + danno4 + ")</td></tr>"
            End If

            fine = "</table></p>"



            TextBox2.Text = "<p align=""center""><table class=""gdr"" cellpadding=""0"" cellspacing=""0""><tr><td colspan=""3""></td></tr><tr><td colspan=""3"" class=""testo""><p align=""center""><b>" + pokemon + "</b> :" + tipop + ":" + "</p></td></tr><tr><td><p align=""center"">Livello " + liv + " | Pv " + pv + " [IMG]http://www.technicianpokemon.com/image/pokemon/sprite/" + num + ".png[/IMG]</p></td></tr>" + casino + casino2 + casino3 + casino4 + fine

        End If

    End Sub

    Private Sub LinkLabel1_LinkClicked(ByVal sender As System.Object, ByVal e As System.Windows.Forms.LinkLabelLinkClickedEventArgs) Handles LinkLabel1.LinkClicked
        System.Diagnostics.Process.Start("http://pokemontheorigins.forumcommunity.net/?act=Profile&MID=2183292")
    End Sub

    Private Sub LinkLabel2_LinkClicked(ByVal sender As System.Object, ByVal e As System.Windows.Forms.LinkLabelLinkClickedEventArgs) Handles LinkLabel2.LinkClicked
        System.Diagnostics.Process.Start("http://pokemontheorigins.forumcommunity.net/")

    End Sub

    Private Sub LinkLabel3_LinkClicked(ByVal sender As System.Object, ByVal e As System.Windows.Forms.LinkLabelLinkClickedEventArgs) Handles LinkLabel3.LinkClicked
        System.Diagnostics.Process.Start("http://www.technicianpokemon.com/")

    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        TextBox3.Text = ""
        TextBox5.Text = ""
        TextBox8.Text = ""
        TextBox4.Text = ""
        TextBox1.Text = ""
        TextBox6.Text = ""
        TextBox7.Text = ""
        TextBox9.Text = ""
        TextBox10.Text = ""
        TextBox11.Text = ""
        TextBox12.Text = ""
        TextBox13.Text = ""
        TextBox18.Text = ""
        TextBox14.Text = ""
        TextBox15.Text = ""
        TextBox16.Text = ""
        TextBox17.Text = ""
        TextBox2.Text = ""
        ComboBox1.Text = ""
        CheckBox1.Checked = False
        CheckBox2.Checked = False
        CheckBox3.Checked = False
        CheckBox4.Checked = False
    End Sub
End Class
