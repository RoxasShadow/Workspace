Imports System.IO
Imports System
Imports System.Data
Imports System.Xml
Public Class Form3
    Private Sub Button1_Click_1(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click

        '                                                                          #1

        Dim hp As String
        hp = Form1.ComboBox2.SelectedItem

        If hp = "Hidden Power" Then
            hp = Form1.ComboBox2.SelectedItem + " [" + Form1.ComboBox8.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox2.SelectedItem

        End If

        Dim hp2 As String
        hp2 = Form1.ComboBox4.SelectedItem

        If hp2 = "Hidden Power" Then
            hp2 = Form1.ComboBox4.SelectedItem + " [" + Form1.ComboBox8.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox4.SelectedItem

        End If


        Dim hp3 As String
        hp3 = Form1.ComboBox5.SelectedItem

        If hp3 = "Hidden Power" Then
            hp3 = Form1.ComboBox5.SelectedItem + " [" + Form1.ComboBox8.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox5.SelectedItem

        End If

        Dim hp4 As String
        hp4 = Form1.ComboBox6.SelectedItem

        If hp4 = "Hidden Power" Then
            hp4 = Form1.ComboBox6.SelectedItem + " [" + Form1.ComboBox8.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox6.SelectedItem

        End If




        '                                                                          #2


        Dim hp5 As String
        hp5 = Form1.ComboBox17.SelectedItem

        If hp5 = "Hidden Power" Then
            hp5 = Form1.ComboBox17.SelectedItem + " [" + Form1.ComboBox14.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox17.SelectedItem

        End If

        Dim hp6 As String
        hp6 = Form1.ComboBox18.SelectedItem

        If hp6 = "Hidden Power" Then
            hp6 = Form1.ComboBox18.SelectedItem + " [" + Form1.ComboBox14.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox18.SelectedItem

        End If


        Dim hp7 As String
        hp7 = Form1.ComboBox19.SelectedItem

        If hp7 = "Hidden Power" Then
            hp7 = Form1.ComboBox19.SelectedItem + " [" + Form1.ComboBox14.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox19.SelectedItem

        End If

        Dim hp8 As String
        hp8 = Form1.ComboBox20.SelectedItem

        If hp8 = "Hidden Power" Then
            hp8 = Form1.ComboBox20.SelectedItem + " [" + Form1.ComboBox14.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox20.SelectedItem

        End If






        '                                                                          #3


        Dim hp9 As String
        hp9 = Form1.ComboBox27.SelectedItem

        If hp9 = "Hidden Power" Then
            hp9 = Form1.ComboBox27.SelectedItem + " [" + Form1.ComboBox24.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox27.SelectedItem

        End If

        Dim hp10 As String
        hp10 = Form1.ComboBox28.SelectedItem

        If hp10 = "Hidden Power" Then
            hp10 = Form1.ComboBox28.SelectedItem + " [" + Form1.ComboBox24.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox28.SelectedItem

        End If

        Dim hp11 As String
        hp11 = Form1.ComboBox29.SelectedItem

        If hp11 = "Hidden Power" Then
            hp11 = Form1.ComboBox29.SelectedItem + " [" + Form1.ComboBox24.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox29.SelectedItem

        End If

        Dim hp12 As String
        hp12 = Form1.ComboBox30.SelectedItem

        If hp12 = "Hidden Power" Then
            hp12 = Form1.ComboBox30.SelectedItem + " [" + Form1.ComboBox24.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox30.SelectedItem

        End If




        '                                                                          #4


        Dim hp13 As String
        hp13 = Form1.ComboBox37.SelectedItem

        If hp13 = "Hidden Power" Then
            hp13 = Form1.ComboBox37.SelectedItem + " [" + Form1.ComboBox34.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox37.SelectedItem

        End If


        Dim hp14 As String
        hp14 = Form1.ComboBox38.SelectedItem

        If hp14 = "Hidden Power" Then
            hp14 = Form1.ComboBox38.SelectedItem + " [" + Form1.ComboBox34.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox38.SelectedItem

        End If


        Dim hp15 As String
        hp15 = Form1.ComboBox39.SelectedItem

        If hp15 = "Hidden Power" Then
            hp15 = Form1.ComboBox39.SelectedItem + " [" + Form1.ComboBox34.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox39.SelectedItem

        End If


        Dim hp16 As String
        hp16 = Form1.ComboBox40.SelectedItem

        If hp16 = "Hidden Power" Then
            hp16 = Form1.ComboBox40.SelectedItem + " [" + Form1.ComboBox34.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox40.SelectedItem

        End If


        '                                                                          #5


        Dim hp17 As String
        hp17 = Form1.ComboBox47.SelectedItem

        If hp17 = "Hidden Power" Then
            hp17 = Form1.ComboBox47.SelectedItem + " [" + Form1.ComboBox44.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox47.SelectedItem

        End If


        Dim hp18 As String
        hp18 = Form1.ComboBox48.SelectedItem

        If hp18 = "Hidden Power" Then
            hp18 = Form1.ComboBox48.SelectedItem + " [" + Form1.ComboBox44.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox48.SelectedItem

        End If

        Dim hp19 As String
        hp19 = Form1.ComboBox49.SelectedItem

        If hp19 = "Hidden Power" Then
            hp19 = Form1.ComboBox49.SelectedItem + " [" + Form1.ComboBox44.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox49.SelectedItem

        End If


        Dim hp20 As String
        hp20 = Form1.ComboBox50.SelectedItem

        If hp20 = "Hidden Power" Then
            hp20 = Form1.ComboBox50.SelectedItem + " [" + Form1.ComboBox44.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox50.SelectedItem

        End If


        '                                                                          #6


        Dim hp21 As String
        hp21 = Form1.ComboBox57.SelectedItem

        If hp21 = "Hidden Power" Then
            hp21 = Form1.ComboBox57.SelectedItem + " [" + Form1.ComboBox54.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox57.SelectedItem

        End If


        Dim hp22 As String
        hp22 = Form1.ComboBox58.SelectedItem

        If hp22 = "Hidden Power" Then
            hp22 = Form1.ComboBox58.SelectedItem + " [" + Form1.ComboBox54.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox58.SelectedItem

        End If


        Dim hp23 As String
        hp23 = Form1.ComboBox59.SelectedItem

        If hp23 = "Hidden Power" Then
            hp23 = Form1.ComboBox59.SelectedItem + " [" + Form1.ComboBox54.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox49.SelectedItem

        End If


        Dim hp24 As String
        hp24 = Form1.ComboBox60.SelectedItem

        If hp24 = "Hidden Power" Then
            hp24 = Form1.ComboBox60.SelectedItem + " [" + Form1.ComboBox54.SelectedItem + "]"

        Else
            TextBox1.Text = Form1.ComboBox60.SelectedItem

        End If




        Dim pokemon As String = Form1.ComboBox1.SelectedItem



        Dim pathxml As String
        pathxml = "C:\Project G\Data\P-16E64DB\" + pokemon + ".xml"

        Dim xml As XmlReader
        xml = XmlReader.Create(pathxml)

        xml.ReadToFollowing("pokemon")
        xml.ReadToFollowing("nome")
        xml.ReadToFollowing("Abilità1")

        Dim abilità1 As String = (xml.ReadElementContentAsString())

        xml.ReadToFollowing("Abilità2")

        Dim abilità2 As String = (xml.ReadElementContentAsString())

        xml.ReadToFollowing("Numero")

        Dim numero As String = (xml.ReadElementContentAsString())

        xml.ReadToFollowing("HP")

        Dim HPP As String = (xml.ReadElementContentAsString())

        xml.ReadToFollowing("Atk")

        Dim atk As String = (xml.ReadElementContentAsString())

        xml.ReadToFollowing("Dif")

        Dim dif As String = (xml.ReadElementContentAsString())

        xml.ReadToFollowing("AtkSp")

        Dim atksp As String = (xml.ReadElementContentAsString())

        xml.ReadToFollowing("DifSp")

        Dim difsp As String = (xml.ReadElementContentAsString())

        xml.ReadToFollowing("Vel")

        Dim vel As String = (xml.ReadElementContentAsString())



        Dim Img1 As String

        If ComboBox1.SelectedItem = "Sprite" Then
            Img1 = "[IMG]http://www.projectg.com/image/pokemon/sprite/" + numero + ".png[/IMG]"

        ElseIf ComboBox1.SelectedItem = "Sprite Shiny" Then
            Img1 = "[IMG]http://www.projectg.com/image/pokemon/sprite_shiny/" + numero + ".png[/IMG]"

        ElseIf ComboBox1.SelectedItem = "Gif Animata" Then
            Img1 = "[IMG]http://www.projectg.com/image/pokemon/gif_animata/" + numero + ".gif[/IMG]"

        ElseIf ComboBox1.SelectedItem = "Personale" Then
            Img1 = "[IMG]" + TextBox2.Text + "[/IMG]"
        End If


        Dim Img2 As String

        If ComboBox2.SelectedItem = "Sprite" Then
            Img2 = "[IMG]http://www.projectg.com/image/pokemon/sprite/" + numero + ".png[/IMG]"

        ElseIf ComboBox2.SelectedItem = "Sprite Shiny" Then
            Img2 = "[IMG]http://www.projectg.com/image/pokemon/sprite_shiny/" + numero + ".png[/IMG]"

        ElseIf ComboBox2.SelectedItem = "Gif Animata" Then
            Img2 = "[IMG]http://www.projectg.com/image/pokemon/gif_animata/" + numero + ".gif[/IMG]"

        ElseIf ComboBox2.SelectedItem = "Personale" Then
            Img2 = "[IMG]" + TextBox3.Text + "[/IMG]"
        End If


        Dim Img3 As String

        If ComboBox3.SelectedItem = "Sprite" Then
            Img3 = "[IMG]http://www.projectg.com/image/pokemon/sprite/" + numero + ".png[/IMG]"

        ElseIf ComboBox3.SelectedItem = "Sprite Shiny" Then
            Img3 = "[IMG]http://www.projectg.com/image/pokemon/sprite_shiny/" + numero + ".png[/IMG]"

        ElseIf ComboBox3.SelectedItem = "Gif Animata" Then
            Img3 = "[IMG]http://www.projectg.com/image/pokemon/gif_animata/" + numero + ".gif[/IMG]"

        ElseIf ComboBox3.SelectedItem = "Personale" Then
            Img3 = "[IMG]" + TextBox5.Text + "[/IMG]"
        End If


        Dim Img4 As String

        If ComboBox4.SelectedItem = "Sprite" Then
            Img4 = "[IMG]http://www.projectg.com/image/pokemon/sprite/" + numero + ".png[/IMG]"

        ElseIf ComboBox4.SelectedItem = "Sprite Shiny" Then
            Img4 = "[IMG]http://www.projectg.com/image/pokemon/sprite_shiny/" + numero + ".png[/IMG]"

        ElseIf ComboBox4.SelectedItem = "Gif Animata" Then
            Img4 = "[IMG]http://www.projectg.com/image/pokemon/gif_animata/" + numero + ".gif[/IMG]"

        ElseIf ComboBox4.SelectedItem = "Personale" Then
            Img4 = "[IMG]" + TextBox6.Text + "[/IMG]"
        End If


        Dim Img5 As String

        If ComboBox5.SelectedItem = "Sprite" Then
            Img5 = "[IMG]http://www.projectg.com/image/pokemon/sprite/" + numero + ".png[/IMG]"

        ElseIf ComboBox5.SelectedItem = "Sprite Shiny" Then
            Img5 = "[IMG]http://www.projectg.com/image/pokemon/sprite_shiny/" + numero + ".png[/IMG]"

        ElseIf ComboBox5.SelectedItem = "Gif Animata" Then
            Img5 = "[IMG]http://www.projectg.com/image/pokemon/gif_animata/" + numero + ".gif[/IMG]"

        ElseIf ComboBox5.SelectedItem = "Personale" Then
            Img5 = "[IMG]" + TextBox7.Text + "[/IMG]"
        End If


        Dim Img6 As String

        If ComboBox6.SelectedItem = "Sprite" Then
            Img6 = "[IMG]http://www.projectg.com/image/pokemon/sprite/" + numero + ".png[/IMG]"

        ElseIf ComboBox6.SelectedItem = "Sprite Shiny" Then
            Img6 = "[IMG]http://www.projectg.com/image/pokemon/sprite_shiny/" + numero + ".png[/IMG]"

        ElseIf ComboBox6.SelectedItem = "Gif Animata" Then
            Img6 = "[IMG]http://www.projectg.com/image/pokemon/gif_animata/" + numero + ".gif[/IMG]"

        ElseIf ComboBox6.SelectedItem = "Personale" Then
            Img6 = "[IMG]" + TextBox8.Text + "[/IMG]"
        End If

        Me.TextBox4.Text = Form1.TextBox2.Text & ControlChars.CrLf & ControlChars.CrLf & Form1.TextBox3.Text & ControlChars.CrLf & ControlChars.CrLf & Img1 & vbCrLf & Form1.ComboBox1.SelectedItem & " " & Form1.ComboBox3.SelectedItem & " " & "@ " & Form1.ComboBox9.SelectedItem & ControlChars.CrLf & "Ability: " & Form1.ComboBox7.SelectedItem & ControlChars.CrLf & "EVs: " & ControlChars.CrLf & Form1.ComboBox10.SelectedItem & " nature" & ControlChars.CrLf & " - " & hp & ControlChars.CrLf & " - " & hp2 & ControlChars.CrLf & " - " & hp3 & ControlChars.CrLf & " - " & hp4 & ControlChars.CrLf & " ------------- " & ControlChars.CrLf & ControlChars.CrLf & ControlChars.CrLf & Img2 & vbCrLf & Form1.ComboBox15.SelectedItem & " " & Form1.ComboBox16.SelectedItem & " " & "@ " & Form1.ComboBox13.SelectedItem & ControlChars.CrLf & "Ability: " & Form1.ComboBox12.SelectedItem & ControlChars.CrLf & "EVs: " & ControlChars.CrLf & Form1.ComboBox11.SelectedItem & " nature" & ControlChars.CrLf & " - " & hp5 & ControlChars.CrLf & " - " & hp6 & ControlChars.CrLf & " - " & hp7 & ControlChars.CrLf & " - " & hp8 & ControlChars.CrLf & " ------------- " & ControlChars.CrLf & ControlChars.CrLf & ControlChars.CrLf & Img3 & vbCrLf & Form1.ComboBox25.SelectedItem & " " & Form1.ComboBox26.SelectedItem & " " & "@ " & Form1.ComboBox23.SelectedItem & ControlChars.CrLf & "Ability: " & Form1.ComboBox22.SelectedItem & ControlChars.CrLf & "EVs: " & ControlChars.CrLf & Form1.ComboBox21.SelectedItem & " nature" & ControlChars.CrLf & " - " & hp9 & ControlChars.CrLf & " - " & hp10 & ControlChars.CrLf & " - " & hp11 & ControlChars.CrLf & " - " & hp12 & ControlChars.CrLf & " ------------- " & ControlChars.CrLf & ControlChars.CrLf & ControlChars.CrLf & Img4 & vbCrLf & Form1.ComboBox35.SelectedItem & " " & Form1.ComboBox36.SelectedItem & " " & "@ " & Form1.ComboBox33.SelectedItem & ControlChars.CrLf & "Ability: " & Form1.ComboBox32.SelectedItem & ControlChars.CrLf & "EVs: " & ControlChars.CrLf & Form1.ComboBox31.SelectedItem & " nature" & ControlChars.CrLf & " - " & hp13 & ControlChars.CrLf & " - " & hp14 & ControlChars.CrLf & " - " & hp15 & ControlChars.CrLf & " - " & hp16 & ControlChars.CrLf & " ------------- " & ControlChars.CrLf & ControlChars.CrLf & ControlChars.CrLf & Img5 & vbCrLf & Form1.ComboBox1.SelectedItem & " " & Form1.ComboBox3.SelectedItem & " " & "@ " & Form1.ComboBox9.SelectedItem & ControlChars.CrLf & "Ability: " & Form1.ComboBox7.SelectedItem & ControlChars.CrLf & "EVs: " & ControlChars.CrLf & Form1.ComboBox10.SelectedItem & " nature" & ControlChars.CrLf & " - " & hp17 & ControlChars.CrLf & " - " & hp18 & ControlChars.CrLf & " - " & hp19 & ControlChars.CrLf & " - " & hp20 & ControlChars.CrLf & " ------------- " & ControlChars.CrLf & ControlChars.CrLf & ControlChars.CrLf & Img6 & vbCrLf & Form1.ComboBox55.SelectedItem & " " & Form1.ComboBox56.SelectedItem & " " & "@ " & Form1.ComboBox53.SelectedItem & ControlChars.CrLf & "Ability: " & Form1.ComboBox52.SelectedItem & ControlChars.CrLf & "EVs: " & ControlChars.CrLf & Form1.ComboBox51.SelectedItem & " nature" & ControlChars.CrLf & " - " & hp21 & ControlChars.CrLf & " - " & hp22 & ControlChars.CrLf & " - " & hp23 & ControlChars.CrLf & " - " & hp24 & ControlChars.CrLf & " ------------- " & ControlChars.CrLf & ControlChars.CrLf & ControlChars.CrLf



    End Sub

    Private Sub ComboBox1_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ComboBox1.SelectedIndexChanged
        If ComboBox1.SelectedItem = "Personale" Then
            GroupBox2.Enabled = True
            GroupBox2.Visible = True
            Label1.Enabled = True
            Label1.Visible = True
            TextBox2.Enabled = True
            TextBox2.Visible = True
        Else
            GroupBox2.Enabled = False
            GroupBox2.Visible = False
            Label1.Enabled = False
            Label1.Visible = False
            TextBox2.Enabled = False
            TextBox2.Visible = False
            TextBox2.Text = "http://"
        End If
    End Sub
    Private Sub ComboBox2_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ComboBox2.SelectedIndexChanged
        If ComboBox2.SelectedItem = "Personale" Then
            GroupBox4.Enabled = True
            GroupBox4.Visible = True
            Label2.Enabled = True
            Label2.Visible = True
            TextBox3.Enabled = True
            TextBox3.Visible = True
        Else
            GroupBox4.Enabled = False
            GroupBox4.Visible = False
            Label2.Enabled = False
            Label2.Visible = False
            TextBox3.Enabled = False
            TextBox3.Visible = False
            TextBox3.Text = "http://"
        End If
    End Sub
    Private Sub ComboBox3_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ComboBox3.SelectedIndexChanged
        If ComboBox3.SelectedItem = "Personale" Then
            GroupBox6.Enabled = True
            GroupBox6.Visible = True
            Label3.Enabled = True
            Label3.Visible = True
            TextBox5.Enabled = True
            TextBox5.Visible = True
        Else
            GroupBox6.Enabled = False
            GroupBox6.Visible = False
            Label3.Enabled = False
            Label3.Visible = False
            TextBox5.Enabled = False
            TextBox5.Visible = False
            TextBox5.Text = "http://"
        End If
    End Sub
    Private Sub ComboBox4_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ComboBox4.SelectedIndexChanged
        If ComboBox4.SelectedItem = "Personale" Then
            GroupBox8.Enabled = True
            GroupBox8.Visible = True
            Label4.Enabled = True
            Label4.Visible = True
            TextBox6.Enabled = True
            TextBox6.Visible = True
        Else
            GroupBox8.Enabled = False
            GroupBox8.Visible = False
            Label4.Enabled = False
            Label4.Visible = False
            TextBox6.Enabled = False
            TextBox6.Visible = False
            TextBox6.Text = "http://"
        End If
    End Sub
    Private Sub ComboBox5_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ComboBox5.SelectedIndexChanged
        If ComboBox5.SelectedItem = "Personale" Then
            GroupBox10.Enabled = True
            GroupBox10.Visible = True
            Label5.Enabled = True
            Label5.Visible = True
            TextBox7.Enabled = True
            TextBox7.Visible = True
        Else
            GroupBox10.Enabled = False
            GroupBox10.Visible = False
            Label5.Enabled = False
            Label5.Visible = False
            TextBox7.Enabled = False
            TextBox7.Visible = False
            TextBox7.Text = "http://"
        End If
    End Sub
    Private Sub ComboBox6_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles ComboBox6.SelectedIndexChanged
        If ComboBox6.SelectedItem = "Personale" Then
            GroupBox12.Enabled = True
            GroupBox12.Visible = True
            Label6.Enabled = True
            Label6.Visible = True
            TextBox8.Enabled = True
            TextBox8.Visible = True
        Else
            GroupBox12.Enabled = False
            GroupBox12.Visible = False
            Label6.Enabled = False
            Label6.Visible = False
            TextBox8.Enabled = False
            TextBox8.Visible = False
            TextBox8.Text = "http://"
        End If
    End Sub
End Class