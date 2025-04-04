package gui;

import java.time.LocalDate;
import java.util.Random;
import java.util.logging.*;
import model.MySQL;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Avishka Chamod
 */
public class LibrarySection extends javax.swing.JPanel {

    static int LibrarianNic;

    public LibrarySection(int nic) {
        initComponents();
        this.LibrarianNic = nic;
        setupLogger();
        loadBookCat();
        loadLocation();
    }

    private static final Logger logger = Logger.getLogger(LibrarySection.class.getName());
    HashMap<String, Integer> bookCatMap = new HashMap();
    HashMap<String, Integer> secMap = new HashMap();
    HashMap<String, Integer> cupMap = new HashMap();
    String today = LocalDate.now().toString();

    private void setupLogger() {
        try {

            Handler fileHandler = new FileHandler("Logfiles/ls.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.log(Level.INFO, "Library Section Setup Success");

        } catch (Exception e) {
            e.printStackTrace();
            logger.severe("Library Section Failed " + e);
        }

    }

    private void loadBookCat() {
        try {
            ResultSet search = MySQL.exeSearch("SELECT * FROM `bookcat`");
            Vector<String> vec = new Vector();
            vec.add("Select");

            while (search.next()) {
                vec.add(search.getString("catname"));
                bookCatMap.put(search.getString("catname"), search.getInt("id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(vec);
            jComboBox1.setModel(model);
            search.close();
        } catch (Exception e) {
            e.printStackTrace();
            logger.severe("Load Book Categories Failed" + e);
        }

    }

    private void loadLocation() {
        try {

            ResultSet sectionSearch = MySQL.exeSearch("SELECT * FROM `section`");
            Vector<String> sec = new Vector<>();
            sec.add("Select");
            while (sectionSearch.next()) {
                sec.add(sectionSearch.getString("name"));
                secMap.put(sectionSearch.getString("name"), sectionSearch.getInt("id"));
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel(sec);
            jComboBox2.setModel(model);
            sectionSearch.close();

            ResultSet cupSearch = MySQL.exeSearch("SELECT * FROM `cupboard`");
            Vector<String> cup = new Vector<>();
            cup.add("Select");
            while (cupSearch.next()) {
                cup.add(cupSearch.getString("name"));
                cupMap.put(cupSearch.getString("name"), cupSearch.getInt("id"));
            }

            DefaultComboBoxModel _model = new DefaultComboBoxModel(cup);
            jComboBox3.setModel(_model);
            cupSearch.close();

        } catch (Exception e) {
            e.printStackTrace();
            logger.severe("Location Loading Failed" + e);
        }
    }

    private void clearFields() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jComboBox1.setSelectedItem("Select");

        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);

        jTextField4.setEditable(true);
        jTextField3.setEditable(true);
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
    }

    private void clearLocationFields() {
        jLabel17.setText("");
        jTextField5.setEditable(true);
        jTextField5.setText("");
        jComboBox2.setSelectedItem("Select");
        jComboBox3.setSelectedItem("Select");
        jButton7.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 133, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Library Section ");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Register a Book");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Book Name");

        jTextField1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Author");

        jTextField2.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Date Added");

        jTextField3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(0, 0, 0));

        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Today");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Book ID");

        jTextField4.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Generate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Book Category");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Availability");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jRadioButton1.setText("Available");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jRadioButton2.setText("Not Available");

