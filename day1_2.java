import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
import java.util.*;

public class day1_2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		ArrayList<String> a = new ArrayList<String>();
		
		String line;
		while(true) {
			line = input.nextLine();
			if(line.equals("")) {
				break;
			}
			else {
				a.add(line);
			}
		}
		
		ArrayList<Integer> f = new ArrayList<Integer>();
		
		for(int i=0; i<a.size()-2; i++) {
			int b = Integer.parseInt(a.get(i));
			int c = Integer.parseInt(a.get(i+1));
			int d = Integer.parseInt(a.get(i+2));
			
			int e = b+c+d;
			f.add(e);
		}
		
		int num = 0;
		
		for(int i=0; i<f.size(); i++) {
			if(i==0) {
				System.out.println("It works");
			}
			else {
				if(f.get(i)>f.get(i-1)) {
					num+=1;
				}
			}
		}
		
		System.out.println(num);
	}
}

