// Time Complexity : O(n) as we are travelling throught the array only once
// Space Complexity : O(n) for the hashmap created but if we initialize what with size 26 for alphabets it is o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


class Solution {
public:
    vector<int> partitionLabels(string S) {
        
        int size = S.size();
        
         vector<int> result;
        if( size == 0) return  result ;
        
        map<char,int> mymap;
        
        
        // creating a hashmap with the endpoints of each character
        for ( int i = 0; i <size; i++){
            
            char ch = S[i];
            
            mymap[ch] = i;
        }
        
    
        
        int start = 0;
         int end = 0;
        // iterating throught the given string and setting the max values to end of each string to check
        
        // as soon as we hit the end will be the current value then we can close the sub array at that position
        
        for( int i = 0; i < size; i++){
            char curr = S[i];
            if(end < mymap[curr]){
                
                end = mymap[curr];
                
            }
            
          
            
            if( i == end){
                result.push_back(end - start +1);
                
                start = i+1;
                
            }
            
        }
        
        return result;
    }
};