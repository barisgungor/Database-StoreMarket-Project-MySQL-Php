<?php
	$row = 0;
	$filename = "csv/1.csv";


	if(!file_exists($filename) || !is_readable($filename))
		return FALSE;
	
	$header = NULL;
	if (($handle = fopen($filename, 'r')) !== FALSE)
	{
		echo '<table border=1>';
		echo '<tr><td>Name</td><td>Val</td><tr/>';
		while (($row = fgetcsv($handle, 1000, ';')) !== FALSE)
		{
			if(!$header)
				$header = $row;
			else{
				echo '<tr><td>'.$row[0].'</td><td>'.$row[1].'</td><tr/>';
			}
		}
		echo '</table>';
		fclose($handle);
	}

?>