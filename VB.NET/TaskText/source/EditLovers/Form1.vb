Imports Microsoft.Win32
Public Class Form1

    Private Sub RadioButton1_CheckedChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles RadioButton1.CheckedChanged

    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click


        Dim key As RegistryKey
        key = Registry.CurrentUser.CreateSubKey("Control Panel\\International")
        key.SetValue("s1159", TextBox1.Text)
        key.SetValue("s2359", TextBox1.Text)







        If RadioButton1.Checked Then
            key.SetValue("sTimeFormat", "tt H.mm.ss")
            key.Close()
        ElseIf RadioButton2.Checked Then
            key.SetValue("sTimeFormat", "H.mm.ss tt")
            key.Close()

        ElseIf Not RadioButton1.Checked And RadioButton2.Checked Then
            MsgBox("Si prega di selezionare una delle due opzioni")

        End If

        'Controlliamo...

        If key.GetValue("s1159") = TextBox1.Text And key.GetValue("s2359") = TextBox1.Text And key.GetValue("sTimeFormat") = "tt H.mm.ss" Or key.GetValue("sTimeFormat") = "H.mm.ss tt" Then
            MsgBox("Operazione completata con successo." + vbCrLf + "Riavviare per rendere effettive le modifiche.")
        Else
            MsgBox("Qualcosa è andato storto." + vbCrLf + "Riprova oppure assicurati di avere i permessi da Amministratore.")
        End If

        If MessageBox.Show("Desideri riavviare ora?", "Desideri riavviare ora?", MessageBoxButtons.YesNo) = DialogResult.No Then
            Close()
        Else
            Shell("shutdown -s")
            Close()

        End If



    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        Dim key As RegistryKey
        key = Registry.CurrentUser.CreateSubKey("Control Panel\\International")

        key.SetValue("s1159", "")
        key.SetValue("s2359", "")
        key.SetValue("sTimeFormat", "H.mm.ss")





        'Controlliamo...

        If key.GetValue("s1159") = "" And key.GetValue("s2359") = "" And key.GetValue("sTimeFormat") = "H.mm.ss" Then
            MsgBox("Tutto è ritornato come prima." + vbCrLf + "Riavviare per rendere effettive le modifiche.")
        Else
            MsgBox("Qualcosa è andato storto." + vbCrLf + "Riprova oppure assicurati di avere i permessi da Amministratore.")
        End If

    End Sub
End Class
