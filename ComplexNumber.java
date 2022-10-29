public class ComplexNumber {
    private double x, y;

    public ComplexNumber(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getABS(){
        return Math.pow(this.x, 2) + Math.pow(this.y, 2);
    }

    public ComplexNumber getNext(double Cx, double Cy){
        double x1 = Math.pow(this.x, 2) - Math.pow(this.y, 2);
        double y1 = 2 * this.x * this.y;
        return new ComplexNumber(x1+Cx, y1+Cy);
    }


}
