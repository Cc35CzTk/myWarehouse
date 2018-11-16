package duong.algorithms;

public class BinaryListPrint 
{
	public static void main(String[] args) {
		java.util.Scanner scan = new java.util.Scanner(System.in);
		int n = scan.nextInt(),i,j,arr[] = new int[n];
		
		for(i = 0;i<n;i++)arr[i]=0;
		while(i>=0)
		{
			//Print 
			for(i = 0;i<n;i++) System.out.print(arr[i]);
			System.out.println();
			
			//Checking all pos
			i = n - 1;
			while(i>=0 && arr[i]==1)i--;
			if(i>=0)
			{
				arr[i] = 1;
				for(j = i+1;j<n;j++)
					arr[j]=0;
			}
		}
	}
}