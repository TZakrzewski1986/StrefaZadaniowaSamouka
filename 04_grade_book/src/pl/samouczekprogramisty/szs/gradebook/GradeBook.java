package pl.samouczekprogramisty.szs.gradebook;


import java.util.HashMap;
import java.util.Map;

public class GradeBook {
    private Map<String, Subject> subjects = new HashMap<>();

    public void addSubject(String subject) {
        if (subjects.containsKey(subject)) {
            throw new IllegalStateException(String.format("Przedmiot  %s juz istnieje!", subject));
        }
        subjects.put(subject, new Subject(subject));
    }

    public Subject getSubject(String subject) {
        if (subjects.containsKey(subject)) {
            return subjects.get(subject);
        }
        throw new IllegalArgumentException(String.format("Przedmiot %s nie istnieje!", subject));
    }

    public void addNote(String subject, double note) {
        if (!subjects.containsKey(subject)) {
            throw new IllegalArgumentException(String.format("Przedmiot %s nie istnieje!", subject));
        }
        subjects.get(subject).addNote(note);
    }
}
