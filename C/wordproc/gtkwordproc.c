/*
TODO:
	How I can get the textarea's text? asd
*/
#include <gtk/gtk.h>
#include <glib.h>
#include <stdio.h>

void callback(GtkWidget *widget, gpointer data) {
	g_print("Hello, %s was pressed.", (char *)data);
}

void displayUI() {
	GtkWidget *mainWindow, *textarea, *button, *container;
	gchar *buffer;
	
	/* Window. */
	mainWindow = gtk_window_new(GTK_WINDOW_TOPLEVEL);
	gtk_window_set_default_size(GTK_WINDOW(mainWindow), 400, 400);
	gtk_window_set_title(GTK_WINDOW(mainWindow), "WordprocessorC");
	gtk_window_set_position(GTK_WINDOW(mainWindow), GTK_WIN_POS_CENTER_ALWAYS);
	gtk_signal_connect(GTK_OBJECT(mainWindow), "destroy", G_CALLBACK(gtk_main_quit), NULL);
	
	/* Textarea. */
	textarea = gtk_text_new(NULL, NULL);
	buffer = "Hello, world!";
	gtk_text_set_editable(GTK_TEXT_VIEW(textarea), TRUE);
	gtk_text_insert(GTK_TEXT_VIEW(textarea), NULL, NULL, NULL, buffer, strlen(buffer));
	
	/* Button. */
	container = gtk_fixed_new();
	button = gtk_button_new_with_label("Click me!");
	gtk_signal_connect(GTK_OBJECT(button), "clicked", GTK_SIGNAL_FUNC(callback), (gpointer) "I");
	
	/* Container. */
	container = gtk_fixed_new();
	/* Button. */
		gtk_container_add(GTK_CONTAINER(container), button);
		gtk_container_add(GTK_CONTAINER(mainWindow), container);
		gtk_fixed_put(GTK_FIXED(container), button, 0, 0);
		gtk_fixed_move(GTK_FIXED(container), button, 0, 0);
	/* Textarea. */
		gtk_container_add(GTK_CONTAINER(container), textarea);
		gtk_container_add(GTK_CONTAINER(mainWindow), container);
		gtk_fixed_put(GTK_FIXED(container), textarea, 0, 40);
		gtk_fixed_move(GTK_FIXED(container), textarea, 0, 40);
		
	
	/* All done. */
	gtk_widget_show_all(mainWindow);
}

int main(int argc, char *argv[]) {
	gtk_init(&argc, &argv);
	displayUI();
	gtk_main();
	return 0;
}
