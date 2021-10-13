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
			System.out.println("[1.가입] [2.탈퇴] [3.로그인]" + "\n[100.관리자] [0.종료] ");
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
				System.out.println("종료");
				break;
			}
		}
	}

	void loginMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.쇼핑] [2.장바구니목록] [0.뒤로가기]");
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
			System.out.println("[1.내 장바구니] [2.삭제] [3.구입] [0.뒤로가기]");
			int sel = scan.nextInt();
			if (sel == 1) {
				im.printJang(um.userList.get(um.userLog));
			} else if (sel == 2) {
				im.printJang(um.userList.get(um.userLog));
				System.out.println("지우고 싶은 품목 선택:");
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
			System.out.println("[카테고리] 번호를 입력하세요.[종료.-1]");

			int caID = scan.nextInt();
			if (caID < im.categorySize()) {
				if (caID == -1)
					break;
				System.out.println("[아이템] 번호를 입력하세요. ");
				im.printItemList(caID);
				int itID = scan.nextInt();
				if (itID < im.itemSize(caID)) {
					im.addCart(um.userList.get(um.userLog).id, caID, itID);
				} else {
					System.out.println("아이템 초과");
				}
			} else {
				System.out.println("카테고리 초과");
			}
		}
	}

	void managerMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.아이템관리] [2.카테고리관리] [3.장바구니관리] [4.유저관리] [0.뒤로가기] ");
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
			System.out.println("[1.전체카테고리] [2.카테고리추가] [3.카테고리삭제] [0.뒤로가기]");
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
			System.out.println("[1.전체아이템] [2.아이템추가] [3.아이템삭제] [0.뒤로가기]");
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
			System.out.println("[1.전체유저] [2.유저추가] [3.유저삭제] [0.뒤로가기]");
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