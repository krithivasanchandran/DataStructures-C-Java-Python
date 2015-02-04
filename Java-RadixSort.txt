
public class radixsort {
	
	public static void main(String args[]){
		
	int a[] = {355,720,437,657,839};
	int lsd[] = new int[5];
	int mid[] = new int[5];
	int msd[] = new int[5];
	
	for(int i=0;i<5;i++){
		int splitup = a[i];
		lsd[i] = splitup%10;
		int temp = splitup/10;
		mid[i] = temp % 10;
		msd[i] = temp / 10;
	}
	
	for(int i=0;i<lsd.length;i++){
		for(int j=0;j<i;j++){
			
			if(lsd[i] < lsd[j]){
				int swap = lsd[j];
				int mswap = mid[j];
				int upswap = msd[j];
				
				lsd[j] = lsd[i];
				mid[j] = mid[i];
				msd[j] = msd[i];
				
				lsd[i] = swap;
				mid[i] = mswap;
				msd[i] = upswap;
			}
		}
	}
	
	for(int i=0;i<mid.length;i++){
		for(int j=0;j<i;j++){
			
			if(mid[i] < mid[j]){
				int swap = lsd[j];
				int mswap = mid[j];
				int upswap = msd[j];
				
				lsd[j] = lsd[i];
				mid[j] = mid[i];
				msd[j] = msd[i];
				
				lsd[i] = swap;
				mid[i] = mswap;
				msd[i] = upswap;
			}
		}	
	}
	
	for(int i=0;i<msd.length;i++){
		for(int j=0;j<i;j++){
			
			if(msd[i] < msd[j]){
				int swap = lsd[j];
				int mswap = mid[j];
				int upswap = msd[j];
				
				lsd[j] = lsd[i];
				mid[j] = mid[i];
				msd[j] = msd[i];
				
				lsd[i] = swap;
				mid[i] = mswap;
				msd[i] = upswap;
			}
		}
	}
	
	
	
	for(int i=0;i<lsd.length;i++){
		 System.out.println("The value is " + msd[i] + mid[i] + lsd[i]);		
	}
 	}

}
