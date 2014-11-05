package module5;

import java.io.*;
import java.net.*;
import java.util.*;

public class DataAnalysis {

	public static void main(String[] args) {
		
	}
		
static ArrayList<DataPoint> dataFromURL(String url)throws IOException{
	//Initialising array list
	ArrayList data=new ArrayList<DataPoint>();
	URL u=new URL(url);
	//Opening an input stream to read some number of bytes and wrapping it into a buffer
	InputStream is=u.openStream();
	InputStreamReader isr = new InputStreamReader(is);
	BufferedReader br = new BufferedReader(isr);
}



	
}
