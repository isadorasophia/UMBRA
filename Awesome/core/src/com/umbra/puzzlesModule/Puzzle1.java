package com.umbra.puzzlesModule;

import java.util.Hashtable;

import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;

import com.umbra.mobModule.itemComponent.impl.ItemManager;
import com.umbra.mobModule.itemComponent.inter.IItemBattle;
import com.umbra.mobModule.itemComponent.inter.IItemManager;
import com.umbra.mobModule.itemComponent.inter.IItemPuzzle;
import com.umbra.mobModule.mobComponent.impl.MobManager;
import com.umbra.mobModule.mobComponent.inter.IPlayer;


public class Puzzle1 implements IPuzzle {
	
	private IPlayer player = null;
	
	public Hashtable<Integer, String> tasks = new Hashtable<Integer, String>();
	public Hashtable<String, Boolean> completedTasks = new Hashtable<String, Boolean>();
	private int tasksSet = 0; 
	private boolean isFinished = false;
	private int hasTheBlade = 0;
	private int hasTheFigure = 0;
	private int key = 0;
	private int progress = 0;
	public String currMessage;
	public int left = 0;

	
	
	// the next 3 declarations make the Puzzle 1 a "singleton" object
	private static Puzzle1 instance =  new Puzzle1();
	
	
	private Puzzle1(){
	}
	
	public static Puzzle1 getPuzzle1Instance(){
		return instance;
	}
	
	public String init(IPlayer playerReceived){
		this.player = playerReceived; 
		if(tasksSet == 0) {
			setSequenceOfTasks();
			setIsFinished(false);
			this.currMessage = tasks.get(progress);
			return outputMsg();
		}
		else{
			return "This puzzle has been set already";
		}
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
				currMessage = tasks.get(progress); 
			}
			else if(msgIn.equalsIgnoreCase("L") && getProgress() == 1){
				completedTasks.put("task1", true);
				setProgress();
				currMessage = tasks.get(progress); //returns the next message.
				
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
					completedTasks.put("task5", true);
					setProgress();
					setProgress(); //advances the progress variable to point to task 5
					this.hasTheBlade = 1;
					currMessage = tasks.get(progress);
					if(hasTheFigure == 0) currMessage = tasks.get(progress)   + "\nBut still, there is that round-shaped figure on the ground... You can: [T]ake the figure.";
					try {
						IGlobalFactory factory = ComponentContextFactory.createGlobalFactory();
			        	factory.registerPrototype(ItemManager.class);
						IItemManager itemmanager = factory.createInstance(
			        			"<http://purl.org/NET/dcc/com.umbra.mobModule.itemComponent.impl.ItemManager>");
						IItemBattle blade = itemmanager.instantiateItemBattle("BLADE", null);
						player.putItem(blade);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
	
			
			else if(msgIn.equalsIgnoreCase("T") && getProgress() == 2){
				completedTasks.put("task4", true);
				setProgress();
				setProgress();//advances the progress variable to point to task 4
				this.hasTheFigure = 1;
				currMessage = tasks.get(progress);
				if(hasTheBlade == 0) currMessage = tasks.get(progress) + "\nBut still, there is that wooden box sitting there... You can: [O]pen the wooden box.";
				
				
				try {
					IGlobalFactory factory = ComponentContextFactory.createGlobalFactory();
		        	factory.registerPrototype(ItemManager.class);
					IItemManager itemmanager = factory.createInstance(
		        			"<http://purl.org/NET/dcc/com.umbra.mobModule.itemComponent.impl.ItemManager>");
					IItemPuzzle figure = itemmanager.instantiateItemPuzzle("FIGURE", null);
					player.putItem(figure);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
	
				//Only sets the task 2 as true here, if the player is coming back to take the remaining item,
				//the blade in this case
				if(completedTasks.get("task3") == true && completedTasks.get("task5") == true)
					completedTasks.put("task2", true);
				
			}
				
			
				
			if((completedTasks.get("task3") == true && completedTasks.get("task5") == true && completedTasks.get("task2") == false) || (completedTasks.get("task4") == true && completedTasks.get("task2") == false)){ 
				
				this.progress = 2; //if entering Puzzle1.inputMsg() to get the left behind item it will start in the correct place.
				
			}
			checkCompletion(); //next time it enters Puzzle1.inputMsg(), it will stop working in case PuzzleCompletion;
			if(isFinished == true) currMessage = currMessage + "\nThis puzzle is over.";
			return outputMsg();
		}	
		return "This puzzle is over!";
	}
		
	
	
	public void setSequenceOfTasks(){
		// acts only one time
		// 'key' here is used only for populating hash table
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
			
			this.tasksSet = 1; // can't change tasksSet again besides this point and sets the variable to don't enter here again.
			
		}
		else {/*Does nothing, tasks already set*/}
	}
	
	//this method changes the status of the current task, if it is completed, returning true if successful;
	//if not successful in changing the current task status returns false;

	public void checkCompletion(){
		int i, flag = 1;
		for(i = 0; i < 6; i++){
			if(completedTasks.get("task"+i) == false)
				flag = 0;
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
