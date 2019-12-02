
import java.util.Scanner;
import java.text.DecimalFormat;

public class PoundsShillingsPennies {
	
	public static final double OLD_PENNY_VALUE = 0.67;
	public static final double OLD_SHILLING_VALUE = 12 * OLD_PENNY_VALUE;
	public static final double OLD_POUND_VALUE = 20 * OLD_SHILLING_VALUE;

	public static void main(String[] args) {
		
		try{
			
		    System.out.println("Enter amount of money (pounds shillings pennies):");
		    Scanner input = new Scanner(System.in);
		    int oldPoundAmount = input.nextInt();
		    int oldShillingAmount = input.nextInt();
		    int oldPennyAmount = input.nextInt();
		    input.close();
		
		    double oldPoundToNewPound = (oldPoundAmount * OLD_POUND_VALUE);
		    double oldShillingToNewPound = (oldShillingAmount * OLD_SHILLING_VALUE);
		    double oldPennyToNewPound = (oldPennyAmount * OLD_PENNY_VALUE);
		    double newPoundAmount = oldPoundToNewPound + oldShillingToNewPound + oldPennyToNewPound;
		    
		    DecimalFormat poundFormat = new DecimalFormat("#.00");
		
		    if (oldPoundAmount < 0 || oldShillingAmount < 0 || oldPennyAmount < 0)
		    	System.out.println("Invalid Input");
		    else{
		    	System.out.println(oldPoundAmount + " old pound, " + oldShillingAmount + " old shilling and " 
		        		            + oldPennyAmount + " old pence = £" + poundFormat.format(newPoundAmount));
		    }
		    
		} catch(Exception NoSuchElementException) {
			System.out.println("Invalid Input");
		}
		
	}

}
