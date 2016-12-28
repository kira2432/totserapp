/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totserapp.view;

import com.totserapp.TotSeries;
import com.totserapp.model.Episodi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;

public class EpisodeView extends View{
    private Timer timer = null; 
    private int selected;
    
     public EpisodeView(Episodi episodi) {
        initComponents();
        setTitle(episodi.getTitle());
        txt_descripcio.setText(episodi.getDescription());
        
        final long start = Calendar.getInstance().getTimeInMillis();
        
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long now = Calendar.getInstance().getTimeInMillis();
                int seconds = (int) (now - start) / 1000;
                txt_seconds.setText("00:00:0" + seconds + "/00:00:05");
                int val = progress_episodi.getValue();
                if (val >= 100) {
                    timer.stop();
                    EpisodeView.this.dispose(); 
                    // TODO: añadir uno a visualizacion
                    TotSeries.getInstance().showView(new ValoracioView(getTitle(), selected));
                    return;
                }
                progress_episodi.setValue(++val);
            }
        });
        timer.start(); 
    }
     
    private EpisodeView() {
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

        progress_episodi = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descripcio = new javax.swing.JTextArea();
        txt_seconds = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Visualitzant episodi...");

        txt_descripcio.setEditable(false);
        txt_descripcio.setColumns(20);
        txt_descripcio.setLineWrap(true);
        txt_descripcio.setRows(5);
        txt_descripcio.setWrapStyleWord(true);
        txt_descripcio.setBorder(null);
        jScrollPane1.setViewportView(txt_descripcio);

        txt_seconds.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_seconds.setText("00:00:00/00:00:05");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(progress_episodi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 120, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(txt_seconds, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(progress_episodi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_seconds)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JProgressBar progress_episodi;
    private javax.swing.JTextArea txt_descripcio;
    private javax.swing.JLabel txt_seconds;
    // End of variables declaration//GEN-END:variables
}
