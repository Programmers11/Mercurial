package printertest;
//author ASA

public class TableEntryPrinter {

	// Row row;
	static int availableWidth = 200; //pixels in the width of recipt
	static int availableWidth2;

	//1 qty 2 rem 3 name 4 price
	static String TheCalculator(Object qty, Object name, Object price) {
		availableWidth2 = availableWidth;
		String result = "";

		result = spacerLoop(4 - qty.toString().length(), result);// qty cannot be of more than 4 digits!!!
		result += qty;
		result = spacerLoop(10, result);// gap bw qty and name

		// availableWidth -= 8;
		result = result + name.toString().toUpperCase(); // result string has qty + name
//((StringManip.fontsInLine2(result, size) + StringManip.fontsInLine2(amount, size) + startingPoint) - avlblw)
		//+ price.toString().length()
		while (0 > (StringManip.fontsInLine(result) + StringManip.fontsInLine(price.toString())) - availableWidth - 30) {
			result = result + " ";
		}
		// System.out.println(result);
		result = result + price;
		//System.out.println(result);

		return result;
	}

	static String TheCalculator(String amount, int startingPoint, int avlblw, int size) {
		String result = "";
		/*200 - amoun*/
		//+ amount.length()
		//System.out.println("Available Width is " + avlblw + "\t" + StringManip.fontsInLine2(result, size));
		while (0 > ((StringManip.fontsInLine2(result, size) + StringManip.fontsInLine2(amount, size) + startingPoint) - avlblw)) {
			//System.out.println(avlblw - (StringManip.fontsInLine2(result, size) + startingPoint));
			result = result + " ";
		}
		result = result + amount;
		return result;
	}

	static String TheCalculator(Object qty, Object name, Object price, int width) {
		availableWidth2 = width;
		String result = "";

		result = spacerLoop(4 - qty.toString().length(), result);// qty cannot be of more than 4 digits!!!
		result += qty;
		result = spacerLoop(10, result);// gap bw qty and name

		// availableWidth -= 8;
		result = result + name; // result string has qty + name
		result = spacerLoop(20, result);// gap bw qty and nam
		//availableWidth2 -= result.length();
		//result =  spacerLoop(availableWidth2 - 8 - price.toString().length(), result); //math shit to adjust price
		result = result + price;
		// System.out.println(result);

		return result;
	}

	static String TheCalculator(String remarks) {

		return remarks;
		//

	}

	//for including n spaces after a string
	static String spacerLoop(int number, String str) {
		String a = str;
		for (int i = 0; i < number; i++) {
			a = a + " ";
		}
		return a;
	}
}
