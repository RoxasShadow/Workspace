'    Il form principale. Visualizza le condizioni meteorologiche.
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
Imports System
Public Class Main
    Private Sub Esegui_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Esegui.Click
        Try
            Dim meteo = Animaonline.Weather.GoogleWeatherAPI.GetWeather(Animaonline.Globals.LanguageCode.it_IT, Citta.SelectedItem + ", IT")
            Dim temperatura As String = meteo.CurrentConditions.Temperature.Celsius
            Dim umidita As String = meteo.CurrentConditions.Humidity
            Dim condizioni As String = meteo.CurrentConditions.Condition
            Dim data As String = meteo.ForecastInformation.CurrentDateTime
            Dim vento As String = meteo.CurrentConditions.WindCondition
            Dim coordinate As String = meteo.ForecastInformation.Coordinates.ToString

            Label3.Text = "Condizioni atmosferiche: " + condizioni
            Label1.Text = umidita
            Label2.Text = "Temperatura: " + temperatura + "°C"
            Label4.Text = "Data e ora:" + data
            Label5.Text = "Vento:" + vento
            Label6.Text = "Coordinate: " + coordinate
            Label7.Text = "Città: " + Citta.SelectedItem
        Catch
            MsgBox("E' accaduto un errore. Per maggiori informazioni effettua il debug.")
        End Try
    End Sub

    Private Sub Debug_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Debug.Click
        Debugger.Show()
    End Sub

    Private Sub About_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles About.Click
        InfoAbout.Show()
    End Sub
End Class