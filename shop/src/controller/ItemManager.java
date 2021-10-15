package controller;

import java.util.Scanner;
import java.util.Vector;

import model.Item;
import model.User;
import model.Cart;

public class ItemManager {
	Scanner scan = new Scanner(System.in);
	Vector<String> category = new Vector<String>();
	Vector<Item> itemList = new Vector<Item>(); // 전체 아이템리스트
	Vector<Cart> jangList = new Vector<Cart>(); // 전체 장바구니

	public ItemManager() {
		init();
		
	}

	void init() {
		category.add("과자");
		category.add("생선");
		category.add("육류");
		category.add("음료수");
		Item temp = new Item("새우깡", 1000, category.get(0));
		itemList.add(temp);
		temp = new Item("고등어", 2000, category.get(1));
		itemList.add(temp);
		temp = new Item("칸쵸", 3600, category.get(0));
		itemList.add(temp);
		temp = new Item("소고기", 6500, category.get(2));
		itemList.add(temp);
		temp = new Item("콜라", 500, category.get(3));
		itemList.add(temp);
		temp = new Item("새우", 1800, category.get(1));
		itemList.add(temp);
	}
	public int categorySize() {
		return category.size();
	}
	public int itemSize(int category) {
		return this.category.get(category).length();
		
	}

	public void purchase(User u) {
		System.out.println("현재 구입한 품목\n------------");
		printJang(u);
		int fee = 0;
		
		for (int i = 0; i < itemList.size(); i++) {
			for (int j = 0; j < jangList.size(); j++) {
				if (jangList.get(j).itemName.equals(itemList.get(i).name)) {
					fee += itemList.get(i).price;
				
				}
			}
		}
		
		System.out.printf("현재 요금은 %d원입니다", fee);
		System.out.println();
		purchaseRemove(u);
	}
	public void purchaseRemove(User u) {
		int[] x;
		int y =0;
		y++;
		for (int i = 0; i < jangList.size(); i++) {
			if (u.id.equals(jangList.get(i).userId)) {
				y++;
			}
		}
		x = new int[y];
		int g = 0;
		for (int i = 0; i < jangList.size(); i++) {
			if (u.id.equals(jangList.get(i).userId)) {
				x[g]=i;
				g++;
			}
		}
		g=0;
		for(int i =0;i<x.length;i++) {
			jangList.remove(x[i-g]);
			g++;
		}
	}

	void printJang() {
		for (int i = 0; i < jangList.size(); i++) {
			jangList.get(i).print();
		}
	}

	public void printJang(User u) {
		for (int i = 0; i < jangList.size(); i++) {
			if (u.id.equals(jangList.get(i).userId)) {
				System.out.print("index:" + i + " ");
				jangList.get(i).print();
			}
		}
	}

	public void removeItem(int index) {
		jangList.remove(index);
	}

	public void printCategory() {
		for (int i = 0; i < category.size(); i++) {
			System.out.println("[" + i + "] " + category.get(i));
		}
	}

	public void printItemList() {
		for (int i = 0; i < itemList.size(); i++) {
			System.out.print("[" + i + "]");
			itemList.get(i).print();
		}
	}

	public void printItemList(int caID) {
		int n = 0;
		for (int i = 0; i < itemList.size(); i++) {
			if (category.get(caID).equals(itemList.get(i).category)) {
				System.out.print("[" + n + "]");
				itemList.get(i).print();
				n += 1;
			}
		}
	}

	public void addItem() {
		System.out.println("[아이템추가] 아이템이름을 입력하세요.");
		String name = scan.next();
		System.out.println("[아이템추가] 가격을 입력하세요. ");
		int price = scan.nextInt();
		printCategory();
		System.out.println("[아이템추가] 카테고리를 입력하세요. ");
		int sel = scan.nextInt();
		Item temp = new Item(name, price, category.get(sel));
		itemList.add(temp);
	}

	public void addCategory() {
		System.out.println("[카테고리추가] 카테고리 이름을 입력하세요. ");
		String name = scan.next();
		category.add(name);
	}

	public void addCart(String usID, int caID, int itemID) {
		int n = 0;
		Cart temp = new Cart();
		temp.userId = usID;
		temp.index++;
		for (int i = 0; i < itemList.size(); i++) {
			if (category.get(caID).equals(itemList.get(i).category)) {
				if (itemID == n) {
					temp.itemName = itemList.get(i).name;
				}
				n += 1;
			}
		}
		jangList.add(temp);
	}

	public void printCart() {
		for (int i = 0; i < jangList.size(); i++) {
			if (i < jangList.size() - 1) {
				if (jangList.get(i).userId.equals(jangList.get(i + 1).userId)) {
					jangList.get(i).print();
				} else {
					jangList.get(i).print();
					System.out.println("--------------");
				}
			} else {
				jangList.get(i).print();
			}
		}
	}

	public void itemRemove() {
		System.out.println("삭제할 아이템 카테고리");
		printCategory();
		int sel = scan.nextInt();
		System.out.println("삭제할 아이템");
		printItemList(sel);
		sel = scan.nextInt();
		itemList.remove(sel);
	}

	public void categoryRemove() {
		System.out.println("삭제할 카테고리 입력:");
		printCategory();
		int sel = scan.nextInt();
		category.remove(sel);
	}

	public void categoryAdd() {
		System.out.println("추가할 카테고리 입력:");
		printCategory();
		String name = scan.next();
		category.add(name);
	}

	public void cartArr() {
//		 String[] id = new String[jangList.size()];
//		 String[] item = new String[jangList.size()];
//		 for(int i =0; i<jangList.size();i++) {
//			 id[i]=jangList.get(i).userId;
//			 item[i]=jangList.get(i).itemName;
//		 }
//		while(true) {
//			int a = 0;
//			for (int i = 0; i < jangList.size(); i++) {
//				if(id[i]!=id[i+1]) {
//					id[i]
//				}
//			}	
//		}
//		
	}
}