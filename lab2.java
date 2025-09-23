
public class lab2 {

    public static void main(String[] args) {

        int N = 0;

        // Check if arguments are provided
        if (args.length == 0) {
            N = 1000;
        } else {
            N = Integer.parseInt(args[0]);
        }

        // setup array of booleans
        boolean[] lights = new boolean[N + 1];

        // set lights[0] and lights[1] to false
        lights[0] = false;
        lights[1] = false;

        // set lights[2] to lights[N] to true
        for (int i = 2; i <= N; i++) {
            lights[i] = true;
        }

        // mark off values
        for (int i = 2; i <= Math.sqrt(N); i++) {
            for (int j = i * i; j <= N; j += i) {
                lights[j] = false;
            }
        }

        // display results
        for (int i = 2; i <= N; i++) {
            if (lights[i] == true) {
                System.out.print(i + " ");
            }
        }
    }
}
