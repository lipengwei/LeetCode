package OOP;

abstract class extend {
	private String name;
	private int age;
	
	public extend(){
		this.name = "涨三";
		this.age = 12;
	}
	
	public String getName() {
		return name;
	}
//
//	public void setName(String name) {
//		this.name = "张三";
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
		this.sex = "难";
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


