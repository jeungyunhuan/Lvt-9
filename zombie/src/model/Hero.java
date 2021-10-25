package model;

import controller.Unit;

public class Hero extends Unit{
	private int cnt = 3;
	private int money=0;
	public Hero(String name,int hp,int att,int def,int pos) {
		super(name, hp, att, def,pos);
		// TODO Auto-generated constructor stub
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money+=money;
	}
	
	public int getcnt() {
		return cnt;
	}
	public void drink() {
		if(cnt>0) {
			System.out.println("ȸ������ ���ʴϴ�.");
			System.out.println("ü���� 100ȸ�� �Ǿ����ϴ�.");
			this.sethp(100);
			System.out.println(this.getname()+"�� ���� ü�� : "+this.gethp());
			cnt--;
		}
		else {
			System.out.println("������ �����ϴ�.");
		}
	}
	public void attack(Unit target) {
		if(target instanceof ZombieKing) {
			if(((ZombieKing) target).shield>0) {
				int dam = (this.getatt() - target.getdef())*(ran.nextInt(150)+50)/100;
				if(dam<=0) {dam = 1;}
				System.out.println(getname()+"�� ����!");
				System.out.println(dam+"�� �����!");
				((ZombieKing) target).setshield(((ZombieKing) target).getshield()-dam);
				if(((ZombieKing) target).getshield()<=0) {
					System.out.println(target.getname()+"�� ���尡 �ڻ쳵��!");
					((ZombieKing) target).setshield(0);
				}
				System.out.println(target.getname()+"�� ���� ü�� : "+target.gethp()+" (���� : "+((ZombieKing) target).getshield()+")");
			}
			else {
				super.attack(target);
			}
		}
		else {
			super.attack(target);
		}
	}

}

