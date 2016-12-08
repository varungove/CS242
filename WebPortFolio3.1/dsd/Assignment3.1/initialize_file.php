<!-- Adds all the Files and versions to the DB -->
<html>
	<body>
		<?php
			
			$pass = "hi";
			
			//Even with correct password, it does not enter the loop. This is intentional.
			if (isset($_POST['add']) && ($_POST['pass']=="hi")) {
					include 'config.php';
					include 'open_db.php';
					include 'project.php'; 
			
					initialize("Assignment1.0", 1, $conn);
					initialize("Assignment1.1", 2, $conn);
					initialize("Assignment1.2", 3, $conn);
					initialize("Assignment2.0", 4, $conn);
					initialize("Assignment2.1", 5, $conn);				
					
			} 	
			
			/**
			 * Initialize each file and its versions
			 * @param $pname Project Name
			 * @param $pro_id ProjectID
			 * @param $conn The Connection
			 */
			function initialize ($pname, $pro_id, $conn){
			
				//Adding Project 1.0
					$data = new Parse($pname);
					$files = $data->files;	
					
					//Adding each file to the DB
					foreach($files as $file)
					{
						$STH = $conn->prepare("INSERT INTO file (name, pid) VALUES (:name, :pid)");
						$name = $file->name;
						$pid = $pro_id;
						$STH->bindParam(':name', $name );
						$STH->bindParam(':pid', $pid );
						if($STH->execute()) {
							echo "Added";	
						} 
						else {
							echo "<script>alert('Error connecting to database');</script>";
						}
						
						//Adding each version of the file to the DB
						$vid = 0;
						foreach($file->versions as $ver)
						{
							
							$STH = $conn->prepare("SELECT fid FROM file WHERE name = :name");
							$STH->bindParam(':name', $name );
							$STH->execute();
							$row = $STH->fetch();
							$fid = $row['fid'];
							
							$STH = $conn->prepare("INSERT INTO version (vid, fid) VALUES (:vid, :fid)");
							$vid = $vid + 1;
							$STH->bindParam(':vid', $vid );
							$STH->bindParam(':fid', $fid );
							
							if($STH->execute()) {
							echo "Added File";	
							} 
							else {
								echo "<script>alert('Error connecting to database');</script>";
							}
									
						}
						
					}	
			}
		?>
		
		<h1>Initialize File DB</h1> 
		Admin Password:<br />
			<input type="text" name="pass" value="" />
			<br /><br />
		<form action="initialize_file.php" method="post">  
			<input type="submit" name="add" value="Initialize File in DB" />
		</form>	
			
	</body>
</html>