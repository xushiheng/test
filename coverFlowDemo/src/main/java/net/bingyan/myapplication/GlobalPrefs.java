package net.bingyan.myapplication;

// 储存一些界面数据
public class GlobalPrefs {
	
	static int density;
	static int width;
	int height;
	

	public static int getDensity() {
		return density;
	}

	public static float getScreenWidth() {
		return width;
	}

	public static void setDensity(float dense) {
		density = (int)dense;
	}

	public static void setScreenWidth(int widthPixels) {
		width = widthPixels;
	}
	
	

}
