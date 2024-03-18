package application;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class NewImage extends Dimensions implements Interface {
	BufferedImage img;
	String path;
	
	NewImage(){
		this.img = null;
		this.path = null;
		this.width = 0;
		this.height = 0;
	}
	NewImage(BufferedImage img, String path, int width, int height){
		super(width,height);
		this.img = img;
		this.path = path;
	}
	
	public void readImg(String path) {
		try {
			File f = new File(path);
			this.img = ImageIO.read(f);
			this.width = this.img.getWidth();
			this.height = this.img.getHeight();
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	public void writeImg(String path){
		try {
			File f = new File(path);
			ImageIO.write(this.img, "bmp", f);
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	public int getWidth() {
		return this.img.getWidth();
	}
	public int getHeight() {
		return this.img.getHeight();
	}
	public BufferedImage getImage() {
		return this.img;
	}
	
}
