package test;

import dev.runnergame.bridge.Stone;
import dev.runnergame.entities.AccelerationPlatform;
import dev.runnergame.entities.PlatformAccelerationEffect;
import dev.runnergame.entities.Player;
import dev.runnergame.entities.Structure;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.*;

public class AccelerationPlatformTest {

    @Test
    public void shouldIncreasePlayerSpeed() throws IOException {
        float DEFAULT_SPEED = 3.0f;
        PlatformAccelerationEffect platformAccelerationEffect1 = new PlatformAccelerationEffect(50,50);
        Structure struct = new AccelerationPlatform(0,0,50 ,50, new Stone(),platformAccelerationEffect1);


        ServerSocket listener = new ServerSocket(49152);
        Socket socket = new Socket("127.0.0.1", 49152);
        listener.accept();
        Player player = new Player.PlayerBuilder().setController().setX(0).setY(0).setOutput(socket).build();

        platformAccelerationEffect1.changeState();
        platformAccelerationEffect1.notifyAllObservers();
        struct.onCollision(player);
        listener.close();
        Assert.assertEquals(DEFAULT_SPEED + 1, player.getSpeed(), 1.0f);
    }

    @Test
    public void onCollision() {

    }
}