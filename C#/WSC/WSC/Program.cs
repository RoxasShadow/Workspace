using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.IO;
using System.Windows.Forms;
using WAPT;

namespace WSC {
    public partial class Program : Form {
        private Engine engine;
        private string version = "0.1b";

        /* Init */
        public Program() {
            InitializeComponent();
            Init();
        }

        private void Form1_Load(object sender, EventArgs e) {
            listBox1.MouseDoubleClick += new MouseEventHandler(listbox1_MouseDoubleClick);
            listBox2.MouseDoubleClick += new MouseEventHandler(listbox2_MouseDoubleClick);
            textBox1.TextChanged += new EventHandler(textbox1_TextChanged);
        }

        /* Find */
        private void textbox1_TextChanged(object sender, EventArgs e) {
            Program.Clear(listBox1);
            if(textBox1.Text == "")
                AddPackage(engine.Packages.ToArray(), listBox1);
            else
                AddPackage(engine.Find(textBox1.Text), listBox1);
        }

        /* Filter */
        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e) {
            Program.Clear(listBox2);
            AddPackage(engine.Find(comboBox1.SelectedItem.ToString()), listBox2);
        }

        /* On package click */
        private void listbox1_MouseDoubleClick(object sender, EventArgs e) {
            if(listBox1.SelectedItem != null)
              new PackageForm(engine, listBox1.SelectedItem.ToString()).Show();
        }
        private void listBox1_SelectedIndexChanged(object sender, EventArgs e) { }

        private void listbox2_MouseDoubleClick(object sender, EventArgs e) {
            if(listBox2.SelectedItem != null)
                new PackageForm(engine, listBox2.SelectedItem.ToString()).Show();
        }

        /* Repository */
        private void button3_Click(object sender, EventArgs e) {
            if(textBox2.Text.Trim() == "")
                MessageBox.Show("Repository URL field is empty.");
            else {
                engine.Clear();
                Init(textBox2.Text);
            }
        }

        /* Refresh */
        private void toolStripButton1_Click(object sender, EventArgs e) {
            if(textBox2.Text == "")
                Init();
            else
                Init(textBox2.Text);
        }

        /* Clear cache */
        private void toolStripButton4_Click(object sender, EventArgs e) {
            if(engine.Clear())
                MessageBox.Show("Cache cleaned.");
            else
                MessageBox.Show("An error has occurred during the cache cleaning.");
        }

        /* Check updates */
        private void toolStripButton2_Click(object sender, EventArgs e) {

        }

        /* About */
        private void toolStripButton3_Click(object sender, EventArgs e) {
            MessageBox.Show("Windows Advanced Packaging Tool " + version + "\nGiovanni Capuano <http://www.giovannicapuano.net>");
        }

        private static void Clear(params ListBox[] listbox) {
            foreach(ListBox lb in listbox)
                lb.Items.Clear();
        }

        private static void Clear(params ComboBox[] combobox) {
            foreach(ComboBox cb in combobox)
                cb.Items.Clear();
        }

        private void reset() {
            Program.Clear(listBox1, listBox2);
            Program.Clear(comboBox1);
            AddPackage(engine.Packages.ToArray(), listBox1);
            AddPackage(engine.Packages.ToArray(), listBox2);
            AddFilter(engine.GetCategoryList(), comboBox1);
        }

        private void Init() {
            try {
                engine = new Engine();
                reset();
                textBox3.Text = engine.Packages.Count + " packages";
            }
            catch(FileNotFoundException) {
                MessageBox.Show("Repository manifest not found.");
                Environment.Exit(1);
            }
        }

        private void Init(string url) {
            try {
                engine = new Engine(url);
                reset();
                textBox3.Text = engine.Packages.Count + " packages";
            }
            catch(FileNotFoundException) {
                MessageBox.Show("Repository malformed or does not exists.");
            }
            catch(ArgumentException) {
                MessageBox.Show("Repository malformed or does not exists.");
            }
        }

        private void AddPackage(Package[] packages, ListBox listbox) {
            foreach(Package p in packages)
                listbox.Items.Add(p.Name);
        }

        private void AddFilter(string[] filters, ComboBox combobox) {
            for(int i=0, count=filters.Length; i<count; ++i)
                combobox.Items.Add(filters[i]);
        }

        [STAThread]
        public static void Main() {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Program());
        }
    }
}
