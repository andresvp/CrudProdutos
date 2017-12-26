package br.andressavieira.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.andressavieira.bean.Product;
import br.andressavieira.dao.ProductDAO;



public class ControllerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try{
			
			ArrayList<Product> list = ProductDAO.list();
			
			if(!list.isEmpty() && list != null){
				req.setAttribute("product", list);
				req.getRequestDispatcher("listProduct.jsp").forward(req, resp);
			}	
			else{
				req.setAttribute("erro", "É nulo ou vazio!");
				req.getRequestDispatcher("erroLogin.jsp").forward(req, resp);
			}
		
		}catch(NullPointerException e){
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
