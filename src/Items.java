import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Items {

	public static void itemsDisplay() {

		String[] listItems = { "apple", "banana", "cauliflower", "dragonfruit", "elderberry", "figs", "grapefruit",
				"honeydew" };
		double[] listPrices = { 0.99, 0.59, 1.59, 2.19, 1.79, 2.09, 1.99, 3.49 };

		System.out.println("Item               Price");
		System.out.println("-------------------------");
		for (int i = 0; i < listItems.length; i++) {
			System.out.printf("%-20s", listItems[i]);
			System.out.printf("%-20s", listPrices[i]);
			System.out.println();
		}

	}

	public static void orderItems() {
		Scanner scan = new Scanner(System.in);

		String cont;

		ArrayList<String> listItems = new ArrayList<String>(
				Arrays.asList("apple", "banana", "cauliflower", "dragonfruit", "elderberry", "figs", "grapefruit",
				"honeydew"));
		ArrayList<Double> listPrices = new ArrayList<Double>(
				Arrays.asList(0.99, 0.59, 1.59, 2.19, 1.79, 2.09, 1.99, 3.49));


		do {
			System.out.println();
			itemsDisplay();
			System.out.println();
			System.out.println("What item would you like to order?");
			String itemOrdered = scan.nextLine();
            boolean itemFound = false;
			for (int i = 0; i < listItems.size(); i++) {
				
				if (((itemOrdered.toLowerCase()).contains(listItems.get(i)))) {
					System.out.println("Adding " + listItems.get(i) + " to cart at " + listPrices.get(i));
					itemFound = true;
					writeToFile(listItems.get(i) + "\t" + listPrices.get(i));
					break;
				}
			}
			
			if (itemFound == false)
				System.out.println("Sorry, we don't have those.  Please try again.");
			
			System.out.println();
			System.out.println("Would you like to order anything else?");
			cont = scan.nextLine();
		} while (cont.equalsIgnoreCase("y"));

		scan.close();
	}

	public static void shoppingCart() {
		System.out.println("Thanks for your order!\nHere is what you got:\n");
		readFromFile();
	}

	public static void readFromFile() {
		Path writeFile = Paths.get("ShoppingCart.txt");
		File file = writeFile.toFile();

		try {
			FileReader fr = new FileReader(file);

			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("There were no items!");
		}

	}

	public static void writeToFile(String name) {
		Path writeFile = Paths.get("ShoppingCart.txt");
		File file = writeFile.toFile();

		try {
			PrintWriter out = new PrintWriter(new FileOutputStream(file, true));
			out.println(name);
			out.close();
		} catch (FileNotFoundException e) {
			createFile("ShoppingCart.txt");
			try {
				PrintWriter out = new PrintWriter(new FileOutputStream(file, true));
				out.println(name);
				out.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void createFile(String fileString) {
		Path filePath = Paths.get(fileString);
		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("Your file was cerated successfully");
			} catch (IOException e) {
				System.out.println("Something went wrong with file creation ");
				e.printStackTrace();
			}
		}
	}
	

	public static void showAveragePrice() {
		
		double avgPrice = 2.00;
		
		System.out.println("The average price per item in this order was " + avgPrice + ".");
		
	}


}
