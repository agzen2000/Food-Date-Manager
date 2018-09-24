package food.date.manager;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Akash
 */
public class Expired extends javax.swing.JPanel {
    MyJFrame instance;
    String[][] expiredItems;
    InventoryDBManager DBInstance;
    DefaultTableModel tableModel;
    Color sidePaneDefault = new Color(51,153,255);
    Color sidePaneSelected = new Color(0,0,255);
    /**
     * Creates new form Expired
     */
    public Expired(MyJFrame instance) {
        initComponents();
        DBInstance = InventoryDBManager.getInstance();
        this.instance = instance;
        try {
            expiredItems = DBInstance.getExpired();
            tableModel = new DefaultTableModel(expiredItems, 
                    new String[] {"Item Number", "Name", "Sell By", "Opened"}) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
            expiredTable.setModel(tableModel);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
        public void updateTable() {
        try {
            tableModel = new DefaultTableModel(DBInstance.getExpired(), 
                    new String[] {"Item Number", "Name", "Sell By", "Opened"}) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
            expiredTable.setModel(tableModel);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidePane = new javax.swing.JPanel();
        homeTab = new javax.swing.JPanel();
        homeLabel = new javax.swing.JLabel();
        inventoryTab = new javax.swing.JPanel();
        inventoryLabel = new javax.swing.JLabel();
        expiredTab = new javax.swing.JPanel();
        expiredLabel = new javax.swing.JLabel();
        expiredItemsLabel = new javax.swing.JLabel();
        throwOutLabel = new javax.swing.JLabel();
        expiredScroll = new javax.swing.JScrollPane();
        expiredTable = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        sidePane.setBackground(new java.awt.Color(51, 102, 255));

        homeTab.setBackground(new java.awt.Color(51, 153, 255));
        homeTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeTabClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeTabMouseExited(evt);
            }
        });

        homeLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        homeLabel.setForeground(new java.awt.Color(255, 255, 255));
        homeLabel.setText("HOME");

        javax.swing.GroupLayout homeTabLayout = new javax.swing.GroupLayout(homeTab);
        homeTab.setLayout(homeTabLayout);
        homeTabLayout.setHorizontalGroup(
            homeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap())
        );
        homeTabLayout.setVerticalGroup(
            homeTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        inventoryTab.setBackground(new java.awt.Color(51, 153, 255));
        inventoryTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventoryTabClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inventoryTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inventoryTabMouseExited(evt);
            }
        });

        inventoryLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        inventoryLabel.setForeground(new java.awt.Color(255, 255, 255));
        inventoryLabel.setText("INVENTORY");

        javax.swing.GroupLayout inventoryTabLayout = new javax.swing.GroupLayout(inventoryTab);
        inventoryTab.setLayout(inventoryTabLayout);
        inventoryTabLayout.setHorizontalGroup(
            inventoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inventoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        inventoryTabLayout.setVerticalGroup(
            inventoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inventoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        expiredTab.setBackground(new java.awt.Color(51, 153, 255));
        expiredTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expiredTabClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                expiredTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                expiredTabMouseExited(evt);
            }
        });

        expiredLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        expiredLabel.setForeground(new java.awt.Color(255, 255, 255));
        expiredLabel.setText("EXPIRED ITEMS");

        javax.swing.GroupLayout expiredTabLayout = new javax.swing.GroupLayout(expiredTab);
        expiredTab.setLayout(expiredTabLayout);
        expiredTabLayout.setHorizontalGroup(
            expiredTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(expiredTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(expiredLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        expiredTabLayout.setVerticalGroup(
            expiredTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(expiredTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(expiredLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout sidePaneLayout = new javax.swing.GroupLayout(sidePane);
        sidePane.setLayout(sidePaneLayout);
        sidePaneLayout.setHorizontalGroup(
            sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homeTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(inventoryTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(expiredTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sidePaneLayout.setVerticalGroup(
            sidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePaneLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(homeTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inventoryTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(expiredTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(309, Short.MAX_VALUE))
        );

        expiredItemsLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        expiredItemsLabel.setText("Expired Items");

        throwOutLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        throwOutLabel.setText("Please throw out the following items:");

        expiredTable.setModel(new javax.swing.table.DefaultTableModel(
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
        expiredScroll.setViewportView(expiredTable);

        deleteButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteButton.setText("Delete Items");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(expiredScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(throwOutLabel)
                                    .addComponent(expiredItemsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteButton)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(expiredItemsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(throwOutLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(expiredScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void homeTabClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeTabClicked
        instance.setFrame("home");
    }//GEN-LAST:event_homeTabClicked

    private void inventoryTabClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryTabClicked
        instance.setFrame("inventory");
    }//GEN-LAST:event_inventoryTabClicked

    private void expiredTabClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expiredTabClicked
        instance.setFrame("expired");
    }//GEN-LAST:event_expiredTabClicked

    private void expiredTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expiredTabMouseEntered
        expiredTab.setBackground(sidePaneSelected);
    }//GEN-LAST:event_expiredTabMouseEntered

    private void expiredTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expiredTabMouseExited
        expiredTab.setBackground(sidePaneDefault);
    }//GEN-LAST:event_expiredTabMouseExited

    private void homeTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeTabMouseEntered
        homeTab.setBackground(sidePaneSelected);
    }//GEN-LAST:event_homeTabMouseEntered

    private void homeTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeTabMouseExited
        homeTab.setBackground(sidePaneDefault);
    }//GEN-LAST:event_homeTabMouseExited

    private void inventoryTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryTabMouseEntered
        inventoryTab.setBackground(sidePaneSelected);
    }//GEN-LAST:event_inventoryTabMouseEntered

    private void inventoryTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryTabMouseExited
        inventoryTab.setBackground(sidePaneDefault);
    }//GEN-LAST:event_inventoryTabMouseExited

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if(expiredItems.length!=0) {
            if(JOptionPane.showConfirmDialog(instance, "Are you sure you want to delete items?", "Delete Item", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                for(String[] item: expiredItems) {
                    DBInstance.deleteItem(item);
                }
                for(int i = 0; i <= tableModel.getRowCount() ; i++) {
                    tableModel.removeRow(i);
                }
                instance.inventoryPanel.updateTable();
            }
        }
        
    }//GEN-LAST:event_deleteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel expiredItemsLabel;
    private javax.swing.JLabel expiredLabel;
    private javax.swing.JScrollPane expiredScroll;
    private javax.swing.JPanel expiredTab;
    private javax.swing.JTable expiredTable;
    private javax.swing.JLabel homeLabel;
    private javax.swing.JPanel homeTab;
    private javax.swing.JLabel inventoryLabel;
    private javax.swing.JPanel inventoryTab;
    private javax.swing.JPanel sidePane;
    private javax.swing.JLabel throwOutLabel;
    // End of variables declaration//GEN-END:variables
}
