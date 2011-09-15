Imports System.Xml
Imports System.Runtime.Serialization.Formatters
Imports System.Xml.Serialization
Imports System.Net
Imports System.IO

Public Class Pokemon
    Public Pokemon As String
End Class

Public Class Client
    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click

        'Scarico l' XmL
        Dim request As WebRequest = WebRequest.Create("http://www.technicianpokemon.com/dex/strategydex/api.php?pokemon=Abomasnow")
        Dim response As WebResponse = request.GetResponse()
        Dim s As Stream = response.GetResponseStream()
        Dim stream As New StreamReader(s)

        'Creo il serializer
        Dim xmlSerializer As New XmlSerializer(GetType(List(Of Pokemon)))
        Dim obj As List(Of Pokemon) = DirectCast(xmlSerializer.Deserialize(stream), List(Of Pokemon))

        Dim writer As New StreamWriter("D:\ser.xml")
        xmlSerializer.Serialize(writer, obj)


    End Sub
End Class
