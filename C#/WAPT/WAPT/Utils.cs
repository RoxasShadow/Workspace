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
using System.Net;
using System.Diagnostics;
using System.IO;
using Microsoft.Win32;
using System.Collections.Generic;

namespace WAPT {
    public class Utils {
        /* Starts the download of a file. */
        public static bool Download(string url) {
            try {
                new WebClient().DownloadFile(url, Utils.GetNameByURL(url));
                return true;
            }
            catch(WebException) {
                return false;
            }
        }

        /* Starts the download of a file saving with the given name. */
        public static bool Download(string url, string name) {
            try {
                new WebClient().DownloadFile(url, name);
                return true;
            }
            catch(WebException) {
                return false;
            }
        }

        /* Removes duplicates in an array. */
        public static string[] RemoveDuplicates(string[] s) {
            HashSet<string> set = new HashSet<string>(s);
            string[] result = new string[set.Count];
            set.CopyTo(result);
            return result;
        }

        /* Giving a url, it gives you its filename. */
        public static string GetNameByURL(String url) {
            string[] splitted = url.Split('/');
            return splitted[splitted.Length - 1];
        }

        /* Installs a package. */
        public static bool install(Package package) {
            string name = Utils.GetNameByURL(package.Path);
            if(Utils.Download(package.Path, name)) {
                try {
                    Process.Start(name);
                }
                catch(Exception) {
                    return false;
                }
                finally {
                    Utils.cleanWizard(name);
                }
                return true;
            }
            else
                return false;
        }

        /* Upgrades a package (=install asd). */
        public static bool upgrade(Package package) {
            return Utils.install(package);
        }

        /* Removes a package. */
        public static bool remove(Package package) {
            RegistryKey uninstall = Registry.LocalMachine.OpenSubKey("SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall", false);
            foreach(string key in uninstall.GetSubKeyNames())
                if(key == package.Name) {
                    RegistryKey target = Registry.LocalMachine.OpenSubKey("SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\" + key, false);
                    try {
                        Process.Start((string)target.GetValue("UninstallString"));
                    }
                    catch(Exception) {
                        return false;
                    }
                    return true;
                }
            return false;
        }

        public static bool cleanWizard(string path) {
            if(File.Exists(path)) {
                try {
                    File.Delete(path);
                }
                catch(Exception) {
                    return false;
                }
                return true;
            }
            else
                return false;
        }
    }
}
