import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;



/**
 *   A <code>Jumper</code> is an actor that will jump over Rocks and Flowers and
 * turn.
 *
 *  @author  Isa Dash
 *  @version Oct 20, 2016
 *  @author  Period: 3
 *  @author  Assignment: GridWorldPart3Jumper
 *
 *  @author  Sources: Bug class used as template
 */
public class Jumper extends Actor implements Edible
{
    /**
     * Constructs a pink Jumper.
     */
    public Jumper()
    {
        setColor( Color.PINK );
    }


    /**
     * Constructs a Jumper of a given color.
     * 
     * @param JumperColor
     *            the color for this Jumper
     */
    public Jumper( Color JumperColor )
    {
        setColor( JumperColor );
    }


    /**
     * act method for the jumper that determined if jumper can or cannot jump
     */
    public void act()
    {
        if ( canJump() )
            jump();
        else
            turn();
    }


    /**
     * Turns the Jumper 45 degrees to the right without changing its location.
     */
    public void turn()
    {
        setDirection( getDirection() + Location.HALF_RIGHT );
    }


    /**
     * Moves the Jumper forward two locations. If location is not
     * valid, the Jumper removes itself from the grid.
     */
    public void jump()
    {
        Grid<Actor> gr = getGrid();
        if ( gr == null )
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation( getDirection() );
        Location twoAway = next.getAdjacentLocation( getDirection() );
        if ( gr.isValid( twoAway ) )
            moveTo( twoAway );
        else
            removeSelfFromGrid();
    }


    /**
     * Tests if this Jumper can move forward into a location two steps ahead
     * that is empty or contains a flower. The location one in front must be
     * empty or contain a Rock or a Flower.
     * 
     * @return true or false to indicate whether it can move
     */
    public boolean canJump()
    {
        Grid<Actor> gr = getGrid();
        if ( gr == null )
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation( getDirection() );
        if ( !gr.isValid( next ) )
            return false;
        Actor object = gr.get( next );
        if ( !( ( object == null ) || ( object instanceof Flower )
            || ( object instanceof Rock ) ) )
            return false;
        Location twoAway = next.getAdjacentLocation( getDirection() );
        if ( !gr.isValid( twoAway ) )
            return false;

        object = gr.get( twoAway );
        return ( object == null ) || ( object instanceof Flower );
    }
}
