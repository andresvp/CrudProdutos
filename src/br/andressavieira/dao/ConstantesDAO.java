package br.andressavieira.dao;

public class ConstantesDAO {
	
	public static final String AddProducts = "insert into product(description,datePurchase,image,price,origin,category)"
			+ "values(?,?,?,?,?,?)";
	public static final String ListProducts = "select * FROM product;";
	public static final String ListProductById = "select * from product where id=?;";
	public static final String ListByCategory = "select * from product where category=?;";
	public static final String DeleteProducts = "delete from product where id=?;";
	public static final String UpdateProducts = "update product set description=?, datePurchase=?, image=?, price=?, origin=?, category=?"
			+ "where id=?";
	
}
