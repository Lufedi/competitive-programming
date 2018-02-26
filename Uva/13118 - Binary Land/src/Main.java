import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
	
	
	
	
	
	public static int pint(String  s){return Integer.parseInt(s);}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line, data[];
		
		
		int board[][];
		int R, C;
		int pg1[], pg2[], ht[];
		
		while(br.ready()){
			
			pg1 = new int[2];
			pg2 = new int[2];
			ht = new int[2];
			
			data = br.readLine().split(" ");
			R = pint(data[0]);
			C = pint(data[1]);
			data = br.readLine().split(" ");
			ht[0] = pint(data[0])-1;
			ht[1] = pint(data[1])-1;
			pg2[0] = pint(data[2])-1;
			pg2[1] = pint(data[3])-1;
			pg1[0] = pint(data[4])-1;
			pg1[1] = pint(data[5])-1;
			
			board = new int[R][C];
			for(int i = 0 ; i <  R ; i ++){
				line = br.readLine();
				for(int j = 0 ; j  < line.length() ; j++){
					if(line.charAt(j) == '.')
						board[i][j] = 0;
					else
						board[i][j] = -1;
				}
			}
			
			
			
			int mv[][] = new int[][]{
					{-1,0,-1,0},{1,0,1,0}, {0,1,0,-1},{0,-1,0,1}	
			};
			
			
			Queue<Node> queue =  new LinkedList<Node>();
			Node u = new Node(pg1[0], pg1[1] , pg2[0] , pg2[1] , C);
			queue.add(u);
			
			
			//Hashtable<String, Integer> distance = new Hashtable<String , Integer>();
			//distance.put(u.toString() , 0);
			int distance[][][][] = new int[R][C][R][C];
			for(int i = 0 ; i <  R ; i++){
				for(int j = 0 ; j <  C; j++){
					for(int k = 0 ; k <  R ; k++){
						for(int l = 0 ; l  <  C ; l++){
							distance[i][j][k][l] = -1;
						}
					}
				}
			}
			
			distance[u.x1][u.y1][u.x2][u.y2] = 0;
			
			
			//System.out.println(idht + " idh ");
			
			boolean done = false;
			while(!queue.isEmpty() && !done){
				Node n = queue.poll();
				//System.out.println("poll " + n.idx+ " "+ n.idy);
				//int acum = distance.get(n.toString());
				int acum = distance[n.x1][n.y1][n.x2][n.y2] ;
				
				
				if(n.x1 == ht[0] && n.x2==ht[0] && n.y1 == ht[1] && n.y2==ht[1] ){
					done = true;
				}
				for(int i = 0 ; i <  mv.length && !done ; i++){
					int vx1=n.x1, vy1=n.y1, vx2=n.x2, vy2 = n.y2;
					
					
					
					int aux1, aux2;
					
						
						aux1 = n.x1 + mv[i][0];
						aux2 = n.y1 + mv[i][1];
						if(aux1>= 0 && aux1 < R && aux2 >= 0 && aux2 < C &&  board[aux1][aux2] != -1){
							vx1 = aux1;
							vy1 = aux2;
						}
						aux1 = n.x2 + mv[i][2];
						aux2 = n.y2 + mv[i][3];
						if(aux1>= 0 && aux1 < R && aux2 >= 0 && aux2 < C &&  board[aux1][aux2] != -1){
							vx2 = aux1;
							vy2 = aux2;
						}
						
					
						Node v = new Node(vx1, vy1, vx2, vy2 , C);
					//System.out.println(" trygin " + v.idx + " " + v.idy+ "  " + distance[v.idx][v.idy]);
						if(distance[v.x1][v.y1][v.x2][v.y2] == -1){
						//	System.out.println(" trygin2 " + v.idx + " " + v.idy);
							distance[v.x1][v.y1][v.x2][v.y2] = acum + 1;
							queue.add(v);
						}
					
				}
				
			}
			
			
			String key = ht[0]+","+ht[1]+":"+ht[0]+","+ht[1];
			

			if ( distance[ht[0]][ht[1]][ht[0]][ht[1]] != -1){
				bw.append(distance[ht[0]][ht[1]][ht[0]][ht[1]] +"\n");
				//System.out.println(distance[idht][idht]);
			}else{
				bw.append("NO LOVE\n");
				//System.out.println("NO LOVE");
			}
			
			
			
			
		}
		bw.close();
	}

}


class Node{
	
	public int x1, y1, x2, y2;

	public Node(int x1, int y1, int x2, int y2 , int C) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;

	}
	
	
	
	
}