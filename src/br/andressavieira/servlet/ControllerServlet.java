package br.andressavieira.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.andressavieira.bean.CategoryEnum;
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
				req.getRequestDispatcher("error.jsp").forward(req, resp);
			}
		
		}catch(NullPointerException e){
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String description = req.getParameter("description");
		String SdatePurchase = req.getParameter("datePurchase");
		String image = req.getParameter("image");
		String Sprice = req.getParameter("price");
		String origin = req.getParameter("origin");
		String Scategory = req.getParameter("category");
		boolean register = false;
		
		try{
			double price = Double.parseDouble(Sprice);
			CategoryEnum category = CategoryEnum.valueOf(Scategory);
			//Converto de String para Date
			DateFormat formatterBrasil = new SimpleDateFormat("DD/MM/YYYY");
			Date dateConvert = (Date) formatterBrasil.parse(SdatePurchase);
			//Formato para o modelo do Banco
			SimpleDateFormat formatBD = new SimpleDateFormat("YYYY-MM-DD");
			String dateFomated = formatBD.format(dateConvert);
			//Converto novamente a String formatada para Date
			//DateFormat formatterEua = new SimpleDateFormat("YYYY-MM-DD");
			Date datePurchase = (Date) formatBD.parse(dateFomated);
			
			Product product = new Product(description,datePurchase,image,price,origin,category); 
			register = ProductDAO.addProduct(product);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(register == false){
			req.getRequestDispatcher("error.jsp").forward(req, resp);
		}else{
			req.getRequestDispatcher("registerProduct.jsp").forward(req, resp);
		}
	}
	}

