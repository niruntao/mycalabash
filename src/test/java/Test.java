import java.util.Scanner;
public class Test {
    private static void PI()
    {
        System.out.print("π=");
        double pi = 0;
        double numberator = 4;
        double denominator = 1;
        for(int i=0;i<100000000;i++)
        {
            pi+=(numberator/denominator);
            numberator *= -1.0;
            denominator += 2.0;
        }
        System.out.print(pi);
        System.out.print("\n");
    }

    private static void Rhombus()
    {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        if(size%2==0)
            System.out.print("Please input a odd number\n");
        for(int i=1;i<=(size+1)/2;i++)
        {
            for(int j=(size+1-2*i)/2;j>=1;j--)
            {
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++)
            {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        for(int i=1;i<=size/2;i++)
        {
            for(int j=i;j>=1;j--)
            {
                System.out.print(" ");
            }
            for(int j=size-2;j>=2*i-1;j--)
            {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    private static void DafodilNumber()
    {
        System.out.print("DafodilNumber:");
        for(int i=100;i<1000;i++)
        {
            int a=i/100;
            int b=(i-100*a)/10;
            int c=i-100*a-10*b;
            if(i==a*a*a+b*b*b+c*c*c)
                System.out.print(i+" ");
        }
    }
    @org.junit.Test
    public void test()
    {
        PI();
        Rhombus();
        DafodilNumber();
    }
}
