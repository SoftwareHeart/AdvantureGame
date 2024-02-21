package Game;

import java.util.Scanner;

public class Game {
       Player player;
       Location location;
       Scanner scan = new Scanner(System.in);
       public void login()
       {
        Scanner scan = new Scanner(System.in);
   		System.out.println("Macera Oyununa Hoşgeldiniz !");
   		System.out.print("Oyuna başlamadan önce isminizi giriniz:");
   		String playerName = scan.nextLine();
   		player = new Player(playerName);
   		player.selectCha();
   		start();
   		
       }
       public void start()
       {
    	   while(true)
    	   {
    		   System.out.println();
        	   System.out.println("=======================================");
        	   System.out.println();
        	   System.out.println("Gitmek için bir yer seçiniz");
        	   System.out.println("1- Güvenli Ev -> Size ait güvenli bir alan, düşman yok !");
        	   System.out.println("2- Mağara -> Burada belki karşınıza zombi çıkabilir !");
        	   System.out.println("3- Orman -> Burada belki karşınıza vampir çıkabilir !");
        	   System.out.println("4- Nehir -> Burada belki karşınıza ayı çıkabilir !");
        	   System.out.println("5- Mağaza -> Silah veya zırh alabilirsiniz !");
        	   System.out.print("Gitmek istediğniz yer ->");
        	   int selectLoc = scan.nextInt();
        	   while(selectLoc<1 || selectLoc>5 )
        	   {
        		   System.out.print("Lütfen geçerli bir yer seçiniz ->");
        		   selectLoc = scan.nextInt();
        	   }
        	   switch(selectLoc)
        	   {
        	   case 1:
        		   location = new SafeHouse(player);
        		   break;
        	   case 2:
        		   location = new Cave(player); 
				   break;	
        	   case 3:
        		   location = new Forest(player);
        		   break;
        	   case 4:
        		   location = new River(player);
        		   break;
        	   case 5:
        		   location = new ToolStore(player);
        		   break;
        		   
        	   default:
        		   location = new SafeHouse(player);
            	   break;	   
        	   }
        	   if(location.getClass().getName().equals("SafeHouse"))
        	   {
        		   if(player.getInv().isFirewood() && player.getInv().isFood()&&player.getInv().isWater())
        		   {
        			   System.out.println("******************************************\n");
        			   System.out.println("Tebrikler oyunu kazandınızzzzzz.");
        			   System.out.println("\n******************************************");
        			   break;
        		   }
        	   }
        	   if(!location.getLocation())
        	   {
        		   System.out.println("Oyun bitti !");
        		   break;
        	   }
    	   }
       }
      
}
