package jogo;

/**
 * Interface implementada por {@link Cronometro}.
 * 
 * @author Thiago dos Santos Fontes
 * @author Victor Fonseca Araujo
 * 
 */
public interface ICronometro {

	/**
	 * M�todo get padr�o.
	 * 
	 * @return Retorna o limite da unidade em quest�o.</br>Ex.: Para minutos
	 *         <code>60</code> pois uma hora = sessenta minutos.
	 */
	public abstract int getLimit();

	/**
	 * M�todo set padr�o.
	 * 
	 * @param limit
	 *            Define o limite da unidade em quest�o.</br>Ex.: Para minutos
	 *            <code>60</code> pois uma hora = sessenta minutos.
	 */
	public abstract void setLimit(int limit);

	/**
	 * M�todo get padr�o.
	 * 
	 * @return Retorna valor atual.
	 */
	public abstract int getValue();

	/**
	 * M�todo set padr�o.
	 * 
	 * @param value
	 *            Define o valor a ser instanciado.
	 */
	public abstract void setValue(int value);

	/**
	 * Incrementa <code>1</code> ao valor.
	 */
	public abstract void increment();

	/**
	 * M�todo get padr�o.
	 * 
	 * @return Retorna string de display.
	 */
	public abstract String getDisplayValue();

}