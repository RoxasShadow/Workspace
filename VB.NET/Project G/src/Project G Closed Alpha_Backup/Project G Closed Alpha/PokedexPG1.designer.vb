<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class PokedexPG1
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
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(PokedexPG1))
        Me.Build = New System.Windows.Forms.Button
        Me.ComboBox1 = New System.Windows.Forms.ComboBox
        Me.Button4 = New System.Windows.Forms.Button
        Me.Button5 = New System.Windows.Forms.Button
        Me.Button6 = New System.Windows.Forms.Button
        Me.PictureBox3 = New System.Windows.Forms.PictureBox
        Me.GroupBox2 = New System.Windows.Forms.GroupBox
        Me.Label48 = New System.Windows.Forms.Label
        Me.Label49 = New System.Windows.Forms.Label
        Me.Label50 = New System.Windows.Forms.Label
        Me.Label51 = New System.Windows.Forms.Label
        Me.Label52 = New System.Windows.Forms.Label
        Me.Label53 = New System.Windows.Forms.Label
        Me.Label78 = New System.Windows.Forms.Label
        Me.Label45 = New System.Windows.Forms.Label
        Me.Label46 = New System.Windows.Forms.Label
        Me.Label47 = New System.Windows.Forms.Label
        Me.Label54 = New System.Windows.Forms.Label
        Me.Label55 = New System.Windows.Forms.Label
        Me.Label56 = New System.Windows.Forms.Label
        Me.Label57 = New System.Windows.Forms.Label
        Me.Label58 = New System.Windows.Forms.Label
        Me.Label59 = New System.Windows.Forms.Label
        Me.Label60 = New System.Windows.Forms.Label
        Me.Label61 = New System.Windows.Forms.Label
        Me.Label62 = New System.Windows.Forms.Label
        Me.Label63 = New System.Windows.Forms.Label
        Me.Label64 = New System.Windows.Forms.Label
        Me.Label65 = New System.Windows.Forms.Label
        Me.Label66 = New System.Windows.Forms.Label
        Me.Label67 = New System.Windows.Forms.Label
        Me.Label68 = New System.Windows.Forms.Label
        Me.Label69 = New System.Windows.Forms.Label
        Me.Label70 = New System.Windows.Forms.Label
        Me.Label71 = New System.Windows.Forms.Label
        Me.Label72 = New System.Windows.Forms.Label
        Me.Label73 = New System.Windows.Forms.Label
        Me.Label74 = New System.Windows.Forms.Label
        Me.Label75 = New System.Windows.Forms.Label
        Me.Label76 = New System.Windows.Forms.Label
        Me.Label77 = New System.Windows.Forms.Label
        Me.Label79 = New System.Windows.Forms.Label
        Me.Label80 = New System.Windows.Forms.Label
        Me.Label81 = New System.Windows.Forms.Label
        Me.Label82 = New System.Windows.Forms.Label
        Me.Label83 = New System.Windows.Forms.Label
        Me.Label84 = New System.Windows.Forms.Label
        Me.Label85 = New System.Windows.Forms.Label
        Me.Label86 = New System.Windows.Forms.Label
        Me.Label87 = New System.Windows.Forms.Label
        Me.Label88 = New System.Windows.Forms.Label
        Me.Back = New System.Windows.Forms.Button
        Me.Button1 = New System.Windows.Forms.Button
        CType(Me.PictureBox3, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.GroupBox2.SuspendLayout()
        Me.SuspendLayout()
        '
        'Build
        '
        Me.Build.BackColor = System.Drawing.Color.Red
        Me.Build.BackgroundImage = CType(resources.GetObject("Build.BackgroundImage"), System.Drawing.Image)
        Me.Build.FlatAppearance.BorderSize = 0
        Me.Build.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.Build.Location = New System.Drawing.Point(449, 41)
        Me.Build.Name = "Build"
        Me.Build.Size = New System.Drawing.Size(48, 48)
        Me.Build.TabIndex = 1
        Me.Build.UseVisualStyleBackColor = False
        '
        'ComboBox1
        '
        Me.ComboBox1.BackColor = System.Drawing.Color.Silver
        Me.ComboBox1.DropDownHeight = 100
        Me.ComboBox1.DropDownStyle = System.Windows.Forms.ComboBoxStyle.Simple
        Me.ComboBox1.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.ComboBox1.FormattingEnabled = True
        Me.ComboBox1.IntegralHeight = False
        Me.ComboBox1.Items.AddRange(New Object() {"Abomasnow", "Abra", "Absol", "Aerodactyl", "Aggron", "Aipom", "Alakazam", "Altaria", "Ambipom", "Ampharos", "Anorith", "Arbok", "Arcanine", "Arceus", "Ariados", "Armaldo", "Aron", "Articuno", "Azelf", "Azumarill", "Azurill", "Bagon", "Baltoy", "Banette", "Barboach", "Bastiodon", "Bayleef", "Beautifly", "Beedrill", "Beldum", "Bellossom", "Bellsprout", "Bibarel", "Bidoof", "Blastoise", "Blaziken", "Blissey", "Bonsly", "Breloom", "Bronzong", "Bronzor", "Budew", "Buizel", "Bulbasaur", "Buneary", "Burmy", "Butterfree", "Cacnea", "Cacturne", "Camerupt", "Carnivine", "Carvanha", "Cascoon", "Castform", "Caterpie", "Celebi", "Chansey", "Charizard", "Charmander", "Charmeleon", "Chatot", "Cherrim", "Cherubi", "Chikorita", "Chimchar", "Chimecho", "Chinchou", "Chingling", "Clamperl", "Claydol", "Clefable", "Clefairy", "Cleffa", "Cloyster", "Combee", "Combusken", "Corphish", "Corsola", "Cradily", "Cranidos", "Crawdaunt", "Cresselia", "Croagunk", "Crobat", "Croconaw", "Cubone", "Cyndaquil", "Darkrai", "Delcatty", "Delibird", "Deoxys", "Deoxys-E", "Deoxys-F", "Deoxys-L", "Dewgong", "Dialga", "Diglett", "Ditto", "Dodrio", "Doduo", "Donphan", "Dragonair", "Dragonite", "Drapion", "Dratini", "Drifblim", "Drifloon", "Drowzee", "Dugtrio", "Dunsparce", "Dusclops", "Dusknoir", "Duskull", "Dustox", "Eevee", "Ekans", "Electabuzz", "Electivire", "Electrike", "Electrode", "Elekid", "Empoleon", "Entei", "Espeon", "Exeggcute", "Exeggutor", "Exploud", "Farfetch'd", "Fearow", "Feebas", "Feraligatr", "Finneon", "Flaaffy", "Flareon", "Floatzel", "Flygon", "Forretress", "Froslass", "Furret", "Gabite", "Gallade", "Garchomp", "Gastrodon", "Gengar", "Geodude", "Gible", "Girafarig", "Giratina", "Glaceon", "Glalie", "Glameow", "Gligar", "Gliscor", "Gloom", "Golbat", "Goldeen", "Golduck", "Golem", "Gorebyss", "Granbull", "Graveler", "Grimer", "Grotle", "Groudon", "Grovyle", "Growlithe", "Grumpig", "Gulpin", "Gyarados", "Happiny", "Hariyama", "Haunter", "Heatran", "Heracross", "Hippopotas", "Hippowdon", "Hitmonchan", "Hitmonlee", "Hitmontop", "Ho-oh", "Honchkrow", "Hoothoot", "Hoppip", "Horsea", "Houndoom", "Houndour", "Huntail", "Hypno", "Igglybuff", "Illumise", "Infernape", "Ivysaur", "Jigglypuff", "Jirachi", "Jolteon", "Jumpluff", "Jynx", "Kabuto", "Kabutops", "Kadabra", "Kakuna", "Kangaskhan", "Kecleon", "Kingdra", "Kingler", "Kirlia", "Koffing", "Krabby", "Kricketot", "Kricketune", "Kyogre", "Lairon", "Lanturn", "Lapras", "Larvitar", "Latias", "Latios", "Leafeon", "Ledian", "Ledyba", "Lickilicky", "Lickitung", "Lileep", "Linoone", "Lombre", "Ledian", "Lopunny", "Lotad", "Lombre", "Lucario", "Ludicolo", "Lugia", "Lumineon", "Lunatone", "Luvdisc", "Luxio", "Luxray", "Machamp", "Machoke", "Machop", "Magby", "Magcargo", "Magikarp", "Magmar", "Magmortar", "Magnemite", "Magneton", "Magnezone", "Makuhita", "Mamoswine", "Manaphy", "Manectric", "Mankey", "Mantine", "Mantyke", "Mareep", "Marill", "Marowak", "Marshtomp", "Masquerain", "Mawile", "Medicham", "Meditite", "Meganium", "Meowth", "Mesprit", "Metagross", "Metang", "Metapod", "Mew", "Mewtwo", "Mightyena", "Milotic", "Miltank", "Mime Jr", "Minun", "Misdreavus", "Mismagius", "Moltres", "Monferno", "Mothim", "Mr Mime", "Mudkip", "Muk", "Munchlax", "Murkrow", "Natu", "Nidoking", "Nidoqueen", "Nidoran-M", "Nidorina", "Nidorino", "Nincada", "Ninetales", "Ninjask", "Noctowl", "Nosepass", "Numel", "Nuzleaf", "Octillery", "Oddish", "Omanyte", "Omastar", "Onix", "Pachirisu", "Palkia", "Paras", "Parasect", "Pelipper", "Persian", "Phanpy", "Phione", "Pichu", "Pidgeot", "Pidgeotto", "Pidgey", "Pikachu", "Piloswine", "Pineco", "Pinsir", "Piplup", "Plusle", "Politoed", "Poliwag", "Poliwhirl", "Poliwrath", "Ponyta", "Poochyena", "Porygon", "Porygon-Z", "Porygon2", "Primeape", "Prinplup", "Probopass", "Psyduck", "Pupitar", "Purugly", "Quagsire", "Quilava", "Qwilfish", "Raichu", "Raikou", "Ralts", "Rampardos", "Rapidash", "Raticate", "Rattata", "Rayquaza", "Regice", "Regigigas", "Regirock", "Registeel", "Relicanth", "Remoraid", "Rhydon", "Rhyhorn", "Rhyperior", "Riolu", "Roselia", "Roserade", "Rotom", "Sableye", "Salamence", "Sandshrew", "Sandslash", "Sceptile", "Scizor", "Scyther", "Seadra", "Seaking", "Sealeo", "Seedot", "Seel", "Sentret", "Seviper", "Sharpedo", "Shaymin", "Shedinja", "Shelgon", "Shellder", "Shellos", "Shieldon", "Shiftry", "Shinx", "Shroomish", "Shuckle", "Shuppet", "Silcoon", "Skarmory", "Skiploom", "Skitty", "Skorupi", "Skuntank", "Slaking", "Slakoth", "Slowbro", "Slowking", "Slowpoke", "Slugma", "Smeargle", "Smoochum", "Sneasel", "Snorlax", "Snorunt", "Snover", "Snubbull", "Solrock", "Spearow", "Spheal", "Spinarak", "Spinda", "Spiritomb", "Spoink", "Squirtle", "Stantler", "Staraptor", "Staravia", "Starly", "Starmie", "Staryu", "Steelix", "Stunky", "Sudowoodo", "Suicune", "Sunflora", "Sunkern", "Surskit", "Swablu", "Swalot", "Swampert", "Swellow", "Swinub", "Taillow", "Tangela", "Tangrowth", "Tauros", "Teddiursa", "Tentacool", "Tentacruel", "Togekiss", "Togetic", "Torchic", "Torkoal", "Torterra", "Totodile", "Toxicroak", "Trapinch", "Treecko", "Tropius", "Turtwig", "Typhlosion", "Tyranitar", "Tyrogue", "Umbreon", "Unown", "Ursaring", "Uxie", "Vaporeon", "Venomoth", "Venonat", "Venusaur", "Vespiquen", "Vibrava", "Victreebel", "Vigoroth", "Vileplume", "Volbeat", "Voltorb", "Vulpix", "Wailmer", "Wailord", "Walrein", "Wartortle", "Weavile", "Weedle", "Weepinbell", "Weezing", "Whiscash", "Whismur", "Wigglytuff", "Wingull", "Wobbuffet", "Wooper", "Wormadam", "Wurmple", "Wynaut", "Xatu", "Yanma", "Yanmega", "Zangoose", "Zapdos", "Zigzagoon", "Zubat"})
        Me.ComboBox1.Location = New System.Drawing.Point(323, 305)
        Me.ComboBox1.Name = "ComboBox1"
        Me.ComboBox1.Size = New System.Drawing.Size(97, 137)
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
        'PictureBox3
        '
        Me.PictureBox3.BackColor = System.Drawing.Color.Transparent
        Me.PictureBox3.Location = New System.Drawing.Point(59, 24)
        Me.PictureBox3.Name = "PictureBox3"
        Me.PictureBox3.Size = New System.Drawing.Size(361, 245)
        Me.PictureBox3.TabIndex = 12
        Me.PictureBox3.TabStop = False
        Me.PictureBox3.Visible = False
        '
        'GroupBox2
        '
        Me.GroupBox2.BackColor = System.Drawing.Color.Transparent
        Me.GroupBox2.Controls.Add(Me.Label48)
        Me.GroupBox2.Controls.Add(Me.Label49)
        Me.GroupBox2.Controls.Add(Me.Label50)
        Me.GroupBox2.Controls.Add(Me.Label51)
        Me.GroupBox2.Controls.Add(Me.Label52)
        Me.GroupBox2.Controls.Add(Me.Label53)
        Me.GroupBox2.Controls.Add(Me.Label78)
        Me.GroupBox2.Controls.Add(Me.Label45)
        Me.GroupBox2.Controls.Add(Me.Label46)
        Me.GroupBox2.Controls.Add(Me.Label47)
        Me.GroupBox2.Controls.Add(Me.Label54)
        Me.GroupBox2.Controls.Add(Me.Label55)
        Me.GroupBox2.Controls.Add(Me.Label56)
        Me.GroupBox2.Controls.Add(Me.Label57)
        Me.GroupBox2.Controls.Add(Me.Label58)
        Me.GroupBox2.Controls.Add(Me.Label59)
        Me.GroupBox2.Controls.Add(Me.Label60)
        Me.GroupBox2.Controls.Add(Me.Label61)
        Me.GroupBox2.Controls.Add(Me.Label62)
        Me.GroupBox2.Controls.Add(Me.Label63)
        Me.GroupBox2.Controls.Add(Me.Label64)
        Me.GroupBox2.Controls.Add(Me.Label65)
        Me.GroupBox2.Controls.Add(Me.Label66)
        Me.GroupBox2.Controls.Add(Me.Label67)
        Me.GroupBox2.Controls.Add(Me.Label68)
        Me.GroupBox2.Controls.Add(Me.Label69)
        Me.GroupBox2.Controls.Add(Me.Label70)
        Me.GroupBox2.Controls.Add(Me.Label71)
        Me.GroupBox2.Controls.Add(Me.Label72)
        Me.GroupBox2.Controls.Add(Me.Label73)
        Me.GroupBox2.Controls.Add(Me.Label74)
        Me.GroupBox2.Controls.Add(Me.Label75)
        Me.GroupBox2.Controls.Add(Me.Label76)
        Me.GroupBox2.Controls.Add(Me.Label77)
        Me.GroupBox2.Controls.Add(Me.Label79)
        Me.GroupBox2.Controls.Add(Me.Label80)
        Me.GroupBox2.Controls.Add(Me.Label81)
        Me.GroupBox2.Controls.Add(Me.Label82)
        Me.GroupBox2.Controls.Add(Me.Label83)
        Me.GroupBox2.Controls.Add(Me.Label84)
        Me.GroupBox2.Controls.Add(Me.Label85)
        Me.GroupBox2.Controls.Add(Me.Label86)
        Me.GroupBox2.Controls.Add(Me.Label87)
        Me.GroupBox2.Controls.Add(Me.Label88)
        Me.GroupBox2.Location = New System.Drawing.Point(59, 305)
        Me.GroupBox2.Name = "GroupBox2"
        Me.GroupBox2.Size = New System.Drawing.Size(258, 137)
        Me.GroupBox2.TabIndex = 17
        Me.GroupBox2.TabStop = False
        Me.GroupBox2.Text = "Statistiche"
        '
        'Label48
        '
        Me.Label48.AutoSize = True
        Me.Label48.BackColor = System.Drawing.Color.Transparent
        Me.Label48.ForeColor = System.Drawing.Color.Red
        Me.Label48.Location = New System.Drawing.Point(85, 101)
        Me.Label48.Name = "Label48"
        Me.Label48.Size = New System.Drawing.Size(10, 13)
        Me.Label48.TabIndex = 64
        Me.Label48.Text = "-"
        '
        'Label49
        '
        Me.Label49.AutoSize = True
        Me.Label49.BackColor = System.Drawing.Color.Transparent
        Me.Label49.ForeColor = System.Drawing.Color.Red
        Me.Label49.Location = New System.Drawing.Point(85, 88)
        Me.Label49.Name = "Label49"
        Me.Label49.Size = New System.Drawing.Size(10, 13)
        Me.Label49.TabIndex = 63
        Me.Label49.Text = "-"
        '
        'Label50
        '
        Me.Label50.AutoSize = True
        Me.Label50.BackColor = System.Drawing.Color.Transparent
        Me.Label50.ForeColor = System.Drawing.Color.Red
        Me.Label50.Location = New System.Drawing.Point(85, 75)
        Me.Label50.Name = "Label50"
        Me.Label50.Size = New System.Drawing.Size(10, 13)
        Me.Label50.TabIndex = 62
        Me.Label50.Text = "-"
        '
        'Label51
        '
        Me.Label51.AutoSize = True
        Me.Label51.BackColor = System.Drawing.Color.Transparent
        Me.Label51.ForeColor = System.Drawing.Color.Red
        Me.Label51.Location = New System.Drawing.Point(85, 62)
        Me.Label51.Name = "Label51"
        Me.Label51.Size = New System.Drawing.Size(10, 13)
        Me.Label51.TabIndex = 61
        Me.Label51.Text = "-"
        '
        'Label52
        '
        Me.Label52.AutoSize = True
        Me.Label52.BackColor = System.Drawing.Color.Transparent
        Me.Label52.ForeColor = System.Drawing.Color.Red
        Me.Label52.Location = New System.Drawing.Point(85, 49)
        Me.Label52.Name = "Label52"
        Me.Label52.Size = New System.Drawing.Size(10, 13)
        Me.Label52.TabIndex = 60
        Me.Label52.Text = "-"
        '
        'Label53
        '
        Me.Label53.AutoSize = True
        Me.Label53.BackColor = System.Drawing.Color.Transparent
        Me.Label53.ForeColor = System.Drawing.Color.Red
        Me.Label53.Location = New System.Drawing.Point(85, 36)
        Me.Label53.Name = "Label53"
        Me.Label53.Size = New System.Drawing.Size(10, 13)
        Me.Label53.TabIndex = 59
        Me.Label53.Text = "-"
        '
        'Label78
        '
        Me.Label78.AutoSize = True
        Me.Label78.BackColor = System.Drawing.Color.Transparent
        Me.Label78.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label78.Location = New System.Drawing.Point(81, 16)
        Me.Label78.Name = "Label78"
        Me.Label78.Size = New System.Drawing.Size(35, 13)
        Me.Label78.TabIndex = 58
        Me.Label78.Text = "Base"
        '
        'Label45
        '
        Me.Label45.AutoSize = True
        Me.Label45.Location = New System.Drawing.Point(184, 121)
        Me.Label45.Name = "Label45"
        Me.Label45.Size = New System.Drawing.Size(10, 13)
        Me.Label45.TabIndex = 57
        Me.Label45.Text = "-"
        '
        'Label46
        '
        Me.Label46.AutoSize = True
        Me.Label46.Location = New System.Drawing.Point(85, 121)
        Me.Label46.Name = "Label46"
        Me.Label46.Size = New System.Drawing.Size(10, 13)
        Me.Label46.TabIndex = 56
        Me.Label46.Text = "-"
        '
        'Label47
        '
        Me.Label47.AutoSize = True
        Me.Label47.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label47.Location = New System.Drawing.Point(4, 120)
        Me.Label47.Name = "Label47"
        Me.Label47.Size = New System.Drawing.Size(50, 13)
        Me.Label47.TabIndex = 55
        Me.Label47.Text = "Abilità: "
        '
        'Label54
        '
        Me.Label54.AutoSize = True
        Me.Label54.BackColor = System.Drawing.Color.Transparent
        Me.Label54.Location = New System.Drawing.Point(221, 101)
        Me.Label54.Name = "Label54"
        Me.Label54.Size = New System.Drawing.Size(10, 13)
        Me.Label54.TabIndex = 48
        Me.Label54.Text = "-"
        '
        'Label55
        '
        Me.Label55.AutoSize = True
        Me.Label55.BackColor = System.Drawing.Color.Transparent
        Me.Label55.Location = New System.Drawing.Point(221, 88)
        Me.Label55.Name = "Label55"
        Me.Label55.Size = New System.Drawing.Size(10, 13)
        Me.Label55.TabIndex = 47
        Me.Label55.Text = "-"
        '
        'Label56
        '
        Me.Label56.AutoSize = True
        Me.Label56.BackColor = System.Drawing.Color.Transparent
        Me.Label56.Location = New System.Drawing.Point(221, 75)
        Me.Label56.Name = "Label56"
        Me.Label56.Size = New System.Drawing.Size(10, 13)
        Me.Label56.TabIndex = 46
        Me.Label56.Text = "-"
        '
        'Label57
        '
        Me.Label57.AutoSize = True
        Me.Label57.BackColor = System.Drawing.Color.Transparent
        Me.Label57.Location = New System.Drawing.Point(221, 62)
        Me.Label57.Name = "Label57"
        Me.Label57.Size = New System.Drawing.Size(10, 13)
        Me.Label57.TabIndex = 45
        Me.Label57.Text = "-"
        '
        'Label58
        '
        Me.Label58.AutoSize = True
        Me.Label58.BackColor = System.Drawing.Color.Transparent
        Me.Label58.Location = New System.Drawing.Point(221, 49)
        Me.Label58.Name = "Label58"
        Me.Label58.Size = New System.Drawing.Size(10, 13)
        Me.Label58.TabIndex = 44
        Me.Label58.Text = "-"
        '
        'Label59
        '
        Me.Label59.AutoSize = True
        Me.Label59.BackColor = System.Drawing.Color.Transparent
        Me.Label59.Location = New System.Drawing.Point(221, 36)
        Me.Label59.Name = "Label59"
        Me.Label59.Size = New System.Drawing.Size(10, 13)
        Me.Label59.TabIndex = 43
        Me.Label59.Text = "-"
        '
        'Label60
        '
        Me.Label60.AutoSize = True
        Me.Label60.BackColor = System.Drawing.Color.Transparent
        Me.Label60.Location = New System.Drawing.Point(188, 101)
        Me.Label60.Name = "Label60"
        Me.Label60.Size = New System.Drawing.Size(10, 13)
        Me.Label60.TabIndex = 42
        Me.Label60.Text = "-"
        '
        'Label61
        '
        Me.Label61.AutoSize = True
        Me.Label61.BackColor = System.Drawing.Color.Transparent
        Me.Label61.Location = New System.Drawing.Point(188, 88)
        Me.Label61.Name = "Label61"
        Me.Label61.Size = New System.Drawing.Size(10, 13)
        Me.Label61.TabIndex = 41
        Me.Label61.Text = "-"
        '
        'Label62
        '
        Me.Label62.AutoSize = True
        Me.Label62.BackColor = System.Drawing.Color.Transparent
        Me.Label62.Location = New System.Drawing.Point(188, 75)
        Me.Label62.Name = "Label62"
        Me.Label62.Size = New System.Drawing.Size(10, 13)
        Me.Label62.TabIndex = 40
        Me.Label62.Text = "-"
        '
        'Label63
        '
        Me.Label63.AutoSize = True
        Me.Label63.BackColor = System.Drawing.Color.Transparent
        Me.Label63.Location = New System.Drawing.Point(188, 62)
        Me.Label63.Name = "Label63"
        Me.Label63.Size = New System.Drawing.Size(10, 13)
        Me.Label63.TabIndex = 39
        Me.Label63.Text = "-"
        '
        'Label64
        '
        Me.Label64.AutoSize = True
        Me.Label64.BackColor = System.Drawing.Color.Transparent
        Me.Label64.Location = New System.Drawing.Point(188, 49)
        Me.Label64.Name = "Label64"
        Me.Label64.Size = New System.Drawing.Size(10, 13)
        Me.Label64.TabIndex = 38
        Me.Label64.Text = "-"
        '
        'Label65
        '
        Me.Label65.AutoSize = True
        Me.Label65.BackColor = System.Drawing.Color.Transparent
        Me.Label65.Location = New System.Drawing.Point(188, 36)
        Me.Label65.Name = "Label65"
        Me.Label65.Size = New System.Drawing.Size(10, 13)
        Me.Label65.TabIndex = 37
        Me.Label65.Text = "-"
        '
        'Label66
        '
        Me.Label66.AutoSize = True
        Me.Label66.BackColor = System.Drawing.Color.Transparent
        Me.Label66.Location = New System.Drawing.Point(158, 101)
        Me.Label66.Name = "Label66"
        Me.Label66.Size = New System.Drawing.Size(10, 13)
        Me.Label66.TabIndex = 36
        Me.Label66.Text = "-"
        '
        'Label67
        '
        Me.Label67.AutoSize = True
        Me.Label67.BackColor = System.Drawing.Color.Transparent
        Me.Label67.Location = New System.Drawing.Point(158, 88)
        Me.Label67.Name = "Label67"
        Me.Label67.Size = New System.Drawing.Size(10, 13)
        Me.Label67.TabIndex = 35
        Me.Label67.Text = "-"
        '
        'Label68
        '
        Me.Label68.AutoSize = True
        Me.Label68.BackColor = System.Drawing.Color.Transparent
        Me.Label68.Location = New System.Drawing.Point(158, 75)
        Me.Label68.Name = "Label68"
        Me.Label68.Size = New System.Drawing.Size(10, 13)
        Me.Label68.TabIndex = 34
        Me.Label68.Text = "-"
        '
        'Label69
        '
        Me.Label69.AutoSize = True
        Me.Label69.BackColor = System.Drawing.Color.Transparent
        Me.Label69.Location = New System.Drawing.Point(158, 62)
        Me.Label69.Name = "Label69"
        Me.Label69.Size = New System.Drawing.Size(10, 13)
        Me.Label69.TabIndex = 33
        Me.Label69.Text = "-"
        '
        'Label70
        '
        Me.Label70.AutoSize = True
        Me.Label70.BackColor = System.Drawing.Color.Transparent
        Me.Label70.Location = New System.Drawing.Point(158, 49)
        Me.Label70.Name = "Label70"
        Me.Label70.Size = New System.Drawing.Size(10, 13)
        Me.Label70.TabIndex = 32
        Me.Label70.Text = "-"
        '
        'Label71
        '
        Me.Label71.AutoSize = True
        Me.Label71.BackColor = System.Drawing.Color.Transparent
        Me.Label71.Location = New System.Drawing.Point(158, 36)
        Me.Label71.Name = "Label71"
        Me.Label71.Size = New System.Drawing.Size(10, 13)
        Me.Label71.TabIndex = 31
        Me.Label71.Text = "-"
        '
        'Label72
        '
        Me.Label72.AutoSize = True
        Me.Label72.BackColor = System.Drawing.Color.Transparent
        Me.Label72.Location = New System.Drawing.Point(122, 101)
        Me.Label72.Name = "Label72"
        Me.Label72.Size = New System.Drawing.Size(10, 13)
        Me.Label72.TabIndex = 30
        Me.Label72.Text = "-"
        '
        'Label73
        '
        Me.Label73.AutoSize = True
        Me.Label73.BackColor = System.Drawing.Color.Transparent
        Me.Label73.Location = New System.Drawing.Point(122, 88)
        Me.Label73.Name = "Label73"
        Me.Label73.Size = New System.Drawing.Size(10, 13)
        Me.Label73.TabIndex = 29
        Me.Label73.Text = "-"
        '
        'Label74
        '
        Me.Label74.AutoSize = True
        Me.Label74.BackColor = System.Drawing.Color.Transparent
        Me.Label74.Location = New System.Drawing.Point(122, 75)
        Me.Label74.Name = "Label74"
        Me.Label74.Size = New System.Drawing.Size(10, 13)
        Me.Label74.TabIndex = 28
        Me.Label74.Text = "-"
        '
        'Label75
        '
        Me.Label75.AutoSize = True
        Me.Label75.BackColor = System.Drawing.Color.Transparent
        Me.Label75.Location = New System.Drawing.Point(122, 62)
        Me.Label75.Name = "Label75"
        Me.Label75.Size = New System.Drawing.Size(10, 13)
        Me.Label75.TabIndex = 27
        Me.Label75.Text = "-"
        '
        'Label76
        '
        Me.Label76.AutoSize = True
        Me.Label76.BackColor = System.Drawing.Color.Transparent
        Me.Label76.Location = New System.Drawing.Point(122, 49)
        Me.Label76.Name = "Label76"
        Me.Label76.Size = New System.Drawing.Size(10, 13)
        Me.Label76.TabIndex = 26
        Me.Label76.Text = "-"
        '
        'Label77
        '
        Me.Label77.AutoSize = True
        Me.Label77.BackColor = System.Drawing.Color.Transparent
        Me.Label77.Location = New System.Drawing.Point(122, 36)
        Me.Label77.Name = "Label77"
        Me.Label77.Size = New System.Drawing.Size(10, 13)
        Me.Label77.TabIndex = 25
        Me.Label77.Text = "-"
        '
        'Label79
        '
        Me.Label79.AutoSize = True
        Me.Label79.BackColor = System.Drawing.Color.Transparent
        Me.Label79.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label79.Location = New System.Drawing.Point(217, 16)
        Me.Label79.Name = "Label79"
        Me.Label79.Size = New System.Drawing.Size(41, 13)
        Me.Label79.TabIndex = 23
        Me.Label79.Text = "Max +"
        '
        'Label80
        '
        Me.Label80.AutoSize = True
        Me.Label80.BackColor = System.Drawing.Color.Transparent
        Me.Label80.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label80.Location = New System.Drawing.Point(184, 16)
        Me.Label80.Name = "Label80"
        Me.Label80.Size = New System.Drawing.Size(30, 13)
        Me.Label80.TabIndex = 22
        Me.Label80.Text = "Max"
        '
        'Label81
        '
        Me.Label81.AutoSize = True
        Me.Label81.BackColor = System.Drawing.Color.Transparent
        Me.Label81.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label81.Location = New System.Drawing.Point(154, 16)
        Me.Label81.Name = "Label81"
        Me.Label81.Size = New System.Drawing.Size(27, 13)
        Me.Label81.TabIndex = 21
        Me.Label81.Text = "Min"
        '
        'Label82
        '
        Me.Label82.AutoSize = True
        Me.Label82.BackColor = System.Drawing.Color.Transparent
        Me.Label82.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label82.Location = New System.Drawing.Point(118, 16)
        Me.Label82.Name = "Label82"
        Me.Label82.Size = New System.Drawing.Size(35, 13)
        Me.Label82.TabIndex = 20
        Me.Label82.Text = "Min -"
        '
        'Label83
        '
        Me.Label83.AutoSize = True
        Me.Label83.BackColor = System.Drawing.Color.Transparent
        Me.Label83.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label83.Location = New System.Drawing.Point(4, 100)
        Me.Label83.Name = "Label83"
        Me.Label83.Size = New System.Drawing.Size(53, 13)
        Me.Label83.TabIndex = 19
        Me.Label83.Text = "Velocità"
        '
        'Label84
        '
        Me.Label84.AutoSize = True
        Me.Label84.BackColor = System.Drawing.Color.Transparent
        Me.Label84.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label84.Location = New System.Drawing.Point(4, 87)
        Me.Label84.Name = "Label84"
        Me.Label84.Size = New System.Drawing.Size(42, 13)
        Me.Label84.TabIndex = 18
        Me.Label84.Text = "Dif Sp"
        '
        'Label85
        '
        Me.Label85.AutoSize = True
        Me.Label85.BackColor = System.Drawing.Color.Transparent
        Me.Label85.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label85.Location = New System.Drawing.Point(4, 74)
        Me.Label85.Name = "Label85"
        Me.Label85.Size = New System.Drawing.Size(45, 13)
        Me.Label85.TabIndex = 17
        Me.Label85.Text = "Atk Sp"
        '
        'Label86
        '
        Me.Label86.AutoSize = True
        Me.Label86.BackColor = System.Drawing.Color.Transparent
        Me.Label86.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label86.Location = New System.Drawing.Point(4, 61)
        Me.Label86.Name = "Label86"
        Me.Label86.Size = New System.Drawing.Size(43, 13)
        Me.Label86.TabIndex = 16
        Me.Label86.Text = "Difesa"
        '
        'Label87
        '
        Me.Label87.AutoSize = True
        Me.Label87.BackColor = System.Drawing.Color.Transparent
        Me.Label87.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label87.Location = New System.Drawing.Point(4, 48)
        Me.Label87.Name = "Label87"
        Me.Label87.Size = New System.Drawing.Size(51, 13)
        Me.Label87.TabIndex = 15
        Me.Label87.Text = "Attacco"
        '
        'Label88
        '
        Me.Label88.AutoSize = True
        Me.Label88.BackColor = System.Drawing.Color.Transparent
        Me.Label88.Font = New System.Drawing.Font("Microsoft Sans Serif", 8.25!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label88.Location = New System.Drawing.Point(4, 35)
        Me.Label88.Name = "Label88"
        Me.Label88.Size = New System.Drawing.Size(24, 13)
        Me.Label88.TabIndex = 14
        Me.Label88.Text = "HP"
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
        'Button1
        '
        Me.Button1.BackColor = System.Drawing.Color.Red
        Me.Button1.BackgroundImage = CType(resources.GetObject("Button1.BackgroundImage"), System.Drawing.Image)
        Me.Button1.Enabled = False
        Me.Button1.FlatAppearance.BorderSize = 0
        Me.Button1.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.Button1.Location = New System.Drawing.Point(449, 41)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(48, 48)
        Me.Button1.TabIndex = 26
        Me.Button1.UseVisualStyleBackColor = False
        Me.Button1.Visible = False
        '
        'PokedexPG1
        '
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.None
        Me.BackColor = System.Drawing.Color.Tan
        Me.BackgroundImage = CType(resources.GetObject("$this.BackgroundImage"), System.Drawing.Image)
        Me.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None
        Me.ClientSize = New System.Drawing.Size(808, 504)
        Me.Controls.Add(Me.GroupBox2)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.Back)
        Me.Controls.Add(Me.PictureBox3)
        Me.Controls.Add(Me.Button6)
        Me.Controls.Add(Me.Button5)
        Me.Controls.Add(Me.Button4)
        Me.Controls.Add(Me.ComboBox1)
        Me.Controls.Add(Me.Build)
        Me.Cursor = System.Windows.Forms.Cursors.PanNW
        Me.DoubleBuffered = True
        Me.ForeColor = System.Drawing.SystemColors.ControlText
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None
        Me.Name = "PokedexPG1"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Project G - Closed Beta"
        Me.TransparencyKey = System.Drawing.Color.Tan
        CType(Me.PictureBox3, System.ComponentModel.ISupportInitialize).EndInit()
        Me.GroupBox2.ResumeLayout(False)
        Me.GroupBox2.PerformLayout()
        Me.ResumeLayout(False)

    End Sub
    Friend WithEvents Build As System.Windows.Forms.Button
    Friend WithEvents ComboBox1 As System.Windows.Forms.ComboBox
    Friend WithEvents Button4 As System.Windows.Forms.Button
    Friend WithEvents Button5 As System.Windows.Forms.Button
    Friend WithEvents Button6 As System.Windows.Forms.Button
    Friend WithEvents PictureBox3 As System.Windows.Forms.PictureBox
    Friend WithEvents GroupBox2 As System.Windows.Forms.GroupBox
    Friend WithEvents Label45 As System.Windows.Forms.Label
    Friend WithEvents Label46 As System.Windows.Forms.Label
    Friend WithEvents Label47 As System.Windows.Forms.Label
    Friend WithEvents Label54 As System.Windows.Forms.Label
    Friend WithEvents Label55 As System.Windows.Forms.Label
    Friend WithEvents Label56 As System.Windows.Forms.Label
    Friend WithEvents Label57 As System.Windows.Forms.Label
    Friend WithEvents Label58 As System.Windows.Forms.Label
    Friend WithEvents Label59 As System.Windows.Forms.Label
    Friend WithEvents Label60 As System.Windows.Forms.Label
    Friend WithEvents Label61 As System.Windows.Forms.Label
    Friend WithEvents Label62 As System.Windows.Forms.Label
    Friend WithEvents Label63 As System.Windows.Forms.Label
    Friend WithEvents Label64 As System.Windows.Forms.Label
    Friend WithEvents Label65 As System.Windows.Forms.Label
    Friend WithEvents Label66 As System.Windows.Forms.Label
    Friend WithEvents Label67 As System.Windows.Forms.Label
    Friend WithEvents Label68 As System.Windows.Forms.Label
    Friend WithEvents Label69 As System.Windows.Forms.Label
    Friend WithEvents Label70 As System.Windows.Forms.Label
    Friend WithEvents Label71 As System.Windows.Forms.Label
    Friend WithEvents Label72 As System.Windows.Forms.Label
    Friend WithEvents Label73 As System.Windows.Forms.Label
    Friend WithEvents Label74 As System.Windows.Forms.Label
    Friend WithEvents Label75 As System.Windows.Forms.Label
    Friend WithEvents Label76 As System.Windows.Forms.Label
    Friend WithEvents Label77 As System.Windows.Forms.Label
    Friend WithEvents Label79 As System.Windows.Forms.Label
    Friend WithEvents Label80 As System.Windows.Forms.Label
    Friend WithEvents Label81 As System.Windows.Forms.Label
    Friend WithEvents Label82 As System.Windows.Forms.Label
    Friend WithEvents Label83 As System.Windows.Forms.Label
    Friend WithEvents Label84 As System.Windows.Forms.Label
    Friend WithEvents Label85 As System.Windows.Forms.Label
    Friend WithEvents Label86 As System.Windows.Forms.Label
    Friend WithEvents Label87 As System.Windows.Forms.Label
    Friend WithEvents Label88 As System.Windows.Forms.Label
    Friend WithEvents Back As System.Windows.Forms.Button
    Friend WithEvents Label48 As System.Windows.Forms.Label
    Friend WithEvents Label49 As System.Windows.Forms.Label
    Friend WithEvents Label50 As System.Windows.Forms.Label
    Friend WithEvents Label51 As System.Windows.Forms.Label
    Friend WithEvents Label52 As System.Windows.Forms.Label
    Friend WithEvents Label53 As System.Windows.Forms.Label
    Friend WithEvents Label78 As System.Windows.Forms.Label
    Friend WithEvents Button1 As System.Windows.Forms.Button

End Class
