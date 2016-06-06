package controller;

import java.util.Observable;

/**
 * Created by Jørgen Johansen on 17.02.2016.
 */
public class WindowObservable extends Observable {

	public void setValue(int i) {
		setChanged();
		notifyObservers(i);
		clearChanged();

	}

}
