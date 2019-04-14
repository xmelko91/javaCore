package travel.common.buisness.dto;

import java.io.Serializable;

public abstract class BaseDto<ID> implements Serializable {
    protected ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
