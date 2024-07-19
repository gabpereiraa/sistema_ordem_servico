package view;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.cj.xdevapi.PreparableStatement;

import model.DAO;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

@SuppressWarnings({ "unused", "serial" })
public class Relatorios extends JDialog {
	private JButton btnRelClientes;
	DAO dao = new DAO();
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pst;
	private JButton btnRelOsPronto;
	private JButton btnAgCli;
	private JButton btnAgTec;
	private JButton btnAgPe;
	private JButton btnRelEstoqueMin;
	private JButton btnFuncionarios;
	private JButton btnFornecedores;
	private JButton btnProdutos;
	private JButton btnValidade;
	private JButton btnPatrimonio;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorios dialog = new Relatorios();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Relatorios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Relatorios.class.getResource("/img/report.png")));
		setTitle("Marvi Cold - Relatórios");
		setBounds(100, 100, 491, 313);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Ordem de Servi\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 228, 142);
		getContentPane().add(panel);
		panel.setLayout(null);
		btnRelOsPronto = new JButton("OS PRONTA");
		btnRelOsPronto.setBounds(10, 15, 207, 23);
		panel.add(btnRelOsPronto);
		btnRelOsPronto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAgCli = new JButton("Aguardando Aprovação do Cliente");
		btnAgCli.setBounds(10, 43, 207, 23);
		panel.add(btnAgCli);
		btnAgCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioOsAgAprCliente();
			}
		});
		btnAgCli.setFont(new Font("Tahoma", Font.PLAIN, 11));

		btnAgTec = new JButton("Aguardando Técnico");
		btnAgTec.setBounds(10, 72, 207, 23);
		panel.add(btnAgTec);
		btnAgTec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioOsAgTecnico();
			}
		});
		btnAgTec.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAgPe = new JButton("Aguardando Peças");
		btnAgPe.setBounds(10, 101, 207, 23);
		panel.add(btnAgPe);
		btnAgPe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioOsAgPeca();
			}
		});
		btnAgPe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRelOsPronto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioOsPronto();
			}
		});

		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Usu\u00E1rios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 156, 228, 46);
		getContentPane().add(panel_1);
		btnFuncionarios = new JButton("Funcionarios");
		btnFuncionarios.setBounds(10, 15, 207, 23);
		panel_1.add(btnFuncionarios);
		btnFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioFuncionarios();
			}
		});
		btnFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 11));

		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Clientes",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 205, 228, 51);
		getContentPane().add(panel_2);
		btnRelClientes = new JButton("Clientes");
		btnRelClientes.setBounds(10, 15, 207, 23);
		panel_2.add(btnRelClientes);
		btnRelClientes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRelClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioClientes();
			}
		});

		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Fornecedores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(248, 156, 228, 46);
		getContentPane().add(panel_3);
		btnFornecedores = new JButton("Fornecedores");
		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioFornecedores();
			}
		});
		btnFornecedores.setBounds(10, 15, 207, 23);
		panel_3.add(btnFornecedores);
		btnFornecedores.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Estoque",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(243, 10, 228, 142);
		getContentPane().add(panel_4);
		btnProdutos = new JButton("Produtos");
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioProdutos();
			}
		});
		btnProdutos.setBounds(10, 15, 207, 23);
		panel_4.add(btnProdutos);
		btnProdutos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnValidade = new JButton("Validade");
		btnValidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioValidade();
			}
		});
		btnValidade.setBounds(10, 43, 207, 23);
		panel_4.add(btnValidade);
		btnValidade.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPatrimonio = new JButton("Patrimonio");
		btnPatrimonio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPatrimonio.setBounds(10, 72, 207, 23);
		panel_4.add(btnPatrimonio);
		btnPatrimonio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRelEstoqueMin = new JButton("Estoque Minimo");
		btnRelEstoqueMin.setBounds(10, 101, 207, 23);
		panel_4.add(btnRelEstoqueMin);
		btnRelEstoqueMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioEstoqMin();
			}
		});
		btnRelEstoqueMin.setFont(new Font("Tahoma", Font.PLAIN, 11));

	}

	private void relatorioClientes() {
		Document document = new Document();
		document.setPageSize(PageSize.A4.rotate());
		try {
			PdfWriter.getInstance(document, new FileOutputStream("clientes.pdf"));
			document.open();
			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));
			document.add(new Paragraph("Clientes:"));
			document.add(new Paragraph(" "));
			String readClientes = "select nome,cpf,telefone1,email from clientes order by nome";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readClientes);
				rs = pst.executeQuery();
				PdfPTable tabela = new PdfPTable(4);
				PdfPCell col1 = new PdfPCell(new Paragraph("Cliente"));
				PdfPCell col2 = new PdfPCell(new Paragraph("CPF"));
				PdfPCell col3 = new PdfPCell(new Paragraph("Telefone"));
				PdfPCell col4 = new PdfPCell(new Paragraph("Email"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col4);
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
				}
				document.add(tabela);
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		document.close();
		try {
			Desktop.getDesktop().open(new File("clientes.pdf"));
			;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	private void relatorioOsPronto() {
		Document document = new Document();
		document.setPageSize(PageSize.A4.rotate());
		try {
			PdfWriter.getInstance(document, new FileOutputStream("OsProntas.pdf"));
			document.open();
			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));
			document.add(new Paragraph("OS Concluida:"));
			document.add(new Paragraph(" "));
			String readOSpronta = "select servicos.os,date_format(servicos.dataOS, '%d/%m/%Y') as data_entrada, servicos.usuario, servicos.MarcaOS, servicos.ModeloOS, clientes.nome as cliente, clientes.telefone1 as telefone, tecnicos.nome as Técnico, date_format(dataOSsaida,'%d/%m/%Y') as data_saida, valor from servicos inner join clientes on servicos.idcli = clientes.idcli inner join tecnicos on servicos.idtec = tecnicos.idtec where statusOS = 'PRONTO'";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readOSpronta);
				rs = pst.executeQuery();
				PdfPTable tabela = new PdfPTable(10);
				PdfPCell col1 = new PdfPCell(new Paragraph("N° OS"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Data Entrada"));
				PdfPCell col3 = new PdfPCell(new Paragraph("Usuario"));
				PdfPCell col4 = new PdfPCell(new Paragraph("Marca"));
				PdfPCell col5 = new PdfPCell(new Paragraph("Modelo"));
				PdfPCell col7 = new PdfPCell(new Paragraph("Cliente"));
				PdfPCell col8 = new PdfPCell(new Paragraph("Telefone"));
				PdfPCell col9 = new PdfPCell(new Paragraph("Tecnico"));
				PdfPCell col11 = new PdfPCell(new Paragraph("Data Saida"));
				PdfPCell col12 = new PdfPCell(new Paragraph("Valor"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col4);
				tabela.addCell(col5);
				tabela.addCell(col7);
				tabela.addCell(col8);
				tabela.addCell(col9);
				tabela.addCell(col11);
				tabela.addCell(col12);

				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
					tabela.addCell(rs.getString(6));
					tabela.addCell(rs.getString(7));
					tabela.addCell(rs.getString(8));
					tabela.addCell(rs.getString(9));
					tabela.addCell(rs.getString(10));
				}
				document.add(tabela);
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		document.close();
		try {
			Desktop.getDesktop().open(new File("OsProntas.pdf"));
			;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	private void relatorioOsAgAprCliente() {
		Document document = new Document();
		document.setPageSize(PageSize.A4.rotate());
		try {
			PdfWriter.getInstance(document, new FileOutputStream("OsAguardandoAprovacao.pdf"));
			document.open();
			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));
			document.add(new Paragraph("OS Aguardando Aprovação do Cliente:"));
			document.add(new Paragraph(" "));
			String readOsAgAprCliente = "select servicos.os, clientes.nome as cliente, clientes.telefone1 as telefone, servicos.MarcaOS, servicos.ModeloOS, servicos.valor from servicos inner join clientes on servicos.idcli = clientes.idcli where statusOS = 'AGUARDANDO APROVAÇÃO DO CLIENTE' ;";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readOsAgAprCliente);
				rs = pst.executeQuery();
				PdfPTable tabela = new PdfPTable(6);
				PdfPCell col1 = new PdfPCell(new Paragraph("N° OS"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Cliente"));
				PdfPCell col3 = new PdfPCell(new Paragraph("Telefone"));
				PdfPCell col4 = new PdfPCell(new Paragraph("Marca"));
				PdfPCell col5 = new PdfPCell(new Paragraph("Modelo"));
				PdfPCell col8 = new PdfPCell(new Paragraph("Valor"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col4);
				tabela.addCell(col5);
				tabela.addCell(col8);
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
					tabela.addCell(rs.getString(6));
				}

				document.add(tabela);
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		document.close();
		try {
			Desktop.getDesktop().open(new File("OsAguardandoAprovacao.pdf"));
			;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	private void relatorioOsAgTecnico() {
		Document document = new Document();
		document.setPageSize(PageSize.A4.rotate());
		try {
			PdfWriter.getInstance(document, new FileOutputStream("OsAguardandoTecnico.pdf"));
			document.open();
			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));
			document.add(new Paragraph("OS Aguardando Técnico:"));
			document.add(new Paragraph(" "));
			String readOsAgTec = "select servicos.os, servicos.MarcaOS, servicos.ModeloOS from servicos where statusOS = 'AGUARDANDO TÉCNICO' ;";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readOsAgTec);
				rs = pst.executeQuery();
				PdfPTable tabela = new PdfPTable(3);
				PdfPCell col1 = new PdfPCell(new Paragraph("N° OS"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Marca"));
				PdfPCell col3 = new PdfPCell(new Paragraph("Modelo"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
				}
				document.add(tabela);
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		document.close();
		try {
			Desktop.getDesktop().open(new File("OsAguardandoTecnico.pdf"));
			;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	private void relatorioOsAgPeca() {
		Document document = new Document();
		document.setPageSize(PageSize.A4.rotate());

		try {
			PdfWriter.getInstance(document, new FileOutputStream("OsAguardandoMaterial.pdf"));
			document.open();
			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));
			document.add(new Paragraph("OS Aguardando Peças:"));
			document.add(new Paragraph(" "));
			String readOsAgAprCliente = "select servicos.os, servicos.MarcaOS, servicos.ModeloOS, tecnicos.nome as Técnico  from servicos inner join tecnicos on servicos.idtec = tecnicos.idtec where statusOS = 'AGUARDANDO PEÇAS' ;";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readOsAgAprCliente);
				rs = pst.executeQuery();
				PdfPTable tabela = new PdfPTable(4);
				PdfPCell col1 = new PdfPCell(new Paragraph("N° OS"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Marca"));
				PdfPCell col3 = new PdfPCell(new Paragraph("Modelo"));
				PdfPCell col6 = new PdfPCell(new Paragraph("Técnico"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col6);
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
				}
				document.add(tabela);
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		document.close();
		try {
			Desktop.getDesktop().open(new File("OsAguardandoMaterial.pdf"));
			;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	private void relatorioEstoqMin() {
		Document document = new Document();
		document.setPageSize(PageSize.A4.rotate());
		try {
			PdfWriter.getInstance(document, new FileOutputStream("EstoqueMinimo.pdf"));
			document.open();
			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));
			document.add(new Paragraph("Estoque Minimo:"));
			document.add(new Paragraph(" "));
			String readEstoqMin = "select estoques.idprodut, estoques.produto, estoques.estoque, estoques.estoquemin, fornecedores.razao as Razao, fornecedores.idforn as idforn, fornecedores.telefone1 as telefone1, fornecedores.email as email from estoques inner join fornecedores on estoques.idforn = fornecedores.idforn where estoque < estoquemin;";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readEstoqMin);
				rs = pst.executeQuery();
				PdfPTable tabela = new PdfPTable(8);
				PdfPCell col1 = new PdfPCell(new Paragraph("ID Produto"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
				PdfPCell col3 = new PdfPCell(new Paragraph("Quant. Estoque"));
				PdfPCell col4 = new PdfPCell(new Paragraph("Quant. Estoque Minimo"));
				PdfPCell col5 = new PdfPCell(new Paragraph("Razão"));
				PdfPCell col6 = new PdfPCell(new Paragraph("ID Fornecedor"));
				PdfPCell col7 = new PdfPCell(new Paragraph("Telefone"));
				PdfPCell col8 = new PdfPCell(new Paragraph("Email"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col4);
				tabela.addCell(col5);
				tabela.addCell(col6);
				tabela.addCell(col7);
				tabela.addCell(col8);
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
					tabela.addCell(rs.getString(6));
					tabela.addCell(rs.getString(7));
					tabela.addCell(rs.getString(8));
				}
				document.add(tabela);
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		document.close();
		try {
			Desktop.getDesktop().open(new File("EstoqueMinimo.pdf"));
			;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	private void relatorioFornecedores() {
		Document document = new Document();
		document.setPageSize(PageSize.A4.rotate());
		try {
			PdfWriter.getInstance(document, new FileOutputStream("fornecedores.pdf"));
			document.open();
			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));
			document.add(new Paragraph("Fornecedores:"));
			document.add(new Paragraph(" "));
			String readFornecedores = "select razao, cnpj, telefone1,email from fornecedores order by razao";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readFornecedores);
				rs = pst.executeQuery();
				PdfPTable tabela = new PdfPTable(4);
				PdfPCell col1 = new PdfPCell(new Paragraph("Razão"));
				PdfPCell col2 = new PdfPCell(new Paragraph("CNPJ"));
				PdfPCell col3 = new PdfPCell(new Paragraph("Telefone"));
				PdfPCell col4 = new PdfPCell(new Paragraph("Email"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col4);
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
				}
				document.add(tabela);
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		document.close();
		try {
			Desktop.getDesktop().open(new File("fornecedores.pdf"));
			;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	private void relatorioFuncionarios() {
		Document document = new Document();
		document.setPageSize(PageSize.A4.rotate());
		try {
			PdfWriter.getInstance(document, new FileOutputStream("funcionarios.pdf"));
			document.open();
			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));
			document.add(new Paragraph("Funcionários:"));
			document.add(new Paragraph(" "));
			String readFornecedores = "select nome, perfil from usuarios order by nome";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readFornecedores);
				rs = pst.executeQuery();
				PdfPTable tabela = new PdfPTable(2);
				PdfPCell col1 = new PdfPCell(new Paragraph("Funcionário"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Perfil"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
				}
				document.add(tabela);
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		document.close();
		try {
			Desktop.getDesktop().open(new File("funcionarios.pdf"));
			;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	private void relatorioProdutos() {
		Document document = new Document();
		document.setPageSize(PageSize.A4.rotate());
		try {
			PdfWriter.getInstance(document, new FileOutputStream("produtos.pdf"));
			document.open();
			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));
			document.add(new Paragraph("Produtos:"));
			document.add(new Paragraph(" "));
			String readFornecedores = "select produto, codebarra, estoque ,estoquemin, validade, valor from estoques order by produto";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readFornecedores);
				rs = pst.executeQuery();
				PdfPTable tabela = new PdfPTable(6);
				PdfPCell col1 = new PdfPCell(new Paragraph("Produto"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Codigo de Barras"));
				PdfPCell col3 = new PdfPCell(new Paragraph("Estoque"));
				PdfPCell col4 = new PdfPCell(new Paragraph("Estoque Minimo"));
				PdfPCell col5 = new PdfPCell(new Paragraph("Validade"));
				PdfPCell col6 = new PdfPCell(new Paragraph("Valor"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col4);
				tabela.addCell(col5);
				tabela.addCell(col6);
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					String setarDataSaida = rs.getString(5);
					Date dataFormatada2 = new SimpleDateFormat("yyyy-MM-dd").parse(setarDataSaida);
					DateFormat formatador1 = DateFormat.getDateInstance(DateFormat.DATE_FIELD);
					tabela.addCell(new Paragraph(formatador1.format(dataFormatada2)));
					tabela.addCell(rs.getString(6));
				}
				document.add(tabela);
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		document.close();
		try {
			Desktop.getDesktop().open(new File("produtos.pdf"));
			;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	private void relatorioValidade() {
		Document document = new Document();
		document.setPageSize(PageSize.A4.rotate());
		try {
			PdfWriter.getInstance(document, new FileOutputStream("produtos.pdf"));
			document.open();
			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));
			document.add(new Paragraph("Produtos:"));
			document.add(new Paragraph(" "));
			String readFornecedores = "select produto, codebarra, estoque ,estoquemin, validade, valor from estoques where validade < CURDATE() order by produto;";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(readFornecedores);
				rs = pst.executeQuery();
				PdfPTable tabela = new PdfPTable(6);
				PdfPCell col1 = new PdfPCell(new Paragraph("Produto"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Codigo de Barras"));
				PdfPCell col3 = new PdfPCell(new Paragraph("Estoque"));
				PdfPCell col4 = new PdfPCell(new Paragraph("Estoque Minimo"));
				PdfPCell col5 = new PdfPCell(new Paragraph("Validade"));
				PdfPCell col6 = new PdfPCell(new Paragraph("Valor"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col4);
				tabela.addCell(col5);
				tabela.addCell(col6);
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					String setarDataSaida = rs.getString(5);
					Date dataFormatada2 = new SimpleDateFormat("yyyy-MM-dd").parse(setarDataSaida);
					DateFormat formatador1 = DateFormat.getDateInstance(DateFormat.DATE_FIELD);
					tabela.addCell(new Paragraph(formatador1.format(dataFormatada2)));
					tabela.addCell(rs.getString(6));
				}
				document.add(tabela);
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		document.close();
		try {
			Desktop.getDesktop().open(new File("produtos.pdf"));
			;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}
}