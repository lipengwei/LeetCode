package OOP;

abstract class extend {
	private String name;
	private int age;
	
	public extend(){
		this.name = "����";
		this.age = 12;
	}
	
	public String getName() {
		return name;
	}
//
//	public void setName(String name) {
//		this.name = "����";
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = 14;
//	}
	
	public void run() {
	}
}

class Person1 extends extend{
	private String sex;
	private int high;
	public Person1(){
		this.sex = "��";
		this.high = 174;
	}
//	public String getName() {
//		return super.getName();
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
	public void run(){
		System.out.println("Person1 run.....");
	}
}


