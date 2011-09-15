/*
TODO:
- Created files have to be recognized as text file and not as binary (or what is :))
*/
#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>
bool file_exists(char *filename);
void writeFile();
void readFile();
void deleteFile();
int main();

bool file_exists(char *filename) {
	FILE *handler;
	if(handler = fopen(filename, "r")) {
		fclose(handler);
		return true;
	}
	else
		return false;
}

void writeFile() {
	char filename[22];
	char buffer[255];
	int size = 0;
	FILE *handler;
	
	printf("Filename: ");
	scanf("%s", &filename);
	
	if(file_exists(filename))
		printf("File `%s` just exists.\n", &filename);
	else {
		printf("Text (Type Ctrl+d for stopping):\n");
		while((buffer[size] = getchar()) != EOF)
			++size;
		handler = fopen(filename, "w");
		fwrite(buffer, sizeof(char), 255, handler);
		fclose(handler);
		(file_exists(filename)) ? printf("Done.\n") : printf("An error has occourred.\n");
	}
}

void readFile() {
	char filename[22];
	char buffer[255];
	FILE *handler;
	
	printf("Filename: ");
	scanf("%s", &filename);

	if(!file_exists(filename))
		printf("File `%s` not exists.\n", &filename);
	else {
		handler = fopen(filename, "r");
		fread(buffer, sizeof(char), 255, handler);
		fclose(handler);
		printf("\n=-=-=-=-=-=-=-=->%s<-=-=-=-=-=-=-=-=\n%s\n=-=-=-=-=-=-=-=->%s<-=-=-=-=-=-=-=-=\n", &filename, &buffer, &filename);
	}
}

void deleteFile() {
	char filename[255];
	
	printf("Filename: ");
	scanf("%s", &filename);

	if(!file_exists(filename))
		printf("File `%s` not exists.\n", &filename);
	else {
		while(file_exists(filename))
			remove(filename);
		printf("File deleted.\n");
	}
}

int main() {
	int i;
	do {
		i = 0;
		printf("[1]New file\n[2]Read file\n[3]Delete file\n[4]Infos\n[5]Exit\n");
		scanf("%d", &i);
		switch(i) {
			case 1:
				writeFile();
				break;
			case 2:
				readFile();
				break;
			case 3:
				deleteFile();
				break;
			case 4:
				printf("WordprocessorC (C) 2011 Giovanni Capuano\n");
				break;
			case 5:
				exit(0);
				break;
			default:
				printf("Function not recognized.\n");
		}
	} while(i != 5);
	return 0;
}
