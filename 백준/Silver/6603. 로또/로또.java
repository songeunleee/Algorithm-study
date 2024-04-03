

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int K;
	static int s;
	static int arr[];
	//static int answer = 0;
	static boolean visited[];
	static List<String> list;

	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			if(K == 0) break;
			list = new ArrayList<>();
			arr = new int[K];
			for(int i =0;i<K;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			visited = new boolean[K];
			
			dfs("",0,0);
			
			for(String s : list) {
				System.out.println(s);
				
			}
			System.out.println();
			
			
		}
	}

	static void dfs(String num, int depth, int at) {
		if(depth==6) {
			list.add(num);
		}
		
		for(int i =at;i<K;i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(num+arr[i]+" ",depth+1,i+1);
				visited[i] = false;
			}
		}
	}

}
