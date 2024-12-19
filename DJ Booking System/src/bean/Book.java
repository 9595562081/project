package bean;

public class Book {
	private String Name;
	private String Email;
	private String phone;
	private String eventDate;
	private String eStart;
	private String eEnd;
	private String additionalInfo;
	private String venue;
	private String event;
	private int cost;
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String geteStart() {
		return eStart;
	}
	public void seteStart(String eStart) {
		this.eStart = eStart;
	}
	public String geteEnd() {
		return eEnd;
	}
	public void seteEnd(String eEnd) {
		this.eEnd = eEnd;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
}
