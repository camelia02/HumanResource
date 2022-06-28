package DB_Testing;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//admin can add, delete, alter and view
//user can only view 
public class  DB_Manager {

    JFrame Aframe;
    JFrame Uframe;
    JPanel Add;
    JPanel Delete;
    JPanel Alter;
    JPanel AView;
    JPanel UView;

    JTabbedPane Atb;

    JLabel Id;
    JLabel FName;
    JLabel Phone;
    JLabel Email;
    JLabel Address;
    JLabel Dept;
    JLabel JobTitle;
    JLabel Salary;
    JLabel E_Id;
    JLabel E_FName;
    JLabel E_Phone;
    JLabel E_Email;
    JLabel E_Address;
    JLabel E_Dept;
    JLabel E_JobTitle;
    JLabel E_Salary;
    JLabel D_Id;

    JTextField IdField;
    JTextField FNameField;
    JTextField PhoneField;
    JTextField EmailField;
    JTextField AddressField;
    JTextField DeptField;
    JTextField JobTitleField;
    JTextField SalaryField;
    JTextField E_IdField;
    JTextField E_FNameField;
    JTextField E_PhoneField;
    JTextField E_EmailField;
    JTextField E_AddressField;
    JTextField E_DeptField;
    JTextField E_JobTitleField;
    JTextField E_SalaryField;
    JTextField D_IdField;

    JButton btSave;
    JButton btDelete;
    JButton btEdit;
    JButton btAdd;
    JButton btView;
    JButton btLogout;
    JButton btReset;


    public void Menu(){
        String userType = Connector.Login();
        if(userType.equals("admin")){
            Admin();
        }
        else if(userType.equals("user")){
            User();
        }
        else{
            System.out.println("Login Failed");
        }
    }
    
