
import java.util.*;

public class Main {
	static int[] dx = { 0, 1, 0, -1, 0, 0 };
	static int[] dy = { -1, 0, 1, 0, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	static boolean visited[][][];
	static int arr[][][];
	static int M;
	static int N;
	static int H;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		M = s.nextInt();
		N = s.nextInt();
		H = s.nextInt();
		arr = new int[H][N][M];
		visited = new boolean[H][N][M];

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[h][i][j] = s.nextInt();
				}
			}
		}

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[h][i][j] == 1) {

						q.offer(new int[] { h, i, j });
						visited[h][i][j] = true;
					}
				}
			}
		}

		BFS();
		int max = 0;
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[h][i][j] == 0) {
						System.out.println(-1);
						return;
					}
					if (max < arr[h][i][j])
						max = arr[h][i][j];
				}
			}
		}

		System.out.println(max - 1);

	}

	static void BFS() {
		
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			
			for(int k =0;k<6;k++) {
				int x = now[1] + dx[k];
				int y = now[2] + dy[k];
				int h = now[0] + dh[k];
				if(x>=0&&y>=0&&h>=0&&x<N&&y<M&&h<H) {
					if(!visited[h][x][y] && arr[h][x][y] != -1) {
						visited[h][x][y] = true;
						arr[h][x][y] = arr[now[0]][now[1]][now[2]] + 1;
						q.add(new int[] {h,x,y});
					}
				}
			}
		}
		
	}
}