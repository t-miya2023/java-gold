package five.q11;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Q11in {

	public static void main(String[] args)throws Exception{
		// TODO 自動生成されたメソッド・スタブ
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("emp.ser"));
		
		try(in){
			Employee emp = (Employee) in.readObject();
			System.out.println(emp);
		}
	}

}
