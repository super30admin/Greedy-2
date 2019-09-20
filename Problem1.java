//Time:O(n log n)
//Space:O(n)
//LeetCode: Yes

//Approach:
//1.Sort the array such that people with greater height come in the first . If multiple people have same height , 
//then sort them such that person with number of people in front of this person are more than others.
//2.Now , since we are not concerned with people shorter than us in front of us, start from first index and check number of people that
// should be infront of him.Insert him in the list at this index.Do this for all members starting from first memebr to last memeber.
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b) -> a[0] == b[0]?a[1]-b[1]:b[0]-a[0]);
        List<int[] > result = new ArrayList<>();
        for(int[] current:people){
            result.add(current[1],current);
        }
        return result.toArray(new int[people.length][]);
    }
}
