<?php
if((isset($_POST['nickname'])) && isset($_POST['password'])) {
$nickname = trim($_POST['nickname']);
$password = trim($_POST['password']);

$apri = fopen("876789ftgyhtgvfrdcfv987653fgtrla23456gfd.ps","r");
$leggi = fread($apri,filesize("876789ftgyhtgvfrdcfv987653fgtrla23456gfd.ps"));
$db=nl2br($leggi);
fclose($apri);

$db2 = explode("|", $db);
$truenick = trim($db2[0]);
$truepass = trim($db2[1]);

if(($truenick == $nickname) && ($truepass == $password)) {
setcookie("arearistretta", md5($password), time()+2592000, "/");  // L' area ristretta è valida per 30 giorni, dopo questi si ci deve riloggare
header("Location: arearistretta.php");
}
else {
echo 'Dati non corretti. Riprova.';
}
}
?>

<html>
<head>
<title>Login</title>
</head>
<body>

<form method="post" name="login" action="login.php">
<input type="text" name="nickname"><br />
<input type="password" name="password"><br />
<input type="submit" name="submit"><br />
</form>

</body>
</html>