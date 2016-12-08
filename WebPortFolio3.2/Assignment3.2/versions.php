<?php
/*
 * Version class
 * Contains all info for each file version.
 */

	class Version{
	
		public $revision;
		public $author;
		public $msg;
		public $date;
		
		public function __construct($revision, $author, $msg, $date)
		{
 			$this->revision = $revision;
 			$this->author = $author;
 			$this->msg = $msg;
 			$this->date = substr($date, 0, 10);
			
		}
	}

?>