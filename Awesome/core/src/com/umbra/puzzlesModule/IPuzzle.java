package project;

public interface IPuzzle{
	
	public void inputMsg(String msgIn);
	public String outputMsg();
	public boolean checkCurrTask(String msgIn);
	public void setNewStatus();
	public void timer(int maxTime); //time in minutes 
	public void setSequenceOfTasks();
}
