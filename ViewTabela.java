package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class ViewTabela extends JFrame {

	private JTable table;
	private String colunas[] = { "Nome:", "Sobrenome:", "CPF:", "Data de Nascimento:", "Idade:", "Maior de idade?" };
	static String dados[][] = new String[10][6];

	public ViewTabela() {
		
		ViewCadastro tabela = new ViewCadastro();

		dados = tabela.Troca(dados);
				
		setSize(new Dimension(689, 268));// tamanho do Formulario
		setLocationRelativeTo(null);// centralizado
		setTitle("Tabela de cadastro");// titulo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// setando a ação padrão de fechamento do Formulário,
		getContentPane().setLayout(null);

		// adicionando a tabela em uma barra de rolagem, ficará envolta , pela mesma
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 677, 154);

		// adicionando ao JFrame "Formulário" a JTable "Tabela"
		getContentPane().add(scrollPane);

		// instanciando a JTable
		table = new JTable(dados, colunas);
		scrollPane.setViewportView(table);
		table.setPreferredScrollableViewportSize(new Dimension(500, 100));// barra de rolagem
		table.setFillsViewportHeight(true);

		JButton btn_salvar = new JButton("Salvar");
		btn_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				File dir = new File("C:/Candidatos");

		        if (!dir.exists()) {
		            dir.mkdir();
		        }
		        
				PrintWriter arquivo= null;
				try {
					 
					FileWriter out = new FileWriter("c:/Candidatos/Cadastrados.txt" );
					arquivo = new PrintWriter(out);
					
					for (int i = 0; i <= 9; i++) {
						
						for (int j = 0; j <= 5; j++) {

							arquivo.print(dados[i][j] + " ");
						}
							arquivo.println("");
					}
					
				}
					
					catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
				
				finally {
					arquivo.flush();
					arquivo.close();
				}
				
				JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
				setVisible(false);
			}

				
			
		});
		btn_salvar.setFont(new Font("Arial", Font.PLAIN, 12));
		btn_salvar.setBounds(10, 182, 89, 23);
		getContentPane().add(btn_salvar);

		JButton btn_cancelar = new JButton("Cancelar");
		btn_cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
			}
		});
		btn_cancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		btn_cancelar.setBounds(553, 182, 89, 23);
		getContentPane().add(btn_cancelar);
	}

	public static void main(String[] args) {
		new ViewTabela().setVisible(true);
	}
}
