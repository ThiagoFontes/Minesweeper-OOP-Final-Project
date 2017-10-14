package jogo;

/**
 * Interface implementada por {@link CalculaCampo}.
 * 
 * @author Thiago Dos Santos Fontes
 *
 */
public interface ICalculaCampo {
	/**
	 * Gerencia as jogadas de forma que a primeira jogada nunca seja uma bomba
	 * @param jogada
	 *            Recebe a jogada do tipo Casa
	 * @see Casa
	 */
	public void gerenciaJogadas(ICasa jogada);

	/**
	 * Metodo get padrão
	 * 
	 * @return Retorna o número de jogadas que já foram feitas
	 * 
	 * @see SepararCoordenadas#enviaJogada(String, String)
	 */
	public int getContadorDeJogadas();

	/**
	 * Esse método faz com que todos os atributos do objeto voltem ao padrão de
	 * inicio, assim um novo jogo pode ser começado
	 * 
	 * @see CampoMinadoIG#reiniciaJogo()
	 */
	public void reiniciaCampo();

	/**
	 * Método get padrão
	 * 
	 * @return Retorna o campo em um array de strings, onde as Strings
	 *         <b>" #"</b> representam as casas não mostradas.
	 * @see CampoMinadoIG#atualizaCampo(String[][])
	 */
	public String[][] getCampoShow();

	/**
	 * Método get padrão
	 * 
	 * @return Retorna um array de {@link Casa} contendo informações do campo
	 * 
	 * @see Casa
	 */
	public ICasa[][] getCasasCampo();

	/**
	 * Método get padrão
	 * 
	 * @return Retorna a {@link Dificuldade} em que o jogo foi calculado
	 * 
	 * @see Dificuldade
	 */
	public IDificuldade getLevel();

	/**
	 * Método ultilizado para definir a dificuldade em que o campo será
	 * calculado
	 * 
	 * @param level
	 *            Parametro do tipo {@link Dificuldade}
	 * 
	 * @see Dificuldade
	 */
	public void setLevel(IDificuldade level);

	/**
	 * Ultilizado para definir o numero de jogadas já feitas
	 * 
	 * @param contadorDeJogadas
	 *            Número de jogadas
	 * 
	 * @see CampoMinadoIG
	 */
	public void setContadorDeJogadas(int contadorDeJogadas);
}
