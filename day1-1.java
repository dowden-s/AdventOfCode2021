import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
import java.util.*;

public class day1 {
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
		
		int num = 0;
		
		for(int i=0; i<a.size(); i++) {
			if(i==0) {
				System.out.println("It works");
			}
			else {
				int b = Integer.parseInt(a.get(i));
				int c = Integer.parseInt(a.get(i-1));
				
				if(b>c) {
					num+=1;
				}
			}
		}
		
		System.out.println(num);
	}
}
