Public Class TrovaPrimi

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim a As Integer = TextBox1.Text 'Il numero dato reso come integer
        Dim input As String = TextBox1.Text 'Il numero dato reso come stringa
        Dim i As Integer = 2

        For i = 2 To a / 2
            Dim contatore As String = i 'Il contatore reso come stringa
            Dim div As String = a / 2 + 1
            Dim div2 As Integer = a / 2 + 1
            If (a Mod i = 0) Then
                'E' inutile fare i seguenti calcoli, se il resto è 0 non è un numero primo.
                TextBox2.Text = input + " non è un numero primo. Esso è divisibile per " + contatore + "."
                Exit For
            ElseIf (i <> div2) Then
                TextBox2.Text = input + " non è un numero primo. Esso è, per esempio, divisibile per " + contatore + ". div= " + div
                Exit For
            Else
                TextBox2.Text = input + " è un numero primo."
                Exit For
            End If
        Next


    End Sub
End Class
