package day4.Test2;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class JDialogEx3 extends JFrame {
    public JDialogEx3() {
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("New button");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JDialog_subEx3 dialog = new JDialog_subEx3("10");
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

                System.out.println("다이얼로그 생성");
                dialog.setModal(true);
                System.out.println("부모 -> 자식 제어권한 위임");

                dialog.setShareData("20");
                dialog.printShareData();

                dialog.setVisible(true);

                System.out.println("자식 -> 부모 제어권한 위임");
                System.out.println("자식으로부터 받은 최종 shareData : " + dialog.getShareData());
            }
        });
        btnNewButton.setBounds(12, 10, 97, 23);
        getContentPane().add(btnNewButton);

    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JDialogEx3 frame = new JDialogEx3();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}