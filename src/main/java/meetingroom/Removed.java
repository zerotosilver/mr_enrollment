package meetingroom;

public class Removed extends AbstractEvent {

    private Long id;

    public Removed(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
