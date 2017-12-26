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
    				<jsp:useBean id="dao" class="br.andressavieira.dao.ProductDAO"/>
	    				<c:forEach var="product" items="${dao.list}">
	    					${product.description}
	    					${product.datePurchase}
	    					${product.image}
	    					${product.price}
	    					${product.origin}
	    					<!--${product.category.getValue()} -->
	    				</c:forEach>
    			</div>
    			<div class="form-group">
				    	<a href="registerProduct.jsp">Cadastrar Produtos</a>
				    </div>
    		</div>
    	</div>
    </div>
    
  <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="./resources/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>