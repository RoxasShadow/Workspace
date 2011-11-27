@@ -0,0 +1,29 @@
+# Oneroi - A POP3 mail manager.
+A simple POP3 mail manager with daemon and client functions.
+
+
+The daemon works only with libnotify-bin on Gnome.
+On Debian and its derivates (like Ubuntu), do
+	sudo apt-get install libnotify-bin
+On Arch, do
+	sudo pacman -S libnotify
+After the installation, try it running in the bash terminal
+	notify-send 'Hi' 'Hello, World!' -t 3000
