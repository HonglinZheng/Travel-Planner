<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Share Trip</title>
</head>
<body>
<h1 style="color: red">${neg}</h1>
<h1 style="color: green">${pos}</h1>
<form action="/trip/share/${id}" method="post">
    Enter Email: <input type="text" name="email" required>
    <button>Submit</button>
</form>
<br>
<a href="/trip/home"><button>Back</button></a>
</body>
</html>
