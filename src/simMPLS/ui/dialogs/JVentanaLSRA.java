/* 
 * Copyright (C) Manuel Domínguez Dorado - ingeniero@ManoloDominguez.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package simMPLS.ui.dialogs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import simMPLS.scenario.TActiveLSRNode;
import simMPLS.scenario.TTopology;
import simMPLS.ui.simulator.JPanelDisenio;
import simMPLS.ui.utils.TImagesBroker;

/**
 * Esta clase implementa una ventana que permite configurar un nodo LSR.
 * @author <B>Manuel Dom�nguez Dorado</B><br><A
 * href="mailto:ingeniero@ManoloDominguez.com">ingeniero@ManoloDominguez.com</A><br><A href="http://www.ManoloDominguez.com" target="_blank">http://www.ManoloDominguez.com</A>
 * @version 1.0
 */
public class JVentanaLSRA extends javax.swing.JDialog {

    /**
     * Crea una nueva instancia de JVentanaLSR
     * @param t Topolog�a dentro de la cual se encuentra el nodo LSR que queremos configurar.
     * @param pad Panel de dise�o donde estamos dise�ando el LSR que queremos configurar.
     * @param di Dispensador de im�genes global del a aplicaci�n.
     * @param parent Ventana padre dentro de la cual se ubicar� esta ventana de tipo JVentanaLSR.
     * @param modal TRUE indica que esta ventana impedira que se pueda seleccionar cualquier otra
     * zona de la interfaz hasta que se haya cerrado. FALSE significa que esto no es
     * as�.
     * @since 2.0
     */
    public JVentanaLSRA(TTopology t, JPanelDisenio pad, TImagesBroker di, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        ventanaPadre = parent;
        dispensadorDeImagenes = di;
        pd = pad;
        topo = t;
        initComponents();
        initComponents2();
    }

