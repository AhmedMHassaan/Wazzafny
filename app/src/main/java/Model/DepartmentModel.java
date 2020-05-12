package Model;

import com.google.gson.annotations.SerializedName;

public class DepartmentModel {


    @SerializedName("CREATION_DATE")
    private String dateOfAdding;

    @SerializedName("NAME")
    private String name;





    public String getDateOfAdding() {
        return dateOfAdding;
    }

    public void setDateOfAdding(String dateOfAdding) {
        this.dateOfAdding = dateOfAdding;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
