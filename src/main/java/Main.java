import zero.GameApp;
import zero.Key;
import zero.Color;

public class Main extends GameApp 
{
    double ballX = 380;
    double ballY = 300;

    double ballSpeed = 0;
    double gravity = 900;
    double jumpSpeed = -420;

    int score = 0;

    boolean gameOver = false;
    boolean spaceWasDown = false;

    public void settings() {
        size(800, 500);
        title("Don't Drop the Ball");
    }

    public void setup() {
    }

    public void update(double seconds) {

        if (keyDown(Key.R)) {
            restartGame();
        }

        if (gameOver == false) {

            boolean spaceDown = keyDown(Key.SPACE);

            if (spaceDown && !spaceWasDown && ballY >= 300) {
                ballSpeed = jumpSpeed;
                score++;
            }

            spaceWasDown = spaceDown;

            ballSpeed = ballSpeed + gravity * seconds;
            ballY = ballY + ballSpeed * seconds;

            if (ballY > 500) {
                gameOver = true;
            }
        }
    }

    public void draw() {

        background(Color.BLACK);

        fill(Color.BLUE);
        rect(0, 450, 800, 50);

        fill(Color.GOLD);
        rect(ballX, ballY, 40, 40);

        fill(Color.WHITE);
        textSize(25);
        text("Score: " + score, 20, 35);

        if (gameOver) {
            textSize(40);
            text("Game Over!", 290, 220);

            textSize(25);
            text("Press R to restart", 295, 270);
        } else {
            textSize(20);
            text("Press space to jump!", 300, 80);
        }
    }

    public void restartGame() {
        ballY = 300;
        ballSpeed = 0;
        score = 0;
        gameOver = false;
        spaceWasDown = false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}