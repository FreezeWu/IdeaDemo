
public class Animal {
	public String name;
	
	Animal(String name){
		this.name = name;
		System.out.println("This is " + this.name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void eat() {
		System.out.println(this.name + " is eating.");
	}
	
	public void sleep() {
		System.out.println(this.name + " is sleeping.");
	}
	
	public void run() {
		System.out.println(this.name + " is running.");
	}

}

class Carnivores extends Animal{
	
	Carnivores(String name){
		super(name);
	}
	public void eat() {
		System.out.println(this.name + " is eating meet.");
	}
	
}

class Tiger extends Carnivores{	
	public int weight;
	
	Tiger(String name){
		super(name);
	}
	
	Tiger(String name, int weight){
		super(name);
		this.weight = weight;
		
	}
	
	public void getWeight() {
		System.out.println(this.weight);
	}
	
	public void howls(){
		System.out.println(this.name + " howls \"miaowu\"");
	}
}
