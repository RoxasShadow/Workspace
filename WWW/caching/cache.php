<?php
list($usec, $sec) = explode(' ', microtime());
$time = ((float)$usec + (float)$sec);
require_once('class.Caching.php');

$cache = new Caching('localhost', 'root', 'kronos', 'ocarina2', '/var/www/htdocs/caching/cache/');
$getNews = $cache->get('SELECT * FROM news LIMIT 10');
foreach($getNews as $v)
	echo $v->titolo.'<br />';
echo 'Count: '.$cache->count('SELECT * FROM news LIMIT 10').'<br /><br />';

list($usec, $sec) = explode(' ', microtime());
$time = ((float)$usec + (float)$sec) - $time;
echo "Time: $time"; // Average ~= 0.003

/* Wait... */
echo '<br />--------------------------------<br />';
unset($time);
unset($cache);
unset($getNews);
/* Go! */

list($usec, $sec) = explode(' ', microtime());
$time = ((float)$usec + (float)$sec);

mysql_selectdb('ocarina2', mysql_connect('localhost', 'root', 'kronos'));
$query = mysql_query('SELECT * FROM news LIMIT 10');
$getNews = array();
while($fetch = mysql_fetch_object($query))
	array_push($getNews, $fetch);
foreach($getNews as $v)
	echo $v->titolo.'<br />';
echo 'Count: '.mysql_num_rows(mysql_query('SELECT * FROM news LIMIT 10')).'<br /><br />';

list($usec, $sec) = explode(' ', microtime());
$time = ((float)$usec + (float)$sec) - $time;
echo "Time: $time"; // Average ~= 0.005 (too unstable, but never under 0.005, more surely!)
