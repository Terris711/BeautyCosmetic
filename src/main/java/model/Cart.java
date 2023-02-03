package model;

import java.util.TreeMap;

public class Cart {
	private TreeMap<Product, Integer> list;
	private long cartID;

	public Cart() {
		list = new TreeMap<>();
		cartID = System.currentTimeMillis();
		// TODO Auto-generated constructor stub
	}

	public Cart(TreeMap<Product, Integer> list) {
		super();
		this.list = list;
		this.cartID = cartID;
	}

	public TreeMap<Product, Integer> getList() {
		return list;
	}

	public void setList(TreeMap<Product, Integer> list) {
		this.list = list;
	}
	

	public long getCartID() {
		return cartID;
	}

	public void setCartID(long cartID) {
		this.cartID = cartID;
	}

	public void addToCart(Product product, int quan) {
		boolean bln = list.containsKey(product);
		if (bln) {
			int temp_quan = list.get(product);
			quan += temp_quan;
			list.put(product, quan);
		} else {
			list.put(product, quan);
		}

	}

	public void subToCart(Product product, int quan) {
		boolean bln = list.containsKey(product);
		if (bln) {
			int temp_quan = list.get(product);
			quan = temp_quan - quan;
			if (quan <= 0) {
				list.remove(product);
			} else {
				list.remove(product);
				list.put(product, quan);
			}

		}
	}

	public void removeToCart(Product product) {
		boolean bln = list.containsKey(product);
		if (bln) {
			list.remove(product);
		}
	}

}
