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
namespace WAPT {
   public class Package {
        public string Path { get; set; } // The path of the executable
        public string Icon { get; set; } // The icon
        public string Name { get; set; } // The name
        public string Version { get; set; } // The version
        public string Category { get; set; } // The category
        public string Description { get; set; } // A short description
        public double Weight { get; set; } // The weight of the executable in kb

        public Package(object[] elements) {
            Path = (string)elements[0];
            Icon = (string)elements[1];
            Name = (string)elements[2];
            Version = (string)elements[3];
            Category = (string)elements[4];
            Description = (string)elements[5];
            Weight = Double.Parse(elements[6].ToString().Replace('.', ','));
        }

        public Package(string path, string icon, string name, string version, string category, string description, double weight) {
            Path = path;
            Icon = icon;
            Name = name;
            Version = version;
            Category = category;
            Description = description;
            Weight = weight;
        }

        public override string ToString() {
            return "Path: " + Path + "\nIcon: " + Icon + "\nName: " + Name + "\nVersion: " + Version + "\nCategory: " + Category + "\nDescription: " + Description + "\nWeight: " + Weight;
        }

        public string[] ToArray() {
            return new string[] { Path, Icon, Name, Version, Category, Description, Weight.ToString() };
        }
    }
}