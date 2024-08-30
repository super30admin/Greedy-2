//TC: O(n)
//SC: O(n)

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = new ArrayList<>();
        //sort the people array such that tallest people come first
        //if 2 have same height, decide based on the number of persons infront of them
        Arrays.sort(people, (a,b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        for(int[] person : people) {
            list.add(person[1], person);
        }

        int[][] result = new int[people.length][2];
        for(int i=0 ; i<people.length ; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}