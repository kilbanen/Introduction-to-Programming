
public class StackTest {

	public static void main(String[] args) {
		Stack myStack = new Stack();
		for(int index = 1; index <= 10; index++)
		{
			myStack.push(index);
		}
		
		System.out.println(myStack.peek());
		myStack.pop();
		System.out.println(myStack.peek());
		System.out.println(myStack.search(4));
		myStack.move(4);
		System.out.println(myStack.peek());

	}

}
