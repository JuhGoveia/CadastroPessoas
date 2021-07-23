package gui;

import java.time.YearMonth;

public class Pessoa {

	private String nome, sobrenome, data, cpf, idade, maior;
	
	static YearMonth ym = YearMonth.now();
	static int m = ym.getMonthValue();
	static int y = ym.getYear();

	public Pessoa(String nome, String sobrenome, String data, String cpf) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.setData(data);
		this.cpf = cpf;
	}
	
	public String getIdade() {
		return idade;
	}



	public String getMaior() {
		return maior;
	}



	private void setIdade(String idade) {

		int x = 0, mes = 0, aniver = 0;
		String aux1, aux2;

		aux1 = idade;
		aux1 = aux1.replace("/", "");

		aux2 = aux1.substring(aux1.length() - 4);
		x = Integer.parseInt(aux2);

		if (mes <= m) {
			aniver = y - x;
		} else {
			aniver = y - x - 1;
		}

		idade = String.valueOf(aniver);
		this.idade = idade;
	}

	public void setMaior(String maior) {

		int x = 0, mes = 0, idade = 0;
		String aux1;

		aux1 = maior;
		aux1 = aux1.replace("/", "");

		String aux2 = aux1.substring(aux1.length() - 6);
		String aux3 = aux2.substring(0, 2);

		aux2 = aux1.substring(aux1.length() - 4);
		x = Integer.parseInt(aux2);
		mes = Integer.parseInt(aux3);

		if ((y - x) == 18) {
			if (mes <= m) {
				maior = "maior de idade";
				
			} 
			else {
				maior = "menor de idade";
				
			}
		} 
		else if ((y - x) >= 18) {
			maior = "maior de idade";
			
		} 
		else {
			maior = "menor de idade";
		}
		
		this.maior= maior;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
		this.setIdade(data);
		this.setMaior(data);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String Status() {
		String tabela;
		tabela ="Nome: " +  this.getNome() + ", Sobrenome: " + this.getSobrenome() + ", CPF: " + this.getCpf() + ", Data de nascimento: " + this.getData() + ", Idade: " + this.idade + ", Maior de idade? " + this.maior; 
		return tabela;
	}

}
