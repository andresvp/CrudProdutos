package br.andressavieira.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.andressavieira.bean.CategoryEnum;
import br.andressavieira.bean.Product;
import br.andressavieira.dao.ProductDAO;


public class ProductsByCategory extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String Scategory = req.getParameter("category");
		
		try{
			CategoryEnum category = CategoryEnum.valueOf(Scategory);
			ArrayList<Product> listByCategory = ProductDAO.listByCategory(category);
			req.setAttribute("product", listByCategory);
			req.getRequestDispatcher("listProductByCategory.jsp").forward(req, resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
