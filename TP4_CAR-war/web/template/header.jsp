<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CAR Java EE TP</title>
        <style>
            table, th, td {
                border : 1px solid;
                border-collapse: collapse;
                padding : 7px;
                margin-bottom: 10px;
            } 
            #header ul {
                padding:0;
                margin:0;
                list-style-type:none;
            }
            #header li {
                margin-left:2px;
                display:inline-block;
                min-width:100px;
                text-align:center;
            }
            #header ul li a {
                color:black;
                text-decoration:none;
                padding:5px;
            }
            #header ul li a:hover {
                background-color:#D3D3D3;
                border-color:#696969 #DCDCDC #DCDCDC #696969;
                border-radius: 5px;
            } 
            hr {
                clear : both;
                border-top : 1px solid;
                border-bottom : 0px;
            }
            #header {
                margin: auto;
            }
        </style>
    </head>
    <body>
        <div id="header">
            <ul>
                <li><a href="http://localhost:8080/TP4_CAR-war/">Index</a></li>
                <li><a href="http://localhost:8080/TP4_CAR-war/authors">List of Authors</a></li>
                <li><a href="http://localhost:8080/TP4_CAR-war/initBook">Init database</a></li>
                <li><a href="http://localhost:8080/TP4_CAR-war/DisplayCart">Show cart</a></li>
                <li><a href="http://localhost:8080/TP4_CAR-war/displayOrders">All orders</a></li>
            </ul>
        </div>
        <hr />
