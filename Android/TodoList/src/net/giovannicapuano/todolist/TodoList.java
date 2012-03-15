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

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TodoList extends Activity {
	private LinearLayout layout;
	private Button save;
	private EditText newText;
	private ArrayList<Todo> todo;
	private Utils utils;
	private String filename;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		utils = new Utils();
		filename = getFilesDir()+"todolist.sav";

		Object o = utils.load(filename);
		todo = o == null ? new ArrayList<Todo>() : (ArrayList<Todo>)o;

		newText = (EditText)findViewById(R.id.editText1);
		save = (Button)findViewById(R.id.button1);
		layout = (LinearLayout)findViewById(R.id.linearLayout1);
		list();
	}

	public void save(View view) {
		String txt = newText.getText().toString();
		if(!txt.trim().equals("")) {
			todo.add(new Todo(txt));
			newText.setText("");
			Toast.makeText(TodoList.this, utils.save(filename, todo) ? getString(R.string.saved) : getString(R.string.not_saved), Toast.LENGTH_SHORT).show();
		}
		list();
	}

	public void list() {
		layout.removeAllViews();
		for(final Todo td : todo) {
			BorderedTextView textView = new BorderedTextView(this);
			textView.setBackgroundColor(Color.DKGRAY);
			textView.setText(td.getText());
			textView.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					AlertDialog.Builder builder = new AlertDialog.Builder(TodoList.this);
					builder.setMessage(getString(R.string.delete_text));
					builder.setTitle(getString(R.string.delete_title));
					builder.setCancelable(false);
					builder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							todo.remove(td);
							Toast.makeText(TodoList.this, utils.save(filename, todo) ? getString(R.string.deleted) : getString(R.string.not_deleted), Toast.LENGTH_SHORT).show();
							list();
						}
					});
					builder.setNegativeButton(getString(R.string.not), new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {

						}
					});
					builder.show();
				}
			});
			layout.addView(textView);
		}
	}
}