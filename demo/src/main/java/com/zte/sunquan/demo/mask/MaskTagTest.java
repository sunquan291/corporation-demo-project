package com.zte.sunquan.demo.mask;

/**
 * Created by 10184538 on 2017/3/6.
 */
public class MaskTagTest {

    private int sendPlace = 0;

    private static int go1 = 1;
    private static int go2 = 1 << 1;
    private static int go3 = 1 << 2;
    private static int go4 = 1 << 3;
    private static int go5 = 1 << 4;
    private static int go6 = 1 << 5;
    private static int go7 = 1 << 6;
    private static int go8 = 1 << 7;
    private static int go9 = 1 << 8;
    private static int go10 = 1 << 9;
    private static int go11 = 1 << 10;
    private static int go12 = 1 << 11;
    private static int go13 = 1 << 12;
    private static int go14 = 1 << 13;
    private static int go15 = 1 << 14;
    private static int go16 = 1 << 15;
    private static int go17 = 1 << 16;
    private static int go18 = 1 << 17;
    private static int go19 = 1 << 18;
    private static int go20 = 1 << 19;
    private static int go21 = 1 << 20;
    private static int go22 = 1 << 21;
    private static int go23 = 1 << 22;
    private static int go24 = 1 << 23;
    private static int go25 = 1 << 24;
    private static int go26 = 1 << 25;
    private static int go27 = 1 << 26;
    private static int go28 = 1 << 27;


    public void addPlace(int place) {
        this.sendPlace = this.sendPlace | place;
    }

    public void addPlace(int... place) {
        for (int p : place)
            this.sendPlace = this.sendPlace | p;
    }

    public void removePlace(int place) {
        this.sendPlace = this.sendPlace & ~place;
    }

    public void print() {
        if ((sendPlace & go1) != 0) {
        }
        if ((sendPlace & go1) != 0) {
        }
        if ((sendPlace & go2) != 0) {
        }
        if ((sendPlace & go3) != 0) {
        }
        if ((sendPlace & go4) != 0) {
        }
        if ((sendPlace & go5) != 0) {
        }
        if ((sendPlace & go6) != 0) {
        }
        if ((sendPlace & go7) != 0) {
        }
        if ((sendPlace & go8) != 0) {
        }
        if ((sendPlace & go9) != 0) {
        }
        if ((sendPlace & go10) != 0) {
        }
        if ((sendPlace & go12) != 0) {
        }
        if ((sendPlace & go13) != 0) {
        }
        if ((sendPlace & go14) != 0) {
        }
        if ((sendPlace & go15) != 0) {
        }
        if ((sendPlace & go16) != 0) {
        }
        if ((sendPlace & go17) != 0) {
        }
        if ((sendPlace & go18) != 0) {
        }
        if ((sendPlace & go19) != 0) {
        }
        if ((sendPlace & go20) != 0) {
        }
        if ((sendPlace & go21) != 0) {
        }
        if ((sendPlace & go22) != 0) {
        }
        if ((sendPlace & go23) != 0) {
        }
        if ((sendPlace & go24) != 0) {
        }
        if ((sendPlace & go25) != 0) {
        }
        if ((sendPlace & go26) != 0) {
        }
        if ((sendPlace & go27) != 0) {
        }
        if ((sendPlace & go28) != 0) {
        }
    }

    public static void main(String[] args) {
        MaskTagTest maskTest = new MaskTagTest();
        maskTest.addPlace(go1, go2, go3, go4, go5, go6, go7, go8, go9, go10, go11, go12, go13, go14, go15, go16,
                go17, go18, go19, go20, go21, go22, go23, go24, go25, go26, go27, go28);

        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1000; i ++)
            maskTest.print();
        System.out.println(System.currentTimeMillis() - begin);

    }
}
