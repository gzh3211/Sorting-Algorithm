import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sort_Algorithm2 {
	int count = 0;
	
	public int[] Counting_Sort(int[] A,int[] B, int k){
		count = 0;
		int[] C = new int[k+1];
		for(int i = 0; i<= k; i++){
			C[i]=0;
		}
		for(int j = 0; j<A.length; j++){
			C[A[j]] = C[A[j]] + 1;
		}
		for (int i = 1; i<= k;i++){
			C[i] = C[i]+C[i-1];
		}
		for(int j = A.length-1;j>=0;j-- ){
			count ++;
			B[C[A[j]]-1] = A[j];
			C[A[j]] = C[A[j]] - 1;
		}
		
		System.out.println("Length Of Array " + A.length + " Count " + count);
		return B;
	}
	
	
	public int[] Radix_Sort(int[] A, int d){
		count = 0;
		int B[] = new int[A.length];
		int curr=1;
		while(curr<=d){
			
			int C[] = new int[10];
			int temp=1;
			for(int i=1;i<curr;i++){
				temp=temp*10;
			}
			for(int i=0;i<=9;i++){
				C[i]=0;
			}
			for(int j=0;j<A.length;j++){
				C[((A[j]/temp)%10)] = C[((A[j]/temp)%10)] + 1;
			}
			for(int i = 1;i<= 9;i++){
				C[i]= C[i]+C[i-1];
			}
			for(int j=A.length-1;j>=0;j--){
				count ++;
				B[C[((A[j]/temp)%10)]-1]=A[j];
				C[((A[j]/temp)%10)] = C[((A[j]/temp)%10)] - 1;
			}
			for(int i=0;i<A.length;i++){
				A[i]=B[i];
			}
			curr++;
		}
		
		System.out.println("Length Of Array " + A.length + " Count " + count);
		return A;
	}
	
	public int[] Bucket_Sort(int[] A){
		
		count = 0;
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] bucket = new LinkedList[A.length];
		
		
		int max = getMax(A);
		for (int i = 0; i < A.length; i++) {
            int index = (A[i] * A.length) / (max + 1);;
            if (bucket[index] == null) {
                bucket[index] = new LinkedList<Integer>();
            }
           
            bucket[index].add(A[i]);
        }

        
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (bucket[i] != null) {
                Insertion_Sort(bucket[i]);
                temp.addAll(bucket[i]);
            }
        }

       
        for (int i = 0; i < A.length; i++) {
            A[i] = temp.get(i);
        }
    
		System.out.println("Length Of Array " + A.length + " Count " + count);
		return A;
	}
	public void Insertion_Sort(LinkedList<Integer> bucket){
		
		
		
		count ++ ;
		
		for ( int j = 1 ; j < bucket.size();j++){
			int key = bucket.get(j);
			int i = j-1;
			
			
			while ( i >= 0 && bucket.get(i) > key)
			{
				bucket.set(i+1, bucket.get(i));
				i = i - 1;
				
				
			}
			
			bucket.set(i+1, key);
		}
		
		
	}
    public int getMax(int A[]) {
        int maxElement = A[0];
        for (int i = 1; i < A.length ; i++){
            if (A[i] > maxElement){
                maxElement = A[i];
            }
        }
        return maxElement;
    }
	
	
}
