<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>
        <title>ToyStore</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/headerfooter.css">
        <link rel="stylesheet" href="styles/main.css">
        <link rel="stylesheet" href="styles/dropdown.css">
    </head>

    <body>
        <header>
          
            <ul class="top">
                <li><a class="active" href="/BAITAPLON_LTM/home">Trang chủ</a></li>
                
                <li><form action="search" method="post">Tìm kiếm: <input type="search" name="search" value="" /> 
                        <input class="ulinput" type="submit" name="search" value="Tìm"/></form> </li>

                

            </ul>
          
          
        </header>
                <!-- List books -->
        <div id="wrapper">
            <div class="headline">
                <h3>DAnh sách các đồ chơi</h3>
            </div>
            
            <div class="products">
                
                <c:forEach items="${listB}" var="x" >
                    <div class="product-item">
                        
                        <div class="product-top">
                            <a href="" class="product-thump">
                                <img src="${x.image}" alt="anh" href="detailsBook?sid=${x.id}">
                            </a>
                            <!-- Mua ngay -->
                            <a href="detailsToy?sid=${x.id}" class="buy-now">Chi tiết</a>
                        </div>
                        <div class="product-infor">
                            
                            <a href="" class="product-name">${x.name}</a>
                            <a href="" class="product-author">Tuổi: ${x.age}</a>
                            <div class="product-price">Giá: ${x.price}đ</div>
                        </div>
                        
                    </div>
                </c:forEach>


            </div>
            
        </div>
<!--        Main-->
        
        
        

    </body>

</html>