        jButton3.setBackground(new java.awt.Color(4, 96, 76));
        jButton3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Register");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 102, 204));
        jButton4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear-icon.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 255));
        jLabel9.setText("Add Location");

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Enter Book ID");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-icon.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Add Section");

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Add Cupboard");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add-icon.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update-icon.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 255));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear-icon.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 6, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton5)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jRadioButton1)
                                        .addGap(29, 29, 29)
                                        .addComponent(jRadioButton2)
                                        .addGap(15, 15, 15))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(80, 80, 80))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(101, 101, 101))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addGap(6, 6, 6)
                                .addComponent(jButton8)
                                .addGap(6, 6, 6)
                                .addComponent(jButton11))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(75, 75, 75))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jButton11))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 255));
        jLabel13.setText("Find Information");

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Enter Book ID or Name");

        jTextField6.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(0, 0, 0));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search-icon.png"))); // NOI18N

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear-icon.png"))); // NOI18N

        jTable1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Date Added", "Book Category", "Added By"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Date Added");
            jTable1.getColumnModel().getColumn(4).setHeaderValue("Added By");
        }

        jTable2.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Section", "Cupboard"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        jTable3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Availability"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 255));
        jLabel15.setText("All Books");

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Sort By");

        jComboBox4.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTable4.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Book Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton10))
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel15)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel13)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton9))
                    .addComponent(jButton10))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextField3.setText(today);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Random random = new Random();
        jTextField4.setText(String.valueOf(10000000 + random.nextInt(99999999)));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String bookName = jTextField1.getText().trim();
        String author = jTextField2.getText().trim();
        String dateAdded = jTextField3.getText().trim();
        String bookId = jTextField4.getText().trim();
        Integer bookCatid = bookCatMap.get(jComboBox1.getSelectedItem().toString());
        jRadioButton1.setSelected(true);

        if (bookName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Book Name ", "Warning !", JOptionPane.WARNING_MESSAGE);
        } else if (author.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Author Name ", "Warning !", JOptionPane.WARNING_MESSAGE);
        } else if (dateAdded.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Date Use Today Button to Get Date ", "Warning !", JOptionPane.WARNING_MESSAGE);
        } else if (!dateAdded.matches("^(?:19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$")) {
            JOptionPane.showMessageDialog(this, "Invalid Format Date Use Today Button to Get Date ", "Warning !", JOptionPane.WARNING_MESSAGE);
        } else if (bookId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Book Id Use Generate Button to Get a Id", "Warning !", JOptionPane.WARNING_MESSAGE);
        } else if (!bookId.matches("^[0-9]{8}")) {
            JOptionPane.showMessageDialog(this, "Book Id Should Be Numbers Only and Include Only 8 Numbers ", "Warning !", JOptionPane.WARNING_MESSAGE);
        } else if (bookCatid == null) {
            JOptionPane.showMessageDialog(this, "Please Select The Book Category", "Warning !", JOptionPane.WARNING_MESSAGE);
        } else if (jRadioButton2.isSelected()) {
            JOptionPane.showMessageDialog(this, "Select The Book Available to Register", "Warning !", JOptionPane.WARNING_MESSAGE);
        } else {
            int bookAvailableId = 1;
            try {

                ResultSet search = MySQL.exeSearch("SELECT `name` FROM `booklibrary` WHERE `id` = '" + bookId + "'");

                if (search.next()) {
                    String name = search.getString("name");
                    JOptionPane.showMessageDialog(this, "Book Id is Already in Use " + name + "!", "Warning", JOptionPane.WARNING_MESSAGE);
                    search.close();
                } else {
                    search.close();

                    MySQL.exeUpdate("INSERT INTO `booklibrary` (`id`,`name`,`author`,`date_added`,`bookcat_id`,`Librarian_nic`,`bookavailability_id`)"
                            + " VALUES ('" + bookId + "','" + bookName + "','" + author + "','" + today + "','" + bookCatid + "', '" + LibrarianNic + "', '" + bookAvailableId + "')");
                    clearFields();

                }

            } catch (Exception e) {
                e.printStackTrace();
                logger.severe("Book Registration Failed " + e);
            }

        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if (jTextField4.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Book Id to Update ", "Warning !", JOptionPane.WARNING_MESSAGE);
            jTextField4.grabFocus();
        } else {

            String bookName = jTextField1.getText().trim();
            String author = jTextField2.getText().trim();
            String bookId = jTextField4.getText().trim();
            Integer bookCatid = bookCatMap.get(jComboBox1.getSelectedItem().toString());

            if (bookName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Book Name ", "Warning !", JOptionPane.WARNING_MESSAGE);
            } else if (author.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Enter Author Name ", "Warning !", JOptionPane.WARNING_MESSAGE);
            } else if (bookCatid == null) {
                JOptionPane.showMessageDialog(this, "Please Select The Book Category", "Warning !", JOptionPane.WARNING_MESSAGE);
            } else {
                int bookAvailablId = 1;
                if (jRadioButton1.isSelected()) {
                    bookAvailablId = 1;
                } else {
                    bookAvailablId = 2;
                }

                try {

                    MySQL.exeUpdate("UPDATE `booklibrary` SET `name`='" + bookName + "', `author`='" + author + "', `bookcat_id`='" + bookCatid + "',  `bookavailability_id`='" + bookAvailablId + "'"
                            + " WHERE `id` = '" + bookId + "'  ");

                    clearFields();

                    jTextField4.setEditable(true);
                    jTextField3.setEditable(true);
                    jButton1.setEnabled(true);
                    jButton2.setEnabled(true);
                    jButton3.setEnabled(true);

                } catch (Exception e) {
                    e.printStackTrace();
                    logger.severe("Book Registration Failed " + e);
                }

            }

        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        String id = jTextField4.getText();
        try {

            ResultSet search = MySQL.exeSearch("SELECT * FROM `booklibrary` WHERE `id` = '" + id + "'");

            if (search.next()) {

                jTextField1.setText(search.getString("name"));
                jTextField2.setText(search.getString("author"));
                jTextField3.setText(search.getString("date_added"));

                int value = search.getInt("bookcat_id");

                String key;

                for (Map.Entry<String, Integer> entry : bookCatMap.entrySet()) {
                    if (entry.getValue().equals(value)) {
                        key = entry.getKey();
                        jComboBox1.setSelectedItem(key);
                    }
                }

                jTextField4.setEditable(false);
                jTextField3.setEditable(false);
                jButton1.setEnabled(false);
                jButton2.setEnabled(false);
                jButton3.setEnabled(false);

                int bookAvId = search.getInt("bookavailability_id");

                if (bookAvId == 1) {
                    jRadioButton1.setSelected(true);
                } else {
                    jRadioButton2.setSelected(true);
                }

            }

            search.close();

        } catch (Exception e) {
            e.printStackTrace();
            logger.severe("Failed to get Book Information to Update" + e);
        }

    }//GEN-LAST:event_jTextField4KeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        clearFields();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        String bookid = jTextField5.getText();

        if (bookid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Id to Search ", "Warning !", JOptionPane.WARNING_MESSAGE);
        } else {

            try {
                ResultSet search = MySQL.exeSearch("SELECT * FROM `booklibrary` WHERE `id` = '" + bookid + "'");

                if (search.next()) {

                    jLabel17.setText(search.getString("name"));
                    jTextField5.setEditable(false);
                    search.close();

                    ResultSet resultSet = MySQL.exeSearch("SELECT * FROM `booklocation` WHERE `booklibrary_id` = '" + bookid + "'");

                    if (resultSet.next()) {
                           
                        Integer sectionId = resultSet.getInt("section_id");
                        Integer cupId = resultSet.getInt("cupboard_id");
                         
                        jButton7.setEnabled(false);
                        
                        for (Map.Entry<String, Integer> entry : secMap.entrySet()) {
                            if (entry.getValue().equals(sectionId)) {
                                String section = entry.getKey();
                                jComboBox2.setSelectedItem(section);
                            }
                        }

                        for (Map.Entry<String, Integer> entry : cupMap.entrySet()) {
                            if (entry.getValue().equals(cupId)) {
                                String cupboard = entry.getKey();
                                jComboBox3.setSelectedItem(cupboard);
                            }
                        }

                    } else {
                        jComboBox2.setSelectedItem("Select");
                        jComboBox3.setSelectedItem("Select");
                    }

                } else {
                    search.close();
                    JOptionPane.showMessageDialog(this, "Invalid Book ID", "Warning !", JOptionPane.WARNING_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
                logger.severe("Failed to find Book Using Id Location Add Failed" + e);
            }

        }


    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        clearLocationFields();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        String id = jTextField5.getText();
        String bookname = jLabel17.getText();

        if (id.isEmpty() && bookname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter the Book ID and Validate it By using Search Button !", "Warning !", JOptionPane.WARNING_MESSAGE);

        } else {

            String section = jComboBox2.getSelectedItem().toString();
            String location = jComboBox3.getSelectedItem().toString();

            if (!section.equals("Select")) {
             
          
                
                    try {

                        if (location.equals("Select")) {
                             int secId = secMap.get(section);
                             
                             MySQL.exeUpdate("INSERT INTO `booklocation` (`booklibrary_id`,`section_id`) VALUES"
                                    + " ('"+id+"','"+secId+"')");
                             JOptionPane.showMessageDialog(this, "Successfully Added" +" " +bookname +" " +"to" +section +"!","Success", JOptionPane.PLAIN_MESSAGE);
                             clearLocationFields();
                             
                        } else {
                            
                             int secId = secMap.get(section);
                             int cupId = cupMap.get(location);

                            MySQL.exeUpdate("INSERT INTO `booklocation` (`booklibrary_id`,`section_id`,`cupboard_id`) VALUES "
                                    + "('"+id+"','"+secId+"','"+cupId+"')  ");
                            JOptionPane.showMessageDialog(this, "Successfully Added" +"   " +bookname +"   " +"to" +"  " +section +"  " +"and" +"  " +location +" " +"!","Success", JOptionPane.PLAIN_MESSAGE);
                            clearLocationFields();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.severe("Failed to Insert Location " + e);
                    }

                

            } else {
                
                JOptionPane.showMessageDialog(this, "Please Select the Section !", "Information", JOptionPane.INFORMATION_MESSAGE);
            }

        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       
        String id = jTextField5.getText();
        String bookname = jLabel17.getText();

        if (id.isEmpty() && bookname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter the Book ID and Validate it By using Search Button !", "Warning !", JOptionPane.WARNING_MESSAGE);

        } else {

            String section = jComboBox2.getSelectedItem().toString();
            String location = jComboBox3.getSelectedItem().toString();

            if (!section.equals("Select")) {
              
          
                
                    try {

                        if (location.equals("Select")) {
                            int secId = secMap.get(section);
                             MySQL.exeUpdate("UPDATE `booklocation` SET `section_id` = '"+secId+"' WHERE `booklibrary_id` = '"+id+"' ");
                             JOptionPane.showMessageDialog(this, "Successfully Updated" +" " +bookname +" " +"to" +section +"!","Success", JOptionPane.PLAIN_MESSAGE);
                             clearLocationFields();

                        } else {

                            int secId = secMap.get(section);
                            int cupId = cupMap.get(location);
                            
                            MySQL.exeUpdate("UPDATE `booklocation`  SET `section_id` = '"+secId+"' , `cupboard_id` = '"+cupId+"' "
                                    + " WHERE `booklibrary_id` = '"+id+"' ");
                            JOptionPane.showMessageDialog(this, "Successfully Updated " +"   " +bookname +"   " +"to" +"  " +section +"  " +"and" +"  " +location +" " +"!","Success", JOptionPane.PLAIN_MESSAGE);
                            clearLocationFields();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.severe("Failed to Insert Location " + e);
                    }

                

            } else {
                
                JOptionPane.showMessageDialog(this, "Please Select the Section !", "Information", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        
        
    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
