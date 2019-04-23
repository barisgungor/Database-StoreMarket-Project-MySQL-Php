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

$sql = "SELECT customer_id, customer_name FROM customers";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
	echo "<table border='1'>";
	echo "<tr><td>ID</td><td>NAME</td></tr>";
    while($row = $result->fetch_assoc()) {
		echo "<tr>";
        echo "<td>" . $row["customer_id"]. "</td><td>" . $row["customer_name"]. "</td>";
		echo "</tr>";
    }
	echo "</table>";
} else {
    echo "0 results";
}
$conn->close();
?>