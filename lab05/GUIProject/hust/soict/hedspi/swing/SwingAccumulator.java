package lab05.GUIProject.hust.soict.hedspi.swing;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;  // Ô nhập số nguyên
    private JTextField tfOutput; // Ô hiển thị tổng
    private int sum = 0;         // Tổng cộng dồn

    public SwingAccumulator() {
        // Lấy Content Pane và đặt Layout
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2)); // Lưới 2x2

        // Thêm nhãn và ô nhập
        cp.add(new JLabel("Enter an Integer:")); // Nhãn cho ô nhập
        tfInput = new JTextField(10); // Ô nhập số nguyên
        cp.add(tfInput);

        // Thêm nhãn và ô hiển thị tổng
        cp.add(new JLabel("The Accumulated Sum is:")); // Nhãn cho ô hiển thị tổng
        tfOutput = new JTextField(10); // Ô hiển thị tổng
        tfOutput.setEditable(false); // Không cho phép chỉnh sửa
        cp.add(tfOutput);

        // Gắn sự kiện cho ô nhập
        tfInput.addActionListener(new TFInputListener());

        // Cài đặt thuộc tính cửa sổ
        setTitle("Swing Accumulator");
        setSize(350, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Đóng cửa sổ khi nhấn X
        setVisible(true);
    }

    public static void main(String[] args) {
        // Chạy chương trình
        new SwingAccumulator();
    }

    // Lớp xử lý sự kiện cho ô nhập
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                // Lấy số nguyên từ ô nhập và cộng vào tổng
                int numberIn = Integer.parseInt(tfInput.getText());
                sum += numberIn;

                // Xóa ô nhập và cập nhật ô hiển thị tổng
                tfInput.setText("");
                tfOutput.setText(sum + "");
            } catch (NumberFormatException e) {
                // Hiển thị thông báo lỗi nếu nhập không hợp lệ
                tfInput.setText("");
                tfOutput.setText("Invalid input!");
            }
        }
    }
}
