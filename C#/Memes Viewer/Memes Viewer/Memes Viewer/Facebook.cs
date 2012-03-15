using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Facebook;

namespace Memes_Viewer {
    class Facebook {
        private FacebookAPI api;

        public Facebook(string token) {
            api = new FacebookAPI(token);
        }

        public static string url(string app_id) {
            return "https://www.facebook.com/dialog/permissions.request?app_id="+app_id+"&display=page&next=https://www.facebook.com/connect/login_success.html&response_type=token&fbconnect=1&perms=publish_stream";
        }

        public void post(string link, string description, string text) {
            JSONObject result = api.Get("/me");
            Dictionary<string, string> parameters = new Dictionary<string, string>();
            parameters["link"] = link;
            parameters["caption"] = description;
            parameters["message"] = text;
            api.Post("/me/feed", parameters);
        }
    }
}
