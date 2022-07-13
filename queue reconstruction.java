TC:O(n*n) - to sort and place the list in a particular position
SC:O(1)

Sorted the given list according to their heights and if any othem have same heights then sorted them acc to
their constrants of no. of people ahead of them.

placed all the sorted elements in order in the respoctive positions of a list and conversted that to a 2 D array
at the end.

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int []>li = new ArrayList<>();
        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
        for(int i=0;i<people.length;i++){
            int [] person = people[i];
            li.add(person[1],person);
        }
        return li.toArray(people);
    }
}