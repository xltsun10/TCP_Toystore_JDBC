<%-- 
    Document   : details
    Created on : Aug 4, 2023, 4:52:51 PM
    Author     : lequa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>LTM</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/headerfooter.css">
    <link rel="stylesheet" href="styles/main.css">
    <link rel="stylesheet" href="styles/dropdown.css">
    <style>
/*        body {
            font-family: Arial, sans-serif;
            max-width: 1170px;
            margin: 0 auto;
            
        }*/
        .details-book{
            display: flex;
            flex-wrap: wrap;
        }
        .add-order{
            display: flex;
            justify-content: center;
            align-items: center;
            position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
        }

        .details-book h1 {
            padding-top: 20px;
            text-align: center;
        }

        .book {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
        }

        .book img {
            max-width: 300px;
            height: auto;
            margin-right: 10px;
        }

        .book-info {
            flex-grow: 1;
        }

        .book-title {
            font-weight: bold;
        }

        .book-author {
            color: #666;
        }

        .book-price {
            font-weight: bold;
            color: #f00;
        }

        .book-quantity {
            color: #888;
        }
        .add-to-cart {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin-top: 10px;
            cursor: pointer;
        }
        
    </style>
</head>

<body>
    <header>
          
            <ul class="top">
                <li><a class="active" href="/BAITAPLON_LTM/home">Trang chủ</a></li>
                
                <li><form action="search" method="post">Tìm kiếm: <input type="search" name="search" value="" /> 
                        <input class="ulinput" type="submit" name="search" value="Tìm"/></form> </li>

            </ul>
          
          
        </header>
    <div id="wrapper">
        
        <div class="details-book">
        
        <form class=add-order" action="addorder" method="post">
            <div class="headline">
                <h1>Chi tiết đồ chơi</h1>
            </div>
            <div class="book">
                <img src="${listU.image}" alt="Ảnh ">
            <div class="book-info">
                <p class="book-title">${listU.name}</p>
                <p class="book-author">Tuổi: ${listU.age}</p>
                <p class="book-price">Giá: ${listU.price}</p>
                
                
             </div>
    </div>
    </form>
    </div>
    </div>
    
    
    
    
        
    

</body>

</html>
