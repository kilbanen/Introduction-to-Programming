import java.util.Random;
import java.util.Scanner;

public class Cipher {

	public static void main(String[] args) {
		
		String plainText = "abcdefghijklmnopqrstuvwxyz ";
		char[] plainTextArray = plainText.toCharArray();
		char[] cipherTextArray = createCipher(plainTextArray);
		System.out.println("This is your cipher:");
		System.out.println(plainTextArray);
		System.out.println(cipherTextArray);
		while(true)
		{
			System.out.println("Please type a word or phrase.");
			Scanner inputScanner = new Scanner( System.in );
			String phrase = inputScanner.nextLine();
			phrase = phrase.toLowerCase();
			char[] phraseArray = phrase.toCharArray();
			char[] encryptedPhraseArray = encrypt(phraseArray, plainTextArray, cipherTextArray);
			System.out.println("Encrypted phrase: " + new String(encryptedPhraseArray));
			char[] decryptedPhrase = decrypt(encryptedPhraseArray, plainTextArray, cipherTextArray);
			System.out.println("Decrypted phrase: " + new String(decryptedPhrase));
		}
		
	}

	public static char[] createCipher(char[] plainTextArray)
	{
		char[] cipherTextArray = plainTextArray.clone();
		Random generator = new Random();
		for (int index = 0; index < cipherTextArray.length; index++)
		{
			int otherIndex = generator.nextInt(cipherTextArray.length);
			char temporaryCharacter = cipherTextArray[otherIndex];
			cipherTextArray[otherIndex] = cipherTextArray[index];
			cipherTextArray[index] = temporaryCharacter;
		}
		return cipherTextArray;
	}
	
	public static char[] encrypt (char[] phraseArray, char[] plainTextArray, char[] cipherTextArray)
	{
		char[] encryptedPhraseArray = phraseArray.clone();
		for (int characterPosition = 0; characterPosition < phraseArray.length; characterPosition++)
		{
			char unencriptedCharacter = phraseArray[characterPosition];
			for(int index = 0; index < plainTextArray.length; index++)
			{
				if (plainTextArray[index] == unencriptedCharacter)
				{
					encryptedPhraseArray[characterPosition] = cipherTextArray[index];
				}
			}
		}
		return encryptedPhraseArray;
	}
	
	public static char[] decrypt ( char[] encryptedPhraseArray, char[] plainTextArray, char[] cipherTextArray)
	{
		char[] decryptedPhraseArray = encryptedPhraseArray.clone();
		for (int characterPosition = 0; characterPosition < encryptedPhraseArray.length; characterPosition++)
		{
			char encriptedCharacter = encryptedPhraseArray[characterPosition];
			for(int index = 0; index < plainTextArray.length; index++)
			{
				if (cipherTextArray[index] == encriptedCharacter)
				{
					decryptedPhraseArray[characterPosition] = plainTextArray[index];
				}
			}
		}
		return decryptedPhraseArray;
	}
}
