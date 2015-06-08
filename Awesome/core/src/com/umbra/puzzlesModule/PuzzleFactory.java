package project;

public class PuzzleFactory{

	private int maxTime = 0 ;
	private int puzzleId = 0;
	
	private IPuzzle currPuzzle = null;
	
	//used to start the next puzzle
	public void init(int time){
		this.maxTime = time;
		if(puzzleId == 0){
			this.puzzleId += 1; // certainly it will get the first puzzle instance;
			this.currPuzzle = Puzzle1.getPuzzle1Instance(); // then Puzzle1.[...];
			getPuzzle(this.currPuzzle);
		}
		// if there is a puzzle started, then does nothing;
	}
	
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
			currPuzzle.setSequenceOfTasks();
		}
		
		else if(this.currPuzzle != null && puzzleId == 1){
			this.currPuzzle = Puzzle1.getPuzzle1Instance();
			if(this.maxTime != 0) currPuzzle.timer(this.maxTime);
			currPuzzle.setSequenceOfTasks();
		}
		
		else if(this.currPuzzle != null && puzzleId == 2){
			this.currPuzzle = Puzzle2.getPuzzle2Instance();
			if(this.maxTime != 0) currPuzzle.timer(this.maxTime);
			currPuzzle.setSequenceOfTasks();
		}
		
		//supposedly it will find one of the two puzzles
		return this.currPuzzle;
	}
	
}
