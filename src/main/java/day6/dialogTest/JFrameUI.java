package day6.dialogTest;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class JFrameUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameUI frame = new JFrameUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn = new JButton("창열기");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// JFrame -> 데이터 -> JDialog 생성자 / setter / static
				// JDialog 멤버필드 / getter -> 데이터 -> JFrame
				
				String data = textField1.getText();
				
				//JDialogUI dialog = new JDialogUI();
				JDialogUI dialog = new JDialogUI( data );
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setModal(true);
				dialog.setVisible(true);
				// 잠시 Frame 동작을 멈춤
				
				//textField2.setText( dialog.outputData );
				textField2.setText( dialog.getOutputData() );
			}
		});
		btn.setBounds(12, 41, 560, 23);
		contentPane.add(btn);
		
		textField1 = new JTextField();
		textField1.setBounds(12, 10, 560, 21);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setEditable(false);
		textField2.setBounds(12, 74, 560, 21);
		contentPane.add(textField2);
		textField2.setColumns(10);
	}
}
