import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import org.jdesktop.swingx.JXDatePicker;
public class Library_mgmt {
JLabel Stud_detail,SName,SGender,SClass,SField,SRoll_no,SAdmission_no,Book_detail,
        BTitle,BPublish,BIssue_date,BDue_date,Bno_of_copies,BEdition,Main_title,SStatus;
JLabel search_admission_no,search_student_name,search_student_name_show,search_roll_no,
                search_roll_no_show,search_gender,search_gender_show,search_class,search_class_show,
		search_field,search_field_show,search_book_title,search_book_title_show,search_book_copy,
                search_book_copy_show,search_book_edition,search_book_edition_show,delete_admission_no
				,delete_data_success;
JTextField STname,STclass,STRoll_no,STadmission,BTtitle,BTpublish,BTcopies,BTedition;
JTextField search_admission_no_tf,delete_admission_no_tf;
JFrame frame,search_frame,delete_frame;
JButton Update,Delete,Add,Refresh,Search,search_info,Search_back,delete_data_button,delete_back_button;
JRadioButton Male,Female;
JComboBox CBfield;
Boolean flag;
//ButtonGroup bg;
Library_mgmt()
{
	library_mgmt();
}
public void library_mgmt()
{
    main_frame();
    
	 //b.main_frame();
    student_detail();
    book_detail();
    lib_button();
	
	//b.lib_button_action();
	database_material();
	
	
	
	Delete_frame();
	refresh();
search_class();
	
	frame.setVisible(true);

}
public void main_frame()
{
	frame=new JFrame("Library management");
    frame.setSize(900,600);
    frame.setLayout(null);
    Main_title=new JLabel("Library Management System");
    Main_title.setFont(new Font("Serif", Font.BOLD, 22));
    Main_title.setBounds(240,2,3500,70);
	frame.add(Main_title);
	
}
public void student_detail()
{    
    Stud_detail=new JLabel("Add new Student Details: ");		//Stud_detail Label
    Stud_detail.setFont(new Font("Serif", Font.BOLD, 15));
    Stud_detail.setBounds(100,60,200,70);
    SName=new JLabel("Name : ");									//SNamw Label
    SName.setBounds(50,140,100,30);
    STname=new JTextField("");  								//STname Textfield
    STname.setBounds(150,140, 150,30); 						
    SGender=new JLabel("Gender :");
    SGender.setBounds(50,190,100,30);
    Male=new JRadioButton(" Male");    						//Male radiobutton
    Female=new JRadioButton(" Female");
	/*bg = new ButtonGroup();
	bg.add(Male);
	bg.add(Female);*/
    Male.setBounds(150,190,100,30);    
    Female.setBounds(250,190,100,30);   						//Female radiobutton
    SClass=new JLabel("Class : ");								//SClass Label
    SClass.setBounds(50,240,100,30);
    STclass=new JTextField("");  								//STclass Textfield
    STclass.setBounds(150,240, 150,30);
    SField=new JLabel("Field : ");
    SField.setBounds(50,290,100,30);
    String Stud_Field[]={"CS","Biotech","IT","Chemistry","Engineering"};        
    CBfield=new JComboBox(Stud_Field);    
    CBfield.setBounds(150, 290,100,30);
    SRoll_no=new JLabel("Roll no :");
    SRoll_no.setBounds(50,340,100,30);
    STRoll_no=new JTextField("");  
    STRoll_no.setBounds(150,340, 150,30);
    SAdmission_no=new JLabel("Admission no :");
    SAdmission_no.setBounds(50,390,100,30);
    STadmission=new JTextField("");  
    STadmission.setBounds(150,390, 150,30);
    frame.add(Stud_detail);
    frame.add(SName);
    frame.add(STname);
    frame.add(SGender);
    frame.add(Male);
    frame.add(Female);
    frame.add(SClass);
    frame.add(STclass);
    frame.add(SField);
    frame.add(CBfield);
    frame.add(SRoll_no);
    frame.add(STRoll_no);
    frame.add(SAdmission_no);
    frame.add(STadmission); 
	SStatus = new JLabel();
	SStatus.setBounds(150,435,180,50);
	frame.add(SStatus);
}
public void book_detail()
{
    Book_detail=new JLabel("Add New Book Details: ");
    Book_detail.setFont(new Font("Serif", Font.BOLD, 15));
    Book_detail.setBounds(500,60,200,70);
    BTitle=new JLabel("Title : ");
    BTitle.setBounds(450,140,100,30);
    BTtitle=new JTextField("");  
    BTtitle.setBounds(550,140, 150,30);
    BPublish=new JLabel("Publish Year : ");
    BPublish.setBounds(450,190,100,30);
	//JXDatePicker picker = new JXDatePicker();
    /*picker.setDate(Calendar.getInstance().getTime());
    picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));*/
    SpinnerModel value = new SpinnerNumberModel(1999,0,2018,1);
    JSpinner spinner = new JSpinner(value);  
    spinner.setBounds(550,190,100,30);
    BIssue_date=new JLabel("Issue Date : ");
    BIssue_date.setBounds(450,240,100,30);
    SpinnerModel value_issue_date = new SpinnerNumberModel(1,1,31,1);
    JSpinner spinner_issue_date = new JSpinner(value_issue_date);  
    spinner_issue_date.setBounds(550,240,50,30);
    SpinnerModel value_issue_month = new SpinnerNumberModel(1,1,12,1);
    JSpinner spinner_issue_month = new JSpinner(value_issue_month);  
    spinner_issue_month.setBounds(600,240,50,30);
    SpinnerModel value_issue_year = new SpinnerNumberModel(1999,0,2018,1);
    JSpinner spinner_issue_year = new JSpinner(value_issue_year);  
    spinner_issue_year.setBounds(650,240,50,30);
    BDue_date=new JLabel("Due Date : ");
    BDue_date.setBounds(450,290,100,30);
    SpinnerModel value_due_date = new SpinnerNumberModel(1,1,31,1);
    JSpinner spinner_due_date = new JSpinner(value_due_date);  
    spinner_due_date.setBounds(550,290,50,30);
    SpinnerModel value_due_month = new SpinnerNumberModel(1,1,12,1);
    JSpinner spinner_due_month = new JSpinner(value_due_month);  
    spinner_due_month.setBounds(600,290,50,30);
    SpinnerModel value_due_year = new SpinnerNumberModel(1999,0,2018,1);
    JSpinner spinner_due_year = new JSpinner(value_due_year);  
    spinner_due_year.setBounds(650,290,50,30);
    Bno_of_copies=new JLabel("No. of copies : ");
    Bno_of_copies.setBounds(450,340,100,30);
    BTcopies=new JTextField("");  
    BTcopies.setBounds(550,340, 150,30);
    BEdition=new JLabel("Edition : ");
    BEdition.setBounds(450,390,100,30);
    BTedition=new JTextField("");  
    BTedition.setBounds(550,390, 150,30);
    frame.add(Book_detail);
    frame.add(BTitle);
    frame.add(BTtitle);
    frame.add(BPublish);
    frame.add(spinner);
    frame.add(BIssue_date);
    frame.add(spinner_issue_date);
    frame.add(spinner_issue_month);
    frame.add(spinner_issue_year);
    frame.add(BDue_date);
    frame.add(spinner_due_date);
    frame.add(spinner_due_month);
    frame.add(spinner_due_year);
    frame.add(Bno_of_copies);
    frame.add(BTcopies);
    frame.add(BEdition);
    frame.add(BTedition);
}
public void lib_button()
{
    Update = new JButton("Update");
    Update.setBounds(150,490,100,30);
    Delete = new JButton("Delete");
    Delete.setBounds(260,490,100,30);
    Add = new JButton("Add");
    Add.setBounds(370,490,100,30);
    Refresh = new JButton("Refresh");
    Refresh.setBounds(480,490,100,30);
	Search = new JButton("Search");
	Search.setBounds(590,490,100,30);
    frame.add(Update);
    frame.add(Delete);
    frame.add(Add);
    frame.add(Refresh);
	frame.add(Search);
	
}
public void database_material()
{
	
	Add.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		/*final String ex = STname.getText();
		final String ex2 = STclass.getText();
		final String jgetstringmale = Male.getText();
		final String jgetstringfemale = Female.getText();*/
	try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
		Connection conn = DriverManager.getConnection("jdbc:odbc:dbq");
		String str = "insert into student_details (sname,sclass,sgender,sfield,sroll_no,sadmission_no,btitle,bcopy,bedition) values(?,?,?,?,?,?,?,?,?)";     //('"+ex+"','"+ex2+"')"
		PreparedStatement ps = conn.prepareStatement(str);		
		ps.setString(1,STname.getText());
		ps.setString(2,STclass.getText());
		if(Male.isSelected())
		{		
			ps.setString(3,"Male");			
		}
		else if(Female.isSelected())
		{	
			ps.setString(3,"Female");	
		}
		String cbvalue = (String)CBfield.getSelectedItem();
		ps.setString(4,cbvalue);
		int roll_value = Integer.parseInt(STRoll_no.getText());
		ps.setInt(5,roll_value);
		ps.setString(6,STadmission.getText());
		ps.setString(7,BTtitle.getText());
		int copy_value = Integer.parseInt(BTcopies.getText());
		ps.setInt(8,copy_value);
		ps.setString(9,BTedition.getText());
		int i = ps.executeUpdate();
		
		conn.close();
	SStatus.setText("Data insert successfull");	
	}
	
