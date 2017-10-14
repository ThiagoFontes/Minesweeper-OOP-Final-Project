package jogo;

/**
 * Interface implementada por {@link SepararCoordenadas}.
 * 
 * @author Thiago dos Santos Fontes
 * @author Victor Fonseca Araujo
 */
public interface ISepararCoordenadas {

	/**
	 * Recebe uma {@link String} com as coordenadas, separa em dois inteiros e
	 * envia a jogada como um tipo {@link Casa}
	 * 
	 * @param auxiliar
	 *            String com as coor. x e y separadas por um caractere.
	 * @param termoSeparador
	 *            String que contem o caractere que separa as coordenadas.
	 * @return retorna a jogada como uma {@link Casa}
	 * @see Casa
	 * @see CalculaCampo#gerenciaJogadas(ICasa)
	 */
	public abstract ICasa enviaJogada(String auxiliar, String termoSeparador);

}