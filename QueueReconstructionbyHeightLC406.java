class Solution {


    //Time Complexity:O(n*log(n))
    //Space Complexity: O(n)

    //here, we are using greedy approah, first sort the array which is specified below, then we iterate the people array, and place the kid at specified position, if there's already kid, then we have to move them one index right, and place current kid at that place, so basically we are focusing one kid at a time, place them, and then we focus on next kid, if there's already a kid, then shift them at one index right, and we already sort the kids according their height, so, that's how this approach works

    public int[][] reconstructQueue(int[][] people) {

        if(people == null || people.length == 0) return people;

        Arrays.sort(people, (a, b) -> {                         //first sort the people array based on their heights (decending order), and if height are same then sort according to acending order based on the number of people which is infront.

            if(a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        List<int[]> result = new ArrayList<>();                //creating the result list

        for(int[] person: people){                             // iterating the people array
            result.add(person[1], person);                      //add the person in the result list at index which is given in the array
        }
        return result.toArray(people);
    }




    //Time Complexity:O(n*log(n))
    //Space Complexity: O(n)

    // public int[][] reconstructQueue(int[][] people) {
        
    //     Arrays.sort(people, (a,b) -> {
            
    //         if(b[0] == a[0]){
    //             return a[1] - b[1];
    //         }
    //         return b[0] - a[0];
    //     });
        
    //     List<int[]> result = new ArrayList<>();
        
    //     for(int[] pupil : people){
    //         result.add(pupil[1], pupil);
    //     }
        
    //     return result.toArray(people);
        
    // }
}
