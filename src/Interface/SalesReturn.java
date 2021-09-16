package Interface;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class SalesReturn extends javax.swing.JInternalFrame {
    /**
     * Creates new form AddItems
     */
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDate ldt = LocalDate.now();
    String date=dtf.format(ldt);
    
    PreparedStatement pst = null;
    ResultSet rs = null;
    Connection con;
    
    Double totalAmt=0.0,subTotal;
    
    //For data from per_item_sales table
    String quantity,unitprice,discount,oldqty;
    
    //For data from sales_return table
    String billno,itemId,nQuantity;
    
    //For data from total_sales table;
    String totalAmount,cash,balance,ndate;
    
    public SalesReturn() {
        initComponents();
        con = DBConnect.connect();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
    }
    
    private void tableLoad(){ 
        try
        {
            String sql="SELECT `bill_no` as 'Bill no.', `item_id` as 'Item Id', `unit_price` as 'Unit Price',"
                    + " `quantity` as 'Quantity', `amount` as 'Sub Total', `discount` as 'Discount', `total_amt` as 'Total'"
                    + " FROM `per_item_sales`"+"WHERE bill_no='"+txtBillno.getText()+"'";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            jTable1.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e){
        }
        try{
            String sqli="SELECT `total_amt`, `cash`, `balance`, `date` FROM `total_sales` WHERE bill_no='"+txtBillno.getText()+"'";
            pst=con.prepareStatement(sqli);
            rs=pst.executeQuery();
            while(rs.next()){
            totalAmount=rs.getString("total_amt");
            cash=rs.getString("cash");
            balance=rs.getString("balance");
            date=rs.getString("date");
        }
        }
        catch(SQLException ex){
            
        }
        label1.setText("GrandTotal :"+totalAmount);
        label2.setText("Cash :"+cash);
        label3.setText("Due :"+balance);
    } 
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtItemId = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        doneBtn = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        returnButton = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        clearButton = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtBillno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtRemarks = new java.awt.TextField();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();

        setPreferredSize(new java.awt.Dimension(890, 510));

        jPanel1.setBackground(new java.awt.Color(206, 152, 235));
        jPanel1.setPreferredSize(new java.awt.Dimension(890, 510));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(478, 450));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ItemID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Quantity");

        txtItemId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtItemIdKeyReleased(evt);
            }
        });

        doneBtn.setBackground(new java.awt.Color(136, 176, 207));
        doneBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doneBtnMouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Done");

        javax.swing.GroupLayout doneBtnLayout = new javax.swing.GroupLayout(doneBtn);
        doneBtn.setLayout(doneBtnLayout);
        doneBtnLayout.setHorizontalGroup(
            doneBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doneBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        doneBtnLayout.setVerticalGroup(
            doneBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doneBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        returnButton.setBackground(new java.awt.Color(136, 176, 207));
        returnButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnButtonMouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Return");

        javax.swing.GroupLayout returnButtonLayout = new javax.swing.GroupLayout(returnButton);
        returnButton.setLayout(returnButtonLayout);
        returnButtonLayout.setHorizontalGroup(
            returnButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(returnButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        returnButtonLayout.setVerticalGroup(
            returnButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(returnButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        clearButton.setBackground(new java.awt.Color(136, 176, 207));
        clearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearButtonMouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Clear");

        javax.swing.GroupLayout clearButtonLayout = new javax.swing.GroupLayout(clearButton);
        clearButton.setLayout(clearButtonLayout);
        clearButtonLayout.setHorizontalGroup(
            clearButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clearButtonLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        clearButtonLayout.setVerticalGroup(
            clearButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clearButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtBillno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBillnoKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Bill no.");

        jLabel4.setBackground(new java.awt.Color(204, 255, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Note: Item should not be damaged or defective. Item should be returned within 15 days.");
        jLabel4.setOpaque(true);
        jLabel4.setPreferredSize(new java.awt.Dimension(506, 14));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Bill no.", "Item Id", "Unit Price", "Quantity", "Sub Total", "Discount", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        txtRemarks.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtRemarks.setForeground(new java.awt.Color(204, 204, 204));
        txtRemarks.setText("Remarks");
        txtRemarks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtRemarksMousePressed(evt);
            }
        });
        txtRemarks.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRemarksFocusGained(evt);
            }
        });
        txtRemarks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRemarksKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRemarksKeyReleased(evt);
            }
        });

        label1.setText("GrandTotal :");

        label2.setText("Cash :");

        label3.setText("Due:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtItemId, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(46, 46, 46)
                                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(txtBillno, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                        .addComponent(txtRemarks, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(doneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtBillno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtItemId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtRemarks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(doneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void returnButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnButtonMouseClicked
        billno=txtBillno.getText();
        itemId=txtItemId.getText();
        nQuantity=txtQuantity.getText();
        //calculation of individual item sales return amount
        if(txtQuantity.getText().equals(quantity))
        {
            double p= Double.parseDouble(txtQuantity.getText())*Double.parseDouble(unitprice);
            subTotal=p-Double.parseDouble(discount);    
        }
        else{
            subTotal= Integer.parseInt(txtQuantity.getText())*Double.parseDouble(unitprice);
        }
        //calculation of total item sales return amount
        totalAmt=totalAmt+subTotal;
        updateQuantity(nQuantity);
        try{
           String qr="INSERT INTO `sales_return`(`bill_no`, `item_id`, `quantity`, `sub_total`, `total_amt`) VALUES ('"+billno+"','"+itemId+"','"+nQuantity+"','"+subTotal+"','"+totalAmt+"')";
           pst=con.prepareStatement(qr);
           pst.execute();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane,e);
        } 
    }//GEN-LAST:event_returnButtonMouseClicked
    
    private void clear() {
        txtItemId.setText("");
        txtQuantity.setText("");
    }
    
    private void clearData() {
        txtBillno.setText("");
        txtItemId.setText("");
        txtQuantity.setText("");
        txtRemarks.setText("");
    }
    private void doneBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneBtnMouseClicked
        jLabel4.setText("Sales Return amount is:"+Double.toString(totalAmt));
        totalAmt=0.0;
        clearData();
    }//GEN-LAST:event_doneBtnMouseClicked
    
    private void updateQuantity(String qty){
        try{
            String sql="SELECT `quantity` FROM `stock` WHERE item_id='"+txtItemId.getText()+"'";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        while(rs.next()){
            oldqty=rs.getString("quantity");
        }
        int newqty=Integer.parseInt(oldqty)+Integer.parseInt(qty);
        String remarks=txtRemarks.getText();
        String sqli="UPDATE `stock` SET `quantity`='"+newqty+"', `remarks`='"+remarks+"' where item_id='"+txtItemId.getText()+"'";
        pst=con.prepareStatement(sqli);
        pst.executeUpdate();
        }catch(SQLException se){
            se.getMessage();
        }
    }
    
    
    private void clearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseClicked
        clear();
    }//GEN-LAST:event_clearButtonMouseClicked

    private void txtBillnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBillnoKeyReleased
        tableLoad();
    }//GEN-LAST:event_txtBillnoKeyReleased

    private void txtItemIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtItemIdKeyReleased
        try{
            String sql="SELECT `unit_price`, `quantity`, `discount` FROM `per_item_sales` WHERE item_id='"+txtItemId.getText()+"' && bill_no='"+txtBillno.getText()+"'";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        while(rs.next()){
            unitprice=rs.getString("unit_price");
            discount=rs.getString("discount");
            quantity=rs.getString("quantity");
        }
        }
        catch(SQLException se){
            se.getMessage();
        } 
    }//GEN-LAST:event_txtItemIdKeyReleased

    private void txtRemarksKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRemarksKeyPressed
        if(txtRemarks.getForeground()!=Color.BLACK){
            if(txtRemarks.getText().equals("Remarks")){
                txtRemarks.setText("");
            }
        }
        txtRemarks.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtRemarksKeyPressed

    private void txtRemarksFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRemarksFocusGained
        txtRemarks.setCaretPosition(0);
    }//GEN-LAST:event_txtRemarksFocusGained

    private void txtRemarksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRemarksKeyReleased
        if(txtRemarks.getText().isEmpty()==true){
            txtRemarks.setText("Remarks");
            txtRemarks.setCaretPosition(0);
            txtRemarks.setForeground(new java.awt.Color(204,204,204));
        }
    }//GEN-LAST:event_txtRemarksKeyReleased

    private void txtRemarksMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRemarksMousePressed
        txtRemarks.setCaretPosition(0);
    }//GEN-LAST:event_txtRemarksMousePressed
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel clearButton;
    private javax.swing.JPanel doneBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JPanel returnButton;
    private javax.swing.JTextField txtBillno;
    private javax.swing.JTextField txtItemId;
    private javax.swing.JTextField txtQuantity;
    private java.awt.TextField txtRemarks;
    // End of variables declaration//GEN-END:variables
}
