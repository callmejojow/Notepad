import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    JFrame window;

    //Text Area Component
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;

    //Navigation
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;

    //File Menu
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
    JMenu menuFont, menuFontSize;

    //Format Menu
    JMenuItem iWrap, iFontArial, iFontComicSans, iFontTimesNewRoman, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24;
    Function_File file = new Function_File(this);

    Function_Format format = new Function_Format(this);

    //Color Menu
    JMenuItem iColor1, iColor2, iColor3;

    Function_Color color = new Function_Color(this);

    public static void main(String[] args){
        new GUI();
    }
    public GUI() {

        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();
        createColorMenu();

        format.selectedFont  = "Arial";
        format.createFont(16);
        format.wordWrap();
        color.changeColor("Beige");

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
        menuFont.add(iFontArial);

        iFontComicSans = new JMenuItem("Comic Sans MS");
        iFontComicSans.addActionListener(this);
        iFontComicSans.setActionCommand("Comic Sans MS");
        menuFont.add(iFontComicSans);

        iFontTimesNewRoman = new JMenuItem("Times New Roman");
        iFontTimesNewRoman.addActionListener(this);
        iFontTimesNewRoman.setActionCommand("Times New Roman");
        menuFont.add(iFontTimesNewRoman);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("size8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("size12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("size16");
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("size20");
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("size24");
        menuFontSize.add(iFontSize24);
    }

    public void createColorMenu() {
        iColor1 = new JMenuItem("Beige");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("Beige");
        menuColor.add(iColor1);

        iColor2 = new JMenuItem("Dark");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Dark");
        menuColor.add(iColor2);

        iColor3 = new JMenuItem("Cyber");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Cyber");
        menuColor.add(iColor3);
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
            case "Word Wrap": format.wordWrap(); break;
            case "Arial": format.setFont(command);break;
            case "Comic Sans MS": format.setFont(command);break;
            case "Times New Roman": format.setFont(command);break;
            case "size8": format.createFont(8); break;
            case "size12": format.createFont(12); break;
            case "size16": format.createFont(16); break;
            case "size20": format.createFont(20); break;
            case "size24": format.createFont(24); break;
            case "Beige": color.changeColor(command);break;
            case "Dark": color.changeColor(command);break;
            case "Cyber": color.changeColor(command);break;
        }
    }
}
