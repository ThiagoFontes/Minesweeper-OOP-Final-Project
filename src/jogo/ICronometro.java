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
	 * Método get padrão.
	 * 
	 * @return Retorna o limite da unidade em questão.</br>Ex.: Para minutos
	 *         <code>60</code> pois uma hora = sessenta minutos.
	 */
	public abstract int getLimit();

	/**
	 * Método set padrão.
	 * 
	 * @param limit
	 *            Define o limite da unidade em questão.</br>Ex.: Para minutos
	 *            <code>60</code> pois uma hora = sessenta minutos.
	 */
	public abstract void setLimit(int limit);

	/**
	 * Método get padrão.
	 * 
	 * @return Retorna valor atual.
	 */
	public abstract int getValue();

	/**
	 * Método set padrão.
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
	 * Método get padrão.
	 * 
	 * @return Retorna string de display.
	 */
	public abstract String getDisplayValue();

}