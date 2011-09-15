<?php
system("clear");
echo "Benvenuto nella morra cinese!\n";
echo "[0]Carta, [1]Forbice o [2]Sasso? ";
$scelta = fgets(STDIN); // Ricevo l'input
$opponent = rand(0, 2); // Un numero pseudocasuale tra 0 e 2
echo "Tu: $scelta";
echo "Avversario: $opponent\n";
$win = 0;
$lose = 0;
$tie = 0;

if(($scelta == 0) && ($opponent == 0)) {
	$tie = 1;
}
else if(($scelta == 0) && ($opponent == 1)) {
	$lose = 1;
}
else if(($scelta == 0) && ($opponent == 2)) {
	$win = 1;
}
else if(($scelta == 1) && ($opponent == 0)) {
	$win = 1;
}
else if(($scelta == 1) && ($opponent == 1)) {
	$tie = 1;
}
else if(($scelta == 1) && ($opponent == 2)) {
	$lose = 1;
}
else if(($scelta == 2) && ($opponent == 0)) {
	$lose = 1;
}
else if(($scelta == 2) && ($opponent == 1)) {
	$win = 1;
}
else if(($scelta == 2) && ($opponent == 2)) {
	$tie = 1;
}

if($win == 1) {
	echo "Hai vinto!\n";
}
else if($lose == 1) {
	echo "Hai perso.\n";
}
else if($tie == 1) {
	echo "Pareggio!\n";
}
exit(0);
?>
