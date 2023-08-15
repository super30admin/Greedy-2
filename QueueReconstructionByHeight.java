import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class QueueReconstructionByHeight {

        // Greedy - Time O(n*n) and SpaceO(n) - descending heights, ascending infronts, add in queue at indices = infronts

        public int[][] reconstructQueue(int[][] people) {

            // sort by descending h-heights and ascending k-other equal or taller persons in front
            Arrays.sort(people, (a,b) -> {         // O(n*log(n))

                if(a[0] == b[0]) {

                    return a[1] - b[1];
                }

                return b[0] - a[0];
            });

            // queue of persons with attributes
            List<int[]> queue = new ArrayList<>();    // O(n) space

            // add person at index = k in queue, based on number of equal or taller persons in front
            for(int[] person: people) {

                queue.add(person[1], person);       // O(n*n)
            }

            // output array
            int[][] reconstructed = new int[people.length][2];

            for(int i = 0; i < people.length; i++) {

                reconstructed[i] = queue.get(i);
            }
            return reconstructed;
        }

        public static void main(String[] args) {

            QueueReconstructionByHeight obj = new QueueReconstructionByHeight();

            Scanner scanner = new Scanner(System.in);

            System.out.println("number of people: ");
            int n = scanner.nextInt();

            int[][] people = new int[n][2];
            System.out.println("people with attributes: ");

            for(int i = 0; i < n; i++) {

                people[i][0] = scanner.nextInt();
                people[i][1] = scanner.nextInt();
                System.out.println(" ");
            }

            int[][] answer = obj.reconstructQueue(people);

            for(int i = 0; i < n; i++) {

                System.out.println(answer[i][0] + ", " + answer[i][1]);
            }

        }
}

/*
TIME COMPLEXITY = O(n*n)

adding persons at a particular index in queue requires readjusting queue elements each time = O(n) * O(n)

custom array sorting = O(nlogn)

SPACE COMPLEXITY = O(n)
intermediary list of persons in queue has O(n) space
*/