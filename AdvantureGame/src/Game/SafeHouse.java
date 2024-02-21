package Game;



public class SafeHouse extends NormalLoc {

	public SafeHouse(Player player) {
		super(player, "Güvenli Ev");
		
	}
	@Override
	public boolean getLocation()
	{
		
		player.setHealthy(player.getrHealthy());
		System.out.println("İyileştiniz....");
		System.out.println("Can : " + player.getHealthy());
		System.out.println("Şuan güvenli evdesiniz..")	;
		return true;
	}


}
