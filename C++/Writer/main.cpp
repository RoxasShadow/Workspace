#include <iostream>
#include <fstream>
using namespace std;

int main() {
string nome;
string contenuto;

cout << "Digita il nome del file che vuoi creare: ";
cin >> nome;
cout << "\nOra digita il contenuto del file:\n";
cin >> contenuto;

ofstream file((nome+".txt").c_str()); // Crea il file
if(!file) {
cout << "Errore, il file non e' stato creato.\n";
return -1;
}
file << contenuto; // Scrivo nel file
file.close(); // Chiudo il file
cout << "Il file e' stato creato.\n";
main();
return 0;
}