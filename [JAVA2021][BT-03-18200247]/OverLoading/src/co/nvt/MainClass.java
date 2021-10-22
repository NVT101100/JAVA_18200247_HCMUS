package co.nvt;

public class MainClass {

	public static void main(String[] args) {
		Point aPoint = new Point();
		Point bPoint = new Point();
		aPoint.setY(8, 9);
		bPoint.setY(-6, 12);
		Point cPoint;
		cPoint = Point.adder(aPoint, bPoint);
		System.out.println("tong 2 diem: ("+ cPoint.x+","+cPoint.y+")");
	}

}

