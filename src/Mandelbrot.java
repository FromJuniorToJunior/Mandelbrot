import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Mandelbrot extends Thread {
    private static BufferedImage img;
    private Mandelbrot.Square square;

    static {
        try {
            img = ImageIO.read(new File("a.bmp"));
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }

    class Square {
        int x0, x1, y0, y1;

        public Square(int rank) {
            switch (rank) {
                case 0 -> {
                    this.x0 = 0;
                    this.x1 = 1500;
                    this.y0 = 0;
                    this.y1 = 1500;
                }
                case 1 -> {
                    this.x0 = 1500;
                    this.x1 = 3000;
                    this.y0 = 0;
                    this.y1 = 1500;
                }
                case 2 -> {
                    this.x0 = 0;
                    this.x1 = 1500;
                    this.y0 = 1500;
                    this.y1 = 3000;
                }
                case 3 -> {
                    this.x0 = 1500;
                    this.x1 = 3000;
                    this.y0 = 1500;
                    this.y1 = 3000;
                }
            }
        }
    }

    public Mandelbrot(int rank) {
        this.square = new Square(rank);
    }

    public void compute(double X0, double Y0, double X1, double Y1, int ITER) {
        double dy = (Y1 - Y0) / 3000;
        double dx = (X1 - X0) / 3000;
        Complex p = new Complex();
        for (int x = this.square.x0; x < this.square.x1; x++) {
            p.setRe(x * dx + X0);
            for (int y = this.square.y0; y < this.square.y1; y++) {
                p.setIm(y * dy + Y0);
                Complex c0 = new Complex(0, 0);
                int iteration = 0;
                while (iteration < ITER && c0.mod() < 2) {
                    iteration += 1;
                    c0.complexPow2();
                    c0.addition(p);
                }


                if (iteration > 100) {
                    img.setRGB(x, y, new Color(255, 255, 0).getRGB());
                } else {
                    img.setRGB(x, y, new Color(190, 60, 147).getRGB());
                }
            }
        }
    }

    public static BufferedImage getImg() {
        return img;
    }

    @Override
    public void run() {
        compute(-2, -1.25, 0.5, 1.25, 256);
    }
}
