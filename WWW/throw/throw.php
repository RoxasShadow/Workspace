<?php
class OcarinaException extends Exception {
	public function getError() {
		return 'An error was accourred: `'.$this->getMessage().'` in '.$this->getFile().'.';
	}
}

function division($a, $b) {
	if((!is_numeric($a)) || (!is_numeric($b))) {
		throw new OcarinaException('The input have to be numeric');
	}
	elseif($b <= 0) {
		throw new OcarinaException('Division per zero denied');
	}
	else
		return ($a/$b);
}

try {
	echo '1/2 = '.division(1, 2);
}
catch(OcarinaException $e) {
	echo '1/2 = '.$e->getError();
}

echo '<br />';

try {
	echo '2/1 = '.division(2, 1);
}
catch(OcarinaException $e) {
	echo '2/1 = '.$e->getError();
}

echo '<br />';

try {
	echo '1/0 = '.division(1, 0);
}
catch(OcarinaException $e) {
	echo '1/0 = '.$e->getError();
}

echo '<br />';

try {
	echo '0/1 = '.division(0, 1);
}
catch(OcarinaException $e) {
	echo '0/1 = '.$e->getError();
}

echo '<br />';

try {
	echo '1/lol = '.division(1, 'lol');
}
catch(OcarinaException $e) {
	echo '1/lol = '.$e->getError();
}

echo '<br />';
