/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.aiis_fee_management;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

/**
 *
 * @author Yusuf Ali
 */
public class AddFees extends javax.swing.JFrame {

    /**
     * Creates new form AddFees
     */
    public void displayCashFirst()
    {
       lbl_cheque_num.setVisible(false);
       lbl_dd_num.setVisible(false);
       txt_cheque_num.setVisible(false);
       txt_dd_num.setVisible(false);
       lbl_bank_name.setVisible(false);
       txt_bank_name.setVisible(false);
       txt_transaction.setVisible(false);
       lbl_transaction.setVisible(false);
       lbl_rec_name.setVisible(true);
    }
    public String insertData()
    {
        int rno=Integer.parseInt(txt_recipt_num.getText());
        String sno=txt_rec_name1.getText();
        String rollno=txt_roll_no.getText();
        String payment_mode=combo_mode_payment.getSelectedItem().toString();
        String cheque_no=txt_cheque_num.getText();
        String bank_nm=txt_bank_name.getText();
        String dd_no=txt_dd_num.getText();
        String course_nm=combo_mode_payment1.getSelectedItem().toString();
        String gst=jLabel8.getText();
        float total=Float.parseFloat(txt_total.getText());
        SimpleDateFormat d1=new SimpleDateFormat("yyyy-MM-dd");
        String date=d1.format(date_c.getDate());
        float amount=Float.parseFloat(txt_amount.getText());
        float cgst=Float.parseFloat(txt_cgst.getText());
        float sgst=Float.parseFloat(txt_sgst.getText());
        String total_words=txt_total_invert.getText();
        String remark=jTextArea1.getText();
        int year1=Integer.parseInt(fromyear.getText());
        int year2=Integer.parseInt(toyear.getText());
        
                  String status="";
        try
        {
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 String url="jdbc:mysql://localhost:3306/aiis_fms?zeroDateTimeBehavior=CONVERT_TO_NULL";
                 Connection con=DriverManager.getConnection(url,"root","Yusuf@123");
                 String sql="insert into fees_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                 PreparedStatement st=con.prepareStatement(sql);
                 st.setInt(1,rno);
                 st.setString(2,sno);
                 st.setString(3,rollno);
                 st.setString(4,payment_mode);
                 st.setString(5,cheque_no);
                 st.setString(6,bank_nm);
                 st.setString(7,dd_no);
                 st.setString(8,course_nm);
                 st.setString(9,gst);
                 st.setFloat(10,total);
                 st.setString(11,date);
                 st.setFloat(12,amount);
                 st.setFloat(13,cgst);
                 st.setFloat(14,sgst);
                 st.setString(15,total_words);
                 st.setString(16,remark);
                 st.setInt(17,year1);
                 st.setInt(18,year2);
          int c=st.executeUpdate();
            if(c==1)
            {
                status="success";
            }
            else
            {
                status="failed";
            }
                 





        }
        catch(Exception e1)
        {
            e1.printStackTrace();
        }
        return status;
    }
    
    public AddFees() {
        initComponents();
        displayCashFirst();
        fillComboBox();
        int r=getRnum();
        r++;
        txt_recipt_num.setText(Integer.toString(r));
    }
    
public class NumberToWordsConverter {

