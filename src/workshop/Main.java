package workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
	Game game = new Game();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (!game.isGameOver()){
            int pins;
            String line = null;
            try {
                line = br.readLine();
            } catch (IOException e) {
            }

            try {
                pins = Integer.parseInt(line);
                game.addRoll(pins);
            }
            catch(Throwable t){

            }

        }

        System.out.println(game.getTotalScore());
    }
}
