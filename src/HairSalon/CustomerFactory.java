package HairSalon;

public class CustomerFactory {

	int id = 0;
	
	public Customer createCustomer(){
		return new Customer(id++);
	}
}