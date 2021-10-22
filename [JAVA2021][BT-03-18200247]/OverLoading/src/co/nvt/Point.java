package co.nvt;

public class Point {
	public int x = 0,y = 0;
	
	public Point getX() {
		return this;
	}
	
	public void setY(int x,int y) {
		this.y = y;
		this.x = x;
	}

	public static Point adder (Point a,Point b) {
		a.x += b.x;
		a.y += b.y;
		return a;
	}
	//sử dụng method này chương trình sẽ báo lỗi Duplicate method nhưng chương trình vẫn chạy với method Point adder(Point,Point)
	/*public int[] adder(Point a,Point b) {
		int point[] = new int[2];
		point[0] = a.x+b.x;
		point[1] = a.y+b.y;
		return point;
	}*/
}
