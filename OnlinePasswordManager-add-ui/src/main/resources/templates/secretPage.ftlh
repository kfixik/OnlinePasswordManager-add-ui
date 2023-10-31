<!DOCTYPE html>
<html>
<head>
    <title>Create Secret</title>
</head>
<body>
<form action="/secret/save/${secret.id}" method="post">
    Secret name: <input type="text" name="name" value="${secret.name}"/><br><br>
    <input type="submit" value="save">
</form>
<form action="/secret/delete/${secret.id}" method="post">
    <input type="submit" value="delete">
</form>
</body>
</html>