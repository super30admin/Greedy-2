/**
 * Brute Force Intuition: build the hashmap with key as the character and value as the last occurance of this char in the gvn array
 * Next will go on traversing the given array and for each char get its last occurance and extend the window.
 * If all the occurances of each char in the string are qithin that window then the partition is added to the resultant list and start from the next char
 *
 * Time: O(2n)
 * Space: O(1) as hashmap takes //constant space and the list is being returned
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        HashMap<Character,Integer> hmap = new HashMap<>();

        for(int i=0;i<S.length();i++){
            hmap.put(S.charAt(i),i);
        }

        int start = 0,end=0;
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<S.length();i++){
            int cend = hmap.get(S.charAt(i));
            end= Math.max(end,cend);
            if(i == end){
                res.add(end-start+1);
                start = end+1;
                end = end+1;
            }
        }
        return res;
    }
}