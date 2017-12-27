<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>CRUD Product</title>

    <link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="./resources/bootstrap/css/bootstrap-theme.min.css" />
 	<script src="./resources/bootstrap/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container" style="padding-top:40px;">
    	<div class="row">
    		<div class="container">
    			<div class="col-md-8">
    				<h1>Listing Products</h1>
    				<br />
    				<jsp:useBean id="dao" class="java.util.ArrayList" scope="request"/>
	    				<c:forEach var="product" items="${product}">
	    				<div class="col-md-4">
	    					<label>${product.description}</label>
	    					<a href="DeleteProduct?action=Delete&id=${product.id}" >[X]</a>
	    					<a href="UpdateProduct?id=${product.id}">Editar</a>
	    					<br />
	    					<img width="100" height="100" src="${product.image}"/>
	    					<br />
	    					<div>
	    					<label>Date Purchase:</label>
	    					<fmt:formatDate pattern="DD/MM/YYYY" value="${product.datePurchase}"/>
	    					<label>Price:</label>
	    						${product.price}
	    					</div>
	    					<div>
	    					<label>Origin:</label>
	    						${product.origin}
	    					</div>
	    					<div>
	    					<label>Category:</label>
	    					<option value="${product.category}">${product.category.getValue()}</option>
	    					</div>
	    					<br />
	    				</div>
	    				</c:forEach>
    			</div>
    			
    			<div class="form-group">
    			<a href="registerProduct.jsp">Cadastrar Produtos</a>
    			</div>
		    	
		    	<div class="form-group">
  						<label for="sel1">Filter by category:</label>
							    <a href="ProductsByCategory?category=ELETRONICOS">ELETRONICOS</a>
							    <a href="ProductsByCategory?category=LIVROS">LIVROS</a>
							    <a href="ProductsByCategory?category=MUSICA">MUSICA</a>
							    <a href="ProductsByCategory?category=ACESSORIOS">ACESSORIOS</a>
							    <a href="ProductsByCategory?category=CELULARES">CELULARES</a>
							    <a href="ProductsByCategory?category=OUTROS">OUTROS</a>
					</div>
		    	
	    		
    			
    		</div>
    	</div>
    </div>
    
  <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="./resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>