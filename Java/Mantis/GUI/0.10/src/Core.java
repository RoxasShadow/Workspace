/**
    Si occupa di dare a disposizione i metodi per gestire il player.
    Copyright (C) 2011  Giovanni 'Roxas Shadow' Capuano

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

import java.io.FileInputStream;
import java.io.BufferedInputStream;
import javazoom.jl.decoder.Manager;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.*;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.jlap;
import javazoom.jl.player.advanced.PlaybackListener;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.FactoryRegistry;
import javazoom.jl.decoder.*;
import javazoom.jl.decoder.FrameDecoder;

public class Core {
	private String nomefile;
	private Player player;
	private FileInputStream input;
	private BufferedInputStream buffer;
	
	public Core(String nomefile) {
		this.nomefile = nomefile;
	}
	
	public void play() {		
		try {
			input = new FileInputStream(nomefile);
			buffer = new BufferedInputStream(input);
			player = new Player(buffer);
		}
		catch(Exception e) {}
		
		new Thread() {
			public void run() {
				try {
					player.play();
				}
				catch(Exception e) {}
			}
		}.start();
	}
	
	public void stop() {
		player.close();
	}
}