    public void Admin(){
        Aframe = new JFrame();
        Aframe.setTitle("Administrator Menu");

        //Panels
        Add = new JPanel(new GridLayout(9,2,5,5));
        Delete = new JPanel(new GridBagLayout());
        Alter = new JPanel(new GridLayout(9,2,5,5));
        AView = new JPanel(null);
        Atb = new JTabbedPane();

        Id = new JLabel("ID");
        FName = new JLabel("First Name");
        Phone = new JLabel("Phone Number");
        Email = new JLabel("Email");
        Address = new JLabel("Address");
        Dept = new JLabel("Department");
        JobTitle = new JLabel("Job Title");
        Salary = new JLabel("Salary");
 
        IdField = new JTextField();
        FNameField = new JTextField();
        PhoneField = new JTextField();
        EmailField = new JTextField();
        AddressField = new JTextField();
        DeptField = new JTextField();
        JobTitleField = new JTextField();
        SalaryField = new JTextField();
 
        E_Id = new JLabel("ID");
        E_FName = new JLabel("First Name");
        E_Phone = new JLabel("Phone Number");
        E_Email = new JLabel("Email");
        E_Address = new JLabel("Address");
        E_Dept = new JLabel("Department");
        E_JobTitle = new JLabel("Job Title");
        E_Salary = new JLabel("Salary");

        E_IdField = new JTextField();
        E_FNameField = new JTextField();
        E_PhoneField = new JTextField();
        E_EmailField = new JTextField();
        E_AddressField = new JTextField();
        E_DeptField = new JTextField();
        E_JobTitleField = new JTextField();
        E_SalaryField = new JTextField();

        D_Id = new JLabel("ID");
        D_Id.setSize(150, 20);
        D_IdField = new JTextField();
        D_IdField.setSize(150, 20);

        btAdd = new JButton("Add");
        btDelete = new JButton("Delete");
        btEdit = new JButton("Edit");
        btView = new JButton("View");
        btReset = new JButton("Reset");
        btSave = new JButton("Save");

        //Add Panel
        Add.add(Id);
        Add.add(IdField);
        Add.add(FName);
        Add.add(FNameField);
        Add.add(Phone);
        Add.add(PhoneField);
        Add.add(Email);
        Add.add(EmailField);
        Add.add(Address);
        Add.add(AddressField);
        Add.add(Dept);
        Add.add(DeptField);
        Add.add(JobTitle);
        Add.add(JobTitleField);
        Add.add(Salary);
        Add.add(SalaryField);
        Add.add(btAdd);
        Add.add(btReset);

        //Alter Panel
        Alter.add(E_Id);
        Alter.add(E_IdField);
        Alter.add(E_FName);
        Alter.add(E_FNameField);
        Alter.add(E_Phone);
        Alter.add(E_PhoneField);
        Alter.add(E_Email);
        Alter.add(E_EmailField);
        Alter.add(E_Address);
        Alter.add(E_AddressField);
        Alter.add(E_Dept);
        Alter.add(E_DeptField);
        Alter.add(E_JobTitle);
        Alter.add(E_JobTitleField);
        Alter.add(E_Salary);
        Alter.add(E_SalaryField);
        Alter.add(btEdit);
        Alter.add(btSave);


        //Delete Panel
        GridBagConstraints c = new GridBagConstraints();
        if (true) {  
            c.weightx = 0.3;  
            }  
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        Delete.add(D_Id, c);
        c.fill = GridBagConstraints.HORIZONTAL; 
        c.weightx = 0.75;
        c.gridx = 1;
        c.gridy = 0;
        Delete.add(D_IdField, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        Delete.add(btDelete, c);
       
        //View Panel
        btView.setBounds(0, 0, 70, 20);
        AView.add(btView);

        //Action Listeners
        HandlerClass handler = new HandlerClass();
        btReset.addActionListener(handler);
        btSave.addActionListener(handler);
        btAdd.addActionListener(handler);
        btDelete.addActionListener(handler);
        btEdit.addActionListener(handler);
        btView.addActionListener(handler);

        displayAdmin();
    }

    public void displayAdmin(){
        Aframe.getContentPane().add(Atb);
        Atb.addTab("Add Record", Add);
        Atb.addTab("Delete Record", Delete);
        Atb.addTab("Alter Record", Alter);
        Atb.addTab("View Record", AView);

        Aframe.setBounds(300,100,800,500);
        Aframe.setVisible(true);
        Aframe.setResizable(true);
        Aframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


        
    public void User() {
        try(Connection conn = Connector.Connect()){
            Statement stmt = conn.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from [dbo].[Employee]");   
            String Column[] = {"ID", "First Name", "Phone Number", "Email", "Address", "Dept", "Job Title", "Salary"};
            String Data[][] = new String[100][100];
            int i = 0;
            while(rs.next()){
                Data[i][0] = rs.getInt("ID") + " ";
                Data[i][1] = rs.getString("FName");
                Data[i][2] = rs.getString("Phone");
                Data[i][3] = rs.getString("Email");
                Data[i][4] = rs.getString("Address");
                Data[i][5] = rs.getString("Dept");
                Data[i][6] = rs.getString("JobTitle");
                Data[i][7] = rs.getFloat("Salary") + " ";
                i++;
            }

            DefaultTableModel model = new DefaultTableModel(Data, Column);
            JTable table = new JTable(model);
            table.setBounds(0, 0, 725, 800);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            JScrollPane pane = new JScrollPane(table);
            JTabbedPane tb = new JTabbedPane();
            tb.addTab("Employee", pane);
            JFrame f = new JFrame("User");
            f.add(tb);
            f.setBounds(300,0,800,800);
            f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            f.setVisible(true);
            conn.close();
        
            }catch(SQLException e){
                e.printStackTrace();
        }

    }
    
    private class HandlerClass implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            JButton button = (JButton)e.getSource();

            if(button == btReset){
                System.out.println("Reset");
                IdField.setText("");
                FNameField.setText("");
                PhoneField.setText("");
                EmailField.setText("");
                AddressField.setText("");
                DeptField.setText("");
                JobTitleField.setText("");
                SalaryField.setText("");
            }

            else if(button == btAdd){
                try{
                    Connection con = Connector.Connect();
                    String sql = "INSERT INTO [dbo].[Employee] VALUES (" + IdField.getText() + ",'" + FNameField.getText() + "','" + PhoneField.getText() + "','" + EmailField.getText() + "','" + AddressField.getText() + "','" + DeptField.getText() + "','" + JobTitleField.getText() + "'," + SalaryField.getText() + ")";
                    Statement stmt = con.createStatement();
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Employee Added");
                    con.close();
                    stmt.close();
                }
                catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
            else if(button == btDelete){
                System.out.println("Delete");
                String sql = "DELETE FROM [dbo].[Employee] WHERE ID = " + D_IdField.getText();
                try{
                    Connection con = Connector.Connect();
                    Statement stmt = con.createStatement();
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Employee Deleted");
                    con.close();
                    stmt.close();
                }
                catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
            else if(button == btEdit){
                System.out.println("Edit");
                String sql = "UPDATE [dbo].[Employee] SET FName = " + E_FNameField.getText() + ", " + E_PhoneField.getText() + ", " + E_EmailField.getText() + ", " + E_AddressField.getText()
                            + ", " + E_DeptField.getText() + ", " + E_JobTitleField.getText() + ", " + E_SalaryField.getText() + " WHERE ID = " + E_IdField.getText();
                 
                try{
                    Connection con =  Connector.Connect();
                    Statement stmt = con.createStatement();
                    stmt.executeUpdate(sql);
                    con.close();
                    stmt.close();

                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
        
            }
            else if(button == btView){
                System.out.println("View");

                try(Connection conn = Connector.Connect()){
                    Statement stmt = conn.createStatement();  
                    ResultSet rs=stmt.executeQuery("select * from [dbo].[Employee]");   
                    String Column[] = {"ID", "First Name", "Phone Number", "Email", "Address", "Dept", "Job Title", "Salary"};
                    String Data[][] = new String[100][100];
                    int i = 0;
                    while(rs.next()){
                        Data[i][0] = rs.getInt("ID") + " ";
                        Data[i][1] = rs.getString("FName");
                        Data[i][2] = rs.getString("Phone");
                        Data[i][3] = rs.getString("Email");
                        Data[i][4] = rs.getString("Address");
                        Data[i][5] = rs.getString("Dept");
                        Data[i][6] = rs.getString("JobTitle");
                        Data[i][7] = rs.getFloat("Salary") + " ";
                        i++;
                    }
        
                    DefaultTableModel model = new DefaultTableModel(Data, Column);
                    JTable table = new JTable(model);
                    table.setBounds(0, 0, 725, 800);
                    table.setShowGrid(true);
                    table.setShowVerticalLines(true);
                    JScrollPane pane = new JScrollPane(table);
                    Atb = new JTabbedPane();
                    Atb.addTab("Employee", pane);
                    JFrame f = new JFrame("Employee Information");
                    f.add(Atb);
                    f.setBounds(300,0,800,800);
                    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    f.setVisible(true);
                    conn.close();
                
                    }catch(SQLException ex){
                        ex.printStackTrace();
                }
            }

    }

}
  

}
