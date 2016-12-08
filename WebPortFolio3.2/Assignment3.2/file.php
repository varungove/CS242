<?php
/*
 * File class that contains information on each file.
 * Also contains an array of versions
 */
include "versions.php";

	class File{
	
		public $name;
		public $type;
		public $path;
		public $size;
		public $versions;
		
		
		/*
 		 * Constructor
 		 * @params: fileName, filetype, filepath, filesize
 		 */
		public function __construct($fname, $ftype, $fpath, $fsize){
			
			$svnList = simplexml_load_file("svn_list.xml");
 			$svnLog = simplexml_load_file("svn_log.xml");
 			$this->name = $fname;
 			$this->type = $ftype;
 			$this->path = $fpath;
 			$this->size = $fsize;
 			$this->revision = $rev;
 			$this->version = array();
 			$check = "/goverdh2/".$fname;			
 			$this->type = self::assignType($fname);
 						
 			foreach($svnLog->logentry as $log){				
				foreach($log->paths->path as $path){
					
					if((strcmp((string)$check, (string)substr($path, 0, strlen($check))) == 0)){
		
					$tempRev = (string)($log->attributes()["revision"]);
					$tempAuthor = $log->author;
					$tempDate = $log->date;
					$tempMsg = $log->msg;
					$tempVersion = new Version($tempRev, $tempAuthor, $tempMsg, $tempDate);
					$this->versions[] = $tempVersion;
					
					}
				
				}	
					
			}			
		}
		
		/*
 		 * Determines type of file
 		 * @param: File Name
 		 * @return: String
		 */
		public function assignType($fname){
		
			$checkType = substr($fname, (strlen($fname)-5), strlen($fname));
 			
 			if($checkType == "class")
 			{	
 				return "code";
 			}
 			
 			$checkType = substr($fname, (strlen($fname)-4), strlen($fname));
 			
 			if($checkType == "java")
 			{	
 				return "java code";
 			}
 				
 			if($checkType == "test" || $checkType == "Test")
 			{	
 				return "Test";
 			}
 				
 			if($checkType == "json")
 			{	
 				return "JSON";
 			}
 			
 			if($checkType == "jpeg" || $checkType == ".png")
 			{
 				return "image";
 			}
 			
 			if($checkType == "html")
 			{	
 				return "html";
 			}
 			
 			$checkType = substr($fname, (strlen($fname)-3), strlen($fname));
 			
 			if($checkType == ".py")
 			{	
 				return "Python Code";
 			}	
 			
 			return "file";
		  }
		
	     }

?>