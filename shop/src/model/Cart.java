package model;

public class Cart {
	public String userId; // ������ ���� id
	public String itemName; // ������ ������
	public int index; // ������ ������ idx

	public void print() {
		
		System.out.println("[" + userId + "]" + index + " ������ : " + itemName);
	}
	
	
}
