<!-- Contains all information for Chess 1.0 -->

<!DOCTYPE html>
<html>
<head>
<style>
div.container {
    width: 100%;
    border: 1px solid gray;
}

header{
    padding: 1em;
    color: white;
    background-color: #645570;
    clear: left;
    text-align: center;
}


body {
    background-color: #b0e0e6;
}

div.overview {

display: inline-block;
background-color: #996969;
margin: 20px 0 20px 0;
 padding: 20px;
 float: left;
}

div.files {

display: inline-block;
background-color: #D3D3D3;
margin: 20px 0 20px 0;
 padding: 20px;
 float: left;
 clear: left;
}



</style>
</head>

<body>

<div class="container">

<header>
   <h1>Chess 1.0 </h1>
</header>
  



</div>

</body>
	<!-- Project Overview -->
	
	<div class="overview">
	<h2>Project Overview</h2>
	<?php
		include "project.php";
		
		$data = new Parse("Assignment1.0");
		
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
	<iframe name='frame' src=''></iframe>
	</div>
	
		 	  
<?php
/*
* Information on each File and Revisions
*/

foreach ($files as $file) {
    
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
}
?>	
	
	<br><br>	
    </body>

</html>

