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
using System.Net;
using System.Text.RegularExpressions;
using System.Text;

namespace Memes_Viewer {
    class Utils {
        public static string GetJSON(string url) {
            WebClient client = new WebClient();
            client.Encoding = Encoding.UTF8;
            string json = client.DownloadString(url);
            return json.Length > 0 ? json : "";
        }

        public static Meme ParseJSON(string content, string pattern) {
            if(content == "")
                return null;
            MatchCollection matches = new Regex(pattern).Matches(content);
            if(matches.Count == 0)
                return null;
            foreach(Match m in matches)
                return new Meme(m.Groups["url"].Value, m.Groups["alt"].Value);
            return null;
        }

        public static string HtmlDecode(string content) {
            return WebUtility.HtmlDecode(content);
        }
    }
}
