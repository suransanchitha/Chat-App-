import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ChatWindow extends JFrame {
    private JLabel lblTitle;
    private JTextField txtmsg;
    private JButton btnsend;
    private JPanel labelPanel;
    private JScrollPane scrollPane;
    private String senderName;
    private String message;

    ChatWindow(String senderName) {
		this.senderName=senderName;
        setSize(400, 300);
        setTitle(senderName);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        lblTitle = new JLabel(senderName);
        lblTitle.setFont(new Font("", Font.BOLD, 30));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setOpaque(true);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBackground(new Color(0, 100, 0));

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.add(lblTitle, BorderLayout.CENTER); 
        
        add(titlePanel, BorderLayout.NORTH);

        JPanel Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtmsg = new JTextField(20);
        txtmsg.setFont(new Font("", Font.BOLD, 15));
        Panel.add(txtmsg);

        btnsend = new JButton("Send");
        btnsend.setFont(new Font("", Font.BOLD, 15));
        Panel.add(btnsend);
        add(Panel, BorderLayout.SOUTH);

        labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(labelPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER);

        btnsend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
				if (!txtmsg.getText().equals("")){
				JLabel lblmsg = new JLabel("Me : " + txtmsg.getText());
                lblmsg.setFont(new Font("", Font.BOLD, 15));
                labelPanel.add(lblmsg);
                labelPanel.revalidate();
                scrollPane.revalidate();
                scrollPane.repaint();
                ChatController.sendMessage(senderName, txtmsg.getText());
                txtmsg.setText("");
				}
            }
        });
        
    }
    
    public void displayMessage(String senderName , String message) {
        JLabel lblmsg = new JLabel(senderName+" : "+message);
        lblmsg.setFont(new Font("", Font.BOLD, 15));
        labelPanel.add(lblmsg);
        labelPanel.revalidate();
        scrollPane.revalidate();
        scrollPane.repaint();
    }
    
    public void setMessage(String message){
		this.message=message;
		}
	public String getSenderName(){
		return senderName;
	}
    public static void main(String args[]) {
        new AddChatWindow().setVisible(true);
    }
}

class AddChatWindow extends JFrame{
	private JLabel lblTitle;
    private JTextField txtmsg;
    private JButton btnAdd;
    private ChatController chatController=new ChatController();
	AddChatWindow(){
		
		setSize(400, 200);
        setTitle("Add Sender");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        lblTitle = new JLabel("Add Sender");
        lblTitle.setFont(new Font("", Font.BOLD, 30));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setOpaque(true);
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBackground(new Color(0, 100, 0));
        
		JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.add(lblTitle, BorderLayout.CENTER);

        add(titlePanel, BorderLayout.NORTH);

		JPanel Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtmsg = new JTextField(20);
        txtmsg.setFont(new Font("", Font.BOLD, 15));
        Panel.add(txtmsg);

        btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("", Font.BOLD, 15));
        Panel.add(btnAdd);
         btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
				if (!txtmsg.getText().equals("")){
				ChatWindow chatWindow= new ChatWindow(txtmsg.getText());
				chatWindow.setVisible(true);
				chatController.addChatWindow(chatWindow);
				 txtmsg.setText("");
				}
			}
        });
        add(Panel, BorderLayout.SOUTH);
            
    }
	
}
