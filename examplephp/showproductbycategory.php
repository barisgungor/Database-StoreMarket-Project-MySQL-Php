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

$sql = "SELECT category, product_name, price FROM products ";
$sql .= "where category = '" . $_POST['productcategoryname'] . "'";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
	echo "<table border='1'>";
	echo "<tr><td>CATEGORY</td><td>PRODUCTNAME</td><td>PRICE</td></tr>";
    while($row = $result->fetch_assoc()) {
		echo "<tr>";
		echo "<td>" . $row["category"]. "</td><td>" . $row["product_name"]. "</td><td>" . $row["price"] . "</td>";
		echo "</tr>";
    }
	echo "</table>";
} else {
    echo "0 results";
}
$conn->close();
?>