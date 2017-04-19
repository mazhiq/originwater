package application;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.InputVerifier;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.Action;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import engine.*;
import engine.Calculate;
import engine.Process;
import engine.SystemModel;
import engine.Water;

import java.util.ArrayList;

public class InputDiag extends JFrame {

	private JPanel contentPane;
	private JTextField textField_TDS;
	private JTextField textField_T;
	private JTextField textField_pH;
	private JTextField textField_PF;
	private JTextField textField_1DR;
	private JTextField textField_1DM;
	private JTextField textField_2DR;
	private JTextField textField_2DM;
	private JTextField textField_bP;
	private JTextField textField_HSL;
	private JTextField textField_CS;
	private final Action action_JS = new Action_JS();
	private final Action action_RES = new Action_RES();
	private JComboBox comboBox_DS;
	private JComboBox comboBox_MType;
	private JButton Button_JS;
	private JButton Button_res;
	private InputVerifier veriFier_TDS;
	private InputVerifier verifier_1DR;
	private InputVerifier verifier_1DM;
	private InputVerifier verifier_2DR;
	private InputVerifier verifier_2DM;
	private InputVerifier verifier_BP;
	private InputVerifier verifier_PF;
	private InputVerifier verifier_pH;
	private InputVerifier verifier_T;
	private InputVerifier verifier_CS;
	private InputVerifier verifier_HSL;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel lblMpa;
	private JLabel lblmh;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField textField;

	static double M = 58.44;
	static DisplayDiag DD;
	static Water water;
	static Process PP;
	static java.text.DecimalFormat df = new java.text.DecimalFormat("0.000");
	static Branch br;
	static Calculate calculate = new Calculate();
	static SystemModel systemmodel;
	private JLabel Label_JS;
	private JLabel error_TDS;
	private JLabel error_pH;
	private JLabel error_T;
	private JLabel error_PF;
	private JLabel lblmgl;
	private JLabel label_7;
	private JLabel error_1DM;
	private JLabel error_1DR;
	private JLabel error_BP;
	private JLabel error_2DR;
	private JLabel error_2DM;
	private JLabel error_HSL;
	private JLabel error_CS;

	public InputDiag() {
		water = new Water(2000.0, 25, 0.85, 7.6);
		PP = new Process(2, 2, 3, 1, 3, 0, "BW_8040", 7.5, 0.6);
		setTitle("RO工艺设计");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = 565;
		int height = 477;
		setBounds((d.width - width) / 2, (d.height - height) / 2, 565, 477);
		setResizable(false); // 禁止最大化及缩放功能
		init();
		setpara();
		verifier();
		action();

	}

