import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
import java.util.*;

public class day2 {
	
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
		
		ArrayList<String> up = new ArrayList<String>();
		ArrayList<String> down = new ArrayList<String>();
		ArrayList<String> forward = new ArrayList<String>();
		
		for(int i=0; i<a.size(); i++) {
			String l = a.get(i);
			
			if(l.charAt(0)=='u') {
				up.add(l);
			}
			else if(l.charAt(0)=='d') {
				down.add(l);
			}
			else if(l.charAt(0)=='f') {
				forward.add(l);
			}
		}
		
		int y = 0;
		for(int i=0; i<up.size(); i++) {
			int num = Integer.parseInt(up.get(i).substring(3));
			y -= num;
		}
		for(int i=0; i<down.size(); i++) {
			int num = Integer.parseInt(down.get(i).substring(5));
			y += num;
		}
		
		int x = 0;
		for(int i=0; i<forward.size(); i++) {
			int num = Integer.parseInt(forward.get(i).substring(8));
			x += num;
		}
		
		int answer = y*x;
		System.out.println(answer);
	}
}
