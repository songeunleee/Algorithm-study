import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static int MAX = Integer.MIN_VALUE;
	public static int MIN = Integer.MAX_VALUE;
	// static int arr[];
	static int opr[];
	// static int answer = 0;
	static boolean visited[];
	static List<Integer> list;
	static Queue<String> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		 st = new StringTokenizer(br.readLine());
		 int n = Integer.parseInt(st.nextToken());
		 
		 
		 String[][] arr = new String[n][4];
		 
		 for(int i=0;i<n;i++) {
			 st = new StringTokenizer(br.readLine());
			 arr[i][0] = st.nextToken();
			 arr[i][1] = st.nextToken();
			 arr[i][2] = st.nextToken();
			 arr[i][3] = st.nextToken();
		 }
		 
		 Arrays.sort(arr,(o1,o2)-> {
			 if(o1[1].equals(o2[1])) {
				 if(o1[1].equals(o2[1])&& o1[2].equals(o2[2])) {
					 if(o1[1].equals(o2[1]) && o1[2].equals(o2[2])&& o1[3].equals(o2[3])) {
						 return o1[0].compareTo(o2[0]);
					 }
					 return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
				 }
				 return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
			 }
			   return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
			 
		 });
		 
		 for(int i =0;i<n;i++) {
			 System.out.println(arr[i][0]);
		 }

		
	}

}
