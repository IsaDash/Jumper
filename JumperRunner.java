import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.actor.Flower;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author TODO Name(s)
 * @version TODO DATE
 * @author Period: TODO
 * @author Assignment: GridWorld_Part3_Jumper
 *
 * @author Sources: TODO
 */
public class JumperRunner
{
    public static void main( String[] args )
    {
        ActorWorld world = new ActorWorld();
        Jumper bob = new Jumper();
        bob.setColor( Color.BLUE );
        Jumper bob2 = new Jumper();
        bob2.setColor( Color.RED );
        world.add( new Rock() );
        world.add( new Flower() );
        world.add( new Actor() );
        world.add( new Actor() );
        world.add( new Bug() );
        world.add( new Location( 7, 8 ), bob );
        world.add( new Location( 5, 8 ), bob2 );
        world.show();

    }
}
