
package innopolis.less.db;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ModelsCollectionTest {
    private static ModelsCollection<Model> collection;

    @Before
    public void setUp() throws Exception {
        collection = new ModelsCollection<>();
    }

    @After
    public void tearDown() throws Exception {
        collection.clear();
    }

    @Test
    public void create() throws Exception {
        long beforeCount = collection.count();
        collection.create(new Model());
        assertEquals(beforeCount + 1, collection.count());
    }

    @Test
    public void createOnce() throws Exception {
        long beforeCount = collection.count();
        Model testedModel = new Model();
        collection.create(testedModel);
        collection.create(testedModel);
        collection.create(testedModel);

        assertEquals(beforeCount + 1, collection.count());
    }

    @Test
    public void clear() throws Exception {
        collection.create(new Model());
        collection.clear();
        assertEquals(0, collection.count());
    }

    @Test
    public void read() throws Exception {
        Model testedModel = new Model();
        collection.create(testedModel);
        assertEquals(testedModel, collection.read(testedModel.getId()));
    }

    @Test
    public void notReadNoCollectionModel() throws Exception {
        Model testModel = new Model();
        assertNull(collection.read(testModel.getId()));
    }

    @Test
    public void find() throws Exception {
        class TestModel extends Model {
            private String name;
            private int number;
            private boolean checked;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public boolean isChecked() {
                return checked;
            }

            public void setChecked(boolean checked) {
                this.checked = checked;
            }
        }

        class TestCollection extends ModelsCollection<TestModel> {}

        TestCollection collection = new TestCollection();

        TestModel testModel1 = new TestModel();
        testModel1.setNumber(1);
        testModel1.setChecked(false);

        TestModel testModel2 = new TestModel();
        testModel2.setNumber(2);
        testModel2.setChecked(false);
        testModel2.setName("Ivan");

        collection.create(testModel1);
        collection.create(testModel2);

        List<TestModel> models = collection.find(new SearchModel() {
            String name = "Ivan";
        });

        assertEquals(models.size(), 1);
        assertEquals(models.get(0), testModel2);

        models = collection.find(new SearchModel() {
            boolean checked = false;
        });

        assertEquals(models.size(), 2);
        assertEquals(models.get(0), testModel1);
        assertEquals(models.get(1), testModel2);

        models = collection.find(new SearchModel() {
            int number = 3;
        });

        assertEquals(models.size(), 0);

        models = collection.find(new SearchModel() {
            boolean test = true;
        });

        assertEquals(models.size(), 0);
    }

    @Test
    public void update() throws Exception {
        class TestModel extends Model {
            private int number;

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }
        }

        TestModel testModel = new TestModel();
        testModel.setNumber(1);

        collection.add(testModel);

        testModel.setNumber(2);
        collection.update(testModel);

        assertEquals(
            ((TestModel) collection.read(testModel.getId())).getNumber(),
            2
        );

        assertEquals(collection.count(), 1);
    }

    @Test
    public void delete() throws Exception {
        Model testedModel = new Model();
        collection.create(testedModel);
        collection.delete(testedModel);
        assertNull(collection.read(testedModel.getId()));
    }

    @Test
    public void count() throws Exception {

    }
}