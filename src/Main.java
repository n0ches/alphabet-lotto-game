
public class Main {

	public static void main(String[] args) {
		//initializing of necessary stacks
		Stack bag1=new Stack(26);
		Stack bag2=new Stack(26);
		Stack temp1=new Stack(8);
		Stack temp2=new Stack(8);
		Stack tempPlayer1=new Stack(4);
		Stack tempPlayer2=new Stack(4);
		Stack tempBag1=new Stack(26);
		Stack tempBag2=new Stack(26);
		
		Stack player1=new Stack(8);
		Stack player2=new Stack(8);
		
		Stack aTon = new Stack(4);
		Stack oToz = new Stack(4);
		//initializing of necessary stacks
		
		//calling the object from game class
		Game game = new Game();
		//calling the object from game class
		
		//initializing of stacks
		game.initializeBag1(bag1);
		game.initializePlayer1(player1,tempPlayer1,aTon,oToz);
		game.initializePlayer2(player2, tempPlayer2, aTon, oToz);
		//initializing of stacks
		
		//displaying for beginning of the game
		System.out.print("Player 1 : ");
		for(int i=0;i<8;i++) {
			if(player1.isEmpty()) {
				break;
			}
			else {
			System.out.print(player1.peek()+" ");
			temp1.push(player1.pop());
			}
		}
		for(int i=0;i<8;i++) {
			if(temp1.isEmpty()) {
				break;
			}
			else {
				player1.push(temp1.pop());
			}
			
		}
		
		System.out.print("			   Bag 1 : ");
		for(int i=0;i<26;i++) {
			if(bag1.isEmpty()) {
				break;
			}
			else {
			System.out.print(bag1.peek()+" ");
			tempBag1.push(bag1.pop());
			}
		}
		for(int i=0;i<26;i++) {
			bag1.push(tempBag1.pop());
		}
		System.out.println();
		
		System.out.print("Player 2 : ");
		for(int i=0;i<8;i++) {
			if(player2.isEmpty()) {
				break;
			}
			else {
			System.out.print(player2.peek()+" ");
			temp2.push(player2.pop());
			}
		}
		for(int i=0;i<8;i++) {
			if(temp2.isEmpty()) {
				break;
			}
			else {
				player2.push(temp2.pop());
			}
			
		}
		System.out.println("			   Bag 2 : ");
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		//displaying for beginning of the game
		
		//main game method.
		game.play(player1, player2, temp1, temp2, bag1, bag2, tempBag1, tempBag2);
		//main game method.
	}

}
