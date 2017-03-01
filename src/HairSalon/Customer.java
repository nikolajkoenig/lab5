package HairSalon;

public class Customer {

	private int id;
	boolean dissatisfied = false;
	
	public Customer(int id) {
		this.id=id;
	}
	
	public void beDissatisfied(){
		dissatisfied = true;
	}
		
	public boolean isDissatisfied(){
		return dissatisfied;
	}
}
