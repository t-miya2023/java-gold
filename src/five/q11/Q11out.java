package five.q11;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Q11out {

	public static void main(String[] args) throws Exception{
		// TODO 自動生成されたメソッド・スタブ
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("emp.ser"));
		
		try(out){
			Employee emp = new Employee("sample", "0120111111");
			out.writeObject(emp);
		}
	}

}
