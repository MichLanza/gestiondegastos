/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gastos;

import Datos.CategoriaXml;
import Datos.MovimientosXml;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import clases.*;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Michele
 */
public class Consulta extends javax.swing.JFrame {
MovimientosXml datosmov = new MovimientosXml();
  CategoriaXml datoscat = new CategoriaXml();
    /**
     * Creates new form Consulta
     */
    public Consulta() {
        initComponents();
            this.setLocationRelativeTo(null);
        this.setResizable(false); 
        comboMov.removeAllItems();
        comboMov.addItem( "Seleccionar Movimiento"); 
       comboMov.addItem("Todo");         
       comboMov.addItem("Gasto");       
       comboMov.addItem("Ingreso");
       totallabel.setVisible(false);
       jLabel3.setVisible(false);
       real.setVisible(false);
        jLabel4.setVisible(false);
      
    }
private void llenartabla(MovimientosXml datosMov,String mes, String tipo){
 String[] columna = {"Mes", "Tipo", "Plan","Real", "Descripción" , "Categoría" };
 DefaultTableModel dtm = new DefaultTableModel(null,columna);  
 JTextField meh = new JTextField ();
Tabla.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(meh));

ArrayList<Movimientos> Lista= datosMov.todoslosMovimientos();
            for (Movimientos veh : Lista)
            {
               if  (( (veh.getMes().equals(mes) )&&( veh.getTipo().equals(tipo)))   ){
                String[] row = {veh.getMes(), veh.getTipo(),Float.toString(veh.getCantidad()),Float.toString(veh.getReal()),veh.getDescrpicion(),veh.getCategoria()};
                dtm.addRow(row);}
               }
            
            Tabla.setModel(dtm);  
}

private void llenartabla(MovimientosXml datosMov,String mes){
 String[] columna = {"Mes", "Tipo", "Plan","Real","Descripción" , "Categoría" };
 DefaultTableModel dtm = new DefaultTableModel(null,columna);       
  JTextField meh = new JTextField ();
Tabla.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(meh));
 ArrayList<Movimientos> Lista= datosMov.todoslosMovimientos();
            for (Movimientos veh : Lista)
            {
               if  (( (veh.getMes().equals(mes) ))   ){
                String[] row = {veh.getMes(), veh.getTipo(),Float.toString(veh.getCantidad()),Float.toString(veh.getReal()),veh.getDescrpicion(),veh.getCategoria()};
                dtm.addRow(row);}
               }
            
            Tabla.setModel(dtm);  
}
private float total(MovimientosXml datosMov,String mes, String tipo)
{
float total= 0;
ArrayList<Movimientos> Lista= datosMov.todoslosMovimientos();
            for (Movimientos veh : Lista)
            {
              if  (( (veh.getMes().equals(mes) )&&( veh.getTipo().equals(tipo)))   )
                 total = veh.getCantidad()+ total;
                
            }
       return total;     

}
private float totalR(MovimientosXml datosMov,String mes, String tipo)//total real por tipo 
{
float total= 0;
ArrayList<Movimientos> Lista= datosMov.todoslosMovimientos();
            for (Movimientos veh : Lista)
            {
              if  (( (veh.getMes().equals(mes) )&&( veh.getTipo().equals(tipo)))   )
                 total = veh.getReal()+ total;
                
            }
       return total;     

}
private float totalR (MovimientosXml datosMov,String mes)//total real 
{
float total= 0, totaltotal=0, total1=0;

ArrayList<Movimientos> Lista= datosMov.todoslosMovimientos();
            for (Movimientos veh : Lista)
            {
              if  ( (veh.getMes().equals(mes) ) && (veh.getTipo().equals("Gasto"))   )
                 total = veh.getReal()+ total;
               if  ( (veh.getMes().equals(mes) ) && (veh.getTipo().equals("Ingreso"))   )
                 total1 = veh.getReal()+ total1;
                        
            }
            totaltotal= total1-total;
       return totaltotal;    
}
private float total(MovimientosXml datosMov,String mes)
{
float total= 0, totaltotal=0, total1=0;

ArrayList<Movimientos> Lista= datosMov.todoslosMovimientos();
            for (Movimientos veh : Lista)
            {
              if  ( (veh.getMes().equals(mes) ) && (veh.getTipo().equals("Gasto"))   )
                 total = veh.getCantidad()+ total;
               if  ( (veh.getMes().equals(mes) ) && (veh.getTipo().equals("Ingreso"))   )
                 total1 = veh.getCantidad()+ total1;
                        
            }
            totaltotal= total1-total;
       return totaltotal;     

}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        comboMov = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboMes = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        totallabel = new javax.swing.JLabel();
        Actualizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        real = new javax.swing.JLabel();

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "null", "null", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabla);
        if (Tabla.getColumnModel().getColumnCount() > 0) {
            Tabla.getColumnModel().getColumn(0).setHeaderValue("null");
            Tabla.getColumnModel().getColumn(1).setHeaderValue("null");
            Tabla.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            Tabla.getColumnModel().getColumn(3).setHeaderValue("Title 4");
            Tabla.getColumnModel().getColumn(4).setHeaderValue("Title 5");
            Tabla.getColumnModel().getColumn(5).setHeaderValue("Title 6");
        }

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        comboMov.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboMov.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboMovItemStateChanged(evt);
            }
        });

        jLabel1.setText("Movimiento:");

        jLabel2.setText("Mes:");

        comboMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        comboMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboMesItemStateChanged(evt);
            }
        });

        jButton3.setText("Atrás");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Total plan:");

        totallabel.setText("jLabel4");

        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });
        Actualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ActualizarKeyPressed(evt);
            }
        });

        jLabel4.setText("Total real:");

        real.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboMov, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(Actualizar)))
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totallabel)
                .addGap(64, 64, 64)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(real)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Actualizar))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(totallabel)
                    .addComponent(jLabel4)
                    .addComponent(real))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
