import java.util.Date;

public class Record {
	private String desc;
	private Date date;

	public Record() {

	}

	public Record(String desc) {
		this.desc = desc;
		date = new Date();
	}

	public String getDesc() {
		return desc;
	}

	public Date getDate() {
		return date;
	}

}
