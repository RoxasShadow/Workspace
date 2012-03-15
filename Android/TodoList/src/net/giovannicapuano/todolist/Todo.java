package net.giovannicapuano.todolist;

import java.io.Serializable;

public class Todo implements Serializable {
	private String text;
	private static final long serialVersionUID = 46548976;
	
	public Todo(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}
