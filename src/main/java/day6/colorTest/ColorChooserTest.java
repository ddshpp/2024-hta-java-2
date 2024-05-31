package day6.colorTest;

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
    private JPanel contentPane;

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
                        JDialog dialog = JColorChooser.createDialog(null, "테스트입니다", true,
                                colorChooser, null, null);
                        dialog.setVisible(true);

                        if (color != null) {
                            System.out.println(color.getRed());
                            System.out.println(color.getGreen());
                            System.out.println(color.getBlue());
                        }
                        System.out.println(color);
                    }
                }
        );

        btnNewButton.setBounds(10, 10, 50, 50);
        contentPane.add(btnNewButton);
    }
}