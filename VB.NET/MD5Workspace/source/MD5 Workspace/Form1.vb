'    Il form principale che esegue criptazioni e confronti.
'    Copyright (C) 2010  Giovanni Capuano

'    This program is free software: you can redistribute it and/or modify
'    it under the terms of the GNU General Public License as published by
'    the Free Software Foundation, either version 3 of the License, or
'    (at your option) any later version.
'
'    This program is distributed in the hope that it will be useful,
'    but WITHOUT ANY WARRANTY; without even the implied warranty of
'    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
'    GNU General Public License for more details.
'
'    You should have received a copy of the GNU General Public License
'    along with this program.  If not, see <http://www.gnu.org/licenses/>.

Imports System.Security.Cryptography
Public Class Form1
    Private Function hashmd5(ByVal text As String) As String
        'Creo un oggetto per la crittografia
        Dim md5 As New Security.Cryptography.MD5CryptoServiceProvider
        'Creo un oggetto che converte in byte l' input
        Dim bytestring() As Byte = System.Text.Encoding.ASCII.GetBytes(text)
        'Converto in MD5 il testo in byte
        bytestring = md5.ComputeHash(bytestring)
        'Creo una variabile vuota
        Dim finalstring As String = Nothing
        'Converto ogni byte in stringa
        For Each bt As Byte In bytestring
            finalstring &= bt.ToString("x2")
        Next
        'Dò la stringa criptata in MD5 in output
        Return finalstring
    End Function

    Private Sub ToolStripButton1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ToolStripButton1.Click
        If TextBox1.Text <> "" Then
            TextBox2.Text = hashmd5(TextBox1.Text)
        End If

        If TextBox4.Text <> "" Then
            TextBox3.Text = hashmd5(TextBox4.Text)
        End If

    End Sub

    Private Sub ToolStripButton2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ToolStripButton2.Click
        TextBox1.Text = ""
        TextBox2.Text = ""
        TextBox3.Text = ""
        TextBox4.Text = ""
    End Sub

    Private Sub ToolStripButton3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ToolStripButton3.Click
        If TextBox1.Text <> "" And TextBox4.Text <> "" Then
            Dim a As String = hashmd5(TextBox1.Text)
            Dim b As String = hashmd5(TextBox4.Text)

            If a = b Then
                MsgBox("Gli hash in MD5 delle due stringhe sono uguali.")
            Else
                MsgBox("Gli hash in MD5 delle due stringhe non sono uguali.")
            End If
        Else
            MsgBox("Per confrontare gli hash di due stringhe devi scriverle nei box corrispondenti.")
        End If
    End Sub

    Private Sub ToolStripButton4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ToolStripButton4.Click
        InfoAbout.Show()
    End Sub
End Class