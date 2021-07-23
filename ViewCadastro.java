package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;

public class ViewCadastro extends JFrame {

	private JPanel Panel;
	private JTextField txt_nome;
	private JTextField txt_sobrenome;
	private JTextField txt_cpf;
	private JTextField txt_data;
	private int x = 0, y = 0, rbtn1 = 0, rbtn2 = 0, rbtn3 = 0, rbtn4 = 0, rbtn5 = 0;
	static Pessoa lista[] = new Pessoa[10];
	static String dados[][] = new String[10][6];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					ViewCadastro frame = new ViewCadastro();
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
	public ViewCadastro() {

		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 381);

		Panel = new JPanel();
		Panel.setBackground(new Color(240, 248, 255));
		Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel);
		Panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastro de Candidatos");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(135, 11, 217, 26);
		Panel.add(lblNewLabel);

		JLabel lbl_nome = new JLabel("Nome:");
		lbl_nome.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_nome.setBounds(10, 64, 52, 26);
		Panel.add(lbl_nome);

		JLabel lbl_sobrenome = new JLabel("Sobrenome:");
		lbl_sobrenome.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_sobrenome.setBounds(10, 101, 108, 26);
		Panel.add(lbl_sobrenome);

		JLabel lbl_cpf = new JLabel("CPF:");
		lbl_cpf.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_cpf.setBounds(10, 138, 79, 26);
		Panel.add(lbl_cpf);

		JLabel lbl_data = new JLabel("Data de Nascimento:");
		lbl_data.setFont(new Font("Arial", Font.BOLD, 14));
		lbl_data.setBounds(10, 175, 153, 26);
		Panel.add(lbl_data);

		txt_nome = new JTextField();
		txt_nome.setFont(new Font("Arial", Font.PLAIN, 14));
		txt_nome.setBounds(166, 68, 268, 20);
		Panel.add(txt_nome);
		txt_nome.setColumns(10);

		txt_sobrenome = new JTextField();
		txt_sobrenome.setFont(new Font("Arial", Font.PLAIN, 14));
		txt_sobrenome.setBounds(166, 105, 268, 20);
		Panel.add(txt_sobrenome);
		txt_sobrenome.setColumns(10);

		txt_cpf = new JTextField();
		txt_cpf.setFont(new Font("Arial", Font.PLAIN, 14));
		txt_cpf.setBounds(166, 142, 268, 20);
		Panel.add(txt_cpf);
		txt_cpf.setColumns(10);

		JRadioButton rdbtn_vaga1 = new JRadioButton("Vaga de Trainee I");
		rdbtn_vaga1.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtn_vaga1.setBounds(22, 224, 143, 26);
		rdbtn_vaga1.setSelected(true);
		Panel.add(rdbtn_vaga1);

		JRadioButton rdbtn_vaga2 = new JRadioButton("Vaga de Trainee II");
		rdbtn_vaga2.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtn_vaga2.setBounds(22, 253, 153, 23);
		Panel.add(rdbtn_vaga2);

		JRadioButton rdbtn_vaga3 = new JRadioButton("Vaga de Trainee III");
		rdbtn_vaga3.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtn_vaga3.setBounds(195, 225, 144, 23);
		Panel.add(rdbtn_vaga3);

		JRadioButton rdbtn_vaga4 = new JRadioButton("Vaga de Trainee IV");
		rdbtn_vaga4.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtn_vaga4.setBounds(195, 253, 144, 23);
		Panel.add(rdbtn_vaga4);

		JRadioButton rdbtn_vaga5 = new JRadioButton("Vaga de Trainee V");
		rdbtn_vaga5.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtn_vaga5.setBounds(397, 225, 130, 23);
		Panel.add(rdbtn_vaga5);

		ButtonGroup buttonGroup1 = new javax.swing.ButtonGroup();
		buttonGroup1.add(rdbtn_vaga1);
		buttonGroup1.add(rdbtn_vaga2);
		buttonGroup1.add(rdbtn_vaga3);
		buttonGroup1.add(rdbtn_vaga4);
		buttonGroup1.add(rdbtn_vaga5);

		JButton btn_cadasCand = new JButton("Cadastrar Candidato");
		btn_cadasCand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txt_nome.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O nome é obrigatório. O candidato não foi adicionado a lista",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					txt_nome.requestFocus();
				}

				else if (txt_sobrenome.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"O sobrenome é obrigatório. O candidato não foi adicionado a lista", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					txt_sobrenome.requestFocus();
				}

				else if (txt_cpf.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O CPF é obrigatório. O candidato não foi adicionado a lista",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					txt_cpf.requestFocus();

				}

				else if (txt_cpf.getText().length() != 11) {
					JOptionPane.showMessageDialog(null, "O CPF está incorreto, tente novamente.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					txt_cpf.requestFocus();
				}

				else if (txt_data.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"A data de nascimento é obrigatório. O candidato não foi adicionado a lista", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					txt_data.requestFocus();
				}

				else if (x == 10) {
					JOptionPane.showMessageDialog(null, "Quantidade máxima de pessoas cadastradas");
				}

				else if ((rbtn1 == 3) && rdbtn_vaga1.isSelected()) {

					JOptionPane.showMessageDialog(null, "Vaga já chegou ao limite de cadastros", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

				else if ((rbtn2 == 3) && rdbtn_vaga2.isSelected()) {

					JOptionPane.showMessageDialog(null, "Vaga já chegou ao limite de cadastros", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

				else if ((rbtn3 == 3)&& rdbtn_vaga3.isSelected()) {

					JOptionPane.showMessageDialog(null, "Vaga já chegou ao limite de cadastros", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

				else if ((rbtn4 == 3) && rdbtn_vaga4.isSelected()) {

					JOptionPane.showMessageDialog(null, "Vaga já chegou ao limite de cadastros", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

				else if ((rbtn5 == 3) && rdbtn_vaga5.isSelected()) {

					JOptionPane.showMessageDialog(null, "Vaga já chegou ao limite de cadastros", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

				else {
					lista[x] = new Pessoa(txt_nome.getText(), txt_sobrenome.getText(), txt_data.getText(),
							txt_cpf.getText());
					y = 0;

					if (x != 0) {
						for (int i = 0; i < x; i++) {
							if (lista[i].getCpf().equals(lista[x].getCpf())) {
								y = 1;
								JOptionPane.showMessageDialog(null, "Candidato já, cadastrado");

							}
						}

					}

					if (y == 0) {
						JOptionPane.showMessageDialog(null, "Candidato adicionado a lista com Sucesso!");

						JOptionPane.showMessageDialog(null, lista[x].Status());

						dados[x][0] = lista[x].getNome();
						dados[x][1] = lista[x].getSobrenome();
						dados[x][2] = lista[x].getCpf();
						dados[x][3] = lista[x].getData();
						dados[x][4] = lista[x].getIdade();
						dados[x][5] = lista[x].getMaior();

						if (rdbtn_vaga1.isSelected()) {
							rbtn1++;
						}
						if (rdbtn_vaga2.isSelected()) {
							rbtn2++;
						}
						if (rdbtn_vaga3.isSelected()) {
							rbtn3++;
						}
						if (rdbtn_vaga4.isSelected()) {
							rbtn4++;
						}
						if (rdbtn_vaga5.isSelected()) {
							rbtn5++;
						}

						txt_nome.setText("");
						txt_sobrenome.setText("");
						txt_cpf.setText("");
						txt_data.setText("");
						txt_nome.requestFocus();
						x++;
					}
				}

			}
		});

		btn_cadasCand.setBackground(new Color(102, 205, 170));
		btn_cadasCand.setFont(new Font("Arial", Font.BOLD, 12));
		btn_cadasCand.setBounds(10, 300, 153, 31);
		Panel.add(btn_cadasCand);

		JButton btn_proximo = new JButton("Proximo");
		btn_proximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new ViewTabela().setVisible(true);

			}
		});

		btn_proximo.setBackground(new Color(102, 205, 170));
		btn_proximo.setFont(new Font("Arial", Font.BOLD, 12));
		btn_proximo.setBounds(419, 302, 108, 27);
		Panel.add(btn_proximo);

		txt_data = new JTextField();
		txt_data.setFont(new Font("Arial", Font.PLAIN, 14));
		txt_data.setBounds(166, 175, 268, 24);
		Panel.add(txt_data);
		txt_data.setColumns(10);

	}

	public String[][] Troca(String dados[][]) {

		return this.dados;

	}
}
