package outLookpkg;

public class FrequesncyArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {1,3,1,5,6,7,7,8,3,9,0,1,5,3,6,6};
		boolean [] sta = new boolean[arr.length];
		
		
		for(int i=0;i<arr.length;i++) {
			
			if(sta[i]==false) {
				int count =1;
			for(int j=i+1;j<arr.length;j++) {
				
				if(arr[i]==arr[j]) {
					count++;
					sta[j] = true;
				}
				
				}
			if(arr[i]%2==0)
			System.out.println(arr[i]+" ----> "+count);
			}
			
			
		}

	}

}
