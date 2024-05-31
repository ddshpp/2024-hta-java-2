package day4.Test2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class SearchEmpUI extends JFrame {

    private final JPanel contentPane;
    private final JTextArea textArea;
    private final JTable table;
    private final JScrollPane scrollPane;

    public SearchEmpUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 661, 507);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(
                new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
                        new Color(160, 160, 160)),
                "\uC0AC\uC6D0\uC815\uBCF4 \uAC80\uC0C9\uD558\uAE30", TitledBorder.LEADING,
                TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(6, 10, 633, 57);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("\uC0AC\uC6D0\uC774\uB984");
        lblNewLabel.setBounds(6, 22, 57, 15);
        panel.add(lblNewLabel);

        textArea = new JTextArea();
        textArea.setBounds(63, 17, 455, 24);
        panel.add(textArea);

        JButton btnNewButton = new JButton("\uAC80\uC0C9");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String strEname = textArea.getText();
                if (table != null) {
                    if (strEname.length() < 2) {
                        JOptionPane.showMessageDialog(SearchEmpUI.this, "2자 이상 입력해주세요", "경고",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        try {
                            table.setModel(new EmpTableModel(strEname));
                        } catch (ClassNotFoundException | SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
        btnNewButton.setBounds(530, 18, 97, 23);
        panel.add(btnNewButton);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 78, 621, 380);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchEmpUI frame = new SearchEmpUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}