package rjj.bmp;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class GUI {
    private static final String title = "BMP Viewer";
    private Bitmap picture;
    private JLabel pic_label;
	private JFrame frame;
    /* private JMenuItem open, save, save_as, flip_v, flip_h, resize;   // This were made local */
    private JFileChooser fc;

	public GUI() throws IOException {
		frame = new JFrame(title);
		initiateGUI(frame.getContentPane());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private void initiateGUI(final Container content) {
		fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter("Bitmap", "bmp", "dib"));

		JMenuBar m_bar = new JMenuBar();

		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		m_bar.add(file);
		JMenu image = new JMenu("Image");
		image.setMnemonic(KeyEvent.VK_I);
		m_bar.add(image);

        JMenuItem open = new JMenuItem("Open file...");
        open.addActionListener(e -> {
            int rtnValue = fc.showOpenDialog(frame);
            if (rtnValue == JFileChooser.APPROVE_OPTION)
                try {
                    picture = new Bitmap(fc.getSelectedFile());
                    drawImage(frame.getContentPane());
                } catch (IOException e1) {
                    System.err.println(e1.getMessage());
                }
        });
        file.add(open);
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(e -> {
            try {
                if (picture != null)
                    picture.save(picture.getPath());
            } catch (IOException e1) {
                System.err.println(e1.getMessage());
            }
        });
        file.add(save);
        JMenuItem save_as = new JMenuItem("Save as...");
        save_as.addActionListener(e -> {
            if (fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION)
                try {
                    if (picture != null)
                        picture.save(fc.getSelectedFile());
                } catch (IOException e1) {
                    System.err.println(e1.getMessage());
                }
        });
        file.add(save_as);

        JMenuItem flip_v = new JMenuItem("Vertical Flip");
        flip_v.addActionListener(e -> {
            if (picture != null) {
                picture.flipVertical();
                drawImage(frame.getContentPane());
            }
        });
        image.add(flip_v);
        JMenuItem flip_h = new JMenuItem("Horizontal Flip");
        flip_h.addActionListener(e -> {
            if (picture != null) {
                picture.flipHorizontal();
                drawImage(frame.getContentPane());
            }
        });
        image.add(flip_h);
        JMenuItem resize = new JMenuItem("Resize");
        resize.addActionListener(e -> {
            String text = JOptionPane.showInputDialog("Please input a value (in ]0, 1])");
            try {
                double v = Double.parseDouble(text);
                if (picture != null) {
                    picture.resize(v);
                    drawImage(frame.getContentPane());
                }
            } catch (NullPointerException | NumberFormatException e1) {
                System.err.println("Invalid input: " + e1.getMessage());
            }
        });
        image.add(resize);

		content.add(m_bar, BorderLayout.PAGE_START);
	}

	private void drawImage(final Container content) {
		try {
			content.remove(pic_label);
		} catch (NullPointerException e) {
			e.printStackTrace();
            System.err.println("Tl;dr: This NullPointer might be because no other image was previously set.");
        }
        pic_label = new JLabel(new ImageIcon(picture.toBufferedImage()));
		content.add(pic_label, BorderLayout.CENTER);
		frame.setTitle(title + String.format(" - %.2f%%", picture.getRelation() * 100));
		frame.setVisible(true);
	}
}
