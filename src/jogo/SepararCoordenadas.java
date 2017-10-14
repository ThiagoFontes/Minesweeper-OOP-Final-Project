package jogo;

import java.util.StringTokenizer;

/**
 * Classe usada para fazer a passagem de parametros da {@link CampoMinadoIG}
 * para a {@link CalculaCampo}. Transforma as coordenadas dos botões em um tipo
 * {@link Casa} para o método {@link CalculaCampo#gerenciaJogadas(ICasa)}
 * 
 * @author Thiago dos Santos Fontes
 * @author Victor Fonseca Araujo
 * 
 */
public class SepararCoordenadas implements ISepararCoordenadas {
	private ICasa jogada;

	public SepararCoordenadas() {
		this.jogada = new Casa();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.ISepararCoordenadas#enviaJogada(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public ICasa enviaJogada(String auxiliar, String termoSeparador) {
		int i = 0;
		StringTokenizer tokenCoords = new StringTokenizer(auxiliar,
				termoSeparador);
		while (tokenCoords.hasMoreTokens()) {
			if (i == 0) {
				this.jogada.setX(Integer.parseInt(tokenCoords.nextToken()));
				i++;
			} else
				this.jogada.setY(Integer.parseInt(tokenCoords.nextToken()));
		}
		return this.jogada;
	}
}
