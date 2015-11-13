package L_09.ex01;

import java.io.*;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class ScannerAveirense implements Iterator<String>, AutoCloseable, Closeable {
    private Scanner sc;
    // Not needed since at this.next state is not checked
/*
    private boolean isClosed;
*/

    public ScannerAveirense(final File source) throws FileNotFoundException {
        sc = new Scanner(Objects.requireNonNull(source));
    }

    public ScannerAveirense(final File source, final String charsetName) throws FileNotFoundException {
        sc = new Scanner(Objects.requireNonNull(source), Objects.requireNonNull(charsetName));
    }

    public ScannerAveirense(final InputStream source) {
        sc = new Scanner(Objects.requireNonNull(source));
    }

    public ScannerAveirense(final InputStream source, final String charsetName) {
        sc = new Scanner(Objects.requireNonNull(source), Objects.requireNonNull(charsetName));
    }

    public ScannerAveirense(final Path source) throws IOException {
        sc = new Scanner(Objects.requireNonNull(source));
    }

    public ScannerAveirense(final Path source, final String charsetName) throws IOException {
        sc = new Scanner(Objects.requireNonNull(source), Objects.requireNonNull(charsetName));
    }

    public ScannerAveirense(final Readable source) {
        sc = new Scanner(Objects.requireNonNull(source));
    }

    public ScannerAveirense(final ReadableByteChannel source) {
        sc = new Scanner(Objects.requireNonNull(source));
    }

    public ScannerAveirense(final ReadableByteChannel source, final String charsetName) {
        sc = new Scanner(Objects.requireNonNull(source), Objects.requireNonNull(charsetName));
    }

    public ScannerAveirense(final String source) {
        sc = new Scanner(Objects.requireNonNull(source));
    }

    @Override
    public boolean hasNext() {
        return sc.hasNext();
    }

    @Override
    public String next() {
        // Checks already conducted by java.util.Scanner
/*        if(!sc.hasNext())
            throw new NoSuchElementException();
        if(isClosed)
            throw new IllegalStateException();
*/
        return replace(sc.next());
    }

    public String nextLine() {
        return replace(sc.nextLine());
    }

    private String replace(final String s) {
        return s.replace('v', 'b').replace('V', 'B');
    }

    @Override
    public void close() throws IOException {
        sc.close();
        // Not needed since at this.next() state is not checked
/*
        isClosed = true;
*/
    }
}
