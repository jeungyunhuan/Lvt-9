package controller;

import java.util.Random;

public abstract class Unit {
	protected Random ran = new Random();
	private String name;
	private int hp;
	private int att;
	private int def;
	private int pos;
//	private int money;
	
//	public int getMoney() {
//		return money;
//	}
//	public void setMoney(int mon) {
//		this.money=mon;
//	}
	
	public String getname() {
		return name;
	}
	public int gethp() {
		return hp;
	}
	public void sethp(int hp) {
		this.hp = hp;
	}
	public int getatt() {
		return att;
	}
	public void setatt(int att) {
		this.att = att;
	}
	public int getdef() {
		return def;
	}
	public void setdef(int def) {
		this.def = def;
	}
	public int getpos() {
		return pos;
	}
	public void setpos(int pos) {
		this.pos = pos;
	}
	protected Unit(String name,int hp,int att,int def,int pos){
		this.name = name;
		this.hp = hp;
		this.att = att;
		this.def = def;
		this.pos = pos;

	}
	public void attack(Unit target) {
		int dam = (this.att - target.def)*(ran.nextInt(150)+50)/100;
		if(dam<=0) {dam = 1;}
		System.out.println(name+"의 공격!");
		System.out.println(dam+"의 대미지!");
		target.sethp(target.gethp()-dam);
		System.out.println(target.name+"의 남은 체력 : "+target.hp);
	}
	public void print() {
		System.out.println("[이름] : "+name+"    [체력] : "+hp);
		System.out.println("[공격력] : "+att+"  [방어력] : "+def+"  [위치] : "+pos);
	}
}