package jogo;

import java.awt.Dimension;

/**
 * Esta classe define o campo em três diferentes dificuldades ou em uma
 * personalizada
 * 
 * @author Thiago
 * 
 */

public class Dificuldade implements IDificuldade {
	private ICampo campo;
	private int nivel = 1;
	private Dimension dimensoes;

	/**
	 * Construtor sem parametros. Inicia com a dificuldade 1.
	 */
	public Dificuldade() {
		campo = new Campo();
		dimensoes = new Dimension();
		setDificuldade(this.nivel);
	}

	/**
	 * Construtor com parametro para definir a dificuldade.
	 * 
	 * @param nivel
	 *            Define o nivel do jogo de 1-3 se estiver fora do intervaloa dificuldade será 1.
	 */
	public Dificuldade(int nivel) {
		campo = new Campo();
		dimensoes = new Dimension();
		setDificuldade(nivel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.IDificuldade#setDificuldade(int)
	 */
	@Override
	public void setDificuldade(int nivel) {
		this.nivel = nivel;
		switch (this.nivel) {
		case 1:
			campo.setNDeLinhas(9);
			campo.setNDeColunas(9);
			campo.setNDeBombas(10);
			dimensoes.setSize(9 * 33, 9 * 34);
			break;
		case 2:
			campo.setNDeLinhas(16);
			campo.setNDeColunas(16);
			campo.setNDeBombas(40);
			dimensoes.setSize(16 * 33, 16 * 34);
			break;
		case 3:
			campo.setNDeLinhas(16);
			campo.setNDeColunas(30);
			campo.setNDeBombas(99);
			dimensoes.setSize(30 * 33, 16 * 34);
			break;
		default:
			campo.setNDeLinhas(9);
			campo.setNDeColunas(9);
			campo.setNDeBombas(10);
			dimensoes.setSize(9 * 33, 9 * 34);
			break;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.IDificuldade#setPersonalizada(int, int, int)
	 */
	@Override
	public void setPersonalizada(int numeroDeL, int numeroDeC, int numeroDeB) {
		campo.setNDeLinhas(numeroDeL);
		campo.setNDeColunas(numeroDeC);
		campo.setNDeBombas(numeroDeB);
		dimensoes.setSize(numeroDeL * 33, numeroDeC * 34);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.IDificuldade#getLinhas()
	 */
	@Override
	public int getLinhas() {
		return this.campo.getNDeLinhas();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.IDificuldade#getColunas()
	 */
	@Override
	public int getColunas() {
		return this.campo.getNDeColunas();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.IDificuldade#getBombas()
	 */
	@Override
	public int getBombas() {
		return this.campo.getNDeBombas();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.IDificuldade#getCampo()
	 */
	@Override
	public ICampo getCampo() {
		return campo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.IDificuldade#getNivel()
	 */
	@Override
	public int getNivel() {
		return nivel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jogo.IDificuldade#getDimensoes()
	 */
	@Override
	public Dimension getDimensoes() {
		return dimensoes;
	}

}
