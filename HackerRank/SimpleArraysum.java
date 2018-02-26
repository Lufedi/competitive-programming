import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleArraysum {
	public static int pint(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int po = pint(br.readLine());

		String[] array = br.readLine().split(" ");
		int[] arrayInt = new int[po];
		int sum = 0;
		for (int i = 0; i < arrayInt.length; i++) {
			arrayInt[i] = pint(array[i]);
			sum += arrayInt[i];
		}
		
		System.out.println(sum);

	}
}
