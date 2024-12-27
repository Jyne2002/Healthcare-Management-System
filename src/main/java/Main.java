

public class Main {

    public static void main(String[] args) {
        // Launch the Home JFrame when the program starts
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
}
