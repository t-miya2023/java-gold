package five.q11;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable{
	private String name;
	private String telephone;
	
	public Employee(String name, String telephone) {
		this.name = name;
		this.telephone = telephone;
	}
	//カスタム・シリアライズ 渡すフィールドを指定できる
	private void writeObject(ObjectOutputStream out) throws IOException{
		System.out.println("write");
		out.writeObject(name);
//		out.writeObject(telephone);
	}
	//カスタム・デシリアライズ
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
		System.out.println("read");
		this.name = (String) in.readObject();
		//this.telephone = (String) in.readObject();
	}
	
	@Override
	public String toString() {
		return "Employee[name =" + name + ", telephone = " + telephone +"]";
		//telephoneは出力されていないためnullになる
	}
}
