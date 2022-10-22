import java.awt.Color;
public class Function_Color {

    GUI gui;

    public Function_Color(GUI gui) {
        this.gui = gui;
    }

    public void changeColor(String color) {

        switch (color) {
            case "Beige":
                gui.window.getContentPane().setBackground(new Color(245, 235, 224));
                gui.textArea.setBackground(new Color(245, 235, 224));
                gui.textArea.setForeground(new Color(64, 61, 57));
                break;
            case "Dark":
                gui.window.getContentPane().setBackground(new Color(27, 42, 65));
                gui.textArea.setBackground(new Color(27, 42, 65));
                gui.textArea.setForeground(new Color(239, 241, 243));
                break;
            case "Cyber":
                gui.window.getContentPane().setBackground(new Color(58, 12, 163));
                gui.textArea.setBackground(new Color(58, 12, 163));
                gui.textArea.setForeground(new Color(251, 255, 18));
                break;
        }
    }
}
