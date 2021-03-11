
public class Game {
	//initializing player's scores.
	private int p1score;
	private int p2score;
	Game(){
		p1score=0;
		p2score=0;
	}
	//initializing player's scores.
	/**
	 * @return the p1score
	 */
	public int getP1score() {
		return p1score;
	}

	/**
	 * @param p1score the p1score to set
	 */
	public void setP1score(int p1score) {
		this.p1score = p1score;
	}

	/**
	 * @return the p2score
	 */
	public int getP2score() {
		return p2score;
	}

	/**
	 * @param p2score the p2score to set
	 */
	public void setP2score(int p2score) {
		this.p2score = p2score;
	}

	public void initializeBag1(Stack bag1) {
		//A to Z in ASCII starting 65 and ending 90 
		for(int i=90;i>=65;i--) {
			bag1.push((char)i); //pushing letters into bag1 stack
		}
	}
	public void initializePlayer1(Stack player1,Stack tempPlayer1,Stack aTon,Stack oToz) {
		char letter1=' ';//variable that temp first letter for letters O to Z
		char letter2=' ';//variable that temp first letter for letters A to N
		int countPlayer1=0;//count letter number.
		//program will push letters into player1 until it is full.
		do {
			
			//if elements number of player 1 stack is less than 4, program will push letters O to Z into stack.
			if(countPlayer1<4) {
				int random=((int)(Math.random()*12))+79; //letters O to Z in ASCII
				if(countPlayer1==0) {
					letter1=(char)random;//keeping first letter for controlling difference.
				}
				
			// Controlling differences	
			if(!(oToz.isEmpty())){
				do {
					tempPlayer1.push(oToz.pop());
					if(tempPlayer1.peek().equals((char)random)) {	// if there are same letters loop will break
						break;
					}
				}while(!(oToz.isEmpty()));//if there are no same letters oToz will be empty, that's why loop will end.
			}
			// Controlling differences
			
			if((oToz.isEmpty()) && ((char)random!=(letter1) ||countPlayer1==0)) { //if there are no same letter, program will enter this statement
				while(!(tempPlayer1.isEmpty())) {
					oToz.push(tempPlayer1.pop());	//re-pushing oToz.
				}
				
				oToz.push((char) random);	//pushing letter 
				countPlayer1++;
			
		}
			else {
				while(!(tempPlayer1.isEmpty())) { //if there are same letter, program will enter this statement
					oToz.push(tempPlayer1.pop());//re-pushing oToz.
				}
			}
			}
			//if elements number of player 1 stack is less than 4, program will push letters O to Z into stack.
			
			//if elements number of player 1 stack is more than 4, program will push letters A to N into stack.
			else {
				int random=((int)(Math.random()*14))+65;//letters O to Z in ASCII
				if(countPlayer1==4) {
					letter2=(char)random;//keeping first letter for controlling difference.
				}
				// Controlling differences	
				if(!(aTon.isEmpty())){
					do {
						tempPlayer1.push(aTon.pop());
						if(tempPlayer1.peek().equals((char)random)) {
							break;// if there are same letters loop will break
						}
					}while(!(aTon.isEmpty()));//if there are no same letters aTon will be empty, that's why loop will end.
				}
				// Controlling differences	
				
				if((aTon.isEmpty()) && ((char)random!=(letter2) ||countPlayer1==4)) {//if there are no same letter, program will enter this statement
					while(!(tempPlayer1.isEmpty())) {
						aTon.push(tempPlayer1.pop());//re-pushing aTon.
					}
					
					aTon.push((char) random);//pushing letter 
					countPlayer1++;
				
			}
				else {
					while(!(tempPlayer1.isEmpty())) {//if there are same letter, program will enter this statement
						aTon.push(tempPlayer1.pop());//re-pushing aTon.
					}
				}
		}
			//if aTon and oToz ara full, letters that are on those stacks will be pushed into player 1 stack.
			if(countPlayer1==8) {
				for(int i=0;i<4;i++) {
					player1.push(oToz.pop());
				}
				
				for(int i=0;i<4;i++) {
					player1.push(aTon.pop());
				}
			}
			//if aTon and oToz ara full, letters that are on those stacks will be pushed into player 1 stack.
			
		}while(!(player1.isFull()));
		//if elements number of player 1 stack is more than 4, program will push letters A to N into stack.
	}

