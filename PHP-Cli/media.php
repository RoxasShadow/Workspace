<?php
function checknum($var) {
       if(is_numeric($var) == false) { // Se è un numero dà true, altrimenti false
               echo "Devi inserire un numero!\n";
               exit(1); // Il programma ha concluso l'esecuzione con errore
       }
}

echo "Quanti numeri hai? ";
$numeri = trim(fgets(STDIN)); // Ricevo l'input
checknum($numeri); // Controllo che sia un numero
$somma = 0; // Inizializzo a 0 la variabile
echo "\n"; // Vado a capo

// Dovrei usare $i=0 ma lo diminuisco di 1 nella verifica così l'output parte da 1
for($i=1; $i-1<$numeri; $i++) {
       echo "Numero $i: ";
       $somma += trim(fgets(STDIN)); // Aumenta $somma del valore degli input
       checknum($somma);
}

$media = $somma / $numeri; // Calcolo la media
echo "La media dei numeri è $media\n";
exit(0); // Il programma ha concluso l'esecuzione con successo
?>
