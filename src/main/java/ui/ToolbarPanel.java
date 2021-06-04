package main.java.ui;


import main.java.App;
import javax.swing.*;
import java.awt.* ;

public class ToolbarPanel extends JPanel{
    private static JButton buttonHome ;
    private static JButton buttonClasses ;
    private static JButton buttonSettings ;

    public ToolbarPanel(){
        initialize() ;
        addButton() ;
        addListener() ;
    }

    private void initialize(){
        Dimension preferredSize = new Dimension( UiConsts.TOOLBAR_BUTTON_WIDTH , UiConsts.MAIN_WINDOW_HEIGHT ) ;
        this.setPreferredSize( preferredSize ) ;
        this.setMaximumSize( preferredSize ) ;
        this.setMinimumSize( preferredSize ) ;
        this.setLayout( new GridLayout( 2 , 1 ) ) ;
    }

    private void addButton(){
        JPanel panelUp = new JPanel() ;
        panelUp.setLayout( new FlowLayout( FlowLayout.CENTER ,  0 , 0 ) ) ;
        JPanel panelDown = new JPanel() ;
        panelDown.setLayout( new BorderLayout( 0 , 0 ) ) ;

        Dimension buttonPreferredSize = new Dimension( UiConsts.TOOLBAR_BUTTON_WIDTH , UiConsts.TOOLBAR_BUTTON_HEIGHT ) ;

        buttonHome = new JButton() ;
        buttonHome.setPreferredSize( buttonPreferredSize ) ;
        buttonHome.setBorderPainted( false );
        buttonClasses = new JButton() ;
        buttonClasses.setPreferredSize( buttonPreferredSize ) ;
        buttonClasses.setBorderPainted( false );
        panelUp.add( buttonHome ) ;
        panelUp.add( buttonClasses ) ;

        buttonSettings = new JButton() ;
        buttonSettings.setPreferredSize( buttonPreferredSize ) ;
        buttonSettings.setBorderPainted( false ) ;

        panelDown.add( buttonSettings , BorderLayout.SOUTH ) ;
        this.add( panelUp ) ;
        this.add( panelDown ) ;
    }

    private void addListener(){
        buttonHome.addActionListener( e -> {
            App.mainPanelCenter.removeAll();
            App.homePanel.setContent() ;
            App.mainPanelCenter.add( App.homePanel , BorderLayout.CENTER );
            SwingUtilities.invokeLater(() -> App.mainPanelCenter.revalidate());
        } );
        buttonClasses.addActionListener( e -> {
            App.mainPanelCenter.removeAll();
            App.classesPanel.setContent() ;
            App.mainPanelCenter.add( App.classesPanel , BorderLayout.CENTER );
            SwingUtilities.invokeLater(() -> App.mainPanelCenter.revalidate());
        } );

        buttonSettings.addActionListener( e-> {
            App.mainPanelCenter.removeAll() ;
            App.mainPanelCenter.add( App.settingsPanel , BorderLayout.CENTER ) ;
            SwingUtilities.invokeLater(() -> App.mainPanelCenter.revalidate());
        });
    }

    
}
