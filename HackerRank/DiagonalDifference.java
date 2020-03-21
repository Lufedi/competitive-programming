import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiagonalDifference {

	public static int pint(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int po = pint(br.readLine());
		int arrayInt[][] = new int[po][po];
		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i < po; i++) {
			String arrayData[] = br.readLine().split(" ");
			for (int j = 0; j < arrayData.length; j++) {
				arrayInt[i][j] = pint(arrayData[j]);
			}
		}

		for (int i = 0; i < arrayInt.length; i++) {
			sum1 += arrayInt[i][i];
			sum2 += arrayInt[i][po - i - 1];
		}

		System.out.println(Math.abs(sum1 - sum2));
	}

}