    /**
     * Este m�todo configura aspectos de la calse que no han podido ser configurados
     * por el constructor.
     * @since 2.0
     */    
    public void initComponents2() {
        panelCoordenadas.ponerPanelOrigen(pd);
        java.awt.Dimension tamFrame=this.getSize();
        java.awt.Dimension tamPadre=ventanaPadre.getSize();
        setLocation((tamPadre.width-tamFrame.width)/2, (tamPadre.height-tamFrame.height)/2);
        configLSRA = null;
        coordenadaX.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaEmisor.X=_") + panelCoordenadas.obtenerXReal());
        coordenadaY.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaEmisor.Y=_") + panelCoordenadas.obtenerYReal());
        BKUPMostrarNombre = true;
        BKUPNombre = "";
        BKUPPotencia = 0;
        BKUPTamBuffer = 0;
        BKUPGenerarEstadisticas = false;
        reconfigurando = false;
        this.selectorSencilloCaracteristicas.removeAllItems();
        this.selectorSencilloCaracteristicas.addItem(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaLSRA.Personalized_LSRA"));
        this.selectorSencilloCaracteristicas.addItem(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaLSRA.Very_low_range_LSRA"));
        this.selectorSencilloCaracteristicas.addItem(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaLSRA.Low_range_LSRA"));
        this.selectorSencilloCaracteristicas.addItem(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaLSRA.Medium_range_LSRA"));
        this.selectorSencilloCaracteristicas.addItem(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaLSRA.High_range_LSRA"));
        this.selectorSencilloCaracteristicas.addItem(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaLSRA.Very_high_range_LSRA"));
        this.selectorSencilloCaracteristicas.setSelectedIndex(0);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        panelPrincipal = new javax.swing.JPanel();
        panelPestanias = new javax.swing.JTabbedPane();
        panelGeneral = new javax.swing.JPanel();
        iconoReceptor = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        nombreNodo = new javax.swing.JTextField();
        panelPosicion = new javax.swing.JPanel();
        coordenadaX = new javax.swing.JLabel();
        coordenadaY = new javax.swing.JLabel();
        panelCoordenadas = new simMPLS.ui.dialogs.JPanelCoordenadas();
        verNombre = new javax.swing.JCheckBox();
        panelRapido = new javax.swing.JPanel();
        iconoEnlace1 = new javax.swing.JLabel();
        selectorDeGenerarEstadisticasSencillo = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        selectorSencilloCaracteristicas = new javax.swing.JComboBox();
        panelAvanzado = new javax.swing.JPanel();
        iconoEnlace2 = new javax.swing.JLabel();
        selectorDeGenerarEstadisticasAvanzado = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        selectorDePotenciaDeConmutacion = new javax.swing.JSlider();
        selectorDeTamanioBuffer = new javax.swing.JSlider();
        etiquetaPotencia = new javax.swing.JLabel();
        etiquetaMemoriaBuffer = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        selectorDeTamanioDMGP = new javax.swing.JSlider();
        etiquetaMemoriaDMGP = new javax.swing.JLabel();
        panelBotones = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setTitle(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSRA.titulo"));
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPestanias.setFont(new java.awt.Font("Dialog", 0, 12));
        panelGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconoReceptor.setIcon(dispensadorDeImagenes.obtenerIcono(TImagesBroker.LSRA));
        iconoReceptor.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSRA.descripcion"));
        panelGeneral.add(iconoReceptor, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, 335, -1));

        etiquetaNombre.setFont(new java.awt.Font("Dialog", 0, 12));
        etiquetaNombre.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSRA.etiquetaNombre"));
        panelGeneral.add(etiquetaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 80, 120, -1));

        panelGeneral.add(nombreNodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 105, 125, -1));

        panelPosicion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPosicion.setBorder(new javax.swing.border.TitledBorder(null, java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSR.titulogrupo"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12)));
        coordenadaX.setFont(new java.awt.Font("Dialog", 0, 12));
        coordenadaX.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSR.X="));
        panelPosicion.add(coordenadaX, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        coordenadaY.setFont(new java.awt.Font("Dialog", 0, 12));
        coordenadaY.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSR.Y="));
        panelPosicion.add(coordenadaY, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        panelCoordenadas.setBackground(new java.awt.Color(255, 255, 255));
        panelCoordenadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clicEnPanelCoordenadas(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ratonEntraEnPanelCoordenadas(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ratonSaleDePanelCoordenadas(evt);
            }
        });

        panelPosicion.add(panelCoordenadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 25, 130, 70));

        panelGeneral.add(panelPosicion, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 75, 180, 125));

        verNombre.setFont(new java.awt.Font("Dialog", 0, 12));
        verNombre.setSelected(true);
        verNombre.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSR.verNombre"));
        panelGeneral.add(verNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 135, -1, -1));

        panelPestanias.addTab(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSR.tabs.General"), panelGeneral);

        panelRapido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconoEnlace1.setIcon(dispensadorDeImagenes.obtenerIcono(TImagesBroker.ASISTENTE));
        iconoEnlace1.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSRA.ConfiguracionSencilla"));
        panelRapido.add(iconoEnlace1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, 335, -1));

        selectorDeGenerarEstadisticasSencillo.setFont(new java.awt.Font("Dialog", 0, 12));
        selectorDeGenerarEstadisticasSencillo.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSRA.GenerarEstadisticas"));
        selectorDeGenerarEstadisticasSencillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicEnSelectorDeGenerarEstadisticasSencillo(evt);
            }
        });

        panelRapido.add(selectorDeGenerarEstadisticasSencillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSRA.Caracteristicas"));
        panelRapido.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 160, -1));

        selectorSencilloCaracteristicas.setFont(new java.awt.Font("Dialog", 0, 12));
        selectorSencilloCaracteristicas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Personalized", "Very low cost LSR", "Low cost LSR", "Medium cost LSR", "Expensive LSR", "Very expensive LSR" }));
        selectorSencilloCaracteristicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicEnSelectorSencilloCaracteristicas(evt);
            }
        });

        panelRapido.add(selectorSencilloCaracteristicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, -1));

        panelPestanias.addTab(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSR.tabs.Fast"), panelRapido);

        panelAvanzado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconoEnlace2.setIcon(dispensadorDeImagenes.obtenerIcono(TImagesBroker.AVANZADA));
        iconoEnlace2.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSRA.ConfiguracionAvanzada"));
        panelAvanzado.add(iconoEnlace2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, 335, -1));

        selectorDeGenerarEstadisticasAvanzado.setFont(new java.awt.Font("Dialog", 0, 12));
        selectorDeGenerarEstadisticasAvanzado.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSRA.GenerarEstadisticas"));
        selectorDeGenerarEstadisticasAvanzado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicEnSelectorDeGenerarEstadisticasAvanzado(evt);
            }
        });

        panelAvanzado.add(selectorDeGenerarEstadisticasAvanzado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSR.PotenciaConmutacion"));
        panelAvanzado.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSR.TamanioBufferEntrada"));
        panelAvanzado.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 180, -1));

        selectorDePotenciaDeConmutacion.setMajorTickSpacing(1000);
        selectorDePotenciaDeConmutacion.setMaximum(10240);
        selectorDePotenciaDeConmutacion.setMinimum(1);
        selectorDePotenciaDeConmutacion.setMinorTickSpacing(100);
        selectorDePotenciaDeConmutacion.setValue(1);
        selectorDePotenciaDeConmutacion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selectorDePotenciaDeConmutacionCambiado(evt);
            }
        });

        panelAvanzado.add(selectorDePotenciaDeConmutacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 90, 130, 20));

        selectorDeTamanioBuffer.setMajorTickSpacing(50);
        selectorDeTamanioBuffer.setMaximum(1024);
        selectorDeTamanioBuffer.setMinimum(1);
        selectorDeTamanioBuffer.setMinorTickSpacing(100);
        selectorDeTamanioBuffer.setValue(1);
        selectorDeTamanioBuffer.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selectorDeTamanioBufferCambiado(evt);
            }
        });

        panelAvanzado.add(selectorDeTamanioBuffer, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 100, 20));

        etiquetaPotencia.setFont(new java.awt.Font("Dialog", 0, 10));
        etiquetaPotencia.setForeground(new java.awt.Color(102, 102, 102));
        etiquetaPotencia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etiquetaPotencia.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSR.1_Mbps"));
        panelAvanzado.add(etiquetaPotencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 70, 20));

        etiquetaMemoriaBuffer.setFont(new java.awt.Font("Dialog", 0, 10));
        etiquetaMemoriaBuffer.setForeground(new java.awt.Color(102, 102, 102));
        etiquetaMemoriaBuffer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etiquetaMemoriaBuffer.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSR.1_MB"));
        panelAvanzado.add(etiquetaMemoriaBuffer, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 60, 20));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaLSRA.DMGP_size"));
        panelAvanzado.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 160, -1));

        selectorDeTamanioDMGP.setMajorTickSpacing(50);
        selectorDeTamanioDMGP.setMaximum(102400);
        selectorDeTamanioDMGP.setMinimum(1);
        selectorDeTamanioDMGP.setMinorTickSpacing(100);
        selectorDeTamanioDMGP.setValue(1);
        selectorDeTamanioDMGP.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                selectorDeTamanioDMGPCambiado(evt);
            }
        });

        panelAvanzado.add(selectorDeTamanioDMGP, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 120, 20));

        etiquetaMemoriaDMGP.setFont(new java.awt.Font("Dialog", 0, 10));
        etiquetaMemoriaDMGP.setForeground(new java.awt.Color(102, 102, 102));
        etiquetaMemoriaDMGP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        etiquetaMemoriaDMGP.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaLSRA.1_KB"));
        panelAvanzado.add(etiquetaMemoriaDMGP, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 60, 20));

        panelPestanias.addTab(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSR.tabs.Advanced"), panelAvanzado);

        panelPrincipal.add(panelPestanias, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 370, 240));

        panelBotones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setFont(new java.awt.Font("Dialog", 0, 12));
        jButton2.setIcon(dispensadorDeImagenes.obtenerIcono(TImagesBroker.ACEPTAR));
        jButton2.setMnemonic(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSR.botones.mne.Aceptar").charAt(0));
        jButton2.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSR.boton.Ok"));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicEnAceptar(evt);
            }
        });

        panelBotones.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 105, -1));

        jButton3.setFont(new java.awt.Font("Dialog", 0, 12));
        jButton3.setIcon(dispensadorDeImagenes.obtenerIcono(TImagesBroker.CANCELAR));
        jButton3.setMnemonic(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSR.botones.mne.Cancelar").charAt(0));
        jButton3.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSR.boton.Cancel"));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicEnCancelar(evt);
            }
        });

        panelBotones.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 105, -1));

        panelPrincipal.add(panelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 400, 60));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 310));

        pack();
    }//GEN-END:initComponents

    private void selectorDeTamanioDMGPCambiado(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_selectorDeTamanioDMGPCambiado
        this.etiquetaMemoriaDMGP.setText(""+this.selectorDeTamanioDMGP.getValue()+" "+java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("JVentanaLSRA._MB."));
    }//GEN-LAST:event_selectorDeTamanioDMGPCambiado

    private void clicEnSelectorSencilloCaracteristicas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clicEnSelectorSencilloCaracteristicas
        int opcionSeleccionada = this.selectorSencilloCaracteristicas.getSelectedIndex();
        if (opcionSeleccionada == 0) {
        } else if (opcionSeleccionada == 0) {
            this.selectorSencilloCaracteristicas.setSelectedIndex(0);
        } else if (opcionSeleccionada == 1) {
            this.selectorDePotenciaDeConmutacion.setValue(1);
            this.selectorDeTamanioBuffer.setValue(1);
            this.selectorDeTamanioDMGP.setValue(1);
            this.selectorSencilloCaracteristicas.setSelectedIndex(1);
        } else if (opcionSeleccionada == 2) {
            this.selectorDePotenciaDeConmutacion.setValue(2560);
            this.selectorDeTamanioBuffer.setValue(256);
            this.selectorDeTamanioDMGP.setValue(2);
            this.selectorSencilloCaracteristicas.setSelectedIndex(2);
        } else if (opcionSeleccionada == 3) {
            this.selectorDePotenciaDeConmutacion.setValue(5120);
            this.selectorDeTamanioBuffer.setValue(512);
            this.selectorDeTamanioDMGP.setValue(3);
            this.selectorSencilloCaracteristicas.setSelectedIndex(3);
        } else if (opcionSeleccionada == 4) {
            this.selectorDePotenciaDeConmutacion.setValue(7680);
            this.selectorDeTamanioDMGP.setValue(4);
            this.selectorDeTamanioBuffer.setValue(768);
            this.selectorSencilloCaracteristicas.setSelectedIndex(4);
        } else if (opcionSeleccionada == 5) {
            this.selectorDePotenciaDeConmutacion.setValue(10240);
            this.selectorDeTamanioBuffer.setValue(1024);
            this.selectorDeTamanioDMGP.setValue(5);
            this.selectorSencilloCaracteristicas.setSelectedIndex(5);
        }
    }//GEN-LAST:event_clicEnSelectorSencilloCaracteristicas

    private void selectorDeTamanioBufferCambiado(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_selectorDeTamanioBufferCambiado
        this.selectorSencilloCaracteristicas.setSelectedIndex(0);
        this.etiquetaMemoriaBuffer.setText(this.selectorDeTamanioBuffer.getValue() + " " + java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSR.MB"));
    }//GEN-LAST:event_selectorDeTamanioBufferCambiado

    private void selectorDePotenciaDeConmutacionCambiado(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_selectorDePotenciaDeConmutacionCambiado
        this.selectorSencilloCaracteristicas.setSelectedIndex(0);
        this.etiquetaPotencia.setText(this.selectorDePotenciaDeConmutacion.getValue() + " " + java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaLSR.Mbps"));
    }//GEN-LAST:event_selectorDePotenciaDeConmutacionCambiado

    private void clicEnSelectorDeGenerarEstadisticasSencillo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clicEnSelectorDeGenerarEstadisticasSencillo
        this.selectorDeGenerarEstadisticasAvanzado.setSelected(this.selectorDeGenerarEstadisticasSencillo.isSelected());
    }//GEN-LAST:event_clicEnSelectorDeGenerarEstadisticasSencillo

    private void clicEnSelectorDeGenerarEstadisticasAvanzado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clicEnSelectorDeGenerarEstadisticasAvanzado
        this.selectorDeGenerarEstadisticasSencillo.setSelected(this.selectorDeGenerarEstadisticasAvanzado.isSelected());
    }//GEN-LAST:event_clicEnSelectorDeGenerarEstadisticasAvanzado