ventana1 th = new ventana1();
th.setVisible(true);
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void comboMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboMesItemStateChanged
try{
        if (evt.getStateChange()== ItemEvent.SELECTED)
          llenartabla(datosmov,comboMes.getSelectedItem().toString(),comboMov.getSelectedItem().toString());
         if (  !(comboMov.getSelectedItem().toString().equals("Todo") ) &&  !(comboMov.getSelectedItem().toString().equals("Seleccionar Movimiento") )  )
           totallabel.setText(Float.toString(total(datosmov,comboMes.getSelectedItem().toString(),comboMov.getSelectedItem().toString())));
     else   
        totallabel.setText(Float.toString(total(datosmov,comboMes.getSelectedItem().toString())));
        totallabel.setVisible(true);
        jLabel3.setVisible(true);
         real.setText(Float.toString(totalR(datosmov,comboMes.getSelectedItem().toString())));
       real.setVisible(true);
        jLabel4.setVisible(true);
        
        if (evt.getStateChange()== ItemEvent.SELECTED)
            if(comboMov.getSelectedItem().toString().equals("Seleccionar Movimiento"))
                llenartabla(datosmov,comboMes.getSelectedItem().toString());
        if (evt.getStateChange()== ItemEvent.SELECTED)
            if(comboMov.getSelectedItem().toString().equals("Todo"))
                llenartabla(datosmov,comboMes.getSelectedItem().toString());
          if (evt.getStateChange()== ItemEvent.SELECTED)
        if(comboMes.getSelectedItem().toString().equals("Seleccionar Mes"))
                {
                        Tabla.setModel(null);
                } 
}
catch (Exception e){
         JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
         
      }

// TODO add your handling code here:
    }//GEN-LAST:event_comboMesItemStateChanged

    private void comboMovItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboMovItemStateChanged
