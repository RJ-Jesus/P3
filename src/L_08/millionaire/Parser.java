package L_08.millionaire;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Parser {

	static void parse(LinkedList<Question> q, String fname) throws IOException{
		parse(q, new File(fname));
	}
	
	static void parse(LinkedList<Question> q, File f) throws IOException{
		parse(q, new FileReader(f));
	}
	
	static void parse(LinkedList<Question> q, FileReader f) throws IOException{
		BufferedReader br = new BufferedReader(f);
		String line = br.readLine();
		while(line != null && !line.equals("")){
			String[] elems = line.split("&&");
			q.add(new Question("src/L_08/Static.d/" + elems[0].replace(":", "/"), elems[1], elems[2], Integer.parseInt(elems[6]), elems[2], elems[3], elems[4], elems[5]));
			line = br.readLine();
		}
		br.close();
	}

	static <T> T[] scrambleArray(T[] ops) {
		T tmp;
		Random rand = new Random();
		for (int i = ops.length - 1, idx; i > 0; i--) {
			idx = rand.nextInt(i + 1);
			tmp = ops[idx];
			ops[idx] = ops[i];
			ops[i] = tmp;
		}
		return ops;
	}

	static <T extends Comparable<? super T>> T[] randSort(T[] arr){
		scrambleArray(arr);
		Arrays.sort(arr);
		return arr;
	}

}
