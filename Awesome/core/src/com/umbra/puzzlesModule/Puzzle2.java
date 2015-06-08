package project;

import java.util.Hashtable;

public class Puzzle2 implements IPuzzle{

	
	Hashtable<String, Integer> tasks = new Hashtable<String, Integer>();
	private int tasksSet = 0;
	private boolean isFinished = false;
	
	// the next 3 declarations make the Puzzle 2 a "singleton" object
	private static Puzzle2 instance =  new Puzzle2();
	
	
	private Puzzle2(){
		setSequenceOfTasks();
		setIsFinished(false);
	}
	
	public static Puzzle2 getPuzzle2Instance(){
		return instance;
	}
	
	public void inputMsg(String msgIn){
		
	}
	
	public void setSequenceOfTasks(){
		if(this.tasksSet == 0){
			
		}
		else {/*Does nothing, tasks already set*/}
	}
	
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

	