	//Same process with initializePlayer1
	public void initializePlayer2(Stack player2,Stack tempPlayer2,Stack aTon,Stack oToz) {
	
		char letter3=' ';
		char letter4=' ';
		int countPlayer2=0;
		do {
			
			if(countPlayer2<4) {
				int random=((int)(Math.random()*12))+79;
				if(countPlayer2==0) {
					letter3=(char)random;
				}
				
			if(!(oToz.isEmpty())){
				do {
					tempPlayer2.push(oToz.pop());
					if(tempPlayer2.peek().equals((char)random)) {
						break;
					}
				}while(!(oToz.isEmpty()));
			}
			
			if((oToz.isEmpty()) && ((char)random!=(letter3) ||countPlayer2==0)) {
				while(!(tempPlayer2.isEmpty())) {
					oToz.push(tempPlayer2.pop());
				}
				
				oToz.push((char) random);
				countPlayer2++;
			
		}
			else {
				while(!(tempPlayer2.isEmpty())) {
					oToz.push(tempPlayer2.pop());
				}
			}
			}
			else {
				int random=((int)(Math.random()*14))+65;
				if(countPlayer2==4) {
					letter4=(char)random;
				}
				if(!(aTon.isEmpty())){
					do {
						tempPlayer2.push(aTon.pop());
						if(tempPlayer2.peek().equals((char)random)) {
							break;
						}
					}while(!(aTon.isEmpty()));
				}
				
				if((aTon.isEmpty()) && ((char)random!=(letter4) ||countPlayer2==4)) {
					while(!(tempPlayer2.isEmpty())) {
						aTon.push(tempPlayer2.pop());
					}
					
					aTon.push((char) random);
					countPlayer2++;
				
			}
				else {
					while(!(tempPlayer2.isEmpty())) {
						aTon.push(tempPlayer2.pop());
					}
				}
		}
			if(countPlayer2==8) {
				for(int i=0;i<4;i++) {
					player2.push(oToz.pop());
				}
				
				for(int i=0;i<4;i++) {
					player2.push(aTon.pop());
				}
			}
			
		}while(!(player2.isFull()));
	}
	//Same process with initializePlayer1
	
	
	public void play(Stack player1,Stack player2,Stack temp1,Stack temp2,Stack bag1,Stack bag2,Stack tempBag1,Stack tempBag2) {
		char letter=' '; //variable that temp first selected letter for controlling selecting different letter
		int countSame=0;//variable that count same letters.
		//variable that count letters for cinko.
		int P1countAtoN=0;
		int P1countOtoZ=0;
		int P2countAtoN=0;
		int P2countOtoZ=0;
		//variable that count letters for cinko.
		
		//do-while loop until player1 or player2 or bag1 ara empty.
		do {
		
		//boolean variables for some controls
		boolean bag1Flag=false;
		boolean outputFlag=false;
		boolean player1Flag=false;
		boolean player2Flag=false;
		//boolean variables for some controls
		
		//selecting randomly letter from bag1.
		int random=((int)(Math.random()*26))+65;
		if(countSame==0) {
			letter=(char)random; //keeping the first selecting letter for difference control.otherwise, program gives error.
		}
		
		//controlling that does player1 have selected letter 
		do {
			
			//controlling that does player1 have selected letter 
			if(!(player1.isEmpty())) {
			temp1.push(player1.pop());
			if(temp1.peek().equals((char)random)) { //if player1 has the letter
				temp1.pop(); //letter will pop.
				player1Flag=true;
				while(!(temp1.isEmpty())) {
					player1.push(temp1.pop());
				}
			}
			}
			else {
				break; //if player hasn't the letter loop will break
			}
		}while(!(player1.isEmpty()) || !(player1Flag==true));
			//counting for cinko
			if(player1Flag) {
				if(64<random && random<79) {
					P1countAtoN++;
				}
				if(78<random && random<91) {
					P1countOtoZ++;
				}
				while(!(temp1.isEmpty())) {
					player1.push(temp1.pop());
				}
				//counting for cinko
			}
			//counting for cinko
			
			//if player1 has no selected letter, it will be re-pushing
			else {
				while(!(temp1.isEmpty())) {
					player1.push(temp1.pop());
				}
			}
			//controlling that does player1 have selected letter 
			
			//same process with player1
			do {
				if(!(player2.isEmpty())) {
				temp2.push(player2.pop());
				if(temp2.peek().equals((char)random)) {
					temp2.pop();
					player2Flag=true;
					while(!(temp2.isEmpty())) {
						player2.push(temp2.pop());
					}
				}}
				else {
					break;
				}
			}while(!(player2.isEmpty()) || !player2Flag);
				if(player2Flag) {
					if(64<random && random<79) {
						P2countAtoN++;
					}
					if(78<random && random<91) {
						P2countOtoZ++;
					}
					while(!(temp2.isEmpty())) {
						player2.push(temp2.pop());
					}
				}
				else {
					while(!(temp2.isEmpty())) {
						player2.push(temp2.pop());
					}
				}
				//same process with player1
				
		//controlling that does bag1 have selected letter
				
		//controlling if the same letter is already selected
		if(!(bag2.isEmpty())) {
			do {
			tempBag2.push(bag2.pop());
			if(tempBag2.peek().equals((char)random)) {
				outputFlag=true;	//if the same letter already selected, outputflag will be true and loop will end.
				break;
			}
		}while(!(bag2.isEmpty()));
			
	}
		//controlling if the same letter is already selected
		
		//if the same letter is not already selected
		if((bag2.isEmpty()) && ((char)random!=(letter) ||countSame==0)) {
			while(!(tempBag2.isEmpty())) {
				bag2.push(tempBag2.pop());	//re-pushing bag2
			}
		//loop until finding selected letter in bag1
		do {
		tempBag1.push(bag1.pop());
		if(tempBag1.peek().equals((char)random)) {//if the bag1 has selected letter
			bag2.push(tempBag1.pop());//selected letter will push into bag2
			bag1Flag=true;
			while(!(tempBag1.isEmpty())) {
				bag1.push(tempBag1.pop());//re-pushing bag1
			}
		}
		}while(!bag1Flag);
		//loop until finding selected letter in bag1
		//if the same letter is not already selected
		
		}
		//if the same letter already selected
		else {
			while(!(tempBag2.isEmpty())) {
				bag2.push(tempBag2.pop()); //re-pushing bag2
			}
		}
		//if the same letter already selected,
		
		
		
		//if selected letter isnfound into bag1
		if(!outputFlag) {
			
			//displaying commands...
			System.out.println("Selected Letter : "+(char)random);
			System.out.println();
			System.out.print("Player1 : ");
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
			
			System.out.print("                         Bag 1 : ");
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
				if(tempBag1.isEmpty()) {
					break;
				}
				else {
					bag1.push(tempBag1.pop());
				}
				
			}
			System.out.println();
			
			System.out.print("Player2 : ");
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
			
			System.out.print("			   Bag 2 : ");
			for(int i=0;i<26;i++) {
				if(bag2.isEmpty()) {
					break;
				}
				else {
				System.out.print(bag2.peek()+" ");
				tempBag2.push(bag2.pop());
				}
			}
			for(int i=0;i<26;i++) {
				if(tempBag2.isEmpty()) {
					break;
				}
				else {
					bag2.push(tempBag2.pop());
				}
				
			}
			System.out.println();
			//displaying commands...
			
			//statements for calculating cinko for player1
			if(!(player1.isEmpty())) {
			if(P1countAtoN==4 || P1countOtoZ==4) {//if cinko condition is provided
				this.p1score+=10; //player1 gets money
				System.out.println("Player1 gets $10");//displaying
				if(P1countAtoN==4) {
					P1countAtoN=0; //I changed the value of the variable so as not to provide the cinko condition again
				}
				if(P1countOtoZ==4) {
					P1countOtoZ=0;//I changed the value of the variable so as not to provide the cinko condition again
				}
					
			}
		}
		//statements for calculating cinko for player1
			
			//statements for calculating cinko for player2
			if(!(player2.isEmpty())) {
			if(P2countAtoN==4 || P2countOtoZ==4) {//if cinko condition is provided
				this.p2score+=10;//player2 gets money
				System.out.println("Player2 gets $10");
				if(P2countAtoN==4) {
					P2countAtoN=0;//I changed the value of the variable so as not to provide the cinko condition again
				}
				if(P2countOtoZ==4) {
					P2countOtoZ=0;//I changed the value of the variable so as not to provide the cinko condition again
				}
			}
		}
			//statements for calculating cinko for player2
			
			System.out.println("----------------------------------------------------------------------------------------------------------------");
		}
		//if selected letter isnfound into bag1
		
		//conditions about ending of the game
		if(player1.isEmpty() || player2.isEmpty() || bag1.isEmpty()) {
			break;//if condition provided loop will end, game is over.
		}
		//conditions about ending of the game
		countSame++;
		}while(!(bag1.isEmpty()) && !(player1.isEmpty()) || !(player2.isEmpty()));
		//do-while loop until player1 or player2 or bag1 ara empty.
		
		//conditions for determining winner and earning money
		if(player1.isEmpty() && !(player2.isEmpty())) {
			System.out.println("Player1 is the winner ");
			this.p1score+=30;
			
		}
		if(player2.isEmpty() && !(player1.isEmpty())) {
			System.out.println("Player2 is the winner ");
			this.p2score+=30;
		}
		if(player1.isEmpty() && player2.isEmpty() ){
			System.out.println("The game is over without any winner.");
			this.p1score+=15;
			this.p2score+=15;
		}
		System.out.println("Player1: $" +this.p1score);
		System.out.println("Player2: $" +this.p2score);
		//conditions for determining winner and earning money
	}
}

