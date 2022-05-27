package model;

public class Estudante {	
	private int id;
	private String nome;
	private String curso;
	private String cpf;
	private String imagem;
	private String situacao;
	
	public Estudante() {
		//TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "Estudante [id=" + id + ", nome=" + nome + ", curso=" + curso + ", cpf=" + cpf + ", imagem=" + imagem
				+ ", situacao=" + situacao + "]";
	}
	
	
	

	
	
}
	