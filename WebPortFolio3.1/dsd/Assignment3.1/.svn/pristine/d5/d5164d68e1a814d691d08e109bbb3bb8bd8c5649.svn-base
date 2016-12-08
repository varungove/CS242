 <?php
include "file.php";

	/*
 	 * Parse class that is an entire project and it's info.
 	 * Contains an array of files.
 	 */
	class Parse{
	
		public $name;
		public $date;
		public $message;
		public $revision;
		public $files;
				
		
		/*
 		 * Constructor 
 		 * @param: Project Name
 		 */	
		public function __construct($pName){
				
			$svnList = simplexml_load_file("svn_list.xml");
 			$svnLog = simplexml_load_file("svn_log.xml");
 			$this->name = $pName;
 			$this->files = array();
			
			foreach($svnList->list->entry as $entry){
							
				if($this->name == ($entry->name))
				{
					
					$this->date = substr($entry->commit->date, 0, 10);
					$this->revision = $entry->commit->attributes()["revision"];
				}
					
				if((string)($entry->attributes()["kind"]) == "file")
				{
					$x = strlen($this->name);
					$str = (string)($entry->name);
					$y = strlen($entry->name);
					$str = substr($str, 0, $x);
						
					if(($str == $this->name) && ($y>$x))
					{
						$tempName = (string)($entry->name);
						$tempSize = (string)($entry->size);
						$tempType = "file";
						$tempPath = "https://subversion.ews.illinois.edu/svn/fa16-cs242/goverdh2/" . $tempName;
						$tempFile = new File($tempName, $tempType, $tempPath, $tempSize);
						$this->files[] = $tempFile;
					}
				}
				
				
			}
				
			foreach($svnLog->logentry as $log){
						
				if((string)($log->attributes()["revision"]) == (string)$this->revision)
				{
					$this->message = $log->msg;
				}
								
			}
			
		     }
	         }

?>