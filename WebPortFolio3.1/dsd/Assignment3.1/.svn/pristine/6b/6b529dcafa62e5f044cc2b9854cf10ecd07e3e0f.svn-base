<?php
/**
 * Contains the function that checks for red flags, HTML tags and replaces them. 
 */

	function replace($word){
		include 'config.php';
		include 'open_db.php';
		
		$STH = $conn->prepare("SELECT * FROM flag");
		$STH->execute();
		
		//HTML Sanitization
		$word = strip_tags($word);
		
		while($row = $STH->fetch()){
			$insult = $row['word'];
			$len = strlen($insult);
			$replacement = $row['replacement'];
			$flag = strpos($word, $insult);

			if($flag != FALSE){
				$word = substr_replace($word, $replacement, $flag, $len);
				
			}
			
		}
		
		return $word;
	}



?>