	public static final String[] units = { "", "One", "Two", "Three", "Four",
			"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };

	public static final String[] tens = { 
			"", 		// 0
			"",		// 1
			"Twenty", 	// 2
			"Thirty", 	// 3
			"Forty", 	// 4
			"Fifty", 	// 5
			"Sixty", 	// 6
			"Seventy",	// 7
			"Eighty", 	// 8
			"Ninety" 	// 9
	};

	public static String convert(final int n) {
		if (n < 0) 
                {
			return "Minus " + convert(-n);
		}

		if (n < 20) 
                {
			return units[n];
		}

		if (n < 100) {
			return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
		}

		if (n < 1000) {
			return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
		}

		if (n < 100000) {
			return convert(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
		}

		if (n < 10000000) {
			return convert(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
		}

		return convert(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
	}

	public static void main(final String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the Amount : ");
		int n=sc.nextInt();

		
		System.out.println( convert(n)+ " Only");

	
	}
}

    boolean validation()
    {
        if(txt_rec_name1.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please Enter Receiver Name First");
            return(false);
        }
        if(date_c.getDate()==null)
        {
            JOptionPane.showMessageDialog(this,"Please Enter Date");
            return(false);
        }
        if(txt_amount.getText().equals("")||txt_amount.getText().matches("[0-9]+")==false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter Amount In(0-9)");
            return(false);
        }
        if(combo_mode_payment.getSelectedItem().toString().equalsIgnoreCase("cheque"))
        {
            if(txt_cheque_num.getText().equals(""))   
            {
            JOptionPane.showMessageDialog(this,"Please Enter Cheque Number");
            return(false);
            }
            if(txt_bank_name.getText().equals(""))
            {
            JOptionPane.showMessageDialog(this,"Please Enter Bank Name");
            return(false);
            }
        }
        if(combo_mode_payment.getSelectedItem().toString().equalsIgnoreCase("DD"))
        {
            if(txt_dd_num.getText().equals(""))   
            {
            JOptionPane.showMessageDialog(this,"Please Enter DD number");
            return(false);
            }
            if(txt_bank_name.getText().equals(""))
            {
            JOptionPane.showMessageDialog(this,"Please Enter Bank Name");
            return(false);
            }
        }
        if(combo_mode_payment.getSelectedItem().toString().equalsIgnoreCase("PhonePay"))
        {
            if(txt_transaction.getText().equals(""))   
            {
            JOptionPane.showMessageDialog(this,"Please Enter Transaction Number");
            return(false);
            }
        }
        if(txt_roll_no.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please Enter Roll Number");
            return(false);
        }
        if(fromyear.getText().equals("")||toyear.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please Fill The Years");
            return(false);
        }
    return(true);
    }
    
    public void fillComboBox()
    {
        try
        {
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 String url="jdbc:mysql://localhost:3306/aiis_fms?zeroDateTimeBehavior=CONVERT_TO_NULL";
                 Connection con=DriverManager.getConnection(url,"root","Yusuf@123");
                 String sql="select CNAME from course";
                 PreparedStatement st=con.prepareStatement(sql);
                ResultSet rs=st.executeQuery(sql);
                 while(rs.next())
                 {
                     combo_mode_payment1.addItem(rs.getString("CNAME"));
                 }
                 
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
    }
    
     public int getRnum()
    {
        int rno=0;
        try
        {
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 String url="jdbc:mysql://localhost:3306/aiis_fms?zeroDateTimeBehavior=CONVERT_TO_NULL";
                 Connection con=DriverManager.getConnection(url,"root","Yusuf@123");
                 String sql="select max(reciept_no) from fees_details";
                 PreparedStatement st=con.prepareStatement(sql);
                ResultSet rs=st.executeQuery(sql);
                
                if(rs.next()==true)
                {
                    rno=rs.getInt("1");
                }
    }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
        return rno;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lbl_transaction = new javax.swing.JLabel();
        lbl_cheque_num = new javax.swing.JLabel();
        lbl_dd_num = new javax.swing.JLabel();
        lbl_recipt_num = new javax.swing.JLabel();
        txt_cheque_num = new javax.swing.JTextField();
        txt_recipt_num = new javax.swing.JTextField();
        lbl_date = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_gstin = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_roll_no = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_cgst = new javax.swing.JTextField();
        txt_total_invert = new javax.swing.JTextField();
        txt_amount = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txt_sgst = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jButton8 = new javax.swing.JButton();
        lbl_rec_name = new javax.swing.JLabel();
        txt_rec_name1 = new javax.swing.JTextField();
        toyear = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        fromyear = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        combo_mode_payment = new javax.swing.JComboBox<>();
        txt_bank_name = new javax.swing.JTextField();
        lbl_bank_name = new javax.swing.JLabel();
        txt_dd_num = new javax.swing.JTextField();
        lbl_mode_payment1 = new javax.swing.JLabel();
        txt_transaction = new javax.swing.JTextField();
        combo_mode_payment1 = new javax.swing.JComboBox<>();
        lbl_mode_payment2 = new javax.swing.JLabel();
        date_c = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(500, 700));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_transaction.setText("Transaction Id");
        jPanel2.add(lbl_transaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, 30));

        lbl_cheque_num.setText("Cheque No.");
        jPanel2.add(lbl_cheque_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 84, -1));

        lbl_dd_num.setText("DD No.");
        jPanel2.add(lbl_dd_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 84, -1));

        lbl_recipt_num.setText("Recipt No");
        jPanel2.add(lbl_recipt_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 30, 90, 20));

