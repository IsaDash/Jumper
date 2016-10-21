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
 * @author Eric Fu
 * @version 10/20/16
 * @author Period: 3
 * @author Assignment: GridWorld_Part3_Jumper
 *
 * @author Sources: BugRunner
 */
public class JumperRunner
{
    public static void main( String[] args )
    {
        ActorWorld world = new ActorWorld();
        world.add(new Jumper());
        world.add(new Rock());
        world.add(new Bug());
        world.add(new Flower());
        world.show(); 
        

    }
}
