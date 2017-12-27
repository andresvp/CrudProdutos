package br.andressavieira.bean;

import java.text.NumberFormat;
import java.util.Date;

import br.andressavieira.bean.CategoryEnum;

public class Product {
	
	private int id;
	private String description;
	private Date datePurchase;
	private String image;
	private double price;
	private String origin;
	private CategoryEnum category;
	
	public double convertDolar(){
		double result = this.price/3.599;
		NumberFormat format = NumberFormat.getInstance();
		format.setMaximumFractionDigits(3);
		result = Double.valueOf(format.format(result));
		return result;	
	}
	
	public Product(){
		
	}
	
	public Product(String description,Date datePurchase, String image, double price, String origin ){
		setDescription(description);
		setDatePurchase(datePurchase);
		setImage(image);
		setPrice(price);
		setOrigin(origin);
		setCategory(category);
	}
	
	public Product(String description, Date datePurchase, String image, double price, String origin, CategoryEnum category ){
		setDescription(description);
		setDatePurchase(datePurchase);
		setImage(image);
		setPrice(price);
		setOrigin(origin);
		setCategory(category);
	}
	
	public Product(int id,String description, Date datePurchase, String image, double price, String origin, CategoryEnum category ){
		setId(id);
		setDescription(description);
		setDatePurchase(datePurchase);
		setImage(image);
		setPrice(price);
		setOrigin(origin);
		setCategory(category);
	}
	
	
	
	@Override
	public String toString() {
		return "Product [category=" + category + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDatePurchase() {
		return datePurchase;
	}
	public void setDatePurchase(Date datePurchase) {
		this.datePurchase = datePurchase;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public CategoryEnum getCategory() {
		return category;
	}
	public void setCategory(CategoryEnum category) {
		this.category = category;
	}
	

}
