Imports System.Xml
Imports System.IO
Imports Microsoft.DirectX
Imports Microsoft.DirectX.AudioVideoPlayback

Public Class Nascosto
    Private Sub PlayMP3()
        If File.Exists("C:\Project G\settings\musica.xml") Then

            Dim musica As XmlReader
            musica = XmlReader.Create("C:\Project G\settings\musica.xml")



            musica.ReadToFollowing("musica")
            musica.ReadToFollowing("selezione")

            Dim selezione As String = (musica.ReadElementContentAsString())

            Dim traccia As Audio
            Dim path As String = "C:\Project G\Media\" + selezione + ".mp3"



            traccia = New Audio(path)
            traccia.Play()
            Timer1.Interval = traccia.Duration * 1000


        End If
    End Sub

    Private Sub Timer1_Tick(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Timer1.Tick
        PlayMP3()
    End Sub

    Private Sub Nascosto_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        PlayMP3()
    End Sub
End Class