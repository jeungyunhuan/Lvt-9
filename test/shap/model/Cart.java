package model;

public class Cart {
	public String userId; // ������ ���� id
	public String itemName; // ������ ������

	public void print() {
		System.out.println("[" + userId + "]" + "������ : " + itemName);
	}
}
