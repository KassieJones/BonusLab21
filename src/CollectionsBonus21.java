import java.util.Scanner;

public class CollectionsBonus21 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to Guenther's Market!");
		System.out.println();

		Items.orderItems();
		System.out.println();
		
		Items.shoppingCart();
		System.out.println();
		
		Items.showAveragePrice();

		scan.close();
	}


}
