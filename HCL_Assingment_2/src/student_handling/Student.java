package student_handling;

public class Student {
	private String rollno;
	private String name;
	private int age;
		public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student{" + "Student Name= "+ name +",Student Roll_No="+rollno+",Student Age="+age+" }";
		
	}
	
	
	

}
