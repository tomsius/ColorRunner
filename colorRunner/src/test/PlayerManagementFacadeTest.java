package test;

import dev.runnergame.SingletonController;
import dev.runnergame.entities.Player;
import dev.runnergame.facade.PlayerManagementFacade;
import dev.runnergame.strategy.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.*;

public class PlayerManagementFacadeTest {

    @Test
    public void checkFlyingPlayer() throws IOException {
        ServerSocket listener = new ServerSocket(49152);
        Socket socket = new Socket("127.0.0.1", 49152);
        listener.accept();
        Player player = new Player.PlayerBuilder().setController().setX(0).setY(0).setOutput(socket).build();
        IMoveStrategy fly = new Fly();

        SingletonController controller = SingletonController.getInstance("ColorRunner", 640, 360);
        PlayerManagementFacade facade = new PlayerManagementFacade(controller, socket);

        player = facade.flyingPlayer();

        listener.close();
        Assert.assertEquals(player.getMovementStrategy().getClass(), fly.getClass());
    }

    @Test
    public void checkRunningPlayer() throws IOException {
        ServerSocket listener = new ServerSocket(49152);
        Socket socket = new Socket("127.0.0.1", 49152);
        listener.accept();
        Player player = new Player.PlayerBuilder().setController().setX(0).setY(0).setOutput(socket).build();
        IMoveStrategy run = new Run();

        SingletonController controller = SingletonController.getInstance("ColorRunner", 640, 360);
        PlayerManagementFacade facade = new PlayerManagementFacade(controller, socket);

        player = facade.runningPlayer();

        listener.close();
        Assert.assertEquals(player.getMovementStrategy().getClass(), run.getClass());
    }

    @Test
    public void checkStunnedPlayer() throws IOException {
        ServerSocket listener = new ServerSocket(49152);
        Socket socket = new Socket("127.0.0.1", 49152);
        listener.accept();
        Player player = new Player.PlayerBuilder().setController().setX(0).setY(0).setOutput(socket).build();
        IMoveStrategy stunned = new Stunned();

        SingletonController controller = SingletonController.getInstance("ColorRunner", 640, 360);
        PlayerManagementFacade facade = new PlayerManagementFacade(controller, socket);

        player = facade.stunnedPlayer();

        listener.close();
        Assert.assertEquals(player.getMovementStrategy().getClass(), stunned.getClass());
    }

    @Test
    public void checkSlidingPlayer() throws IOException {
        ServerSocket listener = new ServerSocket(49152);
        Socket socket = new Socket("127.0.0.1", 49152);
        listener.accept();
        Player player = new Player.PlayerBuilder().setController().setX(0).setY(0).setOutput(socket).build();
        IMoveStrategy slide = new Slide();

        SingletonController controller = SingletonController.getInstance("ColorRunner", 640, 360);
        PlayerManagementFacade facade = new PlayerManagementFacade(controller, socket);

        player = facade.slidingPlayer();

        listener.close();
        Assert.assertEquals(player.getMovementStrategy().getClass(), slide.getClass());
    }
}