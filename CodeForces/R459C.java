import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class R459C {
	
	
	/**
	 * int main() {
	string s;
	cin >> s;

	int n = s.size();

	int ans = 0;

	for (int k = 0; k < n; ++k) {
		int a = 0, b = 0;
		for (int i = k; i < n; ++i) {
			if (s[i] == '(') {
				a++;
				b++;
			}
			if (s[i] == ')') {
				a--;
				b--;
			}
			if (s[i] == '?') {
				a--;
				b++;
			}
			if (a < 0)
				a = 0;
			if (b < 0)
				break;
			if (a == 0 && (b % 2 == 0)) {
				//cout << k << " - " << i << endl;
				ans++;
			}
		}
	}
	cout << ans << endl;
	return 0;
}
	 */

	
	
public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static int res = 0;
	public static boolean[] mark= new boolean[5001];
	public static void main(String[] args)  throws Exception{
		String line, data[];
		int res = 0;
		line  = br.readLine();
		int n = line.length();
		
		for(int k = 0 ; k < n ; k++){
			int a = 0 ,  b = 0;
			for(int i = k ; i < n ; ++i){
				if(line.charAt(i) == '('){
					a++;
					b++;
				}
				System.out.println(k + " " + i + " " + a  + " " + b); 
				if(line.charAt(i) == ')'){
					a--;
					b--;
				}
				System.out.println(k + " " + i + " " + a  + " " + b);
				if(line.charAt(i) == '?'){
					a--;
					b++;
				}
				System.out.println(k + " " + i + " " + a  + " " + b);
				if(a < 0){
					a=0;
				}
				System.out.println(k + " " + i + " " + a  + " " + b);
				if(b < 0){
					break;
				}
				System.out.println(k + " " + i + " " + a  + " " + b + " checking");
				if(a == 0 && (b%2==0)){
					System.out.println("y");
					res++;
				}
				System.out.println(k + " " + i + " " + a  + " " + b);
			}
		}
		
		System.out.println(res);
		
		
		
	}
	
	
	
}
