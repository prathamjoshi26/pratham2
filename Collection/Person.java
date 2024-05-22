package Collection;

class Person {
    private String name;
    private int id;
    private String position;

    public Person(String name, int id, String position) {
        this.name = name;
        this.id = id;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ", Position: " + position + ")";
    }
}
