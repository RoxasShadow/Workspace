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
package net.giovannicapuano.todolist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.app.Activity;

public class Utils extends Activity {
	public boolean exists(String filename) {
		try {
			return new File(filename).exists();
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public boolean delete(String filename) {
		if(!exists(filename))
			return true;
		try {
			return new File(filename).delete();
		}
		catch(Exception e) {
			return false;
		}
	}
	  
	public boolean save(String filename, Object obj) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(filename)));
			oos.writeObject(obj);
			oos.flush();
			oos.close();
		}
		catch(Exception e) {
			return false;
		}
		return exists(filename);
	}
	
	public Object load(String filename) {
		if(!exists(filename))
			return null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(filename)));
			return ois.readObject();
		}
		catch(Exception e) {
			return null;
		}
	}
}
