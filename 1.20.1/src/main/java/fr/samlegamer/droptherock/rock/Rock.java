package fr.samlegamer.droptherock.rock;

public record Rock(String rock, String loose_rock, String cobblestone) {

    public String getLooseRock() {
        return loose_rock;
    }
}
