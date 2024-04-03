

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n;
	public static int MAX = Integer.MIN_VALUE;
	public static int MIN = Integer.MAX_VALUE;
	static int arr[];
	static int opr[];
	//static int answer = 0;
	static boolean visited[];
	static List<Integer> list;
	static Queue<String> q = new LinkedList<>(); 

	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		opr = new int[4];
		visited = new boolean[4];
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<4;i++) {
			opr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1,arr[0]);
		System.out.println(MAX);
		System.out.println(MIN);
		
	}
	
	static void dfs(int depth, int num) {
		
		if(depth == n) {
			MAX = Math.max(MAX,num);
			MIN = Math.min(MIN,num);
			return;
		}
		
		for(int i =0;i<4;i++) {
			if(opr[i]>0) {
				opr[i]--;
				
				switch(i) {
				
				case 0: dfs(depth+1,num+arr[depth]); break;
				case 1: dfs(depth+1,num-arr[depth]); break;
				case 2: dfs(depth+1,num*arr[depth]); break;
				case 3: dfs(depth+1,num/arr[depth]); break;
				
				}
				
				opr[i]++;
			}
		}
		
	}


}