try{
        if (evt.getStateChange()== ItemEvent.SELECTED){
         if (  !(comboMov.getSelectedItem().toString().equals("Todo") ) &&  !(comboMov.getSelectedItem().toString().equals("Seleccionar Movimiento") )  )
                  llenartabla(datosmov,comboMes.getSelectedItem().toString(),comboMov.getSelectedItem().toString());
             totallabel.setText(Float.toString(total(datosmov,comboMes.getSelectedItem().toString(),comboMov.getSelectedItem().toString())));
 totallabel.setText(Float.toString(total(datosmov,comboMes.getSelectedItem().toString())));
        totallabel.setVisible(true);
       jLabel3.setVisible(true);
            real.setText(Float.toString(totalR(datosmov,comboMes.getSelectedItem().toString())));
       real.setVisible(true);
        jLabel4.setVisible(true);
        }
    
          if (evt.getStateChange()== ItemEvent.SELECTED)
              if (evt.getStateChange()== ItemEvent.SELECTED)
            if(comboMov.getSelectedItem().toString().equals("Seleccionar Movimiento"))
                llenartabla(datosmov,comboMes.getSelectedItem().toString());
        if (evt.getStateChange()== ItemEvent.SELECTED)
            if(comboMov.getSelectedItem().toString().equals("Todo"))
                llenartabla(datosmov,comboMes.getSelectedItem().toString());
        if(comboMes.getSelectedItem().toString().equals("Seleccionar Movimiento"))
                {
                        Tabla.setModel(null);
                } 
}
catch (Exception e){
         JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
         
      }        // TODO add your handling code here:
    }//GEN-LAST:event_comboMovItemStateChanged

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
actualizarTabla();
llenartabla(datosmov,comboMes.getSelectedItem().toString());
  totallabel.setText(Float.toString(total(datosmov,comboMes.getSelectedItem().toString())));
         totallabel.setVisible(true);
       jLabel3.setVisible(true);
       real.setText(Float.toString(totalR(datosmov,comboMes.getSelectedItem().toString())));
       real.setVisible(true);
        jLabel4.setVisible(true);
    }//GEN-LAST:event_ActualizarActionPerformed

    private void ActualizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ActualizarKeyPressed
 
    }//GEN-LAST:event_ActualizarKeyPressed
//"Mes", "Tipo", "Plan","Real","Descripción" , "Categoría" 
    
    public  void actualizarTabla() {
int selec = Tabla.getSelectedRow();
int selec2 = Tabla.getSelectedColumn();
float coso;
String cosa = Tabla.getValueAt(selec, selec2).toString();
coso=Float.parseFloat(cosa);
String mes = Tabla.getValueAt(selec, 0).toString();
String tipo = Tabla.getValueAt(selec, 1).toString();
String plan = Tabla.getValueAt(selec, 2).toString();
String reale = Tabla.getValueAt(selec, 3).toString();
String descripcion = Tabla.getValueAt(selec, 4).toString();
String categoria = Tabla.getValueAt(selec, 5).toString();
Movimientos mov = new Movimientos(tipo, Float.parseFloat(plan),descripcion,categoria,mes, Float.parseFloat(reale));
//salvarMov(datosmov,  tipo, Float.parseFloat(plan), Float.parseFloat(reale), descripcion,  mes, categoria);
datosmov.borrarMov(  tipo, Float.parseFloat(plan), Float.parseFloat(reale), descripcion,  mes, categoria);
datosmov.agregarMovimiento(mov);

}
//    public void salvarMov(MovimientosXml datos, String tipo, float plan, float real,String descripcion, String mes,String categoria){
//     Movimientos mov = datosmov.buscarMov( mes, Float.toString(plan),Float.toString(real), descripcion, categoria, tipo);
//                mov.setTipo(tipo);
//                mov.setCantidad(plan);
//                mov.setMes(mes);
//                mov.setReal(real);
//                mov.setCategoria(categoria);
//                mov.setDescrpicion(descripcion);
//               
//               datosmov.actualizarMovimiento(mov);}
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
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JTable Tabla;
    private javax.swing.JComboBox comboMes;
    private javax.swing.JComboBox comboMov;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel real;
    private javax.swing.JLabel totallabel;
    // End of variables declaration//GEN-END:variables
}
