package jogo;

/**
 * Interface implementada por {@link CampoMinadoIG}.
 * 
 * @version 1.0
 * @author Thiago dos Santos Fontes
 * @author Victor Fonseca Ara�jo
 * 
 */

public interface ICampoMinadoIG {
	/**
	 * Este metodo instacia todos os bot�es e componentes que v�o aparecer no
	 * jogo.
	 * 
	 * @see CampoMinadoIG
	 */
	public void fazCampo();

	/**
	 * M�todo respons�vel por receber um array de Strings com a informa��o do
	 * que ser� mostrado no campo e atualizar o status dos bot�es.
	 * 
	 * @see CalculaCampo#gerenciaJogadas(ICasa)
	 * @see CalculaCampo#getCampoShow()
	 * @param campo
	 */
	public void atualizaCampo(String[][] campo);

	/**
	 * Este m�todo faz com que o jogo volte a seu estado inicial
	 * 
	 * @see CampoMinadoIG
	 * @see CalculaCampo
	 * @see Clock
	 */
	public void reiniciaJogo();

	/**
	 * Retorna o numero de casas n�o mostradas. 
	 * @return Este n�mero � ultilizado para
	 * calcular se o jogador venceu o jogo.
	 */
	public int getContaCasasNaoMostradas();
}
