<%-- 
    Document   : index
    Created on : Oct 6, 2017, 10:05:18 AM
    Author     : dbb09
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vending Machine</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container-fluid">
            <h1 style="text-align: center">
                Vending Machine</h1>
            <ul class="list-group" id="errors">
            </ul>
            <hr/>
           
            <div class="col-md-8 column" id="itemsDiv" style="text-align: center">
                <!--itemsDiv loaded from js - DEPRECATED-->
                <c:forEach var="itemsArray" items="${items}">
                    <div onclick="displayItem(${itemsArray.id})" class="col-md-3 col-md-offset-1" style='border: 1px solid black; padding-top: 12px; padding-right: 2px; padding-bottom: 12px; padding-left: 12px; margin: 12px 12px; cursor: pointer'>
                        ${itemsArray.id}
                        <br/><br/>
                        ${itemsArray.name}
                        <br/><br/>
                        ${itemsArray.price}
                        <br/><br/>
                        ${itemsArray.quantity}
                    </div>
                </c:forEach>
            </div>
            <div class="col-md-4 column" id="buttonsDiv">
                <div id="totalIn" class="col-md-12 row">
                    <h2>Total $ In</h2>
                    <input type="number" value="0.00" id="moneyIn" value="${userBalance}" readonly><br/>
                    <div class="btn-group">
                        <button type="button" id="addDollar" class="btn btn-default">Add Dollar</button>
                        <button type="button" id="addQuarter" class="btn btn-default">Add Quarter</button>
                        <br/><br/>
                        <button type="button" id="addDime" class="btn btn-default" style="padding-right: 15px;padding-left: 15px">Add dime</button>
                        <button id="addNickel" class="btn btn-default" style="padding-right: 18px;padding-left: 16px">Add Nickel</button>
                    </div>
                    <hr/>
                </div>
                <div id="messages" class="col-md-12 row">
                    <div>
                        <h2>Messages</h2>
                        <input type="text" id="messageOut" value="${message}" readonly style="padding-left: 37px"><br/>
                    </div>
                    <div>
                        <label for="itemOut">Item:</label>
                        <input type="number" id="itemOut" min="0" readonly>
                    </div>
                    <div>
                        <button id="makePurchase" class="btn btn-default">Make Purchase</button>
                        <hr/>
                    </div>
                </div>
                <div id="change" class="col-md-12 row">
                    <div>
                        <h2>Change</h2>
                        <input type="text" id="changeOut" name="changeOut" value="${change}" readonly>
                    </div>
                    <div>
                        <button type="button" class="btn btn-default" id="returnChange">Change Return</button>
                    </div>
                    <hr/>
                </div>
                <hr/>
            </div>
        </div>
        <!--scripts at bottom to load page faster-->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/index.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
