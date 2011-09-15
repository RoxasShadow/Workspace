<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form esegue l'override del metodo Dispose per pulire l'elenco dei componenti.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Richiesto da Progettazione Windows Form
    Private components As System.ComponentModel.IContainer

    'NOTA: la procedura che segue è richiesta da Progettazione Windows Form
    'Può essere modificata in Progettazione Windows Form.  
    'Non modificarla nell'editor del codice.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(Form1))
        Me.Tools = New System.Windows.Forms.Button
        Me.Build = New System.Windows.Forms.Button
        Me.Button4 = New System.Windows.Forms.Button
        Me.Button5 = New System.Windows.Forms.Button
        Me.Button6 = New System.Windows.Forms.Button
        Me.Introforza = New System.Windows.Forms.Button
        Me.Pokèdex = New System.Windows.Forms.Button
        Me.Check = New System.Windows.Forms.Button
        Me.Carica = New System.Windows.Forms.Button
        Me.Varie = New System.Windows.Forms.Button
        Me.builder = New System.Windows.Forms.Button
        Me.Export = New System.Windows.Forms.Button
        Me.Salva = New System.Windows.Forms.Button
        Me.IVs = New System.Windows.Forms.Button
        Me.Danni = New System.Windows.Forms.Button
        Me.SuspendLayout()
        '
        'Tools
        '
        Me.Tools.BackColor = System.Drawing.Color.Red
        Me.Tools.BackgroundImage = CType(resources.GetObject("Tools.BackgroundImage"), System.Drawing.Image)
        Me.Tools.FlatAppearance.BorderSize = 0
        Me.Tools.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.Tools.Location = New System.Drawing.Point(445, 68)
        Me.Tools.Name = "Tools"
        Me.Tools.Size = New System.Drawing.Size(50, 49)
        Me.Tools.TabIndex = 0
        Me.Tools.Text = "Tools"
        Me.Tools.UseVisualStyleBackColor = False
        '
        'Build
        '
        Me.Build.BackColor = System.Drawing.Color.Red
        Me.Build.BackgroundImage = CType(resources.GetObject("Build.BackgroundImage"), System.Drawing.Image)
        Me.Build.FlatAppearance.BorderSize = 0
        Me.Build.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.Build.Location = New System.Drawing.Point(445, 125)
        Me.Build.Name = "Build"
        Me.Build.Size = New System.Drawing.Size(50, 49)
        Me.Build.TabIndex = 1
        Me.Build.Text = "Build"
        Me.Build.UseVisualStyleBackColor = False
        '
        'Button4
        '
        Me.Button4.BackColor = System.Drawing.Color.Transparent
        Me.Button4.BackgroundImage = CType(resources.GetObject("Button4.BackgroundImage"), System.Drawing.Image)
        Me.Button4.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Center
        Me.Button4.FlatAppearance.BorderSize = 0
        Me.Button4.Location = New System.Drawing.Point(764, 380)
        Me.Button4.Name = "Button4"
        Me.Button4.Size = New System.Drawing.Size(32, 32)
        Me.Button4.TabIndex = 6
        Me.Button4.UseVisualStyleBackColor = False
        '
        'Button5
        '
        Me.Button5.BackColor = System.Drawing.Color.Transparent
        Me.Button5.BackgroundImage = CType(resources.GetObject("Button5.BackgroundImage"), System.Drawing.Image)
        Me.Button5.FlatAppearance.BorderSize = 0
        Me.Button5.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.Button5.Location = New System.Drawing.Point(764, 340)
        Me.Button5.Name = "Button5"
        Me.Button5.Size = New System.Drawing.Size(32, 32)
        Me.Button5.TabIndex = 7
        Me.Button5.UseVisualStyleBackColor = False
        '
        'Button6
        '
        Me.Button6.BackColor = System.Drawing.Color.Transparent
        Me.Button6.BackgroundImage = CType(resources.GetObject("Button6.BackgroundImage"), System.Drawing.Image)
        Me.Button6.FlatAppearance.BorderSize = 0
        Me.Button6.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.Button6.Location = New System.Drawing.Point(764, 302)
        Me.Button6.Name = "Button6"
        Me.Button6.Size = New System.Drawing.Size(32, 32)
        Me.Button6.TabIndex = 8
        Me.Button6.UseVisualStyleBackColor = False
        '
        'Introforza
        '
        Me.Introforza.BackColor = System.Drawing.Color.White
        Me.Introforza.Enabled = False
        Me.Introforza.FlatAppearance.BorderSize = 0
        Me.Introforza.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.Introforza.Location = New System.Drawing.Point(493, 367)
        Me.Introforza.Name = "Introforza"
        Me.Introforza.Size = New System.Drawing.Size(254, 23)
        Me.Introforza.TabIndex = 16
        Me.Introforza.Text = "Calcolatore Introforza"
        Me.Introforza.UseVisualStyleBackColor = False
        Me.Introforza.Visible = False
        '
        'Pokèdex
        '
        Me.Pokèdex.BackColor = System.Drawing.Color.White
        Me.Pokèdex.Enabled = False
        Me.Pokèdex.FlatAppearance.BorderSize = 0
        Me.Pokèdex.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.Pokèdex.Location = New System.Drawing.Point(493, 396)
        Me.Pokèdex.Name = "Pokèdex"
        Me.Pokèdex.Size = New System.Drawing.Size(254, 23)
        Me.Pokèdex.TabIndex = 17
        Me.Pokèdex.Text = "Pokèdex"
        Me.Pokèdex.UseVisualStyleBackColor = False
        Me.Pokèdex.Visible = False
        '
        'Check
        '
        Me.Check.BackColor = System.Drawing.Color.White
        Me.Check.Enabled = False
        Me.Check.FlatAppearance.BorderSize = 0
        Me.Check.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.Check.Location = New System.Drawing.Point(493, 365)
        Me.Check.Name = "Check"
        Me.Check.Size = New System.Drawing.Size(254, 23)
        Me.Check.TabIndex = 18
        Me.Check.Text = "Check Team"
        Me.Check.UseVisualStyleBackColor = False
        Me.Check.Visible = False
        '
        'Carica
        '
        Me.Carica.BackColor = System.Drawing.Color.White
        Me.Carica.Enabled = False
        Me.Carica.FlatAppearance.BorderSize = 0
        Me.Carica.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.Carica.Location = New System.Drawing.Point(493, 397)
        Me.Carica.Name = "Carica"
        Me.Carica.Size = New System.Drawing.Size(254, 23)
        Me.Carica.TabIndex = 19
        Me.Carica.Text = "Carica Team"
        Me.Carica.UseVisualStyleBackColor = False
        Me.Carica.Visible = False
        '
        'Varie
        '
        Me.Varie.BackColor = System.Drawing.Color.White
        Me.Varie.Enabled = False
        Me.Varie.FlatAppearance.BorderSize = 0
        Me.Varie.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.Varie.Location = New System.Drawing.Point(493, 426)
        Me.Varie.Name = "Varie"
        Me.Varie.Size = New System.Drawing.Size(254, 23)
        Me.Varie.TabIndex = 20
        Me.Varie.Text = "Vari ed eventuali..." & Global.Microsoft.VisualBasic.ChrW(13) & Global.Microsoft.VisualBasic.ChrW(10)
        Me.Varie.UseVisualStyleBackColor = False
        Me.Varie.Visible = False
        '
        'builder
        '
        Me.builder.BackColor = System.Drawing.Color.White
        Me.builder.Enabled = False
        Me.builder.FlatAppearance.BorderSize = 0
        Me.builder.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.builder.Location = New System.Drawing.Point(493, 305)
        Me.builder.Name = "builder"
        Me.builder.Size = New System.Drawing.Size(254, 23)
        Me.builder.TabIndex = 21
        Me.builder.Text = "Team Builder"
        Me.builder.UseVisualStyleBackColor = False
        Me.builder.Visible = False
        '
        'Export
        '
        Me.Export.BackColor = System.Drawing.Color.White
        Me.Export.Enabled = False
        Me.Export.FlatAppearance.BorderSize = 0
        Me.Export.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.Export.Location = New System.Drawing.Point(493, 336)
        Me.Export.Name = "Export"
        Me.Export.Size = New System.Drawing.Size(254, 23)
        Me.Export.TabIndex = 22
        Me.Export.Text = "Export to Text"
        Me.Export.UseVisualStyleBackColor = False
        Me.Export.Visible = False
        '
        'Salva
        '
        Me.Salva.BackColor = System.Drawing.Color.White
        Me.Salva.Enabled = False
        Me.Salva.FlatAppearance.BorderSize = 0
        Me.Salva.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.Salva.Location = New System.Drawing.Point(493, 426)
        Me.Salva.Name = "Salva"
        Me.Salva.Size = New System.Drawing.Size(254, 23)
        Me.Salva.TabIndex = 23
        Me.Salva.Text = "Salva Team"
        Me.Salva.UseVisualStyleBackColor = False
        Me.Salva.Visible = False
        '
        'IVs
        '
        Me.IVs.BackColor = System.Drawing.Color.White
        Me.IVs.Enabled = False
        Me.IVs.FlatAppearance.BorderSize = 0
        Me.IVs.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.IVs.Location = New System.Drawing.Point(493, 336)
        Me.IVs.Name = "IVs"
        Me.IVs.Size = New System.Drawing.Size(254, 23)
        Me.IVs.TabIndex = 24
        Me.IVs.Text = "Calcolatore IVs"
        Me.IVs.UseVisualStyleBackColor = False
        Me.IVs.Visible = False
        '
        'Danni
        '
        Me.Danni.BackColor = System.Drawing.Color.White
        Me.Danni.Enabled = False
        Me.Danni.FlatAppearance.BorderSize = 0
        Me.Danni.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.Danni.Location = New System.Drawing.Point(493, 305)
        Me.Danni.Name = "Danni"
        Me.Danni.Size = New System.Drawing.Size(254, 23)
        Me.Danni.TabIndex = 25
        Me.Danni.Text = "Calcolatore Danni"
        Me.Danni.UseVisualStyleBackColor = False
        Me.Danni.Visible = False
        '
        'Form1
        '
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.None
        Me.BackColor = System.Drawing.Color.Tan
        Me.BackgroundImage = CType(resources.GetObject("$this.BackgroundImage"), System.Drawing.Image)
        Me.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None
        Me.ClientSize = New System.Drawing.Size(808, 504)
        Me.Controls.Add(Me.Danni)
        Me.Controls.Add(Me.IVs)
        Me.Controls.Add(Me.Salva)
        Me.Controls.Add(Me.Export)
        Me.Controls.Add(Me.builder)
        Me.Controls.Add(Me.Varie)
        Me.Controls.Add(Me.Carica)
        Me.Controls.Add(Me.Check)
        Me.Controls.Add(Me.Pokèdex)
        Me.Controls.Add(Me.Introforza)
        Me.Controls.Add(Me.Button6)
        Me.Controls.Add(Me.Button5)
        Me.Controls.Add(Me.Button4)
        Me.Controls.Add(Me.Build)
        Me.Controls.Add(Me.Tools)
        Me.Cursor = System.Windows.Forms.Cursors.PanNW
        Me.DoubleBuffered = True
        Me.ForeColor = System.Drawing.SystemColors.ControlText
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None
        Me.Name = "Form1"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Project G - Closed Beta"
        Me.TransparencyKey = System.Drawing.Color.Tan
        Me.ResumeLayout(False)

    End Sub
    Friend WithEvents Tools As System.Windows.Forms.Button
    Friend WithEvents Build As System.Windows.Forms.Button
    Friend WithEvents Button4 As System.Windows.Forms.Button
    Friend WithEvents Button5 As System.Windows.Forms.Button
    Friend WithEvents Button6 As System.Windows.Forms.Button
    Friend WithEvents Introforza As System.Windows.Forms.Button
    Friend WithEvents Pokèdex As System.Windows.Forms.Button
    Friend WithEvents Check As System.Windows.Forms.Button
    Friend WithEvents Carica As System.Windows.Forms.Button
    Friend WithEvents Varie As System.Windows.Forms.Button
    Friend WithEvents builder As System.Windows.Forms.Button
    Friend WithEvents Export As System.Windows.Forms.Button
    Friend WithEvents Salva As System.Windows.Forms.Button
    Friend WithEvents IVs As System.Windows.Forms.Button
    Friend WithEvents Danni As System.Windows.Forms.Button

End Class
