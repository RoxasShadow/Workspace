<?php
if((isset($_GET['id'])) && ($_GET['id'] == 'google')) {
	echo getGoogle();
}

if((isset($_POST['nome'])) && (isset($_POST['cognome']))) {
	for($i=0; $i<1000000; $i++) {}
	echo "Ciao {$_POST['nome']} {$_POST['cognome']}";
}

function getGoogle() {
	return file_get_contents("http://www.google.com");
}
?>
