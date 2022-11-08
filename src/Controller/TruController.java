package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.TruView;

public class TruController implements ActionListener {
	TruView view;

	public TruController(TruView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equalsIgnoreCase("refresh")) {
			view.refresh();
		} else if (command.equalsIgnoreCase("Tính")){
			view.setOutput();
		}

	}
}
