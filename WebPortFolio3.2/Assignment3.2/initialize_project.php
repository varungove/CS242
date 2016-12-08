<!-- Adds all the projects to the project table in the DB -->
<html>
	<body>
		<?php
			include 'config.php';
			include 'open_db.php';
			include 'project.php';
			
			//Even with correct password, it does not enter the loop. This is intentional.
			if (isset($_POST['add']) && ($_POST['pass']=="hi") ) { 
				
				//Adding Project 1.0
					$data = new Parse("Assignment1.0");			
					$STH = $conn->prepare("INSERT INTO project (name) VALUES (:name)");
					$STH->bindParam(':name', $name );
					$name = $data->name;								
					if($STH->execute()) {
						echo "1.0 Added";	
					} else {
						echo "<script>alert('Error connecting to database');</script>";
					}
					
				//Adding Project 1.1
					$data = new Parse("Assignment1.1");			
					$STH = $conn->prepare("INSERT INTO project (name) VALUES (:name)");
					$STH->bindParam(':name', $name );
					$name = $data->name;								
					if($STH->execute()) {
						echo "1.1 Added";	
					} else {
						echo "<script>alert('Error connecting to database');</script>";
					}
				
				//Adding Project 1.2
					$data = new Parse("Assignment1.2");			
					$STH = $conn->prepare("INSERT INTO project (name) VALUES (:name)");
					$STH->bindParam(':name', $name );
					$name = $data->name;								
					if($STH->execute()) {
						echo "1.2 Added";	
					} else {
						echo "<script>alert('Error connecting to database');</script>";
					}
				
				//Adding Project 2.0
					$data = new Parse("Assignment2.0");			
					$STH = $conn->prepare("INSERT INTO project (name) VALUES (:name)");
					$STH->bindParam(':name', $name );
					$name = $data->name;								
					if($STH->execute()) {
						echo "2.0 Added";	
					} else {
						echo "<script>alert('Error connecting to database');</script>";
					}
					
				//Adding Project 2.1
					$data = new Parse("Assignment2.1");			
					$STH = $conn->prepare("INSERT INTO project (name) VALUES (:name)");
					$STH->bindParam(':name', $name );
					$name = $data->name;								
					if($STH->execute()) {
						echo "2.1 Added";	
					} else {
						echo "<script>alert('Error connecting to database');</script>";
					}
					
					
					
				
			} 	
		?>
		
		<h1>Initialize Project DB</h1> 
		Admin Password:<br />
			<input type="text" name="pass" value="" />
			<br /><br />
		<form action="initialize_project.php" method="post">  
			<input type="submit" name="add" value="Initialize Projects in DB" />
		</form>	
			
	</body>
</html>