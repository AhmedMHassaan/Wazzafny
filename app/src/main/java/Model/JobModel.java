package Model;

import com.google.gson.annotations.SerializedName;

public class JobModel {
    @SerializedName("JOB_NAME")
    private String name ;

    @SerializedName("JOB_DESCRIPTION")
    private String description ;

    @SerializedName("DEPARTEMENT_ID")
    private String depId ;

    @SerializedName("ADDING_DATE")
    private String addingDate ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getAddingDate() {
        return addingDate;
    }

    public void setAddingDate(String addingDate) {
        this.addingDate = addingDate;
    }
}
