package com.ants.leetcode.middle;


import static com.sun.jmx.snmp.ThreadContext.contains;

/**
 * @author ants_
 */
public class FractionalAdditionAndSubtraction {

    public static void main(String[] args) {
        FractionalAdditionAndSubtraction test = new FractionalAdditionAndSubtraction();
        String s = test.fractionAddition("1/3-5/4+3/10");
        System.out.println(s);
    }

    public Long aa, bb;

    public String fractionAddition(String expression) {

        double re = 0.0d;
        if (expression == null || expression.trim().length() <= 0) {
            return "0";
        }
        aa = 0L;
        bb = 1L;
        if (expression.startsWith("-")) {
            expression = "0" + expression;
        }
        String[] split = expression.split("[+]");
        for (int i = 0; i < split.length; i++) {
            String temp = split[i];
            if (temp.contains("-")) {
                String[] splitSub = temp.split("-");
                for (int j = 0; j < splitSub.length; j++) {
                    if (splitSub[j].contains("/")) {

                        String[] splitTemp = splitSub[j].split("/");
                        if (j==0){
                            aa = aa * Long.parseLong(splitTemp[1]) + Long.parseLong(splitTemp[0]) * bb;
                            bb = bb * Long.parseLong(splitTemp[1]);
                        }
                        else {
                            aa = aa * Long.parseLong(splitTemp[1]) + Long.parseLong(splitTemp[0]) * bb*-1;
                            bb = bb * Long.parseLong(splitTemp[1]);
                        }


                    }
                }
            } else {

                if (temp.contains("/")) {
                    String[] splitTemp = temp.split("/");
                    aa = aa * Long.parseLong(splitTemp[1]) + Long.parseLong(splitTemp[0]) * bb;
                    bb = bb * Long.parseLong(splitTemp[1]);

                }

            }

        }
        return new Fraction(aa, bb).toString();
    }


    class Fraction {
        public long a, b;

        public Fraction(long a, long b) {
            this.a = a;
            this.b = b;
            if (b == 0) {
                return;
            }
            Appointment();
        }

        private void Appointment() {
            if (a == 0 || b == 1)
                return;
            long gcd = gcd(a, b);

            this.a /= gcd;
            this.b /= gcd;
            if (gcd<0){
                this.a*=-1;
                this.b*=-1;
            }
        }

        private long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);

        }

        @Override
        public String toString() {
            if (a == 0) {
                b = 1;
            }
            return Long.toString(a) + "/" + Long.toString(b);
        }
    }


}
