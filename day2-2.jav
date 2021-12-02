import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
import java.util.*;

public class day2_1 {
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
		
		
		int x = 0;
		int y = 0;
		int aim = 0;
		
		for(int i=0; i<a.size(); i++) {
			String l = a.get(i);
			
			if(l.charAt(0)=='u') {
				int num = Integer.parseInt(l.substring(3));
				aim -= num;
			}
			else if(l.charAt(0)=='d') {
				int num = Integer.parseInt(l.substring(5));
				aim += num;
			}
			else if(l.charAt(0)=='f') {
				int num = Integer.parseInt(l.substring(8));
				x += num;
				y += aim*num;
			}
			
			
		}
		
		int answer = x*y;
		System.out.println(answer);
	}
}
