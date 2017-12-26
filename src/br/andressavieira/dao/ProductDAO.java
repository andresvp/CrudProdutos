package br.andressavieira.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import br.andressavieira.bean.CategoryEnum;
import br.andressavieira.bean.Product;
import br.andressavieira.factory.FactoryCon;



public class ProductDAO {
	
	//Funcionalidade para cadastrar produtos.
	public static boolean addProduct(Product product){
		Connection conn = FactoryCon.openConnection();
		if(conn != null){
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return false;
	}
	
	public static void addProduct(ArrayList<Product> products){
		
	}

	//Funcionalidade para listar os produtos.
	public static ArrayList<Product> list() {
		Connection conn = FactoryCon.openConnection();
		ArrayList<Product> product = new ArrayList<Product>();
		if(conn != null){
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(ConstantesDAO.ListProducts);
				while (rs.next()) {
					product.add(new Product( rs.getString("description"),
							rs.getString("image"),
							Double.parseDouble(rs.getString("price")),
							rs.getString("origin"),
							CategoryEnum.valueOf(rs.getString("category"))
							));
				}
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return product;
	}
	
	public ArrayList<Product> getList(){
		return list();
	}
	
	//Funcionalidade que lista os produtos de acordo com a categoria.
	public static ArrayList<Product> listByCategory() {
		ArrayList<Product> productByCategory = new ArrayList<Product>();
		return productByCategory;
	}
	
	
	public ArrayList<Product> getListByCategory(){
		return listByCategory();
	}
	
	
	//Funcionalidade para excluir produtos.
	public static void delete(int id){
		
	}
	
	//Funcionalidade para editar/atualizar informações dos produtos.
	public static void update(int id){
		
	}


}
