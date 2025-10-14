// This solution first sorts the array based on the descending order of height. If height is equal we can do ascending order
// Then we shift array based on the number of people in front i.e., people[i][1]. 
// This is with the catch that there is no restriction on number of smaller people in front of a person
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int length = people.length;
        Arrays.sort(people, (a,b)-> {if(a[0]!=b[0]) {return b[0]-a[0];} else return a[1]-b[1];});

        List<int[]> result = new ArrayList();
        for(int[] person:people) {
            result.add(person[1], person);
        }
        return result.toArray(new int[0][0]);
    }
}
