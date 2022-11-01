package application.net;

public class NetAddress {
	String address;
	Integer mask;
	
	public NetAddress() {}
	
	public NetAddress(String address, Integer mask) {
		this.address = address;
		this.mask = mask;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getMask() {
		return mask;
	}
	public void setMask(Integer mask) {
		this.mask = mask;
	}
	
	@Override
	public String toString() {
		return address + "/" + mask;
	}
}
