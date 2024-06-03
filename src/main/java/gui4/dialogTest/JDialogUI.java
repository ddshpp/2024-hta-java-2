package gui4.dialogTest;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JDialogUI extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private final JTextField textField1;
    private final JTextField textField2;

    //
    private String outputData;

    /**
     * Create the dialog.
     */
    public JDialogUI() {
        setResizable(false);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            textField1 = new JTextField();
            textField1.setEditable(false);
            textField1.setBounds(12, 10, 410, 21);
            contentPanel.add(textField1);
            textField1.setColumns(10);
        }
        {
            textField2 = new JTextField();
            textField2.setBounds(12, 41, 410, 21);
            contentPanel.add(textField2);
            textField2.setColumns(10);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("확인");
                okButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String data = textField2.getText();
                        System.out.println(data);
                        JDialogUI.this.outputData = data;
                        JDialogUI.this.dispose();
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("취소");
                cancelButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        JDialogUI.this.dispose();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

    /**
     * Launch the application.
     */
	/*
	public static void main(String[] args) {
		try {
			JDialogUI dialog = new JDialogUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/

    public JDialogUI(String data) {
        this();
        //System.out.println( data );
        textField1.setText(data);
    }

    public String getOutputData() {
        return outputData;
    }

}
