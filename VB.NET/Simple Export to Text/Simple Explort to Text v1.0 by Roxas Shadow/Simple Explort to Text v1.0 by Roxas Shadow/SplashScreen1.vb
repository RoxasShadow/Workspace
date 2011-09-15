Public NotInheritable Class SplashScreen1

    'TODO: questo form può essere facilmente impostato come schermata iniziale per l'applicazione dalla scheda "Applicazione"
    '  di Progettazione progetti (scegliere "Proprietà" dal menu "Progetto").


    Private Sub SplashScreen1_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        'Imposta il testo della finestra di dialogo in fase di esecuzione in base alle informazioni sull'assembly dell'applicazione.  

        'TODO: personalizzare le informazioni sull'assembly dell'applicazione nel riquadro "Applicazione" 
        '  della finestra delle proprietà del progetto (accessibile dal menu "Progetto").
    End Sub

    Private Sub tmrShow_Tick(ByVal sender As System.Object, _
        ByVal e As System.EventArgs) Handles tmrShow.Tick
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
    End Sub
End Class
