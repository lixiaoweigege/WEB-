package utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
 
import javax.imageio.ImageIO;
 
public class VerifyCode {
 
	private int w = 70;
	private int h = 35;
 
	private Random r = new Random();
	// ��������Щ����
	private String[] fontNames = { "����", "���Ŀ���", "����", "΢���ź�", "����_GB2312" };
	// ��������Щ��֤�������ַ�
	private String codes = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ";
	// ���ɱ���ɫ
	@SuppressWarnings("unused")
	private Color bgColor = new Color(250, 250, 250);
	//����gettext ���� ������ɵ���֤���ı�
	private String text;
 
	// ���������ɫ
	private Color randomColor() {
		int red = r.nextInt(150);
		int green = r.nextInt(150);
		int blue = r.nextInt(150);
		return new Color(red, green, blue);
	}
 
	// �����������
	private Font randomFont() {
		int index = r.nextInt(fontNames.length);
		String fontName = fontNames[index];
		int style = r.nextInt(4);
		int size = r.nextInt(5) + 24;
 
		return new Font(fontName, style, size);
	}
 
	// ��������
	private void drawLine(BufferedImage image) {
		int num = 3;
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		for (int i = 0; i < num; i++) {
			int x1 = r.nextInt(w);
			int y1 = r.nextInt(h);
			int x2 = r.nextInt(w);
			int y2 = r.nextInt(h);
			g2.setStroke(new BasicStroke(1.5F));// ��֪��
			g2.setColor(Color.blue);
			g2.drawLine(x1, y1, x2, y2);
		}
	}
 
	// �õ�codes�ĳ����ڵ������ ��ʹ��charAt ȡ�������λ���ϵ�codes�е��ַ�
	private char randomChar() {
		int index = r.nextInt(codes.length());
		return codes.charAt(index);
	}
 
	// ����һ����֤���ͼƬ
	public BufferedImage createImage() {
		BufferedImage image = new BufferedImage(w, h,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		StringBuilder sb = new StringBuilder();
		// ��ͼ�л��ĸ��ַ�
		for (int i = 0; i < 4; i++) {
			String s = randomChar() + "";
			sb.append(s);
			float x = i * 1.0F * w / 4;
			g2.setFont(randomFont());
			g2.setColor(randomColor());
			g2.drawString(s, x, h - 5);
 
		}
		this.text = sb.toString();
		drawLine(image);
 
		// ����ͼƬ
		return image;
 
	}
 
	// �õ���֤����ı� �������������û��������֤�� �����
	public String getText() {
		return text;
	}
 
	// ��������Ķ��������ķ���
	public static void output(BufferedImage bi, OutputStream fos)
			throws FileNotFoundException, IOException {
		ImageIO.write(bi, "JPEG", fos);
	}
}
