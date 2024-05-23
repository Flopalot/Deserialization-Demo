import java.io.Serializable;

public class MaliciousPayload implements Exploitable, Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public void execute() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Windows
                Runtime.getRuntime().exec("calc");
            } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
                // Unix/Linux/MacOS
                Runtime.getRuntime().exec("gnome-calculator"); // for GNOME desktop
                // Alternatively, use "xcalc" for a more generic calculator
                // Runtime.getRuntime().exec("xcalc");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "MaliciousPayload{}";
    }
}