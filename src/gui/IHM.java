/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Sarah LOTFI
 */
public class IHM extends javax.swing.JFrame {

    /**
     * Creates new form IHM
     */
    public IHM() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        espaceAdmin1 = new gui.EspaceAdmin();
        espaceAdmin2 = new gui.EspaceAdmin();
        espaceAdmin3 = new gui.EspaceAdmin();
        espaceAdmin4 = new gui.EspaceAdmin();
        espaceAdmin5 = new gui.EspaceAdmin();
        espaceChef2 = new gui.EspaceChef();
        espaceChef1 = new gui.EspaceChef();
        espaceChef4 = new gui.EspaceChef();
        espaceChef3 = new gui.EspaceChef();
        espaceChef5 = new gui.EspaceChef();
        espaceChef6 = new gui.EspaceChef();
        authentify2 = new gui.Authentify();
        authentify3 = new gui.Authentify();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(authentify3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(authentify3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.Authentify authentify2;
    private gui.Authentify authentify3;
    private gui.EspaceAdmin espaceAdmin1;
    private gui.EspaceAdmin espaceAdmin2;
    private gui.EspaceAdmin espaceAdmin3;
    private gui.EspaceAdmin espaceAdmin4;
    private gui.EspaceAdmin espaceAdmin5;
    private gui.EspaceChef espaceChef1;
    private gui.EspaceChef espaceChef2;
    private gui.EspaceChef espaceChef3;
    private gui.EspaceChef espaceChef4;
    private gui.EspaceChef espaceChef5;
    private gui.EspaceChef espaceChef6;
    // End of variables declaration//GEN-END:variables
}
