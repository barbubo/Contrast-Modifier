package application;

import java.awt.image.BufferedImage;

public class FullImage extends NewImage{
	private String source;
	static{
		System.out.println("Image created");
	}
	FullImage(){
		this.img = null;
		this.path = null;
		this.width = 0;
		this.height = 0;
		this.source = null;
	}
	FullImage(BufferedImage img, String path, int width, int height, String source){
		super(img, path, width, height);
		this.source = source;
	}

	public void modificareContrast(double factorContrast) {
		int imgWidth = this.img.getWidth();
		int imgHeight = this.img.getHeight();
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++) {
				int pixel = this.img.getRGB(j, i);
				
				int red = (pixel >> 16) & 0xFF;
				int green = (pixel >> 8) & 0xFF;
				int blue = pixel & 0xFF;
				
				red = (int) (factorContrast * (red - 128) + 128);
				green = (int) (factorContrast * (green - 128) + 128);
				blue = (int) (factorContrast * (blue - 128) + 128);
				
				red = Math.min(Math.max(0, red), 255);
				green = Math.min(Math.max(0, green), 255);
				blue = Math.min(Math.max(0, blue), 255);
				
				int newPixel = (red << 16) | (green << 8) | blue;
				this.img.setRGB(j, i, newPixel);
			}
		}
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getSource() {
		return this.source;
	}
}
