package EZFile.EZBackend;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "ATTACH_TYPE")
public class ATTACH_TYPE {
    @Id
    @Column
    private String ATTACHMENT_TYPE;

    @Column
    private String DESCRIPTION;

    @Column
    private String APPLICATION_CATEGORY_TYPE;

    // Relations
    @OneToMany(mappedBy = "attach_type")
    @JsonIgnore
    private List<ATTACH_PROPOSAL> attach_proposal;

    // Getters

    public String getATTACHMENT_TYPE() {
        return ATTACHMENT_TYPE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }   

    public String getAPPLICATION_CATEGORY_TYPE() {
        return APPLICATION_CATEGORY_TYPE;
    }

    public List<ATTACH_PROPOSAL> getATTACH_PROPOSAL() {
        return attach_proposal;
    }

    // Setters

    public void setATTACHMENT_TYPE(String ATTACHMENT_TYPE) {
        this.ATTACHMENT_TYPE = ATTACHMENT_TYPE;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public void setAPPLICATION_CATEGORY_TYPE(String ATTACHMENT_CATEGORY_TYPE) {
        this.APPLICATION_CATEGORY_TYPE = ATTACHMENT_CATEGORY_TYPE;
    }

    public void setATTACH_PROPOSAL(List<ATTACH_PROPOSAL> attach_proposal) {
        this.attach_proposal = attach_proposal;
    }


}
