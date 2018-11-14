package duong.dataStructure

public class Stack <DataType>{
	@SuppressWarnings("unused")
	private int top, size;
	private Mang stack;
	
	public Stack(int size)
	{
		this.top = 0;
		this.size = size;
		this.stack = null;
	}
	public boolean isEmpty()
	{
		if(top == -1)return false;
		else return true;
	}
	public boolean isFull()
	{
		if(top == size - 1)return true;
		else return false;
	}
	@SuppressWarnings("unchecked")
	public void push(DataType item)
	{
		if(isFull() == false)
		{
			if(stack == null) {
				stack = new Mang<DataType>(item, stack);
				push(item);
			}

			else
			{
				Mang temp = stack;
				while(temp.next != null) {
					temp = temp.next;
					top = top + 1;
				}
				temp.next = new Mang<DataType>(item, null);
				
			}
		}
	}
	public void pop()
	{
		if(isEmpty() == true)
		{
			
			if(stack == null)throw new NoSuchElementException();
			Mang temp = stack;
			while(temp.next != null)temp = temp.next;
			remove();
			System.out.print(temp.data + " ");			
		}else System.out.print("NULL ");
	}
	private Mang remove()
	{
		if(stack == null)throw new NoSuchElementException();
		else
		{
			Mang temp = stack;
			while(temp.next.next != null)temp = temp.next;
			top = top - 1;
			temp.next = null;
			return temp;
		}
	}
	public DataType getFirst()
	{
		if(stack == null) throw new NoSuchElementException();
		return (DataType) stack.data;
	}
	public DataType removeFirst()
	{
		DataType tmp = getFirst();
		stack = stack.next;
	    return tmp;
	}
	public static void main(String[] args) 
	{
		Stack<Integer> stack = new Stack<Integer>(10);
		stack.push(5);
		stack.push(3);

		stack.pop();//get value is 3
		stack.pop();//get value is 5
		
		stack.pop();//get value is NULL
		stack.pop();//get value is NULL
	}
	private static class Mang<DataType>
	{
		private DataType data;
		private Mang next;
		public Mang(DataType item, Mang stack)
		{
			this.data = item;
			this.next = stack;
		}
	}
}