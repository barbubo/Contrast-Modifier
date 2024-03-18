package application;

public class Dimensions extends Width{
	protected int height;
	Dimensions(){
		this.width = 0;
		this.height = 0;
	}
	Dimensions(int width, int height){
		super(width);
		this.height = height;
	}
	
	public void setHeight(int h) {
		this.height = h;
	}
	
	public int getHeight() {
		return this.height;
	}
}
