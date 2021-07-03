//time complexity: n^2 is the for insertion in arraylist and nlog n is for sorting the arraylist.
//O(n^2 + nlog n) => O(nlogn)
//space complexity O(n)

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> {
          if(a[0] == b[0]){
              return a[1] - b[1];// acsending order of number of people in front
          } else{
              return b[0] - a[0];// descending order of height
          }
        });
        List<int[]> result = new ArrayList<>();
        for(int[] person: people){
            result.add(person[1], person);//placing according to number of people in front
        }
        return result.toArray(new int[people.length][2]);
    }
}
