package model;

public class User {
	public String id;
	int money;

	public User(String id, int mo) {
		this.id = id;
		money = mo;
	}

	public void print() {
		System.out.println("[" + id + "] " + "�ݾ� : " + money);
	}
	public void user() {
		System.out.println("id: "+id);
	}
}