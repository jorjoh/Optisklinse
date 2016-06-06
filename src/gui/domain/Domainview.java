package gui.domain;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Domainview extends JPanel {

	Background background = new Background();
	MoveableGlass glassbehind = new MoveableGlass();
	MoveableGlass glassinfront = new MoveableGlass();
	OpticalZoom opticalZoomglass = new OpticalZoom(background);

	public Domainview() {
		setLayout(null);
		//add(glassinfront);
		add(opticalZoomglass);
		add(background);
		add(glassbehind);
		new ZoomController(opticalZoomglass);
	}

	public void selectGlassColor() {
		glassinfront.selectGlassColor();

	}

	public void selectShape() {
		glassinfront.selectShape();

	}

	public Dimension getTheSize() {
		return background.getSize();
	}

}
