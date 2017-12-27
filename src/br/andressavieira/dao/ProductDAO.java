package br.andressavieira.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
				PreparedStatement instruction = conn.prepareStatement(ConstantesDAO.AddProducts);
				instruction.setString(1, product.getDescription());
				instruction.setDate(2, new java.sql.Date(product.getDatePurchase().getTime()));
				instruction.setString(3, product.getImage());
				instruction.setDouble(4, product.getPrice());
				instruction.setString(5, product.getOrigin());
				instruction.setString(6, product.getCategory().toString());
				instruction.execute();
				FactoryCon.closeConnection(conn);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
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
					product.add(new Product( rs.getInt("id"), 
							rs.getString("description"),
							rs.getDate("datePurchase"),
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
	
	//Funcionalidade para procurar somente 1 produto de acordo com seu id. 
	//PS: Usado para recuperar os valores para Edição de produtos. 
	public static Product productById(int id){
		Connection conn = FactoryCon.openConnection();
		Product product = new Product();
		if(conn != null){
			try {
				PreparedStatement pstmt = conn.prepareStatement(ConstantesDAO.ListProductById);
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					product.setId(Integer.parseInt(rs.getString("id")));
					product.setDescription(rs.getString("description"));
					product.setDatePurchase(rs.getDate("datePurchase"));
					product.setImage(rs.getString("image"));		
					product.setPrice(Double.parseDouble(rs.getString("price")));		
					product.setOrigin(rs.getString("origin"));
					product.setCategory(CategoryEnum.valueOf(rs.getString("category")));		
				}
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return product;
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
		Connection conn = FactoryCon.openConnection();
		if(conn != null){
			try{
				PreparedStatement instrucao = conn.prepareStatement(ConstantesDAO.DeleteProducts);
				instrucao.setInt(1, id);
				instrucao.execute();
				instrucao.close();
				FactoryCon.closeConnection(conn);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
	}
	
	//Funcionalidade para editar/atualizar informações dos produtos.
	public static void update(Product product){
		Connection conn = FactoryCon.openConnection();
		if(conn != null){
			try{
				PreparedStatement instruction = conn.prepareStatement(ConstantesDAO.UpdateProducts);
				instruction.setString(1, product.getDescription());
				instruction.setDate(2, new java.sql.Date(product.getDatePurchase().getTime()));
				instruction.setString(3, product.getImage());
				instruction.setDouble(4, product.getPrice());
				instruction.setString(5, product.getOrigin());
				instruction.setString(6, product.getCategory().toString());
				instruction.setInt(7, product.getId());
				instruction.execute();
				instruction.close();
				FactoryCon.closeConnection(conn);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}


}
