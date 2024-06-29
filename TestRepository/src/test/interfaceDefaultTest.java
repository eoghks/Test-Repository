package test;

interface Car {
	default void move(){
		System.out.println("부릉 부릉");
	}
}

class Benz implements Car{
}

public class interfaceDefaultTest {
	public static void main(String[] args) {
		Benz benz = new Benz();
		benz.move();
	}
}
