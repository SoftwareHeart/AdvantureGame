package Game;

import java.util.Scanner;

public class Player {
	private int damage,healthy,money,rHealthy;
	private String name,cName;
	private Inventory inv;
	Scanner scan = new Scanner(System.in);
	public Player(String name) {
		this.name = name;
		this.inv = new Inventory();
	}
	
	public void selectCha()
	{
		switch(chaMenu())
		{
		//Samuray seçildi.
		case 1:
			init("Samuray", 5, 21, 15);
			break;
		case 2:
			init("Okçu", 7, 18, 20);
			break;
		case 3:
			init("Şovalye", 8, 24, 5);
			break;
		default :
		{
			init("Samuray", 5, 21, 15);
			break;
		}
		
		}
		System.out.println("Karakterinizi başarı ile seçtiniz..");
		System.out.println("Karakter : "+getcName()+", Hasar : "+getDamage()+", Sağlık : "+getHealthy()+", Money : "+getMoney());;
	}
	public void init(String cName,int dmg,int hltyh,int mny)
	{
		setcName(cName);
		setDamage(dmg);
		setHealthy(hltyh);
		setMoney(mny);
		setrHealthy(hltyh);
	}
	public int getTotalDamage()
	{
		return this.getDamage()+this.getInv().getDamage();
	}
	public int chaMenu()
	{
		System.out.println("Lütfen bir karakter seçiniz: ");
		System.out.println("1- : Samuray \t Hasar : 5 \t Sağlık : 21 \t Para : 15");
		System.out.println("2- : Okçu \t Hasar : 7 \t Sağlık : 18 \t Para : 20");
		System.out.println("3- : Şovalye \t Hasar : 8 \t Sağlık : 24 \t Para : 5");
		System.out.print("Karakter Seçiminiz ->");
		int chaID=scan.nextInt();
		
		while(chaID<1 || chaID >3)
		{
			System.out.println("Lütfen geçerli bir karakter seçiniz.");
			System.out.print("Karakter Seçiminiz->");
		    chaID=scan.nextInt();
		}
		return chaID;
	}
	
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getHealthy() {
		return healthy;
	}
	public void setHealthy(int healthy) {
		this.healthy = healthy;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Inventory getInv() {
		return inv;
	}
	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	public int getrHealthy() {
		return rHealthy;
	}

	public void setrHealthy(int rHealthy) {
		this.rHealthy = rHealthy;
	}

}
