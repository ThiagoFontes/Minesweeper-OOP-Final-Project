package jogo;

/**
 * Classe que guarda os atributos de um campo: numero de linhas, colunas e
 * bombas
 */
public class Campo implements ICampo {

	private int nDeLinhas;
	private int nDeColunas;
	private int nDeBombas;

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICampo#getNDeLinhas()
	 */
	@Override
	public int getNDeLinhas() {
		return nDeLinhas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICampo#setNDeLinhas(int)
	 */
	@Override
	public void setNDeLinhas(int numeroDeLinhas) {
		this.nDeLinhas = numeroDeLinhas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICampo#getNDeColunas()
	 */
	@Override
	public int getNDeColunas() {
		return nDeColunas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICampo#setNDeColunas(int)
	 */
	@Override
	public void setNDeColunas(int numeroDeColunas) {
		this.nDeColunas = numeroDeColunas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICampo#getNDeBombas()
	 */
	@Override
	public int getNDeBombas() {
		return nDeBombas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ICampo#setNDeBombas(int)
	 */
	@Override
	public void setNDeBombas(int numeroDeBombas) {
		this.nDeBombas = numeroDeBombas;
	}

}
