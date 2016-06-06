package gui.domain;

import controller.WindowObservable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Created by Jørgen Johansen on 17.02.2016.
 */
public class ZoomController extends JFrame implements ChangeListener{
	int min = 50;
	int max = 200;
	int value = 100;
	int i;

	JFrame zoomingArea = new JFrame();
	JSlider slider = new JSlider(min,max,value);

	WindowObservable windowObservable = new WindowObservable();

	public ZoomController(OpticalZoom opticalZoom) {
		zoomingArea.setTitle("ZoomController");
		zoomingArea.setSize(500, 150);
		zoomingArea.setLocation(0, 200);
		zoomingArea.setLayout(new BorderLayout());
		zoomingArea.setVisible(true);
		zoomingArea.add(slider, BorderLayout.CENTER);

		windowObservable.addObserver(opticalZoom);

		slider.addChangeListener(this);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(10);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		i = slider.getValue();
		windowObservable.setValue(i);

	}
}
