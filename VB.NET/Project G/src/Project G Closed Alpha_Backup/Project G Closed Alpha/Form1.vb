Imports System.IO

Public Class Form1
    Private Sub Tools_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Tools.Click

        Danni.Visible = True
        Danni.Enabled = True
        Introforza.Visible = True
        Introforza.Enabled = True
        IVs.Visible = True
        IVs.Enabled = True
        Pokèdex.Visible = True
        Pokèdex.Enabled = True
        Varie.Visible = True
        Varie.Enabled = True

        builder.Visible = False
        builder.Enabled = False
        Export.Visible = False
        Export.Enabled = False
        Check.Visible = False
        Check.Enabled = False
        Carica.Visible = False
        Carica.Enabled = False
        Salva.Visible = False
        Salva.Enabled = False


    End Sub

    Private Sub Build_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Build.Click
        builder.Visible = True
        builder.Enabled = True
        Export.Visible = True
        Export.Enabled = True
        Check.Visible = True
        Check.Enabled = True
        Carica.Visible = True
        Carica.Enabled = True
        Salva.Visible = True
        Salva.Enabled = True


        Danni.Visible = False
        Danni.Enabled = False
        Introforza.Visible = False
        Introforza.Enabled = False
        IVs.Visible = False
        IVs.Enabled = False
        Pokèdex.Visible = False
        Pokèdex.Enabled = False
        Varie.Visible = False
        Varie.Enabled = False
    End Sub
    Private Sub Pokèdex_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Pokèdex.Click

        PokedexPG1.Show()
        Me.Visible = False
        Me.Enabled = False

    End Sub
    Private Sub IVs_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles IVs.Click
        IVs1.Show()
        Me.Visible = False
        Me.Enabled = False

    End Sub
    Private Sub Introforza_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Introforza.Click

        Introforza1.Show()
        Me.Visible = False
        Me.Enabled = False

    End Sub
    Private Sub Button4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button4.Click
        If File.Exists("C:\Project G\Temp\db.projg") Then
            File.Delete("C:\Project G\Temp\db.projg")
        End If


        Intro.Close()


    End Sub

    Private Sub Button6_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button6.Click
        Opzioni.Show()
    End Sub

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load

    End Sub
End Class
