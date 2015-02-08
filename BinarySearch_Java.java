
public class binarysearch {
	
	public static void main(String args[]){
		
		int hi , lo , i =0 , j , key = 4 , mid;
		int a[] = { 2,3,5,23,4,556,64,45};
		mid = a.length/2;
		int left[] = new int[mid]; 
		int right[] = new int[mid];
		
		if(key == a[mid]){
		  System.out.println("element found at " + mid);
		}else if(key < a[mid]){

			int high = mid;
			int low = 1;
			int length = low + (high-low)/2;
			while(low<=length){
				if(key == a[length]){
					System.out.println(" element found at " + length);
				}else if(key > a[length]){
					low++;
				}else{
					if(key < a[length]){
						high--;
					}
				}
			}
		}else if(key > a[mid]){
			
			int high = a.length;
			int low = mid;
			int length = low + (high-low)/2;
			while(low<=length){
				if(key == a[length]){
					System.out.println(" element found at " + length);
				}else if(key > a[length]){
					low++;
				}else{
					if(key < a[length]){
						high--;
					}
				}
			}
		}
		
		
	}

}
