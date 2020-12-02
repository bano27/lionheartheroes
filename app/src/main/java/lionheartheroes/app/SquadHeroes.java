package lionheartheroes.app;

import java.util.ArrayList;

public class SquadHeroes {
    private String squadName;
    private String missionControl;
    private int squadSize;
    private int squadId;
    private ArrayList<MyHero> squadMembers = new ArrayList<>();
    private static ArrayList<SquadHeroes> instances = new ArrayList<>();

    public SquadHeroes(String squadName, String missionControl, Integer squadSize){
        this.squadName = squadName;
        this.missionControl = missionControl;
        this.squadSize = squadSize;
        this.squadId = instances.size();
        this.squadMembers = new ArrayList<>();
        instances.add(this);
    }

    public String getSquadName(){return this.squadName;}
    public String getMissionControl(){return this.missionControl;}
    public int getSquadSize(){return this.squadSize;}
    public int getSquadId(){return this.squadId;}
    public ArrayList<MyHero> getSquadMembers(){return squadMembers;}
    public static ArrayList<SquadHeroes> getInstances(){return instances;}
    public static SquadHeroes findBySquadId(int squadId){return instances.get(squadId);}
    public void setSquadMembers(MyHero newMember){squadMembers.add(newMember);}

    public static SquadHeroes newHeroSquad(){
        return new SquadHeroes("Marvel", "Protect Earth", 22);
    }

}

