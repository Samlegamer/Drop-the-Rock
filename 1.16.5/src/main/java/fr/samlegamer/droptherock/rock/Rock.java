package fr.samlegamer.droptherock.rock;

public class Rock
{
    private final String rock;
    private final String loose_rock;
    private final String cobblestone;

    public Rock(String rock, String loose_rock, String cobblestone)
    {
        this.rock = rock;
        this.loose_rock = loose_rock;
        this.cobblestone = cobblestone;
    }

    public String getRock() {
        return rock;
    }

    public String getLooseRock() {
        return loose_rock;
    }

    public String getCobblestone() {
        return cobblestone;
    }
}
