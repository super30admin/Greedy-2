//Queue Reconstruction by Height
import java.util.*;
//tc- O(n*n)
//sc - O(1) 
public class Problem2 {
    public static void main(String[] args){
        Problem2 p = new Problem2();
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] res = p.reconstructQueue(people);
        for(int[] r : res){
            System.out.println(r[0]+" "+r[1]);
        }

    }
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        if(people == null || people.length ==0){
            return new int[2][2];
        }
        //greedy approach 
        //sort in descending
        Arrays.sort(people, (int[] a, int[] b) -> a[0]==b[0] ? a[1]- b[1] : b[0] - a[0]);
        List<int[]> res = new ArrayList<>();
        
        for(int[] p : people){
            res.add(p[1], p);
        }
        return res.toArray(new int[0][]);
    }

    
}
