import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Main {
	
	public static char T[];
	public static int n;
	
	public static int[] RA, tempRA;
	public static int[] SA, tempSA;
	public static int[] c;
	
	public static char[] P;
	public static int m;
	
	public static int[] Phi;
	public static int[] PLCP;
	public static int[] LCP;
	public static int MAX;
	
	public static void countingSort(int k){
		int i, sum, maxi = Math.max(300, n);
		for(i = 0 ; i < MAX; i++){
			c[i] = 0;
		}
		for(i = 0 ; i < n; i++){
			c[i+k < n ? RA[i+k] : 0] ++;
		}
		for(i = sum = 0; i < maxi; i++){
			int t = c[i]; c[i] = sum; sum +=t;
		}
		for(i = 0 ; i < n ; i++){
			tempSA[c[SA[i]+k < n ? RA[SA[i]+k] : 0]++]=SA[i];
		}
		for(i = 0 ; i < n ; i++){
			SA[i] = tempSA[i];
		}
	}
	
	public static void constructSA(){
		int i,k,r;
		for(i=0;i<n;i++)RA[i] = T[i];
		for(i=0;i<n;i++)SA[i] = i;
		for(k = 1; k < n; k <<= 1){
			countingSort(k);
			countingSort(0);
			tempRA[SA[0]] = r = 0;
			for(i = 1 ; i < n ; i++){
				tempRA[SA[i]] = (RA[SA[i]] == RA[SA[i-1]] && RA[SA[i]+k] == RA[SA[i-1]+k]) ? r : ++r;
			}
			for(i = 0 ; i < n ; i++){
				RA[i] = tempRA[i];
			}
		}
	}
	
	public static void computeLCP(){
		int i,L;
		Phi[SA[0]] = -1;
		for (i = 1; i < n; i++) {
			Phi[SA[i]] = SA[i-1];
		}
		for(i = L = 0; i < n ; i++){
			if(Phi[i] == -1){
				PLCP[i] = 0;
				continue;
			}
			while(i+L<T.length && Phi[i] + L < T.length && T[i+L] == T[Phi[i]+L]) L++;
			PLCP[i] = L;
			L = Math.max(L-1, 0);
		}
		for(i = 1 ; i < n ; i++){
			LCP[i] = PLCP[SA[i]];
		}
	}
	
	public static int strncmp(char[] a, int i, char[] b, int j, int n){
		for(int k = 0;i+k< a.length && j+k < b.length; k++){
			if(a[i+k]!=b[j+k])return a[i+k]-b[j+k];
		}
		return 0;
	}
	
	public static int LRS(){
		int i, idx = 0, maxlcp = 0;
		for(i = 1 ; i < n ; i++){
			if(LCP[i] > maxlcp){
				maxlcp = LCP[i];
				idx=i;
			}
		}
		return (maxlcp);
	}
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int cases = Integer.parseInt(br.readLine());
		MAX = 100010;
		for(int i = 0 ; i < cases; i++){
			T = (br.readLine()+"$").toCharArray();
			n = T.length;
			c = new int[MAX];
			RA = new int[MAX];
			tempRA = new int[MAX];
			SA = new int[MAX];
			tempSA = new int[MAX];
			Phi = new int[MAX];
			PLCP = new int[MAX];
			LCP = new int[MAX];
			constructSA();
			computeLCP();
			pw.println(LRS());
		}
		pw.close();
	}
}
