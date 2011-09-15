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
	Quando premerai il link, Javascript ve lo bloccherà e AJAX effettuerà una richiesta di tipo GET verso PHP che scaricherà una pagina web dalla rete e nel frattempo Javascript vi mostrerà un loading.<br />
	Enjoy :D<br /><br />
	Per cambiare questo contenuto è sufficiente clickare su	<a href="testo.php?id=google" onclick="return inviaGet(this, 'box');">questo link</a>.<br />
	Se non hai Javascript abilitato, visualizzerai direttamente il testo.
</div>
</body>
</html> 
