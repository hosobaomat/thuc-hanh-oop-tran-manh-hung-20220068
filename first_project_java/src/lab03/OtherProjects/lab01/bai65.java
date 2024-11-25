package lab01;
import java.util.Scanner;
public class bai65 {
    public static int Sum(int arr[]){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }
    public static double averagevalue(int arr[]){
        double a;
        double sum=Sum(arr);
        a=(double)sum/arr.length;
        return a;
    }
    public static void bubblesort(int arr[]){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void main(String args[]){
        int n;
        Scanner s=new Scanner(System.in);
        System.out.println("nhap so phan tu: ");
        n=s.nextInt();
        s.nextLine();
        int[]arr=new int[n];
        System.out.println("nhap phan tu:");
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        int sum1=Sum(arr);
        System.out.println(sum1);
        double sum2=averagevalue(arr);
        System.out.println(sum2);
        bubblesort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        s.close();
    }
}
