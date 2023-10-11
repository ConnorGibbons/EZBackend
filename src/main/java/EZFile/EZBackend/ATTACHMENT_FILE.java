package EZFile.EZBackend;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "ATTACHMENT_FILE")
public class ATTACHMENT_FILE {

    @Id
    @Column
    private Integer ATTACHMENT_ID;

    @Column
    private String DESCRIPTION;

    @Column
    private String FILE_NAME;

    @Column
    private String FILE_PATH;

    @Column
    private Date CREATE_DATE;

    // Relations
    @OneToMany(mappedBy = "attachment_file")
    @JsonIgnore
    private List<ATTACH_PROPOSAL> attach_proposal;

    // Getters 

    public Integer getATTACHMENT_ID() {
        return ATTACHMENT_ID;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public String getFILE_NAME() {
        return FILE_NAME;
    }

    public String getFILE_PATH() {
        return FILE_PATH;
    }

    public Date getCREATE_DATE() {
        return CREATE_DATE;
    }

    public List<ATTACH_PROPOSAL> getATTACH_PROPOSAL() {
        return attach_proposal;
    }

    // Setters 

    public void setATTACHMENT_ID(Integer ATTACHMENT_ID) {
        this.ATTACHMENT_ID = ATTACHMENT_ID;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public void setFILE_NAME(String FILE_NAME) {
        this.FILE_NAME = FILE_NAME;
    }

    public void setFILE_PATH(String FILE_PATH) {
        this.FILE_PATH = FILE_PATH;
    }

    public void setCREATE_DATE(Date CREATE_DATE) {
        this.CREATE_DATE = CREATE_DATE;
    }

    public void setATTACH_PROPOSAL(List<ATTACH_PROPOSAL> attach_proposal) {
        this.attach_proposal = attach_proposal;
    }

}
