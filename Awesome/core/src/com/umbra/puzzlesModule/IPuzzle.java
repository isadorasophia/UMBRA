package com.umbra.puzzlesModule;

import com.umbra.mobModule.mobComponent.inter.IPlayer;

public interface IPuzzle{
	
	/*		Inteface que possui os metodos responsaveis por receber e enviar mensagens aos puzzles
	 * 		bem como os metodos minimos comuns a configuracao de um puzzle
	 *		@author Daniel Cunha
	 */
	
	
	//receives the player input processes it and calls outputMsg to return the processed input result.
	public String inputMsg(String msgIn);
	
	//used to access the current message to be displayed for the player
	public String outputMsg();

	//if the puzzle has a time, this method is the one who handles the time inside de puzzle 
	public void timer(int maxTime); //time in minutes 
	
	//initializes the sequence of messages to be displayed to the player
	//that will turn into tasks inside the puzzle 
	public void setSequenceOfTasks();
	
	//gets the integer variable responsible for telling if the puzzle is over
	public boolean getIsFinished();
	
	//sets the integer variable responsible for telling if the puzzle is over 
	public void setIsFinished();
	
	//method that sets the puzzle and return its single instance to the caller (Map module)
	public String init(IPlayer playerReceived);
	
	//Verifies if all the tasks are complete, then neutralizes the input processing mechanism
	public void checkCompletion();
	
}
