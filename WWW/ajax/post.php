<html>
<head>
<script type="text/javascript" src="ajax.js"></script>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<style>
body, div, ul, li, h1, p {
	background: white;
	padding: 10px;
	font: 12px/1.5em Arial, Helvetica;	
	margin:0;
	padding:0;
}

div {
    border: 1px solid #ccc;
    margin: 10px;
    padding: 20px;
    width: 300px;
}

h1 {
    font-size: 2em;
}

p {
    margin-bottom: 1em;
}

ul, li {
    margin-left: 1em;
    list-style-type: disc;
}
</style>
</head>
<body> 
<div id="box">
	Scrivi il tuo nome e cognome.<br />
	Quando premerai il tasto 'Invio', Javascript ve lo bloccherà, PHP controllerà se entrambi i campi sono stati inviati, quindi farà un ciclo for 0-1000000 per perdere un pò di tempo in modo tale che AJAX vi mostrerà un loading e vedrete così la risposta che vi darà PHP.<br />
	Enjoy :D<br /><br />
	<form method="post" action="testo.php" name="bla" onsubmit="inviaPost('testo.php', 'box', this.name, 'invia');">
		<input type="text" name="nome" value="Nome">
		<input type="text" name="cognome" value="Cognome">
		<input type="submit" name="invia">
	</form>
</div>
</body>
</html> 
