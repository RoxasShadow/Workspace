Public Class Form1

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click

        Dim a As String = TextBox1.Text
        Dim b As String = TextBox2.Text
        Dim c As String = TextBox3.Text
        Dim formulapos As String
        formulapos = (-b + Math.Sqrt(b * b - 4 * a * c)) / (2 * a)
        Dim formulaneg As String
        formulaneg = (-b - Math.Sqrt(b * b - 4 * a * c)) / (2 * a)

        TextBox5.Text = formulaneg
        TextBox4.Text = formulapos

    End Sub
End Class
