using System;
using System.Windows.Forms;
using System.Net;
using System.IO;
using System.Threading;
using System.Diagnostics;

namespace WSC {
    public partial class Loading : Form {
        private string url, name;
        private Thread thread;
        private Stream strResponse;
        private Stream strLocal;
        private HttpWebRequest webRequest;
        private HttpWebResponse webResponse;
        private static int PercentProgress;
        private delegate void UpdateProgessCallback(Int64 BytesRead, Int64 TotalBytes);

        public Loading(string url, string name) {
            InitializeComponent();
            this.url = url;
            this.name = name;
            Control.CheckForIllegalCrossThreadCalls = false; // A day I make all thread-safe, promise, ok? :3
            try {
                thread = new Thread(Download);
                thread.Start();
            }
            catch(Exception) {
                throw new FileNotFoundException();
            }
        }

        private void Loading_Load(object sender, EventArgs e) {
            label1.Text = "Download Starting";
        }

        private void Download() {
            if(!File.Exists(name))
                using(WebClient wcDownload = new WebClient()) {
                    try {
                        webRequest = (HttpWebRequest)WebRequest.Create(url);
                        webRequest.Credentials = CredentialCache.DefaultCredentials;
                        webResponse = (HttpWebResponse)webRequest.GetResponse();
                        Int64 fileSize = webResponse.ContentLength;

                        strResponse = wcDownload.OpenRead(url);
                        strLocal = new FileStream(name, FileMode.Create, FileAccess.Write, FileShare.None);

                        int bytesSize = 0;
                        byte[] downBuffer = new byte[2048];

                        while((bytesSize = strResponse.Read(downBuffer, 0, downBuffer.Length)) > 0) {
                            strLocal.Write(downBuffer, 0, bytesSize);
                            this.Invoke(new UpdateProgessCallback(UpdateProgress), new object[] { strLocal.Length, fileSize });
                        }
                    }
                    catch(Exception) {
                        throw new FileNotFoundException();
                    }
                    finally {
                        strResponse.Close();
                        strLocal.Close();
                    }
                }
            if(File.Exists(name))
                Process.Start(name);
            Dispose();
        }

        private void UpdateProgress(Int64 BytesRead, Int64 TotalBytes) {
            PercentProgress = Convert.ToInt32((BytesRead * 100) / TotalBytes);
            progressBar1.Value = PercentProgress;
            label1.Text = "Downloaded " + BytesRead + " out of " + TotalBytes + " (" + PercentProgress + "%)";
        }
    }
}
