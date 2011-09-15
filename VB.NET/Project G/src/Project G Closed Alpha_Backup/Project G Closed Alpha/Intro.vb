Imports System.IO
Imports System
Imports System.Data
Imports System.Text
Imports System.Xml
Imports System.Net.Mail
Imports System.Net

Public Class Intro

    Private Sub Timer1_Tick(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Timer1.Tick
        'Fade in
        SetWindowOpacity(Me.Opacity + 0.05)
    End Sub
    Protected Delegate Sub SetWindowOpacityDelegate(ByVal opacity As Double)
    Protected Sub SetWindowOpacity(ByVal opacity As Double)
        If Me.InvokeRequired Then
            Me.Invoke(New SetWindowOpacityDelegate(AddressOf SetWindowOpacity), _
                opacity)
        Else
            If opacity >= 0 And opacity <= 1 Then
                Me.Opacity = opacity
            ElseIf opacity < 0 Then
                Me.Opacity = 0
            Else
                Me.Opacity = 1
            End If
        End If
        'Fine Fade in
    End Sub
    Private Sub Intro_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load

        Dim pb As String
        pb = ProgressBar1.Value

        Label3.Text = "Sto controllando se tutti i file sono ok..."

        'Controllo directory
        If Not Directory.Exists("C:\Project G\") Or Not Directory.Exists("C:\Project G\Media\") Or Not Directory.Exists("C:\Project G\settings\") Or Not Directory.Exists("C:\Project G\Data\") Or Not Directory.Exists("C:\Project G\Data\M-16F282B") Or Not Directory.Exists("C:\Project G\Data\P-16E64DB") Or Not Directory.Exists("C:\Project G\Temp\") Then
            MsgBox("Una o più directory necessarie per l' avvio di Project G non sono state trovate." + vbCrLf + "Una reinstallazione del programma dovrebbe risolvere il problema.")
            Me.Close()
        End If

        'Controllo musica

        If Not File.Exists("C:\Project G\Media\DPPt Trainer Battle.mp3") Or Not File.Exists("C:\Project G\Media\DPPt Wild Battle.mp3") Or Not File.Exists("C:\Project G\Media\GSC Trainer Battle.mp3") Or Not File.Exists("C:\Project G\Media\HGSS Vs. Red-Lance.mp3") Or Not File.Exists("C:\Project G\Media\HGSS Vs. Silver.mp3") Or Not File.Exists("C:\Project G\Media\RBY Wild Battle.mp3") Or Not File.Exists("C:\Project G\Media\RSE Trainer Battle.mp3") Then
            MsgBox("Uno o più files non sono stati trovati nella directory Media." + vbCrLf + "Una reinstallazione del programma dovrebbe risolvere il problema.")
            Me.Close()
        End If

        Timer3.Start()
    End Sub

    Private Sub Timer3_Tick(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Timer3.Tick

        Label3.Text = "Sto aggiornando il database da DoomDesire..."

        'Test rete

        Dim reteDisponibile As Boolean
        reteDisponibile = My.Computer.Network.IsAvailable
        If reteDisponibile = True Then

        'Scarica il file
        Dim webC As New Net.WebClient
        Dim patchFile As String = "http://www.doomdesire.it/project-g/db.projg"
        Dim filename As String = "C:\Project G\Temp\" & patchFile.Substring(patchFile.LastIndexOf("/") + 1)
        webC.DownloadFile(patchFile, filename)


        Else


            MsgBox("La connessione non è attiva e il database non è scaricabile. In questa sessione non sarà possibile accedere alle schede di analisi.")

        End If

        If Not File.Exists("C:\Project G\Temp\db.projg") And reteDisponibile = True Then
            MsgBox("Il database di DoomDesire è down. In questa sessione non sarà possibile accedere alle schede di analisi." + vbCrLf + "Se il problema persiste contattaci tramite Pokèbug.")


        End If

        Timer3.Stop()
        Timer4.Start()
    End Sub

    Private Sub Timer4_Tick(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Timer4.Tick
        Label3.Text = "Sto caricando le importazioni..."

        'FINESTRA
        If File.Exists("C:\Project G\settings\finestra.xml") Then
            Dim pathxml As String
            pathxml = "C:\Project G\settings\finestra.xml"

            Dim xml As XmlReader
            xml = XmlReader.Create(pathxml)

            xml.ReadToFollowing("finestra")
            xml.ReadToFollowing("bordo")

            Dim bordo As String = (xml.ReadElementContentAsString())

            If bordo = "Si" Then
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

            ElseIf bordo = "No" Then

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
            End If
        End If

        Timer4.Stop()
        Timer2.Start()
    End Sub

    Private Sub Timer2_Tick(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Timer2.Tick
        Label3.Text = "Tutti i componenti sono stati inizializzati. Avvio in corso..."
        Timer2.Stop()

        Form1.Show()

        If File.Exists("C:\Project G\settings\musica.xml") Then
            Nascosto.Show()
        End If

        Me.Visible = False
        Me.Enabled = False


    End Sub
End Class