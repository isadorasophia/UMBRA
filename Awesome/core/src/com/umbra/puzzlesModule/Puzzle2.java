package com.umbra.puzzlesModule;

import java.util.Hashtable;


public class Puzzle2 implements IPuzzle{

	
	//private Iplayer player = null;
	
	Hashtable<Integer, String> tasks = new Hashtable<Integer, String>();
	Hashtable<String, Boolean> completedTasks = new Hashtable<String, Boolean>();
	private int tasksSet = 0; 
	private boolean isFinished = false;
	private int key = 0;
	private int progress = 0;
	public String currMessage;

	
	
	// the next 3 declarations make the Puzzle 1 a "singleton" object
	private static Puzzle2 instance =  new Puzzle2();
	
	
	private Puzzle2(){
		
	}
	
	public static Puzzle2 getPuzzle2Instance(){
		return instance;
	}
	
	public String init(/*Iplayer playerReceived*/){
		//this.player = playerReceived; 
		setSequenceOfTasks();
		setIsFinished(false);
		this.currMessage = tasks.get(progress);
		return outputMsg();
	}
	
	//the inputMsg method calls the outputMsg method for returning the string
	//each condition of this method sets a different currMessage that will be returned to the caller
	public String inputMsg(String msgIn){
		if(getIsFinished() == false){
			this.currMessage = "i don't know what to do!";
			
			//in case time is used, checks the time and the player magically dies if the time is elapsed;
			//else if there is no time, then the player progresses! 
			if(msgIn.equalsIgnoreCase("C") && getProgress() == 0){
				completedTasks.put("task0", true);
				setProgress();
				currMessage = tasks.get(progress); //sets the next message.
			}
			else if(msgIn.equalsIgnoreCase("L") && getProgress() == 1){
				currMessage = tasks.get(progress);
				setProgress();
				completedTasks.put("task1", true);
			}
			//takes a decision here
			else if(msgIn.equalsIgnoreCase("O") && getProgress() == 2){			
				setProgress();
				currMessage = tasks.get(progress);
				//Only sets the task 2 as true here, if the player is coming back to take the remaining item,
				//the picture in this case
				if(completedTasks.get("task4") == true)
					completedTasks.put("task2", true); //here the blade is with the player already, then the puzzle is almost completed.
			}
			
	
				//took the open box decision -> blade path
				else if(msgIn.equalsIgnoreCase("T") && getProgress() == 3){
					completedTasks.put("task3", true);
					setProgress();
					setProgress();//advances the progress variable to point to task 5
					currMessage = tasks.get(progress);
					completedTasks.put("task5", true);
					
					//player.putItem("theBlade");
					
				}
	
			
			else if(msgIn.equalsIgnoreCase("T") && getProgress() == 2){
				currMessage = tasks.get(progress);
				setProgress();
				setProgress();//advances the progress variable to point to task 4
				completedTasks.put("task4", true);
	
				
				//player.putItem("theFigure");
				
	
				//Only sets the task 2 as true here, if the player is coming back to take the remaining item,
				//the blade in this case
				if(completedTasks.get("task3") == true && completedTasks.get("task5") == true)
					completedTasks.put("task2", true);
				
			}
				
				
			if((completedTasks.get("task3") == true && completedTasks.get("task5") == true && completedTasks.get("task2") == false) || (completedTasks.get("task4") == true && completedTasks.get("task2") == false)) 
				this.progress = 2;
			checkCompletion(); //next time it enters inputMsg(), it will stop working in case PuzzleCompletion;
			return outputMsg();
		}	
		return "This puzzle is over!";
	}
		
	
	
	public void setSequenceOfTasks(){
		// acts only one time
		// 'key' here is used only for populating the 
		if(this.tasksSet == 0){
			int i;
			//retrieve key = 0
			this.tasks.put(getThisSetNextKey(), "As you enter the room, you see only a little point of light in the left corner. You can [C]heck the light.");
			
			//retrieve key = 1
			this.tasks.put(getThisSetNextKey(), "While you walk slowly toward the light, you sense an object touching your feet. Trumbling, you fall on your knees trying to hold on to anything you can find. On the ground, you realize that the light was only a candle, almost running out. There�s a big candlestick on the wall. You can [L]ight the candlestick.");
			
			//retrieve key = 2
			this.tasks.put(getThisSetNextKey(), "You take the candle and use it to light the candlestick. The whole room lights up. You see a little table in the middle of the room with a wooden box sitting there. On the ground, there�s a big figure of a snake carved into a round shape of an unknown material, and that was probably what made you fall. You can [O]pen the wooden box or [T]ake the figure.");
			
			//retrieve key = 3
			this.tasks.put(getThisSetNextKey(), "Your hands shake uncontrollably and you try to make them steady with no success. The wooden box creaks, filling the whole room with the noise. When you finally opened enough to see what�s inside, you notice a black liquid floating inside it. Fearfully, you put your hands inside the box, sensing a metalic material through the gooey liquid. It�s a medium sized metal blade. You can [T]ake the blade.");
			
			//retrieve key = 4
			this.tasks.put(getThisSetNextKey(), "You took the figure.");
			
			//retrieve key = 5
			this.tasks.put(getThisSetNextKey(), "You took the blade.");
			
			for(i = 0; i < 6; i++)
				completedTasks.put("task"+i, false);
			
		}
		else {/*Does nothing, tasks already set*/}
	}
	
	//this method changes the status of the current task, if it is completed, returning true if successful;
	//if not successful in changing the current task status returns false;

	public void checkCompletion(){
		int i, flag = 1;
		for(i = 0; i < 6; i++){
			if(completedTasks.get("task"+i) == false){
				flag = 0;
				break;
			}
				
		}
		
		if (flag == 1) setIsFinished();
	}

	public void timer(int maxTime){
		//uses the argument to set a timer using the Java timer -> import java.util.Timer; 
	}
	
	public String outputMsg(){
		return this.currMessage;
	}
	
	public boolean getIsFinished(){
		return this.isFinished; 
	}
	
	public void setIsFinished(){
		this.isFinished = true;
	}
	
	public void setIsFinished(boolean value){
		this.isFinished = value; 
	}
	
	public int getThisSetNextKey(){
		int aux;
		aux = this.key;
		setKey();
		return aux;
	}
	
	public void setKey(){
		if(key < 6)
			this.key += +1;
	}
	
	public void setProgress(){
		if(this.progress < 6)
			this.progress += 1;
	}
	
	public void defineProgress(int progr){
		if(progr < 6 && progr >= 0)
			this.progress = progr;
	}
	
	public int getProgress(){
		return this.progress;
	}
}

	

