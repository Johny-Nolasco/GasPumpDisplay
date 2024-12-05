public class GasPumpTester{
	public static void main(String[] args) {
        int numberOfDigits = 3; // Number of positions in the display
        int maxDigit = 4;       // Digits range from 0 to maxDigit inclusive (0 to 4)

        GasPumpDisplay display = new GasPumpDisplay(numberOfDigits, maxDigit);

        while (display.hasMoreElements()) {
            System.out.print(display.nextElement() + " ");
        }
    }
}