package model;

public class Item {
	public String name;
	int price;
	public String category; // ī�װ� // ���� , ���� , ��� , ���� ���

	public Item(String na, int pr, String cate) {
		name = na;
		price = pr;
		category = cate;
	}

	public void print() {
		System.out.println("[" + name + "]" + "[" + price + "]" + "[" + category + "]");
	}
}