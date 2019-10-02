package com.nrk.design;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.RescaleOp;
import java.io.File;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.filechooser.*;
import java.awt.Image;
import java.awt.TexturePaint;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nrk.dao.MobileDAO;
import com.nrk.model.Mobile;


public class BaseComponent {
	JFrame f;
	JFrame f2;
	JFrame f3;
	JButton contact;
	JLabel title;
	JButton delete;
	JButton search;
	JButton update;
	JButton Viewmobile;
	ClassPathXmlApplicationContext context;
	MobileDAO MobileDAO;
	private JFrame frame;
	String imgloc;
	
	public BaseComponent()
	{
		context = new ClassPathXmlApplicationContext("spring.xml");
		MobileDAO = context.getBean(MobileDAO.class);
	}
	
	
	
	
	public void LoadOnStartUp()
	{
		f=new JFrame();//creating instance of JFrame  
		title=new JLabel("MOBILE SHOP MANAGMENT SYSTEM");
		contact=new JButton("Add Mobile");//creating instance of JButton  
		Viewmobile = new JButton("View Mobile");
		JButton delete = new JButton("Delete Mobile");
		// update = new JButton("update price");
		 //search = new JButton("search mobile");
        
		 
		
		title.setBounds(70,10,300, 40);
		contact.setBounds(100,50,150, 40);//x axis, y axis, width, height  
		//delete.setBounds(, arg1, arg2, arg3);
		Viewmobile.setBounds(100,110,150, 40);//x axis, y axis, width, height
		delete.setBounds(100, 170, 150,40);
		//update.setBounds(100, 230, 150,40);
		//search.setBounds(100, 300, 150,40);
		
		 contact.addActionListener(new ActionListener() {
				
		public void actionPerformed(ActionEvent e) {
				  AddContactPage();  
				}
		});
		
		 delete.addActionListener(new ActionListener() {
				
		public void actionPerformed(ActionEvent e) {
				  Adddelete();  
				}
		});
		
		 Viewmobile.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
						  AddViewmobile();  
						}
				});
	/*	 update.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
						  Addupdate();  
						}
				});
		 search.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
						  Addsearch();  
						}
				});
 	 */
		f.add(contact);//adding button in JFrame  
		f.add(Viewmobile) ;   
	    f.add(delete);
	   // f.add(update);
	    f.add(title);
	    //f.add(search);
		f.setSize(400,500);//400 width and 500 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible  
	}

	 






