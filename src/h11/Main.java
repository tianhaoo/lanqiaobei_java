package h11;

import java.util.Scanner;

public class Main {
	public static int n, m, k, t;
	public static int[] time, have;
	public static Fangan[] fangans;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		m = scan.nextInt();
		k = scan.nextInt();
		t = scan.nextInt();
		time = new int[n+1];
		for (int i = 1; i <= n; i++) {
			time[i] = scan.nextInt();
		}
		have = new int[m];
		for (int i = 0; i < m; i++) {
			have[i] = scan.nextInt();
		}
		fangans = new Fangan[k];
		for (int i = 0; i < k; i++) {
			fangans[i] = new Fangan(scan.nextInt(), scan.nextInt(), scan.nextInt());
		}
		System.out.println(dfs(t));
		 	
		
	}
	
	public static int dfs(int target) {
		for (int i = 0; i < have.length; i++) {
			if(have[i] == target) {
				return 0;
			}
		}
		int sum =0;
		for(Fangan fangan: fangans) {
			if(fangan.jieguo == target) {
				// System.out.println(target+" : " + String.valueOf(fangan.x) + " " + String.valueOf(fangan.y) + " : "+ time[fangan.x-1]+ " " + time[fangan.y-1]);
				       // 培养出x的时间           // 培养出y的时间        // 种x的时间     // 种y的时间
				sum += Math.max(dfs(fangan.x), dfs(fangan.y)) + Math.max(time[fangan.x], time[fangan.y]);
				break;
			}
		}
		return sum;
	}
	
	public static class Fangan{
		int x;
		int y;
		int jieguo;
		public Fangan(int x, int y, int jieguo) {
			this.x = x;
			this.y = y;
			this.jieguo = jieguo;
		}
	}

}
