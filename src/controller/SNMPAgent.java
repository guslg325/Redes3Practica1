package controller;

public class SNMPAgent {
    private String community,version,address,port;

    public SNMPAgent(){
    }
    
    public SNMPAgent(String community, String version, String address, String port) {
        this.community = community;
        this.version = version;
        this.address = address;
        this.port = port;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
    
}
