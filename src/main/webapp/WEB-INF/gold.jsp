<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<h1 class="text-center font-weight-bold text-warning">Ninja Gold Game</h1>
        <div class="d-flex justify-content-around">
            <h5 class="container ml-5 text-warning">Your Gold: <c:out value="${gold}"/></h5>
            <form action="/reset">
                <button type="submit" class="btn btn-danger shadow ">Reset</button>
            </form>
        </div>
        <div class="container d-flex justify-content-around mb-5 mt-5">
            <div class="d-flex flex-column text-center bg-light rounded p-5 shadow">
                <h4>Farm</h4>
                <p>(Earns 10-20 gold)</p>
                <form action="/processgold" method="POST">
                    <input type="hidden" name="gold_acquisition_method" value="farm">
                    <button type="submit" class="btn btn-warning shadow">Find Gold!</button>
                </form>
            </div>
            <div class="d-flex flex-column text-center bg-light rounded p-5 shadow">
                <h4>Cave</h4>
                <p>(Earns 5-10 gold)</p>
                <form action="/processgold" method="POST">
                    <input type="hidden" name="gold_acquisition_method" value="cave">
                    <button type="submit" class="btn btn-warning shadow">Find Gold!</button>
                </form>
            </div>
            <div class="d-flex flex-column text-center bg-light rounded p-5 shadow">
                <h4>House</h4>
                <p>(Earns 2-5 gold)</p>
                <form action="/processgold" method="POST">
                    <input type="hidden" name="gold_acquisition_method" value="house">
                    <button type="submit" class="btn btn-warning shadow">Find Gold!</button>
                </form>
            </div>
            <div class="d-flex flex-column text-center bg-light rounded p-5 shadow">
                <h4>Casino</h4>
                <p>(Earns or loses 0-50 gold)</p>
                <form action="/processgold" method="POST">
                    <input type="hidden" name="gold_acquisition_method" value="casino">
                    <button type="submit" class="btn btn-warning shadow">Find Gold!</button>
                </form>
            </div>
        </div>
        <h5 class="text-warning">Activities:</h5>
        <div id="log" class="bg-light rounded activities">
            <c:forEach items="${activity}" var="event">
                  	<c:out value="${event}" escapeXml="false" />
            </c:forEach>
        </div>
</body>
</html>