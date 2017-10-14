package jogo;

/**
 * Interface implementada por {@link Clock}.
 * 
 * @author Thiago dos Santos Fontes
 * @author Victor Fonseca Araujo
 */
public interface IClock {

	/**
	 * Método responsável por incrementar o tempo.
	 */
	public abstract void timeTick();

	/**
	 * Método get padrão
	 * 
	 * @return Retorna a string a ser mostrada ex: <strong>01:32</strong>.
	 */
	public abstract String getDisplayString();

	/**
	 * Método que inicia o relogio e define o intervalo de tempo entre os
	 * incrementos.
	 */
	public abstract void run();

	/**
	 * Usado para pausar o tempo.
	 * 
	 * @param pausado
	 *            Se for <code>true</code> o tempo é pausado.
	 */
	public abstract void setPausado(boolean pausado);

	/**
	 * Usado para reiniciar o relógio.
	 * 
	 * @see CampoMinadoIG#reiniciaJogo()
	 */
	public abstract void reiniciaRelogio();

}