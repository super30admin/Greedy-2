import java.lang.reflect.Array;
import java.util.*;
/*
Time Complexity: O(NlogN), N is the length of the people array and sorting would that log n time
Space Complexity: O(1), constant space
Run on leetcode: yes
Any difficulties: no

Approach:
Solved after discussed in the class
 */
public class QueueBasedOnHeights {
    public static int[][] heightBasedArrangement(int[][] people){
        Arrays.sort(people, new Comparator<int[]>(){
           public int compare(int[] a, int[] b){
                return a[0] == b[0] ? a[1]-b[1] : b[0]-a[0];
            }
        });

        List<int[]> heightQueue = new LinkedList<>();
        for(int[] person: people){
            heightQueue.add(person[1], person);
        }
        int numberOfPeople = people.length;
        return heightQueue.toArray(new int[numberOfPeople][2]);
    }

    public static void main(String[] args){
        int[][] peoples = {
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}
        };

        System.out.println("Height based arrangement: ");
        for(int[] arr: heightBasedArrangement(peoples)){
            System.out.print(Arrays.toString(arr)+ ","+"\t");
        }
    }
}
