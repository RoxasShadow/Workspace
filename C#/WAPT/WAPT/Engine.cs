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
using System.IO;
using System.Xml;
using Microsoft.Win32;

namespace WAPT {
    public class Engine {
        public List<Package> Packages { get; set; }
        public enum PackageStatus { NOT_INSTALLED, INSTALLED, OLDEST, NEWER }
        private int nElement;
        private string path, url;

        /* Initializes the repository. */
        public Engine() {
            nElement = 7;
            url = "http://www.giovannicapuano.net/repository/";
            path = "package.xml";
            if(!File.Exists(path))
                if(!Utils.Download(url + path, path))
                    throw new FileNotFoundException();
            if(FileExists(path))
                Packages = ParseXML(path);
            else
                throw new FileNotFoundException();
        }

        /* Initializes the repository giving its url. */
        public Engine(string url) {
            nElement = 7;
            this.url = url;
            path = "package.xml";
            if(!File.Exists(path))
                if(!Utils.Download(url + path, path))
                    throw new FileNotFoundException();
            if(FileExists(path))
                Packages = ParseXML(path);
            else
                throw new FileNotFoundException();
        }

        /* Downloads a program giving its name. */
        public bool Download(string name) {
            foreach(Package pkg in Packages)
                if(pkg.Name == name)
                    return Utils.Download(url+pkg.Path, Utils.GetNameByURL(pkg.Path));
            return false;
        }
        
        /* Downloads a program giving its name and path where saving it. */
        public bool Download(string name, string path) {
            foreach(Package pkg in Packages)
                if(pkg.Name == name)
                    return Utils.Download(url+pkg.Path, path);
            return false;
        }

        /* Finds packages giving a description. */
        public Package[] Find(string description) {
            List<Package> results = new List<Package>();
            foreach(Package pkg in Packages)
                if(pkg.Description.Contains(description))
                    results.Add(pkg);
            return results.ToArray();
        }

        /* Returns only packages of a given category. */
        public Package[] Filter(string category) {
            List<Package> results = new List<Package>();
            foreach(Package pkg in Packages)
                if(pkg.Category == category)
                    results.Add(pkg);
            return results.ToArray();
        }

        /* Clear the local repository. */
        public bool Clear() {
            if(FileExists("package.xml"))
                File.Delete("package.xml");
            return !FileExists("package.xml");
        }

        /* Checks if a package exists. */
        public bool IsPackage(string package) {
            foreach(Package p in Packages)
                if(p.Name == package)
                    return true;
            return false;
        }

        /* Returns all the used categories. */
        public string[] GetCategoryList() {
            List<string> categories = new List<string>();
            foreach(Package p in Packages)
                categories.Add(p.Category);
            return Utils.RemoveDuplicates(categories.ToArray());
        }

        /* Returns a package given its name. */
        public Package GetPackage(string package) {
            foreach(Package p in Packages)
                if(p.Name == package)
                    return p;
            return null;
        }

        /* Returns the status of package relatives to system. */
        public PackageStatus GetStatus(Package package) {
            RegistryKey uninstall = Registry.LocalMachine.OpenSubKey("SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall", false);
            foreach(string key in uninstall.GetSubKeyNames())
                if(key == package.Name)
                    return PackageStatus.INSTALLED;
            return PackageStatus.NOT_INSTALLED;
        }

        /* Creates a list of packages parsing the XML repository. */
        private List<Package> ParseXML(string path) {
            List<Package> packages = new List<Package>();
            object[] elements = new object[nElement + 1];
            XmlTextReader objXmlTextReader = null;
            try {
                objXmlTextReader = new XmlTextReader(path);
                int i = 0;
                while(objXmlTextReader.Read())
                    if(objXmlTextReader.NodeType == XmlNodeType.Text) {
                        elements[i] = objXmlTextReader.Value;
                        ++i;
                        if(i == nElement) {
                            packages.Add(new Package(elements));
                            i = 0;
                        }
                    }
            }
            catch(Exception) {
                throw new FileNotFoundException();
            }
            finally {
                if(objXmlTextReader != null)
                       objXmlTextReader.Close();
            }
            return packages;
        }

        /* Checks if a file exists. */
        private bool FileExists(string path) {
            return File.Exists(path);
        }
    }
}
