
import java.util.Scanner;
import java.util.ArrayList;

public class Rover
{


	public static void calculateMove(String moves, Robot rob){

		// interate through characters in string of moves
		for(char c : moves.toCharArray()) {
		    if(c == 'L'){
		    	rob.L();
		    }
		    else if(c == 'R'){
				rob.R();
		    }
		    else if(c == 'M'){
		    	rob.M();
		    }
		    else{
		    	System.out.println("Moves contains a wrong character. Only 'L', 'R', and 'M' will be accepted");
		    	return;
		    }
		}
	}


	public static void start(){
		// List of robots
		ArrayList<Robot> robots = new ArrayList<Robot>();
		int grid[] = new int[2];
		String movements = "";

		System.out.println("Enter 'ext' to quit");

		// create a scanner so we can read the command-line input
    	Scanner input = new Scanner(System.in);

    	// reading first input line (Grid)
		System.out.print("Enter grid size x y: ");
   		String inputString = input.nextLine(); 
    	System.out.println();

    	if(inputString.equals("ext")){movements="ext";}
    	else{
	    	// reading each coordanate into an array (x, y)
	    	String gridString[] = inputString.split(" ");
	    	// Check to see that two intergers were added correctly
	    	try{
		    	grid[0] = Integer.parseInt(gridString[0]);
		    	grid[1] = Integer.parseInt(gridString[1]);
	    	}
	    	catch(Exception e){
	    		System.out.println("Please enter only NUMBERS");
	    		start();
	    		return;
	    	}
    	}

		// looping until 'ext' is entered
		while(!movements.equals("ext")){
			System.out.println("Enter 'ext' to quit");
			
			// coordanates for robot position
			int coord [] = new int[2];

			// Direction of robot N E W S
			String direction = new String("");
			
			// read infor about robot (x, y, and direction)
			System.out.print("Enter Robot posistion and direction x y c: ");
			String posDir = input.nextLine();
			
			// if input equals 'ext' stop the program
			if(posDir.equals("ext")){break;}

			// splitting 
			String robotInfo[] = posDir.split(" ");

			// checking if input was correct and if not it will restart the menu function
	    	try{
				coord[0] = Integer.parseInt(robotInfo[0]);
				coord[1] = Integer.parseInt(robotInfo[1]);
				direction = robotInfo[2];
	    	}
	    	catch(Exception e){
	    		System.out.println("Please enter two NUMBERS and 'N', 'E', 'S' or'W'");
	    		System.out.println();

	    		continue;
	    	}


			//create new Robot
			Robot rob = new Robot(coord[0], coord[1], direction,grid[0],grid[1]);
			robots.add(rob);

			System.out.print("Enter Robot movements: ");
			movements = input.nextLine();
			System.out.println();

			// Calculate the move string on new robot
			calculateMove(movements, rob);
		}		


		System.out.println();

		for (Robot rob : robots) {
			System.out.println();
			System.out.println(rob.getInfoString());
		}

		System.out.println();
		System.out.println("Good Bye");
	
	
		
	}

	public static void main(String[] args) {
		start();	
	}
}

