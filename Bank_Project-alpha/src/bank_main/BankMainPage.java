/**
 * 
 */
package bank_main;

/**
 * @author Adarsh
 *
 */
import java.awt.*;
import java.awt.event.*;
import classes.*;
import sql.SqlFunctions;
public class BankMainPage extends Frame implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	Frame mainframe;
	Button balance_button,statement_button,chgpswd_button,deposit_button,withdraw_button,details_button;
	Button transfer_button,delete_button,signout;
	Label welcome_label;
	SqlFunctions sql=new SqlFunctions();
	public String balance;
	int x=0,y=360,speed=3;
	public BankMainPage(int id) {
		// TODO Auto-generated constructor stub
		setTitle("Welcome");
		setBackground(Color.LIGHT_GRAY);
		setFont(new Font("Tahoma",Font.BOLD,16));
		addWindowListener(new WindowListener() {
	   		 public void windowClosing(WindowEvent w) {
	   			 
	   			 try {
					SqlFunctions.disconnect();
				} catch (Exception e) {
					e.printStackTrace();
				}
	   			dispose();
	   			System.exit(0);
	   		 }

				@Override
				public void windowOpened(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowClosed(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowIconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowDeiconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowActivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowDeactivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
	   	     });
		setSize(1028, 768);
		setLayout(null);
		setVisible(true);
		Thread t=new Thread(this);
		t.start();
		
		
		//Label
		welcome_label=new Label();
		welcome_label.setFont(new Font("Tahoma",Font.BOLD,34));
		welcome_label.setText("Welcome "+sql.getName(id)+"!");
		welcome_label.setBounds(350, 50, 600, 50);
		add(welcome_label);

		//Buttons
		balance_button=new Button("Check Balance");
		balance_button.setBounds(20, 200, 300, 50);
		balance_button.addActionListener(new ActionListener() {
   			 public void actionPerformed(ActionEvent e) {
                 balance=sql.balanceCheck(id);
   				 new Balance(balance);
   			 }
   		 });
        add(balance_button);        
        statement_button=new Button("Statement");
		statement_button.setBounds(700, 200, 300, 50);
		statement_button.addActionListener(new ActionListener() {
   			 public void actionPerformed(ActionEvent e) {
   				EventQueue.invokeLater(new Runnable() {
   					public void run() {
   						try {
   							new Statement(id);
   							
   						} catch (Exception e) {
   							e.printStackTrace();
   						}
   					}
   				});
   			 }
   		 });
        add(statement_button);
        
        chgpswd_button=new Button("Change Password");
		chgpswd_button.setBounds(700, 400, 300, 50);
		chgpswd_button.addActionListener(new ActionListener() {
   			 public void actionPerformed(ActionEvent e) {
   				 new ChangePassword(id);

   			 }
   		 });
        add(chgpswd_button);
        
        deposit_button=new Button("Deposit");
		deposit_button.setBounds(20, 300, 300, 50);
		deposit_button.addActionListener(new ActionListener() {
   			 public void actionPerformed(ActionEvent e) {
                   new Deposit(id);
   			 }
   		 });
        add(deposit_button);
        
        withdraw_button=new Button("Withdraw");
		withdraw_button.setBounds(700, 300, 300, 50);
		withdraw_button.addActionListener(new ActionListener() {
   			 public void actionPerformed(ActionEvent e) {
                    new Withdraw(id);
   			 }
   		 });
        add(withdraw_button);
        
        details_button=new Button("User Details");
		details_button.setBounds(20, 400, 300, 50);
		details_button.addActionListener(new ActionListener() {
   			 public void actionPerformed(ActionEvent e) {
   				EventQueue.invokeLater(new Runnable() {
   					public void run() {
   						try {
                            new UserDetails(id);
   						} catch (Exception e) {
   							e.printStackTrace();
   						}
   					}
   				});
   			 }
   		 });
        add(details_button);
        transfer_button=new Button("Transfer");
		transfer_button.setBounds(20, 500, 300, 50);
		transfer_button.addActionListener(new ActionListener() {
   			 public void actionPerformed(ActionEvent e) {
   				EventQueue.invokeLater(new Runnable() {
   					public void run() {
   						try {
                            new Transfer(id);
   						} catch (Exception e) {
   							e.printStackTrace();
   						}
   					}
   				});
   			 }
   		 });
        add(transfer_button);
        delete_button=new Button("Delete Account");
		delete_button.setBounds(700, 500, 300, 50);
		delete_button.addActionListener(new ActionListener() {
   			 public void actionPerformed(ActionEvent e) {
   				EventQueue.invokeLater(new Runnable() {
   					public void run() {
   						try {
                            new DeleteAccount(id);
   						} catch (Exception e) {
   							e.printStackTrace();
   						}
   					}
   				});

   			 }
   		 });
        add(delete_button);
        signout=new Button("Signout");
		signout.setBounds(350, 600, 300, 50);
		signout.addActionListener(new ActionListener() {
   			 public void actionPerformed(ActionEvent e) {
                 new WelcomePage();
   				 dispose();  			 
   			 }	
   		 });
        add(signout);
	}
	public void paint(Graphics g) {
		g.setColor(Color.RED);
        g.drawArc(100, 50, 50, 50, x, 160);
        g.drawArc(95, 45, 60, 60, y, 180);
	}
	public void movearc() {
		
		if(x>=360) {
			x=0;
		}
		if(y<=0) {
			y=360;
		}
		x=x+speed;
		y=y-speed;
		
}
	public void run() {
		while(true) {
			movearc();
			repaint();
			try {
				Thread.sleep(15);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