	public void init() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel_water = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(18, Short.MAX_VALUE)
						.addComponent(panel_water, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)));
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel_water, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE).addContainerGap()));
		SpringLayout sl_panel_water = new SpringLayout();
		panel_water.setLayout(sl_panel_water);

		// 创建Label，并输入提示信息
		JLabel label_Water = new JLabel("原水水质");
		JLabel lblTds = new JLabel("TDS");
		sl_panel_water.putConstraint(SpringLayout.EAST, lblTds, -459, SpringLayout.EAST, panel_water);
		sl_panel_water.putConstraint(SpringLayout.SOUTH, label_Water, -18, SpringLayout.NORTH, lblTds);
		sl_panel_water.putConstraint(SpringLayout.WEST, lblTds, 0, SpringLayout.WEST, panel_water);
		JLabel label_T = new JLabel("温度");
		sl_panel_water.putConstraint(SpringLayout.NORTH, label_T, 26, SpringLayout.SOUTH, lblTds);
		sl_panel_water.putConstraint(SpringLayout.WEST, label_T, 0, SpringLayout.WEST, panel_water);
		sl_panel_water.putConstraint(SpringLayout.EAST, label_T, 0, SpringLayout.EAST, lblTds);
		JLabel label_pH = new JLabel("pH");
		sl_panel_water.putConstraint(SpringLayout.NORTH, label_pH, 0, SpringLayout.NORTH, lblTds);
		JLabel label_PF = new JLabel("污染因子");
		sl_panel_water.putConstraint(SpringLayout.EAST, label_PF, 0, SpringLayout.EAST, label_pH);
		sl_panel_water.putConstraint(SpringLayout.NORTH, label_PF, 0, SpringLayout.NORTH, label_T);
		JLabel label_process = new JLabel("系统配置");
		sl_panel_water.putConstraint(SpringLayout.WEST, label_process, 0, SpringLayout.WEST, label_Water);
		sl_panel_water.putConstraint(SpringLayout.EAST, label_process, -440, SpringLayout.EAST, panel_water);
		JLabel label_DS = new JLabel("段数");
		sl_panel_water.putConstraint(SpringLayout.NORTH, label_DS, 180, SpringLayout.NORTH, panel_water);
		sl_panel_water.putConstraint(SpringLayout.SOUTH, label_process, -27, SpringLayout.NORTH, label_DS);
		sl_panel_water.putConstraint(SpringLayout.WEST, label_DS, 0, SpringLayout.WEST, label_Water);
		sl_panel_water.putConstraint(SpringLayout.EAST, label_DS, -432, SpringLayout.EAST, panel_water);
		JLabel label_1DR = new JLabel("一段压力容器数");
		sl_panel_water.putConstraint(SpringLayout.NORTH, label_1DR, 26, SpringLayout.SOUTH, label_DS);
		sl_panel_water.putConstraint(SpringLayout.WEST, label_1DR, 0, SpringLayout.WEST, panel_water);
		JLabel label_1DM = new JLabel("一段内膜元件数");
		sl_panel_water.putConstraint(SpringLayout.NORTH, label_1DM, 28, SpringLayout.SOUTH, label_1DR);
		sl_panel_water.putConstraint(SpringLayout.WEST, label_1DM, 0, SpringLayout.WEST, label_Water);
		sl_panel_water.putConstraint(SpringLayout.EAST, label_1DM, -432, SpringLayout.EAST, panel_water);
		JLabel label_2DR = new JLabel("二段压力容器数");
		sl_panel_water.putConstraint(SpringLayout.NORTH, label_2DR, 26, SpringLayout.SOUTH, label_1DM);
		sl_panel_water.putConstraint(SpringLayout.WEST, label_2DR, 0, SpringLayout.WEST, label_Water);
		sl_panel_water.putConstraint(SpringLayout.EAST, label_2DR, -432, SpringLayout.EAST, panel_water);
		JLabel label_2DM = new JLabel("二段内膜元件数");
		sl_panel_water.putConstraint(SpringLayout.NORTH, label_2DM, 24, SpringLayout.SOUTH, label_2DR);
		sl_panel_water.putConstraint(SpringLayout.WEST, label_2DM, 0, SpringLayout.WEST, label_Water);
		sl_panel_water.putConstraint(SpringLayout.EAST, label_2DM, -432, SpringLayout.EAST, panel_water);
		JLabel label_mType = new JLabel("膜元件型号");
		sl_panel_water.putConstraint(SpringLayout.NORTH, label_mType, 0, SpringLayout.NORTH, label_DS);
		JLabel lblmpa = new JLabel("段间增压");
		sl_panel_water.putConstraint(SpringLayout.NORTH, lblmpa, 0, SpringLayout.NORTH, label_1DR);
		sl_panel_water.putConstraint(SpringLayout.EAST, lblmpa, 0, SpringLayout.EAST, label_mType);
		JLabel lblml = new JLabel("系统进水量");
		sl_panel_water.putConstraint(SpringLayout.EAST, lblml, 0, SpringLayout.EAST, label_mType);
		sl_panel_water.putConstraint(SpringLayout.NORTH, lblml, 0, SpringLayout.NORTH, label_1DM);
		JLabel label_HSL = new JLabel("系统回收率");
		sl_panel_water.putConstraint(SpringLayout.NORTH, label_HSL, 0, SpringLayout.NORTH, label_2DR);
		JLabel label_CS = new JLabel("系统产水量");
		sl_panel_water.putConstraint(SpringLayout.NORTH, label_CS, 0, SpringLayout.NORTH, label_2DM);
		sl_panel_water.putConstraint(SpringLayout.WEST, label_Water, 0, SpringLayout.WEST, panel_water);
		panel_water.add(label_Water);
		sl_panel_water.putConstraint(SpringLayout.NORTH, lblTds, 53, SpringLayout.NORTH, panel_water);
		panel_water.add(lblTds);
		panel_water.add(label_T);
		panel_water.add(label_pH);
		panel_water.add(label_PF);

		textField_TDS = new JTextField();
		sl_panel_water.putConstraint(SpringLayout.NORTH, textField_TDS, -3, SpringLayout.NORTH, lblTds);
		sl_panel_water.putConstraint(SpringLayout.WEST, textField_TDS, 33, SpringLayout.EAST, lblTds);
		sl_panel_water.putConstraint(SpringLayout.EAST, textField_TDS, -352, SpringLayout.EAST, panel_water);
		panel_water.add(textField_TDS);

		textField_T = new JTextField();
		sl_panel_water.putConstraint(SpringLayout.EAST, textField_T, 0, SpringLayout.EAST, textField_TDS);
		sl_panel_water.putConstraint(SpringLayout.NORTH, textField_T, -3, SpringLayout.NORTH, label_T);
		sl_panel_water.putConstraint(SpringLayout.WEST, textField_T, 33, SpringLayout.EAST, label_T);
		panel_water.add(textField_T);

		textField_pH = new JTextField();
		sl_panel_water.putConstraint(SpringLayout.EAST, label_pH, -16, SpringLayout.WEST, textField_pH);
		sl_panel_water.putConstraint(SpringLayout.NORTH, textField_pH, -3, SpringLayout.NORTH, lblTds);
		sl_panel_water.putConstraint(SpringLayout.WEST, textField_pH, 366, SpringLayout.WEST, panel_water);
		textField_pH.setColumns(10);
		panel_water.add(textField_pH);

		textField_PF = new JTextField();
		sl_panel_water.putConstraint(SpringLayout.WEST, textField_PF, 366, SpringLayout.WEST, panel_water);
		sl_panel_water.putConstraint(SpringLayout.NORTH, textField_PF, -3, SpringLayout.NORTH, label_T);
		sl_panel_water.putConstraint(SpringLayout.EAST, textField_PF, -91, SpringLayout.EAST, panel_water);
		textField_PF.setColumns(10);
		panel_water.add(textField_PF);
		panel_water.add(label_process);
		panel_water.add(label_DS);
		panel_water.add(label_1DR);
		panel_water.add(label_1DM);
		panel_water.add(label_2DR);
		panel_water.add(label_2DM);

		comboBox_DS = new JComboBox();
		sl_panel_water.putConstraint(SpringLayout.WEST, label_mType, 141, SpringLayout.EAST, comboBox_DS);
		sl_panel_water.putConstraint(SpringLayout.NORTH, comboBox_DS, -3, SpringLayout.NORTH, label_DS);
		sl_panel_water.putConstraint(SpringLayout.WEST, comboBox_DS, 6, SpringLayout.EAST, label_DS);
		panel_water.add(comboBox_DS);

		comboBox_DS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Integer.parseInt((String) comboBox_DS.getSelectedItem()) == 1) {
					textField_2DR.setEditable(false);
					textField_2DM.setEditable(false);
					textField_2DR.setBackground(Color.LIGHT_GRAY);
					textField_2DM.setBackground(Color.LIGHT_GRAY);

				} else {
					textField_2DR.setBackground(Color.WHITE);
					textField_2DM.setBackground(Color.WHITE);
					textField_2DR.setEditable(true);
					textField_2DM.setEditable(true);
				}
			}
		});

		textField_1DR = new JTextField();
		sl_panel_water.putConstraint(SpringLayout.EAST, label_1DR, -6, SpringLayout.WEST, textField_1DR);
		sl_panel_water.putConstraint(SpringLayout.EAST, textField_1DR, 0, SpringLayout.EAST, textField_TDS);
		sl_panel_water.putConstraint(SpringLayout.NORTH, textField_1DR, -3, SpringLayout.NORTH, label_1DR);
		sl_panel_water.putConstraint(SpringLayout.WEST, textField_1DR, 0, SpringLayout.WEST, textField_TDS);
		textField_1DR.setColumns(10);
		panel_water.add(textField_1DR);

		textField_1DM = new JTextField();
		sl_panel_water.putConstraint(SpringLayout.NORTH, textField_1DM, -3, SpringLayout.NORTH, label_1DM);
		sl_panel_water.putConstraint(SpringLayout.WEST, textField_1DM, 0, SpringLayout.WEST, textField_TDS);
		sl_panel_water.putConstraint(SpringLayout.EAST, textField_1DM, 0, SpringLayout.EAST, textField_TDS);
		textField_1DM.setColumns(10);
		panel_water.add(textField_1DM);

		textField_2DR = new JTextField();
		sl_panel_water.putConstraint(SpringLayout.NORTH, textField_2DR, -3, SpringLayout.NORTH, label_2DR);
		sl_panel_water.putConstraint(SpringLayout.WEST, textField_2DR, 0, SpringLayout.WEST, textField_TDS);
		sl_panel_water.putConstraint(SpringLayout.EAST, textField_2DR, 0, SpringLayout.EAST, textField_TDS);
		textField_2DR.setColumns(10);
		panel_water.add(textField_2DR);

		textField_2DM = new JTextField();
		sl_panel_water.putConstraint(SpringLayout.NORTH, textField_2DM, -3, SpringLayout.NORTH, label_2DM);
		sl_panel_water.putConstraint(SpringLayout.WEST, textField_2DM, 105, SpringLayout.WEST, panel_water);
		sl_panel_water.putConstraint(SpringLayout.EAST, textField_2DM, -354, SpringLayout.EAST, panel_water);
		textField_2DM.setColumns(10);
		panel_water.add(textField_2DM);
		panel_water.add(label_mType);
		panel_water.add(lblmpa);
		panel_water.add(lblml);
		panel_water.add(label_HSL);
		panel_water.add(label_CS);

		comboBox_MType = new JComboBox();
		sl_panel_water.putConstraint(SpringLayout.EAST, label_mType, -8, SpringLayout.WEST, comboBox_MType);
		sl_panel_water.putConstraint(SpringLayout.WEST, comboBox_MType, 366, SpringLayout.WEST, panel_water);
		sl_panel_water.putConstraint(SpringLayout.EAST, textField_pH, 0, SpringLayout.EAST, comboBox_MType);
		sl_panel_water.putConstraint(SpringLayout.NORTH, comboBox_MType, -3, SpringLayout.NORTH, label_DS);
		panel_water.add(comboBox_MType);

		textField_bP = new JTextField();
		sl_panel_water.putConstraint(SpringLayout.NORTH, textField_bP, -3, SpringLayout.NORTH, label_1DR);
		sl_panel_water.putConstraint(SpringLayout.WEST, textField_bP, 0, SpringLayout.WEST, textField_pH);
		sl_panel_water.putConstraint(SpringLayout.EAST, textField_bP, 0, SpringLayout.EAST, textField_pH);
		textField_bP.setColumns(10);
		panel_water.add(textField_bP);

		textField_HSL = new JTextField();
		sl_panel_water.putConstraint(SpringLayout.EAST, label_HSL, -8, SpringLayout.WEST, textField_HSL);
		sl_panel_water.putConstraint(SpringLayout.NORTH, textField_HSL, -3, SpringLayout.NORTH, label_2DR);
		sl_panel_water.putConstraint(SpringLayout.WEST, textField_HSL, 0, SpringLayout.WEST, textField_pH);
		sl_panel_water.putConstraint(SpringLayout.EAST, textField_HSL, 0, SpringLayout.EAST, textField_pH);
		textField_HSL.setColumns(10);
		panel_water.add(textField_HSL);

		textField_CS = new JTextField();
		sl_panel_water.putConstraint(SpringLayout.EAST, label_CS, -16, SpringLayout.WEST, textField_CS);
		sl_panel_water.putConstraint(SpringLayout.NORTH, textField_CS, -3, SpringLayout.NORTH, label_2DM);
		sl_panel_water.putConstraint(SpringLayout.WEST, textField_CS, 0, SpringLayout.WEST, textField_pH);
		sl_panel_water.putConstraint(SpringLayout.EAST, textField_CS, 0, SpringLayout.EAST, textField_pH);
		textField_CS.setColumns(10);
		panel_water.add(textField_CS);

		Button_JS = new JButton("计算");
		sl_panel_water.putConstraint(SpringLayout.WEST, Button_JS, 92, SpringLayout.WEST, panel_water);
		sl_panel_water.putConstraint(SpringLayout.SOUTH, Button_JS, -10, SpringLayout.SOUTH, panel_water);
		panel_water.add(Button_JS);

		Button_res = new JButton("重置");
		sl_panel_water.putConstraint(SpringLayout.NORTH, Button_res, 0, SpringLayout.NORTH, Button_JS);
		sl_panel_water.putConstraint(SpringLayout.EAST, Button_res, -121, SpringLayout.EAST, panel_water);
		panel_water.add(Button_res);

		label = new JLabel("个");
		sl_panel_water.putConstraint(SpringLayout.WEST, label_HSL, 83, SpringLayout.EAST, label);
		sl_panel_water.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, label_2DR);
		panel_water.add(label);

		label_1 = new JLabel("支");
		sl_panel_water.putConstraint(SpringLayout.WEST, label_CS, 83, SpringLayout.EAST, label_1);
		sl_panel_water.putConstraint(SpringLayout.NORTH, label_1, 0, SpringLayout.NORTH, label_2DM);
		sl_panel_water.putConstraint(SpringLayout.WEST, label_1, 6, SpringLayout.EAST, textField_2DM);
		panel_water.add(label_1);

		label_2 = new JLabel("个");
		sl_panel_water.putConstraint(SpringLayout.WEST, lblmpa, 83, SpringLayout.EAST, label_2);
		sl_panel_water.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, label_2);
		sl_panel_water.putConstraint(SpringLayout.NORTH, label_2, 0, SpringLayout.NORTH, label_1DR);
		panel_water.add(label_2);

		label_3 = new JLabel("支");
		sl_panel_water.putConstraint(SpringLayout.WEST, lblml, 83, SpringLayout.EAST, label_3);
		sl_panel_water.putConstraint(SpringLayout.NORTH, label_3, 25, SpringLayout.SOUTH, label_2);
		sl_panel_water.putConstraint(SpringLayout.WEST, label_3, 0, SpringLayout.WEST, label_2);
		panel_water.add(label_3);

		lblMpa = new JLabel("MPa");
		sl_panel_water.putConstraint(SpringLayout.NORTH, lblMpa, 0, SpringLayout.NORTH, label_1DR);
		sl_panel_water.putConstraint(SpringLayout.WEST, lblMpa, 6, SpringLayout.EAST, textField_bP);
		sl_panel_water.putConstraint(SpringLayout.EAST, lblMpa, -37, SpringLayout.EAST, panel_water);
		panel_water.add(lblMpa);

		lblmh = new JLabel("<html>m</font><sup>3</sup>h</html>");
		sl_panel_water.putConstraint(SpringLayout.NORTH, lblmh, -5, SpringLayout.NORTH, label_1DM);
		sl_panel_water.putConstraint(SpringLayout.EAST, lblmh, -37, SpringLayout.EAST, panel_water);
		panel_water.add(lblmh);

		label_4 = new JLabel("%");
		sl_panel_water.putConstraint(SpringLayout.NORTH, label_4, 0, SpringLayout.NORTH, label_2DR);
		sl_panel_water.putConstraint(SpringLayout.WEST, label_4, 6, SpringLayout.EAST, textField_HSL);
		sl_panel_water.putConstraint(SpringLayout.EAST, label_4, -37, SpringLayout.EAST, panel_water);
		panel_water.add(label_4);

		label_5 = new JLabel("<html>m</font><sup>3</sup>h</html>");
		sl_panel_water.putConstraint(SpringLayout.WEST, label_5, 6, SpringLayout.EAST, textField_CS);
		sl_panel_water.putConstraint(SpringLayout.SOUTH, label_5, 0, SpringLayout.SOUTH, label_2DM);
		sl_panel_water.putConstraint(SpringLayout.EAST, label_5, -37, SpringLayout.EAST, panel_water);
		panel_water.add(label_5);

		Label_JS = new JLabel("12.5");
		sl_panel_water.putConstraint(SpringLayout.WEST, lblmh, 56, SpringLayout.EAST, Label_JS);
		sl_panel_water.putConstraint(SpringLayout.NORTH, Label_JS, 0, SpringLayout.NORTH, label_1DM);
		sl_panel_water.putConstraint(SpringLayout.WEST, Label_JS, 0, SpringLayout.WEST, textField_pH);
		panel_water.add(Label_JS);

		error_TDS = new JLabel("");
		sl_panel_water.putConstraint(SpringLayout.NORTH, error_TDS, 0, SpringLayout.SOUTH, textField_TDS);
		sl_panel_water.putConstraint(SpringLayout.WEST, error_TDS, 0, SpringLayout.WEST, textField_TDS);
		panel_water.add(error_TDS);

		error_pH = new JLabel("");
		sl_panel_water.putConstraint(SpringLayout.NORTH, error_pH, 0, SpringLayout.NORTH, error_TDS);
		sl_panel_water.putConstraint(SpringLayout.WEST, error_pH, 0, SpringLayout.WEST, textField_pH);
		panel_water.add(error_pH);

		error_T = new JLabel("");
		sl_panel_water.putConstraint(SpringLayout.NORTH, error_T, 112, SpringLayout.NORTH, panel_water);
		sl_panel_water.putConstraint(SpringLayout.WEST, error_T, 0, SpringLayout.WEST, textField_TDS);
		panel_water.add(error_T);

		error_PF = new JLabel("");
		sl_panel_water.putConstraint(SpringLayout.NORTH, error_PF, 1, SpringLayout.SOUTH, textField_PF);
		sl_panel_water.putConstraint(SpringLayout.WEST, error_PF, 0, SpringLayout.WEST, textField_pH);
		panel_water.add(error_PF);

		lblmgl = new JLabel("mg/L");
		sl_panel_water.putConstraint(SpringLayout.WEST, label_pH, 71, SpringLayout.EAST, lblmgl);
		sl_panel_water.putConstraint(SpringLayout.WEST, label_2, 0, SpringLayout.WEST, lblmgl);
		sl_panel_water.putConstraint(SpringLayout.WEST, lblmgl, 4, SpringLayout.EAST, textField_TDS);
		sl_panel_water.putConstraint(SpringLayout.NORTH, lblmgl, 0, SpringLayout.NORTH, lblTds);
		panel_water.add(lblmgl);

		label_7 = new JLabel("℃");
		sl_panel_water.putConstraint(SpringLayout.WEST, label_PF, 83, SpringLayout.EAST, label_7);
		sl_panel_water.putConstraint(SpringLayout.NORTH, label_7, 0, SpringLayout.NORTH, label_T);
		sl_panel_water.putConstraint(SpringLayout.WEST, label_7, 4, SpringLayout.EAST, textField_T);
		panel_water.add(label_7);

		error_1DM = new JLabel("11");
		sl_panel_water.putConstraint(SpringLayout.NORTH, error_1DM, 0, SpringLayout.SOUTH, textField_1DM);
		sl_panel_water.putConstraint(SpringLayout.WEST, error_1DM, 0, SpringLayout.WEST, textField_TDS);
		panel_water.add(error_1DM);

		error_1DR = new JLabel("11");
		sl_panel_water.putConstraint(SpringLayout.WEST, error_1DR, 0, SpringLayout.WEST, textField_TDS);
		sl_panel_water.putConstraint(SpringLayout.SOUTH, error_1DR, -6, SpringLayout.NORTH, textField_1DM);
		panel_water.add(error_1DR);

		error_BP = new JLabel("11");
		sl_panel_water.putConstraint(SpringLayout.NORTH, error_BP, 240, SpringLayout.NORTH, panel_water);
		sl_panel_water.putConstraint(SpringLayout.WEST, error_BP, 0, SpringLayout.WEST, textField_pH);
		panel_water.add(error_BP);

		error_2DR = new JLabel("11");
		sl_panel_water.putConstraint(SpringLayout.NORTH, error_2DR, 1, SpringLayout.SOUTH, textField_2DR);
		sl_panel_water.putConstraint(SpringLayout.WEST, error_2DR, 0, SpringLayout.WEST, textField_TDS);
		panel_water.add(error_2DR);

		error_2DM = new JLabel("11");
		sl_panel_water.putConstraint(SpringLayout.NORTH, error_2DM, 1, SpringLayout.SOUTH, textField_2DM);
		sl_panel_water.putConstraint(SpringLayout.WEST, error_2DM, 0, SpringLayout.WEST, textField_TDS);
		panel_water.add(error_2DM);

		error_HSL = new JLabel("11");
		sl_panel_water.putConstraint(SpringLayout.NORTH, error_HSL, 0, SpringLayout.NORTH, error_2DR);
		sl_panel_water.putConstraint(SpringLayout.WEST, error_HSL, 0, SpringLayout.WEST, textField_pH);
		panel_water.add(error_HSL);

		error_CS = new JLabel("11");
		sl_panel_water.putConstraint(SpringLayout.NORTH, error_CS, 363, SpringLayout.NORTH, panel_water);
		sl_panel_water.putConstraint(SpringLayout.WEST, error_CS, 0, SpringLayout.WEST, textField_pH);
		panel_water.add(error_CS);
		contentPane.setLayout(gl_contentPane);
		verifier();

	}

	public void setpara() {
		textField_TDS.setText("2000");
		textField_pH.setText("7.6");
		textField_T.setText("25");
		textField_PF.setText("0.85");
		textField_1DR.setText("2");
		textField_1DM.setText("3");
		textField_2DR.setText("1");
		textField_2DM.setText("3");
		textField_bP.setText("0");
		textField_CS.setText("7.5");
		textField_HSL.setText("60");
		error_TDS.setText("");
		error_T.setText("");
		error_pH.setText("");
		error_PF.setText("");
		error_1DR.setText("");
		error_1DM.setText("");
		error_2DR.setText("");
		error_2DM.setText("");
		error_BP.setText("");
		error_HSL.setText("");
		error_CS.setText("");
		textField_TDS.setBackground(Color.WHITE);
		textField_pH.setBackground(Color.WHITE);
		textField_T.setBackground(Color.WHITE);
		textField_PF.setBackground(Color.WHITE);
		textField_1DR.setBackground(Color.WHITE);
		textField_1DM.setBackground(Color.WHITE);
		textField_2DR.setBackground(Color.LIGHT_GRAY);
		textField_2DM.setBackground(Color.LIGHT_GRAY);
		textField_bP.setBackground(Color.WHITE);
		textField_CS.setBackground(Color.WHITE);
		textField_HSL.setBackground(Color.WHITE);
		textField_2DR.setEditable(false);
		textField_2DM.setEditable(false);
		comboBox_DS.setModel(new DefaultComboBoxModel(new String[] { "1", "2" }));
		comboBox_MType.setModel(new DefaultComboBoxModel(new String[] { "BW_8040", "ULP_8040", "SW_8040" }));
		comboBox_DS.setSelectedItem("2");
		Label_JS.setText("12.5");

	}

	public void action() {
		// 监听计算动作
		Button_JS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Button_JS.setAction(action_JS);
		Button_JS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				verifier();
				if (textField_TDS.getBackground() != Color.PINK & textField_T.getBackground() != Color.PINK
						& textField_pH.getBackground() != Color.PINK & textField_PF.getBackground() != Color.PINK
						& textField_1DR.getBackground() != Color.PINK & textField_1DM.getBackground() != Color.PINK
						& textField_2DR.getBackground() != Color.PINK & textField_2DM.getBackground() != Color.PINK
						& textField_HSL.getBackground() != Color.PINK & textField_CS.getBackground() != Color.PINK
						& textField_bP.getBackground() != Color.PINK) {
					double process_JS = Double.parseDouble(textField_CS.getText())
							/ (Double.parseDouble(textField_HSL.getText()) / 100);
					Label_JS.setText(String.format("%.1f", process_JS));
					ArrayList<Double> DATA1 = new ArrayList<Double>();
					ArrayList<Object> obj = new ArrayList<Object>();
					obj = DATA();
					SetData();
					systemmodel = new SystemModel(PP.monum(1), PP.motype, PP.Pf(water.T, water.wryz, water.inTDS, M),
							PP.outvel / (PP.systemY * PP.nv1), water.inTDS, calculate.paif(water.T, water.inTDS, M),
							PP.avgPfc(), PP.systemY, PP.avgY(PP.systemY));
					DATA1 = systemmodel.SystemCalc(PP, PP.groupnum, PP.monum(PP.groupnum), PP.motype, PP.avgPfc(),
							PP.systemY, PP.avgY(PP.systemY));
					DD = new DisplayDiag(obj, DATA1);
					DD.frame.setVisible(true);
				}
				;
			}
		});
		// 监听重置动作
		Button_res.setAction(action_RES);
		Button_res.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setpara();
			}
		});

	}

	public void verifier() {

		textField_TDS.setInputVerifier(veriFier_TDS);
		textField_pH.setInputVerifier(verifier_pH);
		textField_T.setInputVerifier(verifier_T);
		textField_PF.setInputVerifier(verifier_PF);
		textField_1DR.setInputVerifier(verifier_1DR);
		textField_1DM.setInputVerifier(verifier_1DM);
		textField_2DR.setInputVerifier(verifier_2DR);
		textField_2DM.setInputVerifier(verifier_2DM);
		textField_bP.setInputVerifier(verifier_BP);
		textField_CS.setInputVerifier(verifier_CS);
		textField_HSL.setInputVerifier(verifier_HSL);

		// 验证TDS
		veriFier_TDS = new InputVerifier() {
			public boolean verify(JComponent comp) {
				boolean returnValue = false;
				textField = (JTextField) comp;
				try {
					if (textField.getText().matches("(0|[1-9]\\d*)(\\.\\d+)?")
							& Double.parseDouble(textField.getText()) < 10000
							& Double.parseDouble(textField.getText()) != 0) {
						textField.setBackground(Color.WHITE);
						error_TDS.setText("");
						returnValue = true;
					} else {
						textField.setBackground(Color.PINK);
						textField.setText("");
						error_TDS.setForeground(Color.RED);
						error_TDS.setText("参数应在0-10000之间!");
					}

				} catch (NumberFormatException e) {
					textField.setBackground(Color.PINK);
					if (textField.getText().matches("")) {
						textField.setText("");
						error_TDS.setForeground(Color.RED);
						error_TDS.setText("参数应在0-10000之间!");
						returnValue = false;
					} else {
						textField.setText("");
						error_TDS.setForeground(Color.RED);
						error_TDS.setText("参数应在0-10000之间!");
						returnValue = false;
					}
				}
				return returnValue;
			}
		};

		// 验证温度参数在0-50之间
		verifier_T = new InputVerifier() {
			public boolean verify(JComponent comp) {
				boolean returnValue = false;
				JTextField textField = (JTextField) comp;
				try {
					if (textField.getText().matches("(0|[1-9]\\d*)(\\.\\d+)?")
							& Double.parseDouble(textField.getText()) < 50
							& Double.parseDouble(textField.getText()) != 0) {
						textField.setBackground(Color.WHITE);
						error_T.setText("");
						returnValue = true;
					} else {
						textField.setBackground(Color.PINK);
						textField.setText("");
						error_T.setForeground(Color.RED);
						error_T.setText("参数应在0-50之间!");
					}

				} catch (NumberFormatException e) {
					textField.setBackground(Color.PINK);
					if (textField.getText().matches("")) {
						textField.setText("");
						error_T.setForeground(Color.RED);
						error_T.setText("参数应在0-50之间!");
						returnValue = false;
					} else {
						textField.setText("");
						error_T.setForeground(Color.RED);
						error_T.setText("参数应在0-50之间!");
						returnValue = false;
					}
				}
				return returnValue;
			}
		};

		// 验证pH值在2-12之间
		verifier_pH = new InputVerifier() {
			public boolean verify(JComponent comp) {
				boolean returnValue = false;
				JTextField textField = (JTextField) comp;
				try {
					if (textField.getText().matches("(0|[1-9]\\d*)(\\.\\d+)?")
							& Double.parseDouble(textField.getText()) > 2
							& Double.parseDouble(textField.getText()) < 12) {
						textField.setBackground(Color.WHITE);
						error_pH.setText("");
						returnValue = true;
					} else {
						textField.setBackground(Color.PINK);
						textField.setText("");
						error_pH.setForeground(Color.RED);
						error_pH.setText("参数应在2-12之间!");
					}

				} catch (NumberFormatException e) {
					textField.setBackground(Color.PINK);
					if (textField.getText().matches("")) {
						textField.setText("");
						error_pH.setForeground(Color.RED);
						error_pH.setText("参数应在2-12之间!");
						returnValue = false;
					} else {
						textField.setText("");
						error_pH.setForeground(Color.RED);
						error_pH.setText("参数应在2-12之间!");
						returnValue = false;
					}
				}
				return returnValue;
			}
		};

		// 验证污染因子
		verifier_PF = new InputVerifier() {
			public boolean verify(JComponent comp) {
				boolean returnValue = false;
				JTextField textField = (JTextField) comp;
				try {
					if (Double.parseDouble(textField.getText()) > 0 & Double.parseDouble(textField.getText()) < 1) {
						textField.setBackground(Color.WHITE);
						error_PF.setText("");
						returnValue = true;
					} else {
						textField.setBackground(Color.PINK);
						textField.setText("");
						error_PF.setForeground(Color.RED);
						error_PF.setText("参数应在0-1之间!");
					}

				} catch (NumberFormatException e) {
					textField.setBackground(Color.PINK);
					if (textField.getText().matches("")) {
						textField.setText("");
						error_PF.setForeground(Color.RED);
						error_PF.setText("参数应在0-1之间!");
						returnValue = false;
					} else {
						textField.setText("");
						error_PF.setForeground(Color.RED);
						error_PF.setText("参数应在0-1之间!");
						returnValue = false;
					}
				}
				return returnValue;
			}
		};

		// 验证一段容器数
		verifier_1DR = new InputVerifier() {
			public boolean verify(JComponent comp) {
				boolean returnValue = false;
				JTextField textField = (JTextField) comp;
				try {
					if (textField.getText().matches("[1-9][0-9]*")) {
						textField.setBackground(Color.WHITE);
						error_1DR.setText("");
						returnValue = true;
					} else {
						textField.setBackground(Color.PINK);
						textField.setText("");
						error_1DR.setForeground(Color.RED);
						error_1DR.setText("参数应为非零整数!");
					}

				} catch (NumberFormatException e) {
					textField.setBackground(Color.PINK);
					if (textField.getText().matches("")) {
						textField.setText("");
						error_1DR.setForeground(Color.RED);
						error_1DR.setText("参数应为非零整数!");
						returnValue = false;
					} else {
						textField.setText("");
						error_1DR.setForeground(Color.RED);
						error_1DR.setText("参数应为非零整数!");
						returnValue = false;
					}
				}
				return returnValue;
			}
		};

		// 验证一段膜数
		verifier_1DM = new InputVerifier() {
			public boolean verify(JComponent comp) {
				boolean returnValue = false;
				JTextField textField = (JTextField) comp;
				try {
					if (textField.getText().matches("[1-9][0-9]*")) {
						textField.setBackground(Color.WHITE);
						error_1DM.setText("");
						returnValue = true;
					} else {
						textField.setBackground(Color.PINK);
						textField.setText("");
						error_1DM.setForeground(Color.RED);
						error_1DM.setText("参数应为非零整数!");
					}

				} catch (NumberFormatException e) {
					textField.setBackground(Color.PINK);
					if (textField.getText().matches("")) {
						textField.setText("");
						error_1DM.setForeground(Color.RED);
						error_1DM.setText("参数应为非零整数!");
						returnValue = false;
					} else {
						textField.setText("");
						error_1DM.setForeground(Color.RED);
						error_1DM.setText("参数应为非零整数!");
						returnValue = false;
					}
				}
				return returnValue;
			}
		};

		// 验证二段容器数
		verifier_2DR = new InputVerifier() {
			public boolean verify(JComponent comp) {
				boolean returnValue = false;
				JTextField textField = (JTextField) comp;
				try {
					if (textField.getText().matches("[1-9][0-9]*")) {
						textField.setBackground(Color.WHITE);
						error_2DR.setText("");
						returnValue = true;
					} else {
						textField.setBackground(Color.PINK);
						textField.setText("");
						error_2DR.setForeground(Color.RED);
						error_2DR.setText("参数应为非零整数!");
					}

				} catch (NumberFormatException e) {
					textField.setBackground(Color.PINK);
					if (textField.getText().matches("")) {
						textField.setText("");
						error_2DR.setForeground(Color.RED);
						error_2DR.setText("参数应为非零整数!");
						returnValue = false;
					} else {
						textField.setText("");
						error_2DR.setForeground(Color.RED);
						error_2DR.setText("参数应为非零整数!");
						returnValue = false;
					}
				}
				return returnValue;
			}
		};

		// 验证二段膜数
		verifier_2DM = new InputVerifier() {
			public boolean verify(JComponent comp) {
				boolean returnValue = false;
				JTextField textField = (JTextField) comp;
				try {
					if (textField.getText().matches("[1-9][0-9]*")) {
						textField.setBackground(Color.WHITE);
						error_2DM.setText("");
						returnValue = true;
					} else {
						textField.setBackground(Color.PINK);
						textField.setText("");
						error_2DM.setForeground(Color.RED);
						error_2DM.setText("参数应为非零整数!");
					}

				} catch (NumberFormatException e) {
					textField.setBackground(Color.PINK);
					if (textField.getText().matches("")) {
						textField.setText("");
						error_2DM.setForeground(Color.RED);
						error_2DM.setText("参数应为非零整数!");
						returnValue = false;
					} else {
						textField.setText("");
						error_2DM.setForeground(Color.RED);
						error_2DM.setText("参数应为非零整数!");
						returnValue = false;
					}
				}
				return returnValue;
			}
		};

		// 验证段间增压
		verifier_BP = new InputVerifier() {
			public boolean verify(JComponent comp) {
				boolean returnValue = false;
				JTextField textField = (JTextField) comp;
				try {
					if (textField.getText().matches("(0|[1-9]\\d*)(\\.\\d+)?")) {
						textField.setBackground(Color.WHITE);
						error_BP.setText("");
						returnValue = true;
					} else {
						textField.setBackground(Color.PINK);
						textField.setText("");
						error_BP.setForeground(Color.RED);
						error_BP.setText("参数应大于或等于0！");
					}

				} catch (NumberFormatException e) {
					textField.setBackground(Color.PINK);
					if (textField.getText().matches("")) {
						textField.setText("");
						error_BP.setForeground(Color.RED);
						error_BP.setText("参数应大于或等于0！");
						returnValue = false;
					} else {
						textField.setText("");
						error_BP.setForeground(Color.RED);
						error_BP.setText("参数应大于或等于0！");
						returnValue = false;
					}
				}
				return returnValue;
			}
		};

		// 验证产水量
		verifier_CS = new InputVerifier() {
			public boolean verify(JComponent comp) {
				boolean returnValue = true;
				JTextField textField = (JTextField) comp;
				try {
					if (textField.getText().matches("(0|[1-9]\\d*)(\\.\\d+)?")
							& Double.parseDouble(textField.getText()) != 0) {
						textField.setBackground(Color.WHITE);
						error_CS.setText("");
						returnValue = true;
					} else {
						textField.setBackground(Color.PINK);
						textField.setText("");
						error_CS.setForeground(Color.RED);
						error_CS.setText("参数应大于0!");
					}

				} catch (NumberFormatException e) {
					textField.setBackground(Color.PINK);
					if (textField.getText().matches("")) {
						textField.setText("");
						error_CS.setForeground(Color.RED);
						error_CS.setText("参数应大于0!");
						returnValue = false;
					} else {
						textField.setText("");
						error_CS.setForeground(Color.RED);
						error_CS.setText("参数应大于0!");
						returnValue = false;
					}
				}
				return returnValue;
			}

		};

		// 验证回收率
		verifier_HSL = new InputVerifier() {
			public boolean verify(JComponent comp) {
				boolean returnValue = false;
				JTextField textField = (JTextField) comp;
				try {
					if (textField.getText().matches("(0|[1-9]\\d*)(\\.\\d+)?")
							& Double.parseDouble(textField.getText()) < 100
							& Double.parseDouble(textField.getText()) != 0) {
						textField.setBackground(Color.WHITE);
						error_HSL.setText("");
						returnValue = true;
					} else {
						textField.setBackground(Color.PINK);
						textField.setText("");
						error_HSL.setForeground(Color.RED);
						error_HSL.setText("参数应在0~100之间!");
					}

				} catch (NumberFormatException e) {
					textField.setBackground(Color.PINK);
					if (textField.getText().matches("")) {
						textField.setText("");
						error_HSL.setForeground(Color.RED);
						error_HSL.setText("参数应在0~100之间!");
						returnValue = false;
					} else {
						textField.setText("");
						error_HSL.setForeground(Color.RED);
						error_HSL.setText("参数应在0~100之间!");
						returnValue = false;
					}
				}
				return returnValue;
			}
		};
	}

	public ArrayList<Object> DATA() { // 返回系统相关参数
		ArrayList<Object> data = new ArrayList<>();
		data.add(Double.parseDouble(textField_TDS.getText())); // TDS
		data.add(Double.parseDouble(textField_T.getText())); // 温度
		data.add(Double.parseDouble(textField_PF.getText())); // 污染参数
		data.add(Double.parseDouble(textField_pH.getText())); // pH
		data.add(Integer.parseInt((String) comboBox_DS.getSelectedItem()));// 段数
		data.add(Integer.parseInt(textField_1DR.getText()));// 一段容器数
		data.add(Integer.parseInt(textField_1DM.getText())); // 一段膜数
		data.add(Integer.parseInt(textField_2DR.getText()));// 二段容器数
		data.add(Integer.parseInt(textField_2DM.getText()));// 二段膜数
		data.add(Double.parseDouble(textField_bP.getText()));// 段间增压
		data.add((String) comboBox_MType.getSelectedItem());// 膜类型
		data.add(Double.parseDouble(textField_CS.getText()));// 系统产水
		data.add((Double.parseDouble(textField_HSL.getText())) / 100);// 系统回收率
		return data;
	}

	public void SetData() {
		water.setIn_TDS(Double.parseDouble(textField_TDS.getText()));// TDS
		water.setT(Double.parseDouble(textField_T.getText())); // 温度
		water.setpH(Double.parseDouble(textField_pH.getText())); // pH
		water.setWryz(Double.parseDouble(textField_PF.getText())); // 污染参数
		PP.setGroup_num(Integer.parseInt((String) comboBox_DS.getSelectedItem()));// 段数
		PP.setYlrq1(Integer.parseInt(textField_1DR.getText()));// 一段容器数
		PP.setn1(Integer.parseInt(textField_1DM.getText())); // 一段膜数
		PP.setYlrq2(Integer.parseInt(textField_2DR.getText()));// 二段容器数
		PP.setn2(Integer.parseInt(textField_2DM.getText()));// 二段膜数
		PP.setP1_2(Double.parseDouble(textField_bP.getText()));// 段间增压
		PP.setMo_type((String) comboBox_MType.getSelectedItem());// 膜类型
		PP.setOut_vel(Double.parseDouble(textField_CS.getText()));// 系统产水
		PP.setsystemY((Double.parseDouble(textField_HSL.getText())) / 100);// 系统回收率
	}

	private class Action_JS extends AbstractAction {
		public Action_JS() {
			putValue(NAME, "计算");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}

	private class Action_RES extends AbstractAction {
		public Action_RES() {
			putValue(NAME, "重置");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}

}
