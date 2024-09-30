<%@ page import="java.util.ArrayList, my.app.pack.classes.Resa, my.app.pack.classes.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <style>
        .boite{
            border: solid 1px;
            border-radius: 25px;
            padding: 50px;
        }
    </style>
    <div class="boite">
        <% ArrayList<User> users=(ArrayList<User>)request.getAttribute("users"); %>
        <p>Il y a <%= users.size() %> utilisateurs connectés.</p>
    </div>
    <div class="boite">
        <% ArrayList<Resa> resas=(ArrayList<Resa>)request.getAttribute("resas"); %>
        <table>
            <tr>
                <th>Titre</th>
                <th>Date</th>
                <th>Heure</th>
                <th>Duree</th>
            </tr>
            <% for(Resa resa:resas){ %>
            <tr>
                <td><%= resa.getTitle() %></td>
                <td><%= resa.getDate() %></td>
                <td><%= resa.getHeure() %></td>
                <td><%= resa.getDuree() %></td>
            </tr>    
            <% } %>
        </table>
        <form action="/mim/resalist" method="post">
            <input type="text" name="title">
            <input type="date" name="date-resa">
            <input type="time" name="heure">
            <input type="number" name="duree" min="0" max="60">
            <input type="hidden" name="operation" value="add">
            <input type="submit" value="Envoyer">
        </form>
    </div>
</body>
</html>