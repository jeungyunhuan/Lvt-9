package samplely;

import java.util.Scanner;
import java.util.Vector;

class Tv {
	private String name;
	private String brand;
	private int price;

	Tv(String name, String brand, int price) {
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

	public String getName() {
		return this.name;
	}
	public void printInfo() {
		System.out.printf("name:%s brand:%s price:%d",this.name,this.brand,this.price);
		System.out.println();
	}

}

public class review {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Vector<Tv> arr = new Vector<>();

		while (true) {
			int x = 0;
			// ��ü ������ ���
			// �߰�, ����, ����, ����(��), ��ȸ, ����, ũ��
			for(int i =0; i<arr.size();i++) {
				System.out.print("index : "+i);
				arr.get(i).printInfo();
			}
			System.out.println();
			System.out.println("�߰�, ����, ����, ����(��), ��ȸ, ����, ũ��");
			System.out.println("�Է�:");
			int sel = scan.nextInt();
			if (sel == 1) {

				System.out.println("name:");
				String name = scan.next();
				System.out.println("brand:");
				String brand = scan.next();
				System.out.println("price:");
				int price = scan.nextInt();
				for (int i = 0; i < arr.size(); i++) {
					if (arr.get(i).getName().equals(name)) {
						x++;
					}
				}
				if (x == 0) {
					arr.add(new Tv(name, brand, price));
					System.out.println("����");
				} else {
					System.out.println("�ߺ��̸�����");
				}
			} else if (sel == 2) {
				System.out.println("�����ϰ���� �ε��� ����:");
				int index = scan.nextInt();
				System.out.println("name:");
				String name = scan.next();
				System.out.println("brand:");
				String brand = scan.next();
				System.out.println("price:");
				int price = scan.nextInt();
				for (int i = 0; i < arr.size(); i++) {
					if (arr.get(i).getName().equals(name)) {
						x++;
					}
				}
				if (x == 0) {
					arr.add(index,new Tv(name, brand, price));
					System.out.println("����");
				} else {
					System.out.println("�ߺ��̸�����");
				}
			} else if (sel == 3) {
				System.out.print("�����ϰ���� �ε��� ����:");
				int index =  scan.nextInt();
				arr.remove(index-1);
				

			} else if (sel == 4) {
				System.out.println("�����ϰ� ���� �� ����name:");
				String name = scan.next();
				System.out.println("�����ϰ� ���� �� ����brand:");
				String brand = scan.next();
				System.out.println("�����ϰ� ���� �� ����price:");
				int price = scan.nextInt();
				arr.remove(name); //����
				

			} else if (sel == 5) {

			} else if (sel == 6) {
				

			} else if (sel == 7) {

			} else if (sel == 8) {

			}

		}

	}
}