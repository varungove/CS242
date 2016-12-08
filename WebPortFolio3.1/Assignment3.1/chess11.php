<!-- Contains all information for Chess 1.1 -->

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/styles.css">
</head>
<body>
<div class="container">
	
<header>
   <h1>Chess 1.1 </h1>
</header>
	 
</div>
</body>

	<!-- Project Overview -->
	
	<div class="overview">
	<h2>Project Overview</h2>
	
	<?php
		include "project.php";
		
		$data = new Parse("Assignment1.1");
		
		$name    = $data->name;
		$date    = $data->date;
		$version = $data->revision;
		$summary = $data->message;
		$files   = $data->files;
		
		echo "<pre>";
		echo "Name: " . $name . "<br>";
		echo "Date: " . $date . "<br>";
		echo "Version Numer: " . $version . "<br>";
		echo "Last Commit Message: " . $summary . "<br>";
		echo "</pre>";
	?>
	
	
	</div>
	</div>
	
	<!-- IFrame Panel -->
	<div class="files">
	<h2>Iframe Code View</h2>
	<iframe name='frame' src='' height="400" width="600" ></iframe>
	</div>
	
		 	  
	<?php
		include 'config.php';
		include 'open_db.php';
		include 'red_flag.php';
		
		/**
		 * PHP handling of adding a comment. 
		 */
		
		if(isset($_POST['submit'])){
			if(empty($_POST['comment']) || empty($_POST['author'])){
			
				echo "<script>alert('Author or Comment mising');</script>";
			} else {
			
			$file_name = $_POST['fname'];
			$comment = $_POST['comment'];
			$comment = replace($comment);
			$author = $_POST['author'];
			
			//Get associated file
			$STH = $conn->prepare("SELECT fid FROM file WHERE name = :name");
			$STH->bindParam(':name', $file_name );
			$STH->execute();
			$row = $STH->fetch();
			$fid = $row['fid'];
			
			//Add comment
			$STH = $conn->prepare("INSERT INTO comment (comment, fid, author) VALUES (:comment, :fid, :author)");
			$STH->bindParam(':comment', $comment );
			$STH->bindParam(':fid', $fid );
			$STH->bindParam(':author', $author );
			$STH->execute();
				}
		}
		
		/**
		 * PHP handling of adding a reply. 
		 */
		
		if(isset($_POST['reply'])){
			if(empty($_POST['r_comment']) || empty($_POST['r_author'])){
			
				echo "<script>alert('Author or Reply mising');</script>";
			} else {
			
			$cid = $_POST['cid'];
			$reply = $_POST['r_comment'];
			$reply = replace($reply);
			$author = $_POST['r_author'];
			
			
			$STH = $conn->prepare("INSERT INTO reply (cid, reply, author) VALUES (:cid, :reply, :author)");
			$STH->bindParam(':cid', $cid );
			$STH->bindParam(':reply', $reply );
			$STH->bindParam(':author', $author );
			$STH->execute();
				}
		}
	
	       /**
		* Information on each File and Revisions. 
		* Comments and Replies as well.
		*/
		
		foreach ($files as $file) {
		    
		    //Displaying of files
			    echo "<div class='files'>";
			    echo "<h2>" . $file->name . "</h2>";
			    echo "<pre>";
			    echo "File Path: " . $file->path . "<br>";
			    echo "File Type: " . $file->type . "<br>";
			    echo "File Size: " . $file->size . "<br>";
			    echo "</pre>";
			    $sourceCode = $file->path;
			    echo "<a href=$sourceCode target='frame'>View Code!</a>";
			    echo "<h3>Version Details: </h3>";
			    
			//Displays each version of the file
			    foreach ($file->versions as $ver) {
			        
			        echo "<pre>";
			        echo "Revision: " . $ver->revision . "<br>";
			        echo "Author: " . $ver->author . "<br>";
			        echo "Commit Message: " . $ver->msg . "<br>";
			        echo "Date: " . $ver->date . "<br>";
			        echo "</pre>";
			        $count = $count + 1;
			    }
			    echo "</div>";
			    echo "<tr></tr>";
			    
		    //Add a comment Dialog
			    echo "<form action='chess1.php' method='post'>";
			    echo "<div class='files'>";
			    echo "<h4> Add a commment </h4>";
			    echo "Author:  <input type='text' name='author' value=''/> <br>";
			    echo "Comment: <input type='text' name='comment' value=''/> <br>";
			    echo "<input type='submit' name='submit' value='Submit' />";
			    echo "<input name='fname' type='hidden' value='$file->name'/>";
			    echo "</div>";
			    echo "<tr></tr>";
			    echo "</form>";
			   
			    
			    $STH = $conn->prepare("SELECT fid FROM file WHERE name = :name");
			    $STH->bindParam(':name', $file->name );
			    $STH->execute();
			    $row = $STH->fetch();
			    $fid = $row['fid'];
			    
			    $STH = $conn->prepare("SELECT comment, author, cid FROM comment WHERE fid = :fid");
			    $STH->bindParam(':fid', $fid);
			    $STH->execute();
			    
	            //Displaying of comments
			    echo "<div class='files'>";
			    echo "<h3> Comments </h3>";
			    while($row = $STH->fetch()){
			    	echo "<div class='comment'>";
			    	echo "<strong> {$row['author']}:  </strong>";
			    	echo "{$row['comment']} <br><br>";
			    	$cid = $row['cid'];
			    	
			  //Add a reply Dialog
			    	echo "<form action='chess1.php' method='post'>";
			    	echo "Author:  <input type='text' name='r_author' value=''/> <br>";
			    	echo "Reply: <input type='text' name='r_comment' value=''/> <br>";
			    	echo "<input type='submit' name='reply' value='Reply' />";
			    	echo "<input name='cid' type='hidden' value='$cid'/>";
			    	echo "</form>";
			    	
			    	
			    	$STH1 = $conn->prepare("SELECT reply, author FROM reply WHERE cid = :cid");
			   	$STH1->bindParam(':cid', $cid);
			    	$STH1->execute();
			    	
			 //Displaying of Replies
			    	echo "<h3> Replies </h3>";
			    	while($row1 = $STH1->fetch()){    		
			    		echo "<strong> {$row1['author']}:  </strong>";
			    		echo "{$row1['reply']} <br><br>";    	 		
			    	}
			    	echo "</div>";
			    			    	
			    	
			    }
			    echo "</div>";
			    echo "<tr></tr>";
			    		   		    
		}
	?>	
	
	<br><br>	
    </body>

</html>

