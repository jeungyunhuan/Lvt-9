package model;

public class Cart {
	public String userId; // 구입한 유저 id
	public String itemName; // 구입한 아이템
	public int index; // 구입한 아이템 idx

	public void print() {
		
		System.out.println("[" + userId + "]" + index + " 아이템 : " + itemName);
	}
	
	
}
