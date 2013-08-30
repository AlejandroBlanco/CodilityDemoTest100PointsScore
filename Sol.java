
public class Sol {

	int solution(int A[]) {
		if (A==null)
			return -1;
		if(A.length==0)
			return -1;
		return solution(A, A.length);
	}
	
	
		int solution(int A[], int N) {
		    int middle=N/2;
		    long left=0; 
		    long right=0;
		    long parts[]={left,right};
		    parts=firstsums(A,middle);
		    if (parts[0]==parts[1])
		    	return middle;
		    else{
		    	int counter=1;
		    	long rightpos=parts[1]; long rightneg=parts[1]; long leftpos=parts[0]; long leftneg=parts[0];
		    	while(middle+counter<A.length){
		    		if(middle+counter==A.length) rightpos=0;
		    		else 
		    		rightpos=rightpos-A[middle+counter];
		    		leftpos=leftpos+A[middle+counter-1];
				    if (rightpos==leftpos)
				    	return middle+counter;
		    		rightneg=rightneg+A[middle-counter+1];
		    		leftneg=leftneg-A[middle-counter];
				    if (rightneg==leftneg)
				    	return middle-counter;
				    counter++;
		    	}
		    	if(A.length%2==0){
		    		System.out.println(counter);
		    		rightneg=rightneg+A[middle-counter+1];
		    		leftneg=leftneg-A[middle-counter];
			    if (rightneg==leftneg)
			    	return middle-counter; //Should be 0
		    	}
		    	return -1;
		    }
		}
		
		long[] firstsums(int A[], int n){
			
			int i=0; long left=0; long right=0;
			while(i<n){
				left=A[i]+left;
				right=A[A.length-1-i]+right;
				i++;
			}
			if(A.length%2==0){
				right=right-A[n];
			}
			long values[]={left,right};
				return values;
		}
}
