package outLookpkg;



public class MergrArray {

	public static void main(String[] args) {
		int[]a= {1,2,3,4,5,6};
	int b[]= {7,8,9,10};
	int c[]=merge(a,b);
	for(int i:c)
	{
		System.out.print(i+" ");
	}
	}

	private static int[] merge(int[] a, int[] b) {
		int []x=new int[a.length+b.length];
		
			int j=0, i = 0;
			while(j<a.length&&j<b.length)
			{
				x[i]=a[j];
				i++;
				x[i]=b[j];
				i++;	
				j++;
			}
		
		while(j<a.length)
		{
			x[i++]=a[j++];
		}
		
		return x;
		
	}
}