package jogo;

/**
 * Interface da classe {@link Campo} usada para definir os atributos do campo de
 * acordo com a dificuldade
 * 
 * @see Dificuldade
 * @author Thiago dos Santos Fontes
 * @author Victor Fonseca Araujo
 */
public interface ICampo {
	/**
	 * M�todo get padr�o
	 * 
	 * @return Retorna o numero de linhas armazenado.
	 */
	public int getNDeLinhas();

	
	/**
	 * M�todo set padr�o
	 * 
	 * @param numeroDeLinhas
	 * Define o numero de linhas armazenado.
	 */
	public void setNDeLinhas(int numeroDeLinhas);

	/**
	 * M�todo get padr�o
	 * 
	 * @return Retorna o numero de colunas armazenado.. 
	 */
	public int getNDeColunas();

	/**
	 * M�todo set padr�o
	 * 
	 * @param numeroDeColunas
	 * Define o numero de coluna armazenado.
	 */
	public void setNDeColunas(int numeroDeColunas);

	/**
	 * M�todo get padr�o
	 * 
	 * @return Retorna o numero de bombas armazenado.
	 */
	public int getNDeBombas();

	/**
	 * M�todo set padr�o
	 * 
	 * @param numeroDeBombas
	 * Define o numero de bombas armazenado.
	 */
	public void setNDeBombas(int numeroDeBombas);
}
