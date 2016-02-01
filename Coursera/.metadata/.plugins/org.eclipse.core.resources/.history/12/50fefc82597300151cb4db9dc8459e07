package testing;
import java.util.*;

public class SortTest {
	public void main(String args[]) {
		
		ArrayList<Animal> animals = new ArrayList();
		
		animals.add(new Animal("fido",4,2));
		animals.add(new Animal("rufus",4,2));
		animals.add(new Animal("sally",4,2));
		animals.add(new Animal("scout",4,2));
		animals.add(new Animal("gem",4,2));
		animals.add(new Animal("tiger",4,2));
		animals.add(new Animal("fluffy",4,2));
		animals.add(new Animal("thor",4,2));
		animals.add(new Animal("brutus",4,2));
		animals.add(new Animal("bill",4,2));
		
		for (Animal a: animals) {
			System.out.println(a);
		}
		
		
		
	}
	
}


class Animal implements Comparable<Animal>{
	private String name;
	private int numLegs;
	private int numEyes;
	
	public Animal(String thename, int numOfLegs, int numOfEyes) 
	{
		name = thename;
		numLegs = numOfLegs;
		numEyes = numOfEyes;
		
	}
	
	public void setNumLegs(int legs){ numLegs = legs; }
	public void setNumEyes(int eyes){ numEyes = eyes; }
	public void setName(String theName){ name = theName; }
	
	public int getNumLegs(){ return this.numLegs; }
	public int getNumEyes(){ return this.numEyes; }
	public String getName(){ return this.name; }
	
	public int compareTo(Animal a){ 
		return (this.getName()).compareTo(a.getName());
		
	}
}