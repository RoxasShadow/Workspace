'    Esegue un debug per verificare la presenza della libreria e della connessione ad internet.
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

Imports Animaonline
Imports System.IO
Public Class Debugger
    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        'Resetto la progressbar
        ProgressBar1.Value = 0

        'Creo le variabili
        Dim connessione As String = vbNullString
        Dim libreria As String = vbNullString
        Label1.Text = "Debugging in corso..."

        'Prima effetto un controllo della connessione
        If Not My.Computer.Network.IsAvailable Then
            connessione = 0
        Else
            connessione = 1
        End If

        'Poi controllo se è presente la libreria
        If Not File.Exists(System.AppDomain.CurrentDomain.BaseDirectory + "Animaonline Weather API.dll") Then
            libreria = 0
        Else
            libreria = 1
        End If

        'Dò gli avvisi
        ProgressBar1.Value = 100
        If connessione = 0 Then
            Label1.Text = "La connessione ad internet non è attiva."
        ElseIf libreria = 0 Then
            Label1.Text = "La libreria ""Animaonline Weather API.dll"" non è presente."
        Else
            Label1.Text = "Debug concluso."
            MsgBox("Non si è riusciti a trovare nessuna anomalia nel software in uso. E' probabile che i server non siano attivi")
        End If
    End Sub

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click
        Me.Close()
    End Sub
End Class