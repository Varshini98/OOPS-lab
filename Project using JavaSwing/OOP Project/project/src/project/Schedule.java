package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Schedule extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Schedule frame = new Schedule();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn=null;
	private JTable table;
	private JTable table_1;

	/**
	 * Create the frame.
	 */
	public class adarray{
		public String adname;
		public int duration;
	};
	
	
	public Schedule() {
		
		conn=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {	
		String qu= "delete from schedule";
		PreparedStatement pstu= conn.prepareStatement(qu);
		pstu.execute();
		}
		catch(Exception e2) {
			
		}
		try {	
			String query= "select * from program p1 inner join pgmday p2 on p1.pgmid = p2.pgmid where day= 'Weekdays' order by start_time";
			PreparedStatement pst= conn.prepareStatement(query);
			ResultSet rs= pst.executeQuery();	
			//float x= Integer.valueOf(rs.getString("start_time"));
		
			
			while(rs.next()) {
				
				SimpleDateFormat formatter = new SimpleDateFormat("hh:mm");	
				
				String pgm;
				pgm=rs.getString("name");
				
				
				String q1= "select Adname, duration from pgmad pd inner join sponspgm sp on pd.slno= sp.slno where sp.pgm = ? order by priority";			
				PreparedStatement pst1= conn.prepareStatement(q1);
				pst1.setString(1, pgm);
				
				ResultSet rs1= pst1.executeQuery();
				
				adarray arr[]= new adarray[10];
				int i=0;
				
				while(rs1.next()) {
					
					//String t= rs1.getString("duration");
					//Date temp = formatter.parse(rs1.getString("time(duration)"));
					arr[i]= new adarray();
					arr[i].adname= rs1.getString("Adname");
					 
				     //SimpleDateFormat sdf = new SimpleDateFormat( "HH:mm:ss" );
				    // String time = sdf.format( temp );
					//Time temp;
					//temp= rs1.getTime("time(duration)");
					
					arr[i].duration= rs1.getInt("duration");//formatter.parse(t);
					
					//String str = String.format("Current Date/Time : %tT", arr[i].duration);
		
				    //System.out.println(t);
					++i;
				}
			
				
				String q2= "select * from channelAd";
				PreparedStatement pst2= conn.prepareStatement(q2);
				
				ResultSet rs2= pst2.executeQuery();
				
				while(rs2.next()) {
					arr[i]= new adarray();
					arr[i].adname= rs2.getString("adname");
					//String t= rs2.getString("duration");
					arr[i].duration= rs2.getInt("duration"); //formatter.parse(t);
					++i;
				}
				
				/*for(int j=0; j<i; ++j) {
					System.out.println(arr[j].adname+" "+ arr[j].duration);
				}*/
				
				i=i-1;
				int j=0;
				
				String temp1=rs.getString("start_time");
				Date x= formatter.parse(temp1);
				//System.out.println(x);
				String temp2=rs.getString("end_time");
				Date y= formatter.parse(temp2);
				
				long x1= x.getTime();
				long y1= y.getTime();
				//System.out.println(x1+ " "+ y1);
				
			
				
				while(x1<y1) {
					String q3= "insert into schedule values(?,?)";
					PreparedStatement pst3= conn.prepareStatement(q3);
					
					pst3.setString(1, formatter.format(x));
					pst3.setString(2, pgm);
					pst3.execute();
					//System.out.println(pgm);
					Calendar cal = Calendar.getInstance();
					cal.setTime(x);
					cal.add(Calendar.MINUTE, 15);
					String newTime = formatter.format(cal.getTime());
					 
					x= formatter.parse(newTime);
					//System.out.println(x);
					
					x1= x.getTime();
					
					if(x1<y1) {
					
					float l=0;
					
					while(l<3) {
					
						if(j>i) {
							j=0;
						}
						//System.out.println(j);
						String q4= "insert into schedule values (?, ?)";
						PreparedStatement pst4= conn.prepareStatement(q4);
						
						//long minutes = TimeUnit.MILLISECONDS.toMinutes(l);
						//System.out.println(minutes);
						
					
						//System.out.println(x);
						
						pst4.setString(1, formatter.format(x));
						pst4.setString(2, arr[j].adname);
						pst4.execute();
						Calendar cal2 = Calendar.getInstance();
						cal2.setTime(x);
						cal2.add(Calendar.MINUTE, arr[j].duration);
						String newTime1 = formatter.format(cal2.getTime());
						 
						x= formatter.parse(newTime1);
						x1= x.getTime();
						
						
						l=l + arr[j].duration;
						j=j+1;
					}
					}
				
				}
		
			}
		
		}
	catch(Exception e2){
		e2.printStackTrace();
		
	}
		
		try {	
			String query= "select * from program p1 inner join pgmday p2 on p1.pgmid = p2.pgmid where day= 'Weekends' order by start_time";
			PreparedStatement pst= conn.prepareStatement(query);
			ResultSet rs= pst.executeQuery();	
			//float x= Integer.valueOf(rs.getString("start_time"));
		
			
			while(rs.next()) {
				
				SimpleDateFormat formatter = new SimpleDateFormat("hh:mm");	
				
				String pgm;
				pgm=rs.getString("name");
				
				
				String q1= "select Adname, duration from pgmad pd inner join sponspgm sp on pd.slno= sp.slno where sp.pgm = ? order by priority";			
				PreparedStatement pst1= conn.prepareStatement(q1);
				pst1.setString(1, pgm);
				
				ResultSet rs1= pst1.executeQuery();
				
				adarray arr[]= new adarray[10];
				int i=0;
				
				while(rs1.next()) {
					
					//String t= rs1.getString("duration");
					//Date temp = formatter.parse(rs1.getString("time(duration)"));
					arr[i]= new adarray();
					arr[i].adname= rs1.getString("Adname");
					 
				     //SimpleDateFormat sdf = new SimpleDateFormat( "HH:mm:ss" );
				    // String time = sdf.format( temp );
					//Time temp;
					//temp= rs1.getTime("time(duration)");
					
					arr[i].duration= rs1.getInt("duration");//formatter.parse(t);
					
					//String str = String.format("Current Date/Time : %tT", arr[i].duration);
		
				    //System.out.println(t);
					++i;
				}
			
				
				String q2= "select * from channelAd";
				PreparedStatement pst2= conn.prepareStatement(q2);
				
				ResultSet rs2= pst2.executeQuery();
				
				while(rs2.next()) {
					arr[i]= new adarray();
					arr[i].adname= rs2.getString("adname");
					//String t= rs2.getString("duration");
					arr[i].duration= rs2.getInt("duration"); //formatter.parse(t);
					++i;
				}
				
				/*for(int j=0; j<i; ++j) {
					System.out.println(arr[j].adname+" "+ arr[j].duration);
				}*/
				
				i=i-1;
				int j=0;
				
				String temp1=rs.getString("start_time");
				Date x= formatter.parse(temp1);
				//System.out.println(x);
				String temp2=rs.getString("end_time");
				Date y= formatter.parse(temp2);
				
				long x1= x.getTime();
				long y1= y.getTime();
				//System.out.println(x1+ " "+ y1);
				
			
				
				while(x1<y1) {
					String q3= "insert into schedule values(?,?)";
					PreparedStatement pst3= conn.prepareStatement(q3);
					
					pst3.setString(1, formatter.format(x));
					pst3.setString(2, pgm);
					pst3.execute();
					//System.out.println(pgm);
					Calendar cal = Calendar.getInstance();
					cal.setTime(x);
					cal.add(Calendar.MINUTE, 15);
					String newTime = formatter.format(cal.getTime());
					 
					x= formatter.parse(newTime);
					//System.out.println(x);
					
					x1= x.getTime();
					
					if(x1<y1) {
					
					float l=0;
					
					while(l<3) {
					
						if(j>i) {
							j=0;
						}
						//System.out.println(j);
						String q4= "insert into schedule values (?, ?)";
						PreparedStatement pst4= conn.prepareStatement(q4);
						
						//long minutes = TimeUnit.MILLISECONDS.toMinutes(l);
						//System.out.println(minutes);
						
					
						//System.out.println(x);
						
						pst4.setString(1, formatter.format(x));
						pst4.setString(2, arr[j].adname);
						pst4.execute();
						Calendar cal2 = Calendar.getInstance();
						cal2.setTime(x);
						cal2.add(Calendar.MINUTE, arr[j].duration);
						String newTime1 = formatter.format(cal2.getTime());
						 
						x= formatter.parse(newTime1);
						x1= x.getTime();
						
						
						l=l + arr[j].duration;
						j=j+1;
					}
					}
				
				}
		
			}
		
		}
	catch(Exception e3){
		e3.printStackTrace();
		
	}
	
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login l= new login();
				l.frame.setVisible(true);
				dispose();
			}
				
		});
		btnBack.setBounds(719, 13, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblScheduledList = new JLabel("Scheduled List");
		lblScheduledList.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblScheduledList.setBounds(305, 11, 215, 23);
		contentPane.add(lblScheduledList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 96, 376, 374);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try {
			String query= "select * from schedule";
			PreparedStatement pst= conn.prepareStatement(query);
			ResultSet rs= pst.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(440, 96, 348, 374);
			contentPane.add(scrollPane_1);
			
			table_1 = new JTable();
			scrollPane_1.setViewportView(table_1);
			
			String query1= "select * from schedule";
			PreparedStatement pst1= conn.prepareStatement(query1);
			ResultSet rs1= pst1.executeQuery();
			
			table_1.setModel(DbUtils.resultSetToTableModel(rs1));
			
			JLabel lblWeekdays = new JLabel("Weekdays");
			lblWeekdays.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblWeekdays.setBounds(152, 65, 167, 37);
			contentPane.add(lblWeekdays);
			
			JLabel lblWeekends = new JLabel("Weekends");
			lblWeekends.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblWeekends.setBounds(558, 65, 167, 37);
			contentPane.add(lblWeekends);
			pst.close();
			rs.close();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
}
