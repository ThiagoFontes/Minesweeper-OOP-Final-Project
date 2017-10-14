package jogo;
/**
 * Classe casa é uma abstração de casa casa presente no jogo guarda suas
 * coordenadas, valor e um modificador que indica se o programa deve apresentar
 * as casas ao redor, esta
 * 
 * @author Thiago Dos Santos Fontes
 * @author Victor Fonseca Araujo
 */
public class Casa implements ICasa {
	private int x;
	private int y;
	int valor;
	private Boolean mostrarArredores;

	/**
	 * Construtor padrão.
	 */
	public Casa() {

	}

	/**
	 * Contrutor com parametros, instacia a casa já com as coordenadas.
	 * @param x Coordenada x.
	 * @param y Coordenada y.
	 */
	public Casa(int x, int y) {
		this.x = x;
		this.y = y;
		valor = 0;
		mostrarArredores = true;
	}

	/* (non-Javadoc)
	 * @see jogo.ICasa#incrementaValor()
	 */
	@Override
	public void incrementaValor() {
		this.valor++;
	}

	/* (non-Javadoc)
	 * @see jogo.ICasa#getValor()
	 */
	@Override
	public int getValor() {
		return valor;
	}

	/* (non-Javadoc)
	 * @see jogo.ICasa#setValor(int)
	 */
	@Override
	public void setValor(int valor) {
		this.valor = valor;
	}

	/* (non-Javadoc)
	 * @see jogo.ICasa#getX()
	 */
	@Override
	public int getX() {
		return x;
	}

	/* (non-Javadoc)
	 * @see jogo.ICasa#setX(int)
	 */
	@Override
	public void setX(int x) {
		this.x = x;
	}

	/* (non-Javadoc)
	 * @see jogo.ICasa#getY()
	 */
	@Override
	public int getY() {
		return y;
	}

	/* (non-Javadoc)
	 * @see jogo.ICasa#setY(int)
	 */
	@Override
	public void setY(int y) {
		this.y = y;
	}

	/* (non-Javadoc)
	 * @see jogo.ICasa#getMostrarArredores()
	 */
	@Override
	public Boolean getMostrarArredores() {
		return mostrarArredores;
	}

	/* (non-Javadoc)
	 * @see jogo.ICasa#setMostrarArredores(java.lang.Boolean)
	 */
	@Override
	public void setMostrarArredores(Boolean mostrarArredores) {
		this.mostrarArredores = mostrarArredores;
	}

	/* (non-Javadoc)
	 * @see jogo.ICasa#toString()
	 */
	@Override
	public String toString() {
		return "Casa [x=" + x + ", y=" + y + ", mostrarArredores="
				+ mostrarArredores + "]";
	}

}
