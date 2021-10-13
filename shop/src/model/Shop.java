package model;

import java.util.Scanner;
import java.util.Vector;

import model.Item;
import controller.ItemManager;
import controller.UserManager;

public class Shop {
	Scanner scan = new Scanner(System.in);
	ItemManager im = new ItemManager();
	UserManager um = new UserManager();

	Cart ct = new Cart();

	public void mainMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.����] [2.Ż��] [3.�α���]" + "\n[100.������] [0.����] ");
			int sel = scan.nextInt();
			if (sel == 1) {
				um.join();
			} else if (sel == 2) {
				um.userRemove();
			} else if (sel == 3) {
				if (um.logIn()) {
					loginMenu();
				}
			} else if (sel == 100) {
				managerMenu();
			} else {
				System.out.println("����");
				break;
			}
		}
	}

	void loginMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.����] [2.��ٱ��ϸ��] [0.�ڷΰ���]");
			int sel = scan.nextInt();
			if (sel == 1) {
				shopMenu();
			} else if (sel == 2) {
				cartMenu();
			} else if (sel == 0) {
				um.logOut();
				break;
			}
		}
	}

	void cartMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.�� ��ٱ���] [2.����] [3.����] [0.�ڷΰ���]");
			int sel = scan.nextInt();
			if (sel == 1) {
				im.printJang(um.userList.get(um.userLog));
			} else if (sel == 2) {
				im.printJang(um.userList.get(um.userLog));
				System.out.println("����� ���� ǰ�� ����:");
				int index = scan.nextInt();
				im.removeItem(index);
			} else if (sel == 3) {
				im.purchase();

			} else if (sel == 0) {
				break;
			}
		}
	}

	void shopMenu() {
		boolean run = true;
		while (run) {
			im.printCategory();
			System.out.println("[ī�װ�] ��ȣ�� �Է��ϼ���.[����.-1]");

			int caID = scan.nextInt();
			if (caID < im.categorySize()) {
				if (caID == -1)
					break;
				System.out.println("[������] ��ȣ�� �Է��ϼ���. ");
				im.printItemList(caID);
				int itID = scan.nextInt();
				if (itID < im.itemSize(caID)) {
					im.addCart(um.userList.get(um.userLog).id, caID, itID);
				} else {
					System.out.println("������ �ʰ�");
				}
			} else {
				System.out.println("ī�װ� �ʰ�");
			}
		}
	}

	void managerMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.�����۰���] [2.ī�װ�����] [3.��ٱ��ϰ���] [4.��������] [0.�ڷΰ���] ");
			int sel = scan.nextInt();
			if (sel == 1) {
				itemMenu();
			} else if (sel == 2) {
				categoryMenu();
			} else if (sel == 3) {
				im.printCart();

			} else if (sel == 4) {
				userMenu();
			} else if (sel == 0) {
				run = false;
			}
		}
	}

	void categoryMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.��üī�װ�] [2.ī�װ��߰�] [3.ī�װ�����] [0.�ڷΰ���]");
			int sel = scan.nextInt();
			if (sel == 1) {
				im.printCategory();
			} else if (sel == 2) {
				im.categoryAdd();

			} else if (sel == 3) {
				im.categoryRemove();

			} else if (sel == 0) {
				run = false;
			}
		}
	}

	void itemMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.��ü������] [2.�������߰�] [3.�����ۻ���] [0.�ڷΰ���]");
			int sel = scan.nextInt();
			if (sel == 1) {
				im.printItemList();
			} else if (sel == 2) {
				im.addItem();
			} else if (sel == 3) {
				im.itemRemove();
			} else if (sel == 0) {
				run = false;
			}
		}
	}

	void userMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.��ü����] [2.�����߰�] [3.��������] [0.�ڷΰ���]");
			int sel = scan.nextInt();
			if (sel == 1) {
				um.printUser();
			} else if (sel == 2) {
				um.join();
			} else if (sel == 3) {
				um.adminRemove();
			} else if (sel == 0) {
				run = false;
			}
		}
	}
}