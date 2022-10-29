import java.awt.*; /* java abstract window toolkit */
import javax.swing.*;
import java.awt.geom.Line2D;

class Fractal extends JPanel { // inherit JPanel 

    private int setNum, width, height, iterations;
    private double r_min, r_max,i_min, i_max, real, imag;
    private Point point;

    public Fractal(int setNum, int width, int height, double r_min, double r_max, double i_min, double i_max, int iterations) {
	// set the panel size
	this.setNum = setNum;
	this.width  = width; 
	this.height = height;
	this.r_min = r_min;
	this.r_max = r_max;
	this.i_min = i_min;
	this.i_max = i_max;
	this.iterations = iterations;

	setPreferredSize(new Dimension(width, height));

    }

    public Fractal(int setNum, int width, int height, double real, double imag, int iterations){
		this.setNum = setNum;
		this.width  = width;
		this.height = height;
		this.real = real;
		this.imag = imag;
		this.iterations = iterations;
		setPreferredSize(new Dimension(width, height));
	}

    public static void printPoint(Graphics2D frame, Color c, Point p) {

		frame.setColor(c);
		frame.draw(new Line2D.Double(p.getX(), p.getY(), p.getX(), p.getY()));

	}


    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int x = 0 ; x < 800; x++){
			for(int y = 0 ; y < 800; y++){
				if(setNum == 1){
					point = new MandrelPoint(x, y, r_min, r_max, i_min, i_max, iterations);
				}
				else {
					point = new JuliaPoint(x, y, real, imag, iterations);
				}

				if(point.getIterations() == iterations){
					printPoint((Graphics2D)g, Color.RED, point);
				}
				else if(point.getIterations() > iterations*1/10){
					printPoint((Graphics2D)g, Color.GREEN, point);
				}

				else if(point.getIterations() > iterations*1/25){
					printPoint((Graphics2D)g, Color.YELLOW, point);
				}
				else {
					printPoint((Graphics2D)g, Color.BLUE, point);
				}

			}
		}

    }

    public static void main(String [] args) { 

	JFrame frame = new JFrame("Serpenski's Triangle");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	int setNum = 0;
	double r_min = -1;
	double r_max = 1;
	double i_min = -1;
	double i_max = 1;
	int iterations = 100;

	double real = -0.4 , imag = 0.6;

	try{
		if(args[0].compareToIgnoreCase("mandelbrot") == 0){
			setNum = 1;
			if(args.length == 5){
				r_min = Double.parseDouble(args[1]);
				r_max = Double.parseDouble(args[2]);
				i_min = Double.parseDouble(args[3]);
				i_max = Double.parseDouble(args[4]);
			}
			else if(args.length == 6){
				r_min = Double.parseDouble(args[1]);
				r_max = Double.parseDouble(args[2]);
				i_min = Double.parseDouble(args[3]);
				i_max = Double.parseDouble(args[4]);
				iterations = Integer.parseInt(args[5]);
			}
			else if(args.length != 1){
				throw new Exception();

			}
		}
		else if(args[0].compareToIgnoreCase("julia") == 0){
			setNum = 2;
			if(args.length == 3){
				real = Double.parseDouble(args[1]);
				imag = Double.parseDouble(args[2]);

			}
			else if(args.length == 4){
				real = Double.parseDouble(args[1]);
				imag = Double.parseDouble(args[2]);
				iterations = Integer.parseInt(args[3]);

			}
			else if(args.length != 1){
				throw new Exception();
			}
		}
		else {
			throw new Exception();
		}
	}

	catch (Exception e){
		System.out.println("Usage : \n\tMandelbrot");
		System.out.println("\tMandelbrot Minimum Real Value | Maximum Real Value | Minimum Imaginary Value | Maximum Imaginary Value");
		System.out.println("\tMandelbrot Minimum Real Value | Maximum Real Value | Minimum Imaginary Value | Maximum Imaginary Value | Iterations\n");

		System.out.println("\tJulia");
		System.out.println("\tJulia Real Value | Imaginary Value");
		System.out.println("\tJulia Real Value | Imaginary Value | Iterations");


		System.exit(0);
	}


	if(setNum == 1){
		frame.setContentPane(new Fractal(setNum, 800, 800, r_min, r_max, i_min, i_max, iterations));
	}
	else {
		frame.setContentPane(new Fractal(setNum, 800, 800, real, imag, iterations));
	}


	frame.pack(); 
	frame.setLocationRelativeTo(null); 
	frame.setVisible(true); 
    }
}