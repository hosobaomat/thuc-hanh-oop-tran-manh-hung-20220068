package lab01;
import javax.swing.JOptionPane;

public class bai61 {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null,"Do you want to change to the first class ticket?");

        JOptionPane.showMessageDialog(null, "You've chosen: "+ (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
        option = JOptionPane.showConfirmDialog(null, "ban muon tiep tuc", "chon 1 option", JOptionPane.YES_NO_OPTION);
        if(option== JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null,"ban chon yes");
        }
        else{
            JOptionPane.showMessageDialog(null,"ban chon no");
        }
        System.exit(0);
    }
}
// What happens if users choose “Cancel”?
// hop thoai se chuyen sang option no do chi co case YES_OPTION neu khong phai yes thi mac dinh la no
// How to customize the options to users, e.g. only two options: “Yes” and “No”, OR “I do” and “I don’t”

