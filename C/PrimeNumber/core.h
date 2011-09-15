/**
    This file is part of PrimeNumber.
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

/* Prototypes */
int isPrime(int n); // Since there isn't boolean I declare it as int :'(
int getRandomPrime(int min, int max);
void getDex(int n);

/* Functions */
int isPrime(int n) {
	if((n == 0) || (n == 1))
		return 1; // Is not first
	if(n == 2)
		return 0; // Is first
		
	int i;
	for(i=3; i<n; i++) // If n is a value as 0, 1 and 2 we wouldn't be here...
		if(n%i == 0) // Loal, that's a inutility, isn't it? :)
			return 1;
	return 0;
}

int getRandomPrime(int min, int max) {	
	int n = 0;
	while(isPrime(n) == 1) {
		n = (rand() % (max - min) + min); // A random number with a range between min and max
	}
	return n;		
}
