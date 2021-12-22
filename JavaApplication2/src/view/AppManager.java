/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Category;
import controller.CategoryModify;
import controller.FeedBackModify;
import controller.ImageHinh;
import controller.OrderModify;
import model.Product;
import controller.ProductModify;
import controller.RoleModify;
import model.Role;
import model.User;
import controller.UserModify;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Feedback;
import model.Order;
/**
 *
 * @author Admin
 */
public class AppManager extends javax.swing.JFrame {
    DefaultTableModel tableModelProduct;
    DefaultTableModel tableModelCategory;
    DefaultTableModel tableModelUser;
    DefaultTableModel tableModelFeedback; 
    DefaultTableModel tableModelOrder;
    
    List<Product> products = new ArrayList<>();
    List<Category> categoryList = new ArrayList<>();
    List<User> users = new ArrayList<>();
    List<Role> roleList = new ArrayList<>();
    List<Feedback> feedbackList = new ArrayList<>();
    List<Order> orderList = new ArrayList<>();
    
    OrderProductFrm orderProductFrm;

    private byte[] personImage;
    private AppManager parentForm; 
    /**
     * Creates new form NewJFrame
     */
    public AppManager() {
        initComponents();
        
        tableModelProduct = (DefaultTableModel) tableProduct.getModel();
        tableModelCategory = (DefaultTableModel) tableCategory.getModel();
        tableModelUser = (DefaultTableModel) tableUser.getModel();
        tableModelFeedback = (DefaultTableModel) tableFeedback.getModel();
        tableModelOrder = (DefaultTableModel) tableOrder.getModel();
        
        showProduct();
        showCategory();
        showUser();
        showFeedback();
        showOrder();
        
        tableProduct.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                int selectedIndex = tableProduct.getSelectedRow();
                Product prd = products.get(selectedIndex);
                
                txtTitleProduct.setText(prd.getTitle());
                boxCategory.setSelectedItem(prd.getCategoryName());
                txtPrice.setText(prd.getPrice());
                txtDescProduct.setText(prd.getDescription());
                txtThumbProduct1.setText(prd.getThumbnail());
                
                btnDeleteProduct.setEnabled(true);
                btnUpdateProduct.setEnabled(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        
        });
        
        tableCategory.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                int selectedIndex = tableCategory.getSelectedRow();
                Category category = categoryList.get(selectedIndex);
                
