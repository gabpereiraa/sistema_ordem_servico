package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ItemSelectable;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.cj.jdbc.Blob;
import com.toedter.calendar.JDateChooser;
import model.DAO;
import util.Validador;
import javax.swing.border.BevelBorder;

@SuppressWarnings({ "unused", "serial" })
public class Servico extends JDialog {
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	private JTextField txtOS;
	private JTextField txtIDcli;
	private JTextField txtDefeito;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtSerie;
	private JTextField txtDiagnostico;
	@SuppressWarnings("rawtypes")
	private JComboBox cboStatus;
	private JButton btnBuscarOS;
	private JButton btnCreate;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnLimpar;
	private JTextField txtNome;
	@SuppressWarnings("rawtypes")
	private JList listaUsuarios;
	private JScrollPane scrollPane;
	private JDateChooser txtDataSaida;
	private JDateChooser txtDataEntrada;
	private JTextField txtIDtec;
	private JTextField txtTecnico;
	private JScrollPane scrollPane1;
	@SuppressWarnings("rawtypes")
	private JList listaUsuarios1;
	private JTextField txtUser;
	public String usuario;
	private JButton btnOS;
	private JTextField txtObs;
	private JPanel panel_4;
	private JRadioButton rdOrcamento;
	private JRadioButton rdOs;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	@SuppressWarnings("rawtypes")
	private JComboBox cboQuant4;
	private JLabel lblNewLabel_17;
	private JTextField txtProduto04;
	private JLabel lblNewLabel_18;
	private JTextField txtTotal;
	private JTextField txtProduto05;
	private JTextField txtProduto06;
	private JTextField txtBarra06;
	private JTextField txtBarra05;
	private JLabel lblNewLabel_11;
	private JTextField txtBarra04;
	private JLabel lblNewLabel_13;
	private JTextField txtProduto01;
	private JTextField txtProduto02;
	private JTextField txtProduto03;
	private JTextField txtBarra03;
	private JTextField txtBarra02;
	private JTextField txtBarra01;
	private JTextField txtValorPecaTotal;
	private JLabel lblNewLabel;
	@SuppressWarnings("rawtypes")
	private JComboBox cboServico;
	@SuppressWarnings("rawtypes")
	private JComboBox cboQuant1;
	@SuppressWarnings("rawtypes")
	private JComboBox cboQuant2;
	@SuppressWarnings("rawtypes")
	private JComboBox cboQuant3;
	@SuppressWarnings("rawtypes")
	private JComboBox cboQuant5;
	@SuppressWarnings("rawtypes")
	private JComboBox cboQuant6;
	private String tipo;
	@SuppressWarnings("rawtypes")
	private JList listaUsuarios03;
	private JScrollPane scrollPane03;
	private JScrollPane scrollPane01;
	private JScrollPane scrollPane06;
	private JScrollPane scrollPane05;
	private JScrollPane scrollPane04;
	@SuppressWarnings("rawtypes")
	private JList listaUsuarios02;
	@SuppressWarnings("rawtypes")
	private JList listaUsuarios01;
	@SuppressWarnings("rawtypes")
	private JList listaUsuarios06;
	@SuppressWarnings("rawtypes")
	private JList listaUsuarios04;
	@SuppressWarnings("rawtypes")
	private JList listaUsuarios05;
	private JScrollPane scrollPane02;
	private JTextField txtValorPeca01;
	private JTextField txtValorPeca02;
	private JLabel lblNewLabel_14;
	private JTextField txtValorPeca03;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JTextField txtValorPeca04;
	private JLabel lblNewLabel_19;
	private JTextField txtValorPeca05;
	private JLabel lblNewLabel_20;
	private JTextField txtValorPeca06;
	private JTextField txtTroco;
	private JLabel lblNewLabel_5_2;
	@SuppressWarnings("rawtypes")
	private JComboBox cboTipoPag;
	private JTextField txtValorServico;
	private JTextField txtPago;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servico dialog = new Servico();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Servico() {
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane01.setVisible(false);
				scrollPane02.setVisible(false);
				scrollPane03.setVisible(false);
				scrollPane04.setVisible(false);
				scrollPane05.setVisible(false);
				scrollPane06.setVisible(false);
			}
		});
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				tipo = "ORÇAMENTO";
				txtUser.setText(usuario);
			}
		});
		setTitle("Marvi Cold - ORDEM DE SERVIÇO");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Servico.class.getResource("/img/ar condicionado 2.png")));
		setBounds(100, 100, 1281, 691);
		getContentPane().setLayout(null);
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"T\u00C9CNICO", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(797, 11, 323, 135);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		scrollPane1 = new JScrollPane();
		scrollPane1.setVisible(false);
		scrollPane1.setBounds(10, 64, 303, 60);
		panel_2.add(scrollPane1);
		listaUsuarios1 = new JList();
		listaUsuarios1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarUsuariosLista();
			}
		});
		scrollPane1.setViewportView(listaUsuarios1);
		txtIDtec = new JTextField();
		txtIDtec.setEditable(false);
		txtIDtec.setColumns(10);
		txtIDtec.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"ID T\u00C9CNICO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		txtIDtec.setBounds(10, 78, 303, 40);
		panel_2.add(txtIDtec);
		txtTecnico = new JTextField();
		txtTecnico.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				listarUsuarios();
			}
		});
		txtTecnico.setDocument(new Validador(50));
		txtTecnico.setColumns(10);
		txtTecnico.setBorder(new TitledBorder(null, "NOME", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtTecnico.setBounds(10, 24, 303, 43);
		panel_2.add(txtTecnico);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "CLIENTE",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(488, 11, 299, 135);
		getContentPane().add(panel);
		panel.setLayout(null);
		setLocationRelativeTo(null);
		scrollPane = new JScrollPane();
		scrollPane.setVisible(false);
		scrollPane.setBounds(10, 64, 273, 60);
		panel.add(scrollPane);
		listaUsuarios = new JList();
		listaUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarClientesLista();
			}
		});
		scrollPane.setViewportView(listaUsuarios);
		txtIDcli = new JTextField();
		txtIDcli.setEditable(false);
		txtIDcli.setBorder(new TitledBorder(null, "ID CLIENTE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtIDcli.setBounds(10, 78, 273, 40);
		panel.add(txtIDcli);
		txtIDcli.setColumns(10);
		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				listarClientes();
			}
		});
		txtNome.setBorder(new TitledBorder(null, "NOME", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtNome.setBounds(10, 24, 273, 43);
		panel.add(txtNome);
		txtNome.setColumns(10);
		txtNome.setDocument(new Validador(30));
		JLabel lblNewLabel_2 = new JLabel("DEFEITO DECLARADO");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_2.setBounds(14, 304, 153, 14);
		getContentPane().add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("DIAGNÓSTICO");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_3.setBounds(12, 385, 93, 14);
		getContentPane().add(lblNewLabel_3);
		txtDefeito = new JTextField();
		txtDefeito.setBounds(135, 297, 852, 29);
		getContentPane().add(txtDefeito);
		txtDefeito.setColumns(10);
		txtDefeito.setDocument(new Validador(200));
		txtDiagnostico = new JTextField();
		txtDiagnostico.setBounds(135, 376, 852, 33);
		getContentPane().add(txtDiagnostico);
		txtDiagnostico.setColumns(10);
		txtDiagnostico.setDocument(new Validador(200));
		btnCreate = new JButton("");
		btnCreate.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.setToolTipText("Adicionar OS");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarOS();
			}
		});
		btnCreate.setContentAreaFilled(false);
		btnCreate.setIcon(new ImageIcon(Servico.class.getResource("/img/addfile.png")));
		btnCreate.setBounds(214, 595, 48, 48);
		getContentPane().add(btnCreate);
		btnUpdate = new JButton("");
		btnUpdate.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setToolTipText("Atualizar OS");
		btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cboStatus.getSelectedItem().equals("FINALIZADO")) {
					int resposta = JOptionPane.showConfirmDialog(null,
							"                                                                  ATENÇÃO \n                                Deseja Confirmar a OS como FINALIZADO ? \n Caso ocorra a confirmação irá travar a OS e não será possivel fazer futuras alterações",
							"Confirmação", JOptionPane.YES_NO_OPTION);
					if (resposta == JOptionPane.YES_OPTION) {
					} else {
						cboStatus.setSelectedItem("");
					}
				}
				Produto1Estoque();
				Produto2Estoque();
				Produto3Estoque();
				Produto4Estoque();
				Produto5Estoque();
				Produto6Estoque();
				contEstoque1();
				contEstoque2();
				contEstoque3();
				contEstoque4();
				contEstoque5();
				contEstoque6();
				editarOS();
			}
		});
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setIcon(new ImageIcon(Servico.class.getResource("/img/update-motos.png")));
		btnUpdate.setBounds(272, 595, 48, 48);
		getContentPane().add(btnUpdate);
		btnLimpar = new JButton("");
		btnLimpar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setToolTipText("Limpar Campos");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setIcon(new ImageIcon(Servico.class.getResource("/img/eraser.png")));
		btnLimpar.setBounds(496, 595, 48, 48);
		getContentPane().add(btnLimpar);
		btnDelete = new JButton("");
		btnDelete.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setToolTipText("Deletar OS");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirOS();
			}
		});
		btnDelete.setContentAreaFilled(false);
		btnDelete.setIcon(new ImageIcon(Servico.class.getResource("/img/trash.png")));
		btnDelete.setBounds(392, 595, 48, 48);
		getContentPane().add(btnDelete);
		JLabel lblNewLabel_12 = new JLabel("DATA SAIDA");
		lblNewLabel_12.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_12.setBounds(14, 563, 79, 13);
		getContentPane().add(lblNewLabel_12);
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"EQUIPAMENTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(12, 185, 986, 83);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		JLabel lblNewLabel_6 = new JLabel("MARCA");
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_6.setBounds(45, 25, 68, 18);
		panel_1.add(lblNewLabel_6);
		txtMarca = new JTextField();
		txtMarca.setBounds(123, 23, 381, 20);
		panel_1.add(txtMarca);
		txtMarca.setColumns(10);
		txtMarca.setDocument(new Validador(15));
		JLabel lblNewLabel_7 = new JLabel("MODELO");
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_7.setBounds(514, 25, 74, 14);
		panel_1.add(lblNewLabel_7);
		txtModelo = new JTextField();
		txtModelo.setBounds(575, 23, 401, 20);
		panel_1.add(txtModelo);
		txtModelo.setColumns(10);
		txtModelo.setDocument(new Validador(20));
		txtSerie = new JTextField();
		txtSerie.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtSerie.setBounds(123, 57, 381, 20);
		panel_1.add(txtSerie);
		txtSerie.setColumns(10);
		txtSerie.setDocument(new Validador(15));
		JLabel lblNewLabel_8 = new JLabel("N° SÉRIE");
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_8.setBounds(45, 55, 68, 25);
		panel_1.add(lblNewLabel_8);
		txtDataSaida = new JDateChooser();
		txtDataSaida.setBounds(83, 561, 160, 20);
		getContentPane().add(txtDataSaida);
		txtUser = new JTextField();
		txtUser.setEditable(false);
		txtUser.setBounds(133, 155, 376, 20);
		getContentPane().add(txtUser);
		txtUser.setColumns(10);
		JLabel lblNewLabel_4 = new JLabel("USUÁRIO");
		lblNewLabel_4.setBounds(12, 161, 64, 14);
		getContentPane().add(lblNewLabel_4);
		btnOS = new JButton("");
		btnOS.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnOS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOS.setEnabled(false);
		btnOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimirOS();
			}
		});
		btnOS.setToolTipText("Impressão da OS");
		btnOS.setContentAreaFilled(false);
		btnOS.setIcon(new ImageIcon(Servico.class.getResource("/img/impressora.png")));
		btnOS.setBounds(332, 595, 48, 48);
		getContentPane().add(btnOS);
		txtObs = new JTextField();
		txtObs.setColumns(10);
		txtObs.setBounds(133, 333, 854, 29);
		txtObs.setDocument(new Validador(100));
		getContentPane().add(txtObs);
		JLabel lblNewLabel_3_1 = new JLabel("OBSERVAÇÃO");
		lblNewLabel_3_1.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_3_1.setBounds(14, 340, 93, 14);
		getContentPane().add(lblNewLabel_3_1);
		cboServico = new JComboBox();
		cboServico.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (!cboServico.getSelectedItem().equals("MANUTENÇÃO CORRETIVA")) {
					txtDefeito.setText(null);
					txtDefeito.setEditable(false);
					txtDiagnostico.setText(null);
					txtDiagnostico.setEditable(false);
				} else {
					txtDefeito.setEditable(true);
					txtDiagnostico.setEditable(true);
				}

			}
		});
		cboServico.setModel(new DefaultComboBoxModel(new String[] { "", "MANUTENÇÃO PREVENTIVA", "MANUTENÇÃO CORRETIVA",
				"INSTALAÇÃO", "REMOÇÃO / REALOCAÇÃO" }));
		cboServico.setBounds(135, 272, 384, 22);
		getContentPane().add(cboServico);
		JLabel lblNewLabel_1_1 = new JLabel("TIPO DE SERVIÇO");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(14, 277, 127, 13);
		getContentPane().add(lblNewLabel_1_1);
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(
				new TitledBorder(null, "ORDEM DE SERVI\u00C7O", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 11, 468, 135);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		txtOS = new JTextField();
		txtOS.setBorder(new TitledBorder(null, "N\u00B0 OS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtOS.setBounds(10, 20, 238, 53);
		panel_3.add(txtOS);
		txtOS.setEnabled(false);
		txtOS.setColumns(10);
		txtDataEntrada = new JDateChooser();
		txtDataEntrada.setBounds(6, 78, 452, 48);
		panel_3.add(txtDataEntrada);
		txtDataEntrada
				.setBorder(new TitledBorder(null, "DATA ENTRADA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtDataEntrada.setEnabled(false);
		rdOrcamento = new JRadioButton("ORÇAMENTO");
		rdOrcamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo = "ORÇAMENTO";
			}
		});
		rdOrcamento.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonGroup.add(rdOrcamento);
		rdOrcamento.setBounds(254, 41, 134, 18);
		panel_3.add(rdOrcamento);

		rdOs = new JRadioButton("OS");
		rdOs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo = "OS";
			}
		});
		rdOs.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonGroup.add(rdOs);
		rdOs.setBounds(254, 20, 106, 18);
		panel_3.add(rdOs);
		btnBuscarOS = new JButton("");
		btnBuscarOS.setBounds(394, 11, 64, 64);
		panel_3.add(btnBuscarOS);
		btnBuscarOS.setToolTipText("Buscar OS");
		btnBuscarOS.setIcon(new ImageIcon(Servico.class.getResource("/img/searchOS.png")));
		JLabel lblNewLabel_1 = new JLabel("STATUS");
		lblNewLabel_1.setBounds(525, 162, 64, 13);
		getContentPane().add(lblNewLabel_1);
		cboStatus = new JComboBox();
		cboStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cboStatus.setBounds(587, 155, 400, 22);
		getContentPane().add(cboStatus);
		cboStatus.setModel(new DefaultComboBoxModel(
				new String[] { "", "AGUARDANDO INSTALAÇÃO", "AGUARDANDO MANUTENÇÃO PREVENTIVA", "AGUARDANDO REMOÇÃO",
						"AGUARDANDO DIAGNOSTICO", "AGUARDANDO APROVAÇÃO DO CLIENTE", "ORDEM NÃO APROVADA PELO CLIENTE",
						"AGUARDANDO TÉCNICO", "AGUARDANDO PEÇAS", "NA BANCADA", "PRONTO", "FINALIZADO" }));
		panel_4 = new JPanel();
		panel_4.setBorder(
				new TitledBorder(null, "PE\u00C7AS UTILIZADAS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(12, 416, 1259, 135);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		scrollPane01 = new JScrollPane();
		scrollPane01.setVisible(false);
		scrollPane01.setBounds(248, 32, 166, 52);
		panel_4.add(scrollPane01);
		listaUsuarios01 = new JList();
		listaUsuarios01.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarProdutosLista01();
			}
		});
		scrollPane01.setViewportView(listaUsuarios01);
		scrollPane04 = new JScrollPane();
		scrollPane04.setVisible(false);
		scrollPane04.setBounds(872, 40, 166, 44);
		panel_4.add(scrollPane04);
		listaUsuarios04 = new JList();
		listaUsuarios04.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarProdutosLista04();
			}
		});
		scrollPane04.setViewportView(listaUsuarios04);
		scrollPane06 = new JScrollPane();
		scrollPane06.setVisible(false);
		scrollPane06.setBounds(872, 94, 166, 44);
		panel_4.add(scrollPane06);
		listaUsuarios06 = new JList();
		listaUsuarios06.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarProdutosLista06();
			}
		});
		scrollPane06.setViewportView(listaUsuarios06);
		scrollPane02 = new JScrollPane();
		scrollPane02.setVisible(false);
		scrollPane02.setBounds(248, 68, 166, 44);
		panel_4.add(scrollPane02);
		listaUsuarios02 = new JList();
		listaUsuarios02.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarProdutosLista02();
			}
		});
		scrollPane02.setViewportView(listaUsuarios02);
		scrollPane05 = new JScrollPane();
		scrollPane05.setVisible(false);
		scrollPane05.setBounds(872, 68, 166, 44);
		panel_4.add(scrollPane05);
		listaUsuarios05 = new JList();
		listaUsuarios05.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarProdutosLista05();
			}
		});
		scrollPane05.setViewportView(listaUsuarios05);
		scrollPane03 = new JScrollPane();
		scrollPane03.setVisible(false);
		scrollPane03.setBounds(248, 94, 166, 44);
		panel_4.add(scrollPane03);
		listaUsuarios03 = new JList();
		listaUsuarios03.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarProdutosLista03();

			}
		});
		scrollPane03.setViewportView(listaUsuarios03);

		cboQuant4 = new JComboBox();
		cboQuant4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ValorProduto4();
			}
		});
		cboQuant4.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43",
				"44", "45", "46", "47", "48", "49", "50" }));
		cboQuant4.setToolTipText("");
		cboQuant4.setBounds(1091, 11, 45, 26);
		panel_4.add(cboQuant4);
		lblNewLabel_17 = new JLabel("QUANT");
		lblNewLabel_17.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_17.setBounds(1048, 18, 45, 13);
		panel_4.add(lblNewLabel_17);
		txtProduto04 = new JTextField();
		txtProduto04.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				listarProdutos04();
			}
		});
		txtProduto04.setColumns(10);
		txtProduto04.setBounds(872, 11, 166, 26);
		txtProduto04.setDocument(new Validador(70));
		panel_4.add(txtProduto04);
		lblNewLabel_18 = new JLabel("PRODUTO");
		lblNewLabel_18.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_18.setBounds(814, 17, 80, 13);
		panel_4.add(lblNewLabel_18);
		JLabel lblNewLabel_18_1 = new JLabel("PRODUTO");
		lblNewLabel_18_1.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_18_1.setBounds(814, 47, 80, 13);
		panel_4.add(lblNewLabel_18_1);
		txtProduto05 = new JTextField();
		txtProduto05.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				listarProdutos05();
			}
		});
		txtProduto05.setColumns(10);
		txtProduto05.setBounds(872, 41, 166, 26);
		txtProduto05.setDocument(new Validador(70));
		panel_4.add(txtProduto05);
		JLabel lblNewLabel_17_1 = new JLabel("QUANT");
		lblNewLabel_17_1.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_17_1.setBounds(1048, 48, 45, 13);
		panel_4.add(lblNewLabel_17_1);
		cboQuant5 = new JComboBox();
		cboQuant5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ValorProduto5();
			}
		});
		cboQuant5.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43",
				"44", "45", "46", "47", "48", "49", "50" }));
		cboQuant5.setToolTipText("");
		cboQuant5.setBounds(1091, 41, 45, 26);
		panel_4.add(cboQuant5);
		JLabel lblNewLabel_18_2 = new JLabel("PRODUTO");
		lblNewLabel_18_2.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_18_2.setBounds(814, 76, 80, 13);
		panel_4.add(lblNewLabel_18_2);
		txtProduto06 = new JTextField();
		txtProduto06.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				listarProdutos06();
			}
		});
		txtProduto06.setColumns(10);
		txtProduto06.setBounds(872, 70, 166, 26);
		txtProduto06.setDocument(new Validador(70));
		panel_4.add(txtProduto06);
		JLabel lblNewLabel_17_2 = new JLabel("QUANT");
		lblNewLabel_17_2.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_17_2.setBounds(1048, 77, 45, 13);
		panel_4.add(lblNewLabel_17_2);
		cboQuant6 = new JComboBox();
		cboQuant6.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ValorProduto6();
			}
		});
		cboQuant6.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43",
				"44", "45", "46", "47", "48", "49", "50" }));
		cboQuant6.setToolTipText("");
		cboQuant6.setBounds(1091, 70, 45, 26);
		panel_4.add(cboQuant6);
		txtBarra06 = new JTextField();
		txtBarra06.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					buscarItemCodBarra6();
				}
			}
		});
		txtBarra06.setColumns(10);
		txtBarra06.setBounds(754, 69, 55, 26);
		txtBarra06.setDocument(new Validador(13));
		panel_4.add(txtBarra06);
		JLabel lblNewLabel_10 = new JLabel("CÓDIGO DE BARRAS");
		lblNewLabel_10.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_10.setBounds(636, 75, 114, 14);
		panel_4.add(lblNewLabel_10);
		txtBarra05 = new JTextField();
		txtBarra05.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					buscarItemCodBarra5();
				}
			}
		});
		txtBarra05.setColumns(10);
		txtBarra05.setBounds(754, 41, 55, 26);
		txtBarra05.setDocument(new Validador(13));
		panel_4.add(txtBarra05);
		lblNewLabel_11 = new JLabel("CÓDIGO DE BARRAS");
		lblNewLabel_11.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_11.setBounds(636, 47, 114, 14);
		panel_4.add(lblNewLabel_11);
		txtBarra04 = new JTextField();
		txtBarra04.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					buscarItemCodBarra4();
				}
			}
		});
		txtBarra04.setColumns(10);
		txtBarra04.setBounds(754, 11, 55, 26);
		txtBarra04.setDocument(new Validador(13));
		panel_4.add(txtBarra04);
		lblNewLabel_13 = new JLabel("CÓDIGO DE BARRAS");
		lblNewLabel_13.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_13.setBounds(636, 17, 114, 14);
		panel_4.add(lblNewLabel_13);
		cboQuant1 = new JComboBox();
		cboQuant1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ValorProduto1();
			}
		});
		cboQuant1.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43",
				"44", "45", "46", "47", "48", "49", "50" }));
		cboQuant1.setToolTipText("");
		cboQuant1.setBounds(467, 11, 45, 26);
		panel_4.add(cboQuant1);
		txtProduto01 = new JTextField();
		txtProduto01.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				listarProdutos01();
			}
		});
		txtProduto01.setColumns(10);
		txtProduto01.setBounds(248, 11, 166, 26);
		txtProduto01.setDocument(new Validador(70));
		panel_4.add(txtProduto01);
		JLabel lblNewLabel_17_3 = new JLabel("QUANT");
		lblNewLabel_17_3.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_17_3.setBounds(424, 18, 45, 13);
		panel_4.add(lblNewLabel_17_3);
		JLabel lblNewLabel_18_3 = new JLabel("PRODUTO");
		lblNewLabel_18_3.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_18_3.setBounds(190, 17, 80, 13);
		panel_4.add(lblNewLabel_18_3);
		JLabel lblNewLabel_18_1_1 = new JLabel("PRODUTO");
		lblNewLabel_18_1_1.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_18_1_1.setBounds(190, 47, 80, 13);
		panel_4.add(lblNewLabel_18_1_1);
		JLabel lblNewLabel_17_1_1 = new JLabel("QUANT");
		lblNewLabel_17_1_1.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_17_1_1.setBounds(424, 48, 45, 13);
		panel_4.add(lblNewLabel_17_1_1);
		txtProduto02 = new JTextField();
		txtProduto02.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				listarProdutos02();
			}
		});
		txtProduto02.setColumns(10);
		txtProduto02.setBounds(248, 41, 166, 26);
		txtProduto02.setDocument(new Validador(70));
		panel_4.add(txtProduto02);
		cboQuant2 = new JComboBox();
		cboQuant2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ValorProduto2();
			}
		});
		cboQuant2.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43",
				"44", "45", "46", "47", "48", "49", "50" }));
		cboQuant2.setToolTipText("");
		cboQuant2.setBounds(467, 41, 45, 26);
		panel_4.add(cboQuant2);
		JLabel lblNewLabel_18_2_1 = new JLabel("PRODUTO");
		lblNewLabel_18_2_1.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_18_2_1.setBounds(190, 76, 80, 13);
		panel_4.add(lblNewLabel_18_2_1);
		JLabel lblNewLabel_17_2_1 = new JLabel("QUANT");
		lblNewLabel_17_2_1.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_17_2_1.setBounds(424, 77, 45, 13);
		panel_4.add(lblNewLabel_17_2_1);
		txtProduto03 = new JTextField();
		txtProduto03.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				listarProdutos03();

			}
		});
		txtProduto03.setColumns(10);
		txtProduto03.setDocument(new Validador(70));
		txtProduto03.setBounds(248, 70, 166, 26);
		panel_4.add(txtProduto03);
		cboQuant3 = new JComboBox();
		cboQuant3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ValorProduto3();
			}
		});
		cboQuant3.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43",
				"44", "45", "46", "47", "48", "49", "50" }));
		cboQuant3.setToolTipText("");
		cboQuant3.setBounds(467, 70, 45, 26);
		panel_4.add(cboQuant3);
		txtBarra03 = new JTextField();
		txtBarra03.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					buscarItemCodBarra3();
				}
			}
		});
		txtBarra03.setColumns(10);
		txtBarra03.setBounds(130, 69, 55, 26);
		txtBarra03.setDocument(new Validador(13));
		panel_4.add(txtBarra03);
		JLabel lblNewLabel_10_1 = new JLabel("CÓDIGO DE BARRAS");
		lblNewLabel_10_1.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_10_1.setBounds(10, 75, 114, 14);
		panel_4.add(lblNewLabel_10_1);
		txtBarra02 = new JTextField();
		txtBarra02.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					buscarItemCodBarra2();
				}
			}
		});
		txtBarra02.setColumns(10);
		txtBarra02.setBounds(130, 41, 55, 26);
		txtBarra02.setDocument(new Validador(13));
		panel_4.add(txtBarra02);
		JLabel lblNewLabel_11_1 = new JLabel("CÓDIGO DE BARRAS");
		lblNewLabel_11_1.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_11_1.setBounds(10, 47, 114, 14);
		panel_4.add(lblNewLabel_11_1);
		JLabel lblNewLabel_13_1 = new JLabel("CÓDIGO DE BARRAS");
		lblNewLabel_13_1.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_13_1.setBounds(10, 17, 114, 14);
		panel_4.add(lblNewLabel_13_1);
		txtBarra01 = new JTextField();
		txtBarra01.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					buscarItemCodBarra1();
				}
			}
		});
		txtBarra01.setColumns(10);
		txtBarra01.setBounds(130, 11, 55, 26);
		txtBarra01.setDocument(new Validador(13));
		panel_4.add(txtBarra01);
		JLabel lblNewLabel_9 = new JLabel("VALOR");
		lblNewLabel_9.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_9.setBounds(522, 18, 72, 13);
		panel_4.add(lblNewLabel_9);
		txtValorPeca01 = new JTextField();
		txtValorPeca01.setText("0.00");
		txtValorPeca01.setEditable(false);
		txtValorPeca01.setBounds(569, 12, 57, 26);
		panel_4.add(txtValorPeca01);
		txtValorPeca01.setColumns(10);
		txtValorPeca02 = new JTextField();
		txtValorPeca02.setText("0.00");
		txtValorPeca02.setEditable(false);
		txtValorPeca02.setColumns(10);
		txtValorPeca02.setBounds(569, 40, 57, 26);
		panel_4.add(txtValorPeca02);
		lblNewLabel_14 = new JLabel("VALOR");
		lblNewLabel_14.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_14.setBounds(522, 46, 72, 13);
		panel_4.add(lblNewLabel_14);
		txtValorPeca03 = new JTextField();
		txtValorPeca03.setText("0.00");
		txtValorPeca03.setEditable(false);
		txtValorPeca03.setColumns(10);
		txtValorPeca03.setBounds(569, 68, 57, 26);
		panel_4.add(txtValorPeca03);
		lblNewLabel_15 = new JLabel("VALOR");
		lblNewLabel_15.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_15.setBounds(522, 74, 72, 13);
		panel_4.add(lblNewLabel_15);
		lblNewLabel_16 = new JLabel("VALOR");
		lblNewLabel_16.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_16.setBounds(1146, 17, 72, 13);
		panel_4.add(lblNewLabel_16);
		txtValorPeca04 = new JTextField();
		txtValorPeca04.setText("0.00");
		txtValorPeca04.setEditable(false);
		txtValorPeca04.setColumns(10);
		txtValorPeca04.setBounds(1193, 11, 57, 26);
		panel_4.add(txtValorPeca04);
		lblNewLabel_19 = new JLabel("VALOR");
		lblNewLabel_19.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_19.setBounds(1146, 45, 72, 13);
		panel_4.add(lblNewLabel_19);
		txtValorPeca05 = new JTextField();
		txtValorPeca05.setText("0.00");
		txtValorPeca05.setEditable(false);
		txtValorPeca05.setColumns(10);
		txtValorPeca05.setBounds(1193, 39, 57, 26);
		panel_4.add(txtValorPeca05);
		lblNewLabel_20 = new JLabel("VALOR");
		lblNewLabel_20.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_20.setBounds(1146, 73, 72, 13);
		panel_4.add(lblNewLabel_20);
		txtValorPeca06 = new JTextField();
		txtValorPeca06.setText("0.00");
		txtValorPeca06.setEditable(false);
		txtValorPeca06.setColumns(10);
		txtValorPeca06.setBounds(1193, 67, 57, 26);
		panel_4.add(txtValorPeca06);
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(
				new TitledBorder(null, "PAGAMENTO E VALORES", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(554, 561, 637, 83);
		getContentPane().add(panel_5);
		panel_5.setLayout(null);
		cboTipoPag = new JComboBox();
		cboTipoPag.setBounds(235, 8, 392, 38);
		panel_5.add(cboTipoPag);
		cboTipoPag.setModel(
				new DefaultComboBoxModel(new String[] { "", "DINHEIRO", "CARTÃO DE CRÉDITO / DÉBITO", "PIX" }));
		cboTipoPag.setBorder(
				new TitledBorder(null, "FORMA DE PAGAMENTO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtTotal = new JTextField();
		txtTotal.setBounds(270, 53, 83, 20);
		panel_5.add(txtTotal);
		txtTotal.setEditable(false);
		txtTotal.setText("0.00");
		txtTotal.setColumns(10);
		JLabel lblNewLabel_5_1 = new JLabel("TOTAL");
		lblNewLabel_5_1.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_5_1.setBounds(227, 56, 64, 14);
		panel_5.add(lblNewLabel_5_1);
		JLabel lblNewLabel_5 = new JLabel("VALOR SERVIÇO");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_5.setBounds(10, 55, 114, 14);
		panel_5.add(lblNewLabel_5);
		lblNewLabel = new JLabel("VALOR TOTAL PEÇAS");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel.setBounds(10, 29, 133, 14);
		panel_5.add(lblNewLabel);
		txtValorPecaTotal = new JTextField();
		txtValorPecaTotal.setBounds(134, 25, 83, 20);
		panel_5.add(txtValorPecaTotal);
		txtValorPecaTotal.setText("0.00");
		txtValorPecaTotal.setEnabled(false);
		txtValorPecaTotal.setColumns(10);
		txtTroco = new JTextField();
		txtTroco.setText("0.00");
		txtTroco.setEditable(false);
		txtTroco.setColumns(10);
		txtTroco.setBounds(571, 53, 56, 20);
		panel_5.add(txtTroco);
		JLabel lblNewLabel_5_1_1 = new JLabel("TROCO");
		lblNewLabel_5_1_1.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_5_1_1.setBounds(519, 55, 56, 14);
		panel_5.add(lblNewLabel_5_1_1);

		lblNewLabel_5_2 = new JLabel("VALOR PAGO");
		lblNewLabel_5_2.setFont(new Font("Dialog", Font.BOLD, 10));
		lblNewLabel_5_2.setBounds(357, 56, 114, 14);
		panel_5.add(lblNewLabel_5_2);

		txtValorServico = new JTextField();
		txtValorServico.setBounds(134, 53, 83, 20);
		panel_5.add(txtValorServico);
		txtValorServico.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				totalValor();
			}

			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtValorServico.setText("0.00");
		txtValorServico.setColumns(10);

		txtPago = new JTextField();
		txtPago.setBounds(430, 53, 81, 20);
		panel_5.add(txtPago);
		txtPago.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				valorPago();
			}

			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtPago.setText("0.00");
		txtPago.setColumns(10);
		btnBuscarOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarOS();
			}
		});
	}

	private void buscarOS() {
		String numOS = JOptionPane.showInputDialog("Número da OS");
		String read = "select * from servicos where os = ? ";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(read);
			pst.setString(1, numOS);
			ResultSet resultSet1 = pst.executeQuery();
			if (resultSet1.next()) {
				txtOS.setText(resultSet1.getString(1));
				txtIDcli.setText(resultSet1.getString(2));
				txtDefeito.setText(resultSet1.getString(3));
				txtDiagnostico.setText(resultSet1.getString(4));
				cboStatus.setSelectedItem(resultSet1.getString(5));
				txtValorServico.setText(resultSet1.getString(6));
				txtMarca.setText(resultSet1.getString(9));
				txtModelo.setText(resultSet1.getString(10));
				txtSerie.setText(resultSet1.getString(11));
				txtIDtec.setText(resultSet1.getString(12));
				txtUser.setText(resultSet1.getString(13));
				txtNome.setText(resultSet1.getString(14));
				txtTecnico.setText(resultSet1.getString(15));
				cboServico.setSelectedItem(resultSet1.getString(16));
				txtObs.setText(resultSet1.getString(17));
				txtBarra01.setText(resultSet1.getString(18));
				txtProduto01.setText(resultSet1.getString(19));
				cboQuant1.setSelectedItem(resultSet1.getString(20));
				txtBarra02.setText(resultSet1.getString(21));
				txtProduto02.setText(resultSet1.getString(22));
				cboQuant2.setSelectedItem(resultSet1.getString(23));
				txtBarra03.setText(resultSet1.getString(24));
				txtProduto03.setText(resultSet1.getString(25));
				cboQuant3.setSelectedItem(resultSet1.getString(26));
				txtBarra04.setText(resultSet1.getString(27));
				txtProduto04.setText(resultSet1.getString(28));
				cboQuant4.setSelectedItem(resultSet1.getString(29));
				txtBarra05.setText(resultSet1.getString(30));
				txtProduto05.setText(resultSet1.getString(31));
				cboQuant5.setSelectedItem(resultSet1.getString(32));
				txtBarra06.setText(resultSet1.getString(33));
				txtProduto06.setText(resultSet1.getString(34));
				cboQuant6.setSelectedItem(resultSet1.getString(35));
				txtValorPecaTotal.setText(resultSet1.getString(36));
				txtTotal.setText(resultSet1.getString(37));
				txtValorPeca01.setText(resultSet1.getString(39));
				txtValorPeca02.setText(resultSet1.getString(40));
				txtValorPeca03.setText(resultSet1.getString(41));
				txtValorPeca04.setText(resultSet1.getString(42));
				txtValorPeca05.setText(resultSet1.getString(43));
				txtValorPeca06.setText(resultSet1.getString(44));
				cboTipoPag.setSelectedItem(resultSet1.getString(45));
				txtPago.setText(resultSet1.getString(46));
				txtTroco.setText(resultSet1.getString(47));
				String rbtTipo = resultSet1.getString(38);
				if (rbtTipo.equals("OS")) {
					rdOs.setSelected(true);
					tipo = "OS";
				} else {
					rdOrcamento.setSelected(true);
					tipo = "Orçamento";
				}
				String setarData = resultSet1.getString(7);
				Date dataFormatada = new SimpleDateFormat("yyyy-MM-dd").parse(setarData);
				txtDataEntrada.setDate(dataFormatada);
				String setarDataSaida = resultSet1.getString(8);
				if (setarDataSaida == null) {
					txtDataSaida.setDate(null);
				} else {
					Date dataFormatada2 = new SimpleDateFormat("yyyy-MM-dd").parse(setarDataSaida);
					txtDataSaida.setDate(dataFormatada2);
				}
				btnCreate.setEnabled(false);
				btnDelete.setEnabled(true);
				btnUpdate.setEnabled(true);
				btnBuscarOS.setEnabled(false);
				btnOS.setEnabled(true);
				if (cboStatus.getSelectedItem().equals("FINALIZADO")) {
					txtNome.setEditable(false);
					txtTecnico.setEditable(false);
					cboStatus.setEnabled(false);
					txtMarca.setEditable(false);
					txtObs.setEditable(false);
					txtModelo.setEditable(false);
					txtSerie.setEditable(false);
					cboServico.setEnabled(false);
					txtDefeito.setEditable(false);
					txtBarra01.setEditable(false);
					txtProduto01.setEditable(false);
					cboQuant1.setEnabled(false);
					txtBarra02.setEditable(false);
					txtProduto02.setEditable(false);
					cboQuant2.setEnabled(false);
					txtBarra03.setEditable(false);
					txtProduto03.setEditable(false);
					cboQuant3.setEnabled(false);
					txtBarra04.setEditable(false);
					txtProduto04.setEditable(false);
					cboQuant4.setEnabled(false);
					txtBarra05.setEditable(false);
					txtProduto05.setEditable(false);
					cboQuant5.setEnabled(false);
					txtBarra06.setEditable(false);
					txtProduto06.setEditable(false);
					cboQuant6.setEnabled(false);
					txtValorServico.setEditable(false);
					txtPago.setEditable(false);
					cboTipoPag.setEnabled(false);
					txtDataSaida.setEnabled(false);
					btnUpdate.setEnabled(false);
				} else {
				}
			} else {
				JOptionPane.showMessageDialog(null, "Ordem de Serviço Inexistente");
				btnCreate.setEnabled(true);
				btnBuscarOS.setEnabled(false);
			}
			resultSet1.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@SuppressWarnings("unchecked")
	private void listarClientes() {
		DefaultListModel<String> modelo = new DefaultListModel<>();
		listaUsuarios.setModel(modelo);
		String readLista = "select * from clientes where nome like '" + txtNome.getText() + "%'" + " order by nome";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(readLista);
			rs = pst.executeQuery(readLista);
			while (rs.next()) {
				scrollPane.setVisible(true);
				modelo.addElement(rs.getString(2));
				if (txtNome.getText().isEmpty()) {
					scrollPane.setVisible(false);
				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void buscarClientesLista() {
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Nome do Usuario");
			txtNome.requestFocus();
		} else {
			int linha = listaUsuarios.getSelectedIndex();
			if (linha >= 0) {
				String read2 = "select * from clientes where nome like '" + txtNome.getText() + "%'"
						+ "order by nome limit " + (linha) + " , 1";
				try {
					con = dao.conectar();
					pst = con.prepareStatement(read2);
					rs = pst.executeQuery();
					if (rs.next()) {
						scrollPane.setVisible(false);
						txtIDcli.setText(rs.getString(1));
						txtNome.setText(rs.getString(2));
					} else {
						JOptionPane.showMessageDialog(null, "Cliente Inexistente");
						btnCreate.setEnabled(true);
					}
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			} else {
				scrollPane.setVisible(false);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void listarUsuarios() {
		DefaultListModel<String> modelo = new DefaultListModel<>();
		listaUsuarios1.setModel(modelo);
		String readLista = "select * from tecnicos where nome like '" + txtTecnico.getText() + "%'" + " order by nome";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(readLista);
			rs = pst.executeQuery(readLista);
			while (rs.next()) {
				scrollPane1.setVisible(true);
				modelo.addElement(rs.getString(2));
				if (txtTecnico.getText().isEmpty()) {
					scrollPane1.setVisible(false);
				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void buscarUsuariosLista() {
		if (txtTecnico.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Nome do Usuario");
			txtTecnico.requestFocus();
		} else {
			int linha = listaUsuarios1.getSelectedIndex();
			if (linha >= 0) {
				String read2 = "select * from tecnicos where nome like '" + txtTecnico.getText() + "%'"
						+ "order by nome limit " + (linha) + " , 1";
				try {
					con = dao.conectar();
					pst = con.prepareStatement(read2);
					rs = pst.executeQuery();
					if (rs.next()) {
						scrollPane1.setVisible(false);
						txtIDtec.setText(rs.getString(1));
						txtTecnico.setText(rs.getString(2));
					} else {
						JOptionPane.showMessageDialog(null, "Usuario Inexistente");
						btnCreate.setEnabled(true);
					}
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			} else {
				scrollPane1.setVisible(false);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void listarProdutos01() {
		DefaultListModel<String> modelo = new DefaultListModel<>();
		listaUsuarios01.setModel(modelo);
		String readLista = "select * from estoques where produto like '" + txtProduto01.getText() + "%'"
				+ " order by produto";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(readLista);
			rs = pst.executeQuery(readLista);
			while (rs.next()) {
				scrollPane01.setVisible(true);
				modelo.addElement(rs.getString(3));
				if (txtProduto01.getText().isEmpty()) {
					scrollPane01.setVisible(false);
				}
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void buscarProdutosLista01() {
		if (txtProduto01.getText().isEmpty()) {
		} else {
			int linha = listaUsuarios01.getSelectedIndex();
			if (linha >= 0) {
				String read01 = "select produto, codebarra from estoques where produto like '" + txtProduto01.getText()
						+ "%'" + "order by produto limit " + (linha) + " , 1";
				try {
					con = dao.conectar();
					pst = con.prepareStatement(read01);
					rs = pst.executeQuery();
					if (rs.next()) {
						scrollPane01.setVisible(false);
						txtBarra01.setText(rs.getString(2));
						txtProduto01.setText(rs.getString(1));

					} else {
						JOptionPane.showMessageDialog(null, "Produto Inexistente");
						btnCreate.setEnabled(true);
					}
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			} else {
				scrollPane01.setVisible(false);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void listarProdutos02() {
		DefaultListModel<String> modelo = new DefaultListModel<>();
		listaUsuarios02.setModel(modelo);
		String readLista = "select * from estoques where produto like '" + txtProduto02.getText() + "%'"
				+ " order by produto";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(readLista);
			rs = pst.executeQuery(readLista);
			while (rs.next()) {
				scrollPane02.setVisible(true);
				modelo.addElement(rs.getString(3));
				if (txtProduto02.getText().isEmpty()) {
					scrollPane02.setVisible(false);
				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void buscarProdutosLista02() {
		if (txtProduto02.getText().isEmpty()) {
		} else {
			int linha = listaUsuarios02.getSelectedIndex();
			if (linha >= 0) {
				String read02 = "select * from estoques where produto like '" + txtProduto02.getText() + "%'"
						+ "order by produto limit " + (linha) + " , 1";
				try {
					con = dao.conectar();
					pst = con.prepareStatement(read02);
					rs = pst.executeQuery();
					if (rs.next()) {
						scrollPane02.setVisible(false);
						txtBarra02.setText(rs.getString(4));
						txtProduto02.setText(rs.getString(3));
					} else {
						JOptionPane.showMessageDialog(null, "Produto Inexistente");
						btnCreate.setEnabled(true);
					}
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			} else {
				scrollPane02.setVisible(false);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void listarProdutos03() {
		DefaultListModel<String> modelo = new DefaultListModel<>();
		listaUsuarios03.setModel(modelo);
		String readLista = "select * from estoques where produto like '" + txtProduto03.getText() + "%'"
				+ " order by produto";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(readLista);
			rs = pst.executeQuery(readLista);
			while (rs.next()) {
				scrollPane03.setVisible(true);
				modelo.addElement(rs.getString(3));
				if (txtProduto03.getText().isEmpty()) {
					scrollPane03.setVisible(false);
				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void buscarProdutosLista03() {
		if (txtProduto03.getText().isEmpty()) {
		} else {
			int linha = listaUsuarios03.getSelectedIndex();
			if (linha >= 0) {
				String read3 = "select * from estoques where produto like '" + txtProduto03.getText() + "%'"
						+ "order by produto limit " + (linha) + " , 1";
				try {
					con = dao.conectar();
					pst = con.prepareStatement(read3);
					rs = pst.executeQuery();
					if (rs.next()) {
						scrollPane03.setVisible(false);
						txtBarra03.setText(rs.getString(4));
						txtProduto03.setText(rs.getString(3));
					} else {
						JOptionPane.showMessageDialog(null, "Produto Inexistente");
						btnCreate.setEnabled(true);
					}
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			} else {
				scrollPane03.setVisible(false);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void listarProdutos04() {
		DefaultListModel<String> modelo = new DefaultListModel<>();
		listaUsuarios04.setModel(modelo);
		String readLista = "select * from estoques where produto like '" + txtProduto04.getText() + "%'"
				+ " order by produto";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(readLista);
			rs = pst.executeQuery(readLista);
			while (rs.next()) {
				scrollPane04.setVisible(true);
				modelo.addElement(rs.getString(3));
				if (txtProduto04.getText().isEmpty()) {
					scrollPane04.setVisible(false);
				}
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void buscarProdutosLista04() {
		if (txtProduto04.getText().isEmpty()) {
		} else {
			int linha = listaUsuarios04.getSelectedIndex();
			if (linha >= 0) {
				String read04 = "select * from estoques where produto like '" + txtProduto04.getText() + "%'"
						+ "order by produto limit " + (linha) + " , 1";
				try {
					con = dao.conectar();
					pst = con.prepareStatement(read04);
					rs = pst.executeQuery();
					if (rs.next()) {
						scrollPane04.setVisible(false);
						txtBarra04.setText(rs.getString(4));
						txtProduto04.setText(rs.getString(3));
					} else {
						JOptionPane.showMessageDialog(null, "Produto Inexistente");
						btnCreate.setEnabled(true);
					}
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			} else {
				scrollPane04.setVisible(false);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void listarProdutos05() {
		DefaultListModel<String> modelo = new DefaultListModel<>();
		listaUsuarios05.setModel(modelo);
		String readLista = "select * from estoques where produto like '" + txtProduto05.getText() + "%'"
				+ " order by produto";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(readLista);
			rs = pst.executeQuery(readLista);
			while (rs.next()) {
				scrollPane05.setVisible(true);
				modelo.addElement(rs.getString(3));
				if (txtProduto05.getText().isEmpty()) {
					scrollPane05.setVisible(false);
				}
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void buscarProdutosLista05() {
		if (txtProduto02.getText().isEmpty()) {
		} else {
			int linha = listaUsuarios05.getSelectedIndex();
			if (linha >= 0) {
				String read05 = "select * from estoques where produto like '" + txtProduto05.getText() + "%'"
						+ "order by produto limit " + (linha) + " , 1";
				try {
					con = dao.conectar();
					pst = con.prepareStatement(read05);
					rs = pst.executeQuery();
					if (rs.next()) {
						scrollPane05.setVisible(false);
						txtBarra05.setText(rs.getString(4));
						txtProduto05.setText(rs.getString(3));
					} else {
						JOptionPane.showMessageDialog(null, "Produto Inexistente");
						btnCreate.setEnabled(true);
					}
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			} else {
				scrollPane05.setVisible(false);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void listarProdutos06() {
		DefaultListModel<String> modelo = new DefaultListModel<>();
		listaUsuarios06.setModel(modelo);
		String readLista = "select * from estoques where produto like '" + txtProduto06.getText() + "%'"
				+ " order by produto";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(readLista);
			rs = pst.executeQuery(readLista);
			while (rs.next()) {
				scrollPane06.setVisible(true);
				modelo.addElement(rs.getString(3));
				if (txtProduto06.getText().isEmpty()) {
					scrollPane06.setVisible(false);
				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void buscarProdutosLista06() {
		if (txtProduto06.getText().isEmpty()) {

		} else {
			int linha = listaUsuarios06.getSelectedIndex();
			if (linha >= 0) {
				String read6 = "select * from estoques where produto like '" + txtProduto06.getText() + "%'"
						+ "order by produto limit " + (linha) + " , 1";
				try {
					con = dao.conectar();
					pst = con.prepareStatement(read6);
					rs = pst.executeQuery();
					if (rs.next()) {
						scrollPane06.setVisible(false);
						txtBarra06.setText(rs.getString(4));
						txtProduto06.setText(rs.getString(3));
					} else {
						JOptionPane.showMessageDialog(null, "Produto Inexistente");
						btnCreate.setEnabled(true);
					}
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			} else {
				scrollPane03.setVisible(false);
			}
		}
	}

	private void adicionarOS() {
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome do CLiente");
			txtIDcli.requestFocus();
		} else if (txtIDcli.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o ID do CLiente");
			txtIDcli.requestFocus();
		} else if (txtMarca.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Marca do Equipamento");
			txtMarca.requestFocus();
		} else if (txtModelo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Modelo do Equipamento");
			txtModelo.requestFocus();
		} else if (cboStatus.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o Status do Equipamento");
			cboStatus.requestFocus();
		} else if (cboServico.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o Tipo de Serviço");
			cboServico.requestFocus();
		} else if (cboServico.getSelectedItem().equals("MANUTENÇÃO CORRETIVA") && txtDefeito.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Defeito");
			txtDefeito.requestFocus();
		} else {
			String create = "insert into servicos(idcli, defeito, diagnostico, statusOS, valor, dataOSsaida, marcaOS, modeloOS, serie, idtec, usuario, nomecli, nometec, tiposervico, observacao, codbarra1, produto1, quant1, codbarra2, produto2, quant2, codbarra3, produto3, quant3, codbarra4, produto4, quant4, codbarra5, produto5, quant5, codbarra6, produto6, quant6, totalpeca, total, tipoOS, totalp01, totalp02, totalp03, totalp04, totalp05, totalp06, tipopagamento, totalpago, troco) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(create);
				pst.setString(1, txtIDcli.getText());
				pst.setString(2, txtDefeito.getText());
				pst.setString(3, txtDiagnostico.getText());
				pst.setString(4, cboStatus.getSelectedItem().toString());
				pst.setString(5, txtValorServico.getText());
				pst.setString(7, txtMarca.getText());
				pst.setString(8, txtModelo.getText());
				pst.setString(9, txtSerie.getText());
				pst.setString(10, txtIDtec.getText());
				pst.setString(11, txtUser.getText());
				pst.setString(12, txtNome.getText());
				pst.setString(13, txtTecnico.getText());
				pst.setString(14, cboServico.getSelectedItem().toString());
				pst.setString(15, txtObs.getText());
				pst.setString(16, txtBarra01.getText());
				pst.setString(17, txtProduto01.getText());
				pst.setString(18, cboQuant1.getSelectedItem().toString());
				pst.setString(19, txtBarra02.getText());
				pst.setString(20, txtProduto02.getText());
				pst.setString(21, cboQuant2.getSelectedItem().toString());
				pst.setString(22, txtBarra03.getText());
				pst.setString(23, txtProduto03.getText());
				pst.setString(24, cboQuant3.getSelectedItem().toString());
				pst.setString(25, txtBarra04.getText());
				pst.setString(26, txtProduto04.getText());
				pst.setString(27, cboQuant4.getSelectedItem().toString());
				pst.setString(28, txtBarra05.getText());
				pst.setString(29, txtProduto05.getText());
				pst.setString(30, cboQuant5.getSelectedItem().toString());
				pst.setString(31, txtBarra06.getText());
				pst.setString(32, txtProduto06.getText());
				pst.setString(33, cboQuant6.getSelectedItem().toString());
				pst.setString(34, txtValorPecaTotal.getText());
				pst.setString(35, txtTotal.getText());
				pst.setString(36, tipo);
				pst.setString(37, txtValorPeca01.getText());
				pst.setString(38, txtValorPeca02.getText());
				pst.setString(39, txtValorPeca03.getText());
				pst.setString(40, txtValorPeca04.getText());
				pst.setString(41, txtValorPeca05.getText());
				pst.setString(42, txtValorPeca06.getText());
				pst.setString(43, cboTipoPag.getSelectedItem().toString());
				pst.setString(44, txtPago.getText());
				pst.setString(45, txtTroco.getText());
				SimpleDateFormat formatador = new SimpleDateFormat("yyyyMMdd");
				if (txtDataSaida.getDate() == null) {
					pst.setString(6, null);
				} else {
					String dataFormatada = formatador.format(txtDataSaida.getDate());
					pst.setString(6, dataFormatada);
				}
				if (!cboStatus.getSelectedItem().equals("AGUARDANDO DIAGNOSTICO") && txtIDtec.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o Tecnico");
					txtIDtec.requestFocus();
				} else {
					pst.setString(10, txtIDtec.getText());
					if (txtIDtec.getText().equals("")) {
						pst.setString(10, null);
					} else {
						pst.setString(10, txtIDtec.getText());
					}
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Ordem de Serviço Cadastrada com Sucesso");
					limparCampos();
					recuperarOS();
					btnOS.setEnabled(true);
					con.close();
				}
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}

	private void editarOS() {

		if (txtIDcli.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o ID do CLiente");
			txtIDcli.requestFocus();
		} else if (txtMarca.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Marca do Equipamento");
			txtMarca.requestFocus();
		} else if (txtModelo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Modelo do Equipamento");
			txtModelo.requestFocus();
		} else if (cboStatus.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o Status do Aparelho");
			cboStatus.requestFocus();
		} else if (cboServico.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o Tipo de Serviço");
			cboServico.requestFocus();
		} else if (cboServico.getSelectedItem().equals("MANUTENÇÃO CORRETIVA") && txtDefeito.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Defeito");
			txtDefeito.requestFocus();
		} else {
			String update = "update servicos set idcli=?, defeito=?, diagnostico=?, statusOS=?, valor=?, dataOSsaida=?, marcaOS=?, modeloOS=?, serie=?, idtec=?, usuario=?, nomecli=?, nometec=?, tiposervico=?, observacao=?, codbarra1=?, produto1=?, quant1=?, codbarra2=?, produto2=?, quant2=?, codbarra3=?, produto3=?, quant3=?, codbarra4=?, produto4=?, quant4=?, codbarra5=?, produto5=?, quant5=?, codbarra6=?, produto6=?, quant6=?, totalpeca=?, total=?, tipoOS=?, totalp01=?, totalp02=?, totalp03=?, totalp04=?, totalp05=?, totalp06=?, tipopagamento=?, totalpago=?, troco=? where os = ?";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(update);
				pst.setString(1, txtIDcli.getText());
				pst.setString(2, txtDefeito.getText());
				pst.setString(3, txtDiagnostico.getText());
				pst.setString(4, cboStatus.getSelectedItem().toString());
				pst.setString(5, txtValorServico.getText());
				pst.setString(7, txtMarca.getText());
				pst.setString(8, txtModelo.getText());
				pst.setString(9, txtSerie.getText());
				pst.setString(11, txtUser.getText());
				pst.setString(12, txtNome.getText());
				pst.setString(13, txtTecnico.getText());
				pst.setString(14, cboServico.getSelectedItem().toString());
				pst.setString(15, txtObs.getText());
				pst.setString(16, txtBarra01.getText());
				pst.setString(17, txtProduto01.getText());
				pst.setString(18, cboQuant1.getSelectedItem().toString());
				pst.setString(19, txtBarra02.getText());
				pst.setString(20, txtProduto02.getText());
				pst.setString(21, cboQuant2.getSelectedItem().toString());
				pst.setString(22, txtBarra03.getText());
				pst.setString(23, txtProduto03.getText());
				pst.setString(24, cboQuant3.getSelectedItem().toString());
				pst.setString(25, txtBarra04.getText());
				pst.setString(26, txtProduto04.getText());
				pst.setString(27, cboQuant4.getSelectedItem().toString());
				pst.setString(28, txtBarra05.getText());
				pst.setString(29, txtProduto05.getText());
				pst.setString(30, cboQuant5.getSelectedItem().toString());
				pst.setString(31, txtBarra06.getText());
				pst.setString(32, txtProduto06.getText());
				pst.setString(33, cboQuant6.getSelectedItem().toString());
				pst.setString(34, txtValorPecaTotal.getText());
				pst.setString(35, txtTotal.getText());
				pst.setString(36, tipo);
				pst.setString(37, txtValorPeca01.getText());
				pst.setString(38, txtValorPeca02.getText());
				pst.setString(39, txtValorPeca03.getText());
				pst.setString(40, txtValorPeca04.getText());
				pst.setString(41, txtValorPeca05.getText());
				pst.setString(42, txtValorPeca06.getText());
				pst.setString(43, cboTipoPag.getSelectedItem().toString());
				pst.setString(44, txtPago.getText());
				pst.setString(45, txtTroco.getText());
				pst.setString(46, txtOS.getText());
				SimpleDateFormat formatador = new SimpleDateFormat("yyyyMMdd");
				if (txtDataSaida.getDate() == null) {
					pst.setString(6, null);
				} else {
					String dataFormatada = formatador.format(txtDataSaida.getDate());
					pst.setString(6, dataFormatada);
				}
				if (!cboStatus.getSelectedItem().equals("AGUARDANDO DIAGNOSTICO") && txtIDtec.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o Tecnico");
					txtIDtec.requestFocus();
				} else {
					pst.setString(10, txtIDtec.getText());
					if (txtIDtec.getText().equals("")) {
						pst.setString(10, null);
					} else {
						pst.setString(10, txtIDtec.getText());
					}
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Dados da Ordem de Serviço alterado com Sucesso");
					con.close();
					limparCampos();
					btnOS.setEnabled(true);
				}
			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null,
						"Ordem de Serviço não atualizada. \nEste Numero de OS está sendo Utilizado.");
				txtOS.setText(null);
				txtOS.requestFocus();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}

	private void excluirOS() {
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão desse usuário?", "ATENÇÃO!",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from servicos where os=?";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(delete);
				pst.setString(1, txtOS.getText());
				pst.executeUpdate();
				limparCampos();
				JOptionPane.showMessageDialog(null, "Ordem de Serviço excluído");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void imprimirOS() {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("os.pdf"));
			document.open();
			String readOS = "select servicos.os,date_format(servicos.dataOS, '%d/%m/%Y %H:%i') as data_entrada, servicos.usuario, servicos.MarcaOS, servicos.ModeloOS, servicos.serie, servicos.defeito, clientes.nome as cliente, clientes.cpf as cpf, servicos.tiposervico as tipoServico, clientes.telefone1 as telefone, clientes.telefone2 as telefone2, clientes.email as email, clientes.endereco as endereco, clientes.numeroendereco as Numero, clientes.bairro as Bairro, clientes.cidade as cidade, clientes.uf as uf, clientes.cep as cep, clientes.complemento as complemento, tecnicos.nome as Técnico, servicos.diagnostico, date_format(dataOSsaida,'%d/%m/%Y') as data_saida, valor, tipoOS, observacao, produto1, quant1, totalp01, produto2, quant2, totalp02, produto3, quant3, totalp03, produto4, quant4, totalp04, produto5, quant5, totalp05, produto6, quant6, totalp06, total, tipopagamento, totalpago, totalpeca from servicos inner join clientes on servicos.idcli = clientes.idcli inner join tecnicos on servicos.idtec = tecnicos.idtec where os = ?;";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readOS);
				pst.setString(1, txtOS.getText());
				rs = pst.executeQuery();
				if (rs.next()) {
					Paragraph tipOs = new Paragraph(
							"-----   " + rs.getString(25) + "   -----   ID: " + rs.getString(1) + "   -----");
					tipOs.setAlignment(Element.ALIGN_CENTER);
					document.add(tipOs);
					Image image = Image.getInstance(Servico.class.getResource("/img/logo_Air_Cond.png"));
					image.scaleToFit(192, 148);
					image.setAbsolutePosition(440, 690);
					document.add(image);
					Paragraph usuario = new Paragraph(
							"Usuário: " + rs.getString(3) + "          Data de Emissão: " + rs.getString(2));
					document.add(usuario);
					Paragraph TipoServico = new Paragraph(" Tipo de Serviço: " + rs.getString(10));
					document.add(TipoServico);
					document.add(new Paragraph("_______________________________________________________________"));
					Paragraph TitleCli = new Paragraph("DADOS DO CLIENTE");
					TitleCli.setAlignment(Element.ALIGN_CENTER);
					document.add(TitleCli);
					Paragraph DadosCli = new Paragraph("CLIENTE:  " + rs.getString(8) + "     CPF: " + rs.getString(9));
					document.add(DadosCli);
					Paragraph DadosCli2 = new Paragraph(
							"FONE 1: " + rs.getString(11) + "  FONE 2: " + rs.getString(12));
					document.add(DadosCli2);
					Paragraph DadosCli3 = new Paragraph("EMAIL: " + rs.getString(13));
					document.add(DadosCli3);
					Paragraph EndCli = new Paragraph("ENDEREÇO:  " + rs.getString(14) + "   N°: " + rs.getString(15));
					document.add(EndCli);
					Paragraph EndCli2 = new Paragraph("BAIRRO: " + rs.getString(16) + "     CIDADE: " + rs.getString(17)
							+ "   UF: " + rs.getString(18));
					document.add(EndCli2);
					document.add(new Paragraph(
							"_____________________________________________________________________________"));
					Paragraph TitleSmart = new Paragraph("DADOS DO EQUIPAMENTO");
					TitleSmart.setAlignment(Element.ALIGN_CENTER);
					document.add(TitleSmart);
					Paragraph DadosSmart = new Paragraph("MARCA:  " + rs.getString(4) + "     MODELO: "
							+ rs.getString(5) + "     N° SÉRIE: " + rs.getString(6));
					document.add(DadosSmart);
					if (rs.getString(7).equals("INSTALAÇÃO") || rs.getString(7).equals("REMOÇÃO / REALOCAÇÃO")
							|| rs.getString(7).equals("MANUTENÇÃO PREVENTIVA")) {
					} else {
						if (rs.getString(7).equals(null)) {
						} else {
							Paragraph DefeitoSmart = new Paragraph("DEFEITO: " + rs.getString(7));
							document.add(DefeitoSmart);
						}
					}
					document.add(new Paragraph(
							"_____________________________________________________________________________"));

					if (rs.getString(7).equals("INSTALAÇÃO") || rs.getString(7).equals("REMOÇÃO / REALOCAÇÃO")
							|| rs.getString(7).equals("MANUTENÇÃO PREVENTIVA")) {
					} else {
						Paragraph TitleDiag = new Paragraph("DIAGNOSTICO");
						TitleDiag.setAlignment(Element.ALIGN_CENTER);
						document.add(TitleDiag);
					}
					document.add(new Paragraph(" "));
					Paragraph TecSmart = new Paragraph("TÉCNICO :  " + rs.getString(21));
					document.add(TecSmart);
					if (rs.getString(7).equals("INSTALAÇÃO") || rs.getString(7).equals("REMOÇÃO / REALOCAÇÃO")
							|| rs.getString(7).equals("MANUTENÇÃO PREVENTIVA")) {
					} else {
						if (rs.getString(22) == null) {
						} else {
							Paragraph DiagSmart = new Paragraph("DIAGNOSTICO :  " + rs.getString(22));
							document.add(DiagSmart);
						}
					}
					if (rs.getString(26) == null) {
						Paragraph OBS1 = new Paragraph("OBSERVAÇÃO: ________________________________________________");
						document.add(OBS1);
					} else {
						Paragraph OBS1 = new Paragraph("OBSERVAÇÃO: " + rs.getString(26));
						Paragraph OBS3 = new Paragraph("________________________________________________");
						document.add(OBS1);
						document.add(OBS3);
					}
					document.add(new Paragraph(
							"_____________________________________________________________________________"));
					document.add(new Paragraph(" "));
					Paragraph TitleDiag = new Paragraph("PEÇAS");
					TitleDiag.setAlignment(Element.ALIGN_CENTER);
					document.add(TitleDiag);
					document.add(new Paragraph(" "));
					PdfPTable table = new PdfPTable(3);
					PdfPCell col1 = new PdfPCell(new Paragraph("PRODUTO"));
					PdfPCell col2 = new PdfPCell(new Paragraph("QUANTIDADE"));
					PdfPCell col3 = new PdfPCell(new Paragraph("VALOR"));
					table.addCell(col1);
					table.addCell(col2);
					table.addCell(col3);
					if (rs.getString(29).equals("0.00")) {
					} else {
						table.addCell(rs.getString(27));
						table.addCell(rs.getString(28));
						table.addCell(rs.getString(29));
					}
					if (rs.getString(32).equals("0.00")) {
					} else {
						table.addCell(rs.getString(30));
						table.addCell(rs.getString(31));
						table.addCell(rs.getString(32));
					}
					if (rs.getString(35).equals("0.00")) {
					} else {
						table.addCell(rs.getString(33));
						table.addCell(rs.getString(34));
						table.addCell(rs.getString(35));
					}
					if (rs.getString(38).equals("0.00")) {
					} else {
						table.addCell(rs.getString(36));
						table.addCell(rs.getString(37));
						table.addCell(rs.getString(38));
					}
					if (rs.getString(41).equals("0.00")) {
					} else {
						table.addCell(rs.getString(39));
						table.addCell(rs.getString(40));
						table.addCell(rs.getString(41));
					}
					if (rs.getString(44).equals("0.00")) {
					} else {
						table.addCell(rs.getString(42));
						table.addCell(rs.getString(43));
						table.addCell(rs.getString(44));
					}
					document.add(table);
					document.add(new Paragraph(
							"_____________________________________________________________________________"));

					document.add(new Paragraph(" "));
					if (rs.getString(23) == null) {
						Paragraph DataSaida = new Paragraph("DATA DE SAÍDA :  " + " ");
						document.add(DataSaida);
					} else {
						Paragraph DataSaida = new Paragraph("DATA DE SAÍDA :  " + rs.getString(23));
						document.add(DataSaida);
					}
					if (rs.getString(24) == "0.00") {
						Paragraph ValorSmart = new Paragraph("VALOR SERVIÇO:  " + " ");
						document.add(ValorSmart);
					} else {
						Paragraph ValorSmart = new Paragraph("VALOR SERVIÇO :  R$ " + rs.getString(24)
								+ "               VALOR TOTAL PEÇAS :  R$ " + rs.getString(48));
						document.add(ValorSmart);
					}
					if (rs.getString(45) == "0.00") {
						Paragraph ValorSmart = new Paragraph("VALOR TOTAL:  " + " ");
						document.add(ValorSmart);
					} else {
						Paragraph ValorSmart = new Paragraph("VALOR TOTAL :  R$ " + rs.getString(45));
						document.add(ValorSmart);
					}
					if (rs.getString(47) == "0.00") {
						Paragraph ValorSmart = new Paragraph(
								"VALOR PAGO:  " + " " + "          FORMA DE PAGAMENTO:" + " ");
						document.add(ValorSmart);
					} else {
						Paragraph ValorSmart = new Paragraph("VALOR PAGO :  R$ " + rs.getString(47)
								+ "               FORMA DE PAGAMENTO:  " + rs.getString(46));
						document.add(ValorSmart);
					}
					document.add(new Paragraph(" "));
					document.add(new Paragraph("ASSINATURA DO CLIENTE : __________________________________________"));
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		document.close();
		try {
			 File pdfFile = new File("os.pdf");
	         Desktop.getDesktop().open(pdfFile);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private void recuperarOS() {
		String readOS = "select max(os) from servicos;";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(readOS);
			rs = pst.executeQuery();
			if (rs.next()) {
				txtOS.setText(rs.getString(1));
			} else {
				JOptionPane.showMessageDialog(null, "OS inexistente");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void contEstoque1() {
		if (cboStatus.getSelectedItem().equals("FINALIZADO")) {
			String read01 = "update estoques set estoques.estoque = estoques.estoque-" + cboQuant1.getSelectedItem()
					+ " where estoques.codebarra ='" + txtBarra01.getText() + "'";
			if (!txtBarra01.getText().isEmpty() && !cboQuant1.getSelectedItem().equals(null)) {
				try {
					con = dao.conectar();
					pst = con.prepareStatement(read01);
					pst.executeUpdate(read01);
					JOptionPane.showMessageDialog(null, "Estoque Calculado");
					con.close();
				} catch (Exception e) {
					System.out.println(e);

				}
			}
		}
	}

	private void contEstoque2() {
		if (cboStatus.getSelectedItem().equals("FINALIZADO")) {
			String read02 = "update estoques set estoques.estoque = estoques.estoque-" + cboQuant2.getSelectedItem()
					+ " where estoques.codebarra ='" + txtBarra02.getText() + "'";
			if (!txtBarra02.getText().isEmpty() && !cboQuant2.getSelectedItem().equals(null)) {
				try {
					pst = con.prepareStatement(read02);
					JOptionPane.showMessageDialog(null, "Estoque Calculado");
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			} else {
			}
		} else {
		}
	}

	private void contEstoque3() {
		if (cboStatus.getSelectedItem().equals("FINALIZADO")) {
			String read03 = "update estoques set estoques.estoque = estoques.estoque-" + cboQuant3.getSelectedItem()
					+ " where estoques.codebarra ='" + txtBarra03.getText() + "'";
			if (!txtBarra03.getText().isEmpty() && !cboQuant3.getSelectedItem().equals(null)) {
				try {
					pst = con.prepareStatement(read03);
					JOptionPane.showMessageDialog(null, "Estoque Calculado");
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}

	private void contEstoque4() {
		if (cboStatus.getSelectedItem().equals("FINALIZADO")) {
			String read04 = "update estoques set estoques.estoque = estoques.estoque-" + cboQuant4.getSelectedItem()
					+ " where estoques.codebarra ='" + txtBarra04.getText() + "'";
			if (!txtBarra04.getText().isEmpty() && !cboQuant4.getSelectedItem().equals(null)) {
				try {
					pst = con.prepareStatement(read04);
					JOptionPane.showMessageDialog(null, "Estoque Calculado");
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}

	private void contEstoque5() {
		if (cboStatus.getSelectedItem().equals("FINALIZADO")) {
			String read05 = "update estoques set estoques.estoque = estoques.estoque-" + cboQuant5.getSelectedItem()
					+ " where estoques.codebarra ='" + txtBarra05.getText() + "'";
			if (!txtBarra05.getText().isEmpty() && !cboQuant5.getSelectedItem().equals(null)) {
				try {
					pst = con.prepareStatement(read05);
					JOptionPane.showMessageDialog(null, "Estoque Calculado");
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}

	private void contEstoque6() {
		if (cboStatus.getSelectedItem().equals("FINALIZADO")) {
			String read06 = "update estoques set estoques.estoque = estoques.estoque-" + cboQuant6.getSelectedItem()
					+ " where estoques.codebarra ='" + txtBarra06.getText() + "'";
			if (!txtBarra06.getText().isEmpty() && !cboQuant6.getSelectedItem().equals(null)) {
				try {
					pst = con.prepareStatement(read06);
					JOptionPane.showMessageDialog(null, "Estoque Calculado");
					con.close();
				} catch (Exception e) {
					System.out.println(e);

				}
			}
		}
	}

	private void ValorProduto1() {
		String read01 = "select estoques.valor*'" + cboQuant1.getSelectedItem()
				+ "'from estoques where estoques.codebarra='" + txtBarra01.getText() + "'";
		if (!txtBarra01.getText().isEmpty() && !cboQuant1.getSelectedItem().equals(null)) {
			try {
				con = dao.conectar();
				pst = con.prepareStatement(read01);
				ResultSet resultSet2 = pst.executeQuery();
				if (resultSet2.next()) {
					txtValorPeca01.setText(resultSet2.getString(1));
				}
				resultSet2.close();
				double totalvalor01 = Double.valueOf(txtValorPeca01.getText()).doubleValue();
				double totalvalor02 = Double.valueOf(txtValorPeca02.getText()).doubleValue();
				double totalvalor03 = Double.valueOf(txtValorPeca03.getText()).doubleValue();
				double totalvalor04 = Double.valueOf(txtValorPeca04.getText()).doubleValue();
				double totalvalor05 = Double.valueOf(txtValorPeca05.getText()).doubleValue();
				double totalvalor06 = Double.valueOf(txtValorPeca06.getText()).doubleValue();
				double resultado = totalvalor01 + totalvalor02 + totalvalor03 + totalvalor04 + totalvalor05
						+ totalvalor06;
				String resultadoValor = Double.toString(resultado);
				txtValorPecaTotal.setText(resultadoValor);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void ValorProduto2() {
		String read01 = "select estoques.valor*'" + cboQuant2.getSelectedItem()
				+ "'from estoques where estoques.codebarra='" + txtBarra02.getText() + "'";
		if (!txtBarra02.getText().isEmpty() && !cboQuant2.getSelectedItem().equals(null)) {
			try {
				con = dao.conectar();
				pst = con.prepareStatement(read01);
				rs = pst.executeQuery();
				if (rs.next()) {
					txtValorPeca02.setText(rs.getString(1));
				}
				con.close();
				double totalvalor01 = Double.valueOf(txtValorPeca01.getText()).doubleValue();
				double totalvalor02 = Double.valueOf(txtValorPeca02.getText()).doubleValue();
				double totalvalor03 = Double.valueOf(txtValorPeca03.getText()).doubleValue();
				double totalvalor04 = Double.valueOf(txtValorPeca04.getText()).doubleValue();
				double totalvalor05 = Double.valueOf(txtValorPeca05.getText()).doubleValue();
				double totalvalor06 = Double.valueOf(txtValorPeca06.getText()).doubleValue();
				double resultado = totalvalor01 + totalvalor02 + totalvalor03 + totalvalor04 + totalvalor05
						+ totalvalor06;
				String resultadoValor = Double.toString(resultado);
				txtValorPecaTotal.setText(resultadoValor);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void ValorProduto3() {
		String read01 = "select estoques.valor*'" + cboQuant3.getSelectedItem()
				+ "'from estoques where estoques.codebarra='" + txtBarra03.getText() + "'";
		if (!txtBarra03.getText().isEmpty() && !cboQuant3.getSelectedItem().equals(null)) {
			try {
				con = dao.conectar();
				pst = con.prepareStatement(read01);
				rs = pst.executeQuery();
				if (rs.next()) {
					txtValorPeca03.setText(rs.getString(1));
				}
				con.close();
				double totalvalor01 = Double.valueOf(txtValorPeca01.getText()).doubleValue();
				double totalvalor02 = Double.valueOf(txtValorPeca02.getText()).doubleValue();
				double totalvalor03 = Double.valueOf(txtValorPeca03.getText()).doubleValue();
				double totalvalor04 = Double.valueOf(txtValorPeca04.getText()).doubleValue();
				double totalvalor05 = Double.valueOf(txtValorPeca05.getText()).doubleValue();
				double totalvalor06 = Double.valueOf(txtValorPeca06.getText()).doubleValue();
				double resultado = totalvalor01 + totalvalor02 + totalvalor03 + totalvalor04 + totalvalor05
						+ totalvalor06;
				String resultadoValor = Double.toString(resultado);
				txtValorPecaTotal.setText(resultadoValor);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void ValorProduto4() {
		String read01 = "select estoques.valor*'" + cboQuant4.getSelectedItem()
				+ "'from estoques where estoques.codebarra='" + txtBarra04.getText() + "'";
		if (!txtBarra04.getText().isEmpty() && !cboQuant4.getSelectedItem().equals(null)) {
			try {
				con = dao.conectar();
				pst = con.prepareStatement(read01);
				rs = pst.executeQuery();
				if (rs.next()) {
					txtValorPeca04.setText(rs.getString(1));
				}
				con.close();
				double totalvalor01 = Double.valueOf(txtValorPeca01.getText()).doubleValue();
				double totalvalor02 = Double.valueOf(txtValorPeca02.getText()).doubleValue();
				double totalvalor03 = Double.valueOf(txtValorPeca03.getText()).doubleValue();
				double totalvalor04 = Double.valueOf(txtValorPeca04.getText()).doubleValue();
				double totalvalor05 = Double.valueOf(txtValorPeca05.getText()).doubleValue();
				double totalvalor06 = Double.valueOf(txtValorPeca06.getText()).doubleValue();
				double resultado = totalvalor01 + totalvalor02 + totalvalor03 + totalvalor04 + totalvalor05
						+ totalvalor06;
				String resultadoValor = Double.toString(resultado);
				txtValorPecaTotal.setText(resultadoValor);
			} catch (Exception e) {
				System.out.println(e);

			}
		}
	}

	private void ValorProduto5() {
		String read01 = "select estoques.valor*'" + cboQuant5.getSelectedItem()
				+ "'from estoques where estoques.codebarra='" + txtBarra05.getText() + "'";
		if (!txtBarra05.getText().isEmpty() && !cboQuant5.getSelectedItem().equals(null)) {
			try {
				con = dao.conectar();
				pst = con.prepareStatement(read01);
				rs = pst.executeQuery();
				if (rs.next()) {
					txtValorPeca05.setText(rs.getString(1));
				}
				con.close();
				double totalvalor01 = Double.valueOf(txtValorPeca01.getText()).doubleValue();
				double totalvalor02 = Double.valueOf(txtValorPeca02.getText()).doubleValue();
				double totalvalor03 = Double.valueOf(txtValorPeca03.getText()).doubleValue();
				double totalvalor04 = Double.valueOf(txtValorPeca04.getText()).doubleValue();
				double totalvalor05 = Double.valueOf(txtValorPeca05.getText()).doubleValue();
				double totalvalor06 = Double.valueOf(txtValorPeca06.getText()).doubleValue();
				double resultado = totalvalor01 + totalvalor02 + totalvalor03 + totalvalor04 + totalvalor05
						+ totalvalor06;
				String resultadoValor = Double.toString(resultado);
				txtValorPecaTotal.setText(resultadoValor);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void ValorProduto6() {
		String read01 = "select estoques.valor*'" + cboQuant6.getSelectedItem()
				+ "'from estoques where estoques.codebarra='" + txtBarra06.getText() + "'";
		if (cboQuant6.getSelectedItem().equals(" ")) {
			txtValorPeca06.setText("0");
		}
		if (!txtBarra06.getText().isEmpty() && !cboQuant6.getSelectedItem().equals(null)) {
			try {
				con = dao.conectar();
				pst = con.prepareStatement(read01);
				rs = pst.executeQuery();
				if (rs.next()) {
					txtValorPeca06.setText(rs.getString(1));
				}
				con.close();
				double totalvalor01 = Double.valueOf(txtValorPeca01.getText()).doubleValue();
				double totalvalor02 = Double.valueOf(txtValorPeca02.getText()).doubleValue();
				double totalvalor03 = Double.valueOf(txtValorPeca03.getText()).doubleValue();
				double totalvalor04 = Double.valueOf(txtValorPeca04.getText()).doubleValue();
				double totalvalor05 = Double.valueOf(txtValorPeca05.getText()).doubleValue();
				double totalvalor06 = Double.valueOf(txtValorPeca06.getText()).doubleValue();
				double resultado = totalvalor01 + totalvalor02 + totalvalor03 + totalvalor04 + totalvalor05
						+ totalvalor06;
				String resultadoValor = Double.toString(resultado);
				txtValorPecaTotal.setText(resultadoValor);
			} catch (Exception e) {
				System.out.println(e);

			}
		}
	}

	private void totalValor() {
		if (!txtValorServico.getText().equals("0")) {
			double totalvalor01 = Double.valueOf(txtValorPecaTotal.getText()).doubleValue();
			double totalvalor02 = Double.valueOf(txtValorServico.getText()).doubleValue();
			double resultado = totalvalor01 + totalvalor02;
			String resultadoValor = Double.toString(resultado);
			txtTotal.setText(resultadoValor);
		} else {

		}
	}

	private void valorPago() {
		if (!txtValorServico.getText().equals("0")) {
			double totalvalor01 = Double.valueOf(txtTotal.getText()).doubleValue();
			double totalvalor02 = Double.valueOf(txtPago.getText()).doubleValue();
			double resultado = totalvalor02 - totalvalor01;
			String resultadoValor = Double.toString(resultado);
			if (resultado > 0) {
				txtTroco.setText(resultadoValor);
			} else {
				txtTroco.setText("0");
			}
		} else {
		}
	}

	private void Produto1Estoque() {
		String read03 = "SELECT estoques.estoque FROM estoques WHERE codebarra =  '" + txtBarra01.getText() + "'";
		String quantidadeSelecionadaStr = cboQuant1.getSelectedItem().toString();
		if (!txtBarra01.getText().isEmpty() && !cboQuant1.getSelectedItem().equals(null)) {
			try {
				int quantidadeSelecionada = Integer.parseInt(quantidadeSelecionadaStr);
				con = dao.conectar();
				pst = con.prepareStatement(read03);
				ResultSet resultSet3 = pst.executeQuery();
				if (resultSet3.next()) {
					int estoque = resultSet3.getInt("estoques.estoque");
					if (resultSet3.getInt("estoques.estoque") > quantidadeSelecionada) {
					} else {
						JOptionPane.showMessageDialog(null, " ATENÇÃO  O produto: " + txtProduto01.getText()
								+ " não tem a Quantidade Digitada em Estoque");
						resultSet3.close();
					}
				} else {
					System.out.println("Código de barras não encontrado.");
					resultSet3.close();
				}
				resultSet3.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void Produto2Estoque() {
		String read03 = "SELECT estoques.estoque FROM estoques WHERE codebarra =  '" + txtBarra02.getText() + "'";
		String quantidadeSelecionadaStr = cboQuant2.getSelectedItem().toString();
		if (!txtBarra02.getText().isEmpty() && !cboQuant2.getSelectedItem().equals(null)) {
			try {
				int quantidadeSelecionada = Integer.parseInt(quantidadeSelecionadaStr);
				con = dao.conectar();
				pst = con.prepareStatement(read03);
				ResultSet resultSet3 = pst.executeQuery();
				if (resultSet3.next()) {
					int estoque = resultSet3.getInt("estoques.estoque");
					if (resultSet3.getInt("estoques.estoque") > quantidadeSelecionada) {
					} else {
						JOptionPane.showMessageDialog(null, " ATENÇÃO  O produto: " + txtProduto02.getText()
								+ " não tem a Quantidade Digitada em Estoque");
						resultSet3.close();
					}
				} else {
					System.out.println("Código de barras não encontrado.");
					resultSet3.close();
				}
				resultSet3.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void Produto3Estoque() {
		String read03 = "SELECT estoques.estoque FROM estoques WHERE codebarra =  '" + txtBarra03.getText() + "'";
		String quantidadeSelecionadaStr = cboQuant3.getSelectedItem().toString();
		if (!txtBarra03.getText().isEmpty() && !cboQuant3.getSelectedItem().equals(null)) {
			try {
				int quantidadeSelecionada = Integer.parseInt(quantidadeSelecionadaStr);
				con = dao.conectar();
				pst = con.prepareStatement(read03);
				ResultSet resultSet3 = pst.executeQuery();
				if (resultSet3.next()) {
					int estoque = resultSet3.getInt("estoques.estoque");
					if (resultSet3.getInt("estoques.estoque") > quantidadeSelecionada) {
					} else {
						JOptionPane.showMessageDialog(null, " ATENÇÃO  O produto: " + txtProduto03.getText()
								+ " não tem a Quantidade Digitada em Estoque");
						resultSet3.close();
					}
				} else {
					System.out.println("Código de barras não encontrado.");
					resultSet3.close();
				}
				resultSet3.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void Produto4Estoque() {
		String read03 = "SELECT estoques.estoque FROM estoques WHERE codebarra =  '" + txtBarra04.getText() + "'";
		String quantidadeSelecionadaStr = cboQuant4.getSelectedItem().toString();
		if (!txtBarra04.getText().isEmpty() && !cboQuant4.getSelectedItem().equals(null)) {
			try {
				int quantidadeSelecionada = Integer.parseInt(quantidadeSelecionadaStr);
				con = dao.conectar();
				pst = con.prepareStatement(read03);
				ResultSet resultSet3 = pst.executeQuery();
				if (resultSet3.next()) {
					int estoque = resultSet3.getInt("estoques.estoque");
					if (resultSet3.getInt("estoques.estoque") > quantidadeSelecionada) {
					} else {
						JOptionPane.showMessageDialog(null, " ATENÇÃO  O produto: " + txtProduto04.getText()
								+ " não tem a Quantidade Digitada em Estoque");
						resultSet3.close();
					}
				} else {
					System.out.println("Código de barras não encontrado.");
					resultSet3.close();
				}
				resultSet3.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void Produto5Estoque() {
		String read03 = "SELECT estoques.estoque FROM estoques WHERE codebarra =  '" + txtBarra05.getText() + "'";
		String quantidadeSelecionadaStr = cboQuant5.getSelectedItem().toString();
		if (!txtBarra05.getText().isEmpty() && !cboQuant5.getSelectedItem().equals(null)) {
			try {
				int quantidadeSelecionada = Integer.parseInt(quantidadeSelecionadaStr);
				con = dao.conectar();
				pst = con.prepareStatement(read03);
				ResultSet resultSet3 = pst.executeQuery();
				if (resultSet3.next()) {
					int estoque = resultSet3.getInt("estoques.estoque");
					if (resultSet3.getInt("estoques.estoque") > quantidadeSelecionada) {
					} else {
						JOptionPane.showMessageDialog(null, " ATENÇÃO  O produto: " + txtProduto05.getText()
								+ " não tem a Quantidade Digitada em Estoque");
						resultSet3.close();
					}
				} else {
					System.out.println("Código de barras não encontrado.");
					resultSet3.close();
				}
				resultSet3.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void Produto6Estoque() {
		String read03 = "SELECT estoques.estoque FROM estoques WHERE codebarra =  '" + txtBarra06.getText() + "'";
		String quantidadeSelecionadaStr = cboQuant6.getSelectedItem().toString();
		if (!txtBarra06.getText().isEmpty() && !cboQuant6.getSelectedItem().equals(null)) {
			try {
				int quantidadeSelecionada = Integer.parseInt(quantidadeSelecionadaStr);
				con = dao.conectar();
				pst = con.prepareStatement(read03);
				ResultSet resultSet3 = pst.executeQuery();
				if (resultSet3.next()) {
					int estoque = resultSet3.getInt("estoques.estoque");
					if (resultSet3.getInt("estoques.estoque") > quantidadeSelecionada) {
					} else {
						JOptionPane.showMessageDialog(null, " ATENÇÃO  O produto: " + txtProduto06.getText()
								+ " não tem a Quantidade Digitada em Estoque");
						resultSet3.close();
					}
				} else {
					System.out.println("Código de barras não encontrado.");
					resultSet3.close();
				}
				resultSet3.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void buscarItemCodBarra1() {
		String read = "select estoques.produto FROM estoques WHERE estoques.codebarra = ? ";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(read);
			pst.setString(1, txtBarra01.getText());
			rs = pst.executeQuery();
			if (rs.next()) {
				txtProduto01.setText(rs.getString(1));
			} else {
				JOptionPane.showMessageDialog(null, "Produto não encontrado");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void buscarItemCodBarra2() {
		String read = "select estoques.produto FROM estoques WHERE estoques.codebarra = ? ";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(read);
			pst.setString(1, txtBarra02.getText());
			rs = pst.executeQuery();
			if (rs.next()) {
				txtProduto02.setText(rs.getString(1));
			} else {
				JOptionPane.showMessageDialog(null, "Produto não encontrado");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void buscarItemCodBarra3() {
		String read = "select estoques.produto FROM estoques WHERE estoques.codebarra = ? ";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(read);
			pst.setString(1, txtBarra03.getText());
			rs = pst.executeQuery();
			if (rs.next()) {
				txtProduto03.setText(rs.getString(1));
			} else {
				JOptionPane.showMessageDialog(null, "Produto não encontrado");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void buscarItemCodBarra4() {
		String read = "select estoques.produto FROM estoques WHERE estoques.codebarra = ? ";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(read);
			pst.setString(1, txtBarra04.getText());
			rs = pst.executeQuery();
			if (rs.next()) {
				txtProduto04.setText(rs.getString(1));
			} else {
				JOptionPane.showMessageDialog(null, "Produto não encontrado");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void buscarItemCodBarra5() {
		String read = "select estoques.produto FROM estoques WHERE estoques.codebarra = ? ";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(read);
			pst.setString(1, txtBarra05.getText());
			rs = pst.executeQuery();
			if (rs.next()) {
				txtProduto05.setText(rs.getString(1));
			} else {
				JOptionPane.showMessageDialog(null, "Produto não encontrado");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void buscarItemCodBarra6() {
		String read = "select estoques.produto FROM estoques WHERE estoques.codebarra = ? ";
		try {
			con = dao.conectar();
			pst = con.prepareStatement(read);
			pst.setString(1, txtBarra06.getText());
			rs = pst.executeQuery();
			if (rs.next()) {
				txtProduto06.setText(rs.getString(1));
			} else {
				JOptionPane.showMessageDialog(null, "Produto não encontrado");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void limparCampos() {

		txtNome.setEditable(true);
		txtTecnico.setEditable(true);
		cboStatus.setEnabled(true);
		txtMarca.setEditable(true);
		txtObs.setEditable(true);
		txtModelo.setEditable(true);
		txtSerie.setEditable(true);
		cboServico.setEnabled(true);
		txtDefeito.setEditable(true);
		txtBarra01.setEditable(true);
		txtProduto01.setEditable(true);
		cboQuant1.setEnabled(true);
		txtBarra02.setEditable(true);
		txtProduto02.setEditable(true);
		cboQuant2.setEnabled(true);
		txtBarra03.setEditable(true);
		txtProduto03.setEditable(true);
		cboQuant3.setEnabled(true);
		txtBarra04.setEditable(true);
		txtProduto04.setEditable(true);
		cboQuant4.setEnabled(true);
		txtBarra05.setEditable(true);
		txtProduto05.setEditable(true);
		cboQuant5.setEnabled(true);
		txtBarra06.setEditable(true);
		txtProduto06.setEditable(true);
		cboQuant6.setEnabled(true);
		txtValorServico.setEditable(true);
		txtPago.setEditable(true);
		cboTipoPag.setEnabled(true);
		txtDataSaida.setEnabled(true);
		txtOS.setText(null);
		txtIDcli.setText(null);
		txtIDtec.setText(null);
		txtDefeito.setText(null);
		txtDiagnostico.setText(null);
		cboStatus.setSelectedItem("");
		txtValorServico.setText("0.00");
		txtDataEntrada.setDate(null);
		txtDataSaida.setDate(null);
		txtMarca.setText(null);
		txtModelo.setText(null);
		txtSerie.setText(null);
		txtPago.setText("0.00");
		txtTroco.setText(null);
		txtNome.setText(null);
		txtTecnico.setText(null);
		txtObs.setText(null);
		txtBarra01.setText(null);
		txtBarra02.setText(null);
		txtBarra03.setText(null);
		txtBarra04.setText(null);
		txtBarra05.setText(null);
		txtBarra06.setText(null);
		txtProduto01.setText(null);
		txtProduto02.setText(null);
		txtProduto03.setText(null);
		txtProduto04.setText(null);
		txtProduto05.setText(null);
		txtProduto06.setText(null);
		txtValorPeca01.setText("0.00");
		txtValorPeca02.setText("0.00");
		txtValorPeca03.setText("0.00");
		txtValorPeca04.setText("0.00");
		txtValorPeca05.setText("0.00");
		txtValorPeca06.setText("0.00");
		txtValorPecaTotal.setText("0.00");
		txtTotal.setText("0.00");
		txtTroco.setText("0.00");
		cboServico.setSelectedItem("");
		cboQuant1.setSelectedItem("");
		cboQuant2.setSelectedItem("");
		cboQuant3.setSelectedItem("");
		cboQuant4.setSelectedItem("");
		cboQuant5.setSelectedItem("");
		cboQuant6.setSelectedItem("");
		cboTipoPag.setSelectedItem("");
		btnBuscarOS.setEnabled(true);
		btnCreate.setEnabled(true);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
		scrollPane.setVisible(false);

		btnOS.setEnabled(false);

	}
}
