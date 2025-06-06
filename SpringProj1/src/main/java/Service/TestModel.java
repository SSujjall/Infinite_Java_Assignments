package Service;

public class TestModel {
    private int id;
    private String name;

    public TestModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Unlike C#/.NET, jata we dont need to override equals model when
    // comparing models in test case, java ma chai override garnu parxa
    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TestModel)) {
            return false;
        }

        final TestModel model = (TestModel) obj;
        return Integer.compare(id, model.id) == 0
                && name.equals(model.name);
    }
}
