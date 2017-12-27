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
    		<div class="container fileinput">
    		<div class="col-md-8">
				<h1>Register Product</h1>
				<br />
				<form method="post" action="ControllerServlet" >
				
				<input type="hidden" id="id "name="id" value=" <c:out value="${product.id}"/> "/> 
					
					<div class="form-group">
                    	<label for="description" class="col-sm-2 control-label">Description:</label>
				        	<textarea class="form-control" id="description" rows="2"
                            		  name="description" ><c:out value="${product.description}"/></textarea>
                    </div>
					
                    <div class="form-group">
                    	<label for="datePurchase" class="col-sm-2 control-label">DatePurchase:</label>
				        	<input type="date" class="form-control" id="dataPurchase"
                            		  name="datePurchase" value=" <c:out value="${product.datePurchase}"/> "/>
                    </div>
                    
                    <div class="form-group">
                    	<label for="price" class="col-sm-2 control-label">Price:</label>
				        	<input type="number" class="form-control" id="price"
                            		  name="price" value=" <c:out value="${product.price}"/> "/>
                    </div>
                    
                    <div class="form-group">
                    	<label for="origin">Origin:</label>
	                    <div>
			                    <label class="col-sm-2 control-label">
			      					<input type="radio" name="origin" value="Nacional" /> National
			      				</label>
			      				<label>
			      					<input type="radio" name="origin" value="Importado"/> Imported
			    				</label>
	                    </div>
                    </div>
                      
                    <div class="form-group">
  						<label for="sel1">Select category:</label>
		  					<select class="form-control" id="category" name="category" >
		    					<option value="ELETRONICO">Eletrônicos</option>
							    <option value="LIVROS">Livros</option>
							    <option value="MUSICA">Música</option>
							    <option value="ACESSORIOS">Acessórios</option>
							    <option value="CELULARES">Celulares</option>
							    <option value="OUTROS">Outros</option>
		  					</select>
					</div>
                    
                    <label for="image">Image:</label>
				        <input type="file" id="image" name="image" span=>
				        <span class="fileinput-filename"><c:out value="${product.image}"/> </span>
				    <br />
				    <br />

				    <div class="form-group">
				    	<button type="submit" value="cadastrar" class="btn btn-primary ">Cadastrar</button>
				    </div>

				       
                </form>
                <div class="form-group">
				    	<a class="btn btn-primary" href="listProduct.jsp" role="button">Listar Produtos</a>
				    </div>
             </div>
             </div>
         </div>
    </div>
    
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="./resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>