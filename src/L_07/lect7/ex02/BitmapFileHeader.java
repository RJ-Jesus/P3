package L_07.lect7.ex02;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BitmapFileHeader {
	static final int SIZE = 14;
	private short type;
	private int size;
	private short reserved0;
	private short reserved1;
	private int offBits;

	public BitmapFileHeader(byte[] arr) {
		if (arr.length != 14)
			throw new IllegalArgumentException("Bitmap File Header is 14 bytes long.");
		ByteBuffer bo = ByteBuffer.wrap(arr).order(ByteOrder.LITTLE_ENDIAN);
		type = bo.getShort();
		size = bo.getInt();
		reserved0 = bo.getShort();
		reserved1 = bo.getShort();
		offBits = bo.getInt();
	}

	public short type() {
		return type;
	}

	public int size() {
		return size;
	}

	public short res0() {
		return reserved0;
	}

	public short res1() {
		return reserved1;
	}

	public int offBits() {
		return offBits;
	}

	void setType(short type) {
		this.type = type;
	}

	void setSize(int size) {
		this.size = size;
	}

	void setRes1(short reserved1) {
		this.reserved1 = reserved1;
	}

	void setRes0(short reserved0) {
		this.reserved0 = reserved0;
	}

	void setOffBits(int offBits) {
		this.offBits = offBits;
	}

	public byte[] toArray() {
		ByteBuffer bo = ByteBuffer.allocate(SIZE).order(ByteOrder.LITTLE_ENDIAN);
		bo.putShort(type).putInt(size).putShort(reserved0).putShort(reserved1).putInt(offBits);
		return bo.array();
	}

	@Override
	public String toString() {
		byte[] t = { (byte) type, (byte) (type >> 8) };
		return "Type: " + (char) t[0] + (char) t[1] + "\nFile size: " + size + " bytes";
	}

}
