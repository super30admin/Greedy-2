class Solution {


    //Time Complexity: O(n)
    //Space Complexity: O(1)

    public List<Integer> partitionLabels(String s) {
        
        List<Integer> result = new ArrayList<>();                       //creating the result list

        Map<Character, Integer> map = new HashMap<>();                  //to store the character and it's last index

        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), i);
        }

        int start = 0;                                                  //start pointer
        int end = 0;                                                    //end pointer

        for(int i=0; i<s.length(); i++){                                //iterate through s

            end = Math.max(end, map.get(s.charAt(i)));                  //get the maximum between end and map.get(s.charAt(i)), update the end 

            if(end == i){                                               //if end reaches to i means its's one parititon
                result.add(end - start + 1);                            //so end the length of the parition
                start =  i + 1;                                         //and start a new parititon from next index
            }
        }
        return result;                                                  //return result
    }






    //Time Complexity: O(n)
    //Space Complexity: O(1)

    // public List<Integer> partitionLabels(String s) {
        
    //     Map<Character, Integer> lastOcc = new HashMap<>();
    //     for(int i=0; i<s.length(); i++){
    //         lastOcc.put(s.charAt(i), i);
    //     }
        
    //     List<Integer> result = new ArrayList<>();
    //     int start = 0;
    //     int end = 0;
        
    //     for(int i=0; i<s.length(); i++){
            
    //         end = Math.max(end, lastOcc.get(s.charAt(i)));
            
    //         if(i==end){
    //             result.add(end - start + 1);
    //             start = end + 1;   
    //         }
    //     }
    //     return result;
    // }
}