                txtNameCategory.setText(category.getName());
                txtDescH4.setText(category.getH4content());
                txtDescH5.setText(category.getH5content());
                btnUpdateCategory.setEnabled(true);
                btnDeleteCategory.setEnabled(true);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        
        });
        
        tableUser.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                int selectedIndex = tableUser.getSelectedRow();
                User user = users.get(selectedIndex);
                
                txtFullname.setText(user.getFullname());
                txtEmail.setText(user.getEmail());
                txtPhonenumber.setText(user.getPhoneNumber());
                txtAddress.setText(user.getAddress());
                boxRole.setSelectedItem(user.getRoleName());
                txtPassword.setText(user.getPassword());
                
                btnUpdateUser.setEnabled(true);
                btnDeleteUser.setEnabled(true);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        
        });
        
        tableOrder.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                int selectedIndex = tableOrder.getSelectedRow();
                Order order = orderList.get(selectedIndex);
                
                txtFullnameOrder.setText(order.getUserfullname());
                txtEmailOrder.setText(order.getEmail());
                txtPhoneNumberOrder.setText(order.getPhoneNumber());
                txtAddressOrder.setText(order.getAddress());
                txtNoteOrder1.setText(order.getNote());
                
                btnUpdateOrder.setEnabled(true);
                btnDeleteOrder.setEnabled(true);
                btnShowProductOrder.setEnabled(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        
        });
        
        showComboBoxSelect_Category();
        showComboBox_Category();
        showComboBox_RoleUser();
    }
    
    
    public void showComboBoxSelect_Category() {
        DefaultComboBoxModel<String> comboBoxModelProducta = (DefaultComboBoxModel<String>) boxSelectCategory.getModel();
        comboBoxModelProducta.removeAllElements();
        categoryList.forEach(category -> {
            comboBoxModelProducta.addElement(category.getName());
        });
    }
    public void showComboBox_Category() {
        DefaultComboBoxModel<String> comboBoxModelProduct = (DefaultComboBoxModel<String>) boxCategory.getModel();
        comboBoxModelProduct.removeAllElements();
        categoryList.forEach(category -> {
            comboBoxModelProduct.addElement(category.getName());
        });
    }
    
    public void showComboBox_RoleUser() {
        DefaultComboBoxModel<String> comboBoxModelUser = (DefaultComboBoxModel<String>) boxRole.getModel();
        comboBoxModelUser.removeAllElements();
        roleList = RoleModify.findAll();
        roleList.forEach(role -> {
            comboBoxModelUser.addElement(role.getName());
        });
    }
    
    private void showProduct() {
        products = ProductModify.findAll();
        
        tableModelProduct.setRowCount(0);
        
        products.forEach((prd) -> {
            tableModelProduct.addRow(new Object[] {
                tableModelProduct.getRowCount() + 1,
                prd.getTitle(),
                prd.getCategoryName(),
                prd.getPrice(),
                prd.getDescription(),
                prd.getThumbnail(),
                prd.getCreated_at(),
                prd.getUpdated_at()
            });
        });
    } 
    private void showCategory() {
        categoryList = CategoryModify.findAll();
        
        tableModelCategory.setRowCount(0);
        
        categoryList.forEach((category) -> {
            tableModelCategory.addRow(new Object[] {tableModelCategory.getRowCount() + 1,
                category.getName(),
                category.getH4content(),
                category.getH5content()});
        });
    }
    
    private void showUser() {
        users = UserModify.findAll();
        
        tableModelUser.setRowCount(0);
        
        users.forEach((user) -> {
            tableModelUser.addRow(new Object[] {tableModelUser.getRowCount() + 1,
                user.getFullname(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getAddress(),
                user.getRoleName(),
                user.getCreated_at(),
                user.getUpdated_at()});
        });
    }
    
    private void showFeedback() {
        feedbackList = FeedBackModify.findAll();
        
        tableModelFeedback.setRowCount(0);
        
        feedbackList.forEach((feedback) -> {
            tableModelFeedback.addRow(new Object[] {tableModelFeedback.getRowCount() + 1,
                feedback.getFullname(),
                feedback.getEmail(),
                feedback.getNote(),
                feedback.getPhoneNumber(),
                feedback.getCreated_at()});
        });
    }
    
    private void showOrder() {
        orderList = OrderModify.findAll();
        
        tableModelOrder.setRowCount(0);
        
        orderList.forEach((order) -> {
            tableModelOrder.addRow(new Object[] {tableModelOrder.getRowCount() + 1,
                order.getUserfullname(),
                order.getEmail(),
                order.getPhoneNumber(),
                order.getAddress(),
                order.getNote(),
                order.getTotalMoney(),
                order.getCreateTime()});
        });
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNameCategory = new javax.swing.JTextField();
        btnDeleteCategory = new javax.swing.JButton();
        btnUpdateCategory = new javax.swing.JButton();
        btnFindCategory = new javax.swing.JButton();
        btnResetCategory = new javax.swing.JButton();
        btnInsertCategory = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtDescH4 = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtDescH5 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCategory = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtFullname = new javax.swing.JTextField();
        txtPhonenumber = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        btnInsertUser = new javax.swing.JButton();
        btnUpdateUser = new javax.swing.JButton();
        btnDeleteUser = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableUser = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnFindUser = new javax.swing.JButton();
        btnResetUser = new javax.swing.JButton();
        boxRole = new javax.swing.JComboBox<>();
        btnExitUser = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableFeedback = new javax.swing.JTable();
        btnDeleteFeedBack = new javax.swing.JButton();
        btnExitFeedback = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableOrder = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btnUpdateOrder = new javax.swing.JButton();
        btnDeleteOrder = new javax.swing.JButton();
        btnShowProductOrder = new javax.swing.JButton();
        btnFindOrder = new javax.swing.JButton();
        btnResetOrder = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtFullnameOrder = new javax.swing.JTextField();
        txtEmailOrder = new javax.swing.JTextField();
        txtPhoneNumberOrder = new javax.swing.JTextField();
        txtAddressOrder = new javax.swing.JTextField();
        btnExitOrder = new javax.swing.JButton();
        txtNoteOrder = new javax.swing.JScrollPane();
        txtNoteOrder1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        infoProduct = new javax.swing.JPanel();
        Name = new javax.swing.JLabel();
        txtTitleProduct = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        Desc = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        Category = new javax.swing.JLabel();
        btnInsertProduct = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        btnResetProduct = new javax.swing.JButton();
        btnFindProduct = new javax.swing.JButton();
        btnUpdateProduct = new javax.swing.JButton();
        boxCategory = new javax.swing.JComboBox<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtDescProduct = new javax.swing.JTextArea();
        txtThumbProduct = new javax.swing.JTextField();
        Desc1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProduct = new javax.swing.JTable();
        txtThumbProduct1 = new javax.swing.JLabel();
        btnExitProduct = new javax.swing.JButton();
        btnSelectImg = new javax.swing.JButton();
        boxSelectCategory = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 161, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Tên Danh Mục: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Mô tả 1:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Mô tả 2:");

        btnDeleteCategory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDeleteCategory.setText("Xóa");
        btnDeleteCategory.setEnabled(false);
        btnDeleteCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCategoryActionPerformed(evt);
            }
        });

        btnUpdateCategory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdateCategory.setText("Sửa");
        btnUpdateCategory.setEnabled(false);
        btnUpdateCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCategoryActionPerformed(evt);
            }
        });

        btnFindCategory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnFindCategory.setText("Tìm Kiếm");
        btnFindCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindCategoryActionPerformed(evt);
            }
        });

        btnResetCategory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnResetCategory.setText("Reset");
        btnResetCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetCategoryActionPerformed(evt);
            }
        });

        btnInsertCategory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnInsertCategory.setText("Thêm");
        btnInsertCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertCategoryActionPerformed(evt);
            }
        });

        txtDescH4.setColumns(20);
        txtDescH4.setLineWrap(true);
        txtDescH4.setRows(5);
        txtDescH4.setWrapStyleWord(true);
        jScrollPane7.setViewportView(txtDescH4);

        txtDescH5.setColumns(20);
        txtDescH5.setLineWrap(true);
        txtDescH5.setRows(5);
        jScrollPane8.setViewportView(txtDescH5);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtNameCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(386, 386, 386)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(23, 23, 23))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(btnInsertCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnUpdateCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnDeleteCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnFindCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnResetCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNameCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        tableCategory.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tableCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên danh mục", "Mô tả 1", "Mô tả 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCategory.setRowHeight(28);
        tableCategory.setShowGrid(true);
        jScrollPane3.setViewportView(tableCategory);
        if (tableCategory.getColumnModel().getColumnCount() > 0) {
            tableCategory.getColumnModel().getColumn(0).setMinWidth(5);
            tableCategory.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableCategory.getColumnModel().getColumn(0).setMaxWidth(100);
            tableCategory.getColumnModel().getColumn(1).setMinWidth(100);
            tableCategory.getColumnModel().getColumn(1).setPreferredWidth(120);
            tableCategory.getColumnModel().getColumn(1).setMaxWidth(150);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );

        jTabbedPane1.addTab("Quản lý danh mục", jPanel3);

        jLabel4.setText("Email:");

        jLabel5.setText("Họ và tên: ");

        jLabel6.setText("Số điện thoại: ");

        jLabel7.setText("Địa chỉ: ");

        jLabel8.setText("Quyền: ");

        btnInsertUser.setText("Thêm");
        btnInsertUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertUserActionPerformed(evt);
            }
        });

        btnUpdateUser.setText("Sửa");
        btnUpdateUser.setEnabled(false);
        btnUpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateUserActionPerformed(evt);
            }
        });

        btnDeleteUser.setText("Xóa");
        btnDeleteUser.setEnabled(false);
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        tableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Họ và tên", "Email", "Số điện thoại", "Địa chỉ", "Quyền", "Ngày tạo", "Ngày update"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableUser.setRowHeight(28);
        tableUser.setShowGrid(true);
        jScrollPane4.setViewportView(tableUser);
        if (tableUser.getColumnModel().getColumnCount() > 0) {
            tableUser.getColumnModel().getColumn(0).setMinWidth(5);
            tableUser.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableUser.getColumnModel().getColumn(0).setMaxWidth(100);
            tableUser.getColumnModel().getColumn(5).setMinWidth(50);
            tableUser.getColumnModel().getColumn(5).setPreferredWidth(70);
            tableUser.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        jLabel9.setText("Mật Khẩu:");

        btnFindUser.setText("Tìm Kiếm");
        btnFindUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindUserActionPerformed(evt);
            }
        });

        btnResetUser.setText("Reset");
        btnResetUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetUserActionPerformed(evt);
            }
        });

        btnExitUser.setText("Thoát");
        btnExitUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(txtPhonenumber, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(txtFullname, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(boxRole, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword))
                        .addGap(100, 100, 100)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnInsertUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpdateUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDeleteUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnResetUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFindUser))
                        .addGap(73, 73, 73)
                        .addComponent(btnExitUser, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxRole, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 183, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPassword)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsertUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExitUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFindUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnResetUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jTabbedPane1.addTab("Quản lý người dùng", jPanel2);

        tableFeedback.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên tài khoản", "Email", "Nội Dung", "SĐT", "Ngày tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableFeedback.setRowHeight(30);
        tableFeedback.setShowGrid(true);
        jScrollPane5.setViewportView(tableFeedback);
        if (tableFeedback.getColumnModel().getColumnCount() > 0) {
            tableFeedback.getColumnModel().getColumn(0).setMinWidth(5);
            tableFeedback.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableFeedback.getColumnModel().getColumn(0).setMaxWidth(100);
            tableFeedback.getColumnModel().getColumn(1).setMinWidth(100);
            tableFeedback.getColumnModel().getColumn(1).setPreferredWidth(150);
            tableFeedback.getColumnModel().getColumn(1).setMaxWidth(200);
            tableFeedback.getColumnModel().getColumn(2).setMinWidth(150);
            tableFeedback.getColumnModel().getColumn(2).setPreferredWidth(200);
            tableFeedback.getColumnModel().getColumn(2).setMaxWidth(250);
            tableFeedback.getColumnModel().getColumn(4).setMinWidth(100);
            tableFeedback.getColumnModel().getColumn(4).setPreferredWidth(120);
            tableFeedback.getColumnModel().getColumn(4).setMaxWidth(150);
            tableFeedback.getColumnModel().getColumn(5).setMinWidth(100);
            tableFeedback.getColumnModel().getColumn(5).setPreferredWidth(160);
            tableFeedback.getColumnModel().getColumn(5).setMaxWidth(200);
        }

        btnDeleteFeedBack.setText("Xóa");
        btnDeleteFeedBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteFeedBackActionPerformed(evt);
            }
        });

        btnExitFeedback.setText("Thoát");
        btnExitFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitFeedbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDeleteFeedBack, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnExitFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(282, 282, 282))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExitFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteFeedBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(312, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý Phản hồi", jPanel6);

        tableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên đăng nhập", "Email khách hàng", "SĐT", "Địa chỉ khách hàng", "Ghi chú", "Tổng tiền ", "Ngày tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tableOrder);
        if (tableOrder.getColumnModel().getColumnCount() > 0) {
            tableOrder.getColumnModel().getColumn(0).setMinWidth(5);
            tableOrder.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableOrder.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        btnUpdateOrder.setText("Sửa");
        btnUpdateOrder.setEnabled(false);
        btnUpdateOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateOrderActionPerformed(evt);
            }
        });

        btnDeleteOrder.setText("Xóa");
        btnDeleteOrder.setEnabled(false);
        btnDeleteOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteOrderActionPerformed(evt);
            }
        });

        btnShowProductOrder.setText("Show List Order");
        btnShowProductOrder.setEnabled(false);
        btnShowProductOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowProductOrderActionPerformed(evt);
            }
        });

        btnFindOrder.setText("Tìm kiếm");
        btnFindOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindOrderActionPerformed(evt);
            }
        });

        btnResetOrder.setText("Reset");
        btnResetOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetOrderActionPerformed(evt);
            }
        });

        jLabel10.setText("Tên đăng nhập:");

        jLabel11.setText("Email khách hàng:");

        jLabel12.setText("SĐT khách hàng: ");

        jLabel13.setText("Địa chỉ khách hàng:");

        jLabel14.setText("Ghi chú:");

        txtPhoneNumberOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneNumberOrderActionPerformed(evt);
            }
        });

        btnExitOrder.setText("Thoát");
        btnExitOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitOrderActionPerformed(evt);
            }
        });

        txtNoteOrder1.setColumns(20);
        txtNoteOrder1.setLineWrap(true);
        txtNoteOrder1.setRows(5);
        txtNoteOrder.setViewportView(txtNoteOrder1);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnUpdateOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(btnDeleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(btnShowProductOrder)
                        .addGap(60, 60, 60)
                        .addComponent(btnFindOrder))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtAddressOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(txtNoteOrder))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPhoneNumberOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEmailOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(txtFullnameOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(64, 64, 64)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnResetOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(btnExitOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFullnameOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExitOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhoneNumberOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAddressOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnShowProductOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6))
                .addGap(51, 51, 51))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý đơn hàng", jPanel7);

        infoProduct.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập thông tin sản phẩm"));

        Name.setText("Tên Sản Phẩm:");

        Desc.setText("Mô Tả:");

        Price.setText("Giá:");

        Category.setText("Danh Mục Sản Phẩm:");

        btnInsertProduct.setText("Thêm");
        btnInsertProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertProductActionPerformed(evt);
            }
        });

        btnDeleteProduct.setText("Xóa");
        btnDeleteProduct.setEnabled(false);
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });

        btnResetProduct.setText("Reset");
        btnResetProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetProductActionPerformed(evt);
            }
        });

        btnFindProduct.setText("Tìm kiếm");
        btnFindProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindProductActionPerformed(evt);
            }
        });

        btnUpdateProduct.setText("Sửa");
        btnUpdateProduct.setEnabled(false);
        btnUpdateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProductActionPerformed(evt);
            }
        });

        boxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCategoryActionPerformed(evt);
            }
        });

        txtDescProduct.setColumns(20);
        txtDescProduct.setLineWrap(true);
        txtDescProduct.setRows(5);
        jScrollPane9.setViewportView(txtDescProduct);

        Desc1.setText("Hình ảnh:");

        javax.swing.GroupLayout infoProductLayout = new javax.swing.GroupLayout(infoProduct);
        infoProduct.setLayout(infoProductLayout);
        infoProductLayout.setHorizontalGroup(
            infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoProductLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoProductLayout.createSequentialGroup()
                        .addComponent(btnInsertProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(btnUpdateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnFindProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnResetProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(infoProductLayout.createSequentialGroup()
                        .addGroup(infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Category, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Desc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Desc1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85)
                        .addGroup(infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtThumbProduct)
                            .addComponent(txtPrice)
                            .addComponent(boxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(txtTitleProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        infoProductLayout.setVerticalGroup(
            infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoProductLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitleProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Category, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoProductLayout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(txtThumbProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(infoProductLayout.createSequentialGroup()
                        .addComponent(Desc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Desc1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(infoProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsertProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên Sản Phẩm", "Danh Mục sản Phẩm", "Giá", "Mô Tả", "Hình ảnh", "Ngày update", "Ngày tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableProduct.setRowHeight(28);
        tableProduct.setShowGrid(true);
        jScrollPane2.setViewportView(tableProduct);
        if (tableProduct.getColumnModel().getColumnCount() > 0) {
            tableProduct.getColumnModel().getColumn(0).setMinWidth(5);
            tableProduct.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableProduct.getColumnModel().getColumn(0).setMaxWidth(100);
            tableProduct.getColumnModel().getColumn(1).setMinWidth(100);
            tableProduct.getColumnModel().getColumn(1).setPreferredWidth(120);
            tableProduct.getColumnModel().getColumn(1).setMaxWidth(150);
            tableProduct.getColumnModel().getColumn(2).setMinWidth(100);
            tableProduct.getColumnModel().getColumn(2).setPreferredWidth(120);
            tableProduct.getColumnModel().getColumn(2).setMaxWidth(200);
            tableProduct.getColumnModel().getColumn(3).setMinWidth(50);
            tableProduct.getColumnModel().getColumn(3).setPreferredWidth(100);
            tableProduct.getColumnModel().getColumn(3).setMaxWidth(150);
        }

        txtThumbProduct1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Hình ảnh")));

        btnExitProduct.setText("Thoát");
        btnExitProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitProductActionPerformed(evt);
            }
        });

        btnSelectImg.setText("Chọn");
        btnSelectImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectImgActionPerformed(evt);
            }
        });

        boxSelectCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSelectCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(infoProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtThumbProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExitProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(54, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boxSelectCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSelectImg, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(infoProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtThumbProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnExitProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnSelectImg, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boxSelectCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý sản phẩm", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteFeedBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteFeedBackActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tableFeedback.getSelectedRow();
        if (selectedIndex >= 0 ){
            Feedback feedback = feedbackList.get(selectedIndex);

            int option = JOptionPane.showConfirmDialog(this, " Bạn có chắc chắn muốn xóa?");
            System.out.println("option: "+ option);
            if(option == 0){
                FeedBackModify.delete(feedback.getId());

                showFeedback();
            }
        }
    }//GEN-LAST:event_btnDeleteFeedBackActionPerformed

    private void btnResetUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetUserActionPerformed
        // TODO add your handling code here:
        txtFullname.setText("");
        txtEmail.setText("");
        txtPhonenumber.setText("");
        txtAddress.setText("");
        txtPassword.setText("");

        btnUpdateUser.setEnabled(false);
        btnDeleteUser.setEnabled(false);
        showUser();
    }//GEN-LAST:event_btnResetUserActionPerformed

    private void btnFindUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindUserActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(this,"Nhap ten nguoi dung can tim kiem!");
        if(input != null && input.length() > 0 ){
            users = UserModify.findByFullnameUser(input);

            tableModelUser.setRowCount(0);
            users.forEach((user) -> {
                tableModelUser.addRow(new Object[] {tableModelUser.getRowCount() + 1,
                    user.getFullname(),
                    user.getEmail(),
                    user.getPhoneNumber(),
                    user.getAddress(),
                    user.getRoleName(),
                    user.getCreated_at(),
                    user.getUpdated_at()});
        });
        } else {
            showUser();
        }
    }//GEN-LAST:event_btnFindUserActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tableUser.getSelectedRow();
        boolean check = true;
        if (selectedIndex >= 0 ){
            User user = users.get(selectedIndex);
            orderList = OrderModify.findAll();
            for (Order order : orderList) {
                if(order.getUser_id()== user.getId()) {
                    check = false;
                }
            }

            if(check) {
                int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?");
                if(option == 0){
                    UserModify.delete(user.getId());
                    JOptionPane.showMessageDialog(rootPane, "Bạn đã xóa thành công");
                }
            }
            else {
                int option = JOptionPane.showConfirmDialog(this, "Người dùng có đơn hàng !! Bạn có chắc chắn muốn xóa?");
                if(option == 0){
                    UserModify.delete(user.getId());

                    txtFullname.setText("");
                    txtEmail.setText("");
                    txtPhonenumber.setText("");
                    txtAddress.setText("");
                    txtPassword.setText("");

                    btnUpdateUser.setEnabled(false);
                    btnDeleteUser.setEnabled(false);
                    showUser();
                }
            }
        }
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void btnUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateUserActionPerformed
        // TODO add your handling code here:

        String fullname = null, email = null, phoneNumber = null, address = null, password = null, roleName = null;
        int idRole = 0;
        boolean isOK = true;
        int selectedIndex = tableUser.getSelectedRow();
        if(selectedIndex >= 0) {
            User user1 = users.get(selectedIndex);

            if(txtFullname.getText().length() > 0) {
                fullname = txtFullname.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập tên");
            }

            roleName = boxRole.getSelectedItem().toString();
            for(Role role : roleList) {
                if(role.getName().equals(roleName)) {
                    idRole = role.getId();
                }
            }

            if(txtEmail.getText().length() > 0) {
                email = txtEmail.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập Email!!");
            }

            if(txtPhonenumber.getText().length() > 0) {
                phoneNumber = txtPhonenumber.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập so dien thoai");
            }

            if(txtAddress.getText().length() > 0) {
                address = txtAddress.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập địa chỉ");
            }

            if(txtPassword.getPassword().length > 0) {
                password = new String(txtPassword.getPassword());
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập mật khẩu");
            }

            if(isOK) {
                Date dateNow = new Date();
                SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                User user = new User( user1.getId(), fullname, roleName, email, phoneNumber, address, password, formatDate.format(dateNow), idRole);

                UserModify.update(user);
                JOptionPane.showMessageDialog(rootPane, "Bạn đã cập nhật thành công!");
            }
        }

        txtFullname.setText("");
        txtEmail.setText("");
        txtPhonenumber.setText("");
        txtAddress.setText("");
        txtPassword.setText("");

        btnUpdateUser.setEnabled(false);
        btnDeleteUser.setEnabled(false);
        showUser();
    }//GEN-LAST:event_btnUpdateUserActionPerformed

    private void btnInsertUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertUserActionPerformed
        // TODO add your handling code here:
        String fullname = txtFullname.getText();
        String email = txtEmail.getText();
        String phoneNumber = txtPhonenumber.getText();
        String address = txtAddress.getText();
        String password = new String(txtPassword.getPassword());
        Date dateNow = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Role role = roleList.get(boxRole.getSelectedIndex());
        int idRole = role.getId();

        User user = new User(fullname, email, phoneNumber, address, password, formatDate.format(dateNow), formatDate.format(dateNow), idRole);

        UserModify.insert(user);

        txtFullname.setText("");
        txtEmail.setText("");
        txtPhonenumber.setText("");
        txtAddress.setText("");
        txtPassword.setText("");

        btnUpdateUser.setEnabled(false);
        btnDeleteUser.setEnabled(false);
        showUser();

    }//GEN-LAST:event_btnInsertUserActionPerformed

    private void btnFindProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindProductActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(this,"Nhap ten san pham can tim kiem!");
        if(input != null && input.length() > 0 ){
            products = ProductModify.findByTitleProduct(input);

            tableModelProduct.setRowCount(0);
            products.forEach((product) -> {
                tableModelProduct.addRow(new Object[] {tableModelProduct.getRowCount() + 1,
                    product.getTitle(),
                    product.getCategoryName(),
                    product.getPrice(),
                    product.getDescription(),
                    product.getThumbnail(),
                    product.getCreated_at(),
                    product.getUpdated_at()});
        });
        } else {
            showProduct();
        }
    }//GEN-LAST:event_btnFindProductActionPerformed

    private void btnResetProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetProductActionPerformed
        txtTitleProduct.setText("");
        txtPrice.setText("");
        txtDescProduct.setText("");
        txtThumbProduct1.setText("");

        btnUpdateProduct.setEnabled(false);
        btnDeleteProduct.setEnabled(false);
        showProduct();
    }//GEN-LAST:event_btnResetProductActionPerformed

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tableProduct.getSelectedRow();
        if (selectedIndex >= 0 ){
            Product prd = products.get(selectedIndex);

            int option = JOptionPane.showConfirmDialog(this, "Ban co chac chan muon xoa?");

            if(option == 0){
                ProductModify.delete(prd.getId());
                
                btnDeleteProduct.setEnabled(false);
                JOptionPane.showMessageDialog(rootPane, "Bạn đã xóa thành công");
                showProduct();
            }
        }
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    private void btnInsertCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertCategoryActionPerformed
        // TODO add your handling code here:
        String name = txtNameCategory.getText();
        String h4_content = txtDescH4.getText();
        String h5_content = txtDescH5.getText();

        Category category = new Category(name,h4_content,h5_content);

        CategoryModify.insert(category);

        txtNameCategory.setText("");
        txtDescH4.setText("");
        txtDescH5.setText("");

        btnUpdateCategory.setEnabled(false);
        btnDeleteCategory.setEnabled(false);

        showCategory();
    }//GEN-LAST:event_btnInsertCategoryActionPerformed

    private void btnResetCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetCategoryActionPerformed
        // TODO add your handling code here:
        txtNameCategory.setText("");
        txtDescH4.setText("");
        txtDescH5.setText("");

        btnUpdateCategory.setEnabled(false);
        btnDeleteCategory.setEnabled(false);
        showCategory();
    }//GEN-LAST:event_btnResetCategoryActionPerformed

    private void btnFindCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindCategoryActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(this,"Nhap ten danh mục can tim kiem:");
        if(input != null && input.length() > 0 ){

            categoryList = CategoryModify.findByNameCategory(input);

            tableModelCategory.setRowCount(0);

            categoryList.forEach((category) -> {
                tableModelCategory.addRow(new Object[] {tableModelCategory.getRowCount() + 1,
                    category.getName(),
                    category.getH4content(),
                    category.getH5content()});
        });
        } else {
            showCategory();
        }
    }//GEN-LAST:event_btnFindCategoryActionPerformed

    private void btnUpdateCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCategoryActionPerformed
        // TODO add your handling code here:
        String category_name = null, mota1 = null, mota2 = null;
        boolean isOK = true;
        int selectedIndex = tableCategory.getSelectedRow();

        if(selectedIndex >= 0) {
            if(txtNameCategory.getText().length() > 0) {
                category_name = txtNameCategory.getText();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập tên danh mục");
                isOK = false;
            }
            mota1 = txtDescH4.getText();
            mota2 = txtDescH5.getText();
            if(isOK) {
                Category category1 = categoryList.get(selectedIndex);
                Category category = new Category(category1.getId(), category_name, mota1, mota2);
                CategoryModify.update(category);
            }

        }

        txtNameCategory.setText("");
        txtDescH4.setText("");
        txtDescH5.setText("");

        btnUpdateCategory.setEnabled(false);
        btnDeleteCategory.setEnabled(false);

        showCategory();
        showProduct();
    }//GEN-LAST:event_btnUpdateCategoryActionPerformed

    private void btnDeleteCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCategoryActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tableCategory.getSelectedRow();
        boolean isOK = true, check = true;
        if (selectedIndex >= 0 ){
            Category category = categoryList.get(selectedIndex);
            products = ProductModify.findAll();
            for (Product product : products) {
                if(product.getIdCat() == category.getId()) {
                    check = false;
                }
            }

            if(check) {
                int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?");
                System.out.println("option: "+ option);
                if(option == 0){
                    CategoryModify.delete(category.getId());

                    btnUpdateCategory.setEnabled(false);
                    btnDeleteCategory.setEnabled(false);
                    JOptionPane.showMessageDialog(rootPane, "Bạn đã xóa thành công");
                }
            }
            else {
                int option = JOptionPane.showConfirmDialog(this, "Danh mục có chứa sản phẩm !! Bạn có chắc chắn muốn xóa?");
                System.out.println("option: "+ option);
                if(option == 0){
                    CategoryModify.delete(category.getId());

                    btnUpdateCategory.setEnabled(false);
                    btnDeleteCategory.setEnabled(false);
                    JOptionPane.showMessageDialog(rootPane, "Bạn đã xóa thành công");
                }
            }
            txtNameCategory.setText("");
            txtDescH4.setText("");
            txtDescH5.setText("");

            btnUpdateCategory.setEnabled(false);
            btnDeleteCategory.setEnabled(false);
            
            showCategory();
            showProduct();

        }
    }//GEN-LAST:event_btnDeleteCategoryActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LoginFrm login = new LoginFrm();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPhoneNumberOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneNumberOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneNumberOrderActionPerformed

    private void boxSelectCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSelectCategoryActionPerformed
        // TODO add your handling code here:
        products = ProductModify.findByCat(boxSelectCategory.getSelectedItem().toString());
        
        tableModelProduct.setRowCount(0);
        
        products.forEach((prd) -> {
            tableModelProduct.addRow(new Object[] {
                tableModelProduct.getRowCount() + 1,
                prd.getTitle(),
                prd.getCategoryName(),
                prd.getPrice(),
                prd.getDescription(),
                prd.getThumbnail()
            });
        });
        
    }//GEN-LAST:event_boxSelectCategoryActionPerformed

    private void btnShowProductOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowProductOrderActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tableOrder.getSelectedRow();
        if(selectedIndex >= 0) {
            Order order = orderList.get(selectedIndex);
            orderProductFrm = new OrderProductFrm(this, rootPaneCheckingEnabled);
            orderProductFrm.getUser_id(order);
            orderProductFrm.setVisible(true);
            showOrder();
        }
    }//GEN-LAST:event_btnShowProductOrderActionPerformed

    private void btnResetOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetOrderActionPerformed
        // TODO add your handling code here:
        txtFullnameOrder.setText("");
        txtEmailOrder.setText("");
        txtPhoneNumberOrder.setText("");
        txtAddressOrder.setText("");
        txtNoteOrder1.setText("");

        btnUpdateOrder.setEnabled(false);
        btnDeleteOrder.setEnabled(false);
        btnShowProductOrder.setEnabled(false);
        showOrder();
    }//GEN-LAST:event_btnResetOrderActionPerformed

    private void btnUpdateOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateOrderActionPerformed
        // TODO add your handling code here:
        String note = null, fullname = null, email = null, phoneNumber = null, address = null;
        boolean isOK = true;
        int selectedIndex = tableOrder.getSelectedRow();
        if(selectedIndex >= 0) {
            
            if(txtFullnameOrder.getText().length() > 0) {
                fullname = txtFullnameOrder.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập tên");
            }
            
            if(txtEmailOrder.getText().length() > 0) {
                email = txtEmailOrder.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập email");
            }
            
            if(txtPhoneNumberOrder.getText().length() > 0) {
                phoneNumber = txtPhoneNumberOrder.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập số điện thoại");
            }
            
            if(txtAddressOrder.getText().length() > 0) {
                address = txtAddressOrder.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập địa chỉ");
            }
            
            if(txtNoteOrder1.getText().length() > 0) {
                note = txtNoteOrder1.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập ghi chú");
            }

            if(isOK) {
                Order order1 = orderList.get(selectedIndex);
                Date dateNow = new Date();
                SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Order order = new Order( order1.getId(), fullname, email, phoneNumber, address, note, formatDate.format(dateNow));

                OrderModify.update(order);
                JOptionPane.showMessageDialog(rootPane, "Bạn đã cập nhật thành công!");
            }
        }

        txtFullnameOrder.setText("");
        txtEmailOrder.setText("");
        txtPhoneNumberOrder.setText("");
        txtAddressOrder.setText("");
        txtNoteOrder1.setText("");

        btnUpdateOrder.setEnabled(false);
        btnDeleteOrder.setEnabled(false);
        
        showOrder();
    }//GEN-LAST:event_btnUpdateOrderActionPerformed

    private void btnDeleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteOrderActionPerformed
        // TODO add your handling code here:
        int selectedIndex = tableOrder.getSelectedRow();
        if (selectedIndex >= 0 ){
            Order order = orderList.get(selectedIndex);

            int option = JOptionPane.showConfirmDialog(this, "Ban co chac chan muon xoa?");

            if(option == 0){
                OrderModify.delete(order.getId());

                txtFullnameOrder.setText("");
                txtEmailOrder.setText("");
                txtPhoneNumberOrder.setText("");
                txtAddressOrder.setText("");
                txtNoteOrder1.setText("");

                btnUpdateOrder.setEnabled(false);
                btnDeleteOrder.setEnabled(false);
                JOptionPane.showMessageDialog(rootPane, "Bạn đã xóa thành công");
                showOrder();
            }
        }
    }//GEN-LAST:event_btnDeleteOrderActionPerformed

    private void btnFindOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindOrderActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(this,"Nhập tên khách hàng cần tìm kiếm!");
        if(input != null && input.length() > 0 ){
            orderList = OrderModify.findByFullnameOrder(input);

            tableModelOrder.setRowCount(0);
            orderList.forEach((order) -> {
                tableModelOrder.addRow(new Object[] {tableModelOrder.getRowCount() + 1,
                    order.getUserfullname(),
                    order.getFullname(),
                    order.getEmail(),
                    order.getPhoneNumber(),
                    order.getAddress(),
                    order.getNote(),
                    order.getTotalMoney(),
                    order.getCreateTime()});
        });
        } else {
            showOrder();
        }
    }//GEN-LAST:event_btnFindOrderActionPerformed

    private void btnExitProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitProductActionPerformed
        // TODO add your handling code here:
        LoginFrm login = new LoginFrm();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitProductActionPerformed

    private void btnExitUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitUserActionPerformed
        // TODO add your handling code here:
        LoginFrm login = new LoginFrm();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitUserActionPerformed

    private void btnExitFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitFeedbackActionPerformed
        // TODO add your handling code here:
        LoginFrm login = new LoginFrm();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitFeedbackActionPerformed

    private void btnExitOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitOrderActionPerformed
        // TODO add your handling code here:
        LoginFrm login = new LoginFrm();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitOrderActionPerformed

    private void btnUpdateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProductActionPerformed
        // TODO add your handling code here:

        String tenSP = null, danhmuc = null, gia = null, mota = null, hinhanh = null;
        int id_Cat = 0;
        boolean isOK = true;
        int selectedIndex = tableProduct.getSelectedRow();
        if(selectedIndex >= 0) {
            Product prd1 = products.get(selectedIndex);

            if(txtTitleProduct.getText().length() > 0) {
                tenSP = txtTitleProduct.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập tên sản phẩm");
            }

            danhmuc = boxCategory.getSelectedItem().toString();
            for(Category category : categoryList) {
                if(category.getName().equals(danhmuc)) {
                    id_Cat = category.getId();
                }
            }

            if(txtPrice.getText().length() > 0) {
                gia = txtPrice.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập giá sản phẩm");
            }

            if(txtDescProduct.getText().length() > 0) {
                mota = txtDescProduct.getText();
            } else {
                isOK = false;
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập mô tả sản phẩm");
            }

//            if(txtThumbProduct.getText().length() > 0) {
//                hinhanh = txtThumbProduct.getText();
//            } else {
//                isOK = false;
//                JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập hình ảnh sản phẩm");
//            }

            if(isOK) {
                Date dateNow = new Date();
                SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Product product = new Product(prd1.getId(), tenSP, danhmuc, gia, mota, hinhanh,formatDate.format(dateNow), id_Cat);
                ProductModify.update(product);
                JOptionPane.showMessageDialog(rootPane, "Bạn đã cập nhật thành công!");
            }
        }

        txtTitleProduct.setText("");
        txtPrice.setText("");
        txtDescProduct.setText("");
        txtThumbProduct1.setText("");

        btnUpdateProduct.setEnabled(false);
        btnDeleteProduct.setEnabled(false);
        showProduct();
    }//GEN-LAST:event_btnUpdateProductActionPerformed

    private void btnInsertProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertProductActionPerformed
        // TODO add your handling code here:
        String title = txtTitleProduct.getText();
        Category category = categoryList.get(boxCategory.getSelectedIndex());
        int idCat = category.getId();
        String price = txtPrice.getText();
        String description = txtDescProduct.getText();
        String thumbnail = txtThumbProduct1.getText();
        Date dateNow = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
        Product prd = new Product(title,price,description,thumbnail, formatDate.format(dateNow), formatDate.format(dateNow),idCat);

        ProductModify.insert(prd);

        txtTitleProduct.setText("");
        txtPrice.setText("");
        txtDescProduct.setText("");
        txtThumbProduct1.setText("");

        btnUpdateProduct.setEnabled(false);
        btnDeleteProduct.setEnabled(false);
        showProduct();
    }//GEN-LAST:event_btnInsertProductActionPerformed

    private void boxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxCategoryActionPerformed

    private void btnSelectImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectImgActionPerformed
        // TODO add your handling code here:
