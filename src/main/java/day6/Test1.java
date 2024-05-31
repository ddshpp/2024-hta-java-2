package day6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Test1 extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel jp1;
    private JPanel jp2;
    private JPanel jp3;

    public Test1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("tt111");
        setBounds(100, 100, 450, 300);
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        jp1 = new JPanel();
        jp1.setLayout(null);
        jp2 = new JPanel();
        jp2.setLayout(null);
        jp1.add(jp2);
        jp3 = new JPanel();
        jp3.setLayout(null);

        jp1.add(jp3);
        jp3.add(buttonOK);
        jp3.add(buttonCancel);

        buttonOK = new JButton("OK");
        buttonCancel = new JButton("Cancel");

        buttonOK.setMnemonic(KeyEvent.VK_O);


        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
                                               public void actionPerformed(ActionEvent e) {
                                                   onCancel();
                                               }
                                           }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
