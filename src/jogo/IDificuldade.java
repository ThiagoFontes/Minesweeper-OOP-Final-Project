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
	 *            O nível vai de 1-3 se o parametro não estiver no intervalo o
	 *            nivel será 1.
	 */
	public abstract void setDificuldade(int nivel);

	/**
	 * Define dificuldade perspnalizada
	 * 
	 * @param numeroDeL
	 *            Número de casas por linha
	 * @param numeroDeC
	 *            Número de casas por coluna
	 * @param numeroDeB
	 *            Número de bombas no Campo
	 */
	public abstract void setPersonalizada(int numeroDeL, int numeroDeC,
			int numeroDeB);

	/**
	 * Método get padrão
	 * 
	 * @return Retorna o número de casas por linha instanciado no objeto
	 */
	public abstract int getLinhas();

	/**
	 * Método get padrão
	 * 
	 * @return Retorna o número de casas por coluna instanciado no objeto
	 */
	public abstract int getColunas();

	/**
	 * Método get padrão
	 * 
	 * @return Retorna o número de bombas instanciadas no objeto
	 */
	public abstract int getBombas();

	/**
	 * Método get padrão
	 * 
	 * @return Retorna o {@link Campo} criado com base nos parametros da
	 *         {@link Dificuldade}.
	 */
	public abstract ICampo getCampo();

	/**
	 * Método get padrão
	 * 
	 * @return Retorna o nivel de {@link Dificuldade} instanciado no objeto
	 */
	public abstract int getNivel();

	/**
	 * Método get padrão
	 * 
	 * @return Retorna a dimensão instaciado no objeto
	 */
	public abstract Dimension getDimensoes();

}