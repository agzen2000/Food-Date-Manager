package food.date.manager;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Akash
 */
public class OpenFrame extends javax.swing.JFrame {

    /**
     * Creates new form OpenFrame2
     */
    MyJFrame frame;
    InventoryDBManager db;
    String[] item;
    public OpenFrame(String[] item, MyJFrame frame) {
        try {
            this.frame = frame;
            this.item = item;
            db = InventoryDBManager.getInstance();
            initComponents();
            int freshness = db.getFreshness(item[0]);
            Date expired = addDays(freshness);
            monthField.setText(new SimpleDateFormat("MM").format(expired));
            yearField.setText(new SimpleDateFormat("yyyy").format(expired));
            dayField.setText(new SimpleDateFormat("dd").format(expired));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
    
    public Date addDays(int days) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, days);
        return c.getTime();
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
        expirationLabel = new javax.swing.JLabel();
        monthField = new javax.swing.JTextField();
        dayField = new javax.swing.JTextField();
        yearField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        openButton = new javax.swing.JButton();
        openLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        expirationLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        expirationLabel.setText("Expiration (mm/dd/yy):");

        monthField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        dayField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        yearField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("/");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("/");

        openButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        openButton.setText("Open");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });

        openLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        openLabel.setText("Open");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(openLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(openButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(expirationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(monthField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dayField, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(openLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expirationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthField)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dayField)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(openButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
        Scanner scan = new Scanner(yearField.getText());
        int year;
        if(scan.hasNextInt()) {
            year = scan.nextInt();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a valid date");
            return;
        }
        scan = new Scanner(monthField.getText());
        int month;
        if(scan.hasNextInt()) {
            month = scan.nextInt();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a valid date");
            return;
        }
        scan = new Scanner(dayField.getText());
        int day;
        if(scan.hasNextInt()) {
            day = scan.nextInt();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a valid date");
            return;
        }
        Date date;
        try{
            date = new SimpleDateFormat("dd-MM-yyyy").parse(day+"-"+month+"-"+year);
            if(Calendar.getInstance().getTime().compareTo(date)>0) {
                JOptionPane.showMessageDialog(this, "Product has already expired. Please dispose it");
                throw new Exception();
            }
           
            db.openPacket(item[0], item[2], month+"-"+day+"-"+year);
            frame.inventoryPanel.updateTable();
            frame.expiredPanel.updateTable();
            item[2] = new SimpleDateFormat("MM-dd-yyyy").format(date);
            item[3] = "true";
            FoodMap.getInstance().addItem(item);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid date");
            Logger.getLogger(OpenFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(OpenFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_openButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dayField;
    private javax.swing.JLabel expirationLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField monthField;
    private javax.swing.JButton openButton;
    private javax.swing.JLabel openLabel;
    private javax.swing.JTextField yearField;
    // End of variables declaration//GEN-END:variables
}