using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using WAPT;

namespace WSC {
    public partial class PackageForm : Form {
        private Engine engine;
        private string package;
        private Package selectedPackage;
        private static string[] columns = { "Path", "Icon", "Name", "Version", "Category", "Description", "Weight" };
        private Engine.PackageStatus status;
        
        public PackageForm(Engine engine, string package) {
            InitializeComponent();
            this.engine = engine;
            this.package = package;
        }

        private void PackageForm_Load(object sender, EventArgs e) {
            if(!engine.IsPackage(package)) {
                MessageBox.Show("That's not a package.");
                Dispose();
            }
            selectedPackage = engine.GetPackage(package);
            status = engine.GetStatus(selectedPackage);
            switch(status) {
                case Engine.PackageStatus.NEWER:
                    button1.Text = "Upgrade";
                    break;
                case Engine.PackageStatus.NOT_INSTALLED:
                    button1.Text = "Install";
                    break;
                default: // INSTALLED, OLDER
                    button1.Text = "Remove";
                    break;
            }
            dataGridView1.AutoGenerateColumns = false;
            dataGridView1.CellDoubleClick += new DataGridViewCellEventHandler(dataGridView1_CellContentDoubleClick);
            PackageForm.MakeRow(dataGridView1, selectedPackage);
        }

        private void dataGridView1_CellContentDoubleClick(Object sender, DataGridViewCellEventArgs e) {
            MessageBox.Show(selectedPackage.ToArray()[e.ColumnIndex]);
        }

        private static void MakeRow(DataGridView grid, Object package) {
            for(int i = 0, count = PackageForm.columns.Length; i < count; ++i) {
                DataGridViewTextBoxColumn col = new DataGridViewTextBoxColumn();
                col.DataPropertyName = PackageForm.columns[i];
                col.HeaderText = PackageForm.columns[i];
                grid.Columns.Add(col);
            }
            List<Object> list = new List<Object>();
            list.Add(package);
            grid.DataSource = list;
        }

        private void button1_Click(object sender, EventArgs e) {
            string name = Utils.GetNameByURL(selectedPackage.Path);
            switch(status) {
                case Engine.PackageStatus.NEWER: // TO UPGRADE
                case Engine.PackageStatus.NOT_INSTALLED: // TO INSTALL
                    try {
                        new Loading(selectedPackage.Path, name).Show();
                    }
                    catch(Exception) {
                        MessageBox.Show("An error has occurred during the launching of the installing wizard.");
                    }
                    break;
                default: // TO REMOVE
                    if(Utils.remove(selectedPackage))
                        MessageBox.Show("Removing wizard launched.");
                    else
                        MessageBox.Show("An error has occurred during the launching of the removing wizard.");
                    break;
            }
        }
    }
}