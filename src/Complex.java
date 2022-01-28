public class Complex {
    private double re;
    private double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public Complex() {
    }

    public void addition(Complex complex) {
        this.re += complex.getRe();
        this.im += complex.getIm();
    }

    public double mod() {
        return Math.sqrt(Math.pow(this.re, 2) + Math.pow(this.im, 2));
    }

    public void complexPow2() {
        double tempRe, tempIm;
        tempRe = this.re;
        tempIm = this.im;
        this.re = Math.pow(tempRe, 2) - Math.pow(tempIm, 2);
        this.im = 2 * tempIm * tempRe;

    }

    public double getRe() {
        return re;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }
}
