package View;

import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.TruController;
import Controller.TruControllerKey;
import Model.TruModel;

public class TruView extends JFrame {

	private JPanel contentPane;
	private JTextField inputP;
	private JTextField inputW;
	private JTextField inputT;
	private JTextField inputA;
	private JTextField inputB;
	private JTextField outputText;

	public TruModel model = new TruModel();

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public TruView() throws IOException {
		setTitle("Trừ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(ImageIO.read(new File(".\\icon.png")));
		TruController controller = new TruController(this);
		TruControllerKey key = new TruControllerKey(this);
		setLocationRelativeTo(null);
		setBounds(-14, -30, 1058, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("p = ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(48, 49, 53, 35);
		contentPane.add(lblNewLabel);

		inputP = new JTextField();
		inputP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		inputP.setBounds(110, 51, 172, 29);
		contentPane.add(inputP);
		inputP.setColumns(10);
		inputP.addKeyListener(key);

		JLabel lblW = new JLabel("w = ");
		lblW.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblW.setBounds(381, 51, 53, 35);
		contentPane.add(lblW);

		inputW = new JTextField();
		inputW.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		inputW.setColumns(10);
		inputW.setBounds(432, 51, 172, 29);
		contentPane.add(inputW);
		inputW.addKeyListener(key);

		JLabel lblT = new JLabel("t = ");
		lblT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblT.setBounds(733, 51, 53, 35);
		contentPane.add(lblT);

		inputT = new JTextField();
		inputT.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		inputT.setColumns(10);
		inputT.setBounds(784, 51, 172, 29);
		contentPane.add(inputT);
		inputT.addKeyListener(key);

		JLabel lblA = new JLabel("a = ");
		lblA.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblA.setBounds(144, 129, 53, 35);
		contentPane.add(lblA);

		inputA = new JTextField();
		inputA.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		inputA.setColumns(10);
		inputA.setBounds(198, 131, 288, 29);
		contentPane.add(inputA);
		inputA.addKeyListener(key);

		JLabel lblB = new JLabel("b = ");
		lblB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblB.setBounds(551, 127, 53, 35);
		contentPane.add(lblB);

		inputB = new JTextField();
		inputB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		inputB.setColumns(10);
		inputB.setBounds(605, 129, 288, 29);
		contentPane.add(inputB);
		inputB.addKeyListener(key);

		JButton btn_cal = new JButton("Tính");
		btn_cal.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btn_cal.setBounds(767, 257, 147, 49);
		contentPane.add(btn_cal);
		btn_cal.addActionListener(controller);

		outputText = new JTextField();
		outputText.setText("Kết quả");
		outputText.setHorizontalAlignment(SwingConstants.CENTER);
		outputText.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		outputText.setBounds(68, 220, 604, 155);
		contentPane.add(outputText);
		outputText.setColumns(10);
		outputText.addKeyListener(key);

		JButton btn_refresh = new JButton("Refresh");
		btn_refresh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btn_refresh.setBounds(918, 428, 101, 49);
		contentPane.add(btn_refresh);
		btn_refresh.addActionListener(controller);
	}

	public void refresh() {
		inputA.setText("");
		inputB.setText("");
		inputP.setText("");
		inputW.setText("");
		inputT.setText("");
		outputText.setText("Kết quả");
	}

	public boolean processInput() {
		String a = inputA.getText();
		String b = inputB.getText();
		String p = inputP.getText().trim();
		String w = inputW.getText().trim();
		String t = inputT.getText().trim();
		if (p.equals("") && t.equals("")) {
			JOptionPane.showMessageDialog(this, "Hãy nhập p hoặc t", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (w.equals("")) {
			JOptionPane.showMessageDialog(this, "Hãy nhập w", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (a.equals("")) {
			JOptionPane.showMessageDialog(this, "Hãy nhập a", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (b.equals("")) {
			JOptionPane.showMessageDialog(this, "Hãy nhập b", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		model.setA(processInputArray(a));
		model.setB(processInputArray(b));
		model.setW(Integer.parseInt(w));
		if (t.equals("")) {
			model.setT(0);
		} else {
			model.setT(Integer.parseInt(t));
		}
		if (p.equals("")) {
			model.setP(0);
		} else {
			model.setP(Integer.parseInt(p));
		}
		return true;
	}

	public void setOutput() {
		if (!processInput()) {
			return;
		} else {
			try {
				int[] a;
				if (model.getP() != 0) {
					a = model.getResulthaveP();
				} else {
					a = model.getResultdonthaveP();
				}
				String result = "";
				for (int temp : a) {
					result += temp + ", ";
				}
				result = result.substring(0, result.length() - 2);
				result = "( " + model.getZ() + ", ( " + result + " ) )";
				outputText.setText(result);
			} catch (Exception e) {
				outputText.setText("Kết quả");
				JOptionPane.showMessageDialog(this, "Lỗi tính toán", "ERROR", JOptionPane.ERROR_MESSAGE);
			}

		}

	}

	public int[] processInputArray(String a) {
		String[] s = a.split(",");
		int[] z = new int[s.length];
		int k = 0;
		for (String temp : s) {
			try {
				int i = Integer.parseInt(temp.trim());
				z[k++] = i;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		int[] l = new int[k];
		for (int i = 0; i < k; i++) {
			l[i] = z[i];
		}
		return l;
	}
}
