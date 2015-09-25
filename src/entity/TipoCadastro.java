package entity;

public enum TipoCadastro {
	
	CADASTRO_FILME("11"),
	CADASTRO_CLIENTE("12"),
	CADASTRO_FUNCIONARIO("13"),
	CADASTRO_ALUGUEL("14");
	
	public String id;
	
	TipoCadastro(String id){
		
		this.id= id;
		
	}
	
	
	static public TipoCadastro getValue(String id){
		
		for(TipoCadastro item : values()){
			
			if(item.getId().equals(id)){
				return item;
			}
			
		}
		
		return null;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
