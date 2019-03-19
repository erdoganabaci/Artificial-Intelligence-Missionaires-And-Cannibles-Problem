package aima.gui.demo.search;

public class MissonairesCanniblesEnvironment {

    private int M1;
    private int M2;
    private int C1;
    private int C2;
    private int B1;
    private int B2;

    public int getM1() {
        return M1;
    }

    public void setM1(int m1) {
        this.M1 = m1;
    }

    public int getM2() {
        return M2;
    }

    public void setM2(int m2) {
        this.M2 = m2;
    }

    public int getC1() {
        return C1;
    }

    public void setC1(int c1) {
        this.C1 = c1;
    }

    public int getC2() {
        return C2;
    }

    public void setC2(int c2) {
        this.C2 = c2;
    }

    public int getB1() {
        return B1;
    }

    public void setB1(int b1) {
        this.B1 = b1;
    }

    public int getB2() {
        return B2;
    }

    public void setB2(int b2) {
        this.B2 = b2;
    }

    public MissonairesCanniblesEnvironment(int m1, int m2, int c1, int c2, int b1, int b2) {
        this.M1 = m1;
        this.M2 = m2;
        this.C1 = c1;
        this.C2 = c2;
        this.B1 = b1;
        this.B2 = b2;
    }


    public MissonairesCanniblesEnvironment() {
        this.M1 = 3;
        this.M2 = 0;
        this.C1 = 3;
        this.C2 = 0;
        this.B1 = 1;
        this.B2 = 0;
    }

    public boolean isStateOk() {
        return this.M1 >= 0 && this.C1 >= 0 && this.B1 >= 0 && this.M2 >= 0 && this.C2 >= 0 && this.B2 >= 0 && this.M1 - this.C1 <= 1 && this.M2 - this.C2 <= 1;
    }

    public boolean isResultOk() {
        return this.M1 == 0 && this.C1 == 0 && this.B1 == 0 && this.M2 == 3 && this.C2 == 3 && this.B2 == 1;
    }

    protected MissonairesCanniblesEnvironment clone() {
        return new MissonairesCanniblesEnvironment(this.M1, this.M2, this.C1, this.C2, this.B1, this.B2);
    }

}
