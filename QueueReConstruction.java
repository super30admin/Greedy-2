class Solution {
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        // if the heights are equal then start comparing the k values
        return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
      }
    });
       
        Arrays.sort( people, Comparator.comparingInt((int[] a) -> a[1]));
        Arrays.sort( people, Comparator.comparingInt((int[] a) -> a[0]).reversed());

        ArrayList<int[]> ordered = new ArrayList<>();

       
        // see the number of tall people that are needed to be present in the front, then insert into k value position
        for (int i=0; i<people.length; i++) 
            ordered.add(people[i][1], people[i]);
        
        return ordered.toArray(new int[people.length][]);
    }
} 
    
//Time complexity : O(N^2)
//space complexty : O(N) 
