<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Introforza1
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
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(Introforza1))
        Me.Button3 = New System.Windows.Forms.Button
        Me.Button4 = New System.Windows.Forms.Button
        Me.Button5 = New System.Windows.Forms.Button
        Me.Button6 = New System.Windows.Forms.Button
        Me.Back = New System.Windows.Forms.Button
        Me.hp = New System.Windows.Forms.TextBox
        Me.GroupBox1 = New System.Windows.Forms.GroupBox
        Me.Label6 = New System.Windows.Forms.Label
        Me.Label5 = New System.Windows.Forms.Label
        Me.Label4 = New System.Windows.Forms.Label
        Me.Label3 = New System.Windows.Forms.Label
        Me.Label2 = New System.Windows.Forms.Label
        Me.Label1 = New System.Windows.Forms.Label
        Me.vel = New System.Windows.Forms.TextBox
        Me.atk = New System.Windows.Forms.TextBox
        Me.dif = New System.Windows.Forms.TextBox
        Me.atksp = New System.Windows.Forms.TextBox
        Me.difsp = New System.Windows.Forms.TextBox
        Me.Label7 = New System.Windows.Forms.Label
        Me.Label8 = New System.Windows.Forms.Label
        Me.GroupBox2 = New System.Windows.Forms.GroupBox
        Me.tipo = New System.Windows.Forms.TextBox
        Me.potenza = New System.Windows.Forms.TextBox
        Me.TextBox1 = New System.Windows.Forms.TextBox
        Me.GroupBox1.SuspendLayout()
        Me.SuspendLayout()
        '
        'Button3
        '
        Me.Button3.BackColor = System.Drawing.Color.Transparent
        Me.Button3.BackgroundImage = CType(resources.GetObject("Button3.BackgroundImage"), System.Drawing.Image)
        Me.Button3.FlatAppearance.BorderSize = 0
        Me.Button3.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.Button3.Location = New System.Drawing.Point(445, 182)
        Me.Button3.Name = "Button3"
        Me.Button3.Size = New System.Drawing.Size(50, 87)
        Me.Button3.TabIndex = 2
        Me.Button3.UseVisualStyleBackColor = False
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
        'Back
        '
        Me.Back.BackColor = System.Drawing.Color.White
        Me.Back.FlatAppearance.BorderSize = 0
        Me.Back.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.Back.Location = New System.Drawing.Point(494, 302)
        Me.Back.Name = "Back"
        Me.Back.Size = New System.Drawing.Size(254, 23)
        Me.Back.TabIndex = 25
        Me.Back.Text = "<< Indietro"
        Me.Back.UseVisualStyleBackColor = False
        '
        'hp
        '
        Me.hp.Location = New System.Drawing.Point(6, 19)
        Me.hp.MaxLength = 2
        Me.hp.Name = "hp"
        Me.hp.Size = New System.Drawing.Size(20, 20)
        Me.hp.TabIndex = 26
        Me.hp.Text = "31"
        '
        'GroupBox1
        '
        Me.GroupBox1.BackColor = System.Drawing.Color.Transparent
        Me.GroupBox1.Controls.Add(Me.Label6)
        Me.GroupBox1.Controls.Add(Me.Label5)
        Me.GroupBox1.Controls.Add(Me.Label4)
        Me.GroupBox1.Controls.Add(Me.Label3)
        Me.GroupBox1.Controls.Add(Me.Label2)
        Me.GroupBox1.Controls.Add(Me.Label1)
        Me.GroupBox1.Controls.Add(Me.vel)
        Me.GroupBox1.Controls.Add(Me.atk)
        Me.GroupBox1.Controls.Add(Me.dif)
        Me.GroupBox1.Controls.Add(Me.atksp)
        Me.GroupBox1.Controls.Add(Me.difsp)
        Me.GroupBox1.Controls.Add(Me.hp)
        Me.GroupBox1.Location = New System.Drawing.Point(61, 312)
        Me.GroupBox1.Name = "GroupBox1"
        Me.GroupBox1.Size = New System.Drawing.Size(360, 79)
        Me.GroupBox1.TabIndex = 27
        Me.GroupBox1.TabStop = False
        Me.GroupBox1.Text = "Individual Values (IVs)"
        '
        'Label6
        '
        Me.Label6.AutoSize = True
        Me.Label6.BackColor = System.Drawing.Color.Transparent
        Me.Label6.Location = New System.Drawing.Point(133, 47)
        Me.Label6.Name = "Label6"
        Me.Label6.Size = New System.Drawing.Size(22, 13)
        Me.Label6.TabIndex = 36
        Me.Label6.Text = "Vel"
        '
        'Label5
        '
        Me.Label5.AutoSize = True
        Me.Label5.BackColor = System.Drawing.Color.Transparent
        Me.Label5.Location = New System.Drawing.Point(107, 47)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(28, 13)
        Me.Label5.TabIndex = 35
        Me.Label5.Text = "SpD"
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.BackColor = System.Drawing.Color.Transparent
        Me.Label4.Location = New System.Drawing.Point(81, 47)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(27, 13)
        Me.Label4.TabIndex = 34
        Me.Label4.Text = "SpA"
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.BackColor = System.Drawing.Color.Transparent
        Me.Label3.Location = New System.Drawing.Point(55, 47)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(20, 13)
        Me.Label3.TabIndex = 33
        Me.Label3.Text = "Dif"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.BackColor = System.Drawing.Color.Transparent
        Me.Label2.Location = New System.Drawing.Point(29, 47)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(23, 13)
        Me.Label2.TabIndex = 32
        Me.Label2.Text = "Atk"
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.BackColor = System.Drawing.Color.Transparent
        Me.Label1.Location = New System.Drawing.Point(3, 47)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(22, 13)
        Me.Label1.TabIndex = 28
        Me.Label1.Text = "HP"
        '
        'vel
        '
        Me.vel.Location = New System.Drawing.Point(136, 19)
        Me.vel.MaxLength = 2
        Me.vel.Name = "vel"
        Me.vel.Size = New System.Drawing.Size(20, 20)
        Me.vel.TabIndex = 31
        Me.vel.Text = "31"
        '
        'atk
        '
        Me.atk.Location = New System.Drawing.Point(32, 19)
        Me.atk.MaxLength = 2
        Me.atk.Name = "atk"
        Me.atk.Size = New System.Drawing.Size(20, 20)
        Me.atk.TabIndex = 30
        Me.atk.Text = "31"
        '
        'dif
        '
        Me.dif.Location = New System.Drawing.Point(58, 19)
        Me.dif.MaxLength = 2
        Me.dif.Name = "dif"
        Me.dif.Size = New System.Drawing.Size(20, 20)
        Me.dif.TabIndex = 29
        Me.dif.Text = "31"
        '
        'atksp
        '
        Me.atksp.Location = New System.Drawing.Point(84, 19)
        Me.atksp.MaxLength = 2
        Me.atksp.Name = "atksp"
        Me.atksp.Size = New System.Drawing.Size(20, 20)
        Me.atksp.TabIndex = 28
        Me.atksp.Text = "31"
        '
        'difsp
        '
        Me.difsp.Location = New System.Drawing.Point(110, 19)
        Me.difsp.MaxLength = 2
        Me.difsp.Name = "difsp"
        Me.difsp.Size = New System.Drawing.Size(20, 20)
        Me.difsp.TabIndex = 27
        Me.difsp.Text = "31"
        '
        'Label7
        '
        Me.Label7.AutoSize = True
        Me.Label7.BackColor = System.Drawing.Color.Transparent
        Me.Label7.Location = New System.Drawing.Point(64, 68)
        Me.Label7.Name = "Label7"
        Me.Label7.Size = New System.Drawing.Size(34, 13)
        Me.Label7.TabIndex = 29
        Me.Label7.Text = "Tipo: "
        '
        'Label8
        '
        Me.Label8.AutoSize = True
        Me.Label8.BackColor = System.Drawing.Color.Transparent
        Me.Label8.Location = New System.Drawing.Point(64, 86)
        Me.Label8.Name = "Label8"
        Me.Label8.Size = New System.Drawing.Size(49, 13)
        Me.Label8.TabIndex = 30
        Me.Label8.Text = "Potenza:"
        '
        'GroupBox2
        '
        Me.GroupBox2.BackColor = System.Drawing.Color.Transparent
        Me.GroupBox2.Location = New System.Drawing.Point(67, 102)
        Me.GroupBox2.Name = "GroupBox2"
        Me.GroupBox2.Size = New System.Drawing.Size(348, 132)
        Me.GroupBox2.TabIndex = 31
        Me.GroupBox2.TabStop = False
        Me.GroupBox2.Text = "Introforze Alternative"
        '
        'tipo
        '
        Me.tipo.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle
        Me.tipo.Location = New System.Drawing.Point(289, 66)
        Me.tipo.MaxLength = 50
        Me.tipo.Name = "tipo"
        Me.tipo.ReadOnly = True
        Me.tipo.Size = New System.Drawing.Size(126, 20)
        Me.tipo.TabIndex = 32
        '
        'potenza
        '
        Me.potenza.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle
        Me.potenza.Location = New System.Drawing.Point(289, 86)
        Me.potenza.MaxLength = 2
        Me.potenza.Name = "potenza"
        Me.potenza.ReadOnly = True
        Me.potenza.Size = New System.Drawing.Size(20, 20)
        Me.potenza.TabIndex = 33
        '
        'TextBox1
        '
        Me.TextBox1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle
        Me.TextBox1.Enabled = False
        Me.TextBox1.Location = New System.Drawing.Point(273, 66)
        Me.TextBox1.MaxLength = 50
        Me.TextBox1.Name = "TextBox1"
        Me.TextBox1.ReadOnly = True
        Me.TextBox1.Size = New System.Drawing.Size(10, 20)
        Me.TextBox1.TabIndex = 34
        Me.TextBox1.Visible = False
        '
        'Introforza1
        '
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.None
        Me.BackColor = System.Drawing.Color.Tan
        Me.BackgroundImage = CType(resources.GetObject("$this.BackgroundImage"), System.Drawing.Image)
        Me.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None
        Me.ClientSize = New System.Drawing.Size(808, 504)
        Me.Controls.Add(Me.TextBox1)
        Me.Controls.Add(Me.potenza)
        Me.Controls.Add(Me.tipo)
        Me.Controls.Add(Me.GroupBox2)
        Me.Controls.Add(Me.Label8)
        Me.Controls.Add(Me.Label7)
        Me.Controls.Add(Me.GroupBox1)
        Me.Controls.Add(Me.Back)
        Me.Controls.Add(Me.Button6)
        Me.Controls.Add(Me.Button5)
        Me.Controls.Add(Me.Button4)
        Me.Controls.Add(Me.Button3)
        Me.Cursor = System.Windows.Forms.Cursors.PanNW
        Me.DoubleBuffered = True
        Me.ForeColor = System.Drawing.SystemColors.ControlText
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None
        Me.Name = "Introforza1"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Project G - Closed Beta"
        Me.TransparencyKey = System.Drawing.Color.Tan
        Me.GroupBox1.ResumeLayout(False)
        Me.GroupBox1.PerformLayout()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents Button3 As System.Windows.Forms.Button
    Friend WithEvents Button4 As System.Windows.Forms.Button
    Friend WithEvents Button5 As System.Windows.Forms.Button
    Friend WithEvents Button6 As System.Windows.Forms.Button
    Friend WithEvents Back As System.Windows.Forms.Button
    Friend WithEvents hp As System.Windows.Forms.TextBox
    Friend WithEvents GroupBox1 As System.Windows.Forms.GroupBox
    Friend WithEvents Label6 As System.Windows.Forms.Label
    Friend WithEvents Label5 As System.Windows.Forms.Label
    Friend WithEvents Label4 As System.Windows.Forms.Label
    Friend WithEvents Label3 As System.Windows.Forms.Label
    Friend WithEvents Label2 As System.Windows.Forms.Label
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents vel As System.Windows.Forms.TextBox
    Friend WithEvents atk As System.Windows.Forms.TextBox
    Friend WithEvents dif As System.Windows.Forms.TextBox
    Friend WithEvents atksp As System.Windows.Forms.TextBox
    Friend WithEvents difsp As System.Windows.Forms.TextBox
    Friend WithEvents Label7 As System.Windows.Forms.Label
    Friend WithEvents Label8 As System.Windows.Forms.Label
    Friend WithEvents GroupBox2 As System.Windows.Forms.GroupBox
    Friend WithEvents tipo As System.Windows.Forms.TextBox
    Friend WithEvents potenza As System.Windows.Forms.TextBox
    Friend WithEvents TextBox1 As System.Windows.Forms.TextBox

End Class
