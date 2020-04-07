import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CALENDAR extends JFrame {
    public String getDay(String str){
        String a[]={"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
        String s[]=str.split("/");
        int d=Integer.parseInt(s[0]);
        int m=Integer.parseInt(s[1]);
        int y=Integer.parseInt(s[2]);
        Calendar c=Calendar.getInstance();
        c.set(y, m-1, d);
        return a[c.get(Calendar.DAY_OF_WEEK)-1];
    }
    public CALENDAR() {
        setLayout(new BorderLayout());
        JPanel p=new JPanel();
        JLabel l=new JLabel();
        l.setForeground(Color.BLUE);
        l.setFont(new Font("serif",Font.BOLD+Font.ITALIC,24));
        l.setBounds(320, 300, 200, 50);
        p.setBackground(Color.WHITE);
        p.setLayout(null);
        JButton b=new JButton("CLICK");
        b.setFont(new Font("serif",Font.BOLD,22));
        b.setBackground(Color.DARK_GRAY);
        b.setBorder(new LineBorder(Color.DARK_GRAY,3));
        b.setForeground(Color.WHITE);
        b.setBounds(350, 200, 130, 60);
        b.setEnabled(false);
        getRootPane().setDefaultButton(b);
        JLabel l1=new JLabel("Format: DD/MM/YYYY (1970-2037)");
        l1.setFont(new Font("serif",Font.BOLD+Font.ITALIC,24));
        l1.setBounds(230, 40, 400, 30);
        l1.setForeground(Color.BLUE);
        JTextField t=new JTextField();
        t.setBorder(new LineBorder(Color.BLACK,3));
        t.setFont(new Font("serif",Font.BOLD+Font.ITALIC,30));
        t.setBounds(250, 100, 300, 50);
        t.getDocument().addDocumentListener(
                new DocumentListener() {
           Pattern p=Pattern.compile("([0]?[1-9]|[1-2][0-9]|[3][0])/([0]?[469]|[1][0-1])/([1][9][7-9][0-9]|[2][0][0-2][0-9]|[2][0][3][0-7])|([0]?[1-9]|[1-2][0-9]|[3][0-1])/([0]?[13578]|[1][02])/([1][9][7-9][0-9]|[2][0][0-2][0-9]|[2][0][3][0-7])|([0]?[1-9]|[1-2][0-8])/([0]?[2])/([1][9][79][^26]|[1][9][8][^048]|[2][0][02][^048]|[2][0][13][^26])|([0]?[1-9]|[1-2][0-9])/([0]?[2])/([1][9][79][26]|[1][9][8][048]|[2][0][02][048]|[2][0][13][26])");
                    public void insertUpdate(DocumentEvent e) {
                        Matcher m=p.matcher(t.getText());
                        if(m.matches()){
                            t.setBorder(new LineBorder(Color.BLACK,3));
                            b.setEnabled(true);
                            l.setText("");
                        }
                        else {
                            b.setEnabled(false);
                                l.setText("INVALID INPUT");
                                t.setBorder(new LineBorder(Color.RED,3));
                            if(t.getText().isEmpty()){
                                l.setText("");
                                t.setBorder(new LineBorder(Color.BLACK,3));
                            }
                        }
                    }
                    public void removeUpdate(DocumentEvent e) {
                        Matcher m=p.matcher(t.getText());
                        if(m.matches()){
                            b.setEnabled(true);
                            t.setBorder(new LineBorder(Color.BLACK,3));
                            l.setText("");
                        }
                        else {
                            b.setEnabled(false);
                                l.setText("INVALID INPUT");
                            t.setBorder(new LineBorder(Color.RED,3));
                            if(t.getText().isEmpty()){
                                l.setText("");
                                t.setBorder(new LineBorder(Color.BLACK,3));
                            }
                        }
                    }
                    public void changedUpdate(DocumentEvent e) {
                    }
                }
        );
        b.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        JFrame f=new JFrame();
                        f.setSize(800, 700);
                        f.setVisible(true);
                        f.setLayout(null);
                        f.setLocationRelativeTo(null);
                        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        JPanel p=new JPanel();
                        p.setBounds(200, 200, 200, 50);
                        p.setBackground(Color.RED);
                        p.setLayout(new FlowLayout());
                        JLabel l=new JLabel(getDay(t.getText()));
                        l.setFont(new Font("serif",Font.BOLD,24));
                        p.add(l);
                        f.add(p);
                    }
                }
        );
        p.add(b);
        p.add(l);
        p.add(l1);
        p.add(t);
        add(p,BorderLayout.CENTER);
    }
}
class Main{
    public static void main(String args[]){
        CALENDAR c=new CALENDAR();
        c.setSize(800, 700);
        c.setVisible(true);
        c.setLocationRelativeTo(null);
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        }
