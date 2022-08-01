import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board implements ActionListener{
	
	public static int NBRSPLAYED = 1;
	public static int btnRows = 20;
	public static int btnCols = 20;
	public static int nbrOfBombs = 50;
	public JFrame frame;
	public JPanel panel;
	public final Icon backOfButton = new ImageIcon("buttonBack.png"); 
	public Button buttonArray[];
	public int nbrOfClickedBtns = 0;
	public static String location = null;
	class Button{
		JButton button = new JButton();
		boolean safe = true;
		public Button(int btnsCreated) {
			button = new JButton();
			button.setPreferredSize(new Dimension(22, 22)); // Make sure dimensions are integers here.
			Image i = new ImageIcon("Button.png").getImage().getScaledInstance
					((int)button.getPreferredSize().getWidth(), (int)button.getPreferredSize().getHeight(), Image.SCALE_SMOOTH);
			button.setIcon(new ImageIcon(i));
			
			if(Math.random() <= (float)nbrOfBombs/((btnRows*btnCols)-btnsCreated)) { // start with the 25/400 ( 6.25% ) (by default)
				safe = false;
				nbrOfBombs = nbrOfBombs - 1;
			} else {
				safe = true;
			}
		}
	}
	
	public Board(){
		Button[] btnArr = new Button[btnRows * btnCols];
		frame = new JFrame("Minesweeper!");
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 30, 40)); // Top, Left, Bottom, Right
		panel.setLayout(new GridLayout(btnRows, btnCols));
		
		for(int btnsCreated = 0; btnsCreated < btnRows * btnCols; btnsCreated++) {
			Button button = new Button(btnsCreated);
			button.button.addActionListener(this);
			btnArr[btnsCreated] = button;
			panel.add(button.button);
			
		}
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocation(415, 80); // Default values: frame.setLocation(415, 80); and btnRows = 20 and btnCols = 20
		buttonArray = btnArr;
		//System.out.println(btnArr[0].toString());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//System.out.println(buttonArray[0].toString());
		
		for(int j = 0; j < btnRows * btnCols; j++) {
			if(e.getSource().toString().equals(buttonArray[j].button.toString())) {
				//System.out.println("Button number:" + (j));
				buttonArray[j].button.setEnabled(false);
				int squareNbr = 0;
				if(buttonArray[j].safe == false) { // the 25/400 ( 6.25% )
					Image i = new ImageIcon("Bomb.png").getImage().getScaledInstance((int)buttonArray[j].button.getPreferredSize().getWidth(), 
							(int)buttonArray[j].button.getPreferredSize().getHeight(), Image.SCALE_SMOOTH);
					buttonArray[j].button.setDisabledIcon(new ImageIcon(i));
				} else {
					int caseValue = j;
					if(!(j == 0 || j == 19 || j == 380 || j == 399)) {
						if(j < 19) { // Top side
							location = "ts";
							caseValue = 1;
						} else if(j > 380) { // Bottom side
							location = "bs";
							caseValue = 2;
						} else if((j%20) == 0) { // Left side
							location = "ls";
							caseValue = 3;
						} else if(((j+1)%20) == 0) { // Right side
							location = "rs";
							caseValue = 4;
						}
					}
					switch(caseValue) {
					case(0): // Top left
						location = "tl";
						if(buttonArray[1].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[20].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[21].safe == false) {
							squareNbr = squareNbr + 1;
						}
						break;
					case(19):
						location = "tr";
						if(buttonArray[18].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[39].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[38].safe == false) {
							squareNbr = squareNbr + 1;
						}
						break;
					case(380):
						location = "bl";
						if(buttonArray[381].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[360].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[361].safe == false) {
							squareNbr = squareNbr + 1;
						}
						break;
					case(399):
						location = "br";
						if(buttonArray[398].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[379].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[378].safe == false) {
							squareNbr = squareNbr + 1;
						}
						break;
					case(1):
						if(buttonArray[j-1].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j+1].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j+20].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j+19].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j+21].safe == false) {
							squareNbr = squareNbr + 1;
						}
						break;
					case(2):
						if(buttonArray[j-1].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j+1].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j-20].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j-19].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j-21].safe == false) {
							squareNbr = squareNbr + 1;
						}
						break;
					case(3):
						if(buttonArray[j+1].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j+20].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j-20].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j+21].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j-19].safe == false) {//////////////////////////////////////////
							squareNbr = squareNbr + 1;
						}
						break;
					case(4):
						if(buttonArray[j-1].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j+20].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j-20].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j+19].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j-21].safe == false) {
							squareNbr = squareNbr + 1;
						}
						break;
					default:
						location = "m";
						if(buttonArray[j-1].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j+1].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j+20].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j-20].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j+19].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j-19].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j+21].safe == false) {
							squareNbr = squareNbr + 1;
						}
						if(buttonArray[j-21].safe == false) {
							squareNbr = squareNbr + 1;
						}
					}
					
					Image i;
					switch(squareNbr) {
					case(0):
						i = new ImageIcon("zero.png").getImage().getScaledInstance((int)buttonArray[j].button.getPreferredSize().getWidth(), 
								(int)buttonArray[j].button.getPreferredSize().getHeight(), Image.SCALE_SMOOTH);
						buttonArray[j].button.setDisabledIcon(new ImageIcon(i));
						expand(j,true);
						break;
					case(1):
						i = new ImageIcon("one.png").getImage().getScaledInstance((int)buttonArray[j].button.getPreferredSize().getWidth(), 
								(int)buttonArray[j].button.getPreferredSize().getHeight(), Image.SCALE_SMOOTH);
						buttonArray[j].button.setDisabledIcon(new ImageIcon(i));
						break;
					case(2):
						i = new ImageIcon("two.png").getImage().getScaledInstance((int)buttonArray[j].button.getPreferredSize().getWidth(), 
								(int)buttonArray[j].button.getPreferredSize().getHeight(), Image.SCALE_SMOOTH);
						buttonArray[j].button.setDisabledIcon(new ImageIcon(i));
						break;
					case(3):
						i = new ImageIcon("three.png").getImage().getScaledInstance((int)buttonArray[j].button.getPreferredSize().getWidth(), 
								(int)buttonArray[j].button.getPreferredSize().getHeight(), Image.SCALE_SMOOTH);
						buttonArray[j].button.setDisabledIcon(new ImageIcon(i));
						break;
					case(4):
						i = new ImageIcon("four.png").getImage().getScaledInstance((int)buttonArray[j].button.getPreferredSize().getWidth(), 
								(int)buttonArray[j].button.getPreferredSize().getHeight(), Image.SCALE_SMOOTH);
						buttonArray[j].button.setDisabledIcon(new ImageIcon(i));
						break;
					case(5):
						i = new ImageIcon("five.png").getImage().getScaledInstance((int)buttonArray[j].button.getPreferredSize().getWidth(), 
								(int)buttonArray[j].button.getPreferredSize().getHeight(), Image.SCALE_SMOOTH);
						buttonArray[j].button.setDisabledIcon(new ImageIcon(i));
						break;
					case(6):
						i = new ImageIcon("six.png").getImage().getScaledInstance((int)buttonArray[j].button.getPreferredSize().getWidth(), 
								(int)buttonArray[j].button.getPreferredSize().getHeight(), Image.SCALE_SMOOTH);
						buttonArray[j].button.setDisabledIcon(new ImageIcon(i));
						break;
					case(7):
						i = new ImageIcon("seven.png").getImage().getScaledInstance((int)buttonArray[j].button.getPreferredSize().getWidth(), 
								(int)buttonArray[j].button.getPreferredSize().getHeight(), Image.SCALE_SMOOTH);
						buttonArray[j].button.setDisabledIcon(new ImageIcon(i));
						break;
					default:
						i = new ImageIcon("eight.png").getImage().getScaledInstance((int)buttonArray[j].button.getPreferredSize().getWidth(), 
								(int)buttonArray[j].button.getPreferredSize().getHeight(), Image.SCALE_SMOOTH);
						buttonArray[j].button.setDisabledIcon(new ImageIcon(i));
					}
				}
			}
		}
		
		//String fullSource = e.getSource().toString();
		//System.out.println(fullSource);
		//String objArr[] = fullSource.split(",");
		//System.out.println(objArr[1]);
		
	}
	
	public void expand(int index, boolean isZero) {
		switch(location) {
		case("tl"):
			buttonArray[index+1].button.doClick();
			buttonArray[index+20].button.doClick();
			buttonArray[index+21].button.doClick();
			break;
		case("tr"):
			buttonArray[index-1].button.doClick();
			buttonArray[index+20].button.doClick();
			buttonArray[index+19].button.doClick();
			break;
		case("bl"):
			buttonArray[index+1].button.doClick();
			buttonArray[index-20].button.doClick();
			buttonArray[index-21].button.doClick();
			break;
		case("br"):
			buttonArray[index-1].button.doClick();
			buttonArray[index-20].button.doClick();
			buttonArray[index-19].button.doClick();
			break;
		case("ts"):
			buttonArray[index-1].button.doClick();
			buttonArray[index+1].button.doClick();
			buttonArray[index+20].button.doClick();
			buttonArray[index+19].button.doClick();
			buttonArray[index+21].button.doClick();
			break;
		case("bs"):
			buttonArray[index-1].button.doClick();
			buttonArray[index+1].button.doClick();
			buttonArray[index-20].button.doClick();
			buttonArray[index-19].button.doClick();
			buttonArray[index-21].button.doClick();
			break;
		case("ls"):
			buttonArray[index+1].button.doClick();
			buttonArray[index-20].button.doClick();
			buttonArray[index+20].button.doClick();
			buttonArray[index-19].button.doClick();
			buttonArray[index+21].button.doClick();
			break;
		case("rs"):
			buttonArray[index-1].button.doClick();
			buttonArray[index-20].button.doClick();
			buttonArray[index+20].button.doClick();
			buttonArray[index+19].button.doClick();
			buttonArray[index-21].button.doClick();
			break;
		default:
			buttonArray[index-1].button.doClick();
			buttonArray[index+1].button.doClick();
			buttonArray[index-20].button.doClick();
			buttonArray[index+20].button.doClick();
			buttonArray[index+19].button.doClick();
			buttonArray[index-21].button.doClick();
			buttonArray[index-19].button.doClick();
			buttonArray[index+21].button.doClick();
		}
	}
	
	public static void main(String[] args) {
		
		new Board();
		
	}

}
