package edu.mu;

public class Main {

	//creating connor branch

	public static void main(String[] args) {
		StockManagerSingleton stockManager = new StockManagerSingleton();
		stockManager.initalizeStock();
		stockManager.print();

	}

}
