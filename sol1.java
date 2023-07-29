package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class main_misc {

	
	public static HashMap<String,Boolean> cache = new HashMap<>();
	
	public static void main(String[] args) {
	
		
	cache.put("damp", true);
	cache.put("lamp", true);
	cache.put("limp", true);
	cache.put("asfsd", true);
	cache.put("lime", true);
	cache.put("like", true);
	cache.put("muda", true);
	
	System.out.println(word_transformer("damp","like"));
		
	}
	
	
	private static boolean word_transformer(String start,String goal,LinkedList<String> path){
		
		if(start.equals(goal)){
			return true;
		}
		if(!cache.containsKey(start)){
			return false;
		}
		
		
		for(int i = 0;i < start.length();i++){
			
			String a = start.substring(i,i+1);
			String b = goal.substring(i,i+1);
			
			if(!a.equals(b)){
				
				String next = start.replace(a,b);
				if(word_transformer(next,goal,path)) {
					path.addFirst(next);
					return true;
				}
				
			}
			
		}
		return false;
	}
	
	private static List<String> word_transformer(String start,String goal){
		
		LinkedList<String> path = new LinkedList<>();
		boolean has_path = word_transformer(start,goal,path);
		path.addFirst(start);
		if(has_path){
			return path;
		}
		else {
			System.out.println("No path.");
			return null;
		}
	}
	
}
