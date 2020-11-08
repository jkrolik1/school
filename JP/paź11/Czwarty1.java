package paź11;


public class Czwarty1 extends java.applet.Applet {

    public void init() {
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new java.awt.Button();
        textField2 = new java.awt.TextField();
        textField3 = new java.awt.TextField();
        textField1 = new java.awt.TextField();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();

        setLayout(null);

        button1.setActionCommand("button1");
        button1.setLabel("/");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        add(button1);
        button1.setBounds(170, 50, 40, 30);
        add(textField2);
        textField2.setBounds(130, 20, 80, 30);
        add(textField3);
        textField3.setBounds(50, 80, 160, 40);

        textField1.setName("kuba1"); // NOI18N
        textField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField1ActionPerformed(evt);
            }
        });
        add(textField1);
        textField1.setBounds(50, 20, 80, 30);

        button2.setLabel("+");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        add(button2);
        button2.setBounds(50, 50, 40, 30);

        button3.setLabel("-");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        add(button3);
        button3.setBounds(90, 50, 40, 30);

        button4.setLabel("x");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        add(button4);
        button4.setBounds(130, 50, 40, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        
        String sx, sy, sz=" ";
        int x, y, z;

        sx = textField1.getText();
        sy = textField2.getText();

        try {
            x = Integer.parseInt(sx);
            y = Integer.parseInt(sy);

            z = x / y;

            sz = Integer.toString(z);

            textField3.setText(sz);

        } catch (Exception e) {
            textField3.setText("Przerwa na kawę");
        }
        
    }//GEN-LAST:event_button1ActionPerformed

    private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        String sx, sy, sz=" ";
        int x, y, z;

        sx = textField1.getText();
        sy = textField2.getText();

        try {
            x = Integer.parseInt(sx);
            y = Integer.parseInt(sy);

            z = x + y;

            sz = Integer.toString(z);

            textField3.setText(sz);

        } catch (Exception e) {
            textField3.setText("Przerwa na kawę");
        }
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        String sx, sy, sz = " ";
        int x, y, z;

        sx = textField1.getText();
        sy = textField2.getText();

        try {
            x = Integer.parseInt(sx);
            y = Integer.parseInt(sy);

            z = x - y;

            sz = Integer.toString(z);

            textField3.setText(sz);

        } catch (Exception e) {
            textField3.setText("Przerwa na kawę");
        }// TODO add your handling code here:
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        String sx, sy, sz = " ";
        int x, y, z;

        sx = textField1.getText();
        sy = textField2.getText();

        try {
            x = Integer.parseInt(sx);
            y = Integer.parseInt(sy);

            z = x * y;

            sz = Integer.toString(z);

            textField3.setText(sz);

        } catch (Exception e) {
            textField3.setText("Przerwa na kawę");
        }// TODO add your handling code here:
    }//GEN-LAST:event_button4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private java.awt.TextField textField1;
    private java.awt.TextField textField2;
    private java.awt.TextField textField3;
    // End of variables declaration//GEN-END:variables
}
