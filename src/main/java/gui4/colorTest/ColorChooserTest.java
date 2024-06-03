package gui4.colorTest;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ColorChooserTest extends JFrame {

    static JColorChooser colorChooser = new JColorChooser();
    private final JPanel contentPane;

    public ColorChooserTest() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 200, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(50, 50, 50, 50));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("버튼입니다!");

        btnNewButton.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Color color = colorChooser.getColor();
                        JDialog dialog = JColorChooser.createDialog(null, "색상선택기!!!", true,
                                colorChooser, null, null);
                        dialog.setVisible(true);
                    }
                }
        );

        btnNewButton.setBounds(10, 10, 50, 50);
        contentPane.add(btnNewButton);
    }
}