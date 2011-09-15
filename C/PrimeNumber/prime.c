/**
    That's a simple (in)utility with a couple of function to manage the
    prime number. 
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
#include "core.h"

int main() {
	int x;
	int y;
	int choice;
	
	printf("Welcome in PrimeNumber v0.10\n");
	do {
		printf("\nWhat you want to do?\n");
		printf("[1] Check if a number is first\n");
		printf("[2] Generate a first number by a range of values\n");
		printf("[3] Say hello\n");
		printf("[4] TODO\n");
		printf("[5] Exit\n");
		scanf("%d", &choice);
		
		switch(choice) {
			case 1:
				printf("Type the number wich you want know if it is or not prime: ");
				scanf("%d", &x);
				if(isPrime(x) == 0) {
					printf("It's prime.");
				}
				else {
					printf("It isn't prime.");
				}
				printf("\n");
				break;
			case 2:
				printf("Type the minimum value of the range: ");
				scanf("%d", &x);
				printf("Type the maximum value of the range: ");
				scanf("%d", &y);
				printf("%d", getRandomPrime(x, y));
				printf("\n");
				break;
			case 3:
				printf("Hello, World!... asd\n");
				break;
			case 4:
				printf("Error handling when I type a non-int char when is requested.\n");
				break;
			case 5:
				printf("Bye");
				printf("\n");
				return;
		}
	} while(choice != 5);
}
