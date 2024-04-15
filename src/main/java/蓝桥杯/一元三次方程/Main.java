package 蓝桥杯.一元三次方程;

public class Main {
    public static void main(String[] args) {
        System.out.println(solve3Polynomial(1, -5, -4, 20));

    }
    public static double solve3Polynomial(double a, double b, double c, double d)
    {
        double x1 = 0.0, x2 = 0.0, x3 = 0.0;
        double A = 0.0, B = 0.0 , C =0.0 , DET = 0.0;

        // 1. 计算重根判别式
        A = b*b - 3*a*c;
        if(Math.abs(A) < 1e-14)
        {
            A = 0.0;
        }

        B = b*c - 9*a*d;
        if(Math.abs(B) < 1e-14)
        {
            B = 0.0;
        }

        C = c*c - 3*b*d;
        if(Math.abs(C) < 1e-14)
        {
            C = 0.0;
        }

        // 2. 计算总判别式
        DET = B*B - 4*A*C;
        if(Math.abs(DET) < 1e-14)
        {
            DET = 0;
        }

        // 3. 条件一，计算根
        if((A == 0) && (B == 0))
        {
            x1 = (-1*c)/b;
            x2 = x1;
            x3 = x1;
            //Log.i("roots", "条件一:" + x1 );
        }

        // 4. 条件二，计算根
        if(DET > 0)
        {
            double Y1 = A*b + 1.5*a*(-1*B + Math.sqrt(DET));
            double Y2 = A*b + 1.5*a*(-1*B - Math.sqrt(DET));
            //Log.i("SQSddd", "Y1: " + Y1 + " Y2: " + Y2);
            double y1 = getCubeRoot(Y1);
            double y2 = getCubeRoot(Y2);
            x1 = (-1.0*b-(y1+y2))/(3.0*a);				// 一个实根
            double vec1 = (-1*b + 0.5*(y1 + y2))/(3*a);
            double vec2 = 0.5*Math.sqrt(y1 - y2)/(3*a);
//    		x2 = Math.
            double x3_real = 0.0, x2_real = 0.0;		// 实部
            x2_real = (-b + getCubeRoot(Y1)) / (3 * a);
            x3_real = x2_real;
            double x2_virtual = 0.0, x3_virtual = 0.0;  // 虚部
            x2_virtual = ((Math.sqrt(3) / 2) * (y1 - y2 )) / (3 * a);
            x3_virtual = -x2_virtual;
            //Log.i("roots", "条件二:" + x1 );
        }

        // 5. 条件三，计算根
        if(DET == 0 && A != 0 && B != 0)
        {
            double K = (b*c - 9*a*d)/(b*b -3*a*c);
            K = Math.round(K);
            x1 = (-1.0*b)/a + K;
            x2 = -1*0.5*K;
            x3 = x2;
            //Log.i("roots", "条件三:" + x1 );
        }

        // 6.条件四，计算根
        if(DET < 0)
        {
            double sqA = Math.sqrt(A);
            double T = (A*b - 1.5*a*B)/(A*sqA);
            double theta = Math.acos(T);
            double csth = Math.cos(theta/3);
            double sn3th = Math.sqrt(3)*Math.sin(theta/3);
            x1 = (-1*b - 2*sqA*csth)/(3*a);
            x2 = (-1*b + sqA*(csth + sn3th))/(3*a);
            x3 = (-1*b + sqA*(csth - sn3th))/(3*a);
            //Log.i("SQSd", "条件四:" + x1 );
        }

        // 7. 返回计算结果
        return x1;
    }

    public static double getCubeRoot(double value) {
        if (value < 0) {
            return -Math.pow(-value, 1.0/3.0);
        } else if (value == 0) {
            return 0;
        } else {
            return Math.pow(value, 1.0/3.0);
        }

    }
}
