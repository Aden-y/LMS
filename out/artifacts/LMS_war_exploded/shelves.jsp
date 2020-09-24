<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/24/2020
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>

<body>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title color-primary">Shelves</h4>
    <div class="row">
        <div class="col s12 m8 l8">
            <h6 class="title color-primary">Displaying shelves for some campus</h6>
            <div class="input-field">
                <select name="CampusNo">
                    <option value="" disabled selected>Select Campus</option>
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                </select>
                <label>Choose campus to display shelves</label>
            </div>
            <table class="highlight">
                <thead>
                <tr>
                    <th>Shelf No</th>
                    <th>Floor No</th>
                    <th>Campus</th>
                    <th>Books Count</th>
                </tr>
                </thead>

                <tbody>
                <tr>
                    <td>Alvin</td>
                    <td>Eclair</td>
                    <td>$0.87</td>
                    <td>Eclair</td>
                </tr>

                </tbody>
            </table>
        </div>
        <div class="col s12 m4 l4">
            <h6 class="title color-primary">Create new shelf</h6>
            <form method="post" action="shelves">
                <div class="input-field">
                    <select name="CampusToDisplay">
                        <option value="" disabled selected>Select Campus</option>
                        <option value="1">Option 1</option>
                        <option value="2">Option 2</option>
                        <option value="3">Option 3</option>
                    </select>
                    <label>Campus</label>
                </div>
                <div class="input-field">
                    <input name="ShelfNo" id="ShelfNo" class="value" type="number" min="1" required>
                    <label for="ShelfNo">Shelf Number</label>
                </div>

                <div class="input-field">
                    <input name="FloorNo" id="FloorNo" class="value" type="number" min="1" required>
                    <label for="FloorNo">Floor Number</label>
                </div>

                <div class="input-field">
                    <input type="submit" class="btn-small pink darken-4" name="NewShelf" value="Create Shelf">
                </div>
            </form>
        </div>

    </div>
</div>
<script>
    $(document).ready(function(){
        $('select').formSelect();
    });
</script>
</body>
</html>
