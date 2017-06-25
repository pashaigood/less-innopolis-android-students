package innopolis.less.registration.models;


import innopolis.less.db.Model;

public class Journal extends Model {
    public static boolean PRESENTED = true;
    public static boolean NOT_PRESENTED = false;

    private Long lessonId;
    private Long studentId;
    private boolean present;

    public Journal(Long lessonId, Long studentId) {
        this.lessonId = lessonId;
        this.studentId = studentId;
    }

    public boolean isPresent() {
        return present == PRESENTED;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}
