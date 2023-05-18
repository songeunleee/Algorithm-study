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
		int X = Integer.parseInt(st.nextToken());

		int S[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		S[0] = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<N;i++) {
			S[i] = S[i-1]+ Integer.parseInt(st.nextToken());
		}
		
		int maxVisit = S[X-1];
		
		for(int i=X;i<N;i++) {
			int j = i-X;
			maxVisit = Math.max(S[i]-S[j], maxVisit);
			
		}
		
		if(maxVisit==0) {
			System.out.println("SAD");
			return;
		}
		
		System.out.println(maxVisit);
		
		int  visit = S[X-1];
		int cnt =0;
		if(visit == maxVisit) cnt++;
		for(int i=X;i<N;i++) {
			int j = i-X;
			visit = S[i]-S[j];

			if(maxVisit==visit) cnt++;
			
			
		}
		
		System.out.println(cnt);
	}

}
