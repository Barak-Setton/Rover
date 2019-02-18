public class Robot{
	private int nextStep[] = new int[2];
	private int coord[] = new int[2];
	private String dir = new String();
	private int boundries[] = new int[2];

	public Robot(int x, int y, String dir, int xBound, int yBound){

		this.coord[0] = x;
		this.coord[1] = y;
		this.dir = dir;
		this.boundries[0] = xBound;
		this.boundries[1] = yBound; 
		this.calcNextMove();
	}

	public int[] getCoord(){
		return this.coord;
	}

	public int[] getNextStep(){
		return this.nextStep;
	}

	public String getDir(){
		return this.dir;
	}

	public String getInfoString(){
		return  Integer.toString(coord[0])+" "+ Integer.toString(coord[1])+ " " + dir;
	}



	public void R(){
		// N
		if(this.dir.equals("N")){
			this.nextStep[0]++;
			this.nextStep[1] = this.coord[1];
			this.dir = "E";
		}
		// S
		else if(this.dir.equals("S")){
			this.nextStep[0]--;
			this.nextStep[1] = this.coord[1];
			this.dir = "W";
		}

		// E
		else if(this.dir.equals("E")){
			this.nextStep[0] = this.coord[0];
			this.nextStep[1]--;
			this.dir = "S";
		}
		// W
		else if(this.dir.equals("W")){
			this.nextStep[0] = this.coord[0];
			this.nextStep[1]++;
			this.dir = "N";
		}
	}
	
	public void L(){
		// N
		if(this.dir.equals("N")){
			this.nextStep[0]--;
			this.nextStep[1] = this.coord[1];
			this.dir = "W";
		}
		// S
		else if(this.dir.equals("S")){
			this.nextStep[0]++;
			this.nextStep[1] = this.coord[1];
			this.dir = "E";
		}
		// E
		else if(this.dir.equals("E")){
			this.nextStep[0] = this.coord[0];
			this.nextStep[1]++;
			this.dir = "N";
		}
		// W
		else if(this.dir.equals("W")){
			this.nextStep[0] = this.coord[0];
			this.nextStep[1]--;
			this.dir = "S";
		}
	}
	
	public void M(){
	
		// Check if Robots next move is off the grid 

		if(this.nextStep[0] > boundries[0] || this.nextStep[0] < 0 || this.nextStep[1] > boundries[1] || this.nextStep[1] < 0){
			System.out.println("Robot hit boundary and stayed in position " + this.coord[0] + " " + this.coord[1]);
			System.out.println();
		}
		else{
			// make current coordinates into the next step coordinates 
			this.coord[0] = this.nextStep[0];
			this.coord[1] = this.nextStep[1];
			calcNextMove();
		}
	}

	private void calcNextMove(){
		if(this.dir.equals("N")){
			this.nextStep[0] = this.coord[0];
			this.nextStep[1] = this.coord[1]+1;
			//System.out.println("OBJECT next step: "+ this.nextStep[0] + " "+ this.nextStep[1]);
		}
		else if(this.dir.equals("S")){
			this.nextStep[0] = this.coord[0];
			this.nextStep[1] = this.coord[1]-1;
		}
		else if(this.dir.equals("E")){
			this.nextStep[0] = this.coord[0]+1;
			this.nextStep[1] = this.coord[1];
		}
		else if(this.dir.equals("W")){
			this.nextStep[0] = this.coord[0]-1;
			this.nextStep[1] = this.coord[1];
		}
	}	
}