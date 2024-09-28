package lab01;

import java.util.Scanner;

public class bai64 {
    public static boolean checkyear(int year){
        if(year%4==0){
            if(year%100==0){
                if(year%400==0){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }
    }
    public static int checkmonth(String month,int year){
        switch (month) {
            case "Jan.":
            case "January":
            case "1":
            case "Jan":
            return 31;
            case "February":
            case "Feb.":
            case "Feb":
            case "2":
            return checkyear(year)?29:28;
            case "3":
            case "March":
            case "Mar.":
            case "Mar":
            return 31;
            case "April":
            case "Apr":
            case "Apr.":
            case "4":
            return 30;
            case "May":
            case "5":
            return 31;
            case "Jun":
            case "6":
            return 30;
            case "July":
            case "7":
            return 31;
            case "August":
            case "Aug.":
            case "Aug":
            case "8":
            return 31; 
            case "September":
            case "Sept.":
            case "Sept":
            case "9":
            return 30; 
            case "October":
            case "Oct.":
            case "OCt":
            case "10":
            return 31; 
            case "November":
            case "Nov.":
            case "Nov":
            case "11":
            return 30;
            case "December":
            case "Dec.":
            case "Dec":
            case "12":
            return 31;  
            default:
                return -1;//neu thang nhap vao ko hop le
        }
    }
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        String month;
        int year;
        while(true){
            System.out.println("nhap thang va nam");
            month=s.nextLine();
            year=s.nextInt();
            s.nextLine();//xoa bo dem
            if(year<0){
                System.out.println("nam nho hon 0 yeu cau nhap lai");
                continue;
            }
            int k=checkmonth(month, year);
            if(k==-1){
                System.out.println("thang nhap khong hop le nhap lai");
                continue;
            }
            else{
            System.out.println(k);
        }
        System.out.println("ban co muon nhap tiep ko (y/n)");
            String s1=s.nextLine();
            if(s1.equals("y")){
                continue;
            }
            else{
                break;
            }
        }
        s.close();
    }
}
