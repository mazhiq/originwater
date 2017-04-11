package application;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.InputVerifier;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;

import engine.Water;

public class InputDieg extends JFrame {
	static Water water ;
	private JPanel contentPane;
	private JTextField textField_TDS;
	private JTextField textField_WD;
	private JTextField textField_1DR;
	private JTextField textField_1DM;
	private JTextField textField_2DR;
	private JTextField textField_2DM;
	private JTextField textField_WRYZ;
	private JTextField textField_DJZ;
	private JTextField textField_pH;
	private JTextField textField_CS;
	private JTextField textField_HSL;
	private final Action action_JS = new Action_JS();
	private final Action action_RS = new Action_EX();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputDieg frame = new InputDieg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InputDieg() {
		
		setType(Type.POPUP);
		setTitle("碧水源(OriginWater)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 351);
		setResizable(false);                                   //禁止最大化及缩放功能
		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel Label = new JLabel("请输入相关参数");    
		Label.setFont(new Font("黑体", Font.PLAIN, 18));
		
		JLabel Label_TDS = new JLabel("TDS(mg/L)");
		Label_TDS.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_pH = new JLabel("pH");
		label_pH.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_WD = new JLabel("温度(\u2103)");   
		label_WD.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_WRYZ = new JLabel("污染因子");
		label_WRYZ.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_1DR = new JLabel("一段压力容器数");
		label_1DR.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_1DM = new JLabel("一段内膜元件数");
		label_1DM.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_2DR = new JLabel("二段压力容器数");
		label_2DR.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_2DM = new JLabel("二段内膜元件数");
		label_2DM.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_DS = new JLabel("\u6BB5\u6570");        
		label_DS.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_MXH = new JLabel("膜元件型号");
		label_MXH.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_DJZ = new JLabel("段间增压");
		label_DJZ.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_CS = new JLabel("系统产水量");
		label_CS.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JLabel label_HSL = new JLabel("系统回收率");
		label_HSL.setFont(new Font("楷体", Font.PLAIN, 15));
		
		JComboBox comboBox_DS = new JComboBox();
		comboBox_DS.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBox_DS.setModel(new DefaultComboBoxModel(new String[] {"2", "1"}));
		
		JComboBox comboBox_MXH = new JComboBox();
		comboBox_MXH.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBox_MXH.setModel(new DefaultComboBoxModel(new String[] {"BW-8040", "ULP-8040", "SW-8040"}));
		
		InputVerifier verifier_Doublt = new InputVerifier() {
			public  boolean verify(JComponent comp) { 
				boolean returnValue; 
				JTextField textField = (JTextField) comp;
				try {
//					Integer.parseInt(textField.getText()); 
//					Float.parseFloat(textField.getText());
					Double.parseDouble(textField.getText());
			        returnValue = true;
			        textField.setBackground(Color.WHITE);
			        
				}
				catch (NumberFormatException e) {
					returnValue = false;
					textField.setBackground(Color.PINK);
					textField.setText("请输入数字");
				}
				return returnValue;
			}
		};
		
		textField_TDS = new JTextField();
		textField_TDS.setHorizontalAlignment(SwingConstants.LEFT);
		textField_TDS.setText("2000");
		textField_TDS.setInputVerifier(verifier_Doublt);
		textField_TDS.setColumns(10);
		
		textField_pH = new JTextField();
		textField_pH.setText("7.6");
		textField_pH.setInputVerifier(verifier_Doublt);
		textField_pH.setColumns(10);
		
		textField_WD = new JTextField();
		textField_WD.setText("25");
		textField_WD.setInputVerifier(verifier_Doublt);
		textField_WD.setColumns(10);
		
		textField_WRYZ = new JTextField();
		textField_WRYZ.setText("0.85");
		textField_WRYZ.setInputVerifier(verifier_Doublt);
		textField_WRYZ.setColumns(10);
		
		textField_1DR = new JTextField();
		textField_1DR.setText("2");
		textField_1DR.setInputVerifier(verifier_Doublt);
		textField_1DR.setColumns(10);
		
		textField_1DM = new JTextField();
		textField_1DM.setText("3");
		textField_1DM.setInputVerifier(verifier_Doublt);
		textField_1DM.setColumns(10);
		
		textField_2DR = new JTextField();
		textField_2DR.setText("1");
		textField_2DR.setInputVerifier(verifier_Doublt);
		textField_2DR.setColumns(10);
		
		textField_2DM = new JTextField();
		textField_2DM.setText("3");
		textField_2DM.setInputVerifier(verifier_Doublt);
		textField_2DM.setColumns(10);
				
		textField_DJZ = new JTextField();
		textField_DJZ.setText("0");
		textField_DJZ.setInputVerifier(verifier_Doublt);
		textField_DJZ.setColumns(10);
				
		textField_CS = new JTextField();
		textField_CS.setText("7.5");
		textField_CS.setInputVerifier(verifier_Doublt);
		textField_CS.setColumns(10);
		
		textField_HSL = new JTextField();
		textField_HSL.setText("0.6");
		textField_HSL.setInputVerifier(verifier_Doublt);
		textField_HSL.setColumns(10);
		
		JButton Button_JS = new JButton("New button");
		Button_JS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double[] par_process =null;
				par_process =new double[7];
				
				par_process[0] = Double.parseDouble(textField_1DR.getText());
				par_process[1] = Double.parseDouble(textField_1DM.getText());
				par_process[2] = Double.parseDouble(textField_2DR.getText());
				par_process[3] = Double.parseDouble(textField_2DM.getText());
				par_process[4] = Double.parseDouble(textField_DJZ.getText());
				par_process[5] = Double.parseDouble(textField_CS.getText());
				par_process[6] = Double.parseDouble(textField_HSL.getText());
				
				double[] par_water= null ;
				par_water = new double[4];
				
				par_water[0] = Double.parseDouble(textField_TDS.getText());
				par_water[1] = Double.parseDouble(textField_WD.getText());
				par_water[2] = Double.parseDouble(textField_pH.getText());
				par_water[3] = Double.parseDouble(textField_WRYZ.getText());
				
				int par_DS = Integer.parseInt((String) comboBox_DS.getSelectedItem());
				String par_MXH =  (String) comboBox_MXH.getSelectedItem();
				System.out.println(par_DS);	
				System.out.println(par_MXH);	
				for (int i=0;i<par_water.length;i++)
				{
					System.out.println(par_water[i]);	
				}
				for (int i=0;i<par_process.length;i++)
				{
					System.out.println(par_process[i]);	
				}
				
//				String a = textField_TDS.getText();
//				water.inTDS = (par_water[0]);
//				double i = Integer.parseInt(a);
//				System.out.println(i);
//				water.inTDS = Double.parseDouble(textField_TDS.getText());
//				water.T = Double.parseDouble(textField_WD.getText());
//				water.pH = Double.parseDouble(textField_pH.getText());
//				water.wryz = Double.parseDouble(textField_WRYZ.getText());
				
//				System.out.println(water.inTDS);
//				System.out.println(water.T);
//				System.out.println(water.pH);
//				System.out.println(water.wryz);
			}
		});		
		Button_JS.setAction(action_JS);
		
		JButton Button_EX = new JButton("New button");
		Button_EX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
			}
		});
		Button_EX.setAction(action_RS);
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(200)
					.addComponent(Label)
					.addContainerGap(200, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(37, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(label_2DM, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label_2DR, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label_1DM, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label_1DR, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(Label_TDS, Alignment.LEADING)
							.addComponent(label_WD, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_DS, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addComponent(Button_JS))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_1DM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_TDS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_WD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_DS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1DR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2DR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2DM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(53)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(label_DJZ, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(label_MXH, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(label_pH, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_WRYZ, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBox_MXH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_WRYZ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_pH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_DJZ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(label_CS)
										.addGap(18)
										.addComponent(textField_CS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(label_HSL)
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(Button_EX)
											.addComponent(textField_HSL)))))))
					.addGap(82))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(Label)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Label_TDS)
						.addComponent(label_pH, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_TDS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_pH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_WD, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_WRYZ, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_WD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_WRYZ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_DS, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_DS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_MXH, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_MXH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1DR, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1DR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_DJZ, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_DJZ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1DM, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1DM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2DR, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2DR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_CS, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_CS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2DM, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2DM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_HSL, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_HSL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Button_EX)
						.addComponent(Button_JS))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private class Action_JS extends AbstractAction {
		public Action_JS() {
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_UNDEFINED, 0));
			putValue(NAME, "计算");
			//putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class Action_EX extends AbstractAction {
		public Action_EX() {
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_UNDEFINED, 0));
			putValue(NAME, "重置");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
