package eletra.project.model;

public class Linha {
	
	private String linha;
	
	public Linha(String linha) {
		this.linha = linha;
	}

	public String getLinha() {
		return linha;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}

	@Override
	public String toString() {
		return getLinha();
	}
	
	
	
}
