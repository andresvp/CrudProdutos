package br.andressavieira.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.andressavieira.dao.ProductDAO;

public class DeleteProduct extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String action = req.getParameter("action");
		String Sid = req.getParameter("id");
		
		try{
			int id = Integer.parseInt(Sid);
				if(action.equalsIgnoreCase("Delete")){
					ProductDAO.delete(id);
				}
				req.getRequestDispatcher("listProduct.jsp").forward(req, resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
