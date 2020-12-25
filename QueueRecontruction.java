import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueRecontruction {
	//descending order by heights
	//ascending order by no. of persons
	public int[][] reconstructQueue(int[][] people) {

		Arrays.sort(people, (a, b) -> {

			if (a[0] == b[0])
				return a[1] - b[1];

			return b[0] - a[0];

		});
		System.out.println(people);
		List<int[]> q = new ArrayList<>();

		for (int[] person : people) {
			q.add(person[1], person);
		}
		return q.toArray(new int[0][]);
	}

	public static void main(String[] args) {
		QueueRecontruction c = new QueueRecontruction();

		c.reconstructQueue(new int[][] { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } });
	}
}
