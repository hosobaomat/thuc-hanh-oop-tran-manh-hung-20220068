package lab01;
import javax.swing.JOptionPane;

public class bai225 {
    public static void main(String[] args){
        String strNum1, strNum2;
        strNum1 = JOptionPane.showInputDialog(null,
            "Please input the first number: ", "Input the first number",
            JOptionPane.INFORMATION_MESSAGE);

        strNum2 = JOptionPane.showInputDialog(null,
            "Please input the second number: ", "Input the second number",
            JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double sum=num1+num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        String quotient;
        if(num2!=0){
            quotient=String.valueOf(num1/num2); 
        }
        else{
            quotient="khong chia dc cho 0";
        }
        String result= "result: "+"sum: "+sum+"\n"+
        "difference"+difference+"\n"+
        "product: "+product+"\n"+
        "quotient: "+quotient;
        JOptionPane.showMessageDialog(null, result,
            "Calculation", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
