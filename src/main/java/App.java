package main.java;

import javax.swing.* ;
import java.awt.* ;

import com.formdev.flatlaf.FlatDarculaLaf;
import main.java.ui.* ;

public class App {
    public static JFrame frame ;
    public static JPanel mainPanelCenter , mainToolPanel ;

    public static TestPanel testPanel ;
    public static ToolbarPanel toolbarPanel ;
    public static HomePanel homePanel ;
    public static ClassesPanel classesPanel ;
    public static SettingsPanel settingsPanel ;

    public static void main( String[] args ){
        EventQueue.invokeLater( ()->{
            try {
                App window = new App() ;
                window.frame.setVisible( true ) ;
            } catch ( Exception e ){
                e.printStackTrace() ;
            }
        } ) ;
    }

    App(){
        initialize() ;
        addComponent() ;
    }

    private void initialize(){
        try {
            UIManager.setLookAndFeel( new FlatDarculaLaf() ) ;

        } catch ( Exception e ){
            System.err.println( "set L&F failed" ) ;
            e.printStackTrace() ;
        }
        frame = new JFrame() ;
        frame.setBounds( UiConsts.MAIN_WINDOW_X,
                UiConsts.MAIN_WINDOW_Y,
                UiConsts.MAIN_WINDOW_WIDTH,
                UiConsts.MAIN_WINDOW_HEIGHT ) ;
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE ) ;
    }

    private void addComponent(){
        JPanel mainPanel = new JPanel( new BorderLayout() ) ;

        mainToolPanel = new JPanel( new BorderLayout() ) ;
        mainPanelCenter = new JPanel( new BorderLayout() ) ;
//
//        mainContentPanel = new JPanel( new BorderLayout() ) ;
//            contentPanelHeader = new JPanel( new BorderLayout() ) ;
//            JSeparator headerSep = new JSeparator( JSeparator.HORIZONTAL ) ;
//            headerSep.setPreferredSize( new Dimension( 500, 11 ) ) ;
//            contentPanelHeader.add( headerSep , BorderLayout.AFTER_LAST_LINE ) ;
//            mainContentPanel.add( contentPanelHeader , BorderLayout.NORTH ) ;
//
//            contentPanelCenter = new JPanel( new BorderLayout() ) ;
//            mainContentPanel.add( contentPanelCenter , BorderLayout.CENTER) ;

        mainPanel.add( mainToolPanel , BorderLayout.WEST ) ;
        mainPanel.add( mainPanelCenter , BorderLayout.CENTER ) ;

        toolbarPanel = new ToolbarPanel() ;
        testPanel = new TestPanel() ;
        homePanel = new HomePanel() ;
        classesPanel = new ClassesPanel() ;
        settingsPanel = new SettingsPanel() ;


        mainToolPanel.add( toolbarPanel , BorderLayout.CENTER ) ;
        mainPanelCenter.add( testPanel , BorderLayout.CENTER ) ;


        frame.add( mainPanel ) ;
        mainPanel.updateUI();

    }
}
