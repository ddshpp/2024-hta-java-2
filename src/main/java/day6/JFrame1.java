package day6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class JFrame1 extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel jp1;
    private JPanel jp2;
    private JPanel jp3;

    public JFrame1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("tt111");
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setLayout(null);

        jp1 = new JPanel();
        contentPane.add(jp1);

        jp2 = new JPanel();
        contentPane.add(jp2);

        jp3 = new JPanel();
        jp1.add(jp3);

        buttonOK = new JButton("OK");
        buttonOK.setBounds(20, 20, 20, 20);
        jp3.add(buttonOK);

        buttonCancel = new JButton("Cancel");
        buttonCancel.setBounds(40, 20, 20, 20);
        jp3.add(buttonCancel);

        buttonOK.setMnemonic(KeyEvent.VK_O);

//        setModal(true);
//        getRootPane().setDefaultButton(buttonOK);

        /**
         1. DB 구조잡고 맥미니,맥북 동기화
         2. 기본적인 클래스 생성
         3.


         */

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
        setContentPane(jp1);
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
