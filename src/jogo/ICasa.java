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
	 * Cada "casa" do campo tem um valor que � calculado de acordo com as
	 * posi��es das bombas este m�todo incrementa o valor da casa.
	 * 
	 * @see CalculaCampo#CalculaCampo(IDificuldade)
	 */
	public abstract void incrementaValor();

	/**
	 * M�todo get padr�o.
	 * 
	 * @return Retorna o valor atribuito a casa.
	 * @see CalculaCampo
	 */
	public abstract int getValor();

	/**
	 * M�todo set padr�o.
	 * 
	 * @param valor
	 *            Atrinui valor a casa.
	 * @see CalculaCampo
	 */
	public abstract void setValor(int valor);

	/**
	 * M�todo get padr�o.
	 * 
	 * @return Retorna coord. x da casa.
	 */
	public abstract int getX();

	/**
	 * M�todo set padr�o.
	 * 
	 * @param x
	 *            Coordenada x da casa.
	 */
	public abstract void setX(int x);

	/**
	 * M�todo get padr�o.
	 * 
	 * @return Retorna coord. y da casa.
	 */
	public abstract int getY();

	/**
	 * M�todo set padr�o.
	 * 
	 * @param y
	 *            Coordenada y da casa.
	 */
	public abstract void setY(int y);

	/**
	 * M�todo get padr�o.
	 * 
	 * @return Valor ultilizado para saber se as casas ao redor j� foram
	 *         mostradas ao usu�rio caso a casa em quest�o tenha valor nulo
	 *         (zero).
	 */
	public abstract Boolean getMostrarArredores();

	/**
	 * M�todo set padr�o.
	 * 
	 * @param mostrarArredores
	 *            Define se true ou false
	 */
	public abstract void setMostrarArredores(Boolean mostrarArredores);

	/**
	 * M�todo toString.
	 * 
	 * @return Retorna uma string contendo todos os parametros da classe.
	 */
	public abstract String toString();

}