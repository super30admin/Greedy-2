// Problem-1: Queue reconstuction
/**
Greedy approach: sort the people array with the highest height value and with index value in case of a clash. Then rearrange in the resultantant list according to the indices in the sorted people array
TC = O(nlogn + n^2) = O(n^2) n^2 to readjust the array according to the indices
SC = O(n)
*/
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        if(people == null || people.length == 0) return new int[0][];
        
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]){ // if heights are equal
                return a[1]-b[1]; // sort by indices in asc order
            }else{
                return b[0]-a[0]; // sort by heights in dsc order
            }
        });
        List<int[]> sortedQueue = new ArrayList<>();
        
        for(int[] person: people){
            sortedQueue.add(person[1], person);  
        }
        
       return sortedQueue.toArray(new int[0][]);
        
    }
}
// Problem-2: Partition Labels
/**
TC = O(n) num of chars in string
SC = O(1) storung 26 chars only in the map
*/
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        if(S == null || S.length() == 0) return result;
        
        int start = 0, end=0;
        HashMap<Character, Integer> map = new HashMap<>();
        // create map of the last occurances of each char in the S string
        for(int i=0; i<S.length(); i++){
            map.put(S.charAt(i), i);
        }
        
        for(int i=0; i<S.length(); i++){
            char cur = S.charAt(i);
            
             end = Math.max(map.get(S.charAt(i)), end); // need the max endpoint of a particular element
            
            if(i == end){
                result.add( i - start +1); // +1 because answer is 1 based instead of 0 based length
                start = end+1; // adjusting the window's start point to the next unique element
            } 
        }
        
        return result;
    }
}
