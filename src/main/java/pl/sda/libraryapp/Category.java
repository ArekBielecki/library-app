package pl.sda.libraryapp;

public class Category {
    private int id;

    private String name;

    private int displayPriority;

    public Category(int id, String name, int displayPriority) {
        this.id = id;
        this.name = name;
        this.displayPriority = displayPriority;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDisplayPriority() {
        return displayPriority;
    }


    @Override
    public String toString() {
        return "Category id: " + getId() + ", Category name: " + getName()
                + ", Display priority: " + getDisplayPriority();
    }
}
