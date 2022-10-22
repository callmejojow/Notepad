import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    JFrame window;

    //Text Area Component
    JTextArea textArea;
    JScrollPane scrollPane;

    //Navigation
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;

    //File Menu
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
    JMenu menuFont, menuFontSize;

    //Format Menu
    JMenuItem iWrap, iFontArial, iFontComicSans, iFontHelvetica, iFontTimesNewRoman, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24;
    Function_File file = new Function_File(this);

    Function_Format format = new Function_Format(this);

    public static void main(String[] args){
        new GUI();
    }
    public GUI() {

        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();

        window.setVisible(true);
    }
    public void createWindow() {
        window = new JFrame("Notepad");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void createTextArea(){

        textArea = new JTextArea();
        scrollPane  = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);

    }

    public void createFileMenu(){
        iNew= new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iOpen= new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iSave= new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs= new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save As");
        menuFile.add(iSaveAs);

        iExit= new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }

    public void createFormatMenu() {
        iWrap = new JMenuItem("Word Wrap: Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFormat.add(iFontArial);

        iFontComicSans = new JMenuItem("Comic Sans");
        iFontComicSans.addActionListener(this);
        iFontComicSans.setActionCommand("Comic Sans");
        menuFormat.add(iFontComicSans);

        iFontHelvetica = new JMenuItem("Helvetica");
        iFontHelvetica.addActionListener(this);
        iFontHelvetica.setActionCommand("Helvetica");
        menuFormat.add(iFontHelvetica);

        iFontTimesNewRoman = new JMenuItem("Times New Roman");
        iFontTimesNewRoman.addActionListener(this);
        iFontTimesNewRoman.setActionCommand("Times New Roman");
        menuFormat.add(iFontHelvetica);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("size8");
        menuFormat.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("size12");
        menuFormat.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("size16");
        menuFormat.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("size20");
        menuFormat.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("size24");
        menuFormat.add(iFontSize24);
    }


    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();

        switch(command){
            case "New": file.newFile(); break;
            case "Open": file.open(); break;
            case "Save": file.save(); break;
            case "Save As": file.saveAs(); break;
            case "Exit": file.exit(); break;
        }
    }
}
