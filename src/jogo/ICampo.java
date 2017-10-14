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
	 * Método get padrão
	 * 
	 * @return Retorna o numero de linhas armazenado.
	 */
	public int getNDeLinhas();

	
	/**
	 * Método set padrão
	 * 
	 * @param numeroDeLinhas
	 * Define o numero de linhas armazenado.
	 */
	public void setNDeLinhas(int numeroDeLinhas);

	/**
	 * Método get padrão
	 * 
	 * @return Retorna o numero de colunas armazenado.. 
	 */
	public int getNDeColunas();

	/**
	 * Método set padrão
	 * 
	 * @param numeroDeColunas
	 * Define o numero de coluna armazenado.
	 */
	public void setNDeColunas(int numeroDeColunas);

	/**
	 * Método get padrão
	 * 
	 * @return Retorna o numero de bombas armazenado.
	 */
	public int getNDeBombas();

	/**
	 * Método set padrão
	 * 
	 * @param numeroDeBombas
	 * Define o numero de bombas armazenado.
	 */
	public void setNDeBombas(int numeroDeBombas);
}
