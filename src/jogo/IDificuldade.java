package jogo;

import java.awt.Dimension;

/**
 * Interface implementada por {@link Dificuldade}
 * 
 * @author Thiago dos Santos Fontes
 * @author Victor Fonseca Araujo
 * 
 */
public interface IDificuldade {

	/**
	 * Define a dificuldade
	 * 
	 * @param nivel
	 *            O n�vel vai de 1-3 se o parametro n�o estiver no intervalo o
	 *            nivel ser� 1.
	 */
	public abstract void setDificuldade(int nivel);

	/**
	 * Define dificuldade perspnalizada
	 * 
	 * @param numeroDeL
	 *            N�mero de casas por linha
	 * @param numeroDeC
	 *            N�mero de casas por coluna
	 * @param numeroDeB
	 *            N�mero de bombas no Campo
	 */
	public abstract void setPersonalizada(int numeroDeL, int numeroDeC,
			int numeroDeB);

	/**
	 * M�todo get padr�o
	 * 
	 * @return Retorna o n�mero de casas por linha instanciado no objeto
	 */
	public abstract int getLinhas();

	/**
	 * M�todo get padr�o
	 * 
	 * @return Retorna o n�mero de casas por coluna instanciado no objeto
	 */
	public abstract int getColunas();

	/**
	 * M�todo get padr�o
	 * 
	 * @return Retorna o n�mero de bombas instanciadas no objeto
	 */
	public abstract int getBombas();

	/**
	 * M�todo get padr�o
	 * 
	 * @return Retorna o {@link Campo} criado com base nos parametros da
	 *         {@link Dificuldade}.
	 */
	public abstract ICampo getCampo();

	/**
	 * M�todo get padr�o
	 * 
	 * @return Retorna o nivel de {@link Dificuldade} instanciado no objeto
	 */
	public abstract int getNivel();

	/**
	 * M�todo get padr�o
	 * 
	 * @return Retorna a dimens�o instaciado no objeto
	 */
	public abstract Dimension getDimensoes();

}