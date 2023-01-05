package model;

public class Product {
	private int id;
	private String name;
	private String imageUrl;
	private String packageSize;
	private String description;
	private double unitPrice;
	private Brand brand;
	private String lotNumber;
	private Category category;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	
	
	
}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getPackageSize() {
		return packageSize;
	}
	public void setPackageSize(String packageSize) {
		this.packageSize = packageSize;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPice) {
		this.unitPrice = unitPice;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public String getLotNumber() {
		return lotNumber;
	}
	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Product(int id, String name, String imageUrl, String packageSize, String description, double unitPrice,
			Brand brand, String lotNumber, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.packageSize = packageSize;
		this.description = description;
		this.unitPrice = unitPrice;
		this.brand = brand;
		this.lotNumber = lotNumber;
		this.category = category;
	}
}
