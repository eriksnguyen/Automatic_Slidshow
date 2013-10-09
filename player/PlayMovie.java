package player;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author Erik
 */
public class PlayMovie extends javax.swing.JFrame {

	private final JFileChooser directorySelector;
	private File directory = null;
	
	/**
	 * Creates new form PlayMovie
	 */
	public PlayMovie() {
		initComponents();
		directorySelector = new JFileChooser();
		directorySelector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		directorySelector.setAcceptAllFileFilterUsed(false);//Disable select all option.
		setCenterLocation();
	}
	
	/*
	 * Centers the frame in the screen
	 */
	private void setCenterLocation(){
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width - getWidth()) / 2 , (d.height - getHeight()) / 2);
	}

	@SuppressWarnings("unchecked")
    private void initComponents() {

        Label_directory = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TextField_directory = new javax.swing.JTextField();
        Button_Browse = new javax.swing.JButton();
        Panel_images = new ImagePanel();
        Button_Rewind = new javax.swing.JButton();
        Button_Play = new javax.swing.JButton();
        Button_Forward = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        Button_Beginning = new javax.swing.JButton();
        Button_End = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

		TextField_directory.setEnabled(false);
		
        Label_directory.setLabelFor(TextField_directory);
        Label_directory.setText("Directory: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Movie");

        Button_Browse.setText("Browse...");
        Button_Browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_BrowseActionPerformed(evt);
            }
        });

        Panel_images.setPreferredSize(new java.awt.Dimension(384, 362));

        javax.swing.GroupLayout Panel_imagesLayout = new javax.swing.GroupLayout(Panel_images);
        Panel_images.setLayout(Panel_imagesLayout);
        Panel_imagesLayout.setHorizontalGroup(
            Panel_imagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );
        Panel_imagesLayout.setVerticalGroup(
            Panel_imagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );

        Button_Rewind.setText("<");
		Button_Rewind.setActionCommand("rewind");
        Button_Rewind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_RewindActionPerformed(evt);
            }
        });

		Button_Play.setActionCommand("play");
        Button_Play.setText("|>");
        Button_Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_PlayActionPerformed(evt);
            }
        });

        Button_Forward.setText(">");
        Button_Forward.setActionCommand("forward");
		Button_Forward.setEnabled(false);
        Button_Forward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ForwardActionPerformed(evt);
            }
        });

		jSlider1.setValue(100);
        jSlider1.setMaximum(200);
		jSlider1.setMinorTickSpacing(10);
		jSlider1.setMajorTickSpacing(50);
		jSlider1.setPaintTicks(true);
		jSlider1.addChangeListener(new javax.swing.event.ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent ce) {
				StateChangedActionPerformed(ce);
			}
			
		});

        Button_Beginning.setText("|<<");
		Button_Beginning.setActionCommand("first");
        Button_Beginning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_BeginningActionPerformed(evt);
            }
        });

        Button_End.setText(">>|");
		Button_End.setActionCommand("last");
        Button_End.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_EndActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(Button_Beginning)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_Rewind, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_Play, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_Forward, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_End)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(Panel_images, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Label_directory)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextField_directory, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Button_Browse)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_directory)
                    .addComponent(TextField_directory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_Browse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_images, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_Rewind)
                    .addComponent(Button_Play)
                    .addComponent(Button_Forward)
                    .addComponent(Button_Beginning)
                    .addComponent(Button_End))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void Button_BrowseActionPerformed(java.awt.event.ActionEvent evt) {
        directorySelector.setCurrentDirectory(directory);
		int selectionValue = directorySelector.showOpenDialog(this);
		do{
			if(selectionValue == 1)
				System.exit(0);
			else if(selectionValue == JFileChooser.APPROVE_OPTION){
				directory = directorySelector.getSelectedFile();
				TextField_directory.setText(directory.toString());
				Panel_images.setDirectory(directory);
			}
			if(Panel_images.numFiles() == 0){
				JOptionPane.showMessageDialog(this, "Directory selected does not contain valid .png images");
				selectionValue = directorySelector.showOpenDialog(this);
			} else {
				break;
			}
		} while(true);
		
    }

    private void Button_PlayActionPerformed(java.awt.event.ActionEvent evt) {
        if(evt.getActionCommand().equals("pause")){
			Button_Play.setText("|>");
			Button_Play.setActionCommand("play");
		} else {
			Button_Play.setText("||");
			Button_Play.setActionCommand("pause");
		}
		Panel_images.actionPerformed(evt);
    }

    private void Button_ForwardActionPerformed(java.awt.event.ActionEvent evt) {
        Button_Forward.setEnabled(false);
		Button_Rewind.setEnabled(true);
		Panel_images.actionPerformed(evt);
    }
	
    private void Button_RewindActionPerformed(java.awt.event.ActionEvent evt) {
        Button_Forward.setEnabled(true);
		Button_Rewind.setEnabled(false);
		Panel_images.actionPerformed(evt);
    }

    private void Button_EndActionPerformed(java.awt.event.ActionEvent evt) {
        Panel_images.actionPerformed(evt);
    }

    private void Button_BeginningActionPerformed(java.awt.event.ActionEvent evt) {
       Panel_images.actionPerformed(evt);
    }

	private void StateChangedActionPerformed(ChangeEvent ce) {
		JSlider source = (JSlider) ce.getSource();
		if(!source.getValueIsAdjusting()){
			Panel_images.changeMultiplier(source.getValue()/200.);
		}
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(PlayMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(PlayMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(PlayMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(PlayMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		

		/* Create and display the form *
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PlayMovie().setVisible(true);
			}
		});
		*/
		PlayMovie movie = new PlayMovie();
		movie.setVisible(true);
		movie.Button_Browse.doClick();
		movie.Button_Browse.setEnabled(false);
		//Set it on pause.
		movie.Button_Play.doClick();
		movie.Button_Play.doClick();
		movie.Panel_images.play();
	}
   
    private javax.swing.JButton Button_Beginning;
    private javax.swing.JButton Button_Browse;
    private javax.swing.JButton Button_End;
    private javax.swing.JButton Button_Forward;
    private javax.swing.JButton Button_Play;
    private javax.swing.JButton Button_Rewind;
    private javax.swing.JLabel Label_directory;
    private ImagePanel Panel_images;
    private javax.swing.JTextField TextField_directory;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSlider jSlider1;
}
