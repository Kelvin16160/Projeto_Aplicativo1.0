package Login.userUI;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import userDAO.UserDAO;
import userDTO.UserDTO;
import static javax.swing.SwingUtilities.invokeLater;

class LoginUI {
	/**
	 * @wbp.parser.entryPoint
	 */
	public static JFrame frmUsuario;
	public static JTextField txtLogin;
	public static JTextField txtSenha;

	public static void main(String[] args) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					try {
						UIManager.setLookAndFeel(info.getClassName());
					} catch (ClassNotFoundException | InstantiationException | IllegalAccessException errolook) {
						errolook.printStackTrace();
					}
				}
			}
		} catch (UnsupportedLookAndFeelException errolook) {
			JOptionPane.showMessageDialog(null, errolook);
		}

		invokeLater(new Runnable() {
			public void run() {
				try {
					new LoginUI();
					LoginUI.frmUsuario.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao Montar Mostrar a Janela Pelo Metodo Invoke \n" + e);
				}
			};
		});
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public LoginUI() {
		initialize();
	}

	public void initialize() {
		frmUsuario = new JFrame("Aplication");
		frmUsuario.setResizable(false);

		frmUsuario.setFocusCycleRoot(false);
		frmUsuario.setFocusTraversalKeysEnabled(false);
		frmUsuario.setAutoRequestFocus(false);
		frmUsuario.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frmUsuario
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\K3lvin\\Pictures\\Sem título (2).png"));
		frmUsuario.getContentPane().setBackground(new Color(125, 128, 128));
		frmUsuario.setBounds(100, 100, 410, 176);
		frmUsuario.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(13, 11, 31, 16);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmUsuario.getContentPane().add(lblNewLabel);

		txtLogin = new JTextField();
		txtLogin.setBounds(52, 5, 125, 28);
		frmUsuario.getContentPane().add(txtLogin);
		txtLogin.setColumns(5);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(189, 9, 36, 21);
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		frmUsuario.getContentPane().add(lblSenha);

		txtSenha = new JTextField();
		txtSenha.setBounds(237, 5, 125, 28);
		txtSenha.setColumns(5);
		frmUsuario.getContentPane().add(txtSenha);

		JButton btnLogar = new JButton("Logar");
		btnLogar.setBounds(94, 54, 63, 28);
		frmUsuario.getContentPane().add(btnLogar);

		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.setBounds(209, 54, 79, 28);
		frmUsuario.getContentPane().add(btnCadastro);
		btnCadastro.setSelectedIcon(
				new ImageIcon("E:/workspace/K3lvin/k3lvinapp/src/Login/Login/Captura de tela 2023-06-17 210443.png"));
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Tela_Cadastro();
			}
		});
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					UserDTO User = new UserDTO();
					User.setUsuario(txtLogin.getText());
					User.setSenha(txtSenha.getText());
					UserDAO user = new UserDAO();
					ResultSet rsResultSet = user.authentication01(User);
					if (rsResultSet.next()) {
						JOptionPane.showMessageDialog(null, "Bem vindo!");
						txtLogin.setText(null);
						txtSenha.setText(null);
						frmUsuario.setVisible(false);
						new App();

					} else {
						txtLogin.setText(null);
						txtSenha.setText(null);
						JOptionPane.showMessageDialog(null, "Dados invalidos");
					}
				} catch (SQLException error) {
					JOptionPane.showMessageDialog(null, error);
				}
			}
		});
	}
}