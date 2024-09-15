import java.util.ArrayList;
import java.util.List;

//time complexity is o(n)
//space complexity is o(1)
//idea is find last index of first character in string and if any character before last index has last index greater then update last index.
//add the length from start index till last index into result array. keep track of all last indexes in an array

public class PartitionLabels {
	public List<Integer> partitionLabels(String S) {
        int[] lastIndexes = new int[26];
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<S.length();i++){
            System.out.println(i);
            lastIndexes[S.charAt(i)-'a'] =i; // keep last index of each character
        }
        int lastIndex=0; int substringStartIndex=0;
        for(int i=0;i<S.length();i++){
            lastIndex= Math.max(lastIndex, lastIndexes[S.charAt(i)-'a']); //check if last index of  characters  is greater than first character last index
            if(i==lastIndex){
                result.add(lastIndex-substringStartIndex+1); //calculate length of substring
                substringStartIndex = i+1; //start of next substring
            }
        }
        return result;
    }
}
