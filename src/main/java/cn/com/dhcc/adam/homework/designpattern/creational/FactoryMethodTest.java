package cn.com.dhcc.adam.homework.designpattern.creational;

public class FactoryMethodTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Factory fac = new ProductAFactory();
		Product pa = fac.getInstance();
		System.out.println(pa.getName());

		Factory fbc = new ProductBFactory();
		Product pb = fbc.getInstance();
		System.out.println(pb.getName());
	}

}
abstract class Product {
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
class ProductA extends Product{
	ProductA(){
		this.name = "product A's name";
	}
}
class ProductB extends Product{
	ProductB(){
		this.name = "product B's name";
	}
}

abstract class Factory{
	abstract Product getInstance();
}

class ProductAFactory extends Factory{

	@Override
	Product getInstance() {
		return new ProductA();
	}
	
}

class ProductBFactory extends Factory{

	@Override
	Product getInstance() {
		return new ProductB();
	}
	
}