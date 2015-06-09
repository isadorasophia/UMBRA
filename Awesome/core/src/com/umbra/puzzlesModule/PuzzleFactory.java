package project;

public class PuzzleFactory{

	private int maxTime = 0 ;
	private int puzzleId = 0;

	
	private IPuzzle currPuzzle = null;
	
	public void setMaxTime(int value){
		if(this.maxTime != 0){
			this.maxTime = value;
		}
	}
	public int getMaxTime(){
		return this.maxTime;
	}
	
	
	//check for possible exceptions
	public IPuzzle getPuzzle(IPuzzle currPuzzle){

			
		//in case of first call
		if(this.currPuzzle == null && puzzleId == 0){
			if(puzzleId < 3) this.puzzleId += 1;
			this.currPuzzle = Puzzle1.getPuzzle1Instance();
			if(this.maxTime != 0) currPuzzle.timer(this.maxTime);
			currPuzzle.setSequenceOfTasks(); //this method does nothing if it had been called once;
		}
		
		else if(currPuzzle != null && puzzleId == 1){
			this.currPuzzle = Puzzle1.getPuzzle1Instance();
			if(this.maxTime != 0) currPuzzle.timer(this.maxTime);
			currPuzzle.setSequenceOfTasks(); //this method does nothing if it had been called once;
		}
		
		else if(currPuzzle != null && puzzleId == 2){
			this.currPuzzle = Puzzle2.getPuzzle2Instance();
			if(this.maxTime != 0) currPuzzle.timer(this.maxTime);
			currPuzzle.setSequenceOfTasks(); //this method does nothing if it had been called once;
		}
		
		//supposedly it will find one of the two puzzles (that are single objects, only the same instance for each puzzle until the game ends)
		return this.currPuzzle;
	}
	
}
