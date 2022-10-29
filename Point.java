import java.lang.Math;

abstract class Point {

    int x, y;
    double r_min, r_max, i_min, i_max;
    int iterations;

    static int width = 800;
    static int height = 800;

    
    public Point(int x, int y, double r_min, double r_max, double i_min, double i_max, int iterations) {
        this.x = x;
        this.y = y;
        this.r_min = r_min;
        this.r_max = r_max;
        this.i_min = i_min;
        this.i_max = i_max;
        this.iterations = iterations;
    }

    public Point(){

    }

    public double getReal(){
        return (x) * (r_max - r_min) / (width-1) + r_min;
    }

    public double getImg(){
        return (y) * (i_min-i_max) / (height-1) + i_max;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract int getIterations();


}
	