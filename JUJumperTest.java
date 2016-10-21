import info.gridworld.actor.*;
import info.gridworld.grid.*;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *  Jumper tests:.
 *  test01 - jumper next to edge of grid - should turn
 *  test02 - jumper 2 from edge of grid - should turn
 *  test03 - non-edible object 2 spaces in front - turn
 *  test04 - edible object 2 spaces in front - jump, object disappears
 *  test05 - spot 2 spaces in front is empty - move to it
 *  test06 - object 1 space ahead - jump over
 *  test07 - turns are 45 degrees
 *
 *  @author  Selena Huang
 *  @version oct 20, 2016
 *
 *  @author  Period: 3
 *  @author  Assignment - GridWorld Part 3 Jumper
 *
 *  @author  Sources: none
 */
public class JUJumperTest
{
    /*
     * Variables used by the test methods.
     */
    private Grid<Actor> grid;
    private ActorWorld world;
    private Jumper jumper1;
    private Jumper jumper2;
    private Rock rock;

    /**
     * Invoked before each test to instantiate the objects
     * used for every test.
     */
    @Before public void initialize()
    {
        grid = new BoundedGrid<Actor>(8, 8);
        world = new ActorWorld(grid);
        jumper1 = new Jumper();
        jumper2 = new Jumper();
        rock = new Rock();
    }

    /**
     * test01 - jumper next to edge of grid - should turn
     */
    @Test
    public void jumperNextToEdgeOfGridShouldTurn()
    {
        Location loc = new Location(0, 3);
        world.add(loc, jumper1);
        jumper1.act();

        assertTrue(testOccupied(loc, jumper1, Location.NORTHEAST));
    }

    /**
     * test02 - jumper 2 from edge of grid - should turn.
     */
    @Test
    public void jumper2FromEdgeOfGridShouldTurn()
    {
        Location loc = new Location(1, 3);
        world.add(loc, jumper1);
        jumper1.act();

        assertTrue(testOccupied(loc, jumper1, Location.NORTHEAST));
    }

    /**
     * test03 - non-edible object 2 spaces in front - turn
     */
    @Test
    public void nonEdibleObject2SpacesInFront()
    {
        Location loc = new Location(3, 3);
        Location loc2 = new Location(1, 3);
        world.add(loc, jumper1);
        world.add(loc2, rock);
        jumper1.act();

        assertTrue(testOccupied(loc, jumper1, Location.NORTHEAST));
    }

    /**
     * test04 - edible object 2 spaces in front - jump, object disappears
     */
    @Test
    public void edibleObject2SpacesInFront()
    {
        Location loc = new Location(3, 3);
        Location loc2 = new Location(1, 3);
        world.add(loc, jumper1);
        world.add(loc2, jumper2);
        jumper1.act();

        assertTrue(testOccupied(loc2, jumper1, Location.NORTH));
    }

    /**
     * test05 - spot 2 spaces in front is empty - move to it
     */
    @Test
    public void noObject2SpacesInFront()
    {
        Location loc = new Location(3, 3);
        Location loc2 = new Location(1, 3);
        world.add(loc, jumper1);
        jumper1.act();

        assertTrue(testOccupied(loc2, jumper1, Location.NORTH));
    }

    /**
     * test06 - object 1 space ahead - jump over
     */
    @Test
    public void object1SpaceInFront()
    {
        Location loc = new Location(3, 3);
        Location loc2 = new Location(2, 3);
        Location loc3 = new Location(1, 3);
        world.add(loc, jumper1);
        world.add(loc2, rock);
        jumper1.act();

        assertTrue(testOccupied(loc3, jumper1, Location.NORTH));
    }

    /**
     * test07 - turns are 45 degrees
     */
    @Test
    public void turns()
    {
        Location loc = new Location(3, 3);
        world.add(loc, jumper1);
        jumper1.turn();

        assertTrue(testOccupied(loc, jumper1, Location.NORTHEAST));
    }

    /**
     * Test helper method to test that object is in a location, and has
     * a consistent loc, and direction dir.
     *
     * @param loc location that should be occupied
     * @param a   actor that should be in location loc
     * @param dir direction this actor should be facing
     * @return true if all assertions pass
     */
    private boolean testOccupied(Location loc, Actor a, int dir)
    {
        Actor found = grid.get( loc );
        assertSame( "<<<<< " + loc + " should contain the actor. >>>>>",
            a, found );
        assertEquals( "<<<<< Loc should be " + loc + " >>>>>",
            loc, found.getLocation() );
        assertEquals( "<<<<< Dir should be " + dir + " >>>>>",
            dir, found.getDirection() );

        return true;
    }
}
