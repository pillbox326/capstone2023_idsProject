package dachaja.idsProject.domain.makePDF;

import jakarta.validation.constraints.NotEmpty;
import jdk.jfr.Enabled;
import lombok.Data;

import javax.persistence.*;


//model
//@Data
@Entity
@Table(name = "idsInfo_01")
public class IdsInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Source IP")
    private String SrcIP;
    @Column(name = "Destination IP")
    private String DstIP;
    @Column(name = "Source Port")
    private int SrcPort;
    @Column(name = "Destination Port")
    private int DstPort;
    @Column(name = "Protocol")
    private int Protocol;

    @Column(name = "Time Stamp")
    private String TimeStamp;
    @Column(name = "Flow Duration")
    private String FlowDuration;

    @Column(name = "Label(Detection Result)")
    private String Label; //benign or not

    public IdsInfo(){
        super();
    }

    public IdsInfo(String SrcIP, String DstIP, int SrcPort, int DstPort, int Protocol, String TimeStamp, String FlowDuration, String Label){
        super();
        this.SrcIP = SrcIP;
        this.DstIP = DstIP;
        this.SrcPort =SrcPort;
        this.DstPort = DstPort;
        this.Protocol = Protocol;
        this.FlowDuration = FlowDuration;
        this.TimeStamp = TimeStamp;
        this.Label = Label;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSrcIP() {
        return SrcIP;
    }

    public void setSrcIP(String srcIP) {
        SrcIP = srcIP;
    }

    public String getDstIP() {
        return DstIP;
    }

    public void setDstIP(String dstIP) {
        DstIP = dstIP;
    }

    public int getSrcPort() {
        return SrcPort;
    }

    public void setSrcPort(int srcPort) {
        SrcPort = srcPort;
    }

    public int getDstPort() {
        return DstPort;
    }

    public void setDstPort(int dstPort) {
        DstPort = dstPort;
    }

    public int getProtocol() {
        return Protocol;
    }

    public void setProtocol(int protocol) {
        Protocol = protocol;
    }

    public String getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        TimeStamp = timeStamp;
    }

    public String getFlowDuration() {
        return FlowDuration;
    }

    public void setFlowDuration(String flowDuration) {
        FlowDuration = flowDuration;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }
}
