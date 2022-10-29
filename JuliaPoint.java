public class JuliaPoint extends Point {
    private double real, imag;
    public JuliaPoint(int x, int y, double real, double imag, int iterations) {
        super(x, y, -1, 1, -1, 1,iterations);
        this.real = real;
        this.imag = imag;
    }


    public int getIterations(){
        ComplexNumber Zn = new ComplexNumber(this.getReal(),this.getImg());
        for (int i = 0; i < this.iterations; i++) {
            if(Zn.getABS() > 4){
                return i;
            }
            Zn = Zn.getNext(this.real, this.imag);
        }
        return iterations;
    }
}