	catch(Exception el)
	{ 
			
			System.out.println(el);
			SStatus.setText("please fill all data");
			//flag = true;
	}  
	/*if (flag == false)
	{
		SStatus.setText("Data insert successfull");
	}
	else
	{
		SStatus.setText("please fill all data");
	}end of if-else*/
	
	}
	}  
    );// end of addActionListener
	
		}
	
	//end of class database_material
public void search_class()
{
	Search.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ed){
			frame.dispose();
			search_frame=new JFrame("Library management");
            search_frame.setSize(900,600);
			search_frame.setLayout(null);
			search_frame_components();
			data_fetcher();
			search_frame.setVisible(true);
			search_back_class();
			}
	}
	);
	
}
public void search_back_class()
{
	Search_back.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent el){
			search_frame.dispose();
			library_mgmt();
		}
		
	});
}
public void search_frame_components()
{
	search_admission_no = new JLabel("Addmission number :");
	search_admission_no.setBounds(50,50,190,30);
	search_admission_no_tf = new JTextField();
	search_admission_no_tf.setBounds(190,50,190,30);
	search_info = new JButton("Enter");
	search_info.setBounds(450,50,100,30);
	search_student_name = new JLabel("Name:");
	search_student_name.setBounds(50,100,190,30);
	search_student_name_show = new JLabel();
	search_student_name_show.setBounds(100,100,190,30);
	search_gender = new JLabel("Gender:");
	search_gender.setBounds(50,150,190,30);
	search_gender_show = new JLabel();
	search_gender_show.setBounds(100,150,190,30);
	search_class = new JLabel("CLass:");
	search_class.setBounds(50,200,190,30);
	search_class_show = new JLabel();
	search_class_show.setBounds(100,200,190,30);
	search_field = new JLabel("Field:");
	search_field.setBounds(50,250,190,30);
	search_field_show = new JLabel();
	search_field_show.setBounds(100,250,190,30);
	search_roll_no = new JLabel("Roll number:");
	search_roll_no.setBounds(50,300,190,30);
	search_roll_no_show = new JLabel();
	search_roll_no_show.setBounds(130,300,190,30);
	search_book_title = new JLabel("Book name:");
	search_book_title.setBounds(50,350,190,30);
	search_book_title_show = new JLabel();
	search_book_title_show.setBounds(130,350,190,30);
	search_book_copy = new JLabel("Number of book copies ");
	search_book_copy.setBounds(50,400,190,30);
	search_book_copy_show = new JLabel();
	search_book_copy_show.setBounds(200,400,190,30);
	search_book_edition = new JLabel("book edition:");
	search_book_edition.setBounds(50,450,190,30);
	search_book_edition_show = new JLabel();
	search_book_edition_show.setBounds(130,450,190,30);
	Search_back = new JButton("Back");
	Search_back.setBounds(0,0,100,30);
	search_frame.add(search_admission_no);
	search_frame.add(search_admission_no_tf);
	search_frame.add(search_student_name);
	search_frame.add(search_student_name_show);
	search_frame.add(search_info);
	search_frame.add(search_gender);
	search_frame.add(search_gender_show);
	search_frame.add(search_class);
	search_frame.add(search_class_show);
	search_frame.add(search_field);
	search_frame.add(search_field_show);
	search_frame.add(search_roll_no);
	search_frame.add(search_roll_no_show);
	search_frame.add(search_book_title);
	search_frame.add(search_book_title_show);
	search_frame.add(search_book_copy);
	search_frame.add(search_book_copy_show);
	search_frame.add(search_book_edition);
	search_frame.add(search_book_edition_show);
	search_frame.add(Search_back);
}
public void data_fetcher()
{
	search_info.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent em){
			try{
		
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
				Connection conn = DriverManager.getConnection("jdbc:odbc:dbq");
				String z = search_admission_no_tf.getText();
				Statement st = conn.createStatement();
				ResultSet rs=st.executeQuery("select * from student_details where sadmission_no = '"+z+"'");		
				while (rs.next())
				{
					search_student_name_show.setText(rs.getString(2));
					search_gender_show.setText(rs.getString(4));
					search_field_show.setText(rs.getString(5));
					search_class_show.setText(rs.getString(3));
					int x = rs.getInt(6);
					search_roll_no_show.setText(Integer.toString(x));
					search_book_title_show.setText(rs.getString(8));
					search_book_copy_show.setText(Integer.toString(rs.getInt(9)));
					search_book_edition_show.setText(rs.getString(10));
			
				}
			
				conn.close();
						
				}
           catch(Exception el)
			{ 
			
			System.out.println(el);
			//flag = true;
	}  
	}
	}
	);	

}
public void refresh()
{
	Refresh.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent iz)
		{
			frame.dispose();
			library_mgmt();
		}
	}
	
	
	);
}
public void Delete_frame()
{
	Delete.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent lk)
		{
			frame.dispose();
			System.out.println("til done");
	        delete_frame = new JFrame("delete data");
            delete_frame.setSize(900,600);
			delete_frame.setLayout(null);
			Delete_frame_components();
			data_delete();
			delete_back_class();
			delete_frame.setVisible(true);
		}
	});
	
	
}
public void Delete_frame_components()
{
	delete_admission_no = new JLabel("Enter admission no:");
	delete_admission_no.setBounds(50,150,190,30);
	delete_admission_no_tf = new JTextField();
	delete_admission_no_tf.setBounds(200,150,190,30);
	delete_data_button = new JButton("Delete");
	delete_data_button.setBounds(400,150,190,30);
	delete_back_button = new JButton("Back");
	delete_back_button.setBounds(0,0,190,30);
	delete_data_success = new JLabel();
	delete_data_success.setBounds(50,250,190,30);
	delete_frame.add(delete_admission_no);
	delete_frame.add(delete_admission_no_tf);
	delete_frame.add(delete_data_button);
	delete_frame.add(delete_back_button);
	delete_frame.add(delete_data_success);
}
public void data_delete()
{
	delete_data_button.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
		try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
		Connection conn = DriverManager.getConnection("jdbc:odbc:dbq");
		String x = delete_admission_no_tf.getText();
		PreparedStatement ps = conn.prepareStatement("delete * from student_details where sadmission_no = '"+x+"'");
		int i = ps.executeUpdate();
		System.out.println("data delete");
		}
		catch(Exception el)
		{
			System.out.println(el);
		}
		delete_data_success.setText("Data Deleted successfull.");
		}
		}
		);
}
public void delete_back_class()
{
	delete_back_button.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			delete_frame.dispose();
			library_mgmt();
		}
	}
	);
}
public static void main(String args[])
{ 
    
    Library_mgmt b = new Library_mgmt();
   
    
}  
}  
  