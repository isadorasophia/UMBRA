package com.umbra.puzzlesModule;

public class PuzzleFactory{

	private int maxTime = 0 ;
	
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
	
	// mus pass the number of the wanted puzzle
	public IPuzzle getPuzzle(int puzzleNum){

		
		if(puzzleNum == 1){
			this.currPuzzle = Puzzle1.getPuzzle1Instance();
			if(this.maxTime != 0) currPuzzle.timer(this.maxTime);
			puzzleNum++;
			//currPuzzle.setSequenceOfTasks(); //this method does nothing if it had been called once;
		}
		
		else if(puzzleNum == 2){
			this.currPuzzle = Puzzle2.getPuzzle2Instance();
			if(this.maxTime != 0) currPuzzle.timer(this.maxTime);
            puzzleNum++;
			//currPuzzle.setSequenceOfTasks(); //this method does nothing if it had been called once;
		} else this.currPuzzle = null;
		
		//supposedly it will find one of the two puzzles (that are single objects, only the same instance for each puzzle until the game ends)
		return this.currPuzzle;
	}
	
}
