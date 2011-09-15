<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class IVs1
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
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(IVs1))
        Me.Button3 = New System.Windows.Forms.Button
        Me.ComboBox1 = New System.Windows.Forms.ComboBox
        Me.Button4 = New System.Windows.Forms.Button
        Me.Button5 = New System.Windows.Forms.Button
        Me.Button6 = New System.Windows.Forms.Button
        Me.Back = New System.Windows.Forms.Button
        Me.GroupBox1 = New System.Windows.Forms.GroupBox
        Me.vel = New System.Windows.Forms.TextBox
        Me.atk = New System.Windows.Forms.TextBox
        Me.atksp = New System.Windows.Forms.TextBox
        Me.difsp = New System.Windows.Forms.TextBox
        Me.dif = New System.Windows.Forms.TextBox
        Me.hp = New System.Windows.Forms.TextBox
        Me.GroupBox2 = New System.Windows.Forms.GroupBox
        Me.vele = New System.Windows.Forms.TextBox
        Me.atke = New System.Windows.Forms.TextBox
        Me.atkspe = New System.Windows.Forms.TextBox
        Me.difspe = New System.Windows.Forms.TextBox
        Me.dife = New System.Windows.Forms.TextBox
        Me.hpe = New System.Windows.Forms.TextBox
        Me.liv = New System.Windows.Forms.TextBox
        Me.Label1 = New System.Windows.Forms.Label
        Me.Label2 = New System.Windows.Forms.Label
        Me.Label3 = New System.Windows.Forms.Label
        Me.Label4 = New System.Windows.Forms.Label
        Me.Label5 = New System.Windows.Forms.Label
        Me.Label6 = New System.Windows.Forms.Label
        Me.Label7 = New System.Windows.Forms.Label
        Me.ComboBox2 = New System.Windows.Forms.ComboBox
        Me.Label8 = New System.Windows.Forms.Label
        Me.Label9 = New System.Windows.Forms.Label
        Me.GroupBox3 = New System.Windows.Forms.GroupBox
        Me.TextBox2 = New System.Windows.Forms.TextBox
        Me.TextBox3 = New System.Windows.Forms.TextBox
        Me.TextBox4 = New System.Windows.Forms.TextBox
        Me.TextBox5 = New System.Windows.Forms.TextBox
        Me.TextBox6 = New System.Windows.Forms.TextBox
        Me.TextBox7 = New System.Windows.Forms.TextBox
        Me.Label10 = New System.Windows.Forms.Label
        Me.Label11 = New System.Windows.Forms.Label
        Me.Label12 = New System.Windows.Forms.Label
        Me.Label13 = New System.Windows.Forms.Label
        Me.Label14 = New System.Windows.Forms.Label
        Me.Label15 = New System.Windows.Forms.Label
        Me.GroupBox1.SuspendLayout()
        Me.GroupBox2.SuspendLayout()
        Me.GroupBox3.SuspendLayout()
        Me.SuspendLayout()
        '
        'Button3
        '
        Me.Button3.BackColor = System.Drawing.Color.Transparent
        Me.Button3.BackgroundImage = CType(resources.GetObject("Button3.BackgroundImage"), System.Drawing.Image)
        Me.Button3.FlatAppearance.BorderSize = 0
        Me.Button3.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.Button3.Location = New System.Drawing.Point(447, 182)
        Me.Button3.Name = "Button3"
        Me.Button3.Size = New System.Drawing.Size(50, 87)
        Me.Button3.TabIndex = 2
        Me.Button3.UseVisualStyleBackColor = False
        '
        'ComboBox1
        '
        Me.ComboBox1.BackColor = System.Drawing.Color.Silver
        Me.ComboBox1.DropDownHeight = 100
        Me.ComboBox1.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList
        Me.ComboBox1.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.ComboBox1.FormattingEnabled = True
        Me.ComboBox1.IntegralHeight = False
        Me.ComboBox1.Items.AddRange(New Object() {"Abomasnow", "Abra", "Absol", "Aerodactyl", "Aggron", "Aipom", "Alakazam", "Altaria", "Ambipom", "Ampharos", "Anorith", "Arbok", "Arcanine", "Arceus", "Ariados", "Armaldo", "Aron", "Articuno", "Azelf", "Azumarill", "Azurill", "Bagon", "Baltoy", "Banette", "Barboach", "Bastiodon", "Bayleef", "Beautifly", "Beedrill", "Beldum", "Bellossom", "Bellsprout", "Bibarel", "Bidoof", "Blastoise", "Blaziken", "Blissey", "Bonsly", "Breloom", "Bronzong", "Bronzor", "Budew", "Buizel", "Bulbasaur", "Buneary", "Burmy", "Butterfree", "Cacnea", "Cacturne", "Camerupt", "Carnivine", "Carvanha", "Cascoon", "Castform", "Caterpie", "Celebi", "Chansey", "Charizard", "Charmander", "Charmeleon", "Chatot", "Cherrim", "Cherubi", "Chikorita", "Chimchar", "Chimecho", "Chinchou", "Chingling", "Clamperl", "Claydol", "Clefable", "Clefairy", "Cleffa", "Cloyster", "Combee", "Combusken", "Corphish", "Corsola", "Cradily", "Cranidos", "Crawdaunt", "Cresselia", "Croagunk", "Crobat", "Croconaw", "Cubone", "Cyndaquil", "Darkrai", "Delcatty", "Delibird", "Deoxys", "Deoxys-E", "Deoxys-F", "Deoxys-L", "Dewgong", "Dialga", "Diglett", "Ditto", "Dodrio", "Doduo", "Donphan", "Dragonair", "Dragonite", "Drapion", "Dratini", "Drifblim", "Drifloon", "Drowzee", "Dugtrio", "Dunsparce", "Dusclops", "Dusknoir", "Duskull", "Dustox", "Eevee", "Ekans", "Electabuzz", "Electivire", "Electrike", "Electrode", "Elekid", "Empoleon", "Entei", "Espeon", "Exeggcute", "Exeggutor", "Exploud", "Farfetch'd", "Fearow", "Feebas", "Feraligatr", "Finneon", "Flaaffy", "Flareon", "Floatzel", "Flygon", "Forretress", "Froslass", "Furret", "Gabite", "Gallade", "Garchomp", "Gastrodon", "Gengar", "Geodude", "Gible", "Girafarig", "Giratina", "Glaceon", "Glalie", "Glameow", "Gligar", "Gliscor", "Gloom", "Golbat", "Goldeen", "Golduck", "Golem", "Gorebyss", "Granbull", "Graveler", "Grimer", "Grotle", "Groudon", "Grovyle", "Growlithe", "Grumpig", "Gulpin", "Gyarados", "Happiny", "Hariyama", "Haunter", "Heatran", "Heracross", "Hippopotas", "Hippowdon", "Hitmonchan", "Hitmonlee", "Hitmontop", "Ho-oh", "Honchkrow", "Hoothoot", "Hoppip", "Horsea", "Houndoom", "Houndour", "Huntail", "Hypno", "Igglybuff", "Illumise", "Infernape", "Ivysaur", "Jigglypuff", "Jirachi", "Jolteon", "Jumpluff", "Jynx", "Kabuto", "Kabutops", "Kadabra", "Kakuna", "Kangaskhan", "Kecleon", "Kingdra", "Kingler", "Kirlia", "Koffing", "Krabby", "Kricketot", "Kricketune", "Kyogre", "Lairon", "Lanturn", "Lapras", "Larvitar", "Latias", "Latios", "Leafeon", "Ledian", "Ledyba", "Lickilicky", "Lickitung", "Lileep", "Linoone", "Lombre", "Ledian", "Lopunny", "Lotad", "Lombre", "Lucario", "Ludicolo", "Lugia", "Lumineon", "Lunatone", "Luvdisc", "Luxio", "Luxray", "Machamp", "Machoke", "Machop", "Magby", "Magcargo", "Magikarp", "Magmar", "Magmortar", "Magnemite", "Magneton", "Magnezone", "Makuhita", "Mamoswine", "Manaphy", "Manectric", "Mankey", "Mantine", "Mantyke", "Mareep", "Marill", "Marowak", "Marshtomp", "Masquerain", "Mawile", "Medicham", "Meditite", "Meganium", "Meowth", "Mesprit", "Metagross", "Metang", "Metapod", "Mew", "Mewtwo", "Mightyena", "Milotic", "Miltank", "Mime Jr", "Minun", "Misdreavus", "Mismagius", "Moltres", "Monferno", "Mothim", "Mr Mime", "Mudkip", "Muk", "Munchlax", "Murkrow", "Natu", "Nidoking", "Nidoqueen", "Nidoran-M", "Nidorina", "Nidorino", "Nincada", "Ninetales", "Ninjask", "Noctowl", "Nosepass", "Numel", "Nuzleaf", "Octillery", "Oddish", "Omanyte", "Omastar", "Onix", "Pachirisu", "Palkia", "Paras", "Parasect", "Pelipper", "Persian", "Phanpy", "Phione", "Pichu", "Pidgeot", "Pidgeotto", "Pidgey", "Pikachu", "Piloswine", "Pineco", "Pinsir", "Piplup", "Plusle", "Politoed", "Poliwag", "Poliwhirl", "Poliwrath", "Ponyta", "Poochyena", "Porygon", "Porygon-Z", "Porygon2", "Primeape", "Prinplup", "Probopass", "Psyduck", "Pupitar", "Purugly", "Quagsire", "Quilava", "Qwilfish", "Raichu", "Raikou", "Ralts", "Rampardos", "Rapidash", "Raticate", "Rattata", "Rayquaza", "Regice", "Regigigas", "Regirock", "Registeel", "Relicanth", "Remoraid", "Rhydon", "Rhyhorn", "Rhyperior", "Riolu", "Roselia", "Roserade", "Rotom", "Sableye", "Salamence", "Sandshrew", "Sandslash", "Sceptile", "Scizor", "Scyther", "Seadra", "Seaking", "Sealeo", "Seedot", "Seel", "Sentret", "Seviper", "Sharpedo", "Shaymin", "Shedinja", "Shelgon", "Shellder", "Shellos", "Shieldon", "Shiftry", "Shinx", "Shroomish", "Shuckle", "Shuppet", "Silcoon", "Skarmory", "Skiploom", "Skitty", "Skorupi", "Skuntank", "Slaking", "Slakoth", "Slowbro", "Slowking", "Slowpoke", "Slugma", "Smeargle", "Smoochum", "Sneasel", "Snorlax", "Snorunt", "Snover", "Snubbull", "Solrock", "Spearow", "Spheal", "Spinarak", "Spinda", "Spiritomb", "Spoink", "Squirtle", "Stantler", "Staraptor", "Staravia", "Starly", "Starmie", "Staryu", "Steelix", "Stunky", "Sudowoodo", "Suicune", "Sunflora", "Sunkern", "Surskit", "Swablu", "Swalot", "Swampert", "Swellow", "Swinub", "Taillow", "Tangela", "Tangrowth", "Tauros", "Teddiursa", "Tentacool", "Tentacruel", "Togekiss", "Togetic", "Torchic", "Torkoal", "Torterra", "Totodile", "Toxicroak", "Trapinch", "Treecko", "Tropius", "Turtwig", "Typhlosion", "Tyranitar", "Tyrogue", "Umbreon", "Unown", "Ursaring", "Uxie", "Vaporeon", "Venomoth", "Venonat", "Venusaur", "Vespiquen", "Vibrava", "Victreebel", "Vigoroth", "Vileplume", "Volbeat", "Voltorb", "Vulpix", "Wailmer", "Wailord", "Walrein", "Wartortle", "Weavile", "Weedle", "Weepinbell", "Weezing", "Whiscash", "Whismur", "Wigglytuff", "Wingull", "Wobbuffet", "Wooper", "Wormadam", "Wurmple", "Wynaut", "Xatu", "Yanma", "Yanmega", "Zangoose", "Zapdos", "Zigzagoon", "Zubat"})
        Me.ComboBox1.Location = New System.Drawing.Point(321, 323)
        Me.ComboBox1.Name = "ComboBox1"
        Me.ComboBox1.Size = New System.Drawing.Size(97, 21)
        Me.ComboBox1.TabIndex = 4
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
        Me.Back.Location = New System.Drawing.Point(493, 302)
        Me.Back.Name = "Back"
        Me.Back.Size = New System.Drawing.Size(254, 23)
        Me.Back.TabIndex = 25
        Me.Back.Text = "<< Indietro"
        Me.Back.UseVisualStyleBackColor = False
        '
        'GroupBox1
        '
        Me.GroupBox1.BackColor = System.Drawing.Color.Transparent
        Me.GroupBox1.Controls.Add(Me.vel)
        Me.GroupBox1.Controls.Add(Me.atk)
        Me.GroupBox1.Controls.Add(Me.atksp)
        Me.GroupBox1.Controls.Add(Me.difsp)
        Me.GroupBox1.Controls.Add(Me.dif)
        Me.GroupBox1.Controls.Add(Me.hp)
        Me.GroupBox1.Location = New System.Drawing.Point(62, 330)
        Me.GroupBox1.Name = "GroupBox1"
        Me.GroupBox1.Size = New System.Drawing.Size(255, 52)
        Me.GroupBox1.TabIndex = 26
        Me.GroupBox1.TabStop = False
        Me.GroupBox1.Text = "Statistiche"
        '
        'vel
        '
        Me.vel.Location = New System.Drawing.Point(136, 19)
        Me.vel.MaxLength = 3
        Me.vel.Name = "vel"
        Me.vel.Size = New System.Drawing.Size(24, 20)
        Me.vel.TabIndex = 32
        '
        'atk
        '
        Me.atk.Location = New System.Drawing.Point(32, 19)
        Me.atk.MaxLength = 3
        Me.atk.Name = "atk"
        Me.atk.Size = New System.Drawing.Size(24, 20)
        Me.atk.TabIndex = 31
        '
        'atksp
        '
        Me.atksp.Location = New System.Drawing.Point(84, 19)
        Me.atksp.MaxLength = 3
        Me.atksp.Name = "atksp"
        Me.atksp.Size = New System.Drawing.Size(24, 20)
        Me.atksp.TabIndex = 30
        '
        'difsp
        '
        Me.difsp.Location = New System.Drawing.Point(110, 19)
        Me.difsp.MaxLength = 3
        Me.difsp.Name = "difsp"
        Me.difsp.Size = New System.Drawing.Size(24, 20)
        Me.difsp.TabIndex = 29
        '
        'dif
        '
        Me.dif.Location = New System.Drawing.Point(58, 19)
        Me.dif.MaxLength = 3
        Me.dif.Name = "dif"
        Me.dif.Size = New System.Drawing.Size(24, 20)
        Me.dif.TabIndex = 28
        '
        'hp
        '
        Me.hp.Location = New System.Drawing.Point(6, 19)
        Me.hp.MaxLength = 3
        Me.hp.Name = "hp"
        Me.hp.Size = New System.Drawing.Size(24, 20)
        Me.hp.TabIndex = 27
        '
        'GroupBox2
        '
        Me.GroupBox2.BackColor = System.Drawing.Color.Transparent
        Me.GroupBox2.Controls.Add(Me.vele)
        Me.GroupBox2.Controls.Add(Me.atke)
        Me.GroupBox2.Controls.Add(Me.atkspe)
        Me.GroupBox2.Controls.Add(Me.difspe)
        Me.GroupBox2.Controls.Add(Me.dife)
        Me.GroupBox2.Controls.Add(Me.hpe)
        Me.GroupBox2.Location = New System.Drawing.Point(62, 388)
        Me.GroupBox2.Name = "GroupBox2"
        Me.GroupBox2.Size = New System.Drawing.Size(255, 52)
        Me.GroupBox2.TabIndex = 27
        Me.GroupBox2.TabStop = False
        Me.GroupBox2.Text = "Effort Values (EVs)"
        '
        'vele
        '
        Me.vele.Location = New System.Drawing.Point(136, 19)
        Me.vele.MaxLength = 3
        Me.vele.Name = "vele"
        Me.vele.Size = New System.Drawing.Size(24, 20)
        Me.vele.TabIndex = 46
        Me.vele.Text = "0"
        '
        'atke
        '
        Me.atke.Location = New System.Drawing.Point(32, 19)
        Me.atke.MaxLength = 3
        Me.atke.Name = "atke"
        Me.atke.Size = New System.Drawing.Size(24, 20)
        Me.atke.TabIndex = 45
        Me.atke.Text = "0"
        '
        'atkspe
        '
        Me.atkspe.Location = New System.Drawing.Point(84, 19)
        Me.atkspe.MaxLength = 3
        Me.atkspe.Name = "atkspe"
        Me.atkspe.Size = New System.Drawing.Size(24, 20)
        Me.atkspe.TabIndex = 44
        Me.atkspe.Text = "0"
        '
        'difspe
        '
        Me.difspe.Location = New System.Drawing.Point(110, 19)
        Me.difspe.MaxLength = 3
        Me.difspe.Name = "difspe"
        Me.difspe.Size = New System.Drawing.Size(24, 20)
        Me.difspe.TabIndex = 43
        Me.difspe.Text = "0"
        '
        'dife
        '
        Me.dife.Location = New System.Drawing.Point(58, 19)
        Me.dife.MaxLength = 3
        Me.dife.Name = "dife"
        Me.dife.Size = New System.Drawing.Size(24, 20)
        Me.dife.TabIndex = 42
        Me.dife.Text = "0"
        '
        'hpe
        '
        Me.hpe.Location = New System.Drawing.Point(6, 19)
        Me.hpe.MaxLength = 3
        Me.hpe.Name = "hpe"
        Me.hpe.Size = New System.Drawing.Size(24, 20)
        Me.hpe.TabIndex = 41
        Me.hpe.Text = "0"
        '
        'liv
        '
        Me.liv.Location = New System.Drawing.Point(321, 401)
        Me.liv.MaxLength = 3
        Me.liv.Name = "liv"
        Me.liv.Size = New System.Drawing.Size(24, 20)
        Me.liv.TabIndex = 40
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.BackColor = System.Drawing.Color.Transparent
        Me.Label1.Location = New System.Drawing.Point(65, 307)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(22, 13)
        Me.Label1.TabIndex = 41
        Me.Label1.Text = "HP"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.BackColor = System.Drawing.Color.Transparent
        Me.Label2.Location = New System.Drawing.Point(91, 307)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(23, 13)
        Me.Label2.TabIndex = 42
        Me.Label2.Text = "Atk"
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.BackColor = System.Drawing.Color.Transparent
        Me.Label3.Location = New System.Drawing.Point(117, 307)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(20, 13)
        Me.Label3.TabIndex = 43
        Me.Label3.Text = "Dif"
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.BackColor = System.Drawing.Color.Transparent
        Me.Label4.Location = New System.Drawing.Point(143, 307)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(27, 13)
        Me.Label4.TabIndex = 44
        Me.Label4.Text = "SpA"
        '
        'Label5
        '
        Me.Label5.AutoSize = True
        Me.Label5.BackColor = System.Drawing.Color.Transparent
        Me.Label5.Location = New System.Drawing.Point(169, 307)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(28, 13)
        Me.Label5.TabIndex = 45
        Me.Label5.Text = "SpD"
        '
        'Label6
        '
        Me.Label6.AutoSize = True
        Me.Label6.BackColor = System.Drawing.Color.Transparent
        Me.Label6.Location = New System.Drawing.Point(195, 307)
        Me.Label6.Name = "Label6"
        Me.Label6.Size = New System.Drawing.Size(22, 13)
        Me.Label6.TabIndex = 46
        Me.Label6.Text = "Vel"
        '
        'Label7
        '
        Me.Label7.AutoSize = True
        Me.Label7.BackColor = System.Drawing.Color.Transparent
        Me.Label7.Location = New System.Drawing.Point(320, 307)
        Me.Label7.Name = "Label7"
        Me.Label7.Size = New System.Drawing.Size(52, 13)
        Me.Label7.TabIndex = 47
        Me.Label7.Text = "Pokèmon"
        '
        'ComboBox2
        '
        Me.ComboBox2.BackColor = System.Drawing.Color.Silver
        Me.ComboBox2.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList
        Me.ComboBox2.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.ComboBox2.FormattingEnabled = True
        Me.ComboBox2.Items.AddRange(New Object() {"Adamant", "Bashful", "Bold", "Brave", "Calm", "Careful", "Docile", "Gentle", "Hardy", "Hasty", "Impish", "Jolly", "Lax", "Lonely", "Mild", "Modest", "Naive", "Naughty", "Quiet", "Quirky", "Rash", "Relaxed", "Sassy", "Serious", "Timid"})
        Me.ComboBox2.Location = New System.Drawing.Point(321, 361)
        Me.ComboBox2.Name = "ComboBox2"
        Me.ComboBox2.Size = New System.Drawing.Size(96, 21)
        Me.ComboBox2.TabIndex = 48
        '
        'Label8
        '
        Me.Label8.AutoSize = True
        Me.Label8.BackColor = System.Drawing.Color.Transparent
        Me.Label8.Location = New System.Drawing.Point(320, 347)
        Me.Label8.Name = "Label8"
        Me.Label8.Size = New System.Drawing.Size(39, 13)
        Me.Label8.TabIndex = 49
        Me.Label8.Text = "Natura"
        '
        'Label9
        '
        Me.Label9.AutoSize = True
        Me.Label9.BackColor = System.Drawing.Color.Transparent
        Me.Label9.Location = New System.Drawing.Point(320, 385)
        Me.Label9.Name = "Label9"
        Me.Label9.Size = New System.Drawing.Size(37, 13)
        Me.Label9.TabIndex = 50
        Me.Label9.Text = "Livello"
        '
        'GroupBox3
        '
        Me.GroupBox3.BackColor = System.Drawing.Color.Transparent
        Me.GroupBox3.Controls.Add(Me.TextBox2)
        Me.GroupBox3.Controls.Add(Me.TextBox3)
        Me.GroupBox3.Controls.Add(Me.TextBox4)
        Me.GroupBox3.Controls.Add(Me.TextBox5)
        Me.GroupBox3.Controls.Add(Me.TextBox6)
        Me.GroupBox3.Controls.Add(Me.TextBox7)
        Me.GroupBox3.Controls.Add(Me.Label10)
        Me.GroupBox3.Controls.Add(Me.Label11)
        Me.GroupBox3.Controls.Add(Me.Label12)
        Me.GroupBox3.Controls.Add(Me.Label13)
        Me.GroupBox3.Controls.Add(Me.Label14)
        Me.GroupBox3.Controls.Add(Me.Label15)
        Me.GroupBox3.Location = New System.Drawing.Point(68, 67)
        Me.GroupBox3.Name = "GroupBox3"
        Me.GroupBox3.Size = New System.Drawing.Size(249, 60)
        Me.GroupBox3.TabIndex = 52
        Me.GroupBox3.TabStop = False
        Me.GroupBox3.Text = "Individual Values (IVs)"
        '
        'TextBox2
        '
        Me.TextBox2.Location = New System.Drawing.Point(139, 19)
        Me.TextBox2.MaxLength = 3
        Me.TextBox2.Name = "TextBox2"
        Me.TextBox2.Size = New System.Drawing.Size(20, 20)
        Me.TextBox2.TabIndex = 58
        '
        'TextBox3
        '
        Me.TextBox3.Location = New System.Drawing.Point(35, 19)
        Me.TextBox3.MaxLength = 3
        Me.TextBox3.Name = "TextBox3"
        Me.TextBox3.Size = New System.Drawing.Size(20, 20)
        Me.TextBox3.TabIndex = 57
        '
        'TextBox4
        '
        Me.TextBox4.Location = New System.Drawing.Point(87, 19)
        Me.TextBox4.MaxLength = 3
        Me.TextBox4.Name = "TextBox4"
        Me.TextBox4.Size = New System.Drawing.Size(20, 20)
        Me.TextBox4.TabIndex = 56
        '
        'TextBox5
        '
        Me.TextBox5.Location = New System.Drawing.Point(113, 19)
        Me.TextBox5.MaxLength = 3
        Me.TextBox5.Name = "TextBox5"
        Me.TextBox5.Size = New System.Drawing.Size(20, 20)
        Me.TextBox5.TabIndex = 55
        '
        'TextBox6
        '
        Me.TextBox6.Location = New System.Drawing.Point(61, 19)
        Me.TextBox6.MaxLength = 3
        Me.TextBox6.Name = "TextBox6"
        Me.TextBox6.Size = New System.Drawing.Size(20, 20)
        Me.TextBox6.TabIndex = 54
        '
        'TextBox7
        '
        Me.TextBox7.Location = New System.Drawing.Point(9, 19)
        Me.TextBox7.MaxLength = 3
        Me.TextBox7.Name = "TextBox7"
        Me.TextBox7.Size = New System.Drawing.Size(20, 20)
        Me.TextBox7.TabIndex = 53
        '
        'Label10
        '
        Me.Label10.AutoSize = True
        Me.Label10.BackColor = System.Drawing.Color.Transparent
        Me.Label10.Location = New System.Drawing.Point(137, 42)
        Me.Label10.Name = "Label10"
        Me.Label10.Size = New System.Drawing.Size(22, 13)
        Me.Label10.TabIndex = 52
        Me.Label10.Text = "Vel"
        '
        'Label11
        '
        Me.Label11.AutoSize = True
        Me.Label11.BackColor = System.Drawing.Color.Transparent
        Me.Label11.Location = New System.Drawing.Point(111, 42)
        Me.Label11.Name = "Label11"
        Me.Label11.Size = New System.Drawing.Size(28, 13)
        Me.Label11.TabIndex = 51
        Me.Label11.Text = "SpD"
        '
        'Label12
        '
        Me.Label12.AutoSize = True
        Me.Label12.BackColor = System.Drawing.Color.Transparent
        Me.Label12.Location = New System.Drawing.Point(85, 42)
        Me.Label12.Name = "Label12"
        Me.Label12.Size = New System.Drawing.Size(27, 13)
        Me.Label12.TabIndex = 50
        Me.Label12.Text = "SpA"
        '
        'Label13
        '
        Me.Label13.AutoSize = True
        Me.Label13.BackColor = System.Drawing.Color.Transparent
        Me.Label13.Location = New System.Drawing.Point(59, 42)
        Me.Label13.Name = "Label13"
        Me.Label13.Size = New System.Drawing.Size(20, 13)
        Me.Label13.TabIndex = 49
        Me.Label13.Text = "Dif"
        '
        'Label14
        '
        Me.Label14.AutoSize = True
        Me.Label14.BackColor = System.Drawing.Color.Transparent
        Me.Label14.Location = New System.Drawing.Point(33, 42)
        Me.Label14.Name = "Label14"
        Me.Label14.Size = New System.Drawing.Size(23, 13)
        Me.Label14.TabIndex = 48
        Me.Label14.Text = "Atk"
        '
        'Label15
        '
        Me.Label15.AutoSize = True
        Me.Label15.BackColor = System.Drawing.Color.Transparent
        Me.Label15.Location = New System.Drawing.Point(7, 42)
        Me.Label15.Name = "Label15"
        Me.Label15.Size = New System.Drawing.Size(22, 13)
        Me.Label15.TabIndex = 47
        Me.Label15.Text = "HP"
        '
        'IVs1
        '
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.None
        Me.BackColor = System.Drawing.Color.Tan
        Me.BackgroundImage = CType(resources.GetObject("$this.BackgroundImage"), System.Drawing.Image)
        Me.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None
        Me.ClientSize = New System.Drawing.Size(808, 504)
        Me.Controls.Add(Me.GroupBox3)
        Me.Controls.Add(Me.Label9)
        Me.Controls.Add(Me.Label8)
        Me.Controls.Add(Me.ComboBox2)
        Me.Controls.Add(Me.Label7)
        Me.Controls.Add(Me.Label6)
        Me.Controls.Add(Me.Label5)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.GroupBox2)
        Me.Controls.Add(Me.GroupBox1)
        Me.Controls.Add(Me.Back)
        Me.Controls.Add(Me.Button6)
        Me.Controls.Add(Me.Button5)
        Me.Controls.Add(Me.Button4)
        Me.Controls.Add(Me.liv)
        Me.Controls.Add(Me.ComboBox1)
        Me.Controls.Add(Me.Button3)
        Me.Cursor = System.Windows.Forms.Cursors.PanNW
        Me.DoubleBuffered = True
        Me.ForeColor = System.Drawing.SystemColors.ControlText
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None
        Me.Name = "IVs1"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Project G - Closed Beta"
        Me.TransparencyKey = System.Drawing.Color.Tan
        Me.GroupBox1.ResumeLayout(False)
        Me.GroupBox1.PerformLayout()
        Me.GroupBox2.ResumeLayout(False)
        Me.GroupBox2.PerformLayout()
        Me.GroupBox3.ResumeLayout(False)
        Me.GroupBox3.PerformLayout()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents Button3 As System.Windows.Forms.Button
    Friend WithEvents ComboBox1 As System.Windows.Forms.ComboBox
    Friend WithEvents Button4 As System.Windows.Forms.Button
    Friend WithEvents Button5 As System.Windows.Forms.Button
    Friend WithEvents Button6 As System.Windows.Forms.Button
    Friend WithEvents Back As System.Windows.Forms.Button
    Friend WithEvents GroupBox1 As System.Windows.Forms.GroupBox
    Friend WithEvents vel As System.Windows.Forms.TextBox
    Friend WithEvents atk As System.Windows.Forms.TextBox
    Friend WithEvents atksp As System.Windows.Forms.TextBox
    Friend WithEvents difsp As System.Windows.Forms.TextBox
    Friend WithEvents dif As System.Windows.Forms.TextBox
    Friend WithEvents hp As System.Windows.Forms.TextBox
    Friend WithEvents GroupBox2 As System.Windows.Forms.GroupBox
    Friend WithEvents vele As System.Windows.Forms.TextBox
    Friend WithEvents atke As System.Windows.Forms.TextBox
    Friend WithEvents atkspe As System.Windows.Forms.TextBox
    Friend WithEvents difspe As System.Windows.Forms.TextBox
    Friend WithEvents dife As System.Windows.Forms.TextBox
    Friend WithEvents hpe As System.Windows.Forms.TextBox
    Friend WithEvents liv As System.Windows.Forms.TextBox
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents Label2 As System.Windows.Forms.Label
    Friend WithEvents Label3 As System.Windows.Forms.Label
    Friend WithEvents Label4 As System.Windows.Forms.Label
    Friend WithEvents Label5 As System.Windows.Forms.Label
    Friend WithEvents Label6 As System.Windows.Forms.Label
    Friend WithEvents Label7 As System.Windows.Forms.Label
    Friend WithEvents ComboBox2 As System.Windows.Forms.ComboBox
    Friend WithEvents Label8 As System.Windows.Forms.Label
    Friend WithEvents Label9 As System.Windows.Forms.Label
    Friend WithEvents GroupBox3 As System.Windows.Forms.GroupBox
    Friend WithEvents Label10 As System.Windows.Forms.Label
    Friend WithEvents Label11 As System.Windows.Forms.Label
    Friend WithEvents Label12 As System.Windows.Forms.Label
    Friend WithEvents Label13 As System.Windows.Forms.Label
    Friend WithEvents Label14 As System.Windows.Forms.Label
    Friend WithEvents Label15 As System.Windows.Forms.Label
    Friend WithEvents TextBox2 As System.Windows.Forms.TextBox
    Friend WithEvents TextBox3 As System.Windows.Forms.TextBox
    Friend WithEvents TextBox4 As System.Windows.Forms.TextBox
    Friend WithEvents TextBox5 As System.Windows.Forms.TextBox
    Friend WithEvents TextBox6 As System.Windows.Forms.TextBox
    Friend WithEvents TextBox7 As System.Windows.Forms.TextBox

End Class
