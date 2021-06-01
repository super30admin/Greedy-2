//Time Complexity : O(n). 2O(n) but asymptotically it is O(n)
//Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Your code here along with comments explaining your approach
class Solution {
    public int candy(int[] ratings) {
        if(ratings.length==0||ratings==null){
            return 0;
        }
        int num = 0;
        int[] candies = new int[ratings.length];
        //initially fill the candies array with 1 as each with will have atleast 1 candy
        Arrays.fill(candies,1);
        //Left pass : comapre the left child for every child
        for(int i=1;i<ratings.length;i++){
            if(ratings[i] > ratings[i-1]){
                //if cur child is greater than left child increase its candy by prev child's candy plus one
                candies[i] = candies[i-1] + 1;
            }
        }
        //Right pass : compare the right child for ever child
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i+1]<ratings[i]){
                //if cur child is greater than right child increase its candy by Maximum of prev child's candy plus one or original val
                candies[i] = Math.max(candies[i],candies[i+1] + 1);
            }
             //calculate the number of candies
             num += candies[i];
        }
        num = num + candies[candies.length-1];
        return num;
    }
}