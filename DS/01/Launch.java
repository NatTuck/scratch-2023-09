
import world.*;
import image.*;

public class Launch {
    public static void main(String args[]) {
        var y0 = 0;
        var world0 = new LaunchWorld(y0);
        world0.bigBang();
    }
}

class LaunchWorld extends World {
    double yy;

    LaunchWorld(double y0) {
        this.yy = y0;
    }

    @Override
    public Scene onDraw() {
        var bg = new EmptyScene(800, 800);
        var balloon = new FromFile("./balloon.png");
        return bg.
            placeImage(balloon, 400, 800 - yy);
    }

    @Override
    public LaunchWorld onTick() {
        return new LaunchWorld(this.yy + 2);
    }
}
