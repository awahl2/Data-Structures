
// it should output all the perfect squares

public class hallOfLights {

    public static void main(String[] args) {

        // Get N
        int N = 100;

        // Create array
        boolean data[] = new boolean[N + 1];

        // Set all to false
        for (int x = 1; x <= N; x++) {
            data[x] = false;
        }

        // Toggle Lights
        for (int a = 1; a <= N; a++) {
            for (int b = a; b <= N; b += a) {
                if (data[b] == true) {
                    data[b] = false;
                } else {
                    data[b] = true;
                }
            }
        }

        // Print Lights that are on
        for (int x = 1; x <= N; x++) {
            if (data[x] == true) {
                System.out.print(x + " ");
            }
        }

    }
}
