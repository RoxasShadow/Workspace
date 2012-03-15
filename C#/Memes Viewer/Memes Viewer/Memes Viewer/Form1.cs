/*
*    Giovanni Capuano <webmaster@giovannicapuano.net>
*    This program is free software: you can redistribute it and/or modify
*    it under the terms of the GNU General Public License as published by
*    the Free Software Foundation, either version 3 of the License, or
*    (at your option) any later version.
*
*    This program is distributed in the hope that it will be useful,
*    but WITHOUT ANY WARRANTY; without even the implied warranty of
*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*    GNU General Public License for more details.
*
*    You should have received a copy of the GNU General Public License
*    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
using System;
using System.Collections.Generic;
using System.Windows.Forms;
using System.ComponentModel;
using System.Drawing;
using System.Drawing.Imaging;
using System.Net;
using System.IO;
using System.Text.RegularExpressions;

namespace Memes_Viewer {
    public partial class Form1 : Form {
        private List<Meme> memes;
        private int i, panelWidth, panelHeight;
        private string version, url, pattern;

        public Form1() {
            InitializeComponent();
            version = "0.9";
            panelWidth = panel1.Width;
            panelHeight = panel1.Height;
            memes = new List<Meme>();
            url = "http://9gag.com/random";
            pattern = @"<img.*?src=""(?<url>.*?)"".*?alt=""(?<alt>.*?)"".*?>";
            i = 0;
        }

        public Meme GetMeme() {
            return Utils.ParseJSON(Utils.GetJSON(url), pattern);
        }

        /* Next */
        private void toolStripButton4_Click(object sender, EventArgs e) {
            if(i < memes.Count-1) {
                ++i;
                SetMeme(memes[i]);
            }
            else {
                SetStatus("Searching for memes...");
                Cursor.Current = Cursors.WaitCursor;
                Meme meme = GetMeme();
                if(meme != null) {
                    memes.Add(GetMeme());
                    Cursor.Current = Cursors.Default;
                    SetStatus("Ready");
                    if(memes.Count > 1)
                        ++i;
                    SetMeme(memes[i]);
                }
                else
                    MessageBox.Show("Meme not found. Retry.");
            }
        }

        /* Back */
        private void toolStripButton3_Click(object sender, EventArgs e) {
            if(i > 0) {
                --i;
                SetMeme(memes[i]);
            }
            else
                MessageBox.Show("No memes available.");
        }

        /* Save */
        private void toolStripButton5_Click(object sender, EventArgs e) {
            if(pictureBox1.Image != null) {
                SaveFileDialog dialog = new SaveFileDialog();
                dialog.Title = "Save file as...";
                dialog.FileName = "Meme.jpg";
                dialog.Filter = "JPEG (*.jpg)|*.jpg|All files (*.*)|*.*";
                dialog.RestoreDirectory = true;

                if(dialog.ShowDialog() == DialogResult.OK) {
                    pictureBox1.Image.Save(dialog.FileName, ImageFormat.Jpeg);
                    SetStatus("Saved");
                }
            }
            else
                MessageBox.Show("No memes available.");
        }

        /* Link */
        private void toolStripButton7_Click(object sender, EventArgs e) {
            if(pictureBox1.Image != null) {
                Clipboard.SetDataObject(memes[i].url, true);
                SetStatus("Copied in the clipboard");
            }
            else
                MessageBox.Show("No memes available.");
            
        }

        /* Fullscreen */
        private void toolStripButton6_Click(object sender, EventArgs e) {
            if(WindowState != FormWindowState.Maximized) {
                MaximizeBox = false;
                MinimizeBox = false;
                TopMost = true;
                FormBorderStyle = FormBorderStyle.None;
                WindowState = FormWindowState.Maximized;
                toolStripButton6.Text = "Restore";

                pictureBox1.Width = panel1.Width = Width - 100;
                pictureBox1.Height = panel1.Height = Height - 100;
            }
            else {
                MaximizeBox = true;
                MinimizeBox = true;
                TopMost = false;
                FormBorderStyle = FormBorderStyle.Sizable;
                WindowState = FormWindowState.Normal;
                toolStripButton6.Text = "Fullscreen";

                pictureBox1.Width = panel1.Width = panelWidth;
                pictureBox1.Height = panel1.Height = panelHeight;
            }
            Refresh();
        }

        /* Facebook */
        private void toolStripButton1_Click(object sender, EventArgs e) {
            string token;
            if(!File.Exists("fb_token") || File.ReadAllText("fb_token").Length < 10) {
                System.Diagnostics.Process.Start(Facebook.url("179745182062082"));
                token = Microsoft.VisualBasic.Interaction.InputBox("Paste the current URL when you see \"Success\" in the just opened page.");
                if(token == "")
                    return;
                string[] url = Regex.Split(token, "#access_token=");
                token = url[1];
                url = Regex.Split(token, "&expires_in");
                token = url[0];
                StreamWriter writer = new StreamWriter("fb_token");
                writer.Write(token);
                writer.Close();
            }
            else
                token = File.ReadAllText("fb_token");
            if(pictureBox1.Image != null) {
                string text = Microsoft.VisualBasic.Interaction.InputBox("Comment for your Facebook post [optional]");
                new Facebook(token).post(memes[i].url, memes[i].description, text + " @ By Memes Viewer");
            }
            else
                MessageBox.Show("No memes available.");
        }

        /* About */
        private void toolStripButton2_Click(object sender, EventArgs e) {
            MessageBox.Show("Memes Viewer " + version + Environment.NewLine + "Developed by Giovanni Capuano <http://www.giovannicapuano.net>" + Environment.NewLine + "Memes by 9GAG <http://9gag.com>");
        }

        public void SetMeme(Meme meme) {
            if(meme.url == "")
                MessageBox.Show("No memes available.");
            else {
                pictureBox1.Image = ViewImage(meme.url);
                pictureBox1.Size = pictureBox1.Image.Size;
                textBox1.Text = Utils.HtmlDecode(meme.description);
                UpdateCounter();
                Refresh();
                panel1.Focus();
            }
        }

        public void SetStatus(string status) {
            toolStripLabel1.Text = status;
            Refresh();
        }

        public void UpdateCounter() {
            label2.Text = "" + (i+1) + '/' + memes.Count;
        }

        private Image ViewImage(string url) {
            progressBar1.Value = 0;

            WebRequest request = (HttpWebRequest)WebRequest.Create(url);
            WebResponse response = request.GetResponse();
            long size = response.ContentLength;
            byte[] buffer = new byte[4048];
            MemoryStream stream = new MemoryStream();
            using(Stream input = response.GetResponseStream()) {
                int bytesRead;
                while((bytesRead = input.Read(buffer, 0, buffer.Length)) > 0) {
                    stream.Write(buffer, 0, bytesRead);
                    int percent = Convert.ToInt32((stream.Length * 100) / size);
                    progressBar1.Value = percent;
                }
            }

            return Image.FromStream(stream);
        }
    }
}
