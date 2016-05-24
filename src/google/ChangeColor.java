package google;

/* 32位int表示四种颜色， RGBA， 比如R就是一个8bit，让转换成GBRA
 * 用Bit操作完成，移位后和0xFF操作。一开始没用这个方法做，小哥提示了。
 */
public class ChangeColor {
	public static int change(int color) {
		int r = color & 0xFF000000;
		int g = color & 0x00FF0000;
		int b = color & 0x0000FF00;
		int a = color & 0x000000FF;
		return r >> 16 | g << 8 | b << 8 | a;
	}
	public static void main(String[] args) {
	    int color = 0x01020304;
	    assert(change(color) == 0x02030104);
	    color = 0x0502010A;
	    assert(change(color) == 0x0201050A);
	}
}
