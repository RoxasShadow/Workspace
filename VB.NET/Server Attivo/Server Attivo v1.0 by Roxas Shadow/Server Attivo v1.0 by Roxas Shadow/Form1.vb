Imports Microsoft.Win32

Public Class Form1

    Private Sub CheckBox1_CheckedChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles CheckBox1.CheckedChanged
        If CheckBox1.Checked = True Then

            Dim regKey As RegistryKey
            regKey = Registry.CurrentUser.OpenSubKey("Software\Microsoft\Windows\CurrentVersion\Run", True)
            regKey.SetValue("Run A Server", "C:\Programmi\NetBattle Supremacy\PokeBattle.exe")
            regKey.Close()

        Else

            Dim regKey As RegistryKey
            regKey = Registry.CurrentUser.OpenSubKey("Software\Microsoft\Windows\CurrentVersion\Run", True)
            regKey.SetValue("Run A Server", "")
            regKey.Close()

        End If

    End Sub


    Private Sub CheckBox2_CheckedChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles CheckBox2.CheckedChanged
        If CheckBox2.Checked = True Then

            Dim regKey As RegistryKey
            regKey = Registry.CurrentUser.OpenSubKey("Software\Microsoft\Windows\CurrentVersion\Run", True)
            regKey.SetValue("No-IP", "C:\Programmi\No-IP\DUC20.exe")
            regKey.Close()

        Else

            Dim regKey As RegistryKey
            regKey = Registry.CurrentUser.OpenSubKey("Software\Microsoft\Windows\CurrentVersion\Run", True)
            regKey.SetValue("No-IP", "")
            regKey.Close()

        End If
    End Sub

    Private Sub LinkLabel1_LinkClicked(ByVal sender As System.Object, ByVal e As System.Windows.Forms.LinkLabelLinkClickedEventArgs)
        System.Diagnostics.Process.Start("http://www.technicianpokemon.com")
    End Sub

    Private Sub LinkLabel2_LinkClicked(ByVal sender As System.Object, ByVal e As System.Windows.Forms.LinkLabelLinkClickedEventArgs)
        System.Diagnostics.Process.Start("mailto:" & "webmaster@technicianpokemon.com")
    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim frm As New Form2()
        frm.ShowDialog()
    End Sub
End Class
