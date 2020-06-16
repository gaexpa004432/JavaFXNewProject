package teamProject;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Basket {  //바스켓클래스선언
	private String myid; //같은클래스 내부에만 접근가능한 문자타입 myid 변수 선언
	private int myrest; //같은클래스 내부에만 접근가능한 int타입 myrest 변수 선언
	private int myfood; //같은클래스 내부에만 접근가능한 int타입 myfood 변수 선언
	
	public int getMyrest() {  //getMyrest() 생성자 생성
		return myrest;  // return값은 myrest
	}

	public void setMyrest(int myrest) {  //setMyrest(int myrest) 생성자생성
		this.myrest = myrest;  // myrest변수를 myrest전역변수에 넣음
	}

	public int getMyfood() {  //getMyfood() 생성자생성
		return myfood;  // return값은 myfood
	}

	public void setMyfood(int myfood) {  //setMyfood(int myfood) 생성자생성
		this.myfood = myfood;  // myfood변수를 myfood전역변수에 넣음
	}

	public String getMyid() {  //getMyid() 생성자생성
		return myid;  // return값은 myid
	}

	private SimpleStringProperty custId; //addlistener를 사용할수 있게해주는 SimpleStringProperty 타입의 custId 변수 선언
	private SimpleStringProperty restId; //addlistener를 사용할수 있게해주는 SimpleStringProperty 타입의 restId 변수 선언
	private SimpleIntegerProperty foodId; //addlistener를 사용할수 있게해주는 SimpleStringProperty 타입의 foodId 변수 선언
	
	//Basket 생성자 사용하면 custId,restId,foodId를 초기화하게 선언
	//메소드 안에 SimpleStringProperty의 변수값들을 전역변수안에다가 넣음
	public Basket(String custId, String restId, int foodId) { 
		this.custId = new SimpleStringProperty(custId);
		this.restId = new SimpleStringProperty(restId);
		this.foodId = new SimpleIntegerProperty(foodId);
	}

	//Basket 빈 생성자 생성
	public Basket() {
	}

	//getCustId 메소드 생성 후 리턴값은 custId로
	public SimpleStringProperty getCustId() {
		return custId;
	}
	
	//setCustId 메소드 생성 후  입력받을 값은 SimpleStringProperty타입의 custId로 받기
	public void setCustId(SimpleStringProperty custId) {
		this.custId = custId;  //SimpleStringProperty custId는 전역변수 custId에 담기
	}

	//SimpleStringProperty getRestId() 메소드 생성 리턴값은 restId
	public SimpleStringProperty getRestId() {
		return restId;
	}

	//setRestId(SimpleStringProperty restId) 메소드 생성
	public void setRestId(SimpleStringProperty restId) {
		this.restId = restId;  //SimpleStringProperty restId는 전역변수 restId에 담기
	}

	//SimpleIntegerProperty getFoodId() 메소드 생성  리턴값은 foodId
	public SimpleIntegerProperty getFoodId() {
		return foodId;
	}

	//setFoodId(SimpleIntegerProperty foodId) 메소드 생성
	public void setFoodId(SimpleIntegerProperty foodId) {
		this.foodId = foodId;  //SimpleStringProperty foodId는 전역변수 foodId에 담기
	}

	//setMyid(String myid) 메소드 생성
	public void setMyid(String myid) {
		this.myid = myid;  //String myid는 전역변수 myid에 담기
		
	}
	
	

}
