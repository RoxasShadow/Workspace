<?php
/**
	class.Caching.php
	(C) Giovanni Capuano 2011
*/
class Caching {
	public $caching = true; // `true` -> Caching enabled; `false` -> Caching disabled.
	private $storage = '/var/www/htdocs/caching/cache/';
	
	public function __construct($host, $username, $password, $database, $storage) {
		if(!mysql_selectdb($database, mysql_connect($host, $username, $password)))
			die('Database connection failed.');
		elseif($this->caching)
			if(!is_dir($this->storage))
				die('The cache directory not exists.');
			elseif(!is_writable($this->storage))
				die('The cache directory is not writable. You should fix the permissions.'); 
			else
				$this->storage = $storage;
	}
	
	public function __distruct() {
		mysql_close();
	}
	
	/* Private methods. */
	private function serial($file, $obj) {
		$f = fopen($this->storage.$file, 'w');
		fwrite($f, serialize($obj));
		fclose($f);
	}
	
	private function unserial($file) {
		$filetime = filemtime($this->storage.$file);
		$f = fopen($this->storage.$file, 'r');
		$content = fread($f, filesize($this->storage.$file));
		fclose($f);
		return unserialize($content);
	}
	
	private function is_cachable($query) {
		return !preg_match('/\s*(INSERT[\s]+|DELETE[\s]+|UPDATE[\s]+|REPLACE[\s]+|CREATE[\s]+|ALTER[\s]+|SET[\s]+|FOUND_ROWS[\s]+|SQL_NO_CACHE[\s]+)/si', $query);
	}
	
	private function is_cached($file) {
		return file_exists($this->storage.$file) ? true : false;
	}
	
	private function cache_remove($file) {
		if($this->is_cached($file))
			unlink($this->storage.$file);
	}
	
	/* Public methods. */
	public function cache_clean() {
		$dir = opendir($this->storage);
		while($file = readdir($dir))
			if(substr($file, -6) == '.cache')
				$this->cache_remove($file);
	}
	
	public function query($query) {
		if(!$result = mysql_query($query))
			return false;
		if($this->caching)
			if(!$this->is_cachable($query))
				$this->cache_clean();
		return $result;
	}
	
	public function get($query) {
		if(!$this->caching) {
			if(!$result = mysql_query($query))
				return false;
			$array = array();
			while($fetch = mysql_fetch_object($result))
				array_push($array, $fetch);
			mysql_free_result($result);
			return empty($array) ? false : $array;
		}
		$file = md5($query).'.cache';
		if($this->is_cached($file))
			return $this->unserial($file);
		if(!$result = mysql_query($query))
			return false;
		$array = array();
		while($fetch = mysql_fetch_object($result))
			array_push($array, $fetch);
		mysql_free_result($result);
		if(!$this->is_cached($file))
			$this->serial($file, $array);
		return empty($array) ? false : $array;
	}
	
	public function count($query) {
		if($this->caching) {
			$file = md5($query).'.cache';
			if($this->is_cached($file)) {
				$count = count($this->unserial($file));
				return ((!$count) || (!is_numeric($count)) || ((int)$count <= 0)) ? 0 : (int)$count;
			}
		}
		if(!$result = mysql_query($query))
			return false;
		$count = mysql_num_rows($result);
		return ((!$count) || (!is_numeric($count)) || ((int)$count <= 0)) ? 0 : (int)$count;
	}
	
	public function getEnum($query) {
		if(!$result = mysql_query($query));
			return false;
		if(!$rows = mysql_fetch_row($result))
			return false;
		$category = explode("','", preg_replace("/(enum|set)\('(.+?)'\)/", "\\2", $rows[1]));
		return (empty($category)) ? false : $category;
	}
	
	public function getColumns($query) {
		if(!$result = mysql_query($query))
			return false;
		$array = array();
		if(!$columns = mysql_num_fields($result))
			return false;
		for($i=0; $i<$columns; $i++)
			$array[$i] = mysql_field_name($result, $i);
		return (empty($array)) ? false : $array;
	}
}
