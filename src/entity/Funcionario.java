package entity;

public class Funcionario extends Pessoa{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2698694255203701203L;
	
	private String lotacao;
	
	public Funcionario(Integer id, String nome, String lotacao) {
		super(id, nome);
		this.lotacao = lotacao;
	}

	public Funcionario() {
		super();
	}

	public String getLotacao() {
		return lotacao;
	}

	public void setLotacao(String lotacao) {
		this.lotacao = lotacao;
	}

	@Override
	public String toString() {
		return "Funcionario [lotacao=" + lotacao + ", ID=" + getId()
				+ ", nome=" + getNome() + "]";
	}

	
	
}
