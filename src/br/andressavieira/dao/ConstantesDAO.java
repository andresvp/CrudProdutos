package br.andressavieira.dao;

public class ConstantesDAO {
	
	public static final String AddProducts = "insert into product(description,datePurchase,image,price,origin,category)"
			+ "values(?,?,?,?,?,?)";
	public static final String ListProducts = "select * FROM product;";
	public static final String ListProductsByCategory = "";
	public static final String DeleteProducts = "";
	public static final String UpdateProducts = "";
	
}
