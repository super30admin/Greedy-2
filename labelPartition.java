import java.util.*;

public class labelPartition {

	public List<Integer> partitionLabel(String S){
		
		int[] cnt = new int[26];
		// find the last index of each particular character, so that we need to know where to do our partition for that characters
		for(int i=0;i<S.length();i++) {
			cnt[S.charAt(i)-'a'] = i;
		}
		
		int j=0, k=0;
		List<Integer> res = new ArrayList<>();
		
		for(int i=0;i<S.length();i++) {
			// find the index where I can find my partition
			j = Math.max(j, cnt[S.charAt(i)]);
			
			// if the ith index and jth value are same, we know we need to partition the array at that place, to find the length of 
			// partition of previous partition to curr partition. we do i-k+1 and add those values onto our result and update our k to i+1
			// because next partition will start at i+1;
			if(i == j) {
				res.add(i-k+1);
				k = i+1;
			}
		}
		
		return res;
	}
}