protected void AddContactPage() {
	JFrame f=new JFrame("Add Mobile");
	JLabel l1,l2,l3,l4;
	
	l1 = new JLabel("Mobile Name");
	JTextField t1 = new JTextField();
	t1.setBounds(100, 60,150,30);
	l1.setBounds(30, 60,150,30);
	
	l2 = new JLabel("Model");
	JTextField t2 = new JTextField();
	t2.setBounds(100, 100,150,30);
	l2.setBounds(30, 100,150,30);
	
	l3 = new JLabel("price");
	JTextField t3 = new JTextField();
	t3.setBounds(100, 150,150,30);
	l3.setBounds(30, 150,150,30);
	
	
	
	//JButton upload=new JButton("upload");
	JTextField txtPath = new JTextField();
    txtPath.setBounds(100, 200, 200, 30);
   // frame.getContentPane().add(txtPath);
    txtPath.setColumns(10);
         
    JButton btnBrowse = new JButton("Upload Image");
    btnBrowse.setBounds(10, 200, 87, 23);
  //  frame.getContentPane().add(btnBrowse);
	
	
	JButton b1 = new JButton("Submit");
	b1.setBounds(150,280,100,40);
	
	
	
	f.add(l1);
	f.add(l2);
	f.add(l3);
	f.add(t1);
	f.add(t2);
	f.add(t3);
	
	f.add(b1);
	
	f.add(txtPath);
	f.add(btnBrowse );
	f.setSize(400,500);//400 width and 500 height  
	f.setLayout(null);//using no layout managers  
	f.setVisible(true);//making the frame visible  
	
	
	
	
	
	
	
	
	b1.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			
			if(t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty()){
				JOptionPane.showMessageDialog(f,"Fields Cannot Be Empty","Alert",JOptionPane.INFORMATION_MESSAGE);
								return;
			}
			

			//validation code
					


						try {
							
							String name = t1.getText();
							
							for(int i=0;i<name.length();++i) {
							if(Character.isDigit(name.charAt(i))) {
								JOptionPane.showMessageDialog(f,"only Charcters are allowed","Alert",JOptionPane.INFORMATION_MESSAGE);
								return;
							}
							}
							
							String model = t2.getText();
							
							for(int i=0;i<model.length();++i) {
							if(Character.isDigit(model.charAt(i))) {
								JOptionPane.showMessageDialog(f,"Only Charcters are allowed","Alert",JOptionPane.INFORMATION_MESSAGE);
								return;
							}
							}
							
							long number = Long.parseLong((t3.getText()));
							
						}catch(NumberFormatException EE)
						{
							JOptionPane.showMessageDialog(f,"Enter Digits Only","Alert",JOptionPane.INFORMATION_MESSAGE);
							return;
						}
			
			
			Mobile p = new Mobile();
			p.setName(t1.getText());
			p.setModel(t2.getText());
			p.setprice(Integer.valueOf(t3.getText()));
			p.setimage(imgloc);
			//p.setimage(txtPath.getText());
			MobileDAO.save(p);
			
			
			
			
	//validation code
			


				
				
			
JOptionPane.showMessageDialog(f,"Successfully inserted.","Alert",JOptionPane.INFORMATION_MESSAGE);
			
			f.setVisible(true); //you can't see me!
			f.dispose();
			
			
		}
	});
	
	
	JButton b=new JButton(new ImageIcon(" C:/Users/NINGANA GOUDA/Pictures.jpg"));  // C:/Users/NINGANA GOUDA/Pictures 
	b.setBounds(100,100,200, 100);    
	//f.add(b);    
	//upload image code
	/*btnBrowse.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        JFileChooser fileChooser = new JFileChooser();
	 
	        // For Directory
	        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	 
	        // For File
	        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	 
	        fileChooser.setAcceptAllFileFilterUsed(true);
	 
	        int rVal = fileChooser.showOpenDialog(null);
	        if (rVal == JFileChooser.APPROVE_OPTION) {
	          txtPath.setText(fileChooser.getSelectedFile().toString());
	         
	        }
	      }
	    });
	    */
	
	JLabel l8;
	btnBrowse.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  
	    	  JFileChooser file = new JFileChooser();
	          file.setCurrentDirectory(new File(System.getProperty("user.home")));
	          //filter the files
	          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
	          file.addChoosableFileFilter(filter);
	          int result = file.showSaveDialog(null);
	           //if the user click on save in Jfilechooser
	          if(result == JFileChooser.APPROVE_OPTION){
	              File selectedFile = file.getSelectedFile();
	              imgloc = selectedFile.getAbsolutePath();
	              txtPath.setText(imgloc);
	             // l8.setIcon(RescaleOp(path));
	          }
	           //if the user click on save in Jfilechooser


	          else if(result == JFileChooser.CANCEL_OPTION){
	              System.out.println("No File Select");
	    	  
	      }    
	      }
	      });
	
	
}
		


		
 
	
		










