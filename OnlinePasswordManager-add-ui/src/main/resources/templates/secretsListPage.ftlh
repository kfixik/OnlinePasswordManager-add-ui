<!DOCTYPE html>
<html>
<head>
    <title>Space Secret</title>
    <style>
        .spacesDiv{
                background: white;
                border-width: thin;
                border-style: solid;
                border-color: black;
                position: absolute;
                right: 50%;
                left: 0%;
                padding: 8px;
                margin: 8px;
        }
        .secretsDiv{
                background: white;
                border-width: thin;
                border-style: solid;
                border-color: black;
                position: absolute;
                left: 50%;
                right: 0%;
                padding: 8px;
                margin: 8px;
        }
        .itemSpace{
            text-decoration: none;
            color: black;
        }
    </style>
</head>
<body>
<h1>Secrets</h1><hr>
<div class="spacesDiv">
    <#list spaces as space>
    <div>
        <p><a href="/spaceSecret/${space.id}" class="itemSpace">${space.name}</a></p>
    </div>
</
#list>
</div>
<div class="secretsDiv">
    <#list secrets as secret>
    <div>
        <p><b>${secret.name}</b> | <a href="/secret/${secret.id}">Details</a></p>
    </div>
</
#list>
<form action="/spaceSecret/createSecret" method="get">
    <input type="submit" value="Create new Secret"/>
</form>
</div>
</body>
</html>