package jogo;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 * Classe que define um Jpanel com um plano de fundo.
 * 
 * @author Thiago dos Santos Fontes
 * @author Victor Fonseca Araujo
 *
 */
public class PainelDeConteudo extends JPanel implements IPainelDeConteudo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3912256902721066731L;
	private Image bImagem;
	public PainelDeConteudo(Image bImagem) {
		this.bImagem = bImagem;
	}
	/**
	 * Construtor recebe String como parametro
	 * @param arquivoI Caminho do arquivo
	 */
	public PainelDeConteudo(String arquivoI){
		this.bImagem = new ImageIcon(getClass().getResource("Img/"+arquivoI)).getImage();
		if (bImagem==null){
			throw new NullPointerException("A imagem não existe");
		}
	}
	protected void paintComponent(final Graphics g) {

		super.paintComponent(g);

		g.drawImage(bImagem, 0, 0, this);

	}
}
