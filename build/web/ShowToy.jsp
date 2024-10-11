
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ToyStore</title>
    </head>
    <body>
        <form>
            <table border="Black">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Type</th>
                        <th>name</th>
                        <th>age</th>
                        <th>image</th>
                        <th>price</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listB}" var="x">
                        <tr>
                            <td>${x.id}</td>
                            <td>${x.idType}</td>
                            <td>${x.name}</td>
                            <td>${x.age}</td>
                            <td><img style="width: 50px; height: 50px" src="${x.image}" /></td>
                            
                            <td>${x.price}</td>
<!--                            <td>
                                <a href="deleteBook?sid=${x.id}">delete</a>
                                <a href="updateBook?sid=${x.id}">update</a>
                            </td>-->
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="AddBook.jsp">Add Book</a>
            <a href="/BAITAPLON_LTM/home"
            <a href="index.jsp"><input type="button" value="Quay Lại" /></a>
        </form>
    </body>
</html>
