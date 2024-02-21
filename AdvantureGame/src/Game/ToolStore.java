package Game;
import java.util.Scanner;
public class ToolStore extends NormalLoc{

	public ToolStore(Player player) {
		super(player, "Mağaza");	
	}
	Scanner scan = new Scanner(System.in);
	@Override
    public boolean getLocation()
    {
		System.out.println("Para : " + getPlayer().getMoney());
		System.out.println("1- Silahlar");
		System.out.println("2- Zırhlar");
		System.out.println("3- Çıkış");
		System.out.print("Gitmek istediğiniz yer->");
		int getL=scan.nextInt();
		while(getL<1 || getL >3)
		{
			System.out.print("Lütfen geçerli bir yeri giriniz->");
			getL = scan.nextInt();
		}
		int selItemID;
		switch(getL)
		{
		case 1:
			selItemID=weaponMenu();
			buyWeapon(selItemID);
			break;
		case 2:
			selItemID = armorMenu();
			buyArmor(selItemID);
			break;
		default:
			break;
		}
    	return true;
    }
	public int armorMenu()
	{
		System.out.println("1- Hafif  <Para : 15 - Hasar Engelleme : 1>");
		System.out.println("2- Orta   <Para : 25 - Hasar Engelleme : 3>");
		System.out.println("3- Ağır   <Para : 40 - Hasar Engelleme : 5>");
		System.out.println("4- Çıkış");
		System.out.print("Almak istediğiniz silah ->");
		int selArmorID = scan.nextInt();
		while(selArmorID<1 || selArmorID>4)
		{
			System.out.print("Lütfen geçerli bir silah giriniz->");
			selArmorID = scan.nextInt();
		}
		return selArmorID;
	}
	public void buyArmor(int x)
	{
		int price = 0,avoid = 0;
		String aName=null;
		switch(x)
		{
		case 1:
			aName = "Hafif Zırh";
			price = 15;	
			avoid = 1;
			break;
		case 2:
			aName = "Orta Zırh";
			price = 25;
			avoid = 3;
			break;
		case 3:
			aName = "Ağır Zırh";
			price = 40;
			avoid = 5;
		case 4:
			System.out.println("Çıkış yapılmıştır");
			break;
		default:
			System.out.println("Geçersiz işlem");
			break;
		}
		if(price > 0)
		{
			if(player.getMoney()>=price)
			{
				
				player.getInv().setArmor(avoid);
				player.getInv().setaName(aName);
				player.setMoney(player.getMoney() - price);
				System.out.println(player.getInv().getaName()+" satın aldınız - Kazanılan hasar engelleme : "+player.getInv().getArmor());
				
				System.out.println("Kalan paranız: "+player.getMoney());
				
			}
			else
			{
				System.out.println("Bakiye yetersiz");
			}
		}
	}
	public int weaponMenu()
	{
		System.out.println("1- Tabanca <Para : 25 - Hasar : 2>");
		System.out.println("2- Kılıç   <Para : 35 - Hasar : 3>");
		System.out.println("3- Tüfek   <Para : 45 - Hasar : 7>");
		System.out.println("4- Çıkış");
		System.out.print("Almak istediğiniz silah ->");
		int selID = scan.nextInt();
		while(selID<1 || selID>4)
		{
			System.out.print("Lütfen geçerli bir silah giriniz->");
			selID = scan.nextInt();
		}
		return selID;
	}
	public void buyWeapon(int x)
	{
		int price = 0,damage = 0;
		String wName=null;
		switch(x)
		{
		case 1:
			wName = "Tabanca";
			price = 25;	
			damage = 2;
			break;
		case 2:
			wName = "Kılıç";
			price = 35;
			damage = 3;
			break;
		case 3:
			wName = "Tüfek";
			price = 45;
			damage = 7;
		case 4:
			System.out.println("Çıkış yapılmıştır");
			break;
		default:
			System.out.println("Geçersiz işlem");
			break;
		}
		if(price > 0)
		{
			if(player.getMoney()>=price)
			{
				
				player.getInv().setDamage(damage);
				player.getInv().setwName(wName);
				
				System.out.println(player.getInv().getwName()+" silahını satın aldınız - Önceki hasar : "+player.getDamage()+" - Artırılmış hasar : "+ player.getTotalDamage());
				player.setMoney(player.getMoney() - price);
				System.out.println("Kalan paranız: "+player.getMoney());
				
				
			}
			else
			{
				System.out.println("Bakiye yetersiz");
			}
		}
		
	}
}
