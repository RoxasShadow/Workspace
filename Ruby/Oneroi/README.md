Oneroi - A POP3 mail manager.
=============================
A simple POP3 mail manager with daemon and client functions.

-----------------------------
The daemon works only with libnotify-bin on Gnome.

On Debian and its derivates (like Ubuntu), do

```bash
sudo apt-get install libnotify-bin
```

On Arch, do

```bash
sudo pacman -S libnotify
```

After the installation, try it running in a terminal emulator

```bash
notify-send 'Hi' 'Hello, World!' -t 3000
```

To demonize at startup in GNU/Linux, edit and copy this etc/rcS.d/S23oneroi in /etc/rcS.d/S23oneroi.

If exists a daemon with "23" prefix, simply change it with the lastest+1 (ie.: if you have S23lol, rename S23oneroi in S24oneroi).
