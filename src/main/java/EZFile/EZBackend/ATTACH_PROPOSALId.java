package EZFile.EZBackend;

import java.io.Serializable;

public class ATTACH_PROPOSALId implements Serializable {
    private int PROPOSAL_ID;
    private int ATTACHMENT_ID;

    public ATTACH_PROPOSALId() {
    }

    public ATTACH_PROPOSALId(int PROPOSAL_ID, int ATTACHMENT_ID) {
        this.PROPOSAL_ID = PROPOSAL_ID;
        this.ATTACHMENT_ID = ATTACHMENT_ID;
    }

    public int getPROPOSAL_ID() {
        return PROPOSAL_ID;
    }

    public void setPROPOSAL_ID(int PROPOSAL_ID) {
        this.PROPOSAL_ID = PROPOSAL_ID;
    }

    public int getATTACHMENT_ID() {
        return ATTACHMENT_ID;
    }

    public void setATTACHMENT_ID(int ATTACHMENT_ID) {
        this.ATTACHMENT_ID = ATTACHMENT_ID;
    }

}
