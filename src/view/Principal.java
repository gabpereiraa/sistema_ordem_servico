package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.border.BevelBorder;

@SuppressWarnings("unused")
public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblData;
	public JButton btnUsuarios;

	public JLabel lblUsuario;
	public JButton btnRelatorios;
	public JPanel panelRodape;
	public JButton btnTecnicos;
	public JButton btnFornecedores;
	public JButton btnEstoque;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/ar condicionado 2.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				setarData();
			}
		});
		setResizable(false);
		setTitle("Marvi Cold - Tela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		JButton btnSobre = new JButton("");
		btnSobre.setToolTipText("Sobre");
		btnSobre.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setBounds(619, 10, 48, 48);
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		btnSobre.setContentAreaFilled(false);
		btnSobre.setIcon(new ImageIcon(Principal.class.getResource("/img/about.png")));
		contentPane.add(btnSobre);
		panelRodape = new JPanel();
		panelRodape.setBounds(0, 401, 677, 40);
		panelRodape.setBackground(SystemColor.windowBorder);
		contentPane.add(panelRodape);
		panelRodape.setLayout(null);
		lblData = new JLabel("");
		lblData.setBounds(339, 7, 338, 18);
		panelRodape.add(lblData);
		lblData.setForeground(SystemColor.text);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 16));
		JLabel lblNewLabel = new JLabel("Usuário:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 58, 14);
		panelRodape.add(lblNewLabel);
		lblUsuario = new JLabel("New label");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setBounds(66, 11, 120, 14);
		panelRodape.add(lblUsuario);
		btnUsuarios = new JButton("");
		btnUsuarios.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnUsuarios.setVisible(false);
		btnUsuarios.setBounds(148, 10, 128, 140);
		btnUsuarios.setEnabled(false);
		btnUsuarios.setToolTipText("Usuários");
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setContentAreaFilled(false);
		btnUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/img/usuarios_marvi.png")));
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios usuarios = new Usuarios();
				usuarios.setVisible(true);
			}
		});
		contentPane.add(btnUsuarios);
		JButton btnServico = new JButton("");
		btnServico.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnServico.setBounds(10, 10, 128, 140);
		btnServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Servico servicos = new Servico();
				servicos.setVisible(true);
				servicos.usuario = lblUsuario.getText();
			}
		});
		btnServico.setContentAreaFilled(false);
		btnServico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnServico.setToolTipText("Ordem de Serviço");
		btnServico.setIcon(new ImageIcon(Principal.class.getResource("/img/orçamento_marvi.png")));
		contentPane.add(btnServico);
		JButton btnClientes = new JButton("");
		btnClientes.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnClientes.setBounds(10, 161, 128, 140);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes clientes = new Clientes();
				clientes.setVisible(true);
			}
		});
		btnClientes.setContentAreaFilled(false);
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setIcon(new ImageIcon(Principal.class.getResource("/img/clientes_marvi.png")));
		btnClientes.setToolTipText("Clientes");
		contentPane.add(btnClientes);
		btnRelatorios = new JButton("");
		btnRelatorios.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnRelatorios.setVisible(false);
		btnRelatorios.setBounds(424, 10, 128, 140);
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios relatorios = new Relatorios();
				relatorios.setVisible(true);
			}
		});
		btnRelatorios.setEnabled(false);
		btnRelatorios.setContentAreaFilled(false);
		btnRelatorios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorios.setIcon(new ImageIcon(Principal.class.getResource("/img/relatorios_marvi.png")));
		btnRelatorios.setToolTipText("Relatórios");
		contentPane.add(btnRelatorios);
		JButton btnNewButton = new JButton("");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(563, 10, 48, 48);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				Principal.this.dispose();
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/img/logout.png")));
		btnNewButton.setToolTipText("Sair");
		contentPane.add(btnNewButton);
		btnTecnicos = new JButton("");
		btnTecnicos.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnTecnicos.setVisible(false);
		btnTecnicos.setBounds(286, 11, 128, 140);
		btnTecnicos.setEnabled(false);
		btnTecnicos.setToolTipText("Técnicos");
		btnTecnicos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTecnicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tecnicos tecnicos = new Tecnicos();
				tecnicos.setVisible(true);
			}
		});
		btnTecnicos.setContentAreaFilled(false);
		btnTecnicos.setIcon(new ImageIcon(Principal.class.getResource("/img/tecnicos_marvi.png")));
		contentPane.add(btnTecnicos);
		btnFornecedores = new JButton("");
		btnFornecedores.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnFornecedores.setVisible(false);
		btnFornecedores.setBounds(148, 161, 128, 140);
		btnFornecedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedores fornecedores = new Fornecedores();
				fornecedores.setVisible(true);
			}
		});
		btnFornecedores.setIcon(new ImageIcon(Principal.class.getResource("/img/fornecedores_marvi.png")));
		btnFornecedores.setToolTipText("Fornecedores");
		btnFornecedores.setEnabled(false);
		btnFornecedores.setContentAreaFilled(false);
		contentPane.add(btnFornecedores);
		btnEstoque = new JButton("");
		btnEstoque.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnEstoque.setVisible(false);
		btnEstoque.setBounds(286, 161, 128, 140);
		btnEstoque.setEnabled(false);
		btnEstoque.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estoques estoques = new Estoques();
				estoques.setVisible(true);
			}
		});
		btnEstoque.setIcon(new ImageIcon(Principal.class.getResource("/img/estoque_marvi.png")));
		btnEstoque.setToolTipText("Estoque");
		btnEstoque.setContentAreaFilled(false);
		contentPane.add(btnEstoque);
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Principal.class.getResource("/img/logo1.png")));
		lblNewLabel_2.setBounds(424, 224, 243, 166);
		contentPane.add(lblNewLabel_2);
	}

	private void setarData() {
		Date data = new Date();
		DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
		lblData.setText(formatador.format(data));
	}
}