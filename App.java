package Login.userUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import static javax.swing.SwingUtilities.invokeLater;

public class App {

	private JFrame frame;
	private JTextField txtValor1;
	private JTextField txtValor2;
	private JTextField Result;

	/**
	 * Launch the application.
	 */
	void AppInit() {

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, "Erro ao Executar a Janela" + error);

		}

		invokeLater(new Runnable() {
			public void run() {
				try {
					new App();
				} catch (Exception error) {
					error.printStackTrace();

					JOptionPane.showMessageDialog(null, "Erro ao Executar a Janela" + error);

				}
			}
		});
	}

	public App() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("Aplication 1.0");
		frame.getContentPane().setFocusable(true);
		frame.getContentPane().setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		frame.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frame.setVisible(true);
		frame.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\K3lvin\\Pictures\\Sem título (2).png"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 413, 332);
		frame.getContentPane().setLayout(null);

		// Textos de identificao

		JLabel lblEscrevaOSegundo = new JLabel("Escreva o Segundo Valor");
		lblEscrevaOSegundo.setFont(new Font("Comic Sans MS", lblEscrevaOSegundo.getFont().getStyle(),
				lblEscrevaOSegundo.getFont().getSize()));
		lblEscrevaOSegundo.setBounds(10, 140, 249, 15);
		frame.getContentPane().add(lblEscrevaOSegundo);

		JLabel lblNewLabel = new JLabel("Escreva o Primeiro Valor");
		lblNewLabel
				.setFont(new Font("Comic Sans MS", lblNewLabel.getFont().getStyle(), lblNewLabel.getFont().getSize()));
		lblNewLabel.setBounds(10, 11, 249, 15);
		frame.getContentPane().add(lblNewLabel);

		txtValor2 = new JTextField();
		txtValor2.setBounds(10, 163, 132, 25);
		frame.getContentPane().add(txtValor2);
		txtValor2.setColumns(10);
		txtValor1 = new JTextField();
		txtValor1.setBounds(10, 34, 132, 25);
		frame.getContentPane().add(txtValor1);
		txtValor1.setColumns(10);

		Result = new JTextField();
		Result.setBounds(241, 100, 150, 28);
		frame.getContentPane().add(Result);
		Result.setColumns(10);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setMaximumRowCount(10);
		comboBox.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 11));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "+", "-", "/", "*" }));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(117, 94, 47, 33);
		frame.getContentPane().add(comboBox);

		JButton btnNewButton = new JButton("Calcular");
		btnNewButton
				.setSelectedIcon(new ImageIcon("C:\\Users\\K3lvin\\Pictures\\Captura de tela 2023-06-17 210442.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("+")) {
					int number1 = Integer.parseInt(txtValor1.getText());
					int number2 = Integer.parseInt(txtValor2.getText());
					int Resp = number1 + number2;
					toString();
					String Result = String.valueOf(Resp);
					App.this.Result.setText(Result);
					

					//JOptionPane.showMessageDialog(null, "Resultado\n" + Result);

				} else if (comboBox.getSelectedItem().equals("-")) {
					int number1 = Integer.parseInt(txtValor1.getText());
					int number2 = Integer.parseInt(txtValor2.getText());
					int Resp = number1 - number2;
					toString();
					String Result = String.valueOf(Resp);
					App.this.Result.setText(Result);

					//JOptionPane.showMessageDialog(null, "Resultado\n" + Result);

				} else if (comboBox.getSelectedItem().equals("/")) {
					int number1 = Integer.parseInt(txtValor1.getText());
					int number2 = Integer.parseInt(txtValor2.getText());
					int Resp = number1 / number2;
					toString();
					String Result = String.valueOf(Resp);
					App.this.Result.setText(Result);
					//JOptionPane.showMessageDialog(null, "Resultado\n" + Result);

				} else if (comboBox.getSelectedItem().equals("*")) {
					int number1 = Integer.parseInt(txtValor1.getText());
					int number2 = Integer.parseInt(txtValor2.getText());
					int Resp = number1 * number2;
					toString();
					String Result = String.valueOf(Resp);
					App.this.Result.setText(Result);
					//JOptionPane.showMessageDialog(null, "Resultado\n" + Result);

				}
			}
		});
		btnNewButton.setBounds(56, 200, 164, 31);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Selecione o Operador.");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 73, 249, 22);
		frame.getContentPane().add(lblNewLabel_1);

	}
}
