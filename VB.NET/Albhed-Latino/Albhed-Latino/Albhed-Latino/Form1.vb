Public Class Form1

    Private Sub Button2_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button2.Click

        Dim s As String = TextBox1.Text
        Dim temp As String
        Dim values As New Hashtable

        'ALB-ITA
        values.Add("a", "e")
        values.Add("b", "p")
        values.Add("c", "s")
        values.Add("d", "t")
        values.Add("e", "i")
        values.Add("f", "w")
        values.Add("g", "k")
        values.Add("h", "n")
        values.Add("i", "u")
        values.Add("j", "v")
        values.Add("k", "g")
        values.Add("l", "c")
        values.Add("m", "l")
        values.Add("n", "r")
        values.Add("o", "y")
        values.Add("p", "b")
        'values.Add("q", "w")
        values.Add("r", "h")
        values.Add("s", "m")
        values.Add("t", "d")
        values.Add("u", "o")
        values.Add("v", "f")
        values.Add("w", "x")
        values.Add("x", "q")
        values.Add("y", "a")
        'values.Add("z", "g")

        'MAIUSCOLO
        values.Add("A", "E")
        values.Add("B", "P")
        values.Add("C", "S")
        values.Add("D", "T")
        values.Add("E", "I")
        values.Add("F", "W")
        values.Add("G", "K")
        values.Add("H", "N")
        values.Add("I", "U")
        values.Add("J", "V")
        values.Add("K", "G")
        values.Add("L", "C")
        values.Add("M", "L")
        values.Add("N", "R")
        values.Add("O", "Y")
        values.Add("P", "B")
        'values.Add("Q", "W")
        values.Add("R", "H")
        values.Add("S", "M")
        values.Add("T", "D")
        values.Add("U", "O")
        values.Add("V", "F")
        values.Add("W", "X")
        values.Add("X", "Q")
        values.Add("Y", "A")
        'values.Add("Z", "G")

        'Altro
        values.Add(".", ".")
        values.Add(",", ",")
        values.Add("-", "-")
        values.Add(";", ";")
        values.Add(":", "_")
        values.Add("_", "_")
        values.Add("+", "+")
        values.Add("°", "°")
        values.Add("ç", "ç ")
        values.Add("!", "!")
        values.Add("?", "?")
        values.Add("^", "^")
        values.Add("'", "'")
        values.Add("=", "=")
        values.Add("&", "&")
        values.Add("""", """")
        values.Add("1", "1")
        values.Add("2", "2")
        values.Add("3", "3")
        values.Add("4", "4")
        values.Add("5", "5")
        values.Add("6", "6")
        values.Add("7", "7")
        values.Add("8", "8")
        values.Add("9", "9")
        values.Add("0", "0")
        values.Add("è", "è")
        values.Add("é", "é")
        values.Add("*", "*")
        values.Add("ò", "ò")
        values.Add("à", "à")
        values.Add("ù", "ù")
        values.Add("#", "#")
        values.Add("@", "@")
        values.Add("<", "< ")
        values.Add(">", ">")
        values.Add("(", "(")
        values.Add(")", ")")
        values.Add("/", "/")
        values.Add("\", "\")

        If TextBox1.Text = Nothing Then
            MsgBox("Nel form non c'è niente da tradurre.")
        End If

        While s.Length > 0
            For Each comb As String In values.Keys
                If s.StartsWith(comb) Then
                    temp += values(comb).ToString
                    s = s.Remove(0, comb.Length)
                End If
                If Not values.ContainsKey(comb) Then
                    MsgBox("La lettera" & comb & "non è supportata.")
                End If
            Next
        End While


        TextBox2.Text = temp

    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click

        Dim s As String = TextBox1.Text
        Dim temp As String
        Dim values As New Hashtable

        'ITA-ALB
        values.Add("e", "a")
        values.Add("p", "b")
        values.Add("s", "c")
        values.Add("t", "d")
        values.Add("i", "e")
        values.Add("w", "f")
        values.Add("k", "g")
        values.Add("n", "h")
        values.Add("u", "i")
        values.Add("v", "j")
        values.Add("g", "k")
        values.Add("c", "l")
        values.Add("l", "m")
        values.Add("r", "n")
        values.Add("y", "o")
        values.Add("b", "p")
        'values.Add("w", "q")
        values.Add("h", "r")
        values.Add("m", "s")
        values.Add("d", "t")
        values.Add("o", "u")
        values.Add("f", "v")
        values.Add("x", "w")
        values.Add("q", "x")
        values.Add("a", "y")
        'values.Add("g", "z")

        'MAIUSCOLO

        values.Add("E", "A")
        values.Add("P", "B")
        values.Add("S", "C")
        values.Add("T", "D")
        values.Add("I", "E")
        values.Add("W", "F")
        values.Add("K", "G")
        values.Add("N", "H")
        values.Add("U", "I")
        values.Add("V", "J")
        values.Add("G", "K")
        values.Add("C", "L")
        values.Add("L", "M")
        values.Add("R", "N")
        values.Add("Y", "O")
        values.Add("B", "P")
        'values.Add("W", "Q")
        values.Add("H", "R")
        values.Add("M", "S")
        values.Add("D", "T")
        values.Add("O", "U")
        values.Add("F", "V")
        values.Add("X", "W")
        values.Add("Q", "X")
        values.Add("A", "Y")
        'values.Add("G", "Z")

        'Altro
        values.Add(" ", " ")
        values.Add(".", ".")
        values.Add(",", ",")
        values.Add("-", "-")
        values.Add(";", ";")
        values.Add(":", "_")
        values.Add("_", "_")
        values.Add("+", "+")
        values.Add("°", "°")
        values.Add("ç", "ç ")
        values.Add("!", "!")
        values.Add("?", "?")
        values.Add("^", "^")
        values.Add("'", "'")
        values.Add("=", "=")
        values.Add("&", "&")
        values.Add("""", """")
        values.Add("1", "1")
        values.Add("2", "2")
        values.Add("3", "3")
        values.Add("4", "4")
        values.Add("5", "5")
        values.Add("6", "6")
        values.Add("7", "7")
        values.Add("8", "8")
        values.Add("9", "9")
        values.Add("0", "0")
        values.Add("è", "è")
        values.Add("é", "é")
        values.Add("*", "*")
        values.Add("ò", "ò")
        values.Add("à", "à")
        values.Add("ù", "ù")
        values.Add("#", "#")
        values.Add("@", "@")
        values.Add("<", "< ")
        values.Add(">", ">")
        values.Add("(", "(")
        values.Add(")", ")")
        values.Add("/", "/")
        values.Add("\", "\")


        While s.Length > 0
            For Each comb As String In values.Keys
                If s.StartsWith(comb) Then
                    temp += values(comb).ToString
                    s = s.Remove(0, comb.Length)
                End If
                If Not values.ContainsKey(comb) Then
                    MsgBox("La lettera" & comb & "non è supportata.")
                End If
            Next
        End While


        TextBox2.Text = temp

    End Sub

    Private Sub Button3_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button3.Click
        TextBox1.Text = ""
        TextBox2.Text = ""
    End Sub

    Private Sub Button4_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button4.Click
        Form2.Show()
    End Sub
End Class