//        JFileChooser chooser = new JFileChooser(); 
//        chooser.setFileFilter(new FileFilter() {
//        @Override
//        public boolean accept(File f) {
//        if (f.isDirectory()){  
//            return true ;
//        } else{ 
//            return f.getName().toLowerCase().endsWith(".jpg");
//        }
//       }
//       @Override
//       public String getDescription() {
//          return "Image File (*.jpg)" ;
//       }
//   }); 
//   if(chooser.showOpenDialog(parentForm) == JFileChooser.CANCEL_OPTION){ 
//       return ;
//   } 
//   File file  = chooser.getSelectedFile(); 
//        try { 
//            ImageIcon icon  = new ImageIcon(file.getPath()); 
//            Image img = ImageHinh.resize(icon.getImage(), 140, 160); 
//            ImageIcon  resize = new ImageIcon(img); 
//            txtThumbProduct.setIcon(resize); 
//            personImage = ImageHinh.toByteArray(img, "jpg");
//            
//            
//        } catch (Exception e) { 
//            e.printStackTrace(); 
//        }
    }//GEN-LAST:event_btnSelectImgActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(AppManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AppManager().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Category;
    private javax.swing.JLabel Desc;
    private javax.swing.JLabel Desc1;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Price;
    private javax.swing.JComboBox<String> boxCategory;
    private javax.swing.JComboBox<String> boxRole;
    private javax.swing.JComboBox<String> boxSelectCategory;
    private javax.swing.JButton btnDeleteCategory;
    private javax.swing.JButton btnDeleteFeedBack;
    private javax.swing.JButton btnDeleteOrder;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnExitFeedback;
    private javax.swing.JButton btnExitOrder;
    private javax.swing.JButton btnExitProduct;
    private javax.swing.JButton btnExitUser;
    private javax.swing.JButton btnFindCategory;
    private javax.swing.JButton btnFindOrder;
    private javax.swing.JButton btnFindProduct;
    private javax.swing.JButton btnFindUser;
    private javax.swing.JButton btnInsertCategory;
    private javax.swing.JButton btnInsertProduct;
    private javax.swing.JButton btnInsertUser;
    private javax.swing.JButton btnResetCategory;
    private javax.swing.JButton btnResetOrder;
    private javax.swing.JButton btnResetProduct;
    private javax.swing.JButton btnResetUser;
    private javax.swing.JButton btnSelectImg;
    private javax.swing.JButton btnShowProductOrder;
    private javax.swing.JButton btnUpdateCategory;
    private javax.swing.JButton btnUpdateOrder;
    private javax.swing.JButton btnUpdateProduct;
    private javax.swing.JButton btnUpdateUser;
    private javax.swing.JPanel infoProduct;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tableCategory;
    private javax.swing.JTable tableFeedback;
    private javax.swing.JTable tableOrder;
    private javax.swing.JTable tableProduct;
    private javax.swing.JTable tableUser;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAddressOrder;
    private javax.swing.JTextArea txtDescH4;
    private javax.swing.JTextArea txtDescH5;
    private javax.swing.JTextArea txtDescProduct;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmailOrder;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtFullnameOrder;
    private javax.swing.JTextField txtNameCategory;
    private javax.swing.JScrollPane txtNoteOrder;
    private javax.swing.JTextArea txtNoteOrder1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhoneNumberOrder;
    private javax.swing.JTextField txtPhonenumber;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtThumbProduct;
    private javax.swing.JLabel txtThumbProduct1;
    private javax.swing.JTextField txtTitleProduct;
    // End of variables declaration//GEN-END:variables

    private static class CountryCellRenderer {

        public CountryCellRenderer() {
        }
    }

}
