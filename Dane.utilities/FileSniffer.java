package utilities;

import java.io.File;
import java.util.*;
/**
 * A simple utility that performs a DFS on a given root directory and
 * returns all files in that given directory and all of its sub-directories.
 * 
 * 
 * @author Dane Jensen
 * @version 0.0.1  (still in development)
 */
public class FileSniffer {
	/**
	 * YAY RECURSIVE DFS!!!!!!!!!!!!!!!
	 * 
	 * @param path The path to the directory to perform the DFS
	 * @return all files in that directory and all its sub-directories
	 */
	public static ArrayList<String> exploreDir(String path){
		File temp = new File(path);
		ArrayList<String> out = new ArrayList<String>();
		if(!temp.isDirectory() && !(path.contains("DS_STORE"))){
			out.add(path);
		}else{
			String[] paths = temp.list();
			for(String nextPath: paths){
				out.addAll(exploreDir(path + "/" + nextPath));//recursive call
			}
		}
		
		return out;
	}
	
}
