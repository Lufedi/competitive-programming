import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompareTheTriplets {

	public static int pint(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String arrayXA[] = br.readLine().split(" ");
		int arrayA[] = new int[3];
		int responseA = 0;
		int responseB = 0;

		for (int i = 0; i < arrayXA.length; i++) {
			arrayA[i] = pint(arrayXA[i]);

		}

		String arrayXB[] = br.readLine().split(" ");
		int arrayB[] = new int[3];

		for (int i = 0; i < arrayXB.length; i++) {
			arrayB[i] = pint(arrayXB[i]);

		}

		for (int i = 0; i < arrayA.length; i++) {
			if (arrayA[i] > arrayB[i]) {
				responseA++;
			}
			if (arrayA[i] < arrayB[i]) {
				responseB++;
			}
		}

		System.out.println(responseA + " " + responseB);
	}

}
