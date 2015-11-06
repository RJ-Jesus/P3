package L_08.millionaire;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class Parser {
    private static Random rand = new Random();

	static void parse(final Collection<Question> q, final String fName) throws IOException {
		parse(q, new File(fName));
	}

	static void parse(final Collection<Question> q, final File f) throws IOException {
		parse(q, new FileReader(f));
	}

	static void parse(final Collection<Question> q, final FileReader f) throws IOException {
		BufferedReader br = new BufferedReader(f);
		String line = br.readLine();
		while(line != null && !line.equals("")){
			String[] elems = line.split("&&");
			q.add(new Question("src/L_08/Static.d/" + elems[0].replace(":", "/"), elems[1], elems[2], Integer.parseInt(elems[6]), elems[2], elems[3], elems[4], elems[5]));
			line = br.readLine();
		}
		br.close();
	}

	static <T> T[] scrambleArray(final T[] ops) {
		T tmp;
		for (int i = ops.length - 1, idx; i > 0; i--) {
			idx = rand.nextInt(i + 1);
			tmp = ops[idx];
			ops[idx] = ops[i];
			ops[i] = tmp;
		}
		return ops;
	}

	static <T extends Comparable<? super T>> T[] sort(final T[] arr) {
		Arrays.sort(arr);
		return arr;
	}

}
