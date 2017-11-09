import java.awt.*;

public class InputHandler {

    public InputHandler() {

    }


    public static final int id_UP = 1004;
    public static final int id_DOWN = 1005;
    public static final int id_LEFT = 1006;
    public static final int id_RIGHT = 1007;
    public static final int id_SPACE = 32;
    public static final int id_ESC = 27;


    public static final int id_A = 65;
    public static final int id_B = 66;
    public static final int id_C = 67;
    public static final int id_D = 68;
    public static final int id_E = 69;
    public static final int id_F = 70;
    public static final int id_G = 71;
    public static final int id_H = 72;
    public static final int id_I = 73;
    public static final int id_J = 74;
    public static final int id_K = 75;
    public static final int id_L = 76;
    public static final int id_M = 77;
    public static final int id_N = 78;
    public static final int id_O = 79;
    public static final int id_P = 80;
    public static final int id_Q = 81;
    public static final int id_R = 82;
    public static final int id_S = 83;
    public static final int id_T = 84;
    public static final int id_U = 85;
    public static final int id_V = 86;
    public static final int id_W = 87;
    public static final int id_X = 88;
    public static final int id_Y = 89;
    public static final int id_Z = 90;


    //boolean values determine if key is pressed
    public static boolean UP = false;
    public static boolean DOWN = false;
    public static boolean LEFT = false;
    public static boolean RIGHT = false;

    public static boolean SPACE = false;
    public static boolean X = false;

    public static boolean W = false;
    public static boolean A = false;
    public static boolean S = false;
    public static boolean D = false;

    public static boolean I = false;
    public static boolean J = false;
    public static boolean K = false;
    public static boolean L = false;

    public static boolean P = false;
    public static boolean ESC = false;

    public static boolean B = false;
    public static boolean C = false;
    public static boolean E = false;
    public static boolean F = false;
    public static boolean G = false;
    public static boolean H = false;
    public static boolean M = false;
    public static boolean N = false;
    public static boolean O = false;
    public static boolean Q = false;
    public static boolean R = false;
    public static boolean T = false;
    public static boolean U = false;
    public static boolean V = false;
    public static boolean Y = false;
    public static boolean Z = false;


    //mouse info
    public static boolean MOUSE_LEFT = false;
    public static boolean MOUSE_RIGHT = false;

    public static int MOUSE_X = 0;
    public static int MOUSE_Y = 0;

    public static boolean onKeyChange(Event e, int key, boolean newKeyState) {
        switch (key) {
            case id_UP:
                InputHandler.UP = newKeyState;
                break;
            case InputHandler.id_DOWN:
                InputHandler.DOWN = newKeyState;
                break;
            case InputHandler.id_LEFT:
                InputHandler.LEFT = newKeyState;
                break;
            case InputHandler.id_RIGHT:
                InputHandler.RIGHT = newKeyState;
                break;

            case InputHandler.id_SPACE:
                InputHandler.SPACE = newKeyState;
                break;
            case InputHandler.id_X:
                InputHandler.X = newKeyState;
                break;

            case InputHandler.id_W:
                InputHandler.W = newKeyState;
                break;
            case InputHandler.id_S:
                InputHandler.S = newKeyState;
                break;
            case InputHandler.id_A:
                InputHandler.A = newKeyState;
                break;
            case InputHandler.id_D:
                InputHandler.D = newKeyState;
                break;

            case InputHandler.id_I:
                InputHandler.I = newKeyState;
                break;
            case InputHandler.id_J:
                InputHandler.J = newKeyState;
                break;
            case InputHandler.id_K:
                InputHandler.K = newKeyState;
                break;
            case InputHandler.id_L:
                InputHandler.L = newKeyState;
                break;

            case InputHandler.id_P:
                InputHandler.P = newKeyState;
                break;
            case InputHandler.id_ESC:
                InputHandler.ESC = newKeyState;
                break;

            case InputHandler.id_B:
                InputHandler.B = newKeyState;
                break;

            case InputHandler.id_C:
                InputHandler.C = newKeyState;
                break;

            case InputHandler.id_E:
                InputHandler.E = newKeyState;
                break;

            case InputHandler.id_F:
                InputHandler.F = newKeyState;
                break;

            case InputHandler.id_G:
                InputHandler.G = newKeyState;
                break;

            case InputHandler.id_H:
                InputHandler.H = newKeyState;
                break;

            case InputHandler.id_M:
                InputHandler.M = newKeyState;
                break;

            case InputHandler.id_N:
                InputHandler.N = newKeyState;
                break;

            case InputHandler.id_O:
                InputHandler.O = newKeyState;
                break;

            case InputHandler.id_Q:
                InputHandler.Q = newKeyState;
                break;

            case InputHandler.id_R:
                InputHandler.R = newKeyState;
                break;

            case InputHandler.id_T:
                InputHandler.T = newKeyState;
                break;

            case InputHandler.id_U:
                InputHandler.U = newKeyState;
                break;

            case InputHandler.id_V:
                InputHandler.V = newKeyState;
                break;

            case InputHandler.id_Y:
                InputHandler.Y = newKeyState;
                break;

            case InputHandler.id_Z:
                InputHandler.Z = newKeyState;
                break;

            default:
                System.out.print(key);    //print any unbound key presses- may spam console
                if (newKeyState)
                    System.out.println(" down");
                else
                    System.out.println(" up");
                break;
        }
        return true;
    }
}