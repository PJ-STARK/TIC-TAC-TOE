// BY PRASANNA JENA
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class tictactoe implements ActionListener
{
	//THE BASIC LAYOUT
	
    Random random=new Random();
    JFrame frame=new JFrame();
    JFrame frame2=new JFrame();
    JPanel title_panel=new JPanel();
    JPanel title_panel2=new JPanel();
	JPanel title_panel3=new JPanel();
    JPanel button_panel =new JPanel();
    JPanel button_panel2=new JPanel();
    JLabel textfield=new JLabel();
    JLabel textfield2=new JLabel();
	JLabel textfield3=new JLabel();
    JButton[] buttons=new JButton[9];
    JButton[] buttons2=new JButton[2];
    boolean player1_turn;

    tictactoe()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(600,600);
        frame2.getContentPane().setBackground(new Color(50,50,50));
		frame2.setLocation(frame.getX()+frame.getWidth(),frame.getY() );
        frame2.setLayout(new BorderLayout());
        frame2.setVisible(false);

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);
		
		textfield3.setBackground(new Color(25,25,25));
        textfield3.setForeground(new Color(25,100,0));
        textfield3.setFont(new Font("Ink Free",Font.ITALIC,20));
        textfield3.setHorizontalAlignment(JLabel.CENTER);
        textfield3.setText("\u00A9 BY PRASANNA JENA \u00A9");
        textfield3.setOpaque(false);
		
        textfield2.setBackground(new Color(25,0,25));
        textfield2.setForeground(new Color(25,255,0));
        textfield2.setFont(new Font("Ink Free",Font.BOLD,75));
        textfield2.setHorizontalAlignment(JLabel.CENTER);
        textfield2.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,700,100);
        
        title_panel2.setLayout(new BorderLayout());
        title_panel2.setBounds(0,0,600,100);
        
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));
        
        button_panel2.setLayout(new GridLayout(2,1));
        button_panel2.setBackground(new Color(150,150,150));
        button_panel2.setSize(50, 50);
        
        
        for(int i=0;i<9;i++)
        {
        	buttons[i]=new JButton();
        	button_panel.add(buttons[i]);
        	buttons[i].setFont(new Font("Mv Boli",Font.BOLD,120));
        	buttons[i].setFocusable(false);
        	buttons[i].addActionListener(this);
        }
        
        title_panel.add(textfield);
		title_panel3.add(textfield3);
        frame.add(title_panel,BorderLayout.NORTH);
		frame.add(title_panel3,BorderLayout.SOUTH);
        frame.add(button_panel);
        
        title_panel2.add(textfield2);
        
        buttons2[0]=new JButton();
        button_panel2.add(buttons2[0]);
        buttons2[0].setFont(new Font("Mv  Boli",Font.BOLD,75));
        buttons2[0].setFocusable(false);
        buttons2[0].addActionListener(this);
        buttons2[0].setForeground(new Color(0,0,255));
		buttons2[0].setText("PLAY AGAIN");
		
        buttons2[1]=new JButton();
        button_panel2.add(buttons2[1]);
        buttons2[1].setFont(new Font("Mv  Boli",Font.BOLD,75));
        buttons2[1].setFocusable(false);
        buttons2[1].addActionListener(this);
        buttons2[1].setForeground(new Color(0,0,255));
		buttons2[1].setText("EXIT");
		
        frame2.add(title_panel2);
        frame2.add(button_panel2,BorderLayout.SOUTH);
        
        
        firstTurn();

    }
    
    public void actionPerformed(ActionEvent e)
    {
    	//WORK TO BE PERFORMED
    	
    	for(int i=0;i<9;i++)
    	{
    		if(e.getSource()==buttons[i])
    		{
    			if(player1_turn)
    			{
    				if(buttons[i].getText()=="")
    				{
    					buttons[i].setForeground(new Color(255,0,0));
    					buttons[i].setText("X");
    					player1_turn=false;
    					textfield.setText("O's Turn");
    					check();
    				}
    			}
    			
    			else
    			{
    				if(buttons[i].getText()=="")
    				{
    					buttons[i].setForeground(new Color(0,0,255));
    					buttons[i].setText("O");
    					player1_turn=true;
    					textfield.setText("X's Turn");
    					check();
    				}
    			}
    		}
    	}
    	
    	if(e.getSource()==buttons2[0])
    	{
    		frame.setVisible(false);
    		frame2.setVisible(false);
    		tictactoe ttt = new tictactoe();
    		textfield2.setText("Loading...");
    	}
    	
    	if(e.getSource()==buttons2[1])
    	{
    		textfield2.setText("ERROR");
    		System.exit(0);
    	}

    }
    public void firstTurn()
    {
    	// STARTING OF GAME
    	
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(random.nextInt(2)==0)

    	{
    		player1_turn=true;
    		textfield.setText("X's Turn");
    	}
    	else
    	{
    		player1_turn=false;
    		textfield.setText("O's Turn");
    	}
    }
    
    //TO CHECK WINNING CONDITIONS
    
    public void check()
    {
		int c=0;
    	//x wins straight
    	if(
    		(buttons[0].getText()=="X") &&
    		(buttons[1].getText()=="X") &&
    		(buttons[2].getText()=="X")
       	)
    	{
    		xWins(0,1,2);
    	}
    	
    	else if(
        		(buttons[3].getText()=="X") &&
        		(buttons[4].getText()=="X") &&
        		(buttons[5].getText()=="X")
          )
        	{
        		xWins(3,4,5);
        	}
    	
    	else if(
        		(buttons[6].getText()=="X") &&
        		(buttons[7].getText()=="X") &&
        		(buttons[8].getText()=="X")
          )
        	{
        		xWins(6,7,8);
        	}
    	
    	// O wins straight
    	
    	else if(
        		(buttons[0].getText()=="O") &&
        		(buttons[1].getText()=="O") &&
        		(buttons[2].getText()=="O")
           	)
        	{
        		oWins(0,1,2);
        	}
        	
        	else if(
            		(buttons[3].getText()=="O") &&
            		(buttons[4].getText()=="O") &&
            		(buttons[5].getText()=="O")
              )
            	{
            		oWins(3,4,5);
            	}
        	
        	else if(
            		(buttons[6].getText()=="O") &&
            		(buttons[7].getText()=="O") &&
            		(buttons[8].getText()=="O")
              )
            	{
            		oWins(6,7,8);
            	}
        	
        	// X wins down
        	
        	else if(
            		(buttons[0].getText()=="X") &&
            		(buttons[3].getText()=="X") &&
            		(buttons[6].getText()=="X")
               	)
            	{
            		xWins(0,3,6);
            	}
            	
            	else if(
                		(buttons[1].getText()=="X") &&
                		(buttons[4].getText()=="X") &&
                		(buttons[7].getText()=="X")
                  )
                	{
                		xWins(1,4,7);
                	}
            	
            	else if(
                		(buttons[2].getText()=="X") &&
                		(buttons[5].getText()=="X") &&
                		(buttons[8].getText()=="X")
                  )
                	{
                		xWins(2,5,8);
                	}
            	
            // O wins down
            	
            	else if(
                		(buttons[0].getText()=="O") &&
                		(buttons[3].getText()=="O") &&
                		(buttons[6].getText()=="O")
                   	)
                	{
                		oWins(0,3,6);
                	}
                	
                	else if(
                    		(buttons[1].getText()=="O") &&
                    		(buttons[4].getText()=="O") &&
                    		(buttons[7].getText()=="O")
                      )
                    	{
                    		oWins(1,4,7);
                    	}
                	
                	else if(
                    		(buttons[2].getText()=="O") &&
                    		(buttons[5].getText()=="O") &&
                    		(buttons[8].getText()=="O")
                      )
                    	{
                    		oWins(2,5,8);
                    	}
                	
                // X wins diagonal
                	
                	else if(
                    		(buttons[0].getText()=="X") &&
                    		(buttons[4].getText()=="X") &&
                    		(buttons[8].getText()=="X")
                       	)
                    	{
                    		xWins(0,4,8);
                    	}
                    	
                    	else if(
                        		(buttons[2].getText()=="X") &&
                        		(buttons[4].getText()=="X") &&
                        		(buttons[6].getText()=="X")
                          )
                        	{
                        		xWins(2,4,6);
                        	}
                    	
                 // o wins diagonal
                    	
                    	else if(
                        		(buttons[0].getText()=="O") &&
                        		(buttons[4].getText()=="O") &&
                        		(buttons[8].getText()=="O")
                           	)
                        	{
                        		oWins(0,4,8);
                        	}
                        	
                        	else if(
                            		(buttons[2].getText()=="O") &&
                            		(buttons[4].getText()=="O") &&
                            		(buttons[6].getText()=="O")
                              )
                            	{
                            		oWins(2,4,6);
                            	}

								else
								{
									for(int i=0;i<9;i++)
									{
										if (buttons[i].getText()!="")
										 {
											c++;	
										}
									}
									if (c==9) {
										draw();
									}
								}
    	

    }
    
    //TO DO IF WINS
    
    public void xWins(int a,int b,int c)
    {
    	buttons[a].setBackground(Color.GREEN);
    	buttons[b].setBackground(Color.GREEN);
    	buttons[c].setBackground(Color.GREEN);
    	
    	for(int i=0;i<9;i++)
    	{
    		buttons[i].setEnabled(false);
    	}
    	
    	textfield2.setText("X WINS");
    	frame2.setVisible(true);
    	

    }
    public void oWins(int a,int b,int c)
    {
    	buttons[a].setBackground(Color.GREEN);
    	buttons[b].setBackground(Color.GREEN);
    	buttons[c].setBackground(Color.GREEN);
    	
    	for(int i=0;i<9;i++)
    	{
    		buttons[i].setEnabled(false);
    	}

    	textfield2.setText("O WINS");
    	frame2.setVisible(true);

    }

	public void draw()
	{
		for(int i=0;i<9;i++)
        {
        	buttons[i].setBackground(Color.YELLOW);
			buttons[i].setEnabled(false);
        }

		textfield2.setText("IT's A DRAW");
    	frame2.setVisible(true);

	}
     

}
