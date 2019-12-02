
import java.util.Scanner;
import java.util.Random;

public class VernamCipher {

	public static void main(String[] args) {
		System.out.println("Enter a string");
		Scanner inputScanner = new Scanner( System.in);
		String plainTextString = inputScanner.nextLine();
		char[] plainText = plainTextString.toCharArray();
		char[] key = new char[plainText.length];
		for(int index = 0; index < plainText.length; index++)
		{
			Random generator = new Random();
			key[index] = (char)(generator.nextInt(127));
		}
		char[] cipherText = new char[plainText.length];
		for(int index = 0; index < plainText.length; index++)
		{
			cipherText[index] = (char)(plainText[index] ^ key[index]);
		}
		System.out.println(cipherText);
		for(int index = 0; index < plainText.length; index++)
		{
			cipherText[index] = (char)(cipherText[index] ^ key[index]);
		}
		System.out.println(cipherText);

	}

}
