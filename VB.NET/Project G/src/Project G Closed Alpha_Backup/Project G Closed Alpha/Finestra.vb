Imports System.Xml
Imports System.IO
Public Class Finestra
    Private Sub RadioButton1_CheckedChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles RadioButton1.CheckedChanged

        Dim myXmlTextWriter As XmlTextWriter = New XmlTextWriter("C:\Project G\settings\finestra.xml", System.Text.Encoding.UTF8)
        myXmlTextWriter.Formatting = System.Xml.Formatting.Indented
        myXmlTextWriter.WriteStartDocument(False)

        myXmlTextWriter.WriteStartElement("finestra")

        myXmlTextWriter.WriteStartElement("bordo")
        myXmlTextWriter.WriteString("Si")

        myXmlTextWriter.Flush()
        myXmlTextWriter.Close()


        Form1.FormBorderStyle = FormBorderStyle.FixedDialog
        Form1.BackColor = Color.Empty
        Form1.ControlBox = False

        Introforza1.FormBorderStyle = FormBorderStyle.FixedDialog
        Introforza1.BackColor = Color.Empty
        Introforza1.ControlBox = False

        IVs1.FormBorderStyle = FormBorderStyle.FixedDialog
        IVs1.BackColor = Color.Empty
        IVs1.ControlBox = False

        PokedexPG1.FormBorderStyle = FormBorderStyle.FixedDialog
        PokedexPG1.BackColor = Color.Empty
        PokedexPG1.ControlBox = False
    End Sub

    Private Sub RadioButton2_CheckedChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles RadioButton2.CheckedChanged
        Dim myXmlTextWriter As XmlTextWriter = New XmlTextWriter("C:\Project G\settings\finestra.xml", System.Text.Encoding.UTF8)
        myXmlTextWriter.Formatting = System.Xml.Formatting.Indented
        myXmlTextWriter.WriteStartDocument(False)

        myXmlTextWriter.WriteStartElement("finestra")

        myXmlTextWriter.WriteStartElement("bordo")
        myXmlTextWriter.WriteString("No")

        myXmlTextWriter.Flush()
        myXmlTextWriter.Close()


        Form1.FormBorderStyle = Windows.Forms.FormBorderStyle.None
        Form1.BackColor = Color.Tan
        Form1.ControlBox = False

        Introforza1.FormBorderStyle = Windows.Forms.FormBorderStyle.None
        Introforza1.BackColor = Color.Tan
        Introforza1.ControlBox = False

        IVs1.FormBorderStyle = Windows.Forms.FormBorderStyle.None
        IVs1.BackColor = Color.Tan
        IVs1.ControlBox = False

        PokedexPG1.FormBorderStyle = Windows.Forms.FormBorderStyle.None
        PokedexPG1.BackColor = Color.Tan
        PokedexPG1.ControlBox = False
    End Sub

    Private Sub Button4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button4.Click
        Opzioni.Show()
        Me.Close()
    End Sub
End Class