package za.ac.cput.domain.domain.value_objects;

public final class Position {
    private final String positionId;
    private final String posName;

    public Position(String positionId,String posName){
        this.positionId = positionId;
        this.posName = posName;
    }

    public String getPositionId() {
        return positionId;
    }

    public String getPosName() {
        return posName;
    }

}
