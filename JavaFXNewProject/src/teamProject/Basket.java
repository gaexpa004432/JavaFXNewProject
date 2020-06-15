package teamProject;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Basket {
	private String myid;
	private int myrest;
	private int myfood;
	public int getMyrest() {
		return myrest;
	}

	public void setMyrest(int myrest) {
		this.myrest = myrest;
	}

	public int getMyfood() {
		return myfood;
	}

	public void setMyfood(int myfood) {
		this.myfood = myfood;
	}

	public String getMyid() {
		return myid;
	}

	private SimpleStringProperty custId;
	private SimpleStringProperty restId;
	private SimpleIntegerProperty foodId;
	
	public Basket(String custId, String restId, int foodId) {
		this.custId = new SimpleStringProperty(custId);
		this.restId = new SimpleStringProperty(restId);
		this.foodId = new SimpleIntegerProperty(foodId);
	}

	public Basket() {
	}

	public SimpleStringProperty getCustId() {
		return custId;
	}
	public void setCustId(SimpleStringProperty custId) {
		this.custId = custId;
	}

	public SimpleStringProperty getRestId() {
		return restId;
	}

	public void setRestId(SimpleStringProperty restId) {
		this.restId = restId;
	}

	public SimpleIntegerProperty getFoodId() {
		return foodId;
	}

	public void setFoodId(SimpleIntegerProperty foodId) {
		this.foodId = foodId;
	}

	public void setMyid(String myid) {
		this.myid = myid;
		
	}
	
	

}
