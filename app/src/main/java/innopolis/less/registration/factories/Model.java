package innopolis.less.registration.factories;

import innopolis.less.registration.utils.Generator;

public class Model {
    private final Long id = Generator.generateId();

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Model)) return false;

        Model model = (Model) object;

        return id != null ? id.equals(model.id) : model.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
