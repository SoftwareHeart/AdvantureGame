package Game;



public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    protected String award;
    
    
	public BattleLoc(Player player,String name,Obstacle obstacle,String award) {
		super(player);
		this.name = name;
		this.obstacle = obstacle;
		this.award = award;
	}
	@Override
	public boolean getLocation()
	{
		int obsCount = obstacle.Count();
		System.out.println("Şuan buradasınız -> " + this.getName());
		System.out.println("Dikkatli ol! Burada " + obsCount +" tane "+obstacle.getName()+ " yaşıyor !");
		System.out.print("<S>avaş veya <K>aç -> ");
		
		String selCase = scan.nextLine();
		System.out.println();
		selCase = selCase.toUpperCase();
		if(selCase.equals("S"))
		{
			if(combat(obsCount))
			{
				System.out.println("==========================");
				System.out.println(this.getName()+" Bölgesindeki tüm düşmanları yendiniz, Tebrikler !!");
				if(this.award.equals("Food") && player.getInv().isFood() == false)
				{
					System.out.println(this.award + " Kazandınız !");
					player.getInv().setFood(true);
				}
				else if(this.award.equals("Firewood") && player.getInv().isWater() == false)
				{
					System.out.println(this.award + " Kazandınız !");
					player.getInv().setWater(true);
				}
				else if(this.award.equals("Water") && player.getInv().isFirewood() == false)
				{
					System.out.println(this.award + " Kazandınız !");
					player.getInv().setFirewood(true);
				}
				return true;
			}
			if(player.getHealthy() <=0)
			{
				System.out.println("=========================");
				System.out.println("Öldünüz !!");
				System.out.println("=========================");
				return false;
			}
		}
		return true;
	}
	public boolean combat(int obsCount)
	{
		for (int i = 0; i < obsCount; i++) {
			playerStats();
			enemyStats();
			int defObsHealth = obstacle.getHealthy();
			while(player.getHealthy()>0 && obstacle.getHealthy()>0)
			{
				System.out.print("<V>ur veya <K>aç ->");
				String selCase = scan.nextLine();
				selCase = selCase.toUpperCase();
				if (selCase.equals("V")) {
					System.out.println();
					System.out.println("Siz vurdunuz!");
					afterHit();
					
					if(obstacle.getHealthy()>0)
					{
						System.out.println((i+1)+"."+obstacle.getName()+"'nin Canı-> " + obstacle.getHealthy());
						System.out.println();
						System.out.println(obstacle.getName()+" size vurdu !");
						System.out.println();
						player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInv().getArmor()));
						
						System.out.println("Canınız -> "+player.getHealthy());
						System.out.println(obstacle.getName()+" Canı -> "+obstacle.getHealthy());
					}
					
				}else {
					return false;
				}
			}
			if(obstacle.getHealthy()<player.getrHealthy() && player.getHealthy()>0)
			{
				System.out.println("=================");
				player.setMoney(player.getMoney()+obstacle.getAward());
				System.out.println("Güncel paranız : " + player.getMoney());
				obstacle.setHealthy(defObsHealth);
			}else
			{
				return false;
			}
		}
		return true;
	}
	public void playerStats()
	{
		System.out.println("\nOyuncu Değerleri\n");
		System.out.println("==================\n");
		System.out.println("Can : " + player.getHealthy());
		System.out.println("Hasar : " + player.getTotalDamage() +" ,Silahlardan kazanılan hasar : "+player.getInv().getDamage());
		System.out.println("Para : " + player.getMoney());
		System.out.println();
		if(player.getInv().getDamage()>0)
		{
			System.out.println("Silah : "+player.getInv().getwName());
		}
		if(player.getInv().getArmor()>0)
		{
			System.out.println("Zırh : "+player.getInv().getaName());
		}
	}
	public void enemyStats()
	{
		System.out.println("\n"+obstacle.getName()+" Değerleri\n");
		System.out.println("==================\n");
		System.out.println("Can : " + obstacle.getHealthy());
		System.out.println("Hasar : " + obstacle.getDamage());
		System.out.println("Ödül : " + obstacle.getAward());
	}
	public void afterHit()
	{
		obstacle.setHealthy(obstacle.getHealthy() - player.getTotalDamage());
		if(obstacle.getHealthy()<=0)
		{
			System.out.println("======================================");
			System.out.println();
			System.out.println(obstacle.getName()+"'yi öldürdünüz !");
			System.out.println("\n=====================================");
		}
		System.out.println("Oyuncu Canı-> " + player.getHealthy()+" ,Zırh : " + player.getInv().getArmor());
		
	}
        
}
