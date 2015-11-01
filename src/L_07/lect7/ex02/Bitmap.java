package L_07.lect7.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Bitmap {
	private BitmapFileHeader bfh;
	private BitmapInfoHeader bih;
	private byte[][] colorPalette;
	private byte[][] pixelData;

	public Bitmap(String fname) throws IOException {
		this(new File(fname));
	}

	public Bitmap(File f) throws IOException {
		this(new FileInputStream(f));
	}

	public Bitmap(FileInputStream f) throws IOException {
		byte[] bStream = new byte[BitmapFileHeader.SIZE];
		f.read(bStream);
		bfh = new BitmapFileHeader(bStream);
		bStream = new byte[BitmapInfoHeader.SIZE];
		f.read(bStream);
		bih = new BitmapInfoHeader(bStream);
		if (bih.bitCount() < 8)
			throw new IllegalArgumentException("Can't parse bitmaps of less than 8 bpp.");
		colorPalette = new byte[bih.colorUsed()][4];
		for (int i = 0; i < colorPalette.length; i++) {
			bStream = new byte[4];
			f.read(bStream);
			colorPalette[i] = bStream;
			assert colorPalette[i][3] != 0 : "Color palette entries should be Blue(Idx:0) -> Green(Idx:1) -> Red(Idx:2) -> 0x00(Idx:3).";
		}
		int rowSize;
		pixelData = new byte[Math.abs(bih.height())][rowSize = (bih.bitCount() * bih.width() + 31) / 32 * 4];
		for (int i = pixelData.length - 1; i >= 0; i--) {
			bStream = new byte[rowSize];
			f.read(bStream);
			pixelData[i] = bStream;
		}
	}

	@Override
	public String toString() {
		return "Bitmap - " + bfh + "\n" + bih;

	}

	public void saveRawData(String fname) throws IOException {
		saveRawData(new File(fname));
	}

	public void saveRawData(File f) throws IOException {
		saveRawData(new FileOutputStream(f));
	}

	public void saveRawData(FileOutputStream f) throws IOException {
		for (byte[] row : pixelData)
			f.write(row);
		f.flush();
	}

	public void resize(double v) {
		if (v > 1)
			throw new UnsupportedOperationException(
					"Currently it's only possible to resize the image to a smaller size.");
		double r = Math.sqrt(v);
		int nCols = (int) (bih.width() * r);
		int nRows = (int) Math.abs(bih.height() * r);
		int rowSize = (bih.bitCount() * nCols + 31) / 32 * 4;
		bfh.setSize(BitmapFileHeader.SIZE + BitmapInfoHeader.SIZE
				+ (bih.colorUsed() != 0 ? colorPalette.length * colorPalette[0].length : 0) + nRows * rowSize);
		bih.setWidth(nCols);
		/*
		 * Notice: Negative height means usual order : last row -> top row
		 * Positive height means opposite order : top row -> last row
		 */
		bih.setHeight(-1 * nRows);
		bih.setSizeImage(nRows * rowSize);
		double ratio = (double) pixelData[0].length / rowSize;
		byte[][] pData = new byte[nRows][rowSize];
		for (int i = 0, bytes = bih.bitCount() / 8, oi; i < pData.length; i++) {
			oi = (int) (i * ratio);
			for (int j = 0, oj; j < pData[0].length; j += bytes) {
				oj = (int) (j * ratio);
				while (oj % bytes != 0)
					oj--;
				int c = 0;
				if (j + bytes <= pData[0].length && oj + bytes <= pixelData[0].length) {
					while (c < bytes) {
						pData[i][j + c] = pixelData[oi][oj + c];
						c++;
					}
				}
			}
		}
		this.pixelData = pData;
	}

	public void flip() {
		for (int i = 0; i < pixelData.length >> 1; i++) {
			byte[] tmp = pixelData[i];
			pixelData[i] = pixelData[pixelData.length - 1 - i];
			pixelData[pixelData.length - 1 - i] = tmp;
		}
	}

	public void save(String fname) throws IOException {
		save(new File(fname));
	}

	public void save(File f) throws IOException {
		save(new FileOutputStream(f));
	}

	public void save(FileOutputStream f) throws IOException {
		f.write(bfh.toArray());
		f.write(bih.toArray());
		for (byte[] cp : colorPalette)
			f.write(cp);
		for (int i = pixelData.length - 1; i >= 0; i--)
			f.write(pixelData[i]);
		f.flush();
	}

}
