public class Sort_Algorithm{

	int count = 0;
	int heapsize;

public int[] Insertion_Sort(int[] A){
	
	int key = 0;
	int i = 0;
	count = 0; 
	for ( int j = 1 ; j < A.length;j++){
		key = A[j];
		i = j-1;
		
		while ( i >= 0 && A[i] > key)
		{
			A[i+1] = A[i];
			i = i - 1;
			count ++ ;
		}
		
		A[i+1] = key;
	}
	System.out.println("Length Of Array " + A.length + " Count " + count);
	return A;
}

public int[] Merge_Sort(int[] A){
	count = 0;
	MergeSort(A,0,A.length-1);
	System.out.println("Length Of Array " + A.length + " Count " + count);
	return A;
}

public void MergeSort(int[] A, int p, int r){
	
	if (p < r){
		int q = (p + r) / 2;
		MergeSort ( A, p, q);
		MergeSort ( A, q+1, r);
		Merge(A, p , q, r);
	}

}
public void Merge ( int[] A, int p ,int q, int r){
	int n1 = (q - p)+1;
	int n2 = r - q;
	int[] L = new int[n1];
	int[] R = new int[n2];
	
	for(int i = 0; i < n1; i++){
		L[i] = A [(p+i)];
	}
	for(int j = 0; j < n2; j++){
		R[j] = A[q+j+1];
	}
	
	int i = 0;
	int j = 0;
	int k = p;
	   
	while(i < n1 && j < n2){
		
		if (L[i] <= R[j]){
			A[k] = L[i];
			i++;
		}else{
			A[k] = R[j];
			j++;
		}
		k++; 
		count++;
	}
	while (i < n1){
		A[k] = L[i];
		i++;
		k++;
		count++;
	}
	while (j < n2){
		A[k] = R[j];
		j++;
		k++;
		count++;
	} 
	}
	
public int[] HeapSort(int[] A){
	count = 0;
	Build_Max_Heap(A);
	
	for (int i = A.length-1;i>=0;i--){
		int temp = A[0];
		A[0] = A[i];
		A[i] = temp;
		heapsize = heapsize - 1;
		Max_Heapify(A,0);
	}
	System.out.println("Length Of Array " + A.length + " Count " + count);
	return A;
}

public void Max_Heapify(int[] A, int i ){
	
	int l = 2 * i;
	int r = 2 * i + 1;
	int largest = i ;
	if (l <= heapsize && A[l] > A[i] ){
		largest = l;
	}
	else
	{
		largest = i;
	}
	
	if (r <= heapsize && A[r] > A[largest] ){
		largest = r;
	}
	if( largest != i){
		int temp = A[i];
		A[i] = A[largest];
		A[largest] = temp;
		count++;
		Max_Heapify(A,largest);
	}
}

public void Build_Max_Heap(int[] A){
	heapsize = A.length-1;
	for (int i = (A.length/2); i>=0;i--){
		Max_Heapify(A,i);
	}
}


public int[] Quick_Sort(int[] A){
	count = 0;
	QuickSort(A,0,A.length-1);
	System.out.println("Length Of Array " + A.length + " Count " + count);
	return A;
}

public void QuickSort(int[] A, int p, int r){
	
	if(p<r){
		int q = Partition(A,p,r);
		QuickSort(A,p,q-1);
		QuickSort(A,q+1,r);
	}

}

public int Partition(int[] A, int p, int r){
	int x = A[r];
	int i = p-1;
	int temp1;
	for(int j = p; j<=r-1; j++){
		count++;
		if (A[j]<=x){
			i++;
			int temp2 = A[i];
			A[i] = A[j];
			A[j] = temp2;
		}
	}
	temp1 = A[i+1];
	A[i+1] = A[r];
	A[r] = temp1;
	
	return i+1;
}


}

		