private void clicEnCancelar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clicEnCancelar
    if (reconfigurando) {
        configLSRA.setShowName(BKUPMostrarNombre);
        configLSRA.setName(BKUPNombre);
        configLSRA.setWellConfigured(true);
        configLSRA.setBufferSizeInMBytes(BKUPTamBuffer);
        configLSRA.setGenerateStats(BKUPGenerarEstadisticas);
        configLSRA.setSwitchingPowerInMbps(BKUPPotencia);
        configLSRA.setDMGPSizeInKB(BKUPTamanioDMGP);
        reconfigurando = false;
    } else {
        configLSRA.setWellConfigured(false);
    }
    this.setVisible(false);
    this.dispose();
}//GEN-LAST:event_clicEnCancelar

private void clicEnAceptar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clicEnAceptar
    configLSRA.setWellConfigured(true);
    if (!this.reconfigurando){
        configLSRA.setPosition(new Point(panelCoordenadas.obtenerXReal(),panelCoordenadas.obtenerYReal()));
    }
    configLSRA.setDMGPSizeInKB(this.selectorDeTamanioDMGP.getValue());
    configLSRA.setBufferSizeInMBytes(this.selectorDeTamanioBuffer.getValue());
    configLSRA.setSwitchingPowerInMbps(this.selectorDePotenciaDeConmutacion.getValue());
    configLSRA.setName(nombreNodo.getText());
    configLSRA.setGenerateStats(this.selectorDeGenerarEstadisticasSencillo.isSelected());
    configLSRA.setShowName(verNombre.isSelected());
    int error = configLSRA.validateConfig(topo, this.reconfigurando);
    if (error != TActiveLSRNode.OK) {
        JVentanaAdvertencia va = new JVentanaAdvertencia(ventanaPadre, true, dispensadorDeImagenes);
        va.mostrarMensaje(configLSRA.getErrorMessage(error));
        va.show();
    } else {
        this.setVisible(false);
        this.dispose();
    }
}//GEN-LAST:event_clicEnAceptar

