<?php
if((isset($_GET['id'])) && ($_GET['id'] == 'google')) {
	echo getGoogle();
}

if((isset($_POST['nome'])) && (isset($_POST['cognome']))) {
	for($i=0; $i<1000000; $i++) {}
	
	include '../ocarina2/core/class.Page.php';
	$page = new Page();
	foreach($page->getPage() as $v)
		echo '<b>'.$v->titolo.'</b><br />News scritta da '.$v->autore.' il '.$v->data.' alle ore '.$v->ora.'<br />'.$v->contenuto.'<br /><br />';
}

function getGoogle() {
	return file_get_contents('http://www.google.com');
}
?>
