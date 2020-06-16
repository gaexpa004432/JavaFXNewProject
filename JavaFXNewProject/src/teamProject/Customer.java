package teamProject;

import javafx.beans.property.SimpleStringProperty;

public class Customer {
	private SimpleStringProperty id; //addlistener를 사용할수 있게해주는 SimpleStringProperty 타입의 id 변수 선언
	private SimpleStringProperty adress; //addlistener를 사용할수 있게해주는 SimpleStringProperty 타입의 adress 변수 선언
	private SimpleStringProperty name; //addlistener를 사용할수 있게해주는 SimpleStringProperty 타입의 name 변수 선언
	private SimpleStringProperty phone; //addlistener를 사용할수 있게해주는 SimpleStringProperty 타입의 phone 변수 선언
	private SimpleStringProperty password; //addlistener를 사용할수 있게해주는 SimpleStringProperty 타입의 password 변수 선언
	
	//Customer 생성자 생성. 초기화 값은 tring id, String adress,String name, String phone ,String password
	public Customer(String id, String adress,
			String name, String phone ,String password) {
		this.id = new SimpleStringProperty(id);  //전역변수 id를 뉴 인스턴스 SimpleStringProperty(id)에 저장
		this.adress = new SimpleStringProperty(adress);  //전역변수 adress를 뉴 인스턴스 SimpleStringProperty(adress)에 저장
		this.name = new SimpleStringProperty(name);  //전역변수 id를 뉴 인스턴스 SimpleStringProperty(id)에 저장
		this.phone = new SimpleStringProperty(phone);  //전역변수 name를 뉴 인스턴스 SimpleStringProperty(name)에 저장
		this.password = new SimpleStringProperty(password);  //전역변수 password를 뉴 인스턴스 SimpleStringProperty(password)에 저장
	}
	
	//Customer 생성자 생성. 초기화 값은 String id,String password
	public Customer(String id,String password) {
		this.id = new SimpleStringProperty(id);  //전역변수 id를 뉴 인스턴스 SimpleStringProperty(id)에 저장
		this.password = new SimpleStringProperty(password);  //전역변수 password를 뉴 인스턴스 SimpleStringProperty(password)에 저장
	}
	
	//겟셋메소드들
	public String getPassword() {
		return password.get();
	}
	public void setPassword(String password) {
		this.password.set(password);
	}
	public SimpleStringProperty passwordProperty() {
		return this.password;
	}
	public String getId() {
		return id.get();
	}
	public void setId(String id) {
		this.id.set(id);
	}
	public SimpleStringProperty idProperty() {
		return this.id;
	}
	public String getAdress() {
		return adress.get();
	}
	public void setAdress(String adress) {
		this.adress.set(adress);
	}
	public SimpleStringProperty adressProperty() {
		return this.adress;
	}
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public SimpleStringProperty nameProperty() {
		return this.name;
	}
	public String getPhone() {
		return phone.get();
	}
	public void setPhone(String phone) {
		this.phone.set(phone);
	}
	public SimpleStringProperty phoneProperty() {
		return this.phone;
	}

}
