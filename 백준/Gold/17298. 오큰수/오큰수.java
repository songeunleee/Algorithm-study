import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int A[] = new int[N];
		

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < A.length; i++) {
			while (!stack.empty() && A[stack.peek()] < A[i]) {
				A[stack.pop()] = A[i];
			}
			stack.push(i);
		}
		
		while(!stack.empty()) {
			A[stack.pop()]=-1;
		}

		for(int i=0;i<A.length;i++) {
			sb.append(A[i]+" ");
		}
        System.out.print(sb);
	}

}
