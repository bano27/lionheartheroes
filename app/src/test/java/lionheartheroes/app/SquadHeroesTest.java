package lionheartheroes.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SquadHeroesTest {

    @Test public void testGetsNameOfNewHeroSquad(){
        SquadHeroes newSquad = SquadHeroes.newHeroSquad();
        assertEquals("Marvel",newSquad.getSquadName());
    }

    @Test public void testGetsMissionControlOfNewHeroSquad(){
        SquadHeroes newSquad = SquadHeroes.newHeroSquad();
        assertEquals("Protect Earth",newSquad.getMissionControl());
    }

    @Test public void testGetsSquadSizeOfNewHeroSquad(){
        SquadHeroes newSquad = SquadHeroes.newHeroSquad();
        assertEquals(22,newSquad.getSquadSize());
    }

    @Test public void testGetsSquadIdOfNewHeroSquad(){
        SquadHeroes newSquad = SquadHeroes.newHeroSquad();
        assertEquals(0,newSquad.getSquadId());
    }

    @Test public void testGetsAllInstancesOfNewHeroSquad(){
        SquadHeroes newSquad = SquadHeroes.newHeroSquad();
        assertTrue(SquadHeroes.getInstances().contains(newSquad));
    }

    @Test public void testGetsSquadByFindingIdOfNewHeroSquad(){
        SquadHeroes newSquad = SquadHeroes.newHeroSquad();
        assertEquals( 0, SquadHeroes.findBySquadId(newSquad.getSquadId()).getSquadId());
    }

    @Test public void testGetsSquadMembersOfNewHeroSquad(){
        MyHero newCharacterHero = MyHero.newHeroCharacter();
        SquadHeroes newSquad = SquadHeroes.newHeroSquad();
        newSquad.setSquadMembers(newCharacterHero);
        assertEquals("heat", newSquad.getSquadMembers().get(0).getFlaw());
    }
}