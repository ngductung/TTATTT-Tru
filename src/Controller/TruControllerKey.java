package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import View.TruView;

public class TruControllerKey implements KeyListener{
	TruView view;

	public TruControllerKey(TruView view) {
		this.view = view;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == 10) {
			view.setOutput();
		} else if (code == 27) {
			view.refresh();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
