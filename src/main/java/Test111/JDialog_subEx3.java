package Test111;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JDialog_subEx3 extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private String shareData;

    public JDialog_subEx3(String shareData) {
        this();
        this.shareData = shareData;

        System.out.println("부모로부터 받은 초기 shareData : " + shareData);
    }

    public JDialog_subEx3() {
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(new FlowLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JDialog_subEx3.this.setShareData("30");
                        JDialog_subEx3.this.dispose();
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JDialog_subEx3.this.dispose();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

    public String getShareData() {
        return shareData;
    }

    public void setShareData(String shareData) {
        this.shareData = shareData;
    }

    public void printShareData() {
        System.out.println("부모로부터 받은 변경 shareData : " + this.shareData);
    }
}