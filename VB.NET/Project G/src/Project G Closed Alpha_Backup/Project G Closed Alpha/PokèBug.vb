Imports System.Net.Mail
Imports System.Net

Public Class PokèBug

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click

        If TextBox1.Text = Nothing Or TextBox2.Text = Nothing Then
            MsgBox("Si prega di compilare tutti i campi.")
        Else
            'Test rete

            Dim reteDisponibile As Boolean
            reteDisponibile = My.Computer.Network.IsAvailable
            If reteDisponibile = True Then



                'Email
                Dim oggetto As String
                Dim mittente As String
                mittente = TextBox2.Text

                TextBox2.Text = oggetto

                'Crea un nuovo oggetto messaggio
                Dim myMail As New MailMessage()
                'Imposta mittente e destinatario
                myMail.From = New MailAddress(mittente)
                myMail.To.Add("webmaster@technicianpokemon.com")
                'Imposta l'oggetto
                myMail.Subject = ComboBox1.Text
                'Imposta la priorità
                myMail.Priority = MailPriority.Normal
                'Imposta il testo
                myMail.Body = TextBox1.Text
                'Crea un nuovo oggetto 'allegato', specificando il percorso e il tipo di codifica
                Dim Smtp As New SmtpClient("mail.technicianpokemon.com")
                'Imposta il server di posta da utilizzare
                'Invia l'e-mail
                Smtp.Send(myMail)

            Else
                MsgBox("Non risulti connesso ad Internet." + vbCrLf + "Finchè non ti connetterai non ti sarà possibile utilizzare Pokèbug.")
            End If
        End If

    End Sub

    Private Sub Button4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button4.Click
        Opzioni.Show()
        Me.Close()
    End Sub
End Class