private void clicEnPanelCoordenadas(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clicEnPanelCoordenadas
    if (evt.getButton() == MouseEvent.BUTTON1) {
        panelCoordenadas.ponerCoordenadasReducidas(evt.getPoint());
        coordenadaX.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaEmisor.X=_") + panelCoordenadas.obtenerXReal());
        coordenadaY.setText(java.util.ResourceBundle.getBundle("simMPLS/lenguajes/lenguajes").getString("VentanaEmisor.Y=_") + panelCoordenadas.obtenerYReal());
        panelCoordenadas.repaint();
    }
}//GEN-LAST:event_clicEnPanelCoordenadas

private void ratonSaleDePanelCoordenadas(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ratonSaleDePanelCoordenadas
    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
}//GEN-LAST:event_ratonSaleDePanelCoordenadas

private void ratonEntraEnPanelCoordenadas(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ratonEntraEnPanelCoordenadas
    this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
}//GEN-LAST:event_ratonEntraEnPanelCoordenadas

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        configLSRA.setWellConfigured(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    /**
     * Este m�todo permite cargar en la ventana la configuraci�n actual del nodo LSR.
     * @since 2.0
     * @param tnlsra Nodo LSR que queremos configurar.
     * @param recfg TRUE indica que vamos a reconfigurar el nodo LSR. FALSE indica que el nodo LSR
     * est� siendo insertado nuevo en la topolog�a.
     */    
    public void ponerConfiguracion(TActiveLSRNode tnlsra, boolean recfg) {
        configLSRA = tnlsra;
        reconfigurando = recfg;
        if (reconfigurando) {
            this.panelCoordenadas.setEnabled(false);
            this.panelCoordenadas.setToolTipText(null);

            BKUPGenerarEstadisticas = tnlsra.isGeneratingStats();
            BKUPMostrarNombre = tnlsra.getShowName();
            BKUPNombre = tnlsra.getName();
            BKUPPotencia = tnlsra.getSwitchingPowerInMbps();
            BKUPTamBuffer = tnlsra.getBufferSizeInMBytes();
            BKUPTamanioDMGP = tnlsra.getDMGPSizeInKB();

            this.selectorDeTamanioDMGP.setValue(this.BKUPTamanioDMGP);
            this.selectorDeGenerarEstadisticasAvanzado.setSelected(BKUPGenerarEstadisticas);
            this.selectorDeGenerarEstadisticasSencillo.setSelected(BKUPGenerarEstadisticas);
            this.selectorDePotenciaDeConmutacion.setValue(BKUPPotencia);
            this.selectorDeTamanioBuffer.setValue(BKUPTamBuffer);
            this.nombreNodo.setText(BKUPNombre);
            this.verNombre.setSelected(BKUPMostrarNombre);
        }
    }

    private TImagesBroker dispensadorDeImagenes;
    private Frame ventanaPadre;
    private JPanelDisenio pd;
    private TActiveLSRNode configLSRA;
    private TTopology topo;
    
    private boolean BKUPMostrarNombre;
    private String BKUPNombre;
    private int BKUPPotencia;
    private int BKUPTamBuffer;
    private boolean BKUPGenerarEstadisticas;
    private int BKUPTamanioDMGP;

    private boolean reconfigurando;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel coordenadaX;
    private javax.swing.JLabel coordenadaY;
    private javax.swing.JLabel etiquetaMemoriaBuffer;
    private javax.swing.JLabel etiquetaMemoriaDMGP;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaPotencia;
    private javax.swing.JLabel iconoEnlace1;
    private javax.swing.JLabel iconoEnlace2;
    private javax.swing.JLabel iconoReceptor;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nombreNodo;
    private javax.swing.JPanel panelAvanzado;
    private javax.swing.JPanel panelBotones;
    private simMPLS.ui.dialogs.JPanelCoordenadas panelCoordenadas;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JTabbedPane panelPestanias;
    private javax.swing.JPanel panelPosicion;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelRapido;
    private javax.swing.JCheckBox selectorDeGenerarEstadisticasAvanzado;
    private javax.swing.JCheckBox selectorDeGenerarEstadisticasSencillo;
    private javax.swing.JSlider selectorDePotenciaDeConmutacion;
    private javax.swing.JSlider selectorDeTamanioBuffer;
    private javax.swing.JSlider selectorDeTamanioDMGP;
    private javax.swing.JComboBox selectorSencilloCaracteristicas;
    private javax.swing.JCheckBox verNombre;
    // End of variables declaration//GEN-END:variables

}
