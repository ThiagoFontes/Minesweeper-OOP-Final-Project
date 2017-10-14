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
	 * Metodo get padr�o
	 * 
	 * @return Retorna o n�mero de jogadas que j� foram feitas
	 * 
	 * @see SepararCoordenadas#enviaJogada(String, String)
	 */
	public int getContadorDeJogadas();

	/**
	 * Esse m�todo faz com que todos os atributos do objeto voltem ao padr�o de
	 * inicio, assim um novo jogo pode ser come�ado
	 * 
	 * @see CampoMinadoIG#reiniciaJogo()
	 */
	public void reiniciaCampo();

	/**
	 * M�todo get padr�o
	 * 
	 * @return Retorna o campo em um array de strings, onde as Strings
	 *         <b>" #"</b> representam as casas n�o mostradas.
	 * @see CampoMinadoIG#atualizaCampo(String[][])
	 */
	public String[][] getCampoShow();

	/**
	 * M�todo get padr�o
	 * 
	 * @return Retorna um array de {@link Casa} contendo informa��es do campo
	 * 
	 * @see Casa
	 */
	public ICasa[][] getCasasCampo();

	/**
	 * M�todo get padr�o
	 * 
	 * @return Retorna a {@link Dificuldade} em que o jogo foi calculado
	 * 
	 * @see Dificuldade
	 */
	public IDificuldade getLevel();

	/**
	 * M�todo ultilizado para definir a dificuldade em que o campo ser�
	 * calculado
	 * 
	 * @param level
	 *            Parametro do tipo {@link Dificuldade}
	 * 
	 * @see Dificuldade
	 */
	public void setLevel(IDificuldade level);

	/**
	 * Ultilizado para definir o numero de jogadas j� feitas
	 * 
	 * @param contadorDeJogadas
	 *            N�mero de jogadas
	 * 
	 * @see CampoMinadoIG
	 */
	public void setContadorDeJogadas(int contadorDeJogadas);
}
