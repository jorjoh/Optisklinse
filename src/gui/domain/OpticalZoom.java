package gui.domain;


import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jørgen Johansen on 17.02.2016.
 */
public class OpticalZoom extends MoveableComponent implements Observer {

	private Image image;

	/*Varriabler*/
	final int WIDTH = 200;
	final int HEIGHT = 200;
	double resize = 100;
	int nyBredde;
	int nyHøyde;
	int denHalveNyeBredde;
	int denHalveNyeHøyde;

	public OpticalZoom(Background background) {
		image = background.getimage();
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		zoomingCalculations();
		Rectangle rectangle = new Rectangle(getX() + nyBredde - denHalveNyeBredde, getY() + nyHøyde - denHalveNyeHøyde, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(),
					rectangle.x, rectangle.y,
					rectangle.x + recalculate(WIDTH), rectangle.y + recalculate(HEIGHT),
					null);
			g.setColor(Color.RED);
			g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
	}

	private int recalculate(double q) {
		double d = q / (resize / 100);
		return (int) Math.round(d);
	}

	@Override
	public void update(Observable o, Object arg) {
		resize = (Integer) arg;
		repaint();
	}

	private void zoomingCalculations() {
		nyBredde = WIDTH / 2;
		nyHøyde = HEIGHT / 2;
		denHalveNyeBredde = recalculate(WIDTH) / 2;
		denHalveNyeHøyde = recalculate(HEIGHT) / 2;
	}
}
