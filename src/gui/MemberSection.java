package gui;

import java.awt.Color;
import java.util.logging.*;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author Avishka Chamod
 */
public class MemberSection extends javax.swing.JPanel {

    static int nic;
    HashMap<String, Integer> ocuMap = new HashMap<>();
    LocalDate date = LocalDate.now();

    public MemberSection(int nic) {
        initComponents();
        this.nic = nic;
        setupLogger();
        loadOccupation();

    }

    private final static Logger logger = Logger.getLogger(MemberSection.class.getName());

    private void setupLogger() {
        try {

            Handler fh = new FileHandler("Logfiles/ms.log", true);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.info("Member Section Logger Setup Success");

        } catch (Exception e) {
            e.printStackTrace();
            logger.severe("Failed to Setup Logger for Member Section" + e);
        }
    }

    private void loadOccupation() {
        try {

            ResultSet resultSet = MySQL.exeSearch("SELECT * FROM `occupation`");
            Vector<String> vector = new Vector<>();
            vector.add("Select");

            while (resultSet.next()) {
                vector.add(resultSet.getString("occupation"));
                ocuMap.put(resultSet.getString("occupation"), resultSet.getInt("id"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox2.setModel(model);
            resultSet.close();

        } catch (Exception e) {
            e.printStackTrace();
            logger.severe("Failed to load Occupations" + e);
        }
    }

    private void clearFields() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jComboBox2.setSelectedItem("Select");
        jLabel11.setText("...");
        jRadioButton1.setSelected(false);
        jButton2.setEnabled(true);
        jTextField6.setEditable(true);
        jTextField3.setEditable(true);
        jButton4.setText("DEACTIVE");
        jButton4.setBackground(new Color(153, 0, 51));

    }
    
    private void loadAllDataTable(){
         String sortBy = jComboBox1.getSelectedItem().toString();
        String query = "SELECT * FROM `member` INNER JOIN `memberstatus` ON `memberstatus`.`id` = `member`.`memberstatus_id`";
           
        
        if(sortBy.equals("Reg Date Newest")){
            query += "ORDER BY `member`.`reg_date` ASC";
        }else if(sortBy.equals("Reg Date Oldest")){
            query += "ORDER BY `member`.`reg_date` DESC";
        }else if(sortBy.equals("Name A-Z")){
            query += "ORDER BY `member`.`first_name` ASC";
        }else if(sortBy.equals("Name Z-A")){
            query += "ORDER BY `member`.`first_name` DESC";
        }else if(sortBy.equals("Active First")){
            query += "ORDER BY `member`.`memberstatus_id` ASC";
        }else if(sortBy.equals("Deactive First")){
            query += "ORDER BY `member`.`memberstatus_id` DESC";
        }
        
        try {
            
            ResultSet resultSet = MySQL.exeSearch(query);
            DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
            model.setRowCount(0);
            
            while(resultSet.next()){
                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("member.id"));
                vector.add(resultSet.getString("member.first_name") +" " +resultSet.getString("member.last_name"));
                vector.add(resultSet.getString("member.mobile"));
                vector.add(resultSet.getString("memberstatus.status"));
                vector.add(resultSet.getString("member.reg_date"));
                model.addRow(vector);               
            }
            
            jTable3.setModel(model);
            resultSet.close();
            
            
            
        } catch (Exception e) {
          e.printStackTrace();
          logger.severe("Failed to Sort and Retrive All Data Member Table " +e);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 133, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Member Section ");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("Member Registration");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("First Name");

        jTextField1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Surname");

        jTextField2.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Birth Day");

        jTextField3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Contact");

        jTextField4.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(0, 0, 0));
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("E-Mail");

        jTextField5.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Member ID");

        jTextField6.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(0, 0, 0));
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Occupation");

        jComboBox2.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Registration Fee :");

        jRadioButton1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jRadioButton1.setText("Paid");

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("...");

        jButton2.setBackground(new java.awt.Color(0, 153, 102));
        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-icon.png"))); // NOI18N
        jButton2.setText("REGISTER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update-icon.png"))); // NOI18N
        jButton3.setText("UPDATE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 0, 51));
        jButton4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/remove-icon.png"))); // NOI18N
        jButton4.setText("DEACTIVE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/email-icon.png"))); // NOI18N

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear-icon.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton2)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton1)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4)))))
                        .addContainerGap(27, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel7)
                .addGap(6, 6, 6)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel9)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(6, 6, 6)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 255));
        jLabel12.setText("Member Info");

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Member ID or Mobile");

        jTextField7.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(0, 0, 0));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-icon.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear-icon.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Member Id", "Name", "Contact", "E-Mail", "Reg Date", "Occupation", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jTable2.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reserve Date", "Return Date", "Book ", "Return Status", "Librarian NIC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 255));
        jLabel18.setText("History");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jLabel13))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel12)))
                        .addGap(0, 433, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton8)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Find Information", jPanel3);

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Sort By :");

        jComboBox1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reg Date Newest", "Reg Date Oldest", "Name A-Z", "Name Z-A", "Active First", "Deactive First" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jTable3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTable3.setForeground(new java.awt.Color(0, 0, 0));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Member ID", "Name", "Contact", "Status", "Reg Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("All Members", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addGap(11, 11, 11)))
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Random random = new Random();
        jTextField6.setText(String.valueOf(100000 + random.nextInt(999999)));

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged

        String ref = jComboBox2.getSelectedItem().toString();

        if (!(ref.equals("Select"))) {

            if (ref.equals("Student")) {
                Double fee = model.SetupDb.getStuRegFee();
                jLabel11.setText(fee.toString());
            } else if (ref.equals("Employee")) {
                Double fee = model.SetupDb.getEmpRegFee();
                jLabel11.setText(fee.toString());
            }

        } else {
            jLabel11.setText("...");
        }

    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String fname = jTextField1.getText();
        String sname = jTextField2.getText();
        String bday = jTextField3.getText();
        String contact = jTextField4.getText();
        String email = jTextField5.getText();
        String id = jTextField6.getText();
        String occupation = jComboBox2.getSelectedItem().toString();

        if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter First Name !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!fname.matches("[A-Z][a-z]*")) {
            JOptionPane.showMessageDialog(this, "First Name can Only Include Letters A to Z and First Letter Should be Capital! !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (sname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter SurName !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!(sname.matches("[A-Z][a-z]*"))) {
            JOptionPane.showMessageDialog(this, "Surname can Only Include Letters A to Z and First Letter Should be Capital !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (bday.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Birth Day !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!(bday.matches("^(19|20)\\d{2}\\-(0[1-9]|1[0-2])\\-(0[1-9]|[12]\\d|3[01])$"))) {
            JOptionPane.showMessageDialog(this, "Invalid Birth Day Format ! Format is: Year-Month-Day ex:2002-01-15 !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (contact.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Contact !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!contact.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Invalid Contact !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "E-Mail Cannot be Empty !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!(email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$"))) {
            JOptionPane.showMessageDialog(this, "E-Mail is Invalid !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter a Member ID or Generate it !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!(id.matches("^[0-9]{6}$"))) {
            JOptionPane.showMessageDialog(this, "Invalid Id use Only 6 Numbers !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (occupation.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select the Occupation !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!(jRadioButton1.isSelected())) {
            JOptionPane.showMessageDialog(this, "Members have to Pay Membership fee before Registration!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {

                ResultSet search = MySQL.exeSearch("SELECT `first_name` FROM `member` WHERE `id` = '" + id + "' OR `email` = '" + email + "' OR `mobile` = '" + contact + "' ");

                if (search.next()) {
                    JOptionPane.showMessageDialog(this, "Already Registered Member Using ID / E-Mail / Mobile !", "Warning", JOptionPane.WARNING_MESSAGE);
                    search.close();
                } else {
                    search.close();
                    int ocId = ocuMap.get(occupation);
                    int mActive = 1;

                    Integer reg = MySQL.exeUpdate("INSERT INTO `member` (`id`,`first_name`,`last_name`,`birthday`,`mobile`,`email`,`reg_date`,`Librarian_nic`,`occupation_id`,`memberstatus_id`) "
                            + "VALUES ('" + id + "', '" + fname + "', '" + sname + "', '" + bday + "', '" + contact + "', '" + email + "', '" + date.toString() + "', '" + this.nic + "', '" + ocId + "', '" + mActive + "') ");

                    if (reg == 1) {

                        String note = "Membership Registration Fee";
                        String amount = jLabel11.getText();
                        String lbId = "";

                        if (ocId == 1) {
                            lbId = "1";
                        } else if (ocId == 2) {
                            lbId = "2";
                        }

                        Integer feesAdding = MySQL.exeUpdate("INSERT INTO `fines` (`note`,`amount`,`paid_date`,`libraryfees_id`,`member_id`,`Librarian_nic`) "
                                + " VALUES ('" + note + "','" + amount + "','" + date.toString() + "','" + lbId + "','" + id + "','" + this.nic + "') ");

                        if (feesAdding == 1) {
                            int res = JOptionPane.showConfirmDialog(this, "Registration Success ! Do You Want to Clear ?", "Registration - Success", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

                            if (res == JOptionPane.YES_OPTION) {
                                clearFields();
                            }

                        } else {
                            JOptionPane.showMessageDialog(this, "User Registration Success But Fees Adding Failed : Internal Error !", "Internal Error", JOptionPane.ERROR_MESSAGE);
                            logger.log(Level.WARNING, "User Registrion Success and Fees Adding Failed");
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "User Registration Failed Unexpectlly !", "Internal Error", JOptionPane.ERROR_MESSAGE);
                        logger.log(Level.WARNING, "User Registrion Failed due to Internal Error ");
                        clearFields();
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
                logger.severe("Member Registration Failed" + e);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        clearFields();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased

        String mobile = jTextField4.getText();

        try {
            ResultSet search = MySQL.exeSearch("SELECT * FROM `member` WHERE `mobile` = '" + mobile + "'");

            if (search.next()) {

                jTextField1.setText(search.getString("first_name"));
                jTextField2.setText(search.getString("last_name"));
                jTextField5.setText(search.getString("email"));
                jTextField3.setText(search.getString("birthday"));
                jTextField6.setText(search.getString("id"));

                Integer ocValue = search.getInt("occupation_id");

                for (Map.Entry<String, Integer> entry : ocuMap.entrySet()) {
                    if (entry.getValue() == ocValue) {
                        String key = entry.getKey();
                        jComboBox2.setSelectedItem(key);
                        jRadioButton1.setSelected(true);
                    }
                }

                String memberStatus = search.getString("memberstatus_id");

                if (memberStatus.equals("1")) {
                    jButton4.setText("DEACTIVE");
                    jButton4.setBackground(new Color(153, 0, 51));
                } else {
                    jButton4.setText("ACTIVE");
                    jButton4.setBackground(new Color(0, 153, 102));
                }

                jButton2.setEnabled(false);
                jTextField6.setEditable(false);
                jTextField3.setEditable(false);

            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.severe("Retriving Member Data Using Mobile is Failed" + e);
        }

    }//GEN-LAST:event_jTextField4KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String fname = jTextField1.getText();
        String sname = jTextField2.getText();
        String bday = jTextField3.getText();
        String contact = jTextField4.getText();
        String email = jTextField5.getText();
        String id = jTextField6.getText();
        String occupation = jComboBox2.getSelectedItem().toString();

        if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter First Name to Update Member Info !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!fname.matches("[A-Z][a-z]*")) {
            JOptionPane.showMessageDialog(this, "First Name can Only Include Letters A to Z and First Letter Should be Capital! !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (sname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter SurName to Update Member Info!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!(sname.matches("[A-Z][a-z]*"))) {
            JOptionPane.showMessageDialog(this, "Surname can Only Include Letters A to Z and First Letter Should be Capital !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (bday.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Birth Day to Update Member Info!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!(bday.matches("^(19|20)\\d{2}\\-(0[1-9]|1[0-2])\\-(0[1-9]|[12]\\d|3[01])$"))) {
            JOptionPane.showMessageDialog(this, "Invalid Birth Day Format ! Format is: Year-Month-Day ex:2002-01-15 !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (contact.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Contact to Update Member Info!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!contact.matches("^07[01245678]{1}[0-9]{7}$")) {
            JOptionPane.showMessageDialog(this, "Invalid Contact !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "E-Mail Cannot be Empty !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!(email.matches("^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$"))) {
            JOptionPane.showMessageDialog(this, "E-Mail is Invalid !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (occupation.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select the Occupation to Update Member Info !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {

                ResultSet search = MySQL.exeSearch("SELECT `id` FROM `member` WHERE  `mobile` = '" + contact + "' OR `email` = '" + email + "' ");

                if (search.next()) {

                    String dbId = search.getString("id");

                    if (dbId.equals(id)) {

                        Integer update = MySQL.exeUpdate("UPDATE `member` SET `first_name` = '" + fname + "' , `last_name` = '" + sname + "' ,"
                                + " `birthday` = '" + bday + "' , `mobile` = '" + contact + "' , `occupation_id` = '" + ocuMap.get(occupation) + "'"
                                + " WHERE `id` = '" + id + "' ");

                        if (update == 1) {
                            int res = JOptionPane.showConfirmDialog(this, "Updating Success ! Do You Want to Clear ?", "Registration - Success", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                            if (res == JOptionPane.YES_OPTION) {
                                clearFields();
                            }

                        } else {
                            JOptionPane.showMessageDialog(this, "Updating Failed !! : Internal Error", "Error", JOptionPane.ERROR_MESSAGE);
                            logger.warning("Member Data Updating Failed");
                            clearFields();
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Mobile or E-Mail Already Used !", "Warning", JOptionPane.WARNING_MESSAGE);
                        search.close();
                    }

                } else {

                    Integer update = MySQL.exeUpdate("UPDATE `member` SET `first_name` = '" + fname + "' , `last_name` = '" + sname + "' ,"
                            + " `birthday` = '" + bday + "' , `mobile` = '" + contact + "' , `occupation_id` = '" + ocuMap.get(occupation) + "'"
                            + " WHERE `id` = '" + id + "' ");

                    if (update == 1) {
                        int res = JOptionPane.showConfirmDialog(this, "Updating Success ! Do You Want to Clear ?", "Registration - Success", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                        if (res == JOptionPane.YES_OPTION) {
                            clearFields();
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Updating Failed !! : Internal Error", "Error", JOptionPane.ERROR_MESSAGE);
                        logger.warning("Member Data Updating Failed");
                        clearFields();
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
                logger.severe("Member Data Update Failed" + e);
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String mobile = jTextField4.getText();
        String id = jTextField6.getText();

        if (mobile.isEmpty() && id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter the Member Mobile or Id to Deactivate or Activate !", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                String status = jButton4.getText();
                String statusid = "";

                if (status.equals("ACTIVE")) {
                    statusid = "1";
                } else {
                    statusid = "2";
                }

                Integer update = MySQL.exeUpdate("UPDATE `member` SET `memberstatus_id` = '" + statusid + "' WHERE `id` = '" + id + "'");

                if (update == 1) {
                    int res = JOptionPane.showConfirmDialog(this, "Status Update Success ! Do You Want to Clear ?", "Success", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                    if (res == JOptionPane.YES_OPTION) {
                        clearFields();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Member status Update Failed ! : Internal Error", "Error", JOptionPane.ERROR_MESSAGE);
                    logger.warning("Member Status Updating Failed : internal Error");
                    clearFields();
                }

            } catch (Exception e) {
                e.printStackTrace();
                logger.severe("Member Status Changing Failed" + e);
            }
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        String id = jTextField6.getText();

        try {
            ResultSet search = MySQL.exeSearch("SELECT * FROM `member` WHERE `id` = '" + id + "'");

            if (search.next()) {

                jTextField1.setText(search.getString("first_name"));
                jTextField2.setText(search.getString("last_name"));
                jTextField5.setText(search.getString("email"));
                jTextField3.setText(search.getString("birthday"));
                jTextField6.setText(search.getString("id"));

                Integer ocValue = search.getInt("occupation_id");

                for (Map.Entry<String, Integer> entry : ocuMap.entrySet()) {
                    if (entry.getValue() == ocValue) {
                        String key = entry.getKey();
                        jComboBox2.setSelectedItem(key);
                        jRadioButton1.setSelected(true);
                    }
                }

                String memberStatus = search.getString("memberstatus_id");

                if (memberStatus.equals("1")) {
                    jButton4.setText("DEACTIVE");
                    jButton4.setBackground(new Color(153, 0, 51));
                } else {
                    jButton4.setText("ACTIVE");
                    jButton4.setBackground(new Color(0, 153, 102));
                }

                search.close();

                jButton2.setEnabled(false);
                jTextField6.setEditable(false);
                jTextField3.setEditable(false);

            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.severe("Retriving Member Data Using Mobile is Failed" + e);
        }
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
        String ref = jTextField7.getText();
        
        if(ref.isEmpty()){
             JOptionPane.showMessageDialog(this, "Please Enter Member ID or Mobile to find info", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                
                ResultSet set = MySQL.exeSearch("SELECT * FROM `member` WHERE `id` = '"+ref+"' OR `mobile` = '"+ref+"'");
                
                if(set.next()){
                    
                    String  memberId = set.getString("id");
                    
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.setRowCount(0);
                    Vector<String> vector = new Vector();
                    vector.add(memberId);
                    vector.add(set.getString("first_name") +" " +set.getString("last_name"));
                    vector.add(set.getString("mobile"));
                    vector.add(set.getString("email"));
                    vector.add(set.getString("reg_date"));
                    
                    Integer value = set.getInt("occupation_id");
                    
                    String occupation = "";
                    
                    for(Map.Entry<String,Integer> entry : ocuMap.entrySet()){
                        if(entry.getValue() == value){
                            occupation = entry.getKey();                         
                        }
                    }
                    
                    vector.add(occupation);                    
                    String memberStId = set.getString("memberstatus_id");                 
                    if(memberId.equals("1")){
                        vector.add("Active");
                    }else{
                        vector.add("Deactive");
                    }
                    
                    model.addRow(vector);
                    jTable1.setModel(model);
                    set.close();
                    
                    ResultSet histroySearch =  MySQL.exeSearch("SELECT * FROM `bookreserve` INNER JOIN `booklibrary` "
                            + " ON `booklibrary`.`id` = `bookreserve`.`booklibrary_id` INNER JOIN `return` ON `return`.`id` = `bookreserve`.`return_id` "
                            + " WHERE `bookreserve`.`member_id` = '"+memberId+"'");
                    DefaultTableModel modelH = (DefaultTableModel) jTable2.getModel();
                    modelH.setRowCount(0);
                 
                    while(histroySearch.next()){
                        Vector<String> vectorH = new Vector<>();
                        vectorH.add(histroySearch.getString("bookreserve.reserve_date"));
                        vectorH.add(histroySearch.getString("bookreserve.return_date"));
                        vectorH.add(histroySearch.getString("booklibrary.name"));
                        vectorH.add(histroySearch.getString("return.status"));
                        vectorH.add(histroySearch.getString("booklibrary.Librarian_nic"));
                        modelH.addRow(vectorH);
                    }
                    
                   jTable2.setModel(modelH);
                   histroySearch.close();
                    
                }else{
                      JOptionPane.showMessageDialog(this, "Invalid Member ID or Mobile !", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (Exception e) {
            e.printStackTrace(); 
            logger.severe("Canont Find member Info using Mobile or ID" +e);
            }          
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       ((DefaultTableModel)jTable1.getModel()).setRowCount(0);
       ((DefaultTableModel)jTable2.getModel()).setRowCount(0);
       jTextField7.setText("");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
           loadAllDataTable();   
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
       loadAllDataTable();
    }//GEN-LAST:event_jComboBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables

}
