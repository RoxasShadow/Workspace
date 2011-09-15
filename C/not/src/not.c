/*  not - output a string repeatedly until killed
    Copyright (C) 2011  Giovanni Capuano

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

#include <stdio.h>

int main(int argc, char** argv) {
	if(argv[1] != NULL) {
		if(strcmp(argv[1], "--help") == 0)
			printf("Uso: not [STRINGA]...\n o:  not OPZIONE\nStampa in continuazione una riga con ogni STRINGA specificata oppure \"not\".\n\n      --help     mostra questo aiuto ed esce\n      --version  stampa le informazioni sulla versione ed esce\n\nSegnalare i bug di not a <webmaster@giovannicapuano.net>\n");
		else if(strcmp(argv[1], "--version") == 0)
			printf("not 1.0\nCopyright © 2011 Giovanni Capuano.\nLicenza GPLv3+: GNU GPL versione 3 o successive <http://gnu.org/licenses/gpl.html>\nQuesto è software libero: è possibile modificarlo e ridistribuirlo.\nNon c'è ALCUNA GARANZIA, nei limiti permessi dalla legge.\n\nScritto da Giovanni Capuano.\n");
		else if(strcmp(argv[1], "happy") == 0)
			printf("hacking!\n");
		else if(strcmp(argv[1], "whatsthis") == 0)
			printf("Questo è un fottuto clone(?) di GNU yes creato in un momento di alta soddisfazione D:\n");
		else if(strcmp(argv[1], "website") == 0)
			printf("Perdi il tuo tempo: http://www.giovannicapuano.net\n");
		else if(strcmp(argv[1], "contact") == 0)
			printf("Perdi il tuo tempo: webmaster@giovannicapuano.net\n");
		else if(strcmp(argv[1], "why") == 0)
			printf("01010110011101010110111101101001001000000110001101100001011100000110100101110010011001010010000001100011011010000110010100100000011100110111010001100001011010010010000001110000011001010111001001100100011001010110111001100100011011110010000001101001011011000010000001110100011101010110111100100000011101000110010101101101011100000110111100111111001000000100010000111010\n");
		else
			while(1)
				printf("%s\n", argv[1]);
		return 0;
	}
	else
		while(1)
			printf("n\n");
	return 0;
}
