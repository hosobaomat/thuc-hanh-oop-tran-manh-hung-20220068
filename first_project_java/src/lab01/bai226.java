package lab01;
import javax.swing.JOptionPane;
public class bai226 {
    public static void main(String[] args){
        String strNum1, strNum2;
        strNum1 = JOptionPane.showInputDialog(null,"nhap he so cua x: ", "phuong trinh bac nhat 1 bien",JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null,"nhap he so tu do: ", "phuong trinh bac nhat 1 bien",JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        String x;
        if(num1!=0){
              x=String.valueOf(-num2/num1);
        }
        else{
            if(num2==0){
                x="phuong trinh co vo so nghiem";
            }
            else{
                x="phuong trinh vo nghiem";
            }
        }
        JOptionPane.showMessageDialog(null, x);
        String strNum3, strNum4, strNum5,strNum6,strNum7,strNum8;
        strNum3 = JOptionPane.showInputDialog(null,"nhap a11 ", "he phuong trinh bac nhat 2 bien",JOptionPane.INFORMATION_MESSAGE);
        strNum4 = JOptionPane.showInputDialog(null,"nhap a12 ", "he phuong trinh bac nhat 2 bien",JOptionPane.INFORMATION_MESSAGE);
        strNum5 = JOptionPane.showInputDialog(null,"nhap b1 ", "he phuong trinh bac nhat 2 bien",JOptionPane.INFORMATION_MESSAGE);
        strNum6 = JOptionPane.showInputDialog(null,"nhap a21 ", "he phuong trinh bac nhat 2 bien",JOptionPane.INFORMATION_MESSAGE);
        strNum7 = JOptionPane.showInputDialog(null,"nhap a22 ", "he phuong trinh bac nhat 2 bien",JOptionPane.INFORMATION_MESSAGE);
        strNum8 = JOptionPane.showInputDialog(null,"nhap b2 ", "he phuong trinh bac nhat 2 bien",JOptionPane.INFORMATION_MESSAGE);
        double num3 = Double.parseDouble(strNum3);
        double num4 = Double.parseDouble(strNum4);
        double num5 = Double.parseDouble(strNum5);
        double num6 = Double.parseDouble(strNum6);
        double num7 = Double.parseDouble(strNum7);
        double num8 = Double.parseDouble(strNum8);
        double D,D1,D2;

        D=num3*num7-num6*num4;
        D1=num5*num7-num8*num4;
        D2=num3*num8-num6*num5;
        if(D!=0){
           double x1=D1/D;
           double x2=D2/D;
           JOptionPane.showMessageDialog(null, "nghiem duy nhat la x1 "+x1+"\nx2 "+x2);
        }
        else{
            if(D1==0&&D2==0){
                JOptionPane.showMessageDialog(null, "Phuong trinh co vo so nghiem");
            }
            else{
                JOptionPane.showMessageDialog(null, "Phuong trinh vo nghiem");
            }
        }
        strNum1="";
        strNum2="";
        strNum3="";
        strNum1 = JOptionPane.showInputDialog(null,"nhap he so cua x^2: ", "phuong trinh bac 2 1 bien",JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null,"nhap he so cua x: ", "phuong trinh bac 2 1 bien",JOptionPane.INFORMATION_MESSAGE);
        strNum3 = JOptionPane.showInputDialog(null,"nhap he so tu do: ", "phuong trinh bac 2 1 bien",JOptionPane.INFORMATION_MESSAGE);
        num1=Double.parseDouble(strNum1);
        num2=Double.parseDouble(strNum2);
        num3=Double.parseDouble(strNum3);
        double delta;
        if(num1!=0){
            delta=num2*num2-4*num1*num3;
            if(delta>0){
                double x1=(-num2 + Math.sqrt(delta))/(2*num1);
                double x2=(-num2 - Math.sqrt(delta))/(2*num1);
                JOptionPane.showMessageDialog(null, "phuong trinh co 2 nghiem: "+"\n"+"x1: "+x1+"\n"+"x2: "+x2);
            }
            else if(delta==0){
                double x3=(-num2)/(2*num1);
                JOptionPane.showMessageDialog(null, "phuong trinh co nghiem kep x: "+x3);
            }
            else{
                JOptionPane.showMessageDialog(null, "phuong trinh vo nghiem");
            }
        }
        else{
            if(num2!=0){
                double x4=-num3/num2;
                JOptionPane.showMessageDialog(null, "phuong trinh co 1 nghiem x:"+x4);
            }
            else{
                if(num3==0){
                    JOptionPane.showMessageDialog(null, "phuong tirnh co vo so nghiem");
                }
                else{
                    JOptionPane.showMessageDialog(null, "phuong trinh vo nghiem");
                }
            }
        }
}
}
