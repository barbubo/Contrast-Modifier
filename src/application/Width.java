package application;

public abstract class Width {
	protected int width;
	Width(){
		this.width = 0;
	}
	Width(int width){
		this.width = width;
	}
	public int getWidth(){
		return width;
	}
	public void setWidth(int w) {
		this.width = w;
	}
	public abstract int getHeight();
}
