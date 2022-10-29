public class MandrelPoint extends Point {
    public MandrelPoint(int x, int y, double r_min, double r_max, double i_min, double i_max, int iterations) {
        super(x, y, r_min, r_max, i_min, i_max, iterations);
    }

    public int getIterations(){
        ComplexNumber Zn = new ComplexNumber(0,0);
        for (int i = 0; i < iterations; i++) {

            if(Zn.getABS() > 4){
                return i;
            }
            Zn = Zn.getNext(getReal(), getImg());
        }
        return iterations;
    }

}
