import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.function.Function;

public class Function_File {
    GUI gui;
    String fileName;
    String fileAddress;
    public Function_File(GUI gui){
        this.gui = gui;
    }

    public void newFile() {

        gui.textArea.setText("");
        gui.window.setTitle("New");
    }

    public void open() {
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);

        if(fd.getFile()!= null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader());
        } catch(Exception e){

        }
    }
}
