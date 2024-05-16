import java.util.*;

public class Main {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static boolean visited[][];
	static int arr[][];
	static int M;
	static int N;
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		M = s.nextInt();
		N = s.nextInt();
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.nextInt();
			}
		}
		
		for(int i =0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if( arr[i][j] == 1) {
					 
					q.offer(new int[] {i,j});
					visited[i][j] = true;
				}
			}
		}
		
		BFS();
		int max = 0;
		for(int i =0;i<N;i++) {
			
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 0) { 
					System.out.println(-1);
					return;
				}
				if(max<arr[i][j]) max = arr[i][j];
			}
		}
		
		System.out.println(max-1);

	}
	
	static void BFS() {
		
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			
			for(int k =0;k<4;k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if(x>=0&&y>=0&&x<N&&y<M) {
					if(!visited[x][y] && arr[x][y] != -1) {
						visited[x][y] = true;
						arr[x][y] = arr[now[0]][now[1]] + 1;
						q.add(new int[] {x,y});
					}
				}
			}
		}
		
	}
}