        txt_cheque_num.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_cheque_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cheque_numActionPerformed(evt);
            }
        });
        jPanel2.add(txt_cheque_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 80, 30));

        txt_recipt_num.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txt_recipt_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 80, 30));

        lbl_date.setText("Date");
        jPanel2.add(lbl_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 6, 30, 40));

        jLabel8.setText("ABC557GHT10");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 90, 20));

        lbl_gstin.setText("GSTIN");
        jPanel2.add(lbl_gstin, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 40, 20));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Received from for the given month");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 610, 190, -1));

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel3.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 600, 80, 30));

        jLabel6.setText("To");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 610, 20, -1));

        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 600, 80, 30));

        jLabel12.setText("Sr.No.");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 43, 30));

        jLabel10.setText("Roll No.");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 70, 20));

        txt_roll_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_roll_noActionPerformed(evt);
            }
        });
        jPanel3.add(txt_roll_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 130, 30));

        jSeparator1.setBackground(new java.awt.Color(153, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(204, 0, 51));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, 190, 10));

        jSeparator2.setBackground(new java.awt.Color(153, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(204, 0, 51));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 115, 502, 10));

        jLabel13.setText("Head");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 43, 30));

        jLabel14.setText("Amount");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 43, 30));

        txt_cgst.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_cgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cgstActionPerformed(evt);
            }
        });
        jPanel3.add(txt_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 120, 30));

        txt_total_invert.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel3.add(txt_total_invert, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 330, 40));

        txt_amount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });
        jPanel3.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 120, 30));

        jTextField10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel3.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 240, 40));

        jLabel9.setText("CGST 7%");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 50, 40));

        jLabel16.setText("Remark");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 100, 30));

        jSeparator3.setBackground(new java.awt.Color(153, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(204, 0, 51));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 502, 10));

        txt_sgst.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel3.add(txt_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 120, 30));

        jLabel18.setText("SGST 7%");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 60, 30));

        jLabel19.setText("Receiver Signature");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, 110, 20));

        txt_total.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel3.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, 120, 30));

        jLabel20.setText("Total In Words");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 100, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 330, 70));

        jLabel21.setText("Total");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 60, 20));

        jSeparator4.setBackground(new java.awt.Color(153, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(204, 0, 51));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 190, 10));

        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton8.setText("Print");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, -1, -1));

        lbl_rec_name.setText("Receiver Name");
        jPanel3.add(lbl_rec_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 30));

        txt_rec_name1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel3.add(txt_rec_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 210, 40));

        toyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toyearActionPerformed(evt);
            }
        });
        jPanel3.add(toyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 70, 30));

        jLabel11.setText("to");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 20, 30));

        fromyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromyearActionPerformed(evt);
            }
        });
        jPanel3.add(fromyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 60, 30));

        jLabel17.setText("From Year");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 60, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 500, 520));

        combo_mode_payment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CASH", "DD", "CHEQUE", "PhonePay" }));
        combo_mode_payment.setToolTipText("");
        combo_mode_payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_mode_paymentActionPerformed(evt);
            }
        });
        jPanel2.add(combo_mode_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        txt_bank_name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_bank_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bank_nameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_bank_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 270, 40));

        lbl_bank_name.setText("Bank Name");
        jPanel2.add(lbl_bank_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 90, 30));

        txt_dd_num.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txt_dd_num, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 80, 30));

        lbl_mode_payment1.setText("Mode of Payment");
        jPanel2.add(lbl_mode_payment1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 100, 20));

        txt_transaction.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txt_transaction, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 210, 30));

        combo_mode_payment1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        combo_mode_payment1.setToolTipText("");
        combo_mode_payment1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_mode_payment1ActionPerformed(evt);
            }
        });
        jPanel2.add(combo_mode_payment1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 120, -1));

        lbl_mode_payment2.setText("Course");
        jPanel2.add(lbl_mode_payment2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 40, 20));
        jPanel2.add(date_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 110, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("Search Record");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 170, -1));

        jButton2.setBackground(new java.awt.Color(204, 255, 204));
        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setText("Edit Course");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 170, -1));

        jButton3.setBackground(new java.awt.Color(204, 255, 204));
        jButton3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton3.setText("Add Course");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 170, -1));

        jButton4.setBackground(new java.awt.Color(204, 255, 204));
        jButton4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton4.setText("View All Record");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 180, -1));

        jButton5.setBackground(new java.awt.Color(204, 255, 204));
        jButton5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton5.setText("Back");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 170, -1));

        jButton6.setBackground(new java.awt.Color(204, 255, 204));
        jButton6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton6.setText("Logout");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 170, -1));

        jButton7.setBackground(new java.awt.Color(204, 255, 204));
        jButton7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton7.setText("Home");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 170, -1));

        jButton9.setBackground(new java.awt.Color(204, 255, 204));
        jButton9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton9.setText("Course List");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 170, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        HomePage h1=new HomePage();
        h1.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void combo_mode_paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_mode_paymentActionPerformed
        if(combo_mode_payment.getSelectedIndex()==1)
        {
            lbl_dd_num.setVisible(true);
            txt_dd_num.setVisible(true);
            lbl_bank_name.setVisible(true);
            txt_bank_name.setVisible(true);
            lbl_rec_name.setVisible(true);
            txt_transaction.setVisible(false);
            lbl_transaction.setVisible(false);
            
            lbl_cheque_num.setVisible(false);
            txt_cheque_num.setVisible(false);
        }
        if(combo_mode_payment.getSelectedIndex()==0)
        {
            lbl_cheque_num.setVisible(false);
            lbl_dd_num.setVisible(false);
            txt_cheque_num.setVisible(false);
            txt_dd_num.setVisible(false);
            lbl_bank_name.setVisible(false);
            txt_bank_name.setVisible(false);
            lbl_rec_name.setVisible(true);
            txt_transaction.setVisible(false);
            lbl_transaction.setVisible(false);
        }
         if(combo_mode_payment.getSelectedIndex()==2)
        {
            lbl_dd_num.setVisible(false);
            txt_dd_num.setVisible(false);
            lbl_bank_name.setVisible(true);
            txt_bank_name.setVisible(true);
            lbl_rec_name.setVisible(true);
            txt_transaction.setVisible(false);
            lbl_transaction.setVisible(false);
            
            lbl_cheque_num.setVisible(true);
            txt_cheque_num.setVisible(true);
        }
         if(combo_mode_payment.getSelectedIndex()==3)
        {
            lbl_cheque_num.setVisible(false);
            lbl_dd_num.setVisible(false);
            txt_cheque_num.setVisible(false);
            txt_dd_num.setVisible(false);
            lbl_bank_name.setVisible(false);
            txt_bank_name.setVisible(false);
            lbl_rec_name.setVisible(true);
            txt_transaction.setVisible(true);
            lbl_transaction.setVisible(true);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_combo_mode_paymentActionPerformed

    private void txt_cgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cgstActionPerformed

    private void txt_roll_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_roll_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_roll_noActionPerformed

    private void txt_bank_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bank_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bank_nameActionPerformed

    private void txt_cheque_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cheque_numActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cheque_numActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
            if(validation()==true)
            {
                String s=insertData();
                    if(s.equals("success"))
                    {
                        JOptionPane.showMessageDialog(this,"Record Inserted Sucessfully");
                    }
                    else
                    {
                         JOptionPane.showMessageDialog(this,"Insertion Failed");
                       
                    }
            }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
         String s1=txt_amount.getText();
         float amt=Float.parseFloat(s1);
         
         float cgst=amt*0.07f;
         float sgst=amt*0.07f;
         txt_cgst.setText(Float.toString(cgst));
         txt_sgst.setText(Float.toString(sgst));
         float t=amt+cgst+sgst;
         txt_total.setText(Float.toString(t));
         
         txt_total_invert.setText(NumberToWordsConverter.convert((int)t));

        // TODO add your handling code here:
    }//GEN-LAST:event_txt_amountActionPerformed

    private void combo_mode_payment1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_mode_payment1ActionPerformed
                 String s1=combo_mode_payment1.getSelectedItem().toString();
                 jTextField10.setText(s1);
                 // TODO add your handling code here:
    }//GEN-LAST:event_combo_mode_payment1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void toyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toyearActionPerformed

    private void fromyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromyearActionPerformed

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        Login l1=new Login();
        l1.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        HomePage hp=new HomePage();
        hp.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
            course_list cl=new course_list();
            cl.setVisible(true);
            
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_mode_payment;
    private javax.swing.JComboBox<String> combo_mode_payment1;
    private com.toedter.calendar.JDateChooser date_c;
    private javax.swing.JTextField fromyear;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel lbl_bank_name;
    private javax.swing.JLabel lbl_cheque_num;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_dd_num;
    private javax.swing.JLabel lbl_gstin;
    private javax.swing.JLabel lbl_mode_payment1;
    private javax.swing.JLabel lbl_mode_payment2;
    private javax.swing.JLabel lbl_rec_name;
    private javax.swing.JLabel lbl_recipt_num;
    private javax.swing.JLabel lbl_transaction;
    private javax.swing.JTextField toyear;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_bank_name;
    private javax.swing.JTextField txt_cgst;
    private javax.swing.JTextField txt_cheque_num;
    private javax.swing.JTextField txt_dd_num;
    private javax.swing.JTextField txt_rec_name1;
    private javax.swing.JTextField txt_recipt_num;
    private javax.swing.JTextField txt_roll_no;
    private javax.swing.JTextField txt_sgst;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_total_invert;
    private javax.swing.JTextField txt_transaction;
    // End of variables declaration//GEN-END:variables
}
