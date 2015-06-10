package project;

import java.util.Hashtable;


public class Puzzle2 implements IPuzzle{

	
	//private Iplayer player = null;
	
	Hashtable<Integer, String> tasks = new Hashtable<Integer, String>();
	Hashtable<String, Boolean> completedTasks = new Hashtable<String, Boolean>();
	Hashtable<String, String> appendStrings = new Hashtable<String, String>(); //<Key, Value>
	private int tasksSet = 0;
	private int appendFrases = 0;
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
		if (appendFrases == 0 && tasksSet == 0){
			setSequenceOfTasks();
			setAppendFrases();
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
				currMessage = tasks.get(progress); //sets the next message.
			}
			else if(msgIn.equalsIgnoreCase("L") && getProgress() == 1){
				currMessage = tasks.get(progress);
				setProgress();
				
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
			this.tasks.put(getThisSetNextKey(), "Passed the door, there’s a giant metal web blocking the center of the room, with something inside but you’re not quite sure what it is. You look around and see blood stains all over the walls repeating the words “YOU ARE NOT THE ONLY YOU”. At your right, there’s a big round hole in the wall. At your left, a rusted lever almost hidden by the darkness that fills this room. You can [C]heck the hole in the wall, [S]ee what’s inside the web or [P]ull the lever.");
			
			//retrieve key = 1 (+ 1.1 on success)
			this.tasks.put(getThisSetNextKey(), "You come closer and see that inside the hole there’s only darkness. But you know that there’s something that could fit in there.");
			
			//retrieve key = 2 
			this.tasks.put(getThisSetNextKey(), "Getting closer, you can see a humanoid figure lying on a table inside the web. But everything is so dark that you can’t really tell if that’s correct.");
			
			//retrieve key = 3 (+ 3.1s on success)
			this.tasks.put(getThisSetNextKey(), "You put the figure into the hole and hears a clicking noise.");
			
			//retrieve key = 4 (+ 6.1s on success)
			this.tasks.put(getThisSetNextKey(), "There’s a naked corpse on the table with stiches all over it’s torso.");
			
			//retrieve key = 5
			this.tasks.put(getThisSetNextKey(), "You take your blade and slowly cuts through the stitches, only to reveal a empty hole inside the corpse, without any organs inside. But what you see is a long sword inside it that goes from inside the corpse’s torso through it’s head, hiding the tip of the sword. You can [T]ry to remove the sword from inside the corpse.");
			
			//retrieve key = 6
			this.tasks.put(getThisSetNextKey(), "You try to push the sword out of the body, covering your hands in blood. Moving it in the right direction, you succesfully take the sword out of the body and hears an unpleasant click. You stop for a moment and listen some cracks coming from the ceiling. Then, a loud noise echoes through the room followed by an ocean of unknown liquid that drops into your head. It’s blood. You hopelessly panic for a moment, but you can’t do a thing. [E]xit the room.");			
			
			for(i = 0; i < 7; i++)
				completedTasks.put("task"+i, false);
			
			this.tasksSet = 1; // can't change tasksSet again besides this point and sets the variable to don't enter here again.
			
		}
		else {/*Does nothing, tasks already set*/}
	}
	
	//this method changes the status of the current task, if it is completed, returning true if successful;
	//if not successful in changing the current task status returns false;

	public void checkCompletion(){
		int i, flag = 1;
		for(i = 0; i < 7; i++){
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
		if(key < 7)
			this.key += +1;
	}
	
	public void setProgress(){
		if(this.progress < 7)
			this.progress += 1;
	}
	
	public void defineProgress(int progr){
		if(progr < 7 && progr >= 0)
			this.progress = progr;
	}
	
	public int getProgress(){
		return this.progress;
	}
	
	
	public void setAppendFrases(){
		
		if(this.appendFrases == 0){
		
			//retrieve key = 1.1
			this.appendStrings.put("1.1", " [P]ut the snake figure into the hole");
			
			//retrieve key = 3.1s
			this.appendStrings.put("3.1s", " You concentrate all your energy into your arms and succeeds. The metal web starts to get Orange, as if it was getting hot. It was. The metal melts from the bottom quickly and cools down right next to your feet. You can [C]heck what was inside the web.");
			
			//retrieve key = 3.1f
			this.appendStrings.put("3.1f", " You concentrate all your energy into your arms but still fails.");
			
			//retrieve key = 4
			this.appendStrings.put("6.1s", " You can [O]pen up the stitches.");
			
			//retrieve key = 5
			this.appendStrings.put("Exit", " [E]xit the room.");
			
			this.appendFrases = 1; // can't change appendFrases again besides this point and sets the variable to don't enter here again.
			
		}
	}
	
}

	

