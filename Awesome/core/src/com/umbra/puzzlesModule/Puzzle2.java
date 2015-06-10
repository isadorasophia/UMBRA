package com.umbra.puzzlesModule;

import java.util.Hashtable;

import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;

import com.umbra.mobModule.itemComponent.impl.ItemManager;
import com.umbra.mobModule.itemComponent.inter.IItemBattle;
import com.umbra.mobModule.itemComponent.inter.IItemManager;
import com.umbra.mobModule.mobComponent.inter.IPlayer;


public class Puzzle2 implements IPuzzle{

	
	private IPlayer player = null;
	
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
	
	public String init(IPlayer playerReceived){
		this.player = playerReceived; 
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
	
	
	
	/*
	 * OBSERVACAO: SE O PLAYER SAIR DO PUZZLE PARA RETORNAR AO PONTO O ARGUMENTO DE INPUTMSG DEVE SER "LAST (ignorecase)"
	 * 
	 * 
	 */
	
	
	public String inputMsg(String msgIn){
		if(getIsFinished() == false){
			this.currMessage = "i don't know what to do!";
			if(msgIn.equalsIgnoreCase("last")) msgIn = "C";
			//in case time is used, checks the time and the player magically dies if the time is elapsed;
			//else if there is no time, then the player progresses! 
			
			if(msgIn.contains("C") && getProgress() == 0){
				completedTasks.put("task0", true);
				completedTasks.put("task1", true);
				if(player.itemsPuzzle().contains("FIGURE"))setProgress();
				currMessage = tasks.get(progress); //sets the next message.
				if(player.itemsPuzzle().contains("FIGURE")) currMessage = currMessage + appendStrings.get("1.1"); // put the figure on the hole;
			}
			else if(msgIn.contains("S") && getProgress() == 0){
				currMessage = tasks.get(progress) + "\n" + tasks.get(progress);
			}
			
			else if(msgIn.contains("P") && getProgress() == 0){
				currMessage = appendStrings.get("3.0") + appendStrings.get("3.0f");
			}
			
			else if(msgIn.contains("P") && getProgress() == 1){			
				completedTasks.put("task2", true);
				completedTasks.put("task3", true);
				completedTasks.put("task4", true);
				setProgress();
				setProgress();
				currMessage = tasks.get(progress) + appendStrings.get("4.a");
				
				player.dropItem("FIGURE");
			}

		
			else if(msgIn.contains("P") && getProgress() == 3){ // only enters here if the item FIGURE has been used
				
				currMessage = appendStrings.get("3.0") + appendStrings.get("3.1s");
				setProgress();
			}
			
			else if(msgIn.contains("C") && getProgress() == 4){
				completedTasks.put("task5", true);
				currMessage = tasks.get(progress);
				if(player.itemsPuzzle().contains("BLADE")) {
					currMessage = currMessage + appendStrings.get("6.1s");
					setProgress();
				}
				else{
					currMessage = "perhaps you should try to find a way to open the stitches. You can:" + appendStrings.get("Exit");
				}
			}
			
			else if(msgIn.contains("O") && getProgress() == 5){
				currMessage = tasks.get(progress);
				setProgress();
			}
			
			else if(msgIn.contains("T") && getProgress() == 6){
				currMessage = tasks.get(progress);
				setProgress();
				completedTasks.put("task6", true);
				
				try {
					IGlobalFactory factory = ComponentContextFactory.createGlobalFactory();
		        	factory.registerPrototype(ItemManager.class);
					IItemManager itemmanager = factory.createInstance(
		        			"<http://purl.org/NET/dcc/com.umbra.mobModule.itemComponent.impl.ItemManager>");
					IItemBattle sword = itemmanager.instantiateItemBattle("SWORD", null);
					player.putItem(sword);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}

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
			this.tasks.put(getThisSetNextKey(), "Passed the door, thereís a giant metal web blocking the center of the room, with something inside but youíre not quite sure what it is. You look around and see blood stains all over the walls repeating the words ìYOU ARE NOT THE ONLY YOUî. At your right, thereís a big round hole in the wall. At your left, a rusted lever almost hidden by the darkness that fills this room. You can [C]heck the hole in the wall, [S]ee whatís inside the web or [P]ull the lever.");
			
			//retrieve key = 1 (+ 1.1 on success)
			this.tasks.put(getThisSetNextKey(), "You come closer and see that inside the hole thereís only darkness. But you know that thereís something that could fit in there.");
			
			//retrieve key = 2 
			this.tasks.put(getThisSetNextKey(), "Getting closer, you can see a humanoid figure lying on a table inside the web. But everything is so dark that you canít really tell if thatís correct.");
			
			//retrieve key = 3 (+ 3.1s on success)
			this.tasks.put(getThisSetNextKey(), "You put the figure into the hole and hears a clicking noise.");
			
			//retrieve key = 4 (+ 6.1s on success)
			this.tasks.put(getThisSetNextKey(), "Thereís a naked corpse on the table with stiches all over itís torso.");
			
			//retrieve key = 5
			this.tasks.put(getThisSetNextKey(), "You take your blade and slowly cuts through the stitches, only to reveal a empty hole inside the corpse, without any organs inside. But what you see is a long sword inside it that goes from inside the corpseís torso through itís head, hiding the tip of the sword. You can [T]ry to remove the sword from inside the corpse.");
			
			//retrieve key = 6
			this.tasks.put(getThisSetNextKey(), "You try to push the sword out of the body, covering your hands in blood. Moving it in the right direction, you succesfully take the sword out of the body and hears an unpleasant click. You stop for a moment and listen some cracks coming from the ceiling. Then, a loud noise echoes through the room followed by an ocean of unknown liquid that drops into your head. Itís blood. You hopelessly panic for a moment, but you canít do a thing. [E]xit the room.");			
			
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
			
			//retrieve key = 3.0
			this.appendStrings.put("3.0", "You grab the lever and pull as hard as you can. It moves a little, but not enough.");
			
			//retrieve key = 3.1s
			this.appendStrings.put("3.1s", " You concentrate all your energy into your arms and succeeds. The metal web starts to get Orange, as if it was getting hot. It was. The metal melts from the bottom quickly and cools down right next to your feet. You can [C]heck what was inside the web.");
			
			//retrieve key = 3.1f
			this.appendStrings.put("3.1f", " You concentrate all your energy into your arms but still fails.");
			
			//retrieve key = 4.a
			this.appendStrings.put("4.a", "\nNow maybe we should try to pull the lever. You can: [P]ull the lever");
			
			//retrieve key = 6.1s
			this.appendStrings.put("6.1s", " You can: [O]pen up the stitches.");
			
			//retrieve key = Exit
			this.appendStrings.put("Exit", " [E]xit the room.");
			
			this.appendFrases = 1; // can't change appendFrases again besides this point and sets the variable to don't enter here again.
			
		}
	}
	
}

	