protected void Adddelete() { 
	final JLabel l1;  
    
	   
	final JFrame f=new JFrame("Delete Mobile");
	JButton b1 = new JButton("Delete");
	
	Vector vector = new Vector();
    
	List<Mobile> list = MobileDAO.list();
	Vector v = new Vector();
	
	for(Mobile p : list){
		v.addElement(p.getName());
	}
	
	
	final JComboBox cb=new JComboBox(v);  
	String name = (String) cb.getItemAt(cb.getSelectedIndex());
	Mobile p = MobileDAO.getName(name);
	l1=new JLabel(p.getModel());
	l1.setText(p.getModel());
	
	
      
    cb.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			String name = (String) cb.getItemAt(cb.getSelectedIndex());
			Mobile p = MobileDAO.getName(name);
			
			l1.setText(p.getModel());
			
		}
	});
    
    b1.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			String name = (String) cb.getItemAt(cb.getSelectedIndex());
			Mobile p = MobileDAO.getName(name);
			
			if(MobileDAO.delete(p.getName()) == 1) {
				JOptionPane.showMessageDialog(f,p.getName()+" Deleted Successufully","Alert",JOptionPane.INFORMATION_MESSAGE);
			f.setVisible(false); //you can't see me!
			f.dispose();
			}else {
				JOptionPane.showMessageDialog(f,"Something Went Wrong","Alert",JOptionPane.INFORMATION_MESSAGE);
			}
			}	
		
	});
    cb.setBounds(50,60,130,20);  
    l1.setBounds(200,55, 100,30);  
    b1.setBounds(60, 130, 100,30);
    f.add(b1);
    f.add(cb);
    f.add(l1);
    f.setSize(300,300);//width and  height  
	f.setLayout(null);//using no layout managers  
	f.setVisible(true);//making the frame visible
	  



}
/*
protected void  Addupdate()
{
	final JFrame f=new JFrame("update price");
	JLabel l1 = new JLabel("Mobile");
	JTextField t1 = new JTextField();
	t1.setBounds(100, 60,150,30);
	l1.setBounds(30, 60,150,30);
	
	JButton b1 = new JButton("Update price");
	b1.setBounds(80,150,200,40);
	
	f.add(l1);
	f.add(t1);
	f.add(b1);
	f.setSize(400,500);//400 width and 500 height  
	f.setLayout(null);//using no layout managers  
	f.setVisible(true);//making the frame visible  
	
	
	
	
}  

protected void  Addsearch()
{
	final JFrame f=new JFrame("Search mobile");
	JLabel l1 = new JLabel("Mobile");
	JTextField t1 = new JTextField();
	t1.setBounds(100, 60,150,30);
	l1.setBounds(30, 60,150,30);
 
	JButton b1 = new JButton("Search");
	b1.setBounds(80,150,200,40);
	
	f.add(l1);
	f.add(t1);
	f.add(b1);
	f.setSize(400,500);//400 width and 500 height  
	f.setLayout(null);//using no layout managers  
	f.setVisible(true);//making the frame visible  

}
*/
protected void AddViewmobile() {
	
	
	DefaultTableModel model = new DefaultTableModel(new String[]{"Name","Model","Price","image"}, 0);
	JFrame f=new JFrame("mobile");    
	 
	List<Mobile> list = MobileDAO.list();
	

	for(Mobile p : list){
		String name = p.getName();
    	String Model = p.getModel();
    	int Price = p.getPrice();
    	String image = p.getimage();
    	
		model.addRow(new Object[]{name,Model,Price,image,});
		
		
	
	}
	
	 
	
	
    JTable jt = new JTable(model);    
   
    jt.setBounds(30,40,200,300);          
    JScrollPane sp=new JScrollPane(jt);    
  int a[] =  jt.getSelectedRows();
  
  jt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	    public void valueChanged(ListSelectionEvent event) {
	        if (jt.getSelectedRow() > -1) {
	            // print first column value from selected row
	            String ImgLoc = jt.getValueAt(jt.getSelectedRow(), 3).toString();
	            display_Image(ImgLoc);
	        }
	    }
	});
    f.add(sp);          
    f.setSize(600,400);    
    f.setVisible(true);    
	
}




protected void display_Image(String imgLoc2) {
	JFrame f=new JFrame("Mobiole Image");
	JLabel l1,l2,l3,l4;
	
	
	JButton btnBrowse = new JButton(new ImageIcon(imgLoc2));
    btnBrowse.setBounds(10, 30, 200, 300);
	
	
	
	f.add(btnBrowse);
	f.setSize(400,380);//400 width and 500 height  
	f.setLayout(null);//using no layout managers  
	f.setVisible(true);
	
}
	
}


	
	