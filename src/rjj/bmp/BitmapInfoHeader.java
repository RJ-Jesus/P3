package rjj.bmp;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BitmapInfoHeader {
	static final int SIZE = 40;
	private int size;
	private int width;
	private int height;
	private short planes;
	private short bitCount;
	private int compression;
	private int sizeImage;
	private int xPelsPerMeter;
	private int yPelsPerMeter;
	private int colorUsed;
	private int colorImportant;

	public BitmapInfoHeader(final byte[] arr) {
		if (arr.length != 40)
			throw new IllegalArgumentException("Bitmap Info Header is 40 bytes long.\n");
		ByteBuffer bo = ByteBuffer.wrap(arr).order(ByteOrder.LITTLE_ENDIAN);
		size = bo.getInt();
		width = bo.getInt();
		height = bo.getInt();
		planes = bo.getShort();
		bitCount = bo.getShort();
		compression = bo.getInt();
		sizeImage = bo.getInt();
		xPelsPerMeter = bo.getInt();
		yPelsPerMeter = bo.getInt();
		colorUsed = bo.getInt();
		colorImportant = bo.getInt();
	}

	public int size() {
		return size;
	}

	public int width() {
		return width;
	}

	public int height() {
		return height;
	}

	public short planes() {
		return planes;
	}

	public short bitCount() {
		return bitCount;
	}

	public int compression() {
		return compression;
	}

	public int sizeImage() {
		return sizeImage;
	}

	public int xPelsPerMeter() {
		return xPelsPerMeter;
	}

	public int yPelsPerMeter() {
		return yPelsPerMeter;
	}

	public int colorUsed() {
		return colorUsed;
	}

	public int colorImportant() {
		return colorImportant;
	}

	void setSize(final int size) {
		this.size = size;
	}

	void setWidth(final int width) {
		this.width = width;
	}

	void setHeight(final int height) {
		this.height = height;
	}

	void setPlanes(final short planes) {
		this.planes = planes;
	}

	void setBitCount(final short bitCount) {
		this.bitCount = bitCount;
	}

	void setCompression(final int compression) {
		this.compression = compression;
	}

	void setSizeImage(final int sizeImage) {
		this.sizeImage = sizeImage;
	}

	void setxPelsPerMeter(final int xPelsPerMeter) {
		this.xPelsPerMeter = xPelsPerMeter;
	}

	void setyPelsPerMeter(final int yPelsPerMeter) {
		this.yPelsPerMeter = yPelsPerMeter;
	}

	void setColorUsed(final int colorUsed) {
		this.colorUsed = colorUsed;
	}

	void setColorImportant(final int colorImportant) {
		this.colorImportant = colorImportant;
	}

	public byte[] toArray() {
		ByteBuffer bo = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN);
		bo.putInt(size).putInt(width).putInt(height).putShort(planes).putShort(bitCount).putInt(compression)
				.putInt(sizeImage).putInt(xPelsPerMeter).putInt(yPelsPerMeter).putInt(colorUsed).putInt(colorImportant);
		return bo.array();
	}

	@Override
	public String toString() {
		return "Image width: " + width + " pixels" + "\nImage Height: " + height + " pixels" + "\nColor planes: "
				+ planes + "\nBits per pixel: " + bitCount() + "\nRaw data size: " + sizeImage + " bytes"
				+ "\nPixels/meter horizontal: " + xPelsPerMeter + "\nPixels/meter vertical: " + yPelsPerMeter
				+ (colorUsed == 0 ? "" : "\nColors in the palette: " + colorUsed) + "\n"
				+ (colorImportant == 0 ? "All colors are important." : "Important colors: " + colorImportant);
	}

}
