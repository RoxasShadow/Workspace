// Le librerie di base
#include <nds.h>
#include <stdio.h>

// Le librerie per il suono
#include <maxmod9.h>
#include "soundbank.h"
#include "soundbank_bin.h"

// Stampa il carattere (key) digitato dalla tastiera
void OnKeyPressed(int key) {
	if(key > 0) {
	iprintf("%c", key);
	}
}

int main(void)  {

	// Inizializzo la console
	consoleDemoInit();
	   
	// Inizializzo la tastiera
	Keyboard *kbd = keyboardDemoInit();
	kbd->OnKeyPressed = OnKeyPressed;

	while(1) {


		/* ---- START ---- */


		// Inizializzo il suono
		mmInitDefaultMem((mm_addr)soundbank_bin);

		// Carico in memoria il suono
		mmLoad(SFX_AMBULANCE);

		// Lo avvio
		mmStart(SFX_AMBULANCE, MM_PLAY_LOOP);

		int sign; // Il simbolo dell'operazione
		int x; // Variabile X
		int y; // Variabile Y
		int res; // Risultato

		iprintf("Benvenuto in DSCalculator 1.0!\n");
		iprintf("Rilasciato sotto licenza GNU/GPL v3, DSCalculator è una semplice calcolatrice scritta da Giovanni Capuano.\n");
		iprintf("Per maggiori informazioni, vai a http://dscalculator.giovannicapuano.net\n\n");
		
		iprintf("Digita un numero 'X' dalla tastiera\n");
		scanf("%d", &x); // Registro l'input nella variabile x
		iprintf("Digita un numero 'Y' dalla tastiera\n");
		scanf("%d", &y); // Registro l'input nella variabile y
		iprintf("Digita 1 per sommare, 2 per moltiplicare, 3 per sottrarre e 4 per dividere\n");
		scanf("%d", &sign); // Registro l'input nella variabile sign

		if(sign == 1) {
			res = x + y;
		}
		else if(sign == 2) {
			res = x * y;
		}
		else if(sign == 3) {
			res = x - y;
		}
		else if(sign == 4) {
			res = x / y;
		}

		iprintf("\n Risultato: %d", res);


		/* ---- END ---- */


		// Attendo un input
		scanKeys();
		  
		// Appena lo ricevo pulisco la console
		while(!keysDown()) {
			scanKeys();
		}
		  
		swiWaitForVBlank();
		consoleClear();
	}

	return 0;
}