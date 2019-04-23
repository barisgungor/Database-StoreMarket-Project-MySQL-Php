<!DOCTYPE html>
<html>
<body>
<form action="showproductbycategory.php" method="post">
<?php
$servername = "localhost";
$username = "root";
$password = "mysql";
$dbname = "store";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "SELECT DISTINCT category FROM products";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
	echo "<select name='productcategoryname'>";
    while($row = $result->fetch_assoc()) {
        echo "<option value='" . $row["category"]. "'>" . $row["category"]. "</option>";
    }
	echo "</select>";
} else {
    echo "0 results";
}
$conn->close();
?>
<input type="submit" value="Submit">
</form> 
</body>
</html>