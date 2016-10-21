import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.actor.Flower;

/**
 *  This class runs a world that contains a Jumper.
 *
 *  @author  Eric Fu
 *  @version 10/20/16
 *  @author  Period: 3
 *  @author  Assignment: GridWorld_Part3_Jumper
 *
 *  @author  Sources: BugRunner used as template.
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
        world.add(new Rock());
        world.add(new Flower());
        world.add( new Actor() );
        world.add( new Actor() );
        world.add( new Location( 7, 8 ), bob );
        world.add( new Location( 5, 5 ), bob2 );
        world.show();
    }
}
