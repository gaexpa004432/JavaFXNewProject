package teamProject;

import javafx.beans.property.SimpleStringProperty;

public class Customer {
	private SimpleStringProperty id;
	private SimpleStringProperty adress;
	private SimpleStringProperty name;
	private SimpleStringProperty phone;
	
	public Customer(String id, String adress,
			String name, String phone) {
		this.id = new SimpleStringProperty(id);
		this.adress = new SimpleStringProperty(adress);
		this.name = new SimpleStringProperty(name);
		this.phone = new SimpleStringProperty(phone);
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
