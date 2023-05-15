import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	static int[][] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Integer> A = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		
		for(int i =0;i<N;i++ ) {
		
				A.add(Integer.parseInt(st.nextToken()));
			
		}

		st = new StringTokenizer(br.readLine());
		
		for(int i =0;i<M;i++ ) {
			
				A.add(Integer.parseInt(st.nextToken()));
			
		}
		
		Collections.sort(A);
		
		for(int i : A) {
			bw.write(i+" ");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}
