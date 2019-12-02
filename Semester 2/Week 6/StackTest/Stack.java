
import java.util.ArrayList;

public class Stack {
	ArrayList<Integer> integers;
	
	Stack()
	{
		integers = new ArrayList<Integer>();
	}
	
	public void push(int integer)
	{
		integers.add(0, integer);
	}
	
	public void pop()
	{
		integers.remove(0);
	}
	
	public int peek()
	{
		if(integers.get(0) != null)
		{
			return (int)integers.get(0);
		}
		return -1;
	}
	
	public int search(Object element)
	{
		for(int index = 0; index < integers.size(); index++)
		{
			if(integers.get(index) == element)
			{
				return index;
			}
		}
		return -1;
	}
	
	public void move(Object element)
	{
		int movedElementIndex = search(element);
		if(movedElementIndex != -1)
		{
			int movedElement = integers.get(movedElementIndex);
			for(int index = movedElementIndex; index > 0; index--)
			{
				integers.set(index,integers.get(index-1));
			}
			integers.set(0, movedElement);
		}
	}

}
