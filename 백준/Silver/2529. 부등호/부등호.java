

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n;
	static int k;
	static String arr[];
	static int answer = 0;
	static boolean visited[];
	static List<String> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		
		arr = new String[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<n;i++) {
			arr[i] = st.nextToken();
		}
		visited = new boolean[10];
		
	dfs(0,"");
	System.out.print(list.get(list.size() - 1) + "\n");
	//최소값
	System.out.print(list.get(0));
	}
	
	static void dfs(int depth,String num) {
		if(depth == n + 1) {
			list.add(num);
			return;
		}
		
		for(int i = 0;i<10;i++) {
			if(visited[i]) {
				continue;
			}
			if(depth==0 || check(arr[depth-1],Character.getNumericValue(num.charAt(depth-1)) , i )) {
				visited[i] = true;
				
				// true일시, num에 문자열 붙임
				dfs(depth+1,num+i);
				visited[i] = false;	
			}
		}
	
	}

	static boolean check(String s,int a, int b) {
		if(s.equals("<")) {
			if(a>b) {
				return false;
			}
		}else if(s.equals(">")){
			if(a<b) {
				return false;
			}
		}
		return true;
	}
		
}
