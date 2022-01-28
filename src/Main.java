import javax.imageio.ImageIO;
import java.io.File;

public class Main {
    private static synchronized void save() {
        try {
            ImageIO.write(Mandelbrot.getImg(), "png", new File("a.bmp"));

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public static void main(String[] args) {
        Mandelbrot[] mandel = new Mandelbrot[4];
        for (int x = 0; x < mandel.length; x++) {
            mandel[x] = new Mandelbrot(x);
            mandel[x].run();
        }
        save();
    }
}
