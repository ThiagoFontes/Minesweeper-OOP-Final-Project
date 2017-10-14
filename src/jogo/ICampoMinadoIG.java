package jogo;

/**
 * Interface implementada por {@link CampoMinadoIG}.
 * 
 * @version 1.0
 * @author Thiago dos Santos Fontes
 * @author Victor Fonseca Araújo
 * 
 */

public interface ICampoMinadoIG {
	/**
	 * Este metodo instacia todos os botões e componentes que vão aparecer no
	 * jogo.
	 * 
	 * @see CampoMinadoIG
	 */
	public void fazCampo();

	/**
	 * Método responsável por receber um array de Strings com a informação do
	 * que será mostrado no campo e atualizar o status dos botões.
	 * 
	 * @see CalculaCampo#gerenciaJogadas(ICasa)
	 * @see CalculaCampo#getCampoShow()
	 * @param campo
	 */
	public void atualizaCampo(String[][] campo);

	/**
	 * Este método faz com que o jogo volte a seu estado inicial
	 * 
	 * @see CampoMinadoIG
	 * @see CalculaCampo
	 * @see Clock
	 */
	public void reiniciaJogo();

	/**
	 * Retorna o numero de casas não mostradas. 
	 * @return Este número é ultilizado para
	 * calcular se o jogador venceu o jogo.
	 */
	public int getContaCasasNaoMostradas();
}
