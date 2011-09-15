Imports System.Xml
Imports System.IO
'Imports Microsoft.DirectX
'Imports Microsoft.DirectX.AudioVideoPlayback

Public Class Musica
    Private Sub ComboBox1_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ComboBox1.SelectedIndexChanged


        Dim myXmlTextWriter As XmlTextWriter = New XmlTextWriter("C:\Project G\settings\musica.xml", System.Text.Encoding.UTF8)
        myXmlTextWriter.Formatting = System.Xml.Formatting.Indented
        myXmlTextWriter.WriteStartDocument(False)

        myXmlTextWriter.WriteStartElement("musica")

        myXmlTextWriter.WriteStartElement("selezione")
        myXmlTextWriter.WriteString(ComboBox1.SelectedItem)

        myXmlTextWriter.Flush()
        myXmlTextWriter.Close()



    End Sub

    ' Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
    '    Nascosto.Close()


    '  Dim musica As Audio

    '  If RadioButton1.Checked = True And ComboBox1.Enabled = True And Not ComboBox1.SelectedItem = Nothing Then

    'Dim path As String = "C:\Project G\Media\" + ComboBox1.SelectedItem + ".mp3"

    '  If File.Exists(path) = False Then
    'MsgBox("Questa musica non è stata trovata." + vbCrLf + "Una reinstallazione del programma dovrebbe risolvere il problema.")
    '   End If

    '    Musica = New Audio(Path)
    '   Musica.Play()

    '   Else
    '   Button1.Enabled = False
    '  End If


    '  End Sub

    Private Sub RadioButton1_Checked(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles RadioButton1.CheckedChanged

        ComboBox1.Enabled = True


    End Sub

    Private Sub RadioButton2_Checked(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles RadioButton2.CheckedChanged


        ComboBox1.Enabled = False
        File.Delete("C:\Project G\settings\musica.xml")

    End Sub

    Private Sub Button4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button4.Click
        MsgBox("Devi riavviare il programma per rendere effettive le modifiche apportate")
        Opzioni.Show()
        Me.Close()

    End Sub
End Class