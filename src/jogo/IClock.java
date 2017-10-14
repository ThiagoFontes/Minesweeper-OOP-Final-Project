package jogo;

/**
 * Interface implementada por {@link Clock}.
 * 
 * @author Thiago dos Santos Fontes
 * @author Victor Fonseca Araujo
 */
public interface IClock {

	/**
	 * M�todo respons�vel por incrementar o tempo.
	 */
	public abstract void timeTick();

	/**
	 * M�todo get padr�o
	 * 
	 * @return Retorna a string a ser mostrada ex: <strong>01:32</strong>.
	 */
	public abstract String getDisplayString();

	/**
	 * M�todo que inicia o relogio e define o intervalo de tempo entre os
	 * incrementos.
	 */
	public abstract void run();

	/**
	 * Usado para pausar o tempo.
	 * 
	 * @param pausado
	 *            Se for <code>true</code> o tempo � pausado.
	 */
	public abstract void setPausado(boolean pausado);

	/**
	 * Usado para reiniciar o rel�gio.
	 * 
	 * @see CampoMinadoIG#reiniciaJogo()
	 */
	public abstract void reiniciaRelogio();

}