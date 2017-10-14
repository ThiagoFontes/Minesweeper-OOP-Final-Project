package jogo;

/**
 * Interface implementada por {@link Casa}.
 * 
 * @author Thiago dos Santos Fontes
 * @author Victor Fonseca Araujo
 *
 */
public interface ICasa {

	/**
	 * Cada "casa" do campo tem um valor que é calculado de acordo com as
	 * posições das bombas este método incrementa o valor da casa.
	 * 
	 * @see CalculaCampo#CalculaCampo(IDificuldade)
	 */
	public abstract void incrementaValor();

	/**
	 * Método get padrão.
	 * 
	 * @return Retorna o valor atribuito a casa.
	 * @see CalculaCampo
	 */
	public abstract int getValor();

	/**
	 * Método set padrão.
	 * 
	 * @param valor
	 *            Atrinui valor a casa.
	 * @see CalculaCampo
	 */
	public abstract void setValor(int valor);

	/**
	 * Método get padrão.
	 * 
	 * @return Retorna coord. x da casa.
	 */
	public abstract int getX();

	/**
	 * Método set padrão.
	 * 
	 * @param x
	 *            Coordenada x da casa.
	 */
	public abstract void setX(int x);

	/**
	 * Método get padrão.
	 * 
	 * @return Retorna coord. y da casa.
	 */
	public abstract int getY();

	/**
	 * Método set padrão.
	 * 
	 * @param y
	 *            Coordenada y da casa.
	 */
	public abstract void setY(int y);

	/**
	 * Método get padrão.
	 * 
	 * @return Valor ultilizado para saber se as casas ao redor já foram
	 *         mostradas ao usuário caso a casa em questão tenha valor nulo
	 *         (zero).
	 */
	public abstract Boolean getMostrarArredores();

	/**
	 * Método set padrão.
	 * 
	 * @param mostrarArredores
	 *            Define se true ou false
	 */
	public abstract void setMostrarArredores(Boolean mostrarArredores);

	/**
	 * Método toString.
	 * 
	 * @return Retorna uma string contendo todos os parametros da classe.
	 */
	public abstract String toString();

}