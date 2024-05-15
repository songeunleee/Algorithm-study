

import java.util.*;

public class Main {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static boolean visited[][];
	static int arr[][];
	static int M;
	static int N;

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int T = s.nextInt();

		for (int t = 0; t < T; t++) {
			 M = s.nextInt();
			 N = s.nextInt();

			int K = s.nextInt();

			arr = new int[M][N];
			visited = new boolean[M][N];
			
			

			for (int i = 0; i < K; i++) {
				int x = s.nextInt();
				int y = s.nextInt();
				arr[x][y] = 1;
			}
			int count=0;
			for(int i =0;i<M;i++) {
				for(int j =0;j<N;j++) {
					if(visited[i][j] == false && arr[i][j] == 1) {
						count++;
						BFS(i,j);
					}
				}
			}
			
			System.out.println(count);
		}

	}

	public static void BFS(int i ,int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j});
		visited[i][j] = true;
			while(!queue.isEmpty()) {
				int now[] = queue.poll();
				for(int k =0;k<4;k++) {
					int x = now[0]+dx[k];
					int y = now[1]+dy[k];
					if(x>=0 && y>=0 && x<M && y<N) {
						if(arr[x][y] ==1 && !visited[x][y]) {
							visited[x][y] = true;
							queue.add(new int[] {x,y});
						}
					}
				}
			}
		
	}
}