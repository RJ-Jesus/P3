package L_07;

import rjj.bmp.Bitmap;

import java.io.IOException;
import java.util.Scanner;

public class ex0702 {
	static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.print("File name: ");
		String fname = sc.nextLine();
		Bitmap bm = new Bitmap(fname);
		System.out.println(bm);
		switch (menu()) {
		case 1:
			String saveName = saveImage(fname);
			bm.saveRawData(saveName);
			break;
		case 2:
			bm.resize(resizeImage());
			saveName = saveImage(fname);
			bm.save(saveName);
			break;
		case 3:
			bm.flipVertical();
			saveName = saveImage(fname);
			bm.save(saveName);
			break;
		}
	}

	public static int menu() {
		System.out.println("1 - Extract pixel data");
		System.out.println("2 - Resize image");
		System.out.println("3 - Flip the image vertically");
		System.out.print("Opt: ");
		int x = -1;
		while (x < 1 || x > 3)
			x = Integer.parseInt(sc.nextLine());
		return x;
	}

	public static String extractData() {
		System.out.println("File to save RAW data to: ");
		return sc.nextLine();
	}

	public static double resizeImage() {
		System.out.println("Resize value: ");
		return Double.parseDouble(sc.nextLine());
	}
	
	public static String saveImage(String defaultName){
		System.out.println("File to save to (ENTER to overwrite): ");
		String name = sc.nextLine();
		name = name.equals("") ? defaultName : name;
		return name;
	}

}
