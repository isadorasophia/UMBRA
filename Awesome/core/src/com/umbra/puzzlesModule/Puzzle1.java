package project;

import java.util.Hashtable;

public class Puzzle1 implements IPuzzle{

	
	Hashtable<String, Integer> tasks = new Hashtable<String, Integer>();
	private int tasksSet = 0; 
	private boolean isFinished = false;
	
	// the next 3 declarations make the Puzzle 1 a "singleton" object
	private static Puzzle1 instance =  new Puzzle1();
	
	
	private Puzzle1(){
		setSequenceOfTasks();
		setIsFinished(false);
	}
	
	public static Puzzle1 getPuzzle1Instance(){
		return instance;
	}
	
	
	
	public void inputMsg(String msgIn){
	
	}
	
	public void setSequenceOfTasks(){
		if(this.tasksSet == 0){
			
		}
		else {/*Does nothing, tasks already set*/}
	}
	
	//this method changes the status of the current task, if it is completed, returning true if successful;
	//if not successful in changing the current task status returns false;

	public boolean checkCurrTask(String msgIn){
		
		return true;
	}
	public void setNewStatus(){
		
	}
	public void timer(int maxTime){
		//uses the argument to set a timer using the Java timer -> import java.util.Timer; 
	}
	
	public String outputMsg(){
		return "a";
	}
	
	public boolean getIsFinished(){
		return this.isFinished; 
	}
	
	public void setIsFinished(boolean value){
		this.isFinished = value; 
	}
